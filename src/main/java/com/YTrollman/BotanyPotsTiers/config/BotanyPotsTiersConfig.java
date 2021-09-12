package com.YTrollman.BotanyPotsTiers.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class BotanyPotsTiersConfig {

    public static ForgeConfigSpec.IntValue UNIVERSAL_GRID_CAPACITY;

    public static void init(ForgeConfigSpec.Builder builder) {

        builder.comment("Botany Pots Tiers Options");

        UNIVERSAL_GRID_CAPACITY = builder
            		.comment("\nUniversal Grid Capacity")
                    .defineInRange("universalGridCapacity", 3200, 1, Integer.MAX_VALUE);

        builder.build();
    }
}
