package com.ultramega.botanypotstiers.common.impl.config;

import net.darkhax.pricklemc.common.api.annotations.Value;

public class Recipes {
    @Value(comment = "Determines if elite basic botany pots may be crafted.")
    public boolean craft_elite_basic_pots = true;
    @Value(comment = "Determines if elite hopper pots may be crafted.")
    public boolean craft_elite_hopper_pots = true;
    @Value(comment = "Determines if elite wax pots may be crafted.")
    public boolean craft_elite_wax_pots = true;

    @Value(comment = "Determines if ultra basic botany pots may be crafted.")
    public boolean craft_ultra_basic_pots = true;
    @Value(comment = "Determines if ultra hopper pots may be crafted.")
    public boolean craft_ultra_hopper_pots = true;
    @Value(comment = "Determines if ultra wax pots may be crafted.")
    public boolean craft_ultra_wax_pots = true;

    @Value(comment = "Determines if mega basic botany pots may be crafted.")
    public boolean craft_mega_basic_pots = true;
    @Value(comment = "Determines if mega hopper pots may be crafted.")
    public boolean craft_mega_hopper_pots = true;
    @Value(comment = "Determines if mega wax pots may be crafted.")
    public boolean craft_mega_wax_pots = true;
}
