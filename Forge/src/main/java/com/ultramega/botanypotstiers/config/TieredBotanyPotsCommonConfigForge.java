package com.ultramega.botanypotstiers.config;

import com.ultramega.botanypotstiers.TieredBotanyPotsUtils;

import net.minecraftforge.common.ForgeConfigSpec;

public class TieredBotanyPotsCommonConfigForge {

	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;

	//Elite
	public static final ForgeConfigSpec.IntValue ELITE_SPEED;
	public static final ForgeConfigSpec.IntValue ELITE_MULTIPLIER;

	//Ultra
	public static final ForgeConfigSpec.IntValue ULTRA_SPEED;
	public static final ForgeConfigSpec.IntValue ULTRA_MULTIPLIER;

	//Creative
	public static final ForgeConfigSpec.IntValue CREATIVE_SPEED;
	public static final ForgeConfigSpec.IntValue CREATIVE_MULTIPLIER;
	
	static {
		BUILDER.push("Configs for Tiered Botany Pots");

		//Elite
		ELITE_SPEED = BUILDER.comment("Define the speed of crop growth of the tier 1 botany pot")
				.defineInRange("Elite Speed", 2, 2, 64);
		ELITE_MULTIPLIER = BUILDER.comment("Define the speed of crop growth of the tier 1 botany pot")
				.defineInRange("Elite Multiplier", 2, 2, 64);
		
		//Ultra
		ULTRA_SPEED = BUILDER.comment("Define the speed of crop growth of the tier 1 botany pot")
				.defineInRange("Ultra 2 Speed", 6, 2, 64);
		ULTRA_MULTIPLIER = BUILDER.comment("Define the speed of crop growth of the tier 1 botany pot")
				.defineInRange("Ultra Multiplier", 6, 2, 64);
		
		//Creative
		CREATIVE_SPEED = BUILDER.comment("Define the speed of crop growth of the tier 1 botany pot")
				.defineInRange("Creative Speed", 10, 2, 64);
		CREATIVE_MULTIPLIER = BUILDER.comment("Define the speed of crop growth of the tier 1 botany pot")
				.defineInRange("Creative Multiplier", 10, 2, 64);
		
		BUILDER.pop();
		SPEC = BUILDER.build();
	}

	public static void setupValues() {
		TieredBotanyPotsUtils.ELITE_MULTIPLIER = ELITE_MULTIPLIER.get();
		TieredBotanyPotsUtils.ELITE_SPEED = ELITE_SPEED.get();

		TieredBotanyPotsUtils.ULTRA_MULTIPLIER = ULTRA_MULTIPLIER.get();
		TieredBotanyPotsUtils.ULTRA_SPEED = ULTRA_SPEED.get();
		
		TieredBotanyPotsUtils.CREATIVE_MULTIPLIER = CREATIVE_MULTIPLIER.get();
		TieredBotanyPotsUtils.CREATIVE_SPEED = CREATIVE_SPEED.get();	
	}

}
