package com.ultramega.botanypotstiers.events;

import com.ultramega.botanypotstiers.block.TieredBlockEntityBotanyPot;
import com.ultramega.botanypotstiers.data.recipes.crop.Crop;
import com.ultramega.botanypotstiers.data.recipes.fertilizer.Fertilizer;
import com.ultramega.botanypotstiers.data.recipes.potinteraction.PotInteraction;
import com.ultramega.botanypotstiers.data.recipes.soil.Soil;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class TieredBotanyPotEventDispatcherFabric implements BotanyPotEventDispatcher {
    public static final Event<ILookupCropListener> LOOKUP_CROP = EventFactory.createArrayBacked(ILookupCropListener.class, callbacks -> (level, pos, pot, stack, found) -> {
        Crop result = found;

        for (ILookupCropListener listener : callbacks) {
            result = listener.lookup(level, pos, pot, stack, found);
        }

        return result;
    });

    public static final Event<ILookupSoilListener> LOOKUP_SOIL = EventFactory.createArrayBacked(ILookupSoilListener.class, callbacks -> (level, pos, pot, stack, found) -> {
        Soil result = found;

        for (ILookupSoilListener listener : callbacks) {
            result = listener.lookup(level, pos, pot, stack, found);
        }

        return result;
    });

    public static final Event<ILookupInteractionListener> LOOKUP_INTERACTION = EventFactory.createArrayBacked(ILookupInteractionListener.class, callbacks -> (state, level, pos, player, hand, stack, pot, found) -> {
        PotInteraction result = found;

        for (ILookupInteractionListener listener : callbacks) {
            result = listener.lookup(state, level, pos, player, hand, stack, pot, found);
        }

        return result;
    });

    public static final Event<ILookupFertilizerListener> LOOKUP_FERTILIZER = EventFactory.createArrayBacked(ILookupFertilizerListener.class, callbacks -> (state, level, pos, player, hand, stack, pot, found) -> {
        Fertilizer result = found;

        for (ILookupFertilizerListener listener : callbacks) {
            result = listener.lookup(state, level, pos, player, hand, stack, pot, found);
        }

        return result;
    });

    public static final Event<ICropDropListener> CROP_DROPS = EventFactory.createArrayBacked(ICropDropListener.class, callbacks -> ((rng, level, pos, pot, crop, originalDrops, drops) -> {
        for (ICropDropListener listener : callbacks) {
            listener.generateDrop(rng, level, pos, pot, crop, originalDrops, drops);
        }
    }));

    @Nullable
    @Override
    public Soil postSoilLookup(Level level, BlockPos pos, TieredBlockEntityBotanyPot pot, ItemStack stack, @Nullable Soil found) {
        return LOOKUP_SOIL.invoker().lookup(level, pos, pot, stack, found);
    }

    @Override
    public void listenSoilLookup(ILookupSoilListener listener) {
        LOOKUP_SOIL.register(listener);
    }

    @Nullable
    @Override
    public Crop postCropLookup(Level level, BlockPos pos, TieredBlockEntityBotanyPot pot, ItemStack stack, @Nullable Crop found) {
        return LOOKUP_CROP.invoker().lookup(level, pos, pot, stack, found);
    }

    @Override
    public void listenCropLookup(ILookupCropListener listener) {
        LOOKUP_CROP.register(listener);
    }

    @Nullable
    @Override
    public PotInteraction postInteractionLookup(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, ItemStack heldStack, TieredBlockEntityBotanyPot pot, PotInteraction found) {
        return LOOKUP_INTERACTION.invoker().lookup(state, level, pos, player, hand, heldStack, pot, found);
    }

    @Override
    public void listenInteractionLookup(ILookupInteractionListener listener) {
        LOOKUP_INTERACTION.register(listener);
    }

    @Nullable
    @Override
    public Fertilizer postFertilizerLookup(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, ItemStack heldStack, TieredBlockEntityBotanyPot pot, Fertilizer found) {
        return LOOKUP_FERTILIZER.invoker().lookup(state, level, pos, player, hand, heldStack, pot, found);
    }

    @Override
    public void listenFertilizerLookup(ILookupFertilizerListener listener) {
        LOOKUP_FERTILIZER.register(listener);
    }

    @Override
    public List<ItemStack> postCropDrops(Random rng, Level level, BlockPos pos, TieredBlockEntityBotanyPot pot, Crop crop, List<ItemStack> originalDrops) {
        final List<ItemStack> drops = NonNullList.create();
        drops.addAll(originalDrops);
        CROP_DROPS.invoker().generateDrop(rng, level, pos, pot, crop, originalDrops, drops);
        return drops;
    }

    @Override
    public void listenCropDrops(ICropDropListener listener) {
        CROP_DROPS.register(listener);
    }
}
