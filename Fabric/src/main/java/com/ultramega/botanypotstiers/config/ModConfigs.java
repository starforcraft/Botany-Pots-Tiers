package com.ultramega.botanypotstiers.config;

import com.mojang.datafixers.util.Pair;
import com.ultramega.botanypotstiers.Constants;
import com.ultramega.botanypotstiers.TieredBotanyPotsUtils;

public class ModConfigs {
    public static SimpleConfig CONFIG;
    private static ModConfigProvider configs;

    public static String TEST;
    public static int SOME_INT;
    public static double SOME_DOUBLE;
    public static int MAX_DAMAGE_DOWSING_ROD;

    public static void registerConfigs() {
        configs = new ModConfigProvider();
        createConfigs();
        
        CONFIG = SimpleConfig.of(Constants.MOD_ID + "-common").provider(configs).request();
        
        assignConfigs();
    }

    private static void createConfigs() {
        configs.addKeyValuePair(new Pair<>("elite.speed", 2), "Default: 2, Min: 2, Max 64");
        configs.addKeyValuePair(new Pair<>("elite.multiplier", 2), "Default: 2, Min: 2, Max 64");
    
        configs.addKeyValuePair(new Pair<>("ultra.speed", 6), "Default: 6, Min: 2, Max 64");
        configs.addKeyValuePair(new Pair<>("ultra.multiplier", 6), "Default: 6, Min: 2, Max 64");
    
        configs.addKeyValuePair(new Pair<>("creative.speed", 10), "Default: 10, Min: 2, Max 64");
        configs.addKeyValuePair(new Pair<>("creative.multiplier", 10), "Default: 10, Min: 2, Max 64");
    }

    private static void assignConfigs() {
		TieredBotanyPotsUtils.ELITE_MULTIPLIER = CONFIG.getOrDefault("elite.multiplier", 2);
		TieredBotanyPotsUtils.ELITE_SPEED = CONFIG.getOrDefault("elite.speed", 2);

		TieredBotanyPotsUtils.ULTRA_MULTIPLIER = CONFIG.getOrDefault("ultra.multiplier", 6);
		TieredBotanyPotsUtils.ULTRA_SPEED = CONFIG.getOrDefault("ultra.speed", 6);
		
		TieredBotanyPotsUtils.CREATIVE_MULTIPLIER = CONFIG.getOrDefault("creative.multiplier", 10);
		TieredBotanyPotsUtils.CREATIVE_SPEED = CONFIG.getOrDefault("creative.speed", 10);	

        Constants.LOG.warn("All " + configs.getConfigsList().size() + " have been set properly");
    }
}
