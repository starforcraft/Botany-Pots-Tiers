package com.ultramega.botanypotstiers.common.impl.config;

import net.darkhax.pricklemc.common.api.annotations.Value;

public class Config {
    @Value(comment = "Options related to the usage of botany pots.", writeDefault = false)
    public Gameplay gameplay = new Gameplay();

    @Value(comment = "Options related to various recipes in the game.", writeDefault = false)
    public Recipes recipes = new Recipes();
}