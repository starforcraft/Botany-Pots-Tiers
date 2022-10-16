package com.ultramega.botanypotstiers.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class TieredBotanyPotsClientConfigForge {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	
	static {
		BUILDER.push("Configs for Tiered Botany Pots");
		
		//MADE FOR CLIENT CONFIGURATION DOWN THE ROAD (ENABLE/DISABLE CROP GROWTH VISUALIZATION UPDATES)
		
		BUILDER.pop();
		SPEC = BUILDER.build();
	}
	
	
}
