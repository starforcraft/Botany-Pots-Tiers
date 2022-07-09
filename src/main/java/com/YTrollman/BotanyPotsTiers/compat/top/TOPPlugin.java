package com.YTrollman.BotanyPotsTiers.compat.top;

import com.YTrollman.BotanyPotsTiers.BotanyPotsTiers;
import com.YTrollman.BotanyPotsTiers.blocks.TieredBlockBotanyPot;
import com.YTrollman.BotanyPotsTiers.tileentity.TieredTileEntityBotanyPot;
import mcjty.theoneprobe.api.*;
import mcjty.theoneprobe.apiimpl.styles.ProgressStyle;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import java.text.DecimalFormat;
import java.util.function.Function;

@SuppressWarnings("unused")
public class TOPPlugin implements Function<ITheOneProbe, Void>, IProbeInfoProvider {

    private static final DecimalFormat format = new DecimalFormat("#");

    @Override
    public String getID() {
        return BotanyPotsTiers.MOD_ID + ":top_support";
    }

    @Override
    public Void apply(ITheOneProbe top) {
        top.registerProvider(this);
        return null;
    }

    @Override
    public void addProbeInfo(ProbeMode mode, IProbeInfo info, PlayerEntity player, World world, BlockState state, IProbeHitData hit) {
        final Block block = state.getBlock();

        if (block instanceof TieredBlockBotanyPot) {

            final TileEntity tile = world.getBlockEntity(hit.getPos());

            if (tile instanceof TieredTileEntityBotanyPot) {

                this.addPotInfo((TieredTileEntityBotanyPot) tile, ((TieredBlockBotanyPot) block).isHopper(), info);
            }
        }
    }

    private void addPotInfo(TieredTileEntityBotanyPot pot, boolean isHopper, IProbeInfo info) {
        if (pot.getSoil() != null) {

            // I would like to use Block#getTranslatedName but it is client only and this is a
            // server environment.
            info.text(new TranslationTextComponent("botanypots.tooltip.soil", new TranslationTextComponent(pot.getSoil().getRenderState().getState().getBlock().getDescriptionId())));
        }

        if (pot.getCrop() != null) {

            // I would like to use Block#getTranslatedName but it is client only and this is a
            // server environment.
            info.text(new TranslationTextComponent("botanypots.tooltip.crop", new TranslationTextComponent(pot.getCrop().getDisplayState()[0].getState().getBlock().getDescriptionId())));
        }

        if (pot.getCurrentGrowthTicks() > 0) {

            final int ticksRemaining = pot.getTotalGrowthTicks() - pot.getCurrentGrowthTicks();
            info.text(new TranslationTextComponent("botanypots.tooltip.growth_time", ticksToElapsedTime(ticksRemaining)));
        }

        if (pot.getCrop() != null && pot.getSoil() != null) {

            final ProgressStyle style = new ProgressStyle();
            style.filledColor(0xff32CD32);
            style.alternateFilledColor(0xff259925);
            style.prefix("Progress: "); // TODO This can't be translated?
            style.suffix("%");
            final int f = MathHelper.floor(pot.getGrowthPercent() * 100f);
            info.progress(f, 100, style);
        }
    }

    private static String ticksToElapsedTime(int ticks) {
        int i = ticks / 20;
        final int j = i / 60;
        i = i % 60;
        return i < 10 ? j + ":0" + i : j + ":" + i;
    }
}
