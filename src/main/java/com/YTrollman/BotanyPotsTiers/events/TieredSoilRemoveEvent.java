package com.YTrollman.BotanyPotsTiers.events;

import com.YTrollman.BotanyPotsTiers.tileentity.TieredTileEntityBotanyPot;
import net.darkhax.botanypots.soil.SoilInfo;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.eventbus.api.Cancelable;

import javax.annotation.Nullable;

/**
 * This class contains events that are fired when a player attempts to remove soil from the
 * pot.
 */
public class TieredSoilRemoveEvent extends TieredBotanyPotEvent.Player {

    /**
     * The soil being removed.
     */
    private final SoilInfo soil;

    public TieredSoilRemoveEvent(TieredTileEntityBotanyPot pot, SoilInfo soil, @Nullable PlayerEntity player) {

        super(pot, player);
        this.soil = soil;
    }

    /**
     * Gets the soil being removed.
     *
     * @return The soil being removed.
     */
    public SoilInfo getSoil () {

        return this.soil;
    }

    /**
     * This event is fired on the Forge event bus just before a player removes a soil from the
     * pot. Canceling this event will prevent the soil from being removed.
     */
    @Cancelable
    public static class Pre extends TieredSoilRemoveEvent {

        public Pre(TieredTileEntityBotanyPot pot, SoilInfo soil, PlayerEntity player) {

            super(pot, soil, player);
        }
    }

    /**
     * This event is fired on the Forge event bus after a player removes soil from the pot.
     */
    public static class Post extends TieredSoilRemoveEvent {

        public Post(TieredTileEntityBotanyPot pot, SoilInfo soil, PlayerEntity player) {

            super(pot, soil, player);
        }
    }
}
