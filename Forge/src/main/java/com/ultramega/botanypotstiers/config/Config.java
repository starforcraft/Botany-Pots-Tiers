package com.ultramega.botanypotstiers.config;

import java.io.File;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import com.ultramega.botanypotstiers.Constants;

import net.minecraftforge.common.ForgeConfigSpec;

public class Config {
    public static ForgeConfigSpec common_config;
    private static final ForgeConfigSpec.Builder common_builder = new ForgeConfigSpec.Builder();
    
    static {
    	TieredBotanyPotsCommonConfigForge.init(common_builder);
        common_config = common_builder.build();
    }
	
    public static void loadConfig(ForgeConfigSpec config, String path) {
        Constants.LOG.info("Loading config: " + path);
        CommentedFileConfig file = CommentedFileConfig.builder(new File(path)).sync().autosave().writingMode(WritingMode.APPEND).build();
        Constants.LOG.info("Built config: " + path);
        file.load();
        Constants.LOG.info("Loaded config: " + path);
        config.setConfig(file);
    }

}
