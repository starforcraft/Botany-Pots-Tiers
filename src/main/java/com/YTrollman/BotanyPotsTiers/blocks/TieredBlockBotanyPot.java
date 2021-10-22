package com.YTrollman.BotanyPotsTiers.blocks;

import com.YTrollman.BotanyPotsTiers.BotanyPotsTiers;
import com.YTrollman.BotanyPotsTiers.events.*;
import com.YTrollman.BotanyPotsTiers.events.TieredBotanyPotHarvestedEvent.LootGenerated;
import com.YTrollman.BotanyPotsTiers.events.TieredCropRemovedEvent.Post;
import com.YTrollman.BotanyPotsTiers.events.TieredCropRemovedEvent.Pre;
import com.YTrollman.BotanyPotsTiers.events.TieredLookupEvent.Crop;
import com.YTrollman.BotanyPotsTiers.events.TieredLookupEvent.Fertilizer;
import com.YTrollman.BotanyPotsTiers.events.TieredLookupEvent.Soil;
import com.YTrollman.BotanyPotsTiers.registry.ModTileEntityTypes;
import com.YTrollman.BotanyPotsTiers.tileentity.TieredTileEntityBotanyPot;
import net.darkhax.bookshelf.util.MathsUtils;
import net.darkhax.botanypots.BotanyPotHelper;
import net.darkhax.botanypots.crop.CropInfo;
import net.darkhax.botanypots.fertilizer.FertilizerInfo;
import net.darkhax.botanypots.soil.SoilInfo;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.Property;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;

import javax.annotation.Nullable;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class TieredBlockBotanyPot extends Block implements IGrowable, IWaterLoggable {

    private static final ITextComponent TOOLTIP_NORMAL = new TranslationTextComponent("botanypots.tooltip.pot.normal").withStyle(TextFormatting.GRAY);
    private static final ITextComponent TOOLTIP_HOPPER = new TranslationTextComponent("botanypots.tooltip.pot.hopper").withStyle(TextFormatting.GRAY);

    private static final VoxelShape SHAPE = Block.box(2, 0, 2, 14, 8, 14);

    private static final Properties properties = Properties.of(Material.CLAY).strength(1.25F, 4.2F).noOcclusion();

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    private final boolean hopper;

    public static List<Block> botanyPots = NonNullList.create();

    private String tileEntityName;
    private String tier;

    public TieredBlockBotanyPot(boolean hopper, String tileEntityName) {
        super(properties);
        this.tileEntityName = tileEntityName;
        this.hopper = hopper;
        botanyPots.add(this);
        this.registerDefaultState(this.getStateDefinition().any().setValue(WATERLOGGED, false));
    }

    public boolean isHopper() {
        return this.hopper;
    }

    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
        if (world.isClientSide) {
            return ActionResultType.SUCCESS;
        } else {
            TileEntity tile = world.getBlockEntity(pos);
            if (tile instanceof TieredTileEntityBotanyPot) {
                TieredTileEntityBotanyPot pot = (TieredTileEntityBotanyPot)tile;
                SoilInfo soilForStack;
                if (player.isShiftKeyDown()) {
                    CropInfo crop = pot.getCrop();
                    if (crop != null) {
                        if (MinecraftForge.EVENT_BUS.post(new Pre(pot, player, crop))) {
                            return ActionResultType.FAIL;
                        }

                        if (pot.canSetCrop(null)) {
                            ItemStack seedStack = pot.getCropStack();
                            if (!seedStack.isEmpty()) {
                                dropItem(seedStack.copy(), world, pos);
                            }

                            pot.setCrop(null, ItemStack.EMPTY);
                            MinecraftForge.EVENT_BUS.post(new Post(pot, player, crop));
                            return ActionResultType.SUCCESS;
                        }
                    } else {
                        soilForStack = pot.getSoil();
                        if (soilForStack != null && !MinecraftForge.EVENT_BUS.post(new TieredSoilRemoveEvent.Pre(pot, soilForStack, player))) {
                            ItemStack soilStack = pot.getSoilStack();
                            if (!soilStack.isEmpty() && pot.canSetSoil(null)) {
                                pot.setSoil(null, ItemStack.EMPTY);
                                dropItem(soilStack.copy(), world, pos);
                                MinecraftForge.EVENT_BUS.post(new TieredSoilRemoveEvent.Post(pot, soilForStack, player));
                                return ActionResultType.SUCCESS;
                            }
                        }
                    }
                } else {
                    ItemStack heldItem = player.getItemInHand(hand);
                    if (!heldItem.isEmpty()) {
                        if (pot.getSoil() == null) {
                            soilForStack = BotanyPotHelper.getSoilForItem(heldItem);
                            Soil lookupEvent = new Soil(pot, player, soilForStack, heldItem);
                            if (!MinecraftForge.EVENT_BUS.post(lookupEvent) && lookupEvent.getCurrentLookup() != null) {
                                soilForStack = lookupEvent.getCurrentLookup();
                                TieredSoilPlaceEvent.Pre preEvent = new TieredSoilPlaceEvent.Pre(pot, soilForStack, player);
                                if (!MinecraftForge.EVENT_BUS.post(preEvent) && preEvent.getCurrentSoil() != null) {
                                    soilForStack = preEvent.getCurrentSoil();
                                    if (soilForStack != null && pot.canSetSoil(soilForStack)) {
                                        ItemStack inStack = heldItem.copy();
                                        inStack.setCount(1);
                                        pot.setSoil(soilForStack, inStack);
                                        if (!player.isCreative()) {
                                            heldItem.shrink(1);
                                        }

                                        MinecraftForge.EVENT_BUS.post(new TieredSoilPlaceEvent.Post(pot, soilForStack, player));
                                        return ActionResultType.SUCCESS;
                                    }
                                }
                            }
                        } else if (pot.getCrop() == null) {
                            CropInfo cropForStack = BotanyPotHelper.getCropForItem(heldItem);
                            TieredLookupEvent<CropInfo> lookupEvent = new Crop(pot, player, cropForStack, heldItem);
                            if (!MinecraftForge.EVENT_BUS.post(lookupEvent) && lookupEvent.getCurrentLookup() != null) {
                                cropForStack = lookupEvent.getCurrentLookup();
                                TieredCropPlaceEvent.Pre preEvent = new TieredCropPlaceEvent.Pre(pot, player, cropForStack);
                                if (!MinecraftForge.EVENT_BUS.post(preEvent) && preEvent.getCurrentCrop() != null) {
                                    cropForStack = preEvent.getCurrentCrop();
                                    boolean isSoilValid = BotanyPotHelper.isSoilValidForCrop(pot.getSoil(), cropForStack);
                                    TieredSoilValidForCropEvent validSoilEvent = new TieredSoilValidForCropEvent(pot, player, pot.getSoil(), cropForStack, isSoilValid);
                                    isSoilValid = !MinecraftForge.EVENT_BUS.post(validSoilEvent) && validSoilEvent.isSoilValid();
                                    if (isSoilValid && pot.canSetCrop(cropForStack)) {
                                        ItemStack inStack = heldItem.copy();
                                        inStack.setCount(1);
                                        pot.setCrop(cropForStack, inStack);
                                        if (!player.isCreative()) {
                                            heldItem.shrink(1);
                                        }

                                        MinecraftForge.EVENT_BUS.post(new TieredCropPlaceEvent.Post(pot, player, cropForStack));
                                        return ActionResultType.SUCCESS;
                                    }
                                }
                            }
                        } else if (!pot.canHarvest()) {
                            FertilizerInfo fertilizerForStack = BotanyPotHelper.getFertilizerForItem(heldItem);
                            Fertilizer lookupEvent = new Fertilizer(pot, player, fertilizerForStack, heldItem);
                            if (!MinecraftForge.EVENT_BUS.post(lookupEvent) && lookupEvent.getCurrentLookup() != null) {
                                fertilizerForStack = lookupEvent.getCurrentLookup();
                                if (fertilizerForStack != null) {
                                    int ticksToGrow = fertilizerForStack.getTicksToGrow(world.random, pot.getSoil(), pot.getCrop());
                                    TieredFertilizerUsedEvent.Pre preEvent = new TieredFertilizerUsedEvent.Pre(pot, player, fertilizerForStack, heldItem, ticksToGrow);
                                    if (!MinecraftForge.EVENT_BUS.post(preEvent) && preEvent.getCurrentGrowthTicks() > 0) {
                                        ticksToGrow = preEvent.getCurrentGrowthTicks();
                                        pot.addGrowth(ticksToGrow);
                                        if (!world.isClientSide) {
                                            world.levelEvent(2005, tile.getBlockPos(), 0);
                                        }

                                        if (!player.isCreative()) {
                                            heldItem.shrink(1);
                                        }

                                        MinecraftForge.EVENT_BUS.post(new TieredFertilizerUsedEvent.Post(pot, player, fertilizerForStack, heldItem, ticksToGrow));
                                        return ActionResultType.SUCCESS;
                                    }
                                }
                            }
                        }
                    }

                    if (!this.isHopper() && pot.canHarvest() && !MinecraftForge.EVENT_BUS.post(new TieredBotanyPotHarvestedEvent.Pre(pot, player))) {
                        LootGenerated event = new LootGenerated(pot, player, BotanyPotHelper.generateDrop(world.random, pot.getCrop()));
                        if (!MinecraftForge.EVENT_BUS.post(event) && !event.getDrops().isEmpty()) {
                            Iterator var23 = event.getDrops().iterator();

                            while(var23.hasNext()) {
                                ItemStack stack = (ItemStack)var23.next();
                                stack.setCount(stack.getCount() * pot.getSpeed());
                                dropItem(stack, world, pos);
                            }
                        }

                        pot.onCropHarvest();
                        pot.resetGrowthTime();
                        MinecraftForge.EVENT_BUS.post(new TieredBotanyPotHarvestedEvent.Post(pot, player));
                        return ActionResultType.SUCCESS;
                    }
                }
            }

            return ActionResultType.FAIL;
        }
    }

    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new TieredTileEntityBotanyPot(rightTileEntity(), tier);
    }

    private TileEntityType<?> rightTileEntity()
    {
        //Elite
        if(tileEntityName == "ELITE_BOTANY_POT")
        {
            tier = "Elite";
            return ModTileEntityTypes.ELITE_BOTANY_POT.get();
        }
        else if(tileEntityName == "ELITE_BLACK_BOTANY_POT")
        {
            tier = "Elite";
            return ModTileEntityTypes.ELITE_BLACK_BOTANY_POT.get();
        }
        else if(tileEntityName == "ELITE_BLUE_BOTANY_POT")
        {
            tier = "Elite";
            return ModTileEntityTypes.ELITE_BLUE_BOTANY_POT.get();
        }
        else if(tileEntityName == "ELITE_BROWN_BOTANY_POT")
        {
            tier = "Elite";
            return ModTileEntityTypes.ELITE_BROWN_BOTANY_POT.get();
        }
        else if(Objects.equals(tileEntityName, "ELITE_CYAN_BOTANY_POT"))
        {
            tier = "Elite";
            return ModTileEntityTypes.ELITE_CYAN_BOTANY_POT.get();
        }
        else if(tileEntityName == "ELITE_GRAY_BOTANY_POT")
        {
            tier = "Elite";
            return ModTileEntityTypes.ELITE_GRAY_BOTANY_POT.get();
        }
        else if(tileEntityName == "ELITE_GREEN_BOTANY_POT")
        {
            tier = "Elite";
            return ModTileEntityTypes.ELITE_GREEN_BOTANY_POT.get();
        }
        else if(tileEntityName == "ELITE_LIGHT_BLUE_BOTANY_POT")
        {
            tier = "Elite";
            return ModTileEntityTypes.ELITE_LIGHT_BLUE_BOTANY_POT.get();
        }
        else if(tileEntityName == "ELITE_LIGHT_GRAY_BOTANY_POT")
        {
            tier = "Elite";
            return ModTileEntityTypes.ELITE_LIGHT_GRAY_BOTANY_POT.get();
        }
        else if(tileEntityName == "ELITE_LIME_BOTANY_POT")
        {
            tier = "Elite";
            return ModTileEntityTypes.ELITE_LIME_BOTANY_POT.get();
        }
        else if(tileEntityName == "ELITE_MAGENTA_BOTANY_POT")
        {
            tier = "Elite";
            return ModTileEntityTypes.ELITE_MAGENTA_BOTANY_POT.get();
        }
        else if(tileEntityName == "ELITE_ORANGE_BOTANY_POT")
        {
            tier = "Elite";
            return ModTileEntityTypes.ELITE_ORANGE_BOTANY_POT.get();
        }
        else if(tileEntityName == "ELITE_PINK_BOTANY_POT")
        {
            tier = "Elite";
            return ModTileEntityTypes.ELITE_PINK_BOTANY_POT.get();
        }
        else if(tileEntityName == "ELITE_PURPLE_BOTANY_POT")
        {
            tier = "Elite";
            return ModTileEntityTypes.ELITE_PURPLE_BOTANY_POT.get();
        }
        else if(tileEntityName == "ELITE_RED_BOTANY_POT")
        {
            tier = "Elite";
            return ModTileEntityTypes.ELITE_RED_BOTANY_POT.get();
        }
        else if(tileEntityName == "ELITE_WHITE_BOTANY_POT")
        {
            tier = "Elite";
            return ModTileEntityTypes.ELITE_WHITE_BOTANY_POT.get();
        }
        else if(tileEntityName == "ELITE_YELLOW_BOTANY_POT")
        {
            tier = "Elite";
            return ModTileEntityTypes.ELITE_YELLOW_BOTANY_POT.get();
        }

        else if(tileEntityName == "ELITE_HOPPER_BOTANY_POT")
        {
            tier = "Elite";
            return ModTileEntityTypes.ELITE_HOPPER_BOTANY_POT.get();
        }
        else if(tileEntityName == "ELITE_HOPPER_BLACK_BOTANY_POT")
        {
            tier = "Elite";
            return ModTileEntityTypes.ELITE_HOPPER_BLACK_BOTANY_POT.get();
        }
        else if(tileEntityName == "ELITE_HOPPER_BLUE_BOTANY_POT")
        {
            tier = "Elite";
            return ModTileEntityTypes.ELITE_HOPPER_BLUE_BOTANY_POT.get();
        }
        else if(tileEntityName == "ELITE_HOPPER_BROWN_BOTANY_POT")
        {
            tier = "Elite";
            return ModTileEntityTypes.ELITE_HOPPER_BROWN_BOTANY_POT.get();
        }
        else if(tileEntityName == "ELITE_HOPPER_CYAN_BOTANY_POT")
        {
            tier = "Elite";
            return ModTileEntityTypes.ELITE_HOPPER_CYAN_BOTANY_POT.get();
        }
        else if(tileEntityName == "ELITE_HOPPER_GRAY_BOTANY_POT")
        {
            tier = "Elite";
            return ModTileEntityTypes.ELITE_HOPPER_GRAY_BOTANY_POT.get();
        }
        else if(tileEntityName == "ELITE_HOPPER_GREEN_BOTANY_POT")
        {
            tier = "Elite";
            return ModTileEntityTypes.ELITE_HOPPER_GREEN_BOTANY_POT.get();
        }
        else if(tileEntityName == "ELITE_HOPPER_LIGHT_BLUE_BOTANY_POT")
        {
            tier = "Elite";
            return ModTileEntityTypes.ELITE_HOPPER_LIGHT_BLUE_BOTANY_POT.get();
        }
        else if(tileEntityName == "ELITE_HOPPER_LIGHT_GRAY_BOTANY_POT")
        {
            tier = "Elite";
            return ModTileEntityTypes.ELITE_HOPPER_LIGHT_GRAY_BOTANY_POT.get();
        }
        else if(tileEntityName == "ELITE_HOPPER_LIME_BOTANY_POT")
        {
            tier = "Elite";
            return ModTileEntityTypes.ELITE_HOPPER_LIME_BOTANY_POT.get();
        }
        else if(tileEntityName == "ELITE_HOPPER_MAGENTA_BOTANY_POT")
        {
            tier = "Elite";
            return ModTileEntityTypes.ELITE_HOPPER_MAGENTA_BOTANY_POT.get();
        }
        else if(tileEntityName == "ELITE_HOPPER_ORANGE_BOTANY_POT")
        {
            tier = "Elite";
            return ModTileEntityTypes.ELITE_HOPPER_ORANGE_BOTANY_POT.get();
        }
        else if(tileEntityName == "ELITE_HOPPER_PINK_BOTANY_POT")
        {
            tier = "Elite";
            return ModTileEntityTypes.ELITE_HOPPER_PINK_BOTANY_POT.get();
        }
        else if(tileEntityName == "ELITE_HOPPER_PURPLE_BOTANY_POT")
        {
            tier = "Elite";
            return ModTileEntityTypes.ELITE_HOPPER_PURPLE_BOTANY_POT.get();
        }
        else if(tileEntityName == "ELITE_HOPPER_RED_BOTANY_POT")
        {
            tier = "Elite";
            return ModTileEntityTypes.ELITE_HOPPER_RED_BOTANY_POT.get();
        }
        else if(tileEntityName == "ELITE_HOPPER_WHITE_BOTANY_POT")
        {
            tier = "Elite";
            return ModTileEntityTypes.ELITE_HOPPER_WHITE_BOTANY_POT.get();
        }
        else if(tileEntityName == "ELITE_HOPPER_YELLOW_BOTANY_POT")
        {
            tier = "Elite";
            return ModTileEntityTypes.ELITE_HOPPER_YELLOW_BOTANY_POT.get();
        }

        //Ultra
        else if(tileEntityName == "ULTRA_BOTANY_POT")
        {
            tier = "Ultra";
            return ModTileEntityTypes.ULTRA_BOTANY_POT.get();
        }
        else if(tileEntityName == "ULTRA_BLACK_BOTANY_POT")
        {
            tier = "Ultra";
            return ModTileEntityTypes.ULTRA_BLACK_BOTANY_POT.get();
        }
        else if(tileEntityName == "ULTRA_BLUE_BOTANY_POT")
        {
            tier = "Ultra";
            return ModTileEntityTypes.ULTRA_BLUE_BOTANY_POT.get();
        }
        else if(tileEntityName == "ULTRA_BROWN_BOTANY_POT")
        {
            tier = "Ultra";
            return ModTileEntityTypes.ULTRA_BROWN_BOTANY_POT.get();
        }
        else if(tileEntityName == "ULTRA_CYAN_BOTANY_POT")
        {
            tier = "Ultra";
            return ModTileEntityTypes.ULTRA_CYAN_BOTANY_POT.get();
        }
        else if(tileEntityName == "ULTRA_GRAY_BOTANY_POT")
        {
            tier = "Ultra";
            return ModTileEntityTypes.ULTRA_GRAY_BOTANY_POT.get();
        }
        else if(tileEntityName == "ULTRA_GREEN_BOTANY_POT")
        {
            tier = "Ultra";
            return ModTileEntityTypes.ULTRA_GREEN_BOTANY_POT.get();
        }
        else if(tileEntityName == "ULTRA_LIGHT_BLUE_BOTANY_POT")
        {
            tier = "Ultra";
            return ModTileEntityTypes.ULTRA_LIGHT_BLUE_BOTANY_POT.get();
        }
        else if(tileEntityName == "ULTRA_LIGHT_GRAY_BOTANY_POT")
        {
            tier = "Ultra";
            return ModTileEntityTypes.ULTRA_LIGHT_GRAY_BOTANY_POT.get();
        }
        else if(tileEntityName == "ULTRA_LIME_BOTANY_POT")
        {
            tier = "Ultra";
            return ModTileEntityTypes.ULTRA_LIME_BOTANY_POT.get();
        }
        else if(tileEntityName == "ULTRA_MAGENTA_BOTANY_POT")
        {
            tier = "Ultra";
            return ModTileEntityTypes.ULTRA_MAGENTA_BOTANY_POT.get();
        }
        else if(tileEntityName == "ULTRA_ORANGE_BOTANY_POT")
        {
            tier = "Ultra";
            return ModTileEntityTypes.ULTRA_ORANGE_BOTANY_POT.get();
        }
        else if(tileEntityName == "ULTRA_PINK_BOTANY_POT")
        {
            tier = "Ultra";
            return ModTileEntityTypes.ULTRA_PINK_BOTANY_POT.get();
        }
        else if(tileEntityName == "ULTRA_PURPLE_BOTANY_POT")
        {
            tier = "Ultra";
            return ModTileEntityTypes.ULTRA_PURPLE_BOTANY_POT.get();
        }
        else if(tileEntityName == "ULTRA_RED_BOTANY_POT")
        {
            tier = "Ultra";
            return ModTileEntityTypes.ULTRA_RED_BOTANY_POT.get();
        }
        else if(tileEntityName == "ULTRA_WHITE_BOTANY_POT")
        {
            tier = "Ultra";
            return ModTileEntityTypes.ULTRA_WHITE_BOTANY_POT.get();
        }
        else if(tileEntityName == "ULTRA_YELLOW_BOTANY_POT")
        {
            tier = "Ultra";
            return ModTileEntityTypes.ULTRA_YELLOW_BOTANY_POT.get();
        }

        else if(tileEntityName == "ULTRA_HOPPER_BOTANY_POT")
        {
            tier = "Ultra";
            return ModTileEntityTypes.ULTRA_HOPPER_BOTANY_POT.get();
        }
        else if(tileEntityName == "ULTRA_HOPPER_BLACK_BOTANY_POT")
        {
            tier = "Ultra";
            return ModTileEntityTypes.ULTRA_HOPPER_BLACK_BOTANY_POT.get();
        }
        else if(tileEntityName == "ULTRA_HOPPER_BLUE_BOTANY_POT")
        {
            tier = "Ultra";
            return ModTileEntityTypes.ULTRA_HOPPER_BLUE_BOTANY_POT.get();
        }
        else if(tileEntityName == "ULTRA_HOPPER_BROWN_BOTANY_POT")
        {
            tier = "Ultra";
            return ModTileEntityTypes.ULTRA_HOPPER_BROWN_BOTANY_POT.get();
        }
        else if(tileEntityName == "ULTRA_HOPPER_CYAN_BOTANY_POT")
        {
            tier = "Ultra";
            return ModTileEntityTypes.ULTRA_HOPPER_CYAN_BOTANY_POT.get();
        }
        else if(tileEntityName == "ULTRA_HOPPER_GRAY_BOTANY_POT")
        {
            tier = "Ultra";
            return ModTileEntityTypes.ULTRA_HOPPER_GRAY_BOTANY_POT.get();
        }
        else if(tileEntityName == "ULTRA_HOPPER_GREEN_BOTANY_POT")
        {
            tier = "Ultra";
            return ModTileEntityTypes.ULTRA_HOPPER_GREEN_BOTANY_POT.get();
        }
        else if(tileEntityName == "ULTRA_HOPPER_LIGHT_BLUE_BOTANY_POT")
        {
            tier = "Ultra";
            return ModTileEntityTypes.ULTRA_HOPPER_LIGHT_BLUE_BOTANY_POT.get();
        }
        else if(tileEntityName == "ULTRA_HOPPER_LIGHT_GRAY_BOTANY_POT")
        {
            tier = "Ultra";
            return ModTileEntityTypes.ULTRA_HOPPER_LIGHT_GRAY_BOTANY_POT.get();
        }
        else if(tileEntityName == "ULTRA_HOPPER_LIME_BOTANY_POT")
        {
            tier = "Ultra";
            return ModTileEntityTypes.ULTRA_HOPPER_LIME_BOTANY_POT.get();
        }
        else if(tileEntityName == "ULTRA_HOPPER_MAGENTA_BOTANY_POT")
        {
            tier = "Ultra";
            return ModTileEntityTypes.ULTRA_HOPPER_MAGENTA_BOTANY_POT.get();
        }
        else if(tileEntityName == "ULTRA_HOPPER_ORANGE_BOTANY_POT")
        {
            tier = "Ultra";
            return ModTileEntityTypes.ULTRA_HOPPER_ORANGE_BOTANY_POT.get();
        }
        else if(tileEntityName == "ULTRA_HOPPER_PINK_BOTANY_POT")
        {
            tier = "Ultra";
            return ModTileEntityTypes.ULTRA_HOPPER_PINK_BOTANY_POT.get();
        }
        else if(tileEntityName == "ULTRA_HOPPER_PURPLE_BOTANY_POT")
        {
            tier = "Ultra";
            return ModTileEntityTypes.ULTRA_HOPPER_PURPLE_BOTANY_POT.get();
        }
        else if(tileEntityName == "ULTRA_HOPPER_RED_BOTANY_POT")
        {
            tier = "Ultra";
            return ModTileEntityTypes.ULTRA_HOPPER_RED_BOTANY_POT.get();
        }
        else if(tileEntityName == "ULTRA_HOPPER_WHITE_BOTANY_POT")
        {
            tier = "Ultra";
            return ModTileEntityTypes.ULTRA_HOPPER_WHITE_BOTANY_POT.get();
        }
        else if(tileEntityName == "ULTRA_HOPPER_YELLOW_BOTANY_POT")
        {
            tier = "Ultra";
            return ModTileEntityTypes.ULTRA_HOPPER_YELLOW_BOTANY_POT.get();
        }

        //Creative
        else if(tileEntityName == "CREATIVE_BOTANY_POT")
        {
            tier = "Creative";
            return ModTileEntityTypes.CREATIVE_BOTANY_POT.get();
        }
        else if(tileEntityName == "CREATIVE_BLACK_BOTANY_POT")
        {
            tier = "Creative";
            return ModTileEntityTypes.CREATIVE_BLACK_BOTANY_POT.get();
        }
        else if(tileEntityName == "CREATIVE_BLUE_BOTANY_POT")
        {
            tier = "Creative";
            return ModTileEntityTypes.CREATIVE_BLUE_BOTANY_POT.get();
        }
        else if(tileEntityName == "CREATIVE_BROWN_BOTANY_POT")
        {
            tier = "Creative";
            return ModTileEntityTypes.CREATIVE_BROWN_BOTANY_POT.get();
        }
        else if(tileEntityName == "CREATIVE_CYAN_BOTANY_POT")
        {
            tier = "Creative";
            return ModTileEntityTypes.CREATIVE_CYAN_BOTANY_POT.get();
        }
        else if(tileEntityName == "CREATIVE_GRAY_BOTANY_POT")
        {
            tier = "Creative";
            return ModTileEntityTypes.CREATIVE_GRAY_BOTANY_POT.get();
        }
        else if(tileEntityName == "CREATIVE_GREEN_BOTANY_POT")
        {
            tier = "Creative";
            return ModTileEntityTypes.CREATIVE_GREEN_BOTANY_POT.get();
        }
        else if(tileEntityName == "CREATIVE_LIGHT_BLUE_BOTANY_POT")
        {
            tier = "Creative";
            return ModTileEntityTypes.CREATIVE_LIGHT_BLUE_BOTANY_POT.get();
        }
        else if(tileEntityName == "CREATIVE_LIGHT_GRAY_BOTANY_POT")
        {
            tier = "Creative";
            return ModTileEntityTypes.CREATIVE_LIGHT_GRAY_BOTANY_POT.get();
        }
        else if(tileEntityName == "CREATIVE_LIME_BOTANY_POT")
        {
            tier = "Creative";
            return ModTileEntityTypes.CREATIVE_LIME_BOTANY_POT.get();
        }
        else if(tileEntityName == "CREATIVE_MAGENTA_BOTANY_POT")
        {
            tier = "Creative";
            return ModTileEntityTypes.CREATIVE_MAGENTA_BOTANY_POT.get();
        }
        else if(tileEntityName == "CREATIVE_ORANGE_BOTANY_POT")
        {
            tier = "Creative";
            return ModTileEntityTypes.CREATIVE_ORANGE_BOTANY_POT.get();
        }
        else if(tileEntityName == "CREATIVE_PINK_BOTANY_POT")
        {
            tier = "Creative";
            return ModTileEntityTypes.CREATIVE_PINK_BOTANY_POT.get();
        }
        else if(tileEntityName == "CREATIVE_PURPLE_BOTANY_POT")
        {
            tier = "Creative";
            return ModTileEntityTypes.CREATIVE_PURPLE_BOTANY_POT.get();
        }
        else if(tileEntityName == "CREATIVE_RED_BOTANY_POT")
        {
            tier = "Creative";
            return ModTileEntityTypes.CREATIVE_RED_BOTANY_POT.get();
        }
        else if(tileEntityName == "CREATIVE_WHITE_BOTANY_POT")
        {
            tier = "Creative";
            return ModTileEntityTypes.CREATIVE_WHITE_BOTANY_POT.get();
        }
        else if(tileEntityName == "CREATIVE_YELLOW_BOTANY_POT")
        {
            tier = "Creative";
            return ModTileEntityTypes.CREATIVE_YELLOW_BOTANY_POT.get();
        }

        else if(tileEntityName == "CREATIVE_HOPPER_BOTANY_POT")
        {
            tier = "Creative";
            return ModTileEntityTypes.CREATIVE_HOPPER_BOTANY_POT.get();
        }
        else if(tileEntityName == "CREATIVE_HOPPER_BLACK_BOTANY_POT")
        {
            tier = "Creative";
            return ModTileEntityTypes.CREATIVE_HOPPER_BLACK_BOTANY_POT.get();
        }
        else if(tileEntityName == "CREATIVE_HOPPER_BLUE_BOTANY_POT")
        {
            tier = "Creative";
            return ModTileEntityTypes.CREATIVE_HOPPER_BLUE_BOTANY_POT.get();
        }
        else if(tileEntityName == "CREATIVE_HOPPER_BROWN_BOTANY_POT")
        {
            tier = "Creative";
            return ModTileEntityTypes.CREATIVE_HOPPER_BROWN_BOTANY_POT.get();
        }
        else if(tileEntityName == "CREATIVE_HOPPER_CYAN_BOTANY_POT")
        {
            tier = "Creative";
            return ModTileEntityTypes.CREATIVE_HOPPER_CYAN_BOTANY_POT.get();
        }
        else if(tileEntityName == "CREATIVE_HOPPER_GRAY_BOTANY_POT")
        {
            tier = "Creative";
            return ModTileEntityTypes.CREATIVE_HOPPER_GRAY_BOTANY_POT.get();
        }
        else if(tileEntityName == "CREATIVE_HOPPER_GREEN_BOTANY_POT")
        {
            tier = "Creative";
            return ModTileEntityTypes.CREATIVE_HOPPER_GREEN_BOTANY_POT.get();
        }
        else if(tileEntityName == "CREATIVE_HOPPER_LIGHT_BLUE_BOTANY_POT")
        {
            tier = "Creative";
            return ModTileEntityTypes.CREATIVE_HOPPER_LIGHT_BLUE_BOTANY_POT.get();
        }
        else if(tileEntityName == "CREATIVE_HOPPER_LIGHT_GRAY_BOTANY_POT")
        {
            tier = "Creative";
            return ModTileEntityTypes.CREATIVE_HOPPER_LIGHT_GRAY_BOTANY_POT.get();
        }
        else if(tileEntityName == "CREATIVE_HOPPER_LIME_BOTANY_POT")
        {
            tier = "Creative";
            return ModTileEntityTypes.CREATIVE_HOPPER_LIME_BOTANY_POT.get();
        }
        else if(tileEntityName == "CREATIVE_HOPPER_MAGENTA_BOTANY_POT")
        {
            tier = "Creative";
            return ModTileEntityTypes.CREATIVE_HOPPER_MAGENTA_BOTANY_POT.get();
        }
        else if(tileEntityName == "CREATIVE_HOPPER_ORANGE_BOTANY_POT")
        {
            tier = "Creative";
            return ModTileEntityTypes.CREATIVE_HOPPER_ORANGE_BOTANY_POT.get();
        }
        else if(tileEntityName == "CREATIVE_HOPPER_PINK_BOTANY_POT")
        {
            tier = "Creative";
            return ModTileEntityTypes.CREATIVE_HOPPER_PINK_BOTANY_POT.get();
        }
        else if(tileEntityName == "CREATIVE_HOPPER_PURPLE_BOTANY_POT")
        {
            tier = "Creative";
            return ModTileEntityTypes.CREATIVE_HOPPER_PURPLE_BOTANY_POT.get();
        }
        else if(tileEntityName == "CREATIVE_HOPPER_RED_BOTANY_POT")
        {
            tier = "Creative";
            return ModTileEntityTypes.CREATIVE_HOPPER_RED_BOTANY_POT.get();
        }
        else if(tileEntityName == "CREATIVE_HOPPER_WHITE_BOTANY_POT")
        {
            tier = "Creative";
            return ModTileEntityTypes.CREATIVE_HOPPER_WHITE_BOTANY_POT.get();
        }
        else if(tileEntityName == "CREATIVE_HOPPER_YELLOW_BOTANY_POT")
        {
            tier = "Creative";
            return ModTileEntityTypes.CREATIVE_HOPPER_YELLOW_BOTANY_POT.get();
        }
        return null;
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    public void onRemove(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.hasTileEntity() && state.getBlock() != newState.getBlock()) {
            TileEntity tileEntity = worldIn.getBlockEntity(pos);
            if (tileEntity instanceof TieredTileEntityBotanyPot) {
                TieredTileEntityBotanyPot pot = (TieredTileEntityBotanyPot)tileEntity;
                if (pot.getSoil() != null) {
                    dropItem(pot.getSoilStack(), worldIn, pos);
                }

                if (pot.getCrop() != null) {
                    dropItem(pot.getCropStack(), worldIn, pos);
                }
            }
        }

        super.onRemove(state, worldIn, pos, newState, isMoving);
    }

    public static void dropItem(ItemStack item, World world, BlockPos pos) {
        if (!world.isClientSide) {
            double offsetX = (double)(world.random.nextFloat() * 0.7F) + 0.15000000596046448D;
            double offsetY = (double)(world.random.nextFloat() * 0.7F) + 0.06000000238418579D + 0.6D;
            double offsetZ = (double)(world.random.nextFloat() * 0.7F) + 0.15000000596046448D;
            ItemEntity droppedItemEntity = new ItemEntity(world, (double)pos.getX() + offsetX, (double)pos.getY() + offsetY, (double)pos.getZ() + offsetZ, item);
            droppedItemEntity.setDefaultPickUpDelay();
            world.addFreshEntity(droppedItemEntity);
        }

    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(this.isHopper() ? TOOLTIP_HOPPER : TOOLTIP_NORMAL);
    }

    public boolean isValidBonemealTarget(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        TileEntity tile = worldIn.getBlockEntity(pos);
        if (!(tile instanceof TieredTileEntityBotanyPot)) {
            return false;
        } else {
            TieredTileEntityBotanyPot pot = (TieredTileEntityBotanyPot)tile;
            return pot.hasSoilAndCrop() && !pot.isDoneGrowing();
        }
    }

    public boolean isBonemealSuccess(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return false;
    }

    public void performBonemeal(ServerWorld world, Random random, BlockPos pos, BlockState myState) {
        TileEntity tile = world.getBlockEntity(pos);
        if (tile instanceof TieredTileEntityBotanyPot) {
            ((TieredTileEntityBotanyPot)tile).addGrowth(MathsUtils.nextIntInclusive(random, 3, 15) * 20);
        }

    }

    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    public int getAnalogOutputSignal(BlockState blockState, World world, BlockPos pos) {
        if (world.hasChunkAt(pos)) {
            TileEntity tile = world.getBlockEntity(pos);
            if (tile instanceof TieredTileEntityBotanyPot) {
                return ((TieredTileEntityBotanyPot)tile).isDoneGrowing() ? 15 : super.getAnalogOutputSignal(blockState, world, pos);
            }
        }

        return super.getAnalogOutputSignal(blockState, world, pos);
    }

    public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
        int light = super.getLightValue(state, world, pos);
        TileEntity tile = world.getBlockEntity(pos);
        if (tile instanceof TieredTileEntityBotanyPot) {
            TieredTileEntityBotanyPot pot = (TieredTileEntityBotanyPot)tile;
            int cropLight;
            if (pot.getSoil() != null) {
                cropLight = pot.getSoil().getLightLevel(world, pos);
                if (cropLight > light) {
                    light = cropLight;
                }
            }

            if (pot.getCrop() != null) {
                cropLight = pot.getCrop().getLightLevel(world, pos);
                if (cropLight > light) {
                    light = cropLight;
                }
            }
        }

        return light;
    }

    public int getLightBlock(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 0;
    }

    public BlockState getStateForPlacement(BlockItemUseContext context) {
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
        return this.defaultBlockState().setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER);
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED);
    }

    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (stateIn.getValue(WATERLOGGED)) {
            worldIn.getLiquidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn));
        }

        return super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }
}
