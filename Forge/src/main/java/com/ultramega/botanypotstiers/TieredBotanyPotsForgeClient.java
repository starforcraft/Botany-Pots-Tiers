package com.ultramega.botanypotstiers;

import com.ultramega.botanypotstiers.block.TieredBlockEntityBotanyPot;
import com.ultramega.botanypotstiers.block.TieredBotanyPotRenderer;
import com.ultramega.botanypotstiers.block.inv.TieredBotanyPotMenu;
import com.ultramega.botanypotstiers.block.inv.TieredBotanyPotScreen;
import com.ultramega.botanypotstiers.data.displaystate.render.DisplayStateRenderer;
import net.darkhax.bookshelf.api.Services;
import net.darkhax.bookshelf.api.function.CachedSupplier;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Constants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TieredBotanyPotsForgeClient {
    private static final CachedSupplier<MenuType<?>> MENU_TYPE = CachedSupplier.cache(() -> Registry.MENU.get(new ResourceLocation(Constants.MOD_ID, "pot_menu")));
    protected static final CachedSupplier<BlockEntityType<TieredBlockEntityBotanyPot>> POT_TYPE = CachedSupplier.cache(() -> (BlockEntityType<TieredBlockEntityBotanyPot>) Services.REGISTRIES.blockEntities().get(new ResourceLocation(Constants.MOD_ID, "botany_pot")));

    @SubscribeEvent
    public static void clientInit(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            MenuType<TieredBotanyPotMenu> menu = (MenuType<TieredBotanyPotMenu>) MENU_TYPE.get();
            MenuScreens.register(menu, TieredBotanyPotScreen::new);
            DisplayStateRenderer.init();
        });
    }

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(POT_TYPE.get(), TieredBotanyPotRenderer::new);
    }
}
