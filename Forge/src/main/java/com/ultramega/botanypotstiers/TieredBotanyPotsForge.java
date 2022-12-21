package com.ultramega.botanypotstiers;

import com.ultramega.botanypotstiers.config.Config;
import com.ultramega.botanypotstiers.config.TieredBotanyPotsConfigForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod(Constants.MOD_ID)
public class TieredBotanyPotsForge {
    public TieredBotanyPotsForge() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.common_config);
        Config.loadConfig(Config.common_config, FMLPaths.CONFIGDIR.get().resolve(Constants.MOD_ID + "-common.toml").toString());
        TieredBotanyPotsConfigForge.setupValues();
        new TieredBotanyPotsCommon();
    }
}