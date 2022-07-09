package com.YTrollman.BotanyPotsTiers.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class BotanyPotsTiersConfig {
    public static ForgeConfigSpec.IntValue ELITE_BOTANY_POT_SPEED;
    public static ForgeConfigSpec.IntValue ULTRA_BOTANY_POT_SPEED;
    public static ForgeConfigSpec.IntValue CREATIVE_BOTANY_POT_SPEED;

    public static ForgeConfigSpec.IntValue ELITE_BOTANY_POT_MULTIPLIER;
    public static ForgeConfigSpec.IntValue ULTRA_BOTANY_POT_MULTIPLIER;
    public static ForgeConfigSpec.IntValue CREATIVE_BOTANY_POT_MULTIPLIER;

    public static void init(ForgeConfigSpec.Builder builder) {
        builder.comment("Botany Pots Tiers Options");

        ELITE_BOTANY_POT_SPEED = builder.comment("\nElite Botany Pot Speed").defineInRange("eliteBotanyPotSpeed", 2, 1, Integer.MAX_VALUE);
        ULTRA_BOTANY_POT_SPEED = builder.comment("\nUltra Botany Pot Speed").defineInRange("ultraBotanyPotSpeed", 6, 1, Integer.MAX_VALUE);
        CREATIVE_BOTANY_POT_SPEED = builder.comment("\nCreative Botany Pot Speed").defineInRange("creativeBotanyPotSpeed", 10, 1, Integer.MAX_VALUE);

        ELITE_BOTANY_POT_MULTIPLIER = builder.comment("\nElite Botany Pot Multiplier").defineInRange("eliteBotanyPotMultiplier", 2, 1, Integer.MAX_VALUE);
        ULTRA_BOTANY_POT_MULTIPLIER = builder.comment("\nUltra Botany Pot Multiplier").defineInRange("ultraBotanyPotMultiplier", 6, 1, Integer.MAX_VALUE);
        CREATIVE_BOTANY_POT_MULTIPLIER = builder.comment("\nCreative Botany Pot Multiplier").defineInRange("creativeBotanyPotMultiplier", 10, 1, Integer.MAX_VALUE);

        builder.build();
    }
}
