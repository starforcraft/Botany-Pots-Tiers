package com.ultramega.botanypotstiers.common.impl.config;

import com.ultramega.botanypotstiers.common.impl.BotanyPotsTiersMod;

import java.util.function.Supplier;

import net.darkhax.bookshelf.common.api.function.CachedSupplier;
import net.darkhax.pricklemc.common.api.annotations.Value;
import net.darkhax.pricklemc.common.api.config.ConfigManager;

public class Config {
    public static final Supplier<Config> INSTANCE = CachedSupplier.cache(() -> ConfigManager.load(BotanyPotsTiersMod.MOD_ID, new Config()));

    @Value(comment = "Options related to the usage of botany pots.", writeDefault = false)
    public Gameplay gameplay = new Gameplay();

    @Value(comment = "Options related to various recipes in the game.", writeDefault = false)
    public Recipes recipes = new Recipes();
}