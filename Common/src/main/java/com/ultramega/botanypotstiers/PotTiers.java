package com.ultramega.botanypotstiers;

public enum PotTiers {
    ELITE("elite", TieredBotanyPotsUtils.ELITE_MULTIPLIER, TieredBotanyPotsUtils.ELITE_SPEED),
    ULTRA("ultra", TieredBotanyPotsUtils.ULTRA_MULTIPLIER, TieredBotanyPotsUtils.ULTRA_SPEED),
    CREATIVE("creative", TieredBotanyPotsUtils.CREATIVE_MULTIPLIER, TieredBotanyPotsUtils.CREATIVE_SPEED);

    private final String name;
    private final int multiplier;
    private final int speed;

    PotTiers(String name, int multiplier, int speed) {
        this.name = name;
        this.multiplier = multiplier;
        this.speed = speed;
        System.out.println("Created pot" + getName() + " with speed " + getSpeed() + "with multiplier " + getMultiplier());
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
