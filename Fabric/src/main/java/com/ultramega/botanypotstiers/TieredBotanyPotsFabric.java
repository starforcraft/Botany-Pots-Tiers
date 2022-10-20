package com.ultramega.botanypotstiers;

import com.ultramega.botanypotstiers.config.ModConfigs;
import net.fabricmc.api.ModInitializer;

public class TieredBotanyPotsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ModConfigs.registerConfigs();
        new TieredBotanyPotsCommon();
    }
}