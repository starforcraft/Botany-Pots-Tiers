package com.ultramega.botanypotstiers;

import com.ultramega.botanypotstiers.block.TieredBlockBotanyPot;
import com.ultramega.botanypotstiers.block.TieredBlockEntityBotanyPot;
import net.darkhax.bookshelf.api.Services;
import net.darkhax.bookshelf.api.registry.RegistryDataProvider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.Set;
import java.util.stream.Collectors;

public class Content extends RegistryDataProvider {
    public Content() {
        super(Constants.MOD_ID);

        this.withItemTab(() -> new ItemStack(BuiltInRegistries.ITEM.get(new ResourceLocation(Constants.MOD_ID, "elite_terracotta_botany_pot"))));
        this.withAutoItemBlocks();

        for(PotTiers tier : PotTiers.values()) {
            // Basic Pot
            this.blocks.add(() -> new TieredBlockBotanyPot(tier, false), tier.getName() + "_terracotta_botany_pot");
            this.blocks.add(() -> new TieredBlockBotanyPot(tier, true), tier.getName() + "_terracotta_hopper_botany_pot");

            for (DyeColor color : DyeColor.values()) {
                final BlockBehaviour.Properties properties = Block.Properties.of().mapColor(color).strength(1.25F, 4.2F).noOcclusion();

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

        for(PotTiers tier : PotTiers.values()) {
            this.blockEntities.add(() -> Services.CONSTRUCTS.blockEntityType((pos, state) -> new TieredBlockEntityBotanyPot(tier, pos, state), this::getAllPots).get(), tier.getName() + "_botany_pot");
        }
    }

    private Set<Block> getAllPots() {
        return this.blocks.getEntries().values().stream().filter(b -> b instanceof TieredBlockBotanyPot).collect(Collectors.toSet());
    }
}