package com.ultramega.botanypotstiers.common.impl;

import org.jetbrains.annotations.Nullable;

public enum PotTier {
    ELITE("elite"),
    ULTRA("ultra"),
    MEGA("mega");

    private final String name;

    PotTier(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getOutputMultiplier() {
        return switch (this) {
            case ELITE -> BotanyPotsTiersMod.CONFIG.get().gameplay.elite_botany_pot_output_multiplier;
            case ULTRA -> BotanyPotsTiersMod.CONFIG.get().gameplay.ultra_botany_pot_output_multiplier;
            case MEGA -> BotanyPotsTiersMod.CONFIG.get().gameplay.mega_botany_pot_output_multiplier;
        };
    }

    public int getSpeedMultiplier() {
        return switch (this) {
            case ELITE -> BotanyPotsTiersMod.CONFIG.get().gameplay.elite_botany_pot_speed_multiplier;
            case ULTRA -> BotanyPotsTiersMod.CONFIG.get().gameplay.ultra_botany_pot_speed_multiplier;
            case MEGA -> BotanyPotsTiersMod.CONFIG.get().gameplay.mega_botany_pot_speed_multiplier;
        };
    }

    @Nullable
    public static PotTier getPrevious(PotTier current) {
        PotTier[] values = PotTier.values();
        int index = current.ordinal() - 1;
        if (index < 0) {
            return null;
        }
        return values[index];
    }

    @Nullable
    public static PotTier getNext(PotTier current) {
        PotTier[] values = PotTier.values();
        int index = current.ordinal() + 1;
        if (index > values.length - 1) {
            return null;
        }
        return values[index];
    }
}
