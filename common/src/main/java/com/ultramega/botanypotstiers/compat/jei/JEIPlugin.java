package com.ultramega.botanypotstiers.compat.jei;

import com.ultramega.botanypotstiers.Constants;
import com.ultramega.botanypotstiers.TieredBotanyPotsCommon;
import com.ultramega.botanypotstiers.block.TieredBlockBotanyPot;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

@JeiPlugin
public class JEIPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(Constants.MOD_ID, Constants.MOD_ID);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        for (Item potItem : TieredBotanyPotsCommon.content.items) {
            if (potItem instanceof BlockItem blockItem && blockItem.getBlock() instanceof TieredBlockBotanyPot) {
                registration.addRecipeCatalyst(potItem.getDefaultInstance(), net.darkhax.botanypots.addons.jei.JEIPlugin.CROP);
            }
        }
    }
}
