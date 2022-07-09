package com.YTrollman.BotanyPotsTiers.registry;

import com.YTrollman.BotanyPotsTiers.BotanyPotsTiers;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

public class ItemGroupBotanyPotsTiers {

    public static final ItemGroup BOTANY_POTS_TIERS = (new ItemGroup(BotanyPotsTiers.MOD_ID) {

        @Override
        @Nonnull
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.ELITE_BOTANY_POT.get());
        }
    });

}
