package com.YTrollman.BotanyPotsTiers.init;

import com.YTrollman.BotanyPotsTiers.BotanyPotsTiers;
import com.YTrollman.BotanyPotsTiers.blocks.TieredBlockBotanyPot;
import com.YTrollman.BotanyPotsTiers.registry.ModTileEntityTypes;
import com.YTrollman.BotanyPotsTiers.renderer.TieredRendererBotanyPot;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = BotanyPotsTiers.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventHandler {

    @SubscribeEvent
    public static void init(FMLClientSetupEvent event) {
        for (final Block block : TieredBlockBotanyPot.botanyPots) {
            RenderTypeLookup.setRenderLayer(block, RenderType.cutout());
        }

        //Elite
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ELITE_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ELITE_BLACK_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ELITE_BLUE_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ELITE_BROWN_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ELITE_CYAN_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ELITE_GRAY_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ELITE_GREEN_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ELITE_LIGHT_BLUE_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ELITE_LIGHT_GRAY_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ELITE_LIME_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ELITE_MAGENTA_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ELITE_ORANGE_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ELITE_PINK_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ELITE_PURPLE_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ELITE_RED_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ELITE_WHITE_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ELITE_YELLOW_BOTANY_POT.get(), TieredRendererBotanyPot::new);

        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ELITE_HOPPER_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ELITE_HOPPER_BLACK_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ELITE_HOPPER_BLUE_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ELITE_HOPPER_BROWN_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ELITE_HOPPER_CYAN_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ELITE_HOPPER_GRAY_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ELITE_HOPPER_GREEN_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ELITE_HOPPER_LIGHT_BLUE_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ELITE_HOPPER_LIGHT_GRAY_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ELITE_HOPPER_LIME_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ELITE_HOPPER_MAGENTA_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ELITE_HOPPER_ORANGE_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ELITE_HOPPER_PINK_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ELITE_HOPPER_PURPLE_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ELITE_HOPPER_RED_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ELITE_HOPPER_WHITE_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ELITE_HOPPER_YELLOW_BOTANY_POT.get(), TieredRendererBotanyPot::new);

        //Ultra
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ULTRA_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ULTRA_BLACK_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ULTRA_BLUE_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ULTRA_BROWN_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ULTRA_CYAN_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ULTRA_GRAY_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ULTRA_GREEN_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ULTRA_LIGHT_BLUE_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ULTRA_LIGHT_GRAY_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ULTRA_LIME_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ULTRA_MAGENTA_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ULTRA_ORANGE_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ULTRA_PINK_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ULTRA_PURPLE_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ULTRA_RED_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ULTRA_WHITE_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ULTRA_YELLOW_BOTANY_POT.get(), TieredRendererBotanyPot::new);

        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ULTRA_HOPPER_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ULTRA_HOPPER_BLACK_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ULTRA_HOPPER_BLUE_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ULTRA_HOPPER_BROWN_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ULTRA_HOPPER_CYAN_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ULTRA_HOPPER_GRAY_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ULTRA_HOPPER_GREEN_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ULTRA_HOPPER_LIGHT_BLUE_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ULTRA_HOPPER_LIGHT_GRAY_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ULTRA_HOPPER_LIME_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ULTRA_HOPPER_MAGENTA_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ULTRA_HOPPER_ORANGE_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ULTRA_HOPPER_PINK_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ULTRA_HOPPER_PURPLE_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ULTRA_HOPPER_RED_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ULTRA_HOPPER_WHITE_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ULTRA_HOPPER_YELLOW_BOTANY_POT.get(), TieredRendererBotanyPot::new);

        //Creative
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.CREATIVE_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.CREATIVE_BLACK_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.CREATIVE_BLUE_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.CREATIVE_BROWN_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.CREATIVE_CYAN_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.CREATIVE_GRAY_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.CREATIVE_GREEN_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.CREATIVE_LIGHT_BLUE_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.CREATIVE_LIGHT_GRAY_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.CREATIVE_LIME_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.CREATIVE_MAGENTA_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.CREATIVE_ORANGE_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.CREATIVE_PINK_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.CREATIVE_PURPLE_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.CREATIVE_RED_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.CREATIVE_WHITE_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.CREATIVE_YELLOW_BOTANY_POT.get(), TieredRendererBotanyPot::new);

        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.CREATIVE_HOPPER_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.CREATIVE_HOPPER_BLACK_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.CREATIVE_HOPPER_BLUE_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.CREATIVE_HOPPER_BROWN_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.CREATIVE_HOPPER_CYAN_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.CREATIVE_HOPPER_GRAY_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.CREATIVE_HOPPER_GREEN_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.CREATIVE_HOPPER_LIGHT_BLUE_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.CREATIVE_HOPPER_LIGHT_GRAY_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.CREATIVE_HOPPER_LIME_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.CREATIVE_HOPPER_MAGENTA_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.CREATIVE_HOPPER_ORANGE_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.CREATIVE_HOPPER_PINK_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.CREATIVE_HOPPER_PURPLE_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.CREATIVE_HOPPER_RED_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.CREATIVE_HOPPER_WHITE_BOTANY_POT.get(), TieredRendererBotanyPot::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.CREATIVE_HOPPER_YELLOW_BOTANY_POT.get(), TieredRendererBotanyPot::new);
    }
}
