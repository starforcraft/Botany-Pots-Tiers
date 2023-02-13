package com.ultramega.botanypotstiers.config;

import com.ultramega.botanypotstiers.TieredBotanyPotsUtils;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.Builder;

public class TieredBotanyPotsConfigForge {
    public static ForgeConfigSpec.IntValue ELITE_BOTANY_POT_SPEED;
    public static ForgeConfigSpec.IntValue ELITE_BOTANY_POT_MULTIPLIER;

    public static ForgeConfigSpec.IntValue ULTRA_BOTANY_POT_SPEED;
    public static ForgeConfigSpec.IntValue ULTRA_BOTANY_POT_MULTIPLIER;

    public static ForgeConfigSpec.IntValue CREATIVE_BOTANY_POT_SPEED;
    public static ForgeConfigSpec.IntValue CREATIVE_BOTANY_POT_MULTIPLIER;

    public static void init(Builder builder) {
        builder.push("Botany Pots Tiers Options");

        ELITE_BOTANY_POT_SPEED = builder.comment("\nElite Botany Pot Speed").defineInRange("eliteBotanyPotSpeed", 2, 1, Integer.MAX_VALUE);
        ELITE_BOTANY_POT_MULTIPLIER = builder.comment("\nElite Botany Pot Multiplier").defineInRange("eliteBotanyPotMultiplier", 2, 1, Integer.MAX_VALUE);

        ULTRA_BOTANY_POT_SPEED = builder.comment("\nUltra Botany Pot Speed").defineInRange("ultraBotanyPotSpeed", 6, 1, Integer.MAX_VALUE);
        ULTRA_BOTANY_POT_MULTIPLIER = builder.comment("\nUltra Botany Pot Multiplier").defineInRange("ultraBotanyPotMultiplier", 6, 1, Integer.MAX_VALUE);

        CREATIVE_BOTANY_POT_SPEED = builder.comment("\nCreative Botany Pot Speed").defineInRange("creativeBotanyPotSpeed", 10, 1, Integer.MAX_VALUE);
        CREATIVE_BOTANY_POT_MULTIPLIER = builder.comment("\nCreative Botany Pot Multiplier").defineInRange("creativeBotanyPotMultiplier", 10, 1, Integer.MAX_VALUE);

        builder.build();
    }

    public static void setupValues() {
        TieredBotanyPotsUtils.ELITE_BOTANY_POT_MULTIPLIER = ELITE_BOTANY_POT_MULTIPLIER.get();
        TieredBotanyPotsUtils.ELITE_BOTANY_POT_SPEED = ELITE_BOTANY_POT_SPEED.get();

        TieredBotanyPotsUtils.ULTRA_BOTANY_POT_MULTIPLIER = ULTRA_BOTANY_POT_MULTIPLIER.get();
        TieredBotanyPotsUtils.ULTRA_BOTANY_POT_SPEED = ULTRA_BOTANY_POT_SPEED.get();

        TieredBotanyPotsUtils.CREATIVE_BOTANY_POT_MULTIPLIER = CREATIVE_BOTANY_POT_MULTIPLIER.get();
        TieredBotanyPotsUtils.CREATIVE_BOTANY_POT_SPEED = CREATIVE_BOTANY_POT_SPEED.get();
    }
}