package com.YTrollman.BotanyPotsTiers.events;

import com.YTrollman.BotanyPotsTiers.tileentity.TieredTileEntityBotanyPot;

/**
 * These events are fired on the Forge event bus when a botany pot ticks.
 */
public class TieredBotanyPotTickEvent extends TieredBotanyPotEvent {

    public TieredBotanyPotTickEvent(TieredTileEntityBotanyPot pot) {

        super(pot);
    }

    /**
     * This event is fired on the Forge event bus just before the botany pot begins it's tick.
     */
    public static class Pre extends TieredBotanyPotTickEvent {

        public Pre(TieredTileEntityBotanyPot pot) {

            super(pot);
        }
    }

    /**
     * This event is fired on the Forge event bus just after the botany pot finishes it's tick.
     */
    public static class Post extends TieredBotanyPotTickEvent {

        public Post(TieredTileEntityBotanyPot pot) {

            super(pot);
        }
    }
}
