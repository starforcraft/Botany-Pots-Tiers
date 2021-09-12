package com.YTrollman.BotanyPotsTiers.events;

import com.YTrollman.BotanyPotsTiers.tileentity.TieredTileEntityBotanyPot;
import net.darkhax.botanypots.crop.CropInfo;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.eventbus.api.Cancelable;

import javax.annotation.Nullable;

/**
 * This class contains events that are fired on the Forge event bus when a player tries to
 * remove a crop from the Botany Pot.
 */
public class TieredCropRemovedEvent extends TieredBotanyPotEvent.Player {

    /**
     * The crop being removed.
     */
    protected final CropInfo crop;

    public TieredCropRemovedEvent(TieredTileEntityBotanyPot pot, @Nullable PlayerEntity player, CropInfo crop) {

        super(pot, player);
        this.crop = crop;
    }

    /**
     * Gets the crop being removed.
     *
     * @return The crop being removed.
     */
    public CropInfo getCrop () {

        return this.crop;
    }

    /**
     * This event is fired on the Forge event bus just before a player removes a crop from a
     * Botany Pot. Canceling this event will prevent the crop from being removed.
     */
    @Cancelable
    public static class Pre extends TieredCropRemovedEvent {

        public Pre(TieredTileEntityBotanyPot pot, PlayerEntity player, CropInfo crop) {

            super(pot, player, crop);
        }
    }

    /**
     * This event is fired on the Forge event bus just after a player removes a crop from a
     * Botany Pot.
     */
    public static class Post extends TieredCropRemovedEvent {

        public Post(TieredTileEntityBotanyPot pot, PlayerEntity player, CropInfo soil) {

            super(pot, player, soil);
        }
    }
}
