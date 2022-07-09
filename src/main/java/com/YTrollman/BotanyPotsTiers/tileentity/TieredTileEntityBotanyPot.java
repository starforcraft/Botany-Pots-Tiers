package com.YTrollman.BotanyPotsTiers.tileentity;

import com.YTrollman.BotanyPotsTiers.BotanyPotsTiers;
import com.YTrollman.BotanyPotsTiers.blocks.TieredBlockBotanyPot;
import com.YTrollman.BotanyPotsTiers.config.BotanyPotsTiersConfig;
import com.YTrollman.BotanyPotsTiers.events.TieredBotanyPotHarvestedEvent;
import com.YTrollman.BotanyPotsTiers.events.TieredBotanyPotHarvestedEvent.LootGenerated;
import com.YTrollman.BotanyPotsTiers.events.TieredBotanyPotTickEvent;
import com.YTrollman.BotanyPotsTiers.events.TieredBotanyPotTickEvent.Pre;
import com.YTrollman.BotanyPotsTiers.events.TieredPotGrowCropEvent;
import com.YTrollman.BotanyPotsTiers.events.TieredPotGrowCropEvent.Post;
import net.darkhax.bookshelf.block.tileentity.TileEntityBasicTickable;
import net.darkhax.bookshelf.util.InventoryUtils;
import net.darkhax.botanypots.BotanyPotHelper;
import net.darkhax.botanypots.BotanyPots;
import net.darkhax.botanypots.crop.CropInfo;
import net.darkhax.botanypots.network.BreakEffectsMessage;
import net.darkhax.botanypots.soil.SoilInfo;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunk;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.EmptyHandler;

import javax.annotation.Nullable;
import java.util.Iterator;
import java.util.List;

public class TieredTileEntityBotanyPot extends TileEntityBasicTickable {
    private static ItemStackHandler DUMMY_INV = new ItemStackHandler(0);
    @Nullable
    private SoilInfo soil;
    private ItemStack soilStack = ItemStack.EMPTY;
    @Nullable
    private CropInfo crop;
    private ItemStack cropStack = ItemStack.EMPTY;
    private int totalGrowthTicks;
    private int currentGrowthTicks;
    private int autoHarvestCooldown;
    private ChunkPos chunkPos;
    private List<ItemStack> dropsCache = null;

    private String tier;

    public TieredTileEntityBotanyPot(TileEntityType<?> tileEntityType, String tier) {
        super(tileEntityType);
        this.tier = tier;
    }

    public boolean canSetSoil(@Nullable SoilInfo newSoil) {
        return newSoil == null || this.getSoil() == null;
    }

    public void setSoil(@Nullable SoilInfo newSoil, ItemStack stack) {
        this.soil = newSoil;
        this.soilStack = stack;
        this.resetGrowthTime();
        if (!this.level.isClientSide) {
            this.sync(false);
            this.level.getChunkSource().getLightEngine().checkBlock(this.worldPosition);
        }
    }

    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket packet) {
        super.onDataPacket(net, packet);
        this.level.getLightEngine().checkBlock(this.worldPosition);
    }

    public boolean canSetCrop(@Nullable CropInfo newCrop) {
        return newCrop == null || this.getSoil() != null && this.getCrop() == null;
    }

    public void setCrop(@Nullable CropInfo newCrop, ItemStack stack) {
        this.crop = newCrop;
        this.cropStack = stack;
        this.resetGrowthTime();
        if (!this.level.isClientSide) {
            this.sync(false);
        }
    }

    @Nullable
    public SoilInfo getSoil() {
        return this.soil;
    }

    @Nullable
    public CropInfo getCrop() {
        return this.crop;
    }

    public int getTotalGrowthTicks() {
        return this.totalGrowthTicks;
    }

    public int getCurrentGrowthTicks() {
        return this.currentGrowthTicks;
    }

    public boolean canHarvest() {
        return this.crop != null && this.getTotalGrowthTicks() > 0 && this.getCurrentGrowthTicks() >= this.getTotalGrowthTicks();
    }

    public int getSpeed() {
        if (getTier() == "Elite") {
            return BotanyPotsTiersConfig.ELITE_BOTANY_POT_SPEED.get();
        } else if (getTier() == "Ultra") {
            return BotanyPotsTiersConfig.ULTRA_BOTANY_POT_SPEED.get();
        } else if (getTier() == "Creative") {
            return BotanyPotsTiersConfig.CREATIVE_BOTANY_POT_SPEED.get();
        } else {
            return 0;
        }
    }

    public int getMultiplier() {
        if (getTier() == "Elite") {
            return BotanyPotsTiersConfig.ELITE_BOTANY_POT_MULTIPLIER.get();
        } else if (getTier() == "Ultra") {
            return BotanyPotsTiersConfig.ULTRA_BOTANY_POT_MULTIPLIER.get();
        } else if (getTier() == "Creative") {
            return BotanyPotsTiersConfig.CREATIVE_BOTANY_POT_MULTIPLIER.get();
        } else {
            return 0;
        }
    }

    private int getAutoHarvestCooldown() {
        if (getTier() == "Elite") {
            return 4;
        } else if (getTier() == "Ultra") {
            return 2;
        } else if (getTier() == "Creative") {
            return 0;
        } else {
            return 0;
        }
    }

    public void resetGrowthTime() {
        this.totalGrowthTicks = BotanyPotHelper.getRequiredGrowthTicks(this.getCrop(), this.getSoil()) / getSpeed();
        this.currentGrowthTicks = 0;
        if (this.soil != null) {
            this.soil = BotanyPotHelper.getSoil(this.soil.getId());
            if (this.soil == null) {
                this.crop = null;
            }
        }

        if (this.crop != null) {
            this.crop = BotanyPotHelper.getCrop(this.crop.getId());
        }

        this.autoHarvestCooldown = getAutoHarvestCooldown();
        this.level.updateNeighbourForOutputSignal(this.worldPosition, this.getBlockState().getBlock());
        if (!this.level.isClientSide) {
            this.sync(false);
        }
    }

    public void addGrowth(int ticksToGrow) {
        this.currentGrowthTicks += ticksToGrow;
        if (this.currentGrowthTicks > this.totalGrowthTicks) {
            this.currentGrowthTicks = this.totalGrowthTicks;
        }

        if (!this.level.isClientSide) {
            this.sync(false);
        }
    }

    public float getGrowthPercent() {
        return this.totalGrowthTicks != -1 && this.currentGrowthTicks != -1 ? (float) this.currentGrowthTicks / (float) this.totalGrowthTicks : 0.0F;
    }

    public void onTileTick() {
        MinecraftForge.EVENT_BUS.post(new Pre(this));
        if (this.hasSoilAndCrop()) {
            if (this.isDoneGrowing()) {
                this.level.updateNeighbourForOutputSignal(this.worldPosition, this.getBlockState().getBlock());
                this.attemptAutoHarvest();
            } else {
                TieredPotGrowCropEvent.Pre growCropEvent = new TieredPotGrowCropEvent.Pre(this, 1);
                if (!MinecraftForge.EVENT_BUS.post(growCropEvent)) {
                    this.currentGrowthTicks += growCropEvent.getCurrentAmount();
                    MinecraftForge.EVENT_BUS.post(new Post(this, growCropEvent.getCurrentAmount()));
                }
            }
        } else if (this.totalGrowthTicks != -1 || this.currentGrowthTicks != 0) {
            this.resetGrowthTime();
        }

        MinecraftForge.EVENT_BUS.post(new TieredBotanyPotTickEvent.Post(this));
    }

    public boolean hasSoilAndCrop() {
        return this.soil != null && this.crop != null;
    }

    public boolean isDoneGrowing() {
        return this.hasSoilAndCrop() && this.totalGrowthTicks > 0 && this.currentGrowthTicks >= this.totalGrowthTicks;
    }

    private void attemptAutoHarvest() {
        if (!MinecraftForge.EVENT_BUS.post(new TieredBotanyPotHarvestedEvent.Pre(this, null))) {
            Block block = this.getBlockState().getBlock();
            if (block instanceof TieredBlockBotanyPot && ((TieredBlockBotanyPot) block).isHopper()) {
                if (this.autoHarvestCooldown > 0) {
                    --this.autoHarvestCooldown;
                    return;
                }

                IItemHandler inventory = InventoryUtils.getInventory(this.level, this.worldPosition.below(), Direction.UP);
                if (inventory != EmptyHandler.INSTANCE && !this.level.isClientSide) {
                    boolean didAutoHarvest = false;
                    List<ItemStack> drops = this.getDrops();
                    Iterator var5 = drops.iterator();

                    while (true) {
                        while (var5.hasNext()) {
                            ItemStack item = (ItemStack) var5.next();

                            for (int slot = 0; slot < inventory.getSlots(); ++slot) {
                                if (inventory.isItemValid(slot, item) && inventory.insertItem(slot, item, true).getCount() != item.getCount()) {
                                    item.setCount(item.getCount() * getMultiplier());
                                    inventory.insertItem(slot, item, false);
                                    didAutoHarvest = true;
                                    break;
                                }
                            }
                        }

                        if (didAutoHarvest || drops.isEmpty()) {
                            this.onCropHarvest();
                            this.resetGrowthTime();
                            this.dropsCache = null;
                            MinecraftForge.EVENT_BUS.post(new TieredBotanyPotHarvestedEvent.Post(this, null));
                        }
                        break;
                    }
                }
            }
        }
    }

    public void onCropHarvest() {
        if (this.hasSoilAndCrop()) {
            IChunk chunk = this.level.getChunk(this.worldPosition);
            if (chunk instanceof Chunk) {
                BotanyPots.NETWORK.sendToChunk((Chunk) chunk, new BreakEffectsMessage(this.worldPosition, this.crop.getDisplayState()[0].getState()));
            }
        }

        MinecraftForge.EVENT_BUS.post(new net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Post(this.level, this.worldPosition, this.getState(), this.getState()));
    }

    public void serialize(CompoundNBT dataTag) {
        if (this.soil != null) {
            dataTag.putString("Soil", this.soil.getId().toString());
            if (this.crop != null) {
                dataTag.putString("Crop", this.crop.getId().toString());
                dataTag.putInt("GrowthTicks", this.currentGrowthTicks);
            }
        }

        dataTag.put("CropStack", this.cropStack.serializeNBT());
        dataTag.put("SoilStack", this.soilStack.serializeNBT());
    }

    public void deserialize(CompoundNBT dataTag) {
        this.soil = null;
        this.crop = null;
        if (dataTag.contains("CropStack")) {
            this.cropStack = ItemStack.of(dataTag.getCompound("CropStack"));
        }

        if (dataTag.contains("SoilStack")) {
            this.soilStack = ItemStack.of(dataTag.getCompound("SoilStack"));
        }

        if (dataTag.contains("Soil")) {
            String rawSoilId = dataTag.getString("Soil");
            ResourceLocation soilId = ResourceLocation.tryParse(rawSoilId);
            if (soilId != null) {
                SoilInfo foundSoil = BotanyPotHelper.getSoil(soilId);
                if (foundSoil != null) {
                    this.soil = foundSoil;
                    if (dataTag.contains("Crop")) {
                        String rawCropId = dataTag.getString("Crop");
                        ResourceLocation cropId = ResourceLocation.tryParse(rawCropId);
                        if (cropId != null) {
                            CropInfo cropInfo = BotanyPotHelper.getCrop(cropId);
                            if (cropInfo != null) {
                                this.crop = cropInfo;
                                this.currentGrowthTicks = dataTag.getInt("GrowthTicks");
                                this.totalGrowthTicks = this.crop.getGrowthTicksForSoil(this.soil) / getSpeed();
                            } else {
                                BotanyPotsTiers.LOGGER.error(getTier() + " Botany Pot at {} had a crop of type {} but that crop does not exist. The crop will be discarded.", this.worldPosition, rawCropId);
                            }
                        } else {
                            BotanyPotsTiers.LOGGER.error(getTier() + " Botany Pot at {} has an invalid crop Id of {}. The crop will be discarded.", this.worldPosition, rawCropId);
                        }
                    }
                } else {
                    BotanyPotsTiers.LOGGER.error(getTier() + " Botany Pot at {} had a soil of type {} which no longer exists. Soil and crop will be discarded.", this.worldPosition, rawSoilId);
                }
            } else {
                BotanyPotsTiers.LOGGER.error(getTier() + " Botany Pot at {} has invalid soil type {}. Soil and crop will be discarded.", this.worldPosition, rawSoilId);
            }
        }
    }

    public ItemStack getSoilStack() {
        return this.soilStack;
    }

    public ItemStack getCropStack() {
        return this.cropStack;
    }

    public ChunkPos getChunkPos() {
        if (this.chunkPos == null) {
            this.chunkPos = new ChunkPos(this.worldPosition);
        }

        return this.chunkPos;
    }

    @OnlyIn(Dist.CLIENT)
    public double getViewDistance() {
        return BotanyPots.CLIENT_CONFIG.getRenderDistance();
    }

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        if (!this.remove && cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY && side == Direction.DOWN) {
            return LazyOptional.of(() -> DUMMY_INV).cast();
        }

        return super.getCapability(cap, side);
    }

    private List<ItemStack> getDrops() {
        if (this.dropsCache == null) {
            LootGenerated event = new LootGenerated(this, null, BotanyPotHelper.generateDrop(this.level.random, this.getCrop()));
            if (!MinecraftForge.EVENT_BUS.post(event)) {
                this.dropsCache = event.getDrops();
            } else {
                this.dropsCache = NonNullList.create();
            }
        }

        return this.dropsCache;
    }

    private String getTier() {
        return tier;
    }
}
