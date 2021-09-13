package com.YTrollman.BotanyPotsTiers;

import com.YTrollman.BotanyPotsTiers.compat.top.TOPPlugin;
import com.YTrollman.BotanyPotsTiers.config.Config;
import com.YTrollman.BotanyPotsTiers.registry.RegistryHandler;
import net.darkhax.bookshelf.util.ModUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("botanypotstiers")
public class BotanyPotsTiers
{
    public static final String MOD_ID = "botanypotstiers";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public BotanyPotsTiers() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.common_config);

        RegistryHandler.init();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        Config.loadConfig(Config.common_config, FMLPaths.CONFIGDIR.get().resolve("botanypotstiers-common.toml").toString());

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(FMLCommonSetupEvent event)
    {
        if (ModUtils.isInModList("theoneprobe")) {
            InterModComms.sendTo("theoneprobe", "getTheOneProbe", TOPPlugin::new);
        }
    }

    private void doClientStuff(FMLClientSetupEvent event)
    {

    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) 
    {
    	
    }
}
