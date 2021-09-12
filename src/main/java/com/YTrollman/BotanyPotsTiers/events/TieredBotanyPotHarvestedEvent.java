package com.YTrollman.BotanyPotsTiers.events;

import com.YTrollman.BotanyPotsTiers.tileentity.TieredTileEntityBotanyPot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.eventbus.api.Cancelable;

import javax.annotation.Nullable;
import java.util.List;

/**
 * This class contains events that are fired on the Forge event bus when a botany pot is
 * harvested.
 */
public class TieredBotanyPotHarvestedEvent extends TieredBotanyPotEvent {

    /**
     * The player harvesting the pot. This will be null in cases like the hopper pot.
     */
    @Nullable
    private final PlayerEntity harvester;

    public TieredBotanyPotHarvestedEvent(TieredTileEntityBotanyPot pot, PlayerEntity harvester) {

        super(pot);
        this.harvester = harvester;
    }

    /**
     * Gets the player harvesting the pot. This will be null in cases like auto-harvesting with
     * a hopper pot.
     *
     * @return The player harvesting the pot.
     */
    @Nullable
    public PlayerEntity getHarvestingPlayer() {

        return this.harvester;
    }

    /**
     * This event is fired on the Forge event bus just before the pot has been harvested.
     * Canceling this event will prevent the pot from being harvested.
     */
    @Cancelable
    public static class Pre extends TieredBotanyPotHarvestedEvent {

        public Pre(TieredTileEntityBotanyPot pot, PlayerEntity harvester) {

            super(pot, harvester);
        }
    }

    /**
     * This event is fired on the Forge event bus when the harvest loot is being generated.
     */
    @Cancelable
    public static class LootGenerated extends TieredBotanyPotHarvestedEvent {

        /**
         * The loot that will be dropped by the pot.
         */
        private final List<ItemStack> drops;

        public LootGenerated(TieredTileEntityBotanyPot pot, PlayerEntity harvester, List<ItemStack> drops) {

            super(pot, harvester);
            this.drops = drops;
        }

        /**
         * Gets the loot dropped by the pot. This is a mutable list.
         *
         * @return The loot dropped by the pot.
         */
        public List<ItemStack> getDrops() {

            return this.drops;
        }
    }

    /**
     * This event is fired on the Forge event bus just after a botany pot has been harvested.
     */
    public static class Post extends TieredBotanyPotHarvestedEvent {

        public Post(TieredTileEntityBotanyPot pot, PlayerEntity harvester) {

            super(pot, harvester);
        }
    }
}
