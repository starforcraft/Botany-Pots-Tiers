package com.YTrollman.BotanyPotsTiers.events;

import com.YTrollman.BotanyPotsTiers.tileentity.TieredTileEntityBotanyPot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class TieredBotanyPotEvent extends Event {

    private final TieredTileEntityBotanyPot pot;

    public TieredBotanyPotEvent(TieredTileEntityBotanyPot pot) {

        this.pot = pot;
    }

    public TieredTileEntityBotanyPot getBotanyPot() {

        return this.pot;
    }

    public static class Player extends TieredBotanyPotEvent {

        @Nullable
        private final PlayerEntity player;

        public Player(TieredTileEntityBotanyPot pot, @Nullable PlayerEntity player) {

            super(pot);
            this.player = player;
        }

        @Nullable
        public PlayerEntity getPlayer() {

            return this.player;
        }
    }
}
