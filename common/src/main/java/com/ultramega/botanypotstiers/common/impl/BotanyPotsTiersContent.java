package com.ultramega.botanypotstiers.common.impl;

import com.ultramega.botanypotstiers.common.impl.block.TieredBotanyPotBlock;
import com.ultramega.botanypotstiers.common.impl.block.entity.TieredBotanyPotBlockEntity;
import com.ultramega.botanypotstiers.common.impl.data.TieredBotanyPotFileGenerator;
import com.ultramega.botanypotstiers.common.impl.data.conditions.ConfigLoadCondition;
import com.ultramega.botanypotstiers.common.impl.item.UpgradeItem;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

import com.mojang.serialization.MapCodec;
import net.darkhax.bookshelf.common.api.data.conditions.ILoadCondition;
import net.darkhax.bookshelf.common.api.function.CachedSupplier;
import net.darkhax.bookshelf.common.api.registry.ContentProvider;
import net.darkhax.bookshelf.common.api.registry.adapters.GameRegistryAdapter;
import net.darkhax.bookshelf.common.api.registry.adapters.GenericRegistryAdapter;
import net.darkhax.bookshelf.common.api.service.Services;
import net.darkhax.bookshelf.common.impl.registry.adapter.BlockEntityRendererAdapter;
import net.darkhax.bookshelf.common.impl.registry.adapter.BlockRegistryAdapter;
import net.darkhax.bookshelf.common.impl.registry.adapter.BlockRenderTypeAdapter;
import net.darkhax.bookshelf.common.impl.registry.adapter.CreativeModeTabAdapter;
import net.darkhax.bookshelf.common.impl.registry.adapter.MenuScreenAdapter;
import net.darkhax.bookshelf.common.impl.registry.adapter.MenuTypeAdapter;
import net.darkhax.botanypots.common.impl.block.BotanyPotRenderer;
import net.darkhax.botanypots.common.impl.block.PotType;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.material.MapColor;

public class BotanyPotsTiersContent implements ContentProvider {
    public static final Supplier<ItemStack> TAB_ICON = CachedSupplier.cache(() -> BuiltInRegistries.ITEM.get(BotanyPotsTiersMod.id("elite_terracotta_botany_pot")).getDefaultInstance());
    private static final String[] BRICK_TYPES = {"brick", "stone", "mossy_stone", "deepslate", "tuff", "mud", "prismarine", "nether", "red_nether", "polished_blackstone", "end_stone", "quartz"};
    private final Map<ResourceLocation, TieredBotanyPotBlock> allPotBlocks = new LinkedHashMap<>();
    private final Map<ResourceLocation, Item> allUpgradeItems = new LinkedHashMap<>();

    public BotanyPotsTiersContent() {
        //generatePotFiles();
    }

    private void generatePotFiles() {
        final TieredBotanyPotFileGenerator gen = new TieredBotanyPotFileGenerator(new File("outdir"), BotanyPotsTiersMod.MOD_ID);
        make(gen, "terracotta");
        for (DyeColor color : DyeColor.values()) {
            make(gen, color.getName() + "_terracotta");
            make(gen, color.getName() + "_glazed_terracotta");
            make(gen, color.getName() + "_concrete");
        }
        for (String brickType : BRICK_TYPES) {
            make(gen, "brick".equals(brickType) ? "bricks" : brickType + "_bricks");
        }
    }

    private void make(TieredBotanyPotFileGenerator gen, String block) {
        final ResourceLocation blockId = ResourceLocation.withDefaultNamespace(block);
        for (PotTier tier : PotTier.values()) {
            gen.potRecipes(blockId, tier);
            gen.models(blockId, tier);
            gen.lootTables(blockId, tier);
        }
    }

    @Override
    public void defineBlocks(BlockRegistryAdapter registry) {
        for (PotTier tier : PotTier.values()) {
            createPots(registry, "terracotta", tier);
            for (DyeColor color : DyeColor.values()) {
                createPots(registry, color.getName() + "_terracotta", tier);
                createPots(registry, color.getName() + "_glazed_terracotta", tier);
                createPots(registry, color.getName() + "_concrete", tier);
            }
            for (String brickType : BRICK_TYPES) {
                createPots(registry, "brick".equals(brickType) ? "bricks" : brickType + "_bricks", tier);
            }
        }
    }

    private void createPots(BlockRegistryAdapter registry, String name, PotTier tier) {
        final ResourceLocation blockId = ResourceLocation.withDefaultNamespace(name);
        final MapColor color = BuiltInRegistries.BLOCK.containsKey(blockId) ? BuiltInRegistries.BLOCK.get(blockId).defaultMapColor() : MapColor.COLOR_ORANGE;
        definePot(registry, tier.getName() + "_" + name + "_botany_pot", new TieredBotanyPotBlock(color, PotType.BASIC, tier));
        definePot(registry, tier.getName() + "_" + name + "_hopper_botany_pot", new TieredBotanyPotBlock(color, PotType.HOPPER, tier));
        definePot(registry, tier.getName() + "_" + name + "_waxed_botany_pot", new TieredBotanyPotBlock(color, PotType.WAXED, tier));
    }

    private void definePot(BlockRegistryAdapter registry, String id, TieredBotanyPotBlock block) {
        final ResourceLocation blockId = ResourceLocation.fromNamespaceAndPath(this.namespace(), id);
        registry.addPlaceable(id, () -> block);
        allPotBlocks.put(blockId, block);
    }

    @Override
    public void defineItems(final GameRegistryAdapter<Item> registry) {
        for (PotTier tier : PotTier.values()) {
            final String id = tier.getName() + "_upgrade";
            final ResourceLocation itemId = ResourceLocation.fromNamespaceAndPath(this.namespace(), id);
            final Item item = new UpgradeItem(new Item.Properties().stacksTo(1), tier);
            registry.add(id, () -> item);
            allUpgradeItems.put(itemId, item);
        }
    }

    @Override
    public void defineBlockEntities(GameRegistryAdapter<BlockEntityType<?>> registry) {
        for (PotTier tier : PotTier.values()) {
            registry.add(tier.getName() + "_botany_pot",
                Services.GAMEPLAY.blockEntityBuilder((pos, state) -> new TieredBotanyPotBlockEntity(pos, state, tier),
                    this.allPotBlocks.values().stream()
                        .filter(block -> block.getTier() == tier)
                        .toArray(Block[]::new)).build(null));
        }
    }

    @Override
    public void defineMenuType(MenuTypeAdapter registry) {
        //registry.add("tiered_basic_pot_menu", TieredBotanyPotMenu::basicMenuClient);
        //registry.add("tiered_hopper_pot_menu", TieredBotanyPotMenu::hopperMenuClient);
    }

    @Override
    public void defineLoadConditions(GenericRegistryAdapter<MapCodec<? extends ILoadCondition>> registry) {
        registry.add(ConfigLoadCondition.TYPE_ID, ConfigLoadCondition.CODEC);
    }

    @Override
    public void defineCreativeTabs(CreativeModeTabAdapter registry) {
        registry.add("tab", TAB_ICON, (params, builder) -> {
            for (Item item : this.allUpgradeItems.values()) {
                builder.accept(item);
            }
            for (Block block : this.allPotBlocks.values()) {
                builder.accept(block.asItem());
            }
        });
    }

    @Override
    public void defineBlockRenderers(BlockEntityRendererAdapter registry) {
        for (PotTier tier : PotTier.values()) {
            registry.bind(TieredBotanyPotBlockEntity.getType(tier).get(), BotanyPotRenderer::new);
        }
    }

    @Override
    public void defineMenuScreens(MenuScreenAdapter registry) {
        //registry.bind(TieredBotanyPotMenu.BASIC_MENU.get(), TieredBotanyPotScreen::new);
        //registry.bind(TieredBotanyPotMenu.HOPPER_MENU.get(), TieredBotanyPotScreen::new);
    }

    @Override
    public void defineBlockRenderTypes(BlockRenderTypeAdapter registry) {
        for (Block block : this.allPotBlocks.values()) {
            registry.add(block, RenderType.cutout());
        }
    }

    @Override
    public String namespace() {
        return BotanyPotsTiersMod.MOD_ID;
    }
}
