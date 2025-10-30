package com.ultramega.botanypotstiers.compat.rei;

import com.ultramega.botanypotstiers.TieredBotanyPotsCommon;
import com.ultramega.botanypotstiers.block.TieredBlockBotanyPot;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

public class REIPlugin implements REIClientPlugin {
    @Override
    public void registerCategories(CategoryRegistry registry) {
        EntryIngredient.Builder builder = EntryIngredient.builder();

        for (Item potItem : TieredBotanyPotsCommon.content.items) {
            if (potItem instanceof BlockItem blockItem && blockItem.getBlock() instanceof TieredBlockBotanyPot) {
                builder.add(EntryStacks.of(potItem));
            }
        }

        registry.addWorkstations(net.darkhax.botanypots.addons.rei.REIPlugin.CROP, builder.build());
    }
}
