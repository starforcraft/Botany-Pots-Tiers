package com.ultramega.botanypotstiers.impl;

import com.ultramega.botanypotstiers.common.impl.BotanyPotsTiersMod;
import com.ultramega.botanypotstiers.common.impl.PotTier;
import com.ultramega.botanypotstiers.common.impl.block.entity.TieredBotanyPotBlockEntity;

import net.minecraft.core.Direction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.items.wrapper.SidedInvWrapper;

@Mod(BotanyPotsTiersMod.MOD_ID)
public class NeoForgeMod {
    public NeoForgeMod(IEventBus bus) {
        BotanyPotsTiersMod.init();
        bus.addListener(NeoForgeMod::registerCapabilities);
    }

    private static void registerCapabilities(RegisterCapabilitiesEvent event) {
        for (PotTier tier : PotTier.values()) {
            event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, TieredBotanyPotBlockEntity.getType(tier).get(), (be, side) -> {
                if (side == Direction.DOWN) {
                    return new SidedInvWrapper(be, Direction.DOWN);
                }
                return null;
            });
        }
    }
}