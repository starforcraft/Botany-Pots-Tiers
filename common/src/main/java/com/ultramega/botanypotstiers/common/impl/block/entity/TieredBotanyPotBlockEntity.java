package com.ultramega.botanypotstiers.common.impl.block.entity;

import com.ultramega.botanypotstiers.common.impl.BotanyPotsTiersMod;
import com.ultramega.botanypotstiers.common.impl.PotTier;

import net.darkhax.bookshelf.common.api.data.enchantment.EnchantmentLevel;
import net.darkhax.bookshelf.common.api.function.CachedSupplier;
import net.darkhax.bookshelf.common.api.service.Services;
import net.darkhax.botanypots.common.api.context.BlockEntityContext;
import net.darkhax.botanypots.common.api.data.recipes.crop.Crop;
import net.darkhax.botanypots.common.api.data.recipes.soil.Soil;
import net.darkhax.botanypots.common.impl.BotanyPotsMod;
import net.darkhax.botanypots.common.impl.Helpers;
import net.darkhax.botanypots.common.impl.block.PotType;
import net.darkhax.botanypots.common.impl.block.entity.BotanyPotBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;

public class TieredBotanyPotBlockEntity extends BotanyPotBlockEntity {
    private final PotTier tier;

    private int bonemealCooldown = 0;

    public TieredBotanyPotBlockEntity(BlockPos pos, BlockState state, PotTier tier) {
        super(getType(tier), pos, state);
        this.tier = tier;
    }

    public static void tickPot(Level level, BlockPos pos, BlockState state, TieredBotanyPotBlockEntity pot) {
        BotanyPotBlockEntity.tickPot(level, pos, state, pot);
        /*if (pot.isRemoved() || pot.level == null) {
            return;
        }
        if (pot.potType.get() == PotType.WAXED) {
            pot.growthTime.setTicks(Float.MAX_VALUE);
            return;
        }
        final BlockEntityContext context = pot.getRecipeContext();
        if (pot.bonemealCooldown > 0) {
            pot.bonemealCooldown--;
        }
        // Update soil
        final Soil soil = pot.getOrInvalidateSoil();
        if (soil != null) {
            soil.onTick(context, level);
        }
        // Update crop
        final Crop crop = pot.getOrInvalidateCrop();
        if (crop != null) {
            crop.onTick(context, level);
            if (pot.growCooldown.getTicks() > 0) {
                pot.growCooldown.tickDown(level);
            }
            if (pot.growCooldown.getTicks() <= 0 && crop.isGrowthSustained(context, level)) {
                for (int i = 0; i < pot.getTier().getSpeedMultiplier(); i++) {
                    pot.growthTime.tickUp(level);
                }
                crop.onGrowthTick(context, level);
                final int requiredGrowthTicks = Helpers.getRequiredGrowthTicks(pot.getRecipeContext(), pot.level, crop, soil);
                if (pot.growthTime.getTicks() >= requiredGrowthTicks) {
                    pot.updateComparatorLevel(15);
                    pot.growCooldown.setTicks(5f / pot.getTier().getSpeedMultiplier());
                    if (pot.isHopper() && crop.canHarvest(context, level)) {
                        if (level instanceof ServerLevel serverLevel) {
                            for (int i = 0; i < pot.getTier().getOutputMultiplier(); i++) {
                                crop.onHarvest(context, level, stack -> Services.GAMEPLAY.addItem(stack, pot.getItems(), BotanyPotBlockEntity.STORAGE_SLOTS));
                            }
                            if (BotanyPotsMod.CONFIG.get().gameplay.damage_harvest_tool && EnchantmentLevel.FIRST.get(Helpers.NEGATE_HARVEST_DAMAGE_TAG, pot.getHarvestItem()) <= 0) {
                                pot.getHarvestItem().hurtAndBreak(1, serverLevel, null, stack -> {
                                });
                            }
                            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(pot.getBlockState()));
                        }
                        pot.growthTime.reset();
                    }
                }
                else {
                    pot.updateComparatorLevel(Mth.ceil(14f * (pot.growthTime.getTicks() / requiredGrowthTicks)));
                }
            }
        }
        // Update Inventory
        if (pot.isHopper()) {
            pot.exportCooldown.tickDown(level);
            if (pot.exportCooldown.getTicks() <= 0) {
                if (level instanceof ServerLevel serverLevel && !serverLevel.getBlockState(pot.below.get()).isAir()) {
                    for (int slot : BotanyPotBlockEntity.STORAGE_SLOTS) {
                        final ItemStack stack = pot.getItem(slot);
                        if (!stack.isEmpty()) {
                            final ItemStack result = Services.GAMEPLAY.inventoryInsert(serverLevel, pot.below.get(), Direction.UP, stack);
                            pot.setItem(slot, result);
                        }
                    }
                }
                pot.exportCooldown.reset();
            }
        }*/
    }

    @Override
    public void reset() {
        super.reset();
        this.bonemealCooldown = 0;
    }

    @Override
    public boolean canBonemeal() {
        return this.bonemealCooldown <= 0;
    }

    @Override
    public void setBonemealCooldown(final int cooldown) {
        this.bonemealCooldown = cooldown;
    }

    @Override
    public void loadAdditional(@NotNull CompoundTag tag, @NotNull HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        this.bonemealCooldown = tag.getInt("bonemeal_cooldown");
    }

    @Override
    public void saveAdditional(@NotNull CompoundTag tag, @NotNull HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.putInt("bonemeal_cooldown", this.bonemealCooldown);
    }

    public static CachedSupplier<BlockEntityType<BotanyPotBlockEntity>> getType(PotTier tier) {
        return CachedSupplier.of(BuiltInRegistries.BLOCK_ENTITY_TYPE, BotanyPotsTiersMod.id(tier.getName() + "_botany_pot")).cast();
    }
}
