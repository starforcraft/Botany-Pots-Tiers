package com.ultramega.botanypotstiers.common.impl.item;

import com.ultramega.botanypotstiers.common.impl.BotanyPotsTiersMod;
import com.ultramega.botanypotstiers.common.impl.PotTier;
import com.ultramega.botanypotstiers.common.impl.block.TieredBotanyPotBlock;

import net.darkhax.botanypots.common.impl.block.BotanyPotBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class UpgradeItem extends Item {
    private final PotTier tier;

    public UpgradeItem(Properties properties, PotTier tier) {
        super(properties);
        this.tier = tier;
    }

    @Override
    public InteractionResult useOn(final UseOnContext context) {
        final Level level = context.getLevel();
        final BlockPos pos = context.getClickedPos();
        final BlockState state = level.getBlockState(pos);
        final Block block = state.getBlock();

        if (!(block instanceof BotanyPotBlock botanyPotBlock)) {
            return InteractionResult.FAIL;
        }

        PotTier targetTier = PotTier.ELITE;
        String baseName;

        if (block instanceof TieredBotanyPotBlock tieredPot) {
            PotTier nextTier = PotTier.getNext(tieredPot.getTier());
            if (nextTier == null || nextTier != tier) {
                return InteractionResult.FAIL;
            }
            targetTier = nextTier;
            baseName = BuiltInRegistries.BLOCK.getKey(botanyPotBlock)
                .getPath()
                .replaceFirst(tieredPot.getTier().getName() + "_", "");
        } else {
            if (tier != PotTier.ELITE) {
                return InteractionResult.FAIL;
            }
            baseName = BuiltInRegistries.BLOCK.getKey(botanyPotBlock).getPath();
        }

        final ResourceLocation newBlockId = BotanyPotsTiersMod.id(targetTier.getName() + "_" + baseName);
        final Block newBlock = BuiltInRegistries.BLOCK.get(newBlockId);

        // Save old BlockEntity data
        BlockEntity oldBlockEntity = level.getBlockEntity(pos);
        CompoundTag savedData = null;

        if (oldBlockEntity != null) {
            savedData = oldBlockEntity.saveWithFullMetadata(level.registryAccess());

            // Clear the container, so the contents won't be dropped and therefore duped
            if (oldBlockEntity instanceof Container container) {
                for(int i = 0; i < container.getContainerSize(); ++i) {
                    container.setItem(i, ItemStack.EMPTY);
                }
            }
        }

        level.setBlock(pos, newBlock.defaultBlockState(), Block.UPDATE_ALL);

        // Load saved data into new BlockEntity
        if (savedData != null) {
            BlockEntity newBlockEntity = level.getBlockEntity(pos);
            if (newBlockEntity != null) {
                newBlockEntity.loadWithComponents(savedData, level.registryAccess());
            }
        }

        context.getItemInHand().shrink(1);
        return InteractionResult.SUCCESS;
    }
}
