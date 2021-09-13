package com.YTrollman.BotanyPotsTiers.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class BotanyPotsTiersConfig {

    public static ForgeConfigSpec.IntValue ELITE_BOTANY_POT_SPEED_OUTPUT;
    public static ForgeConfigSpec.IntValue ULTRA_BOTANY_POT_SPEED_OUTPUT;
    public static ForgeConfigSpec.IntValue CREATIVE_BOTANY_POT_SPEED_OUTPUT;

    public static void init(ForgeConfigSpec.Builder builder) {

        builder.comment("Botany Pots Tiers Options");

        ELITE_BOTANY_POT_SPEED_OUTPUT = builder
            		.comment("\nElite Botany Pot Speed & OUtput")
                    .defineInRange("eliteBotanyPotSpeedOutput", 2, 1, Integer.MAX_VALUE);
        ULTRA_BOTANY_POT_SPEED_OUTPUT = builder
                .comment("\nUltra Botany Pot Speed & Output")
                .defineInRange("ultraBotanyPotSpeedOutput", 6, 1, Integer.MAX_VALUE);
        CREATIVE_BOTANY_POT_SPEED_OUTPUT = builder
                .comment("\nCreative Botany Pot Speed & Output")
                .defineInRange("creativeBotanyPotSpeedOutput", 10, 1, Integer.MAX_VALUE);

        builder.build();
    }
}
