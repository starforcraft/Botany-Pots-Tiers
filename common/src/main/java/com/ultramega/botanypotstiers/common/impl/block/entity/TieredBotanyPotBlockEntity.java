package com.ultramega.botanypotstiers.common.impl.block.entity;

import com.ultramega.botanypotstiers.common.impl.BotanyPotsTiersMod;
import com.ultramega.botanypotstiers.common.impl.PotTier;

import net.darkhax.bookshelf.common.api.function.CachedSupplier;
import net.darkhax.botanypots.common.impl.block.entity.BotanyPotBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class TieredBotanyPotBlockEntity extends BotanyPotBlockEntity {
    private final PotTier tier;

    public TieredBotanyPotBlockEntity(BlockPos pos, BlockState state, PotTier tier) {
        super(getType(tier), pos, state);
        this.tier = tier;
    }

    public static void tickPot(Level level, BlockPos pos, BlockState state, TieredBotanyPotBlockEntity pot) {
        BotanyPotBlockEntity.tickPot(level, pos, state, pot);
    }

    public static CachedSupplier<BlockEntityType<BotanyPotBlockEntity>> getType(PotTier tier) {
        return CachedSupplier.of(BuiltInRegistries.BLOCK_ENTITY_TYPE, BotanyPotsTiersMod.id(tier.getName() + "_botany_pot")).cast();
    }
}
