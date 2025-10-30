package com.ultramega.botanypotstiers.common.impl.data.conditions;

import com.ultramega.botanypotstiers.common.impl.BotanyPotsTiersMod;
import com.ultramega.botanypotstiers.common.impl.config.Config;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.darkhax.bookshelf.common.api.data.conditions.ConditionType;
import net.darkhax.bookshelf.common.api.data.conditions.ILoadCondition;
import net.darkhax.bookshelf.common.api.data.conditions.LoadConditions;
import net.darkhax.bookshelf.common.api.function.CachedSupplier;
import net.minecraft.resources.ResourceLocation;

public record ConfigLoadCondition(String property) implements ILoadCondition {
    public static final ResourceLocation TYPE_ID = BotanyPotsTiersMod.id("config");
    public static final Supplier<ConditionType> TYPE = CachedSupplier.cache(() -> LoadConditions.getType(TYPE_ID));
    public static final MapCodec<ConfigLoadCondition> CODEC = RecordCodecBuilder.mapCodec(instance ->
        instance.group(Codec.STRING.fieldOf("property").forGetter(ConfigLoadCondition::property))
            .apply(instance, ConfigLoadCondition::new));

    private static final Supplier<Map<String, Supplier<Boolean>>> PROPERTIES = CachedSupplier.cache(() -> {
        final Config cfg = BotanyPotsTiersMod.CONFIG.get();
        final Map<String, Supplier<Boolean>> properties = new HashMap<>();
        properties.put("can_craft_elite_basic_pots", () -> cfg.recipes.craft_elite_basic_pots);
        properties.put("can_craft_elite_hopper_pots", () -> cfg.recipes.craft_elite_hopper_pots);
        properties.put("can_wax_elite_pots", () -> cfg.recipes.craft_elite_wax_pots);
        properties.put("can_craft_ultra_basic_pots", () -> cfg.recipes.craft_ultra_basic_pots);
        properties.put("can_craft_ultra_hopper_pots", () -> cfg.recipes.craft_ultra_hopper_pots);
        properties.put("can_wax_ultra_pots", () -> cfg.recipes.craft_ultra_wax_pots);
        properties.put("can_craft_mega_basic_pots", () -> cfg.recipes.craft_mega_basic_pots);
        properties.put("can_craft_mega_hopper_pots", () -> cfg.recipes.craft_mega_hopper_pots);
        properties.put("can_wax_mega_pots", () -> cfg.recipes.craft_mega_wax_pots);
        return properties;
    });

    @Override
    public boolean allowLoading() {
        return PROPERTIES.get().get(this.property).get();
    }

    @Override
    public ConditionType getType() {
        return TYPE.get();
    }
}
