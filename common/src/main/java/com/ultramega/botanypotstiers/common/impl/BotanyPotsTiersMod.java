package com.ultramega.botanypotstiers.common.impl;

import com.ultramega.botanypotstiers.common.impl.config.Config;

import net.darkhax.pricklemc.common.api.config.ConfigManager;
import net.darkhax.pricklemc.common.api.util.CachedSupplier;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BotanyPotsTiersMod {
    public static final String MOD_ID = "botanypotstiers";
    public static final String MOD_NAME = "BotanyPotsTiers";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);
    public static final CachedSupplier<Config> CONFIG = CachedSupplier.cache(() -> ConfigManager.load(MOD_ID, new Config()));

    public static ResourceLocation id(String path) {
        return ResourceLocation.tryBuild(MOD_ID, path);
    }

    public BotanyPotsTiersMod() {

    }
}