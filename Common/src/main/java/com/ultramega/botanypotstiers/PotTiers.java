package com.ultramega.botanypotstiers;

public enum PotTiers {
    ELITE("elite", 2, 2),
    ULTRA("ultra", 6, 6),
    CREATIVE("creative", 10, 10);

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
