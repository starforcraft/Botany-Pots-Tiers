package com.ultramega.botanypotstiers.events;

import com.ultramega.botanypotstiers.block.TieredBlockEntityBotanyPot;
import com.ultramega.botanypotstiers.data.recipes.crop.Crop;
import com.ultramega.botanypotstiers.data.recipes.fertilizer.Fertilizer;
import com.ultramega.botanypotstiers.data.recipes.potinteraction.PotInteraction;
import com.ultramega.botanypotstiers.data.recipes.soil.Soil;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public interface TieredBotanyPotEventDispatcher {
    @Nullable
    Soil postSoilLookup(Level level, BlockPos pos, TieredBlockEntityBotanyPot pot, ItemStack stack, @Nullable Soil found);

    void listenSoilLookup(ILookupSoilListener listener);

    @Nullable
    Crop postCropLookup(Level level, BlockPos pos, TieredBlockEntityBotanyPot pot, ItemStack stack, @Nullable Crop found);

    void listenCropLookup(ILookupCropListener listener);

    @Nullable
    PotInteraction postInteractionLookup(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, ItemStack heldStack, TieredBlockEntityBotanyPot pot, PotInteraction found);

    void listenInteractionLookup(ILookupInteractionListener listener);

    @Nullable
    Fertilizer postFertilizerLookup(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, ItemStack heldStack, TieredBlockEntityBotanyPot pot, Fertilizer found);

    void listenFertilizerLookup(ILookupFertilizerListener listener);

    List<ItemStack> postCropDrops(Random rng, Level level, BlockPos pos, TieredBlockEntityBotanyPot pot, Crop crop, List<ItemStack> originalDrops);

    void listenCropDrops(ICropDropListener listener);
}