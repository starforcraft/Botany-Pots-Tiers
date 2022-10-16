package com.ultramega.botanypotstiers;

import com.ultramega.botanypotstiers.addons.top.TOPPlugin;
import com.ultramega.botanypotstiers.config.TieredBotanyPotsCommonConfigForge;

import net.darkhax.bookshelf.api.Services;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Constants.MOD_ID)
public class TieredBotanyPotsForge {
    public TieredBotanyPotsForge() {
    	TieredBotanyPotsCommonConfigForge.setupValues();
        new TieredBotanyPotsCommon();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::loadModCompat);
        
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, TieredBotanyPotsCommonConfigForge.SPEC, "botanypottiers-common.toml");
        }
    
    
    
    private void loadModCompat(FMLCommonSetupEvent event) {
        if (Services.PLATFORM.isModLoaded("theoneprobe")) {
            InterModComms.sendTo("theoneprobe", "getTheOneProbe", TOPPlugin::new);
        }
    }
}