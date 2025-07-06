package com.ultramega.botanypotstiers.common.impl.config;

import net.darkhax.pricklemc.common.api.annotations.Value;

public class Gameplay {
    @Value(comment = "The speed multiplier of the elite botany pot. Increasing this value will make crops grow faster.")
    public int elite_botany_pot_speed_multiplier = 2;
    @Value(comment = "The output multiplier of the elite botany pot. Increasing this value will make more crops drop.")
    public int elite_botany_pot_output_multiplier = 2;

    @Value(comment = "The speed multiplier of the ultra botany pot. Increasing this value will make crops grow faster.")
    public int ultra_botany_pot_speed_multiplier = 6;
    @Value(comment = "The output multiplier of the ultra botany pot. Increasing this value will make more crops drop.")
    public int ultra_botany_pot_output_multiplier = 3;

    @Value(comment = "The speed multiplier of the mega botany pot. Increasing this value will make crops grow faster.")
    public int mega_botany_pot_speed_multiplier = 10;
    @Value(comment = "The output multiplier of the mega botany pot. Increasing this value will make more crops drop.")
    public int mega_botany_pot_output_multiplier = 4;
}