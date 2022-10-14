package com.ultramega.botanypotstiers;

import com.ultramega.botanypotstiers.block.TieredBlockBotanyPot;
import com.ultramega.botanypotstiers.block.TieredBlockEntityBotanyPot;
import com.ultramega.botanypotstiers.block.inv.TieredBotanyPotMenu;
import com.ultramega.botanypotstiers.data.recipes.crop.BasicCropSerializer;
import com.ultramega.botanypotstiers.data.recipes.fertilizer.BasicFertilizerSerializer;
import com.ultramega.botanypotstiers.data.recipes.potinteraction.BasicPotInteractionSerializer;
import com.ultramega.botanypotstiers.data.recipes.soil.BasicSoilSerializer;
import net.darkhax.bookshelf.api.Services;
import net.darkhax.bookshelf.api.registry.RegistryDataProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

import java.util.Set;
import java.util.stream.Collectors;

public class Content extends RegistryDataProvider {
    public Content() {
        super(Constants.MOD_ID);

        this.withCreativeTab(() -> Services.REGISTRIES.items().get(new ResourceLocation(Constants.MOD_ID, "elite_terracotta_botany_pot")));
        this.withAutoItemBlocks();
        this.bindBlockRenderLayers();

        // Recipe Types
        this.recipeTypes.add("soil");
        this.recipeTypes.add("crop");
        this.recipeTypes.add("pot_interaction");
        this.recipeTypes.add("fertilizer");

        // Recipe Serializers
        this.recipeSerializers.add(() -> BasicSoilSerializer.SERIALIZER, "soil");
        this.recipeSerializers.add(() -> BasicCropSerializer.SERIALIZER, "crop");
        this.recipeSerializers.add(() -> BasicPotInteractionSerializer.SERIALIZER, "pot_interaction");
        this.recipeSerializers.add(() -> BasicFertilizerSerializer.SERIALIZER, "fertilizer");

        for(PotTiers tier : PotTiers.values()) {
            // Basic Pot
            this.blocks.add(() -> new TieredBlockBotanyPot(tier, false), tier.getName() + "_terracotta_botany_pot");
            this.blocks.add(() -> new TieredBlockBotanyPot(tier, true), tier.getName() + "_terracotta_hopper_botany_pot");

            for (DyeColor color : DyeColor.values()) {
                final BlockBehaviour.Properties properties = Block.Properties.of(Material.CLAY, color.getMaterialColor()).strength(1.25F, 4.2F).noOcclusion();

                // Coloured Terracotta
                this.blocks.add(() -> new TieredBlockBotanyPot(tier, properties, false), tier.getName() + "_" + color.getName() + "_terracotta_botany_pot");
                this.blocks.add(() -> new TieredBlockBotanyPot(tier, properties, true), tier.getName() + "_" + color.getName() + "_terracotta_hopper_botany_pot");

                // Coloured Concrete
                this.blocks.add(() -> new TieredBlockBotanyPot(tier, properties, false), tier.getName() + "_" + color.getName() + "_concrete_botany_pot");
                this.blocks.add(() -> new TieredBlockBotanyPot(tier, properties, true), tier.getName() + "_" + color.getName() + "_concrete_hopper_botany_pot");

                // Glazed Terracotta
                this.blocks.add(() -> new TieredBlockBotanyPot(tier, properties, false), tier.getName() + "_" + color.getName() + "_glazed_terracotta_botany_pot");
                this.blocks.add(() -> new TieredBlockBotanyPot(tier, properties, true), tier.getName() + "_" + color.getName() + "_glazed_terracotta_hopper_botany_pot");
            }
        }

        this.blockEntities.add(() -> Services.CONSTRUCTS.blockEntityType(TieredBlockEntityBotanyPot::new, this::getAllPots).get(), "botany_pot");
        this.menus.add(() -> Services.CONSTRUCTS.menuType(TieredBotanyPotMenu::fromNetwork), "pot_menu");
    }

    private Set<Block> getAllPots() {
        return this.blocks.getEntries().values().stream().filter(b -> b instanceof TieredBlockBotanyPot).collect(Collectors.toSet());
    }
}