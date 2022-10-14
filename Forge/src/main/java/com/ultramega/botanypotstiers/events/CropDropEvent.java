package com.ultramega.botanypotstiers.events;

import com.google.common.collect.ImmutableList;
import com.ultramega.botanypotstiers.block.TieredBlockEntityBotanyPot;
import com.ultramega.botanypotstiers.data.recipes.crop.Crop;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CropDropEvent extends TieredBotanyPotEvent {
    private final Random rng;
    private final Crop crop;
    private final List<ItemStack> originalDrops;
    private final List<ItemStack> drops;

    public CropDropEvent(Random rng, Level level, BlockPos pos, TieredBlockEntityBotanyPot pot, Crop crop, List<ItemStack> originalDrops) {
        super(level, pos, pot);
        this.rng = rng;
        this.crop = crop;
        this.originalDrops = ImmutableList.copyOf(originalDrops);
        this.drops = new ArrayList<>(originalDrops);
    }

    public Random getRandom() {
        return this.rng;
    }

    public Crop getCrop() {
        return this.crop;
    }

    public List<ItemStack> getOriginalDrops() {
        return this.originalDrops;
    }

    public List<ItemStack> getDrops() {
        return this.drops;
    }
}
