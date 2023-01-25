package com.ultramega.botanypotstiers;

import com.ultramega.botanypotstiers.block.TieredBlockEntityBotanyPot;
import com.ultramega.botanypotstiers.block.TieredBotanyPotRenderer;
import net.darkhax.bookshelf.api.function.CachedSupplier;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class TieredBotanyPotsFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        for(PotTiers tier : PotTiers.values()) {
            CachedSupplier<BlockEntityType<TieredBlockEntityBotanyPot>> POT_TYPE = CachedSupplier.cache(() -> (BlockEntityType<TieredBlockEntityBotanyPot>) BuiltInRegistries.BLOCK_ENTITY_TYPE.get(new ResourceLocation(Constants.MOD_ID, tier.getName() + "_botany_pot")));
            BlockEntityRendererRegistry.register(POT_TYPE.get(), TieredBotanyPotRenderer::new);
        }
    }
}