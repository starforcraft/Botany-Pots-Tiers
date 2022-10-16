package com.ultramega.botanypotstiers.config;

import com.ultramega.botanypotstiers.Constants;
import com.ultramega.botanypotstiers.TieredBotanyPotsUtils;

public class TieredBotanyPotsFabricConfig {

	//Elite
	public static int ELITE_SPEED;
	public static int ELITE_MULTIPLIER;

	//Ultra
	public static int ULTRA_SPEED;
	public static int ULTRA_MULTIPLIER;

	//CreativE
	public static int CREATIVE_SPEED;
	public static int CREATIVE_MULTIPLIER;
	
	static SimpleConfig CONFIG = SimpleConfig.of(Constants.MOD_ID + "-common").provider(TieredBotanyPotsFabricConfig::provider).request();
	
	private static String provider(String filename) {
		return "#My default config content\n";
	}

	public static void setupValues() {
		TieredBotanyPotsUtils.ELITE_MULTIPLIER = CONFIG.getOrDefault("elite.multiplier", 2);
		TieredBotanyPotsUtils.ELITE_SPEED = CONFIG.getOrDefault("elite.speed", 2);
		
		TieredBotanyPotsUtils.ULTRA_MULTIPLIER = CONFIG.getOrDefault("ultra.multipler", 6);
		TieredBotanyPotsUtils.ULTRA_SPEED = CONFIG.getOrDefault("ultra.speed", 6);

		TieredBotanyPotsUtils.CREATIVE_MULTIPLIER = CONFIG.getOrDefault("creative.multiplier", 10);
		TieredBotanyPotsUtils.CREATIVE_SPEED = CONFIG.getOrDefault("creative.speed", 10);
	}

}
