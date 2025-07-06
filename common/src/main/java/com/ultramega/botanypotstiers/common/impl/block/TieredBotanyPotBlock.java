package com.ultramega.botanypotstiers.common.impl.block;

import com.ultramega.botanypotstiers.common.impl.PotTier;
import com.ultramega.botanypotstiers.common.impl.block.entity.TieredBotanyPotBlockEntity;

import java.util.List;

import net.darkhax.botanypots.common.api.context.BotanyPotContext;
import net.darkhax.botanypots.common.api.data.recipes.crop.Crop;
import net.darkhax.botanypots.common.api.data.recipes.soil.Soil;
import net.darkhax.botanypots.common.impl.block.BotanyPotBlock;
import net.darkhax.botanypots.common.impl.block.PotType;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TieredBotanyPotBlock extends BotanyPotBlock {
    private final PotTier tier;

    public TieredBotanyPotBlock(final MapColor color, final PotType type, final PotTier tier) {
        super(color, type);
        this.tier = tier;
    }

    public TieredBotanyPotBlock(final Properties properties, final PotType type, final PotTier tier) {
        super(properties, type);
        this.tier = tier;
    }

    @Override
    public float getGrowthModifier(final BotanyPotContext context, final Level level, final Crop crop, @Nullable final Soil soil) {
        return this.tier.getSpeedMultiplier();
    }

    @Override
    public float getYieldModifier(final BotanyPotContext context, final Level level, final Crop crop, @Nullable final Soil soil) {
        return this.tier.getOutputMultiplier();
    }

    @Override
    public void appendHoverText(final ItemStack stack, final Item.TooltipContext context, final List<Component> components, final TooltipFlag tooltipFlag) {
        if (Screen.hasShiftDown()) {
            components.add(Component.translatable("tooltip.botanypotstiers.tiered_botany_pot.multiplier", tier.getOutputMultiplier())
                .withStyle(ChatFormatting.AQUA));
            components.add(Component.translatable("tooltip.botanypotstiers.tiered_botany_pot.speed", tier.getSpeedMultiplier())
                .withStyle(ChatFormatting.AQUA));
        } else {
            components.add(Component.translatable("tooltip.botanypotstiers.tiered_botany_pot.pressShiftForMore")
                .withStyle(ChatFormatting.YELLOW));
        }
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level level, @NotNull BlockState state, @NotNull BlockEntityType<T> type) {
        return createTickerHelper(type, TieredBotanyPotBlockEntity.getType(tier).get(), (level1, pos, state1, pot) ->
            TieredBotanyPotBlockEntity.tickPot(level1, pos, state1, (TieredBotanyPotBlockEntity) pot));
    }

    @Override
    public BlockEntity newBlockEntity(@NotNull final BlockPos pos, @NotNull final BlockState state) {
        return new TieredBotanyPotBlockEntity(pos, state, tier);
    }

    public PotTier getTier() {
        return tier;
    }
}
