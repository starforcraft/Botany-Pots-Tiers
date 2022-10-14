package com.ultramega.botanypotstiers.events;

import com.ultramega.botanypotstiers.block.TieredBlockEntityBotanyPot;
import com.ultramega.botanypotstiers.data.recipes.soil.Soil;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.Cancelable;

import javax.annotation.Nullable;

@Cancelable
public class LookupSoilEvent extends TieredBotanyPotEvent {
    final ItemStack stack;
    @Nullable
    private final Soil original;
    @Nullable
    private Soil result;

    public LookupSoilEvent(Level level, BlockPos pos, TieredBlockEntityBotanyPot pot, ItemStack stack, Soil original) {
        super(level, pos, pot);
        this.stack = stack;
        this.original = original;
        this.result = original;
    }

    public ItemStack getStack() {
        return this.stack;
    }

    @Nullable
    public Soil getOriginal() {
        return this.original;
    }

    @Nullable
    public Soil getLookupResult() {
        return this.result;
    }

    public void setLookupResult(@Nullable Soil newResult) {
        this.result = newResult;
    }
}