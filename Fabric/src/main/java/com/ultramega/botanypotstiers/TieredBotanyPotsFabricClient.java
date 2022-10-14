package com.ultramega.botanypotstiers;

import com.ultramega.botanypotstiers.block.TieredBlockEntityBotanyPot;
import com.ultramega.botanypotstiers.block.inv.TieredBotanyPotScreen;
import com.ultramega.botanypotstiers.data.displaystate.render.DisplayStateRenderer;
import net.darkhax.bookshelf.api.Services;
import net.darkhax.bookshelf.api.function.CachedSupplier;
import com.ultramega.botanypotstiers.block.TieredBotanyPotRenderer;
import com.ultramega.botanypotstiers.block.inv.TieredBotanyPotMenu;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class TieredBotanyPotsFabricClient implements ClientModInitializer {
    private static final CachedSupplier<MenuType<?>> MENU_TYPE = CachedSupplier.cache(() -> Registry.MENU.get(new ResourceLocation(Constants.MOD_ID, "pot_menu")));
    private static final CachedSupplier<BlockEntityType<TieredBlockEntityBotanyPot>> POT_TYPE = CachedSupplier.cache(() -> (BlockEntityType<TieredBlockEntityBotanyPot>) Services.REGISTRIES.blockEntities().get(new ResourceLocation(Constants.MOD_ID, "botany_pot")));

    @Override
    public void onInitializeClient() {
        MenuType<TieredBotanyPotMenu> menu = (MenuType<TieredBotanyPotMenu>) MENU_TYPE.get();
        MenuScreens.register(menu, TieredBotanyPotScreen::new);
        BlockEntityRendererRegistry.register(POT_TYPE.get(), TieredBotanyPotRenderer::new);
        DisplayStateRenderer.init();
    }
}