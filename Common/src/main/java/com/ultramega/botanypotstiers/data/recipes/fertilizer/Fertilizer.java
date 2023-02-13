package com.ultramega.botanypotstiers.data.recipes.fertilizer;

import com.ultramega.botanypotstiers.TieredBotanyPotHelper;
import com.ultramega.botanypotstiers.block.TieredBlockEntityBotanyPot;
import net.darkhax.bookshelf.api.data.recipes.RecipeBaseData;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public abstract class Fertilizer extends RecipeBaseData<Container> {
    public Fertilizer(ResourceLocation id) {
        super(id);
    }

    public abstract boolean canApply(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, ItemStack heldStack, TieredBlockEntityBotanyPot pot);

    public abstract void apply(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, ItemStack heldStack, TieredBlockEntityBotanyPot pot);

    @Override
    public RecipeType<?> getType() {
        return TieredBotanyPotHelper.FERTILIZER_TYPE.get();
    }
}
