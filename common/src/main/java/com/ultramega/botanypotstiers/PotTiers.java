package com.ultramega.botanypotstiers;

public enum PotTiers {
    ELITE("elite", TieredBotanyPotsUtils.ELITE_BOTANY_POT_MULTIPLIER, TieredBotanyPotsUtils.ELITE_BOTANY_POT_SPEED),
    ULTRA("ultra", TieredBotanyPotsUtils.ULTRA_BOTANY_POT_MULTIPLIER, TieredBotanyPotsUtils.ULTRA_BOTANY_POT_SPEED),
    CREATIVE("creative", TieredBotanyPotsUtils.CREATIVE_BOTANY_POT_MULTIPLIER, TieredBotanyPotsUtils.CREATIVE_BOTANY_POT_SPEED);

    private final String name;
    private final int multiplier;
    private final int speed;

    PotTiers(String name, int multiplier, int speed) {
        this.name = name;
        this.multiplier = multiplier;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public int getSpeed() {
        return speed;
    }
}
