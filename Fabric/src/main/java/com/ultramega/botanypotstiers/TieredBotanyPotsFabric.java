package com.ultramega.botanypotstiers;

import net.fabricmc.api.ModInitializer;

public class TieredBotanyPotsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        new TieredBotanyPotsCommon();
    }
}