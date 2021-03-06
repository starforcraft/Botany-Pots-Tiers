package com.YTrollman.BotanyPotsTiers.renderer;

import com.YTrollman.BotanyPotsTiers.tileentity.TieredTileEntityBotanyPot;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.darkhax.bookshelf.block.DisplayableBlockState;
import net.darkhax.botanypots.BotanyPots;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TieredRendererBotanyPot extends TileEntityRenderer<TieredTileEntityBotanyPot> {

    private static final Direction[] SOIL_SIDES = new Direction[]{Direction.UP};
    private static final Direction[] CROP_SIDES = new Direction[]{Direction.UP, Direction.NORTH, Direction.SOUTH, Direction.WEST, Direction.EAST};

    public TieredRendererBotanyPot(TileEntityRendererDispatcher dispatcher) {

        super(dispatcher);
    }

    @Override
    public void render(TieredTileEntityBotanyPot tile, float partial, MatrixStack matrix, IRenderTypeBuffer buffer, int light, int overlay) {

        if (tile.getSoil() != null && BotanyPots.CLIENT_CONFIG.shouldRenderSoil()) {

            matrix.pushPose();
            matrix.scale(0.625f, 0.384f, 0.625f);
            matrix.translate(0.3, 0.01, 0.3);
            tile.getSoil().getRenderState().render(tile.getLevel(), tile.getBlockPos(), matrix, buffer, light, overlay, SOIL_SIDES);
            matrix.popPose();
        }

        if (tile.getCrop() != null && BotanyPots.CLIENT_CONFIG.shouldRenderCrop()) {

            matrix.pushPose();
            matrix.translate(0.5, 0.40, 0.5);

            if (BotanyPots.CLIENT_CONFIG.shouldDoGrowthAnimation()) {

                final float partialOffset = tile.getCurrentGrowthTicks() < tile.getTotalGrowthTicks() ? partial : 0f;
                final float progressScale = 0.25f + (tile.getCurrentGrowthTicks() + partialOffset) / tile.getTotalGrowthTicks() * 0.75f;
                final float growth = MathHelper.clamp(progressScale * 0.625f, 0, 1f);
                matrix.scale(growth, growth, growth);
            }

            matrix.translate(-0.5, 0, -0.5);

            final DisplayableBlockState[] cropStates = tile.getCrop().getDisplayState();

            for (int i = 0; i < cropStates.length; i++) {

                matrix.translate(0, i, 0);
                cropStates[i].render(tile.getLevel(), tile.getBlockPos(), matrix, buffer, light, overlay, CROP_SIDES);
                matrix.translate(0, -i, 0);
            }

            matrix.popPose();
        }
    }
}