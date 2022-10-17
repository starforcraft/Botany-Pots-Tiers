package com.ultramega.botanypotstiers;

import com.ultramega.botanypotstiers.addons.top.TOPPlugin;
import com.ultramega.botanypotstiers.config.Config;
import com.ultramega.botanypotstiers.config.TieredBotanyPotsCommonConfigForge;

import net.darkhax.bookshelf.api.Services;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod(Constants.MOD_ID)
public class TieredBotanyPotsForge {
    public TieredBotanyPotsForge() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.common_config);
        Config.loadConfig(Config.common_config, FMLPaths.CONFIGDIR.get().resolve(Constants.MOD_ID + "-common.toml").toString());TieredBotanyPotsCommonConfigForge.setupValues();
        new TieredBotanyPotsCommon();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::loadModCompat);
    }
    
    
    
    private void loadModCompat(FMLCommonSetupEvent event) {
        if (Services.PLATFORM.isModLoaded("theoneprobe")) {
            InterModComms.sendTo("theoneprobe", "getTheOneProbe", TOPPlugin::new);
        }
    }
}