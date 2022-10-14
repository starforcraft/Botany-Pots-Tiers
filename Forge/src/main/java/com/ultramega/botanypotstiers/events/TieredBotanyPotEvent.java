package com.ultramega.botanypotstiers.events;

import com.ultramega.botanypotstiers.block.TieredBlockEntityBotanyPot;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.Event;

public class TieredBotanyPotEvent extends Event {
    private final Level level;
    private final BlockPos pos;
    private final TieredBlockEntityBotanyPot pot;

    public TieredBotanyPotEvent(Level level, BlockPos pos, TieredBlockEntityBotanyPot pot) {
        this.level = level;
        this.pos = pos;
        this.pot = pot;
    }

    public Level getLevel() {
        return this.level;
    }

    public BlockPos getPos() {
        return this.pos;
    }

    public TieredBlockEntityBotanyPot getPot() {
        return this.pot;
    }
}