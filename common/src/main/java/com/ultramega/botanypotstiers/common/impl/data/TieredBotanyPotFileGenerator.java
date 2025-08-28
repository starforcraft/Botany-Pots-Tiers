package com.ultramega.botanypotstiers.common.impl.data;

import com.ultramega.botanypotstiers.common.impl.PotTier;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import net.darkhax.botanypots.common.impl.BotanyPotsMod;
import net.minecraft.resources.ResourceLocation;

public class TieredBotanyPotFileGenerator {
    private final File outDir;
    private final String ownerId;

    public TieredBotanyPotFileGenerator(File outDir, String ownerId) {
        this.outDir = outDir;
        this.ownerId = ownerId;
    }

    public void potRecipes(ResourceLocation material, PotTier tier) {
        final File potsDir = setup(new File(outDir, "data/" + this.ownerId + "/recipe/pots"));
        basicPotUpgradeRecipe(potsDir, material, tier);
        basicPotUpgradeSameMaterialRecipe(potsDir, material, tier);
        hopperPotUpgradeRecipe(potsDir, material, tier);
        hopperPotUpgradeSameMaterialRecipe(potsDir, material, tier);
        hopperPotRecipe(potsDir, material, tier);
        quickHopperUpgradePotRecipe(potsDir, material, tier);
        quickHopperUpgradePotSameMaterialRecipe(potsDir, material, tier);
        waxedPotRecipe(potsDir, material, tier);
    }

    public void lootTables(ResourceLocation material, PotTier tier) {
        final File lootDir = setup(new File(outDir, "data/" + this.ownerId + "/loot_table/blocks"));
        final String prefix = tier.getName() + "_" + material.getPath();
        lootTable(lootDir, ResourceLocation.fromNamespaceAndPath(this.ownerId, prefix + "_botany_pot"));
        lootTable(lootDir, ResourceLocation.fromNamespaceAndPath(this.ownerId, prefix + "_hopper_botany_pot"));
        lootTable(lootDir, ResourceLocation.fromNamespaceAndPath(this.ownerId, prefix + "_waxed_botany_pot"));
    }

    public void models(ResourceLocation material, PotTier tier) {
        final File modelDir = setup(new File(outDir, "assets/" + this.ownerId + "/models"));
        final File blockDir = setup(new File(modelDir, "block"));
        final File itemDir = setup(new File(modelDir, "item"));
        final File stateDir = setup(new File(outDir, "assets/" + this.ownerId + "/blockstates"));
        final String prefix = tier.getName() + "_" + material.getPath();

        write(new File(blockDir, prefix + "_botany_pot.json"), BASIC_POT_MODEL_TEMPLATE.replace("$texture", material.getPath()).replace("$tier", tier.getName()));
        write(new File(itemDir, prefix + "_botany_pot.json"), BLOCK_ITEM_MODEL_TEMPLATE.replace("$owner", this.ownerId).replace("$block_name", prefix + "_botany_pot"));
        write(new File(stateDir, prefix + "_botany_pot.json"), BLOCK_STATE_TEMPLATE.replace("$owner", this.ownerId).replace("$model_name", prefix + "_botany_pot"));

        write(new File(blockDir, prefix + "_hopper_botany_pot.json"), HOPPER_POT_MODEL_TEMPLATE.replace("$texture", material.getPath()).replace("$tier", tier.getName()));
        write(new File(itemDir, prefix + "_hopper_botany_pot.json"), BLOCK_ITEM_MODEL_TEMPLATE.replace("$owner", this.ownerId).replace("$block_name", prefix + "_hopper_botany_pot"));
        write(new File(stateDir, prefix + "_hopper_botany_pot.json"), BLOCK_STATE_TEMPLATE.replace("$owner", this.ownerId).replace("$model_name", prefix + "_hopper_botany_pot"));

        write(new File(blockDir, prefix + "_waxed_botany_pot.json"), BASIC_POT_MODEL_TEMPLATE.replace("$texture", material.getPath()).replace("$tier", tier.getName()));
        write(new File(itemDir, prefix + "_waxed_botany_pot.json"), BLOCK_ITEM_MODEL_TEMPLATE.replace("$owner", this.ownerId).replace("$block_name", prefix + "_botany_pot"));
        write(new File(stateDir, prefix + "_waxed_botany_pot.json"), BLOCK_STATE_TEMPLATE.replace("$owner", this.ownerId).replace("$model_name", prefix + "_botany_pot"));
    }

    public void basicPotUpgradeRecipe(File recipeDir, ResourceLocation material, PotTier tier) {
        write(new File(recipeDir, tier.getName() + "_" + material.getPath() + "_botany_pot.json"), format(BASIC_POT_RECIPE_TEMPLATE, material, tier, false));
    }

    public void basicPotUpgradeSameMaterialRecipe(File recipeDir, ResourceLocation material, PotTier tier) {
        write(new File(recipeDir, tier.getName() + "_" + material.getPath() + "_botany_pot_same_material.json"), format(BASIC_POT_SAME_MATERIAL_RECIPE_TEMPLATE, material, tier, false));
    }

    public void hopperPotUpgradeRecipe(File recipeDir, ResourceLocation material, PotTier tier) {
        if (tier == PotTier.ELITE) { //TODO: The Botany Pots mod has to be split it's tag into hopper and basic
            return;
        }

        write(new File(recipeDir, tier.getName() + "_" + material.getPath() + "_hopper_botany_pot_upgrade.json"), format(BASIC_POT_RECIPE_TEMPLATE, material, tier, true));
    }

    public void hopperPotUpgradeSameMaterialRecipe(File recipeDir, ResourceLocation material, PotTier tier) {
        if (tier == PotTier.ELITE) { //TODO: The Botany Pots mod has to be split it's tag into hopper and basic
            return;
        }

        write(new File(recipeDir, tier.getName() + "_" + material.getPath() + "_hopper_botany_pot_upgrade_same_material.json"), format(BASIC_POT_SAME_MATERIAL_RECIPE_TEMPLATE, material, tier, true));
    }

    public void quickHopperUpgradePotRecipe(File recipeDir, ResourceLocation material, PotTier tier) {
        write(new File(recipeDir, tier.getName() + "_" + material.getPath() + "_hopper_botany_pot_upgrade_quick.json"), format(QUICK_HOPPER_POT_RECIPE_TEMPLATE, material, tier, false));
    }

    public void quickHopperUpgradePotSameMaterialRecipe(File recipeDir, ResourceLocation material, PotTier tier) {
        write(new File(recipeDir, tier.getName() + "_" + material.getPath() + "_hopper_botany_pot_upgrade_quick_same_material.json"), format(QUICK_HOPPER_POT_SAME_MATERIAL_RECIPE_TEMPLATE, material, tier, false));
    }

    public void hopperPotRecipe(File recipeDir, ResourceLocation material, PotTier tier) {
        write(new File(recipeDir, tier.getName() + "_" + material.getPath() + "_hopper_botany_pot.json"), format(HOPPER_POT_RECIPE_TEMPLATE, material, tier, false));
    }

    public void waxedPotRecipe(File recipeDir, ResourceLocation material, PotTier tier) {
        write(new File(recipeDir, tier.getName() + "_" + material.getPath() + "_waxed_botany_pot.json"), format(WAX_POT_RECIPE_TEMPLATE, material, tier, false));
    }

    public void lootTable(File lootDir, ResourceLocation blockId) {
        write(new File(lootDir, blockId.getPath() + ".json"), DROP_SELF_TABLE.replace("$block_id", blockId.toString()));
    }

    private String format(String template, ResourceLocation material, PotTier tier, boolean isHopper) {
        final PotTier prevTier = PotTier.getPrevious(tier);
        return template
            .replace("$previous_owner", tier == PotTier.ELITE ? BotanyPotsMod.MOD_ID : this.ownerId)
            .replace("$previous_tier_", (prevTier != null ? prevTier.getName() + "_" : ""))
            .replace("$owner", this.ownerId)
            .replace("$material_id", material.toString())
            .replace("$material_name", material.getPath())
            .replace("$recipe1_id", this.getRecipeItem1(tier))
            .replace("$recipe2_id", this.getRecipeItem2(tier))
            .replace("$is_hopper_", isHopper ? "hopper_" : "")
            .replace("$tier", tier.getName());
    }

    private String getRecipeItem1(PotTier tier) {
        return switch (tier) {
            case ELITE -> "minecraft:iron_block";
            case ULTRA -> "minecraft:diamond_block";
            case MEGA -> "minecraft:netherite_block";
        };
    }

    private String getRecipeItem2(PotTier tier) {
        return switch (tier) {
            case ELITE -> "minecraft:ender_pearl";
            case ULTRA -> "minecraft:nether_star";
            case MEGA -> "minecraft:enchanted_golden_apple";
        };
    }

    private static void write(File file, String text) {
        try {
            file.createNewFile();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (FileWriter writer = new FileWriter(file)) {
            writer.append(text);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static File setup(File dir) {
        dir.mkdirs();
        return dir;
    }

    private static final String BASIC_POT_MODEL_TEMPLATE = """
            {
                "parent": "botanypotstiers:block/template/pot",
                "render_type": "minecraft:cutout",
                "textures": {
                    "material": "minecraft:block/$texture",
                    "material_top": "botanypots:block/$texture_pot_top",
                    "stripe": "botanypotstiers:block/$tier"
                }
            }
            """;

    private static final String HOPPER_POT_MODEL_TEMPLATE = """
            {
                "parent": "botanypotstiers:block/template/hopper_pot",
                "render_type": "minecraft:cutout",
                "textures": {
                    "material": "minecraft:block/$texture",
                    "material_top": "botanypots:block/$texture_pot_top",
                    "stripe": "botanypotstiers:block/$tier"
                }
            }
            """;

    private static final String BLOCK_ITEM_MODEL_TEMPLATE = """
            {
                "parent": "$owner:block/$block_name"
            }
            """;

    private static final String BLOCK_STATE_TEMPLATE = """
            {
              "variants": {
                "": {
                  "model": "$owner:block/$model_name"
                }
              }
            }
            """;

    private static final String BASIC_POT_RECIPE_TEMPLATE = """
            {
                "bookshelf:load_conditions": [
                    {
                        "type": "botanypotstiers:config",
                        "property": "can_craft_$tier_basic_pots"
                    }
                ],
                "type": "minecraft:crafting_shaped",
                "category": "misc",
                "group": "botanypotstiers:$tier_basic_pot",
                "pattern": [
                    "MAM",
                    "MPM",
                    "BMB"
                ],
                "key": {
                    "M": {
                        "item": "$material_id"
                    },
                    "B": {
                        "item": "$recipe1_id"
                    },
                    "A": {
                        "item": "$recipe2_id"
                    },
                    "P": {
                        "tag": "$previous_owner:$previous_tier_$is_hopper_botany_pots"
                    }
                },
                "result": {
                    "id": "$owner:$tier_$material_name_$is_hopper_botany_pot",
                    "count": 1
                }
            }""";

    private static final String BASIC_POT_SAME_MATERIAL_RECIPE_TEMPLATE = """
            {
                "bookshelf:load_conditions": [
                    {
                        "type": "botanypotstiers:config",
                        "property": "can_craft_$tier_basic_pots"
                    }
                ],
                "type": "minecraft:crafting_shaped",
                "category": "misc",
                "group": "botanypotstiers:$tier_basic_pot",
                "pattern": [
                    " A ",
                    " P ",
                    "B B"
                ],
                "key": {
                    "B": {
                        "item": "$recipe1_id"
                    },
                    "A": {
                        "item": "$recipe2_id"
                    },
                    "P": {
                        "item": "$previous_owner:$previous_tier_$material_name_$is_hopper_botany_pot"
                    }
                },
                "result": {
                    "id": "$owner:$tier_$material_name_$is_hopper_botany_pot",
                    "count": 1
                }
            }""";

    private static final String HOPPER_POT_RECIPE_TEMPLATE = """
            {
                "bookshelf:load_conditions": [
                    {
                        "type": "botanypotstiers:config",
                        "property": "can_craft_$tier_hopper_pots"
                    }
                ],
                "type": "minecraft:crafting_shapeless",
                "category": "misc",
                "group": "botanypotstiers:$tier_hopper_pot",
                "ingredients": [
                    {
                        "item": "minecraft:hopper"
                    },
                    {
                        "item": "$owner:$tier_$material_name_botany_pot"
                    }
                ],
                "result": {
                    "id": "$owner:$tier_$material_name_hopper_botany_pot",
                    "count": 1
                }
            }""";

    private static final String QUICK_HOPPER_POT_RECIPE_TEMPLATE = """
            {
                "bookshelf:load_conditions": [
                    {
                        "type": "botanypotstiers:config",
                        "property": "can_craft_$tier_hopper_pots"
                    }
                ],
                "type": "minecraft:crafting_shaped",
                "category": "misc",
                "group": "botanypotstiers:quick_$tier_hopper_pot",
                "pattern": [
                    "HMA",
                    "MPM",
                    "BMB"
                ],
                "key": {
                    "M": {
                        "item": "$material_id"
                    },
                    "B": {
                        "item": "$recipe1_id"
                    },
                    "A": {
                        "item": "$recipe2_id"
                    },
                    "P": {
                        "tag": "$previous_owner:$previous_tier_botany_pots"
                    },
                    "H": {
                        "item": "minecraft:hopper"
                    }
                },
                "result": {
                    "id": "$owner:$tier_$material_name_hopper_botany_pot",
                    "count": 1
                }
            }""";

    private static final String QUICK_HOPPER_POT_SAME_MATERIAL_RECIPE_TEMPLATE = """
            {
                "bookshelf:load_conditions": [
                    {
                        "type": "botanypotstiers:config",
                        "property": "can_craft_$tier_hopper_pots"
                    }
                ],
                "type": "minecraft:crafting_shaped",
                "category": "misc",
                "group": "botanypotstiers:quick_$tier_hopper_pot",
                "pattern": [
                    "H A",
                    " P ",
                    "B B"
                ],
                "key": {
                    "B": {
                        "item": "$recipe1_id"
                    },
                    "A": {
                        "item": "$recipe2_id"
                    },
                    "P": {
                        "item": "$previous_owner:$previous_tier_$material_name_botany_pot"
                    },
                    "H": {
                        "item": "minecraft:hopper"
                    }
                },
                "result": {
                    "id": "$owner:$tier_$material_name_hopper_botany_pot",
                    "count": 1
                }
            }""";

    private static final String WAX_POT_RECIPE_TEMPLATE = """
            {
                "bookshelf:load_conditions": [
                    {
                        "type": "botanypotstiers:config",
                        "property": "can_wax_$tier_pots"
                    }
                ],
                "type": "minecraft:crafting_shapeless",
                "category": "misc",
                "group": "botanypotstiers:waxed_$tier_pot",
                "ingredients": [
                    {
                        "item": "minecraft:honeycomb"
                    },
                    {
                        "item": "$owner:$tier_$material_name_botany_pot"
                    }
                ],
                "result": {
                    "id": "$owner:$tier_$material_name_waxed_botany_pot",
                    "count": 1
                }
            }""";

    private static final String DROP_SELF_TABLE = """
            {
              "type": "minecraft:block",
              "pools": [
                {
                  "conditions": [
                    {
                      "condition": "minecraft:survives_explosion"
                    }
                  ],
                  "entries": [
                    {
                      "type": "minecraft:item",
                      "name": "$block_id"
                    }
                  ],
                  "rolls": 1.0
                }
              ],
              "random_sequence": "$block_id"
            }
            """;
}