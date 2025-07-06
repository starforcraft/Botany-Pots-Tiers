package com.ultramega.botanypotstiers.fabric.impl;

import com.ultramega.botanypotstiers.common.impl.BotanyPotsTiersMod;
import net.fabricmc.api.ModInitializer;

public class FabricMod implements ModInitializer {
    @Override
    public void onInitialize() {
        new BotanyPotsTiersMod();
    }
}