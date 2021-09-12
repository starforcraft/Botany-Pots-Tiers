package com.YTrollman.BotanyPotsTiers.registry;

import com.YTrollman.BotanyPotsTiers.BotanyPotsTiers;
import com.YTrollman.BotanyPotsTiers.blocks.TieredBlockBotanyPot;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BotanyPotsTiers.MOD_ID);

    //Elite
    public static final RegistryObject<TieredBlockBotanyPot> ELITE_BOTANY_POT = BLOCKS.register("elite_botany_pot", () -> new TieredBlockBotanyPot(false, "ELITE_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ELITE_BLACK_BOTANY_POT = BLOCKS.register("elite_black_botany_pot", () -> new TieredBlockBotanyPot(false, "ELITE_BLACK_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ELITE_BLUE_BOTANY_POT = BLOCKS.register("elite_blue_botany_pot", () -> new TieredBlockBotanyPot(false, "ELITE_BLUE_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ELITE_BROWN_BOTANY_POT = BLOCKS.register("elite_brown_botany_pot", () -> new TieredBlockBotanyPot(false, "ELITE_BROWN_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ELITE_CYAN_BOTANY_POT = BLOCKS.register("elite_cyan_botany_pot", () -> new TieredBlockBotanyPot(false, "ELITE_CYAN_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ELITE_GRAY_BOTANY_POT = BLOCKS.register("elite_gray_botany_pot", () -> new TieredBlockBotanyPot(false, "ELITE_GRAY_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ELITE_GREEN_BOTANY_POT = BLOCKS.register("elite_green_botany_pot", () -> new TieredBlockBotanyPot(false, "ELITE_GREEN_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ELITE_LIGHT_BLUE_BOTANY_POT = BLOCKS.register("elite_light_blue_botany_pot", () -> new TieredBlockBotanyPot(false, "ELITE_LIGHT_BLUE_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ELITE_LIGHT_GRAY_BOTANY_POT = BLOCKS.register("elite_light_gray_botany_pot", () -> new TieredBlockBotanyPot(false, "ELITE_LIGHT_GRAY_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ELITE_LIME_BOTANY_POT = BLOCKS.register("elite_lime_botany_pot", () -> new TieredBlockBotanyPot(false, "ELITE_LIME_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ELITE_MAGENTA_BOTANY_POT = BLOCKS.register("elite_magenta_botany_pot", () -> new TieredBlockBotanyPot(false, "ELITE_MAGENTA_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ELITE_ORANGE_BOTANY_POT = BLOCKS.register("elite_orange_botany_pot", () -> new TieredBlockBotanyPot(false, "ELITE_ORANGE_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ELITE_PINK_BOTANY_POT = BLOCKS.register("elite_pink_botany_pot", () -> new TieredBlockBotanyPot(false, "ELITE_PINK_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ELITE_PURPLE_BOTANY_POT = BLOCKS.register("elite_purple_botany_pot", () -> new TieredBlockBotanyPot(false, "ELITE_PURPLE_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ELITE_RED_BOTANY_POT = BLOCKS.register("elite_red_botany_pot", () -> new TieredBlockBotanyPot(false, "ELITE_RED_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ELITE_WHITE_BOTANY_POT = BLOCKS.register("elite_white_botany_pot", () -> new TieredBlockBotanyPot(false, "ELITE_WHITE_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ELITE_YELLOW_BOTANY_POT = BLOCKS.register("elite_yellow_botany_pot", () -> new TieredBlockBotanyPot(false, "ELITE_YELLOW_BOTANY_POT"));

    public static final RegistryObject<TieredBlockBotanyPot> ELITE_HOPPER_BOTANY_POT = BLOCKS.register("elite_hopper_botany_pot", () -> new TieredBlockBotanyPot(true, "ELITE_HOPPER_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ELITE_HOPPER_BLACK_BOTANY_POT = BLOCKS.register("elite_hopper_black_botany_pot", () -> new TieredBlockBotanyPot(true, "ELITE_HOPPER_BLACK_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ELITE_HOPPER_BLUE_BOTANY_POT = BLOCKS.register("elite_hopper_blue_botany_pot", () -> new TieredBlockBotanyPot(true, "ELITE_HOPPER_BLUE_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ELITE_HOPPER_BROWN_BOTANY_POT = BLOCKS.register("elite_hopper_brown_botany_pot", () -> new TieredBlockBotanyPot(true, "ELITE_HOPPER_BROWN_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ELITE_HOPPER_CYAN_BOTANY_POT = BLOCKS.register("elite_hopper_cyan_botany_pot", () -> new TieredBlockBotanyPot(true, "ELITE_HOPPER_CYAN_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ELITE_HOPPER_GRAY_BOTANY_POT = BLOCKS.register("elite_hopper_gray_botany_pot", () -> new TieredBlockBotanyPot(true, "ELITE_HOPPER_GRAY_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ELITE_HOPPER_GREEN_BOTANY_POT = BLOCKS.register("elite_hopper_green_botany_pot", () -> new TieredBlockBotanyPot(true, "ELITE_HOPPER_GREEN_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ELITE_HOPPER_LIGHT_BLUE_BOTANY_POT = BLOCKS.register("elite_hopper_light_blue_botany_pot", () -> new TieredBlockBotanyPot(true, "ELITE_HOPPER_LIGHT_BLUE_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ELITE_HOPPER_LIGHT_GRAY_BOTANY_POT = BLOCKS.register("elite_hopper_light_gray_botany_pot", () -> new TieredBlockBotanyPot(true, "ELITE_HOPPER_LIGHT_GRAY_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ELITE_HOPPER_LIME_BOTANY_POT = BLOCKS.register("elite_hopper_lime_botany_pot", () -> new TieredBlockBotanyPot(true, "ELITE_HOPPER_LIME_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ELITE_HOPPER_MAGENTA_BOTANY_POT = BLOCKS.register("elite_hopper_magenta_botany_pot", () -> new TieredBlockBotanyPot(true, "ELITE_HOPPER_MAGENTA_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ELITE_HOPPER_ORANGE_BOTANY_POT = BLOCKS.register("elite_hopper_orange_botany_pot", () -> new TieredBlockBotanyPot(true, "ELITE_HOPPER_ORANGE_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ELITE_HOPPER_PINK_BOTANY_POT = BLOCKS.register("elite_hopper_pink_botany_pot", () -> new TieredBlockBotanyPot(true, "ELITE_HOPPER_PINK_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ELITE_HOPPER_PURPLE_BOTANY_POT = BLOCKS.register("elite_hopper_purple_botany_pot", () -> new TieredBlockBotanyPot(true, "ELITE_HOPPER_PURPLE_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ELITE_HOPPER_RED_BOTANY_POT = BLOCKS.register("elite_hopper_red_botany_pot", () -> new TieredBlockBotanyPot(true, "ELITE_HOPPER_RED_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ELITE_HOPPER_WHITE_BOTANY_POT = BLOCKS.register("elite_hopper_white_botany_pot", () -> new TieredBlockBotanyPot(true, "ELITE_HOPPER_WHITE_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ELITE_HOPPER_YELLOW_BOTANY_POT = BLOCKS.register("elite_hopper_yellow_botany_pot", () -> new TieredBlockBotanyPot(true, "ELITE_HOPPER_YELLOW_BOTANY_POT"));

    //Ultra
    public static final RegistryObject<TieredBlockBotanyPot> ULTRA_BOTANY_POT = BLOCKS.register("ultra_botany_pot", () -> new TieredBlockBotanyPot(false, "ULTRA_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ULTRA_BLACK_BOTANY_POT = BLOCKS.register("ultra_black_botany_pot", () -> new TieredBlockBotanyPot(false, "ULTRA_BLACK_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ULTRA_BLUE_BOTANY_POT = BLOCKS.register("ultra_blue_botany_pot", () -> new TieredBlockBotanyPot(false, "ULTRA_BLUE_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ULTRA_BROWN_BOTANY_POT = BLOCKS.register("ultra_brown_botany_pot", () -> new TieredBlockBotanyPot(false, "ULTRA_BROWN_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ULTRA_CYAN_BOTANY_POT = BLOCKS.register("ultra_cyan_botany_pot", () -> new TieredBlockBotanyPot(false, "ULTRA_CYAN_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ULTRA_GRAY_BOTANY_POT = BLOCKS.register("ultra_gray_botany_pot", () -> new TieredBlockBotanyPot(false, "ULTRA_GRAY_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ULTRA_GREEN_BOTANY_POT = BLOCKS.register("ultra_green_botany_pot", () -> new TieredBlockBotanyPot(false, "ULTRA_GREEN_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ULTRA_LIGHT_BLUE_BOTANY_POT = BLOCKS.register("ultra_light_blue_botany_pot", () -> new TieredBlockBotanyPot(false, "ULTRA_LIGHT_BLUE_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ULTRA_LIGHT_GRAY_BOTANY_POT = BLOCKS.register("ultra_light_gray_botany_pot", () -> new TieredBlockBotanyPot(false, "ULTRA_LIGHT_GRAY_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ULTRA_LIME_BOTANY_POT = BLOCKS.register("ultra_lime_botany_pot", () -> new TieredBlockBotanyPot(false, "ULTRA_LIME_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ULTRA_MAGENTA_BOTANY_POT = BLOCKS.register("ultra_magenta_botany_pot", () -> new TieredBlockBotanyPot(false, "ULTRA_MAGENTA_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ULTRA_ORANGE_BOTANY_POT = BLOCKS.register("ultra_orange_botany_pot", () -> new TieredBlockBotanyPot(false, "ULTRA_ORANGE_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ULTRA_PINK_BOTANY_POT = BLOCKS.register("ultra_pink_botany_pot", () -> new TieredBlockBotanyPot(false, "ULTRA_PINK_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ULTRA_PURPLE_BOTANY_POT = BLOCKS.register("ultra_purple_botany_pot", () -> new TieredBlockBotanyPot(false, "ULTRA_PURPLE_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ULTRA_RED_BOTANY_POT = BLOCKS.register("ultra_red_botany_pot", () -> new TieredBlockBotanyPot(false, "ULTRA_RED_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ULTRA_WHITE_BOTANY_POT = BLOCKS.register("ultra_white_botany_pot", () -> new TieredBlockBotanyPot(false, "ULTRA_WHITE_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ULTRA_YELLOW_BOTANY_POT = BLOCKS.register("ultra_yellow_botany_pot", () -> new TieredBlockBotanyPot(false, "ULTRA_YELLOW_BOTANY_POT"));

    public static final RegistryObject<TieredBlockBotanyPot> ULTRA_HOPPER_BOTANY_POT = BLOCKS.register("ultra_hopper_botany_pot", () -> new TieredBlockBotanyPot(true, "ULTRA_HOPPER_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ULTRA_HOPPER_BLACK_BOTANY_POT = BLOCKS.register("ultra_hopper_black_botany_pot", () -> new TieredBlockBotanyPot(true, "ULTRA_HOPPER_BLACK_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ULTRA_HOPPER_BLUE_BOTANY_POT = BLOCKS.register("ultra_hopper_blue_botany_pot", () -> new TieredBlockBotanyPot(true, "ULTRA_HOPPER_BLUE_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ULTRA_HOPPER_BROWN_BOTANY_POT = BLOCKS.register("ultra_hopper_brown_botany_pot", () -> new TieredBlockBotanyPot(true, "ULTRA_HOPPER_BROWN_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ULTRA_HOPPER_CYAN_BOTANY_POT = BLOCKS.register("ultra_hopper_cyan_botany_pot", () -> new TieredBlockBotanyPot(true, "ULTRA_HOPPER_CYAN_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ULTRA_HOPPER_GRAY_BOTANY_POT = BLOCKS.register("ultra_hopper_gray_botany_pot", () -> new TieredBlockBotanyPot(true, "ULTRA_HOPPER_GRAY_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ULTRA_HOPPER_GREEN_BOTANY_POT = BLOCKS.register("ultra_hopper_green_botany_pot", () -> new TieredBlockBotanyPot(true, "ULTRA_HOPPER_GREEN_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ULTRA_HOPPER_LIGHT_BLUE_BOTANY_POT = BLOCKS.register("ultra_hopper_light_blue_botany_pot", () -> new TieredBlockBotanyPot(true, "ULTRA_HOPPER_LIGHT_BLUE_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ULTRA_HOPPER_LIGHT_GRAY_BOTANY_POT = BLOCKS.register("ultra_hopper_light_gray_botany_pot", () -> new TieredBlockBotanyPot(true, "ULTRA_HOPPER_LIGHT_GRAY_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ULTRA_HOPPER_LIME_BOTANY_POT = BLOCKS.register("ultra_hopper_lime_botany_pot", () -> new TieredBlockBotanyPot(true, "ULTRA_HOPPER_LIME_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ULTRA_HOPPER_MAGENTA_BOTANY_POT = BLOCKS.register("ultra_hopper_magenta_botany_pot", () -> new TieredBlockBotanyPot(true, "ULTRA_HOPPER_MAGENTA_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ULTRA_HOPPER_ORANGE_BOTANY_POT = BLOCKS.register("ultra_hopper_orange_botany_pot", () -> new TieredBlockBotanyPot(true, "ULTRA_HOPPER_ORANGE_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ULTRA_HOPPER_PINK_BOTANY_POT = BLOCKS.register("ultra_hopper_pink_botany_pot", () -> new TieredBlockBotanyPot(true, "ULTRA_HOPPER_PINK_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ULTRA_HOPPER_PURPLE_BOTANY_POT = BLOCKS.register("ultra_hopper_purple_botany_pot", () -> new TieredBlockBotanyPot(true, "ULTRA_HOPPER_PURPLE_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ULTRA_HOPPER_RED_BOTANY_POT = BLOCKS.register("ultra_hopper_red_botany_pot", () -> new TieredBlockBotanyPot(true, "ULTRA_HOPPER_RED_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ULTRA_HOPPER_WHITE_BOTANY_POT = BLOCKS.register("ultra_hopper_white_botany_pot", () -> new TieredBlockBotanyPot(true, "ULTRA_HOPPER_WHITE_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> ULTRA_HOPPER_YELLOW_BOTANY_POT = BLOCKS.register("ultra_hopper_yellow_botany_pot", () -> new TieredBlockBotanyPot(true, "ULTRA_HOPPER_YELLOW_BOTANY_POT"));

    //Creative
    public static final RegistryObject<TieredBlockBotanyPot> CREATIVE_BOTANY_POT = BLOCKS.register("creative_botany_pot", () -> new TieredBlockBotanyPot(false, "CREATIVE_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> CREATIVE_BLACK_BOTANY_POT = BLOCKS.register("creative_black_botany_pot", () -> new TieredBlockBotanyPot(false, "CREATIVE_BLACK_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> CREATIVE_BLUE_BOTANY_POT = BLOCKS.register("creative_blue_botany_pot", () -> new TieredBlockBotanyPot(false, "CREATIVE_BLUE_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> CREATIVE_BROWN_BOTANY_POT = BLOCKS.register("creative_brown_botany_pot", () -> new TieredBlockBotanyPot(false, "CREATIVE_BROWN_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> CREATIVE_CYAN_BOTANY_POT = BLOCKS.register("creative_cyan_botany_pot", () -> new TieredBlockBotanyPot(false, "CREATIVE_CYAN_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> CREATIVE_GRAY_BOTANY_POT = BLOCKS.register("creative_gray_botany_pot", () -> new TieredBlockBotanyPot(false, "CREATIVE_GRAY_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> CREATIVE_GREEN_BOTANY_POT = BLOCKS.register("creative_green_botany_pot", () -> new TieredBlockBotanyPot(false, "CREATIVE_GREEN_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> CREATIVE_LIGHT_BLUE_BOTANY_POT = BLOCKS.register("creative_light_blue_botany_pot", () -> new TieredBlockBotanyPot(false, "CREATIVE_LIGHT_BLUE_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> CREATIVE_LIGHT_GRAY_BOTANY_POT = BLOCKS.register("creative_light_gray_botany_pot", () -> new TieredBlockBotanyPot(false, "CREATIVE_LIGHT_GRAY_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> CREATIVE_LIME_BOTANY_POT = BLOCKS.register("creative_lime_botany_pot", () -> new TieredBlockBotanyPot(false, "CREATIVE_LIME_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> CREATIVE_MAGENTA_BOTANY_POT = BLOCKS.register("creative_magenta_botany_pot", () -> new TieredBlockBotanyPot(false, "CREATIVE_MAGENTA_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> CREATIVE_ORANGE_BOTANY_POT = BLOCKS.register("creative_orange_botany_pot", () -> new TieredBlockBotanyPot(false, "CREATIVE_ORANGE_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> CREATIVE_PINK_BOTANY_POT = BLOCKS.register("creative_pink_botany_pot", () -> new TieredBlockBotanyPot(false, "CREATIVE_PINK_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> CREATIVE_PURPLE_BOTANY_POT = BLOCKS.register("creative_purple_botany_pot", () -> new TieredBlockBotanyPot(false, "CREATIVE_PURPLE_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> CREATIVE_RED_BOTANY_POT = BLOCKS.register("creative_red_botany_pot", () -> new TieredBlockBotanyPot(false, "CREATIVE_RED_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> CREATIVE_WHITE_BOTANY_POT = BLOCKS.register("creative_white_botany_pot", () -> new TieredBlockBotanyPot(false, "CREATIVE_WHITE_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> CREATIVE_YELLOW_BOTANY_POT = BLOCKS.register("creative_yellow_botany_pot", () -> new TieredBlockBotanyPot(false, "CREATIVE_YELLOW_BOTANY_POT"));

    public static final RegistryObject<TieredBlockBotanyPot> CREATIVE_HOPPER_BOTANY_POT = BLOCKS.register("creative_hopper_botany_pot", () -> new TieredBlockBotanyPot(true, "CREATIVE_HOPPER_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> CREATIVE_HOPPER_BLACK_BOTANY_POT = BLOCKS.register("creative_hopper_black_botany_pot", () -> new TieredBlockBotanyPot(true, "CREATIVE_HOPPER_BLACK_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> CREATIVE_HOPPER_BLUE_BOTANY_POT = BLOCKS.register("creative_hopper_blue_botany_pot", () -> new TieredBlockBotanyPot(true, "CREATIVE_HOPPER_BLUE_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> CREATIVE_HOPPER_BROWN_BOTANY_POT = BLOCKS.register("creative_hopper_brown_botany_pot", () -> new TieredBlockBotanyPot(true, "CREATIVE_HOPPER_BROWN_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> CREATIVE_HOPPER_CYAN_BOTANY_POT = BLOCKS.register("creative_hopper_cyan_botany_pot", () -> new TieredBlockBotanyPot(true, "CREATIVE_HOPPER_CYAN_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> CREATIVE_HOPPER_GRAY_BOTANY_POT = BLOCKS.register("creative_hopper_gray_botany_pot", () -> new TieredBlockBotanyPot(true, "CREATIVE_HOPPER_GRAY_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> CREATIVE_HOPPER_GREEN_BOTANY_POT = BLOCKS.register("creative_hopper_green_botany_pot", () -> new TieredBlockBotanyPot(true, "CREATIVE_HOPPER_GREEN_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> CREATIVE_HOPPER_LIGHT_BLUE_BOTANY_POT = BLOCKS.register("creative_hopper_light_blue_botany_pot", () -> new TieredBlockBotanyPot(true, "CREATIVE_HOPPER_LIGHT_BLUE_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> CREATIVE_HOPPER_LIGHT_GRAY_BOTANY_POT = BLOCKS.register("creative_hopper_light_gray_botany_pot", () -> new TieredBlockBotanyPot(true, "CREATIVE_HOPPER_LIGHT_GRAY_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> CREATIVE_HOPPER_LIME_BOTANY_POT = BLOCKS.register("creative_hopper_lime_botany_pot", () -> new TieredBlockBotanyPot(true, "CREATIVE_HOPPER_LIME_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> CREATIVE_HOPPER_MAGENTA_BOTANY_POT = BLOCKS.register("creative_hopper_magenta_botany_pot", () -> new TieredBlockBotanyPot(true, "CREATIVE_HOPPER_MAGENTA_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> CREATIVE_HOPPER_ORANGE_BOTANY_POT = BLOCKS.register("creative_hopper_orange_botany_pot", () -> new TieredBlockBotanyPot(true, "CREATIVE_HOPPER_ORANGE_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> CREATIVE_HOPPER_PINK_BOTANY_POT = BLOCKS.register("creative_hopper_pink_botany_pot", () -> new TieredBlockBotanyPot(true, "CREATIVE_HOPPER_PINK_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> CREATIVE_HOPPER_PURPLE_BOTANY_POT = BLOCKS.register("creative_hopper_purple_botany_pot", () -> new TieredBlockBotanyPot(true, "CREATIVE_HOPPER_PURPLE_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> CREATIVE_HOPPER_RED_BOTANY_POT = BLOCKS.register("creative_hopper_red_botany_pot", () -> new TieredBlockBotanyPot(true, "CREATIVE_HOPPER_RED_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> CREATIVE_HOPPER_WHITE_BOTANY_POT = BLOCKS.register("creative_hopper_white_botany_pot", () -> new TieredBlockBotanyPot(true, "CREATIVE_HOPPER_WHITE_BOTANY_POT"));
    public static final RegistryObject<TieredBlockBotanyPot> CREATIVE_HOPPER_YELLOW_BOTANY_POT = BLOCKS.register("creative_hopper_yellow_botany_pot", () -> new TieredBlockBotanyPot(true, "CREATIVE_HOPPER_YELLOW_BOTANY_POT"));
}