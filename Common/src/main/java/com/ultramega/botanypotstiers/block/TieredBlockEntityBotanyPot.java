package com.ultramega.botanypotstiers.block;

import com.ultramega.botanypotstiers.Constants;
import com.ultramega.botanypotstiers.PotTiers;
import net.darkhax.bookshelf.api.Services;
import net.darkhax.bookshelf.api.inventory.ContainerInventoryAccess;
import net.darkhax.bookshelf.api.inventory.IInventoryAccess;
import net.darkhax.bookshelf.api.registry.RegistryObject;
import net.darkhax.botanypots.BotanyPotHelper;
import net.darkhax.botanypots.block.BlockEntityBotanyPot;
import net.darkhax.botanypots.block.inv.BotanyPotContainer;
import net.darkhax.botanypots.data.recipes.crop.Crop;
import net.darkhax.botanypots.data.recipes.soil.Soil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;
import java.util.Random;

public class TieredBlockEntityBotanyPot extends BlockEntityBotanyPot {
    final Random rng = new Random();
    private long rngSeed;

    private final PotTiers tier;

    public TieredBlockEntityBotanyPot(PotTiers tier, BlockPos pos, BlockState state) {
        super((BlockEntityType) RegistryObject.deferred(Registry.BLOCK_ENTITY_TYPE, Constants.MOD_ID, tier.getName() + "_botany_pot").cast().get(), pos, state);
        this.tier = tier;
        this.refreshRandom();
    }

    public boolean getDoneGrowing() {
        return doneGrowing;
    }

    @Override
    public boolean isHopper() {
        if (this.getLevel() != null && this.getLevel().getBlockState(this.getBlockPos()).getBlock() instanceof TieredBlockBotanyPot potBlock) {
            return potBlock.hasInventory();
        }

        return false;
    }

    @Override
    public boolean attemptAutoHarvest() {
        if (this.getLevel() != null && !this.getLevel().isClientSide && this.getCrop() != null) {
            final ContainerInventoryAccess<BotanyPotContainer> inventory = new ContainerInventoryAccess<>(this.getInventory());

            this.rng.setSeed(this.rngSeed);
            final List<ItemStack> drops = BotanyPotHelper.generateDrop(rng, this.level, this.getBlockPos(), this, this.getCrop());

            if (drops.isEmpty()) {
                return true;
            }

            boolean didCollect = false;

            for (ItemStack drop : drops) {
                if (!drop.isEmpty()) {
                    drop.setCount(drop.getCount() * tier.getMultiplier());

                    final int originalSize = drop.getCount();

                    for (int slot : BotanyPotContainer.STORAGE_SLOT) {
                        if (drop.isEmpty()) {
                            break;
                        }

                        drop = inventory.insert(slot, drop, Direction.UP, true, true);
                    }

                    if (drop.getCount() != originalSize) {
                        didCollect = true;
                    }
                }
            }

            return didCollect;
        }

        return false;
    }

    public static void tickPot(Level level, BlockPos pos, BlockState state, TieredBlockEntityBotanyPot pot) {
        // Don't try to update unloaded pots.
        if (pot.isRemoved() || pot.getLevel() == null) {
            return;
        }

        pot.getInventory().update();

        final Soil soil = pot.getSoil();
        final Crop crop = pot.getCrop();

        if (soil != null) {
            soil.onTick(level, pos, pot);
        }

        if (crop != null) {
            crop.onTick(level, pos, pot);
        }

        // Harvesting Logic
        if (pot.isHopper()) {
            if (pot.exportDelay > 0) {
                pot.exportDelay--;
            }

            if (pot.harvestDelay > 0) {
                pot.harvestDelay--;
            }

            if (pot.isCropHarvestable() && crop != null && pot.harvestDelay < 1) {
                if (pot.attemptAutoHarvest()) {
                    pot.resetGrowth();
                }

                // Wait at least 2.5 seconds before trying to harvest again.
                pot.harvestDelay = 50;
            }

            if (pot.exportDelay < 1) {
                pot.attemptExport();

                // Wait at least 0.5 second before trying to export items again.
                pot.exportDelay = 10;
            }
        }

        // Growth Logic
        if (soil != null && crop != null && pot.areGrowthConditionsMet()) {
            if (!pot.doneGrowing) {
                pot.growthTime += pot.tier.getSpeed();
                soil.onGrowthTick(level, pos, pot, crop);
                crop.onGrowthTick(level, pos, pot, soil);

                pot.prevComparatorLevel = pot.comparatorLevel;
                pot.comparatorLevel = Mth.floor(15f * ((float) pot.growthTime / pot.getInventory().getRequiredGrowthTime()));

                final boolean finishedGrowing = pot.growthTime >= pot.getInventory().getRequiredGrowthTime();

                if (pot.doneGrowing != finishedGrowing) {
                    pot.doneGrowing = finishedGrowing;
                    pot.markDirty();
                }
            }
        }

        else if (pot.growthTime != -1 || pot.doneGrowing || pot.comparatorLevel != 0) {
            pot.resetGrowth();
        }

        // Update Comparators if they need it.
        if (pot.comparatorLevel != pot.prevComparatorLevel) {
            pot.prevComparatorLevel = pot.comparatorLevel;
            pot.level.updateNeighbourForOutputSignal(pot.worldPosition, pot.getBlockState().getBlock());
        }
    }

    private void attemptExport() {
        if (this.getLevel() != null && !this.getLevel().isClientSide) {
            final IInventoryAccess exportTo = Services.INVENTORY_HELPER.getInventory(this.getLevel(), this.getBlockPos().below(), Direction.UP);

            if (exportTo != null) {
                for (int potSlotId : BotanyPotContainer.STORAGE_SLOT) {
                    final ItemStack potStack = this.getInventory().getItem(potSlotId);

                    if (!potStack.isEmpty()) {
                        for (int exportSlotId : exportTo.getAvailableSlots()) {
                            if (exportTo.insert(exportSlotId, potStack, Direction.UP, false).getCount() != potStack.getCount()) {
                                this.getInventory().setItem(potSlotId, exportTo.insert(exportSlotId, potStack, Direction.UP, true));
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("block.botanypotstiers." + tier.getName() + "_terracotta_botany_pot");
    }
}