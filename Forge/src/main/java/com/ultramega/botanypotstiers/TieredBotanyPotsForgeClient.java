package com.ultramega.botanypotstiers;

import com.ultramega.botanypotstiers.block.TieredBlockEntityBotanyPot;
import net.darkhax.bookshelf.api.Services;
import net.darkhax.bookshelf.api.function.CachedSupplier;
import net.darkhax.botanypots.block.BotanyPotRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Constants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TieredBotanyPotsForgeClient {
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        for(PotTiers tier : PotTiers.values()) {
            CachedSupplier<BlockEntityType<TieredBlockEntityBotanyPot>> POT_TYPE = CachedSupplier.cache(() -> (BlockEntityType<TieredBlockEntityBotanyPot>) Services.REGISTRIES.blockEntities().get(new ResourceLocation(Constants.MOD_ID, tier.getName() + "_botany_pot")));
            event.registerBlockEntityRenderer(POT_TYPE.get(), BotanyPotRenderer::new);
        }
    }
}
