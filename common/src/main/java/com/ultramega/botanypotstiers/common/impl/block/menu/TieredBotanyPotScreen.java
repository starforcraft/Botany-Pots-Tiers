/*package com.ultramega.botanypotstiers.common.impl.block.menu;

import com.ultramega.botanypotstiers.common.api.context.TieredBlockEntityContext;
import com.ultramega.botanypotstiers.common.impl.block.entity.TieredBotanyPotBlockEntity;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;

import net.darkhax.bookshelf.common.api.function.SidedReloadableCache;
import net.darkhax.botanypots.common.api.data.components.CropOverride;
import net.darkhax.botanypots.common.api.data.components.SoilOverride;
import net.darkhax.botanypots.common.api.data.recipes.BotanyPotRecipe;
import net.darkhax.botanypots.common.api.data.recipes.RecipeCache;
import net.darkhax.botanypots.common.api.data.recipes.crop.Crop;
import net.darkhax.botanypots.common.api.data.recipes.fertilizer.Fertilizer;
import net.darkhax.botanypots.common.api.data.recipes.interaction.PotInteraction;
import net.darkhax.botanypots.common.api.data.recipes.soil.Soil;
import net.darkhax.botanypots.common.impl.BotanyPotsMod;
import net.darkhax.botanypots.common.impl.Helpers;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class TieredBotanyPotScreen extends AbstractContainerScreen<TieredBotanyPotMenu> {
    private static final ResourceLocation RECIPE_BUTTON_LOCATION = BotanyPotsMod.id("textures/gui/recipe_button.png");
    private final ResourceLocation backgroundTexture;

    public TieredBotanyPotScreen(TieredBotanyPotMenu menu, Inventory playerInv, Component name) {
        super(menu, playerInv, name);
        this.backgroundTexture = BotanyPotsMod.id("textures/gui/container/" + (menu.isHopper ? "hopper_botany_pot_gui.png" : "botany_pot_gui.png"));
    }

    @Override
    protected void renderBg(GuiGraphics graphics, float delta, int mouseX, int mouseY) {
        graphics.blit(this.backgroundTexture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
    }

    @Override
    public void render(@NotNull GuiGraphics graphics, int mouseX, int mouseY, float tickDelta) {
        super.render(graphics, mouseX, mouseY, tickDelta);
        this.renderTooltip(graphics, mouseX, mouseY);
    }

    @NotNull
    @Override
    protected List<Component> getTooltipFromContainerItem(@NotNull ItemStack stack) {
        final List<Component> tooltips = super.getTooltipFromContainerItem(stack);
        final TieredBlockEntityContext context = this.menu.getContext();
        if (context != null) {
            if (stack == this.menu.getItems().get(TieredBotanyPotBlockEntity.SOIL_SLOT)) {
                stack = context.getItem(TieredBotanyPotBlockEntity.SOIL_SLOT);
            }
            else if (stack == this.menu.getItems().get(TieredBotanyPotBlockEntity.SEED_SLOT)) {
                stack = context.getItem(TieredBotanyPotBlockEntity.SEED_SLOT);
            }
            final Level level = context.pot().getLevel();
            if (!addComponentTooltip(SoilOverride.TYPE.get(), SoilOverride::soil, stack, context, level, tooltips)) {
                addRecipeTooltips(Soil.CACHE, stack, context, level, tooltips);
            }
            if (!addComponentTooltip(CropOverride.TYPE.get(), CropOverride::crop, stack, context, level, tooltips)) {
                addRecipeTooltips(Crop.CACHE, stack, context, level, tooltips);
            }
            addRecipeTooltips(Fertilizer.CACHE, stack, context, level, tooltips);
            addRecipeTooltips(PotInteraction.CACHE, stack, context, level, tooltips);
            if (stack.is(TieredBotanyPotMenu.HARVEST_ITEM) && level != null) {
                final float modifier = Helpers.efficiencyModifier(level.registryAccess(), stack);
                if (modifier != 0f) {
                    tooltips.add(Helpers.growthModifierComponent(modifier));
                }
            }
        }
        return tooltips;
    }

    private static <T extends BotanyPotRecipe, W> boolean addComponentTooltip(DataComponentType<W> componentType, Function<W, T> func, ItemStack stack, TieredBlockEntityContext context, Level level, List<Component> tooltips) {
        if (stack.has(componentType)) {
            func.apply(stack.get(componentType)).hoverTooltip(stack, context, level, tooltips::add);
            return true;
        }
        return false;
    }

    private static <T extends BotanyPotRecipe> void addRecipeTooltips(SidedReloadableCache<RecipeCache<T>> cache, ItemStack stack, TieredBlockEntityContext context, Level level, List<Component> tooltips) {
        final RecipeHolder<T> recipe = Objects.requireNonNull(cache.apply(level)).lookup(stack, context, level);
        if (recipe != null) {
            recipe.value().hoverTooltip(stack, context, level, tooltips::add);
        }
    }
}*/
