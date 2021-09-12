package com.YTrollman.BotanyPotsTiers.registry;

import com.YTrollman.BotanyPotsTiers.BotanyPotsTiers;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import net.darkhax.botanypots.addons.jei.CategoryCrop;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

@JeiPlugin
public class BotanyPotsPlugin implements IModPlugin {
    @Nonnull
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(BotanyPotsTiers.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.ELITE_BOTANY_POT.get()), CategoryCrop.ID);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.ELITE_HOPPER_BOTANY_POT.get()), CategoryCrop.ID);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.ULTRA_BOTANY_POT.get()), CategoryCrop.ID);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.ULTRA_HOPPER_BOTANY_POT.get()), CategoryCrop.ID);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.CREATIVE_BOTANY_POT.get()), CategoryCrop.ID);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.CREATIVE_HOPPER_BOTANY_POT.get()), CategoryCrop.ID);
    }
}
