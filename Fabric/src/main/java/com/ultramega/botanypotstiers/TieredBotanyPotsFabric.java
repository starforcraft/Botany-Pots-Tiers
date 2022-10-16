package com.ultramega.botanypotstiers;

import com.ultramega.botanypotstiers.config.TieredBotanyPotsFabricConfig;

import net.fabricmc.api.ModInitializer;

public class TieredBotanyPotsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
    	TieredBotanyPotsFabricConfig.setupValues();
        new TieredBotanyPotsCommon();
    }
}