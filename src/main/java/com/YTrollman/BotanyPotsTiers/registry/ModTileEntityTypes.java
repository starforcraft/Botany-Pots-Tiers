package com.YTrollman.BotanyPotsTiers.registry;

import com.YTrollman.BotanyPotsTiers.BotanyPotsTiers;
import com.YTrollman.BotanyPotsTiers.tileentity.TieredTileEntityBotanyPot;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityTypes {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, BotanyPotsTiers.MOD_ID);

    //Elite
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ELITE_BOTANY_POT = TILE_ENTITY_TYPES.register("elite_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ELITE_BOTANY_POT.get(), "Elite"), ModBlocks.ELITE_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ELITE_BLACK_BOTANY_POT = TILE_ENTITY_TYPES.register("elite_black_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ELITE_BLACK_BOTANY_POT.get(), "Elite"), ModBlocks.ELITE_BLACK_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ELITE_BLUE_BOTANY_POT = TILE_ENTITY_TYPES.register("elite_blue_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ELITE_BLUE_BOTANY_POT.get(), "Elite"), ModBlocks.ELITE_BLUE_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ELITE_BROWN_BOTANY_POT = TILE_ENTITY_TYPES.register("elite_brown_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ELITE_BROWN_BOTANY_POT.get(), "Elite"), ModBlocks.ELITE_BROWN_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ELITE_CYAN_BOTANY_POT = TILE_ENTITY_TYPES.register("elite_cyan_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ELITE_CYAN_BOTANY_POT.get(), "Elite"), ModBlocks.ELITE_CYAN_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ELITE_GRAY_BOTANY_POT = TILE_ENTITY_TYPES.register("elite_gray_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ELITE_GRAY_BOTANY_POT.get(), "Elite"), ModBlocks.ELITE_GRAY_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ELITE_GREEN_BOTANY_POT = TILE_ENTITY_TYPES.register("elite_green_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ELITE_GREEN_BOTANY_POT.get(), "Elite"), ModBlocks.ELITE_GREEN_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ELITE_LIGHT_BLUE_BOTANY_POT = TILE_ENTITY_TYPES.register("elite_light_blue_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ELITE_LIGHT_BLUE_BOTANY_POT.get(), "Elite"), ModBlocks.ELITE_LIGHT_BLUE_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ELITE_LIGHT_GRAY_BOTANY_POT = TILE_ENTITY_TYPES.register("elite_light_gray_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ELITE_LIGHT_GRAY_BOTANY_POT.get(), "Elite"), ModBlocks.ELITE_LIGHT_GRAY_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ELITE_LIME_BOTANY_POT = TILE_ENTITY_TYPES.register("elite_lime_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ELITE_LIME_BOTANY_POT.get(), "Elite"), ModBlocks.ELITE_LIME_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ELITE_MAGENTA_BOTANY_POT = TILE_ENTITY_TYPES.register("elite_magenta_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ELITE_MAGENTA_BOTANY_POT.get(), "Elite"), ModBlocks.ELITE_MAGENTA_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ELITE_ORANGE_BOTANY_POT = TILE_ENTITY_TYPES.register("elite_orange_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ELITE_ORANGE_BOTANY_POT.get(), "Elite"), ModBlocks.ELITE_ORANGE_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ELITE_PINK_BOTANY_POT = TILE_ENTITY_TYPES.register("elite_pink_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ELITE_PINK_BOTANY_POT.get(), "Elite"), ModBlocks.ELITE_PINK_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ELITE_PURPLE_BOTANY_POT = TILE_ENTITY_TYPES.register("elite_purple_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ELITE_PURPLE_BOTANY_POT.get(), "Elite"), ModBlocks.ELITE_PURPLE_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ELITE_RED_BOTANY_POT = TILE_ENTITY_TYPES.register("elite_red_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ELITE_RED_BOTANY_POT.get(), "Elite"), ModBlocks.ELITE_RED_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ELITE_WHITE_BOTANY_POT = TILE_ENTITY_TYPES.register("elite_white_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ELITE_WHITE_BOTANY_POT.get(), "Elite"), ModBlocks.ELITE_WHITE_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ELITE_YELLOW_BOTANY_POT = TILE_ENTITY_TYPES.register("elite_yellow_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ELITE_YELLOW_BOTANY_POT.get(), "Elite"), ModBlocks.ELITE_YELLOW_BOTANY_POT.get())
            .build(null));

    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ELITE_HOPPER_BOTANY_POT = TILE_ENTITY_TYPES.register("elite_hopper_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ELITE_HOPPER_BOTANY_POT.get(), "Elite"), ModBlocks.ELITE_HOPPER_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ELITE_HOPPER_BLACK_BOTANY_POT = TILE_ENTITY_TYPES.register("elite_hopper_black_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ELITE_HOPPER_BLACK_BOTANY_POT.get(), "Elite"), ModBlocks.ELITE_HOPPER_BLACK_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ELITE_HOPPER_BLUE_BOTANY_POT = TILE_ENTITY_TYPES.register("elite_hopper_blue_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ELITE_HOPPER_BLUE_BOTANY_POT.get(), "Elite"), ModBlocks.ELITE_HOPPER_BLUE_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ELITE_HOPPER_BROWN_BOTANY_POT = TILE_ENTITY_TYPES.register("elite_hopper_brown_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ELITE_HOPPER_BROWN_BOTANY_POT.get(), "Elite"), ModBlocks.ELITE_HOPPER_BROWN_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ELITE_HOPPER_CYAN_BOTANY_POT = TILE_ENTITY_TYPES.register("elite_hopper_cyan_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ELITE_HOPPER_CYAN_BOTANY_POT.get(), "Elite"), ModBlocks.ELITE_HOPPER_CYAN_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ELITE_HOPPER_GRAY_BOTANY_POT = TILE_ENTITY_TYPES.register("elite_hopper_gray_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ELITE_HOPPER_GRAY_BOTANY_POT.get(), "Elite"), ModBlocks.ELITE_HOPPER_GRAY_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ELITE_HOPPER_GREEN_BOTANY_POT = TILE_ENTITY_TYPES.register("elite_hopper_green_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ELITE_HOPPER_GREEN_BOTANY_POT.get(), "Elite"), ModBlocks.ELITE_HOPPER_GREEN_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ELITE_HOPPER_LIGHT_BLUE_BOTANY_POT = TILE_ENTITY_TYPES.register("elite_hopper_light_blue_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ELITE_HOPPER_LIGHT_BLUE_BOTANY_POT.get(), "Elite"), ModBlocks.ELITE_HOPPER_LIGHT_BLUE_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ELITE_HOPPER_LIGHT_GRAY_BOTANY_POT = TILE_ENTITY_TYPES.register("elite_hopper_light_gray_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ELITE_HOPPER_LIGHT_GRAY_BOTANY_POT.get(), "Elite"), ModBlocks.ELITE_HOPPER_LIGHT_GRAY_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ELITE_HOPPER_LIME_BOTANY_POT = TILE_ENTITY_TYPES.register("elite_hopper_lime_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ELITE_HOPPER_LIME_BOTANY_POT.get(), "Elite"), ModBlocks.ELITE_HOPPER_LIME_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ELITE_HOPPER_MAGENTA_BOTANY_POT = TILE_ENTITY_TYPES.register("elite_hopper_magenta_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ELITE_HOPPER_MAGENTA_BOTANY_POT.get(), "Elite"), ModBlocks.ELITE_HOPPER_MAGENTA_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ELITE_HOPPER_ORANGE_BOTANY_POT = TILE_ENTITY_TYPES.register("elite_hopper_orange_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ELITE_HOPPER_ORANGE_BOTANY_POT.get(), "Elite"), ModBlocks.ELITE_HOPPER_ORANGE_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ELITE_HOPPER_PINK_BOTANY_POT = TILE_ENTITY_TYPES.register("elite_hopper_pink_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ELITE_HOPPER_PINK_BOTANY_POT.get(), "Elite"), ModBlocks.ELITE_HOPPER_PINK_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ELITE_HOPPER_PURPLE_BOTANY_POT = TILE_ENTITY_TYPES.register("elite_hopper_purple_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ELITE_HOPPER_PURPLE_BOTANY_POT.get(), "Elite"), ModBlocks.ELITE_HOPPER_PURPLE_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ELITE_HOPPER_RED_BOTANY_POT = TILE_ENTITY_TYPES.register("elite_hopper_red_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ELITE_HOPPER_RED_BOTANY_POT.get(), "Elite"), ModBlocks.ELITE_HOPPER_RED_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ELITE_HOPPER_WHITE_BOTANY_POT = TILE_ENTITY_TYPES.register("elite_hopper_white_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ELITE_HOPPER_WHITE_BOTANY_POT.get(), "Elite"), ModBlocks.ELITE_HOPPER_WHITE_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ELITE_HOPPER_YELLOW_BOTANY_POT = TILE_ENTITY_TYPES.register("elite_hopper_yellow_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ELITE_HOPPER_YELLOW_BOTANY_POT.get(), "Elite"), ModBlocks.ELITE_HOPPER_YELLOW_BOTANY_POT.get())
            .build(null));

    //Ultra
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ULTRA_BOTANY_POT = TILE_ENTITY_TYPES.register("ultra_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ULTRA_BOTANY_POT.get(), "Ultra"), ModBlocks.ULTRA_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ULTRA_BLACK_BOTANY_POT = TILE_ENTITY_TYPES.register("ultra_black_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ULTRA_BLACK_BOTANY_POT.get(), "Ultra"), ModBlocks.ULTRA_BLACK_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ULTRA_BLUE_BOTANY_POT = TILE_ENTITY_TYPES.register("ultra_blue_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ULTRA_BLUE_BOTANY_POT.get(), "Ultra"), ModBlocks.ULTRA_BLUE_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ULTRA_BROWN_BOTANY_POT = TILE_ENTITY_TYPES.register("ultra_brown_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ULTRA_BROWN_BOTANY_POT.get(), "Ultra"), ModBlocks.ULTRA_BROWN_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ULTRA_CYAN_BOTANY_POT = TILE_ENTITY_TYPES.register("ultra_cyan_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ULTRA_CYAN_BOTANY_POT.get(), "Ultra"), ModBlocks.ULTRA_CYAN_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ULTRA_GRAY_BOTANY_POT = TILE_ENTITY_TYPES.register("ultra_gray_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ULTRA_GRAY_BOTANY_POT.get(), "Ultra"), ModBlocks.ULTRA_GRAY_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ULTRA_GREEN_BOTANY_POT = TILE_ENTITY_TYPES.register("ultra_green_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ULTRA_GREEN_BOTANY_POT.get(), "Ultra"), ModBlocks.ULTRA_GREEN_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ULTRA_LIGHT_BLUE_BOTANY_POT = TILE_ENTITY_TYPES.register("ultra_light_blue_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ULTRA_LIGHT_BLUE_BOTANY_POT.get(), "Ultra"), ModBlocks.ULTRA_LIGHT_BLUE_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ULTRA_LIGHT_GRAY_BOTANY_POT = TILE_ENTITY_TYPES.register("ultra_light_gray_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ULTRA_LIGHT_GRAY_BOTANY_POT.get(), "Ultra"), ModBlocks.ULTRA_LIGHT_GRAY_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ULTRA_LIME_BOTANY_POT = TILE_ENTITY_TYPES.register("ultra_lime_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ULTRA_LIME_BOTANY_POT.get(), "Ultra"), ModBlocks.ULTRA_LIME_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ULTRA_MAGENTA_BOTANY_POT = TILE_ENTITY_TYPES.register("ultra_magenta_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ULTRA_MAGENTA_BOTANY_POT.get(), "Ultra"), ModBlocks.ULTRA_MAGENTA_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ULTRA_ORANGE_BOTANY_POT = TILE_ENTITY_TYPES.register("ultra_orange_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ULTRA_ORANGE_BOTANY_POT.get(), "Ultra"), ModBlocks.ULTRA_ORANGE_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ULTRA_PINK_BOTANY_POT = TILE_ENTITY_TYPES.register("ultra_pink_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ULTRA_PINK_BOTANY_POT.get(), "Ultra"), ModBlocks.ULTRA_PINK_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ULTRA_PURPLE_BOTANY_POT = TILE_ENTITY_TYPES.register("ultra_purple_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ULTRA_PURPLE_BOTANY_POT.get(), "Ultra"), ModBlocks.ULTRA_PURPLE_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ULTRA_RED_BOTANY_POT = TILE_ENTITY_TYPES.register("ultra_red_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ULTRA_RED_BOTANY_POT.get(), "Ultra"), ModBlocks.ULTRA_RED_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ULTRA_WHITE_BOTANY_POT = TILE_ENTITY_TYPES.register("ultra_white_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ULTRA_WHITE_BOTANY_POT.get(), "Ultra"), ModBlocks.ULTRA_WHITE_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ULTRA_YELLOW_BOTANY_POT = TILE_ENTITY_TYPES.register("ultra_yellow_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ULTRA_YELLOW_BOTANY_POT.get(), "Ultra"), ModBlocks.ULTRA_YELLOW_BOTANY_POT.get())
            .build(null));

    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ULTRA_HOPPER_BOTANY_POT = TILE_ENTITY_TYPES.register("ultra_hopper_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ULTRA_HOPPER_BOTANY_POT.get(), "Ultra"), ModBlocks.ULTRA_HOPPER_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ULTRA_HOPPER_BLACK_BOTANY_POT = TILE_ENTITY_TYPES.register("ultra_hopper_black_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ULTRA_HOPPER_BLACK_BOTANY_POT.get(), "Ultra"), ModBlocks.ULTRA_HOPPER_BLACK_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ULTRA_HOPPER_BLUE_BOTANY_POT = TILE_ENTITY_TYPES.register("ultra_hopper_blue_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ULTRA_HOPPER_BLUE_BOTANY_POT.get(), "Ultra"), ModBlocks.ULTRA_HOPPER_BLUE_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ULTRA_HOPPER_BROWN_BOTANY_POT = TILE_ENTITY_TYPES.register("ultra_hopper_brown_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ULTRA_HOPPER_BROWN_BOTANY_POT.get(), "Ultra"), ModBlocks.ULTRA_HOPPER_BROWN_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ULTRA_HOPPER_CYAN_BOTANY_POT = TILE_ENTITY_TYPES.register("ultra_hopper_cyan_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ULTRA_HOPPER_CYAN_BOTANY_POT.get(), "Ultra"), ModBlocks.ULTRA_HOPPER_CYAN_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ULTRA_HOPPER_GRAY_BOTANY_POT = TILE_ENTITY_TYPES.register("ultra_hopper_gray_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ULTRA_HOPPER_GRAY_BOTANY_POT.get(), "Ultra"), ModBlocks.ULTRA_HOPPER_GRAY_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ULTRA_HOPPER_GREEN_BOTANY_POT = TILE_ENTITY_TYPES.register("ultra_hopper_green_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ULTRA_HOPPER_GREEN_BOTANY_POT.get(), "Ultra"), ModBlocks.ULTRA_HOPPER_GREEN_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ULTRA_HOPPER_LIGHT_BLUE_BOTANY_POT = TILE_ENTITY_TYPES.register("ultra_hopper_light_blue_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ULTRA_HOPPER_LIGHT_BLUE_BOTANY_POT.get(), "Ultra"), ModBlocks.ULTRA_HOPPER_LIGHT_BLUE_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ULTRA_HOPPER_LIGHT_GRAY_BOTANY_POT = TILE_ENTITY_TYPES.register("ultra_hopper_light_gray_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ULTRA_HOPPER_LIGHT_GRAY_BOTANY_POT.get(), "Ultra"), ModBlocks.ULTRA_HOPPER_LIGHT_GRAY_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ULTRA_HOPPER_LIME_BOTANY_POT = TILE_ENTITY_TYPES.register("ultra_hopper_lime_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ULTRA_HOPPER_LIME_BOTANY_POT.get(), "Ultra"), ModBlocks.ULTRA_HOPPER_LIME_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ULTRA_HOPPER_MAGENTA_BOTANY_POT = TILE_ENTITY_TYPES.register("ultra_hopper_magenta_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ULTRA_HOPPER_MAGENTA_BOTANY_POT.get(), "Ultra"), ModBlocks.ULTRA_HOPPER_MAGENTA_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ULTRA_HOPPER_ORANGE_BOTANY_POT = TILE_ENTITY_TYPES.register("ultra_hopper_orange_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ULTRA_HOPPER_ORANGE_BOTANY_POT.get(), "Ultra"), ModBlocks.ULTRA_HOPPER_ORANGE_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ULTRA_HOPPER_PINK_BOTANY_POT = TILE_ENTITY_TYPES.register("ultra_hopper_pink_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ULTRA_HOPPER_PINK_BOTANY_POT.get(), "Ultra"), ModBlocks.ULTRA_HOPPER_PINK_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ULTRA_HOPPER_PURPLE_BOTANY_POT = TILE_ENTITY_TYPES.register("ultra_hopper_purple_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ULTRA_HOPPER_PURPLE_BOTANY_POT.get(), "Ultra"), ModBlocks.ULTRA_HOPPER_PURPLE_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ULTRA_HOPPER_RED_BOTANY_POT = TILE_ENTITY_TYPES.register("ultra_hopper_red_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ULTRA_HOPPER_RED_BOTANY_POT.get(), "Ultra"), ModBlocks.ULTRA_HOPPER_RED_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ULTRA_HOPPER_WHITE_BOTANY_POT = TILE_ENTITY_TYPES.register("ultra_hopper_white_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ULTRA_HOPPER_WHITE_BOTANY_POT.get(), "Ultra"), ModBlocks.ULTRA_HOPPER_WHITE_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> ULTRA_HOPPER_YELLOW_BOTANY_POT = TILE_ENTITY_TYPES.register("ultra_hopper_yellow_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.ULTRA_HOPPER_YELLOW_BOTANY_POT.get(), "Ultra"), ModBlocks.ULTRA_HOPPER_YELLOW_BOTANY_POT.get())
            .build(null));

    //Creative
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> CREATIVE_BOTANY_POT = TILE_ENTITY_TYPES.register("creative_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.CREATIVE_BOTANY_POT.get(), "Creative"), ModBlocks.CREATIVE_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> CREATIVE_BLACK_BOTANY_POT = TILE_ENTITY_TYPES.register("creative_black_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.CREATIVE_BLACK_BOTANY_POT.get(), "Creative"), ModBlocks.CREATIVE_BLACK_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> CREATIVE_BLUE_BOTANY_POT = TILE_ENTITY_TYPES.register("creative_blue_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.CREATIVE_BLUE_BOTANY_POT.get(), "Creative"), ModBlocks.CREATIVE_BLUE_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> CREATIVE_BROWN_BOTANY_POT = TILE_ENTITY_TYPES.register("creative_brown_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.CREATIVE_BROWN_BOTANY_POT.get(), "Creative"), ModBlocks.CREATIVE_BROWN_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> CREATIVE_CYAN_BOTANY_POT = TILE_ENTITY_TYPES.register("creative_cyan_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.CREATIVE_CYAN_BOTANY_POT.get(), "Creative"), ModBlocks.CREATIVE_CYAN_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> CREATIVE_GRAY_BOTANY_POT = TILE_ENTITY_TYPES.register("creative_gray_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.CREATIVE_GRAY_BOTANY_POT.get(), "Creative"), ModBlocks.CREATIVE_GRAY_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> CREATIVE_GREEN_BOTANY_POT = TILE_ENTITY_TYPES.register("creative_green_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.CREATIVE_GREEN_BOTANY_POT.get(), "Creative"), ModBlocks.CREATIVE_GREEN_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> CREATIVE_LIGHT_BLUE_BOTANY_POT = TILE_ENTITY_TYPES.register("creative_light_blue_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.CREATIVE_LIGHT_BLUE_BOTANY_POT.get(), "Creative"), ModBlocks.CREATIVE_LIGHT_BLUE_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> CREATIVE_LIGHT_GRAY_BOTANY_POT = TILE_ENTITY_TYPES.register("creative_light_gray_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.CREATIVE_LIGHT_GRAY_BOTANY_POT.get(), "Creative"), ModBlocks.CREATIVE_LIGHT_GRAY_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> CREATIVE_LIME_BOTANY_POT = TILE_ENTITY_TYPES.register("creative_lime_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.CREATIVE_LIME_BOTANY_POT.get(), "Creative"), ModBlocks.CREATIVE_LIME_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> CREATIVE_MAGENTA_BOTANY_POT = TILE_ENTITY_TYPES.register("creative_magenta_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.CREATIVE_MAGENTA_BOTANY_POT.get(), "Creative"), ModBlocks.CREATIVE_MAGENTA_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> CREATIVE_ORANGE_BOTANY_POT = TILE_ENTITY_TYPES.register("creative_orange_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.CREATIVE_ORANGE_BOTANY_POT.get(), "Creative"), ModBlocks.CREATIVE_ORANGE_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> CREATIVE_PINK_BOTANY_POT = TILE_ENTITY_TYPES.register("creative_pink_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.CREATIVE_PINK_BOTANY_POT.get(), "Creative"), ModBlocks.CREATIVE_PINK_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> CREATIVE_PURPLE_BOTANY_POT = TILE_ENTITY_TYPES.register("creative_purple_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.CREATIVE_PURPLE_BOTANY_POT.get(), "Creative"), ModBlocks.CREATIVE_PURPLE_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> CREATIVE_RED_BOTANY_POT = TILE_ENTITY_TYPES.register("creative_red_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.CREATIVE_RED_BOTANY_POT.get(), "Creative"), ModBlocks.CREATIVE_RED_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> CREATIVE_WHITE_BOTANY_POT = TILE_ENTITY_TYPES.register("creative_white_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.CREATIVE_WHITE_BOTANY_POT.get(), "Creative"), ModBlocks.CREATIVE_WHITE_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> CREATIVE_YELLOW_BOTANY_POT = TILE_ENTITY_TYPES.register("creative_yellow_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.CREATIVE_YELLOW_BOTANY_POT.get(), "Creative"), ModBlocks.CREATIVE_YELLOW_BOTANY_POT.get())
            .build(null));

    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> CREATIVE_HOPPER_BOTANY_POT = TILE_ENTITY_TYPES.register("creative_hopper_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.CREATIVE_HOPPER_BOTANY_POT.get(), "Creative"), ModBlocks.CREATIVE_HOPPER_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> CREATIVE_HOPPER_BLACK_BOTANY_POT = TILE_ENTITY_TYPES.register("creative_hopper_black_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.CREATIVE_HOPPER_BLACK_BOTANY_POT.get(), "Creative"), ModBlocks.CREATIVE_HOPPER_BLACK_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> CREATIVE_HOPPER_BLUE_BOTANY_POT = TILE_ENTITY_TYPES.register("creative_hopper_blue_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.CREATIVE_HOPPER_BLUE_BOTANY_POT.get(), "Creative"), ModBlocks.CREATIVE_HOPPER_BLUE_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> CREATIVE_HOPPER_BROWN_BOTANY_POT = TILE_ENTITY_TYPES.register("creative_hopper_brown_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.CREATIVE_HOPPER_BROWN_BOTANY_POT.get(), "Creative"), ModBlocks.CREATIVE_HOPPER_BROWN_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> CREATIVE_HOPPER_CYAN_BOTANY_POT = TILE_ENTITY_TYPES.register("creative_hopper_cyan_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.CREATIVE_HOPPER_CYAN_BOTANY_POT.get(), "Creative"), ModBlocks.CREATIVE_HOPPER_CYAN_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> CREATIVE_HOPPER_GRAY_BOTANY_POT = TILE_ENTITY_TYPES.register("creative_hopper_gray_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.CREATIVE_HOPPER_GRAY_BOTANY_POT.get(), "Creative"), ModBlocks.CREATIVE_HOPPER_GRAY_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> CREATIVE_HOPPER_GREEN_BOTANY_POT = TILE_ENTITY_TYPES.register("creative_hopper_green_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.CREATIVE_HOPPER_GREEN_BOTANY_POT.get(), "Creative"), ModBlocks.CREATIVE_HOPPER_GREEN_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> CREATIVE_HOPPER_LIGHT_BLUE_BOTANY_POT = TILE_ENTITY_TYPES.register("creative_hopper_light_blue_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.CREATIVE_HOPPER_LIGHT_BLUE_BOTANY_POT.get(), "Creative"), ModBlocks.CREATIVE_HOPPER_LIGHT_BLUE_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> CREATIVE_HOPPER_LIGHT_GRAY_BOTANY_POT = TILE_ENTITY_TYPES.register("creative_hopper_light_gray_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.CREATIVE_HOPPER_LIGHT_GRAY_BOTANY_POT.get(), "Creative"), ModBlocks.CREATIVE_HOPPER_LIGHT_GRAY_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> CREATIVE_HOPPER_LIME_BOTANY_POT = TILE_ENTITY_TYPES.register("creative_hopper_lime_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.CREATIVE_HOPPER_LIME_BOTANY_POT.get(), "Creative"), ModBlocks.CREATIVE_HOPPER_LIME_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> CREATIVE_HOPPER_MAGENTA_BOTANY_POT = TILE_ENTITY_TYPES.register("creative_hopper_magenta_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.CREATIVE_HOPPER_MAGENTA_BOTANY_POT.get(), "Creative"), ModBlocks.CREATIVE_HOPPER_MAGENTA_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> CREATIVE_HOPPER_ORANGE_BOTANY_POT = TILE_ENTITY_TYPES.register("creative_hopper_orange_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.CREATIVE_HOPPER_ORANGE_BOTANY_POT.get(), "Creative"), ModBlocks.CREATIVE_HOPPER_ORANGE_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> CREATIVE_HOPPER_PINK_BOTANY_POT = TILE_ENTITY_TYPES.register("creative_hopper_pink_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.CREATIVE_HOPPER_PINK_BOTANY_POT.get(), "Creative"), ModBlocks.CREATIVE_HOPPER_PINK_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> CREATIVE_HOPPER_PURPLE_BOTANY_POT = TILE_ENTITY_TYPES.register("creative_hopper_purple_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.CREATIVE_HOPPER_PURPLE_BOTANY_POT.get(), "Creative"), ModBlocks.CREATIVE_HOPPER_PURPLE_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> CREATIVE_HOPPER_RED_BOTANY_POT = TILE_ENTITY_TYPES.register("creative_hopper_red_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.CREATIVE_HOPPER_RED_BOTANY_POT.get(), "Creative"), ModBlocks.CREATIVE_HOPPER_RED_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> CREATIVE_HOPPER_WHITE_BOTANY_POT = TILE_ENTITY_TYPES.register("creative_hopper_white_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.CREATIVE_HOPPER_WHITE_BOTANY_POT.get(), "Creative"), ModBlocks.CREATIVE_HOPPER_WHITE_BOTANY_POT.get())
            .build(null));
    public static final RegistryObject<TileEntityType<TieredTileEntityBotanyPot>> CREATIVE_HOPPER_YELLOW_BOTANY_POT = TILE_ENTITY_TYPES.register("creative_hopper_yellow_botany_pot", () -> TileEntityType.Builder
            .of(() -> new TieredTileEntityBotanyPot(ModTileEntityTypes.CREATIVE_HOPPER_YELLOW_BOTANY_POT.get(), "Creative"), ModBlocks.CREATIVE_HOPPER_YELLOW_BOTANY_POT.get())
            .build(null));
}
