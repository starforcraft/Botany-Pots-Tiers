package com.ultramega.botanypotstiers.block;

import com.ultramega.botanypotstiers.Constants;
import com.ultramega.botanypotstiers.PotTiers;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TieredBotanyPotVariantGenerator {
    public static File blockDir = makeDir("assets/botanypotstiers/models/block");
    public static File itemDir = makeDir("assets/botanypotstiers/models/item");
    public static File stateDir = makeDir("assets/botanypotstiers/blockstates");
    public static File lootDir = makeDir("data/botanypotstiers/loot_tables/blocks");
    public static File craftingDir = makeDir("data/botanypotstiers/recipes/crafting");

    public static void generate() {
        // Default
        generatePot(Blocks.TERRACOTTA);

        // Terracotta
        generatePot(Blocks.WHITE_TERRACOTTA);
        generatePot(Blocks.ORANGE_TERRACOTTA);
        generatePot(Blocks.MAGENTA_TERRACOTTA);
        generatePot(Blocks.LIGHT_BLUE_TERRACOTTA);
        generatePot(Blocks.YELLOW_TERRACOTTA);
        generatePot(Blocks.LIME_TERRACOTTA);
        generatePot(Blocks.PINK_TERRACOTTA);
        generatePot(Blocks.GRAY_TERRACOTTA);
        generatePot(Blocks.LIGHT_GRAY_TERRACOTTA);
        generatePot(Blocks.CYAN_TERRACOTTA);
        generatePot(Blocks.PURPLE_TERRACOTTA);
        generatePot(Blocks.BLUE_TERRACOTTA);
        generatePot(Blocks.BROWN_TERRACOTTA);
        generatePot(Blocks.GREEN_TERRACOTTA);
        generatePot(Blocks.RED_TERRACOTTA);
        generatePot(Blocks.BLACK_TERRACOTTA);

        // Glazed Terracotta
        generatePot(Blocks.WHITE_GLAZED_TERRACOTTA);
        generatePot(Blocks.ORANGE_GLAZED_TERRACOTTA);
        generatePot(Blocks.MAGENTA_GLAZED_TERRACOTTA);
        generatePot(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA);
        generatePot(Blocks.YELLOW_GLAZED_TERRACOTTA);
        generatePot(Blocks.LIME_GLAZED_TERRACOTTA);
        generatePot(Blocks.PINK_GLAZED_TERRACOTTA);
        generatePot(Blocks.GRAY_GLAZED_TERRACOTTA);
        generatePot(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA);
        generatePot(Blocks.CYAN_GLAZED_TERRACOTTA);
        generatePot(Blocks.PURPLE_GLAZED_TERRACOTTA);
        generatePot(Blocks.BLUE_GLAZED_TERRACOTTA);
        generatePot(Blocks.BROWN_GLAZED_TERRACOTTA);
        generatePot(Blocks.GREEN_GLAZED_TERRACOTTA);
        generatePot(Blocks.RED_GLAZED_TERRACOTTA);
        generatePot(Blocks.BLACK_GLAZED_TERRACOTTA);

        // Concrete
        generatePot(Blocks.WHITE_CONCRETE);
        generatePot(Blocks.ORANGE_CONCRETE);
        generatePot(Blocks.MAGENTA_CONCRETE);
        generatePot(Blocks.LIGHT_BLUE_CONCRETE);
        generatePot(Blocks.YELLOW_CONCRETE);
        generatePot(Blocks.LIME_CONCRETE);
        generatePot(Blocks.PINK_CONCRETE);
        generatePot(Blocks.GRAY_CONCRETE);
        generatePot(Blocks.LIGHT_GRAY_CONCRETE);
        generatePot(Blocks.CYAN_CONCRETE);
        generatePot(Blocks.PURPLE_CONCRETE);
        generatePot(Blocks.BLUE_CONCRETE);
        generatePot(Blocks.BROWN_CONCRETE);
        generatePot(Blocks.GREEN_CONCRETE);
        generatePot(Blocks.RED_CONCRETE);
        generatePot(Blocks.BLACK_CONCRETE);
    }

    public static void generatePot(Block block) {
        try {
            final ResourceLocation blockId = Registry.BLOCK.getKey(block);

            for(PotTiers tier : PotTiers.values()) {
                Constants.LOG.info("botanypotstiers:" + tier.getName() + "_" + blockId.getPath() + "_botany_pot");
                Constants.LOG.info("botanypotstiers:" + tier.getName() + "_" + blockId.getPath() + "_hopper_botany_pot");

                // Normal
                generateBlockState(tier, blockId, "botany_pot");
                generateBlockModel(tier, blockId, "botany_pot", false);
                generateItemModel(tier, blockId, "botany_pot");
                generateLootTable(tier, blockId, "botany_pot");
                generateBasicCrafting(tier, blockId);

                // Hopper
                generateBlockState(tier, blockId, "hopper_botany_pot");
                generateBlockModel(tier, blockId, "hopper_botany_pot", true);
                generateItemModel(tier, blockId, "hopper_botany_pot");
                generateLootTable(tier, blockId, "hopper_botany_pot");
                generateHopperCrafting(tier, blockId);
                generateCompactHopperCrafting(tier, blockId);
            }
        } catch (Exception e) {

        }
    }

    public static void generateCompactHopperCrafting(PotTiers tier, ResourceLocation blockId) throws IOException {
        final String potId = "botanypotstiers:" + tier.getName() + "_" + blockId.getPath() + "_hopper_botany_pot";

        try (FileWriter writer = new FileWriter(new File(craftingDir, tier.getName() + "_" + blockId.getPath() + "_compact_hopper_botany_pot.json"))) {
            switch(tier) {
                case ELITE:
                    writer.append("{\n" +
                            "    \"type\": \"crafting_shaped\",\n" +
                            "    \"pattern\": [\n" +
                            "        \"SES\",\n" +
                            "        \"SPS\",\n" +
                            "        \"IHI\"\n" +
                            "    ],\n" +
                            "    \"key\": {\n" +
                            "        \"S\": {\n" +
                            "            \"item\": \"" + blockId.toString() + "\"\n" +
                            "        },\n" +
                            "        \"P\": {\n" +
                            "            \"item\": \"botanypots:terracotta_botany_pot\"\n" +
                            "        },\n" +
                            "        \"I\": {\n" +
                            "            \"item\": \"minecraft:iron_block\"\n" +
                            "        },\n" +
                            "        \"E\": {\n" +
                            "            \"item\": \"minecraft:ender_pearl\"\n" +
                            "        },\n" +
                            "        \"H\": {\n" +
                            "            \"item\": \"minecraft:hopper\"\n" +
                            "        }\n" +
                            "    },\n" +
                            "    \"result\": {\n" +
                            "        \"item\": \"" + potId.toString() + "\",\n" +
                            "        \"count\": 1\n" +
                            "    }\n" +
                            "}");
                    break;
                case ULTRA:
                    writer.append("{\n" +
                            "    \"type\": \"crafting_shaped\",\n" +
                            "    \"pattern\": [\n" +
                            "        \"SES\",\n" +
                            "        \"SPS\",\n" +
                            "        \"IHI\"\n" +
                            "    ],\n" +
                            "    \"key\": {\n" +
                            "        \"S\": {\n" +
                            "            \"item\": \"" + blockId.toString() + "\"\n" +
                            "        },\n" +
                            "        \"P\": {\n" +
                            "            \"item\": \"botanypotstiers:elite_terracotta_botany_pot\"\n" +
                            "        },\n" +
                            "        \"I\": {\n" +
                            "            \"item\": \"minecraft:diamond_block\"\n" +
                            "        },\n" +
                            "        \"E\": {\n" +
                            "            \"item\": \"minecraft:nether_star\"\n" +
                            "        },\n" +
                            "        \"H\": {\n" +
                            "            \"item\": \"minecraft:hopper\"\n" +
                            "        }\n" +
                            "    },\n" +
                            "    \"result\": {\n" +
                            "        \"item\": \"" + potId.toString() + "\",\n" +
                            "        \"count\": 1\n" +
                            "    }\n" +
                            "}");
                    break;
                case CREATIVE:
                    writer.append("{\n" +
                            "    \"type\": \"crafting_shaped\",\n" +
                            "    \"pattern\": [\n" +
                            "        \"SES\",\n" +
                            "        \"SPS\",\n" +
                            "        \"IHI\"\n" +
                            "    ],\n" +
                            "    \"key\": {\n" +
                            "        \"S\": {\n" +
                            "            \"item\": \"" + blockId.toString() + "\"\n" +
                            "        },\n" +
                            "        \"P\": {\n" +
                            "            \"item\": \"botanypotstiers:ultra_terracotta_botany_pot\"\n" +
                            "        },\n" +
                            "        \"I\": {\n" +
                            "            \"item\": \"minecraft:netherite_block\"\n" +
                            "        },\n" +
                            "        \"E\": {\n" +
                            "            \"item\": \"minecraft:enchanted_golden_apple\"\n" +
                            "        },\n" +
                            "        \"H\": {\n" +
                            "            \"item\": \"minecraft:hopper\"\n" +
                            "        }\n" +
                            "    },\n" +
                            "    \"result\": {\n" +
                            "        \"item\": \"" + potId.toString() + "\",\n" +
                            "        \"count\": 1\n" +
                            "    }\n" +
                            "}");
                    break;
            }
        }
    }

    public static void generateHopperCrafting(PotTiers tier, ResourceLocation blockId) throws IOException {
        final String potId = "botanypotstiers:" + tier.getName() + "_" + blockId.getPath() + "_hopper_botany_pot";

        try (FileWriter writer = new FileWriter(new File(craftingDir, tier.getName() + "_" + blockId.getPath() + "_hopper_botany_pot.json"))) {
            writer.append("{\n" +
                    "    \"type\": \"minecraft:crafting_shapeless\",\n" +
                    "    \"ingredients\": [\n" +
                    "        {\n" +
                    "            \"item\": \"botanypotstiers:" + tier.getName() + "_" + blockId.getPath() + "_botany_pot\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"item\": \"minecraft:hopper\"\n" +
                    "        }\n" +
                    "    ],\n" +
                    "    \"result\": {\n" +
                    "        \"item\": \"" + potId + "\",\n" +
                    "        \"count\": 1\n" +
                    "    }\n" +
                    "}");
        }
    }

    public static void generateBasicCrafting(PotTiers tier, ResourceLocation blockId) throws IOException {
        final String potId = "botanypotstiers:" + tier.getName() + "_" + blockId.getPath() + "_botany_pot";

        try (FileWriter writer = new FileWriter(new File(craftingDir, tier.getName() + "_" + blockId.getPath() + "_botany_pot.json"))) {
            switch(tier) {
                case ELITE:
                    writer.append("{\n" +
                            "    \"type\": \"crafting_shaped\",\n" +
                            "    \"pattern\": [\n" +
                            "        \"SES\",\n" +
                            "        \"SPS\",\n" +
                            "        \"ISI\"\n" +
                            "    ],\n" +
                            "    \"key\": {\n" +
                            "        \"S\": {\n" +
                            "            \"item\": \"" + blockId.toString() + "\"\n" +
                            "        },\n" +
                            "        \"P\": {\n" +
                            "            \"item\": \"botanypots:terracotta_botany_pot\"\n" +
                            "        },\n" +
                            "        \"I\": {\n" +
                            "            \"item\": \"minecraft:iron_block\"\n" +
                            "        },\n" +
                            "        \"E\": {\n" +
                            "            \"item\": \"minecraft:ender_pearl\"\n" +
                            "        }\n" +
                            "    },\n" +
                            "    \"result\": {\n" +
                            "        \"item\": \"" + potId.toString() + "\",\n" +
                            "        \"count\": 1\n" +
                            "    }\n" +
                            "}");
                    break;
                case ULTRA:
                    writer.append("{\n" +
                            "    \"type\": \"crafting_shaped\",\n" +
                            "    \"pattern\": [\n" +
                            "        \"SES\",\n" +
                            "        \"SPS\",\n" +
                            "        \"ISI\"\n" +
                            "    ],\n" +
                            "    \"key\": {\n" +
                            "        \"S\": {\n" +
                            "            \"item\": \"" + blockId.toString() + "\"\n" +
                            "        },\n" +
                            "        \"P\": {\n" +
                            "            \"item\": \"botanypotstiers:elite_terracotta_botany_pot\"\n" +
                            "        },\n" +
                            "        \"I\": {\n" +
                            "            \"item\": \"minecraft:diamond_block\"\n" +
                            "        },\n" +
                            "        \"E\": {\n" +
                            "            \"item\": \"minecraft:nether_star\"\n" +
                            "        }\n" +
                            "    },\n" +
                            "    \"result\": {\n" +
                            "        \"item\": \"" + potId.toString() + "\",\n" +
                            "        \"count\": 1\n" +
                            "    }\n" +
                            "}");
                    break;
                case CREATIVE:
                    writer.append("{\n" +
                            "    \"type\": \"crafting_shaped\",\n" +
                            "    \"pattern\": [\n" +
                            "        \"SES\",\n" +
                            "        \"SPS\",\n" +
                            "        \"ISI\"\n" +
                            "    ],\n" +
                            "    \"key\": {\n" +
                            "        \"S\": {\n" +
                            "            \"item\": \"" + blockId.toString() + "\"\n" +
                            "        },\n" +
                            "        \"P\": {\n" +
                            "            \"item\": \"botanypotstiers:ultra_terracotta_botany_pot\"\n" +
                            "        },\n" +
                            "        \"I\": {\n" +
                            "            \"item\": \"minecraft:netherite_block\"\n" +
                            "        },\n" +
                            "        \"E\": {\n" +
                            "            \"item\": \"minecraft:enchanted_golden_apple\"\n" +
                            "        }\n" +
                            "    },\n" +
                            "    \"result\": {\n" +
                            "        \"item\": \"" + potId.toString() + "\",\n" +
                            "        \"count\": 1\n" +
                            "    }\n" +
                            "}");
                    break;
            }
        }
    }

    public static void generateLootTable(PotTiers tier, ResourceLocation blockId, String suffix) throws IOException {
        final String potId = tier.getName() + "_" + blockId.getPath() + "_" + suffix;

        try (FileWriter writer = new FileWriter(new File(lootDir, potId + ".json"))) {
            writer.append("{\n" +
                    "  \"type\": \"minecraft:block\",\n" +
                    "  \"pools\": [\n" +
                    "    {\n" +
                    "      \"bonus_rolls\": 0.0,\n" +
                    "      \"conditions\": [\n" +
                    "        {\n" +
                    "          \"condition\": \"minecraft:survives_explosion\"\n" +
                    "        }\n" +
                    "      ],\n" +
                    "      \"entries\": [\n" +
                    "        {\n" +
                    "          \"type\": \"minecraft:item\",\n" +
                    "          \"functions\": [\n" +
                    "            {\n" +
                    "              \"function\": \"minecraft:copy_name\",\n" +
                    "              \"source\": \"block_entity\"\n" +
                    "            }\n" +
                    "          ],\n" +
                    "          \"name\": \"" + Constants.MOD_ID + ":" + potId + "\"\n" +
                    "        }\n" +
                    "      ],\n" +
                    "      \"rolls\": 1.0\n" +
                    "    }\n" +
                    "  ]\n" +
                    "}");
        }
    }

    public static void generateBlockState(PotTiers tier, ResourceLocation blockId, String suffix) throws IOException {
        final String potId = tier.getName() + "_" + blockId.getPath() + "_" + suffix;

        try (FileWriter writer = new FileWriter(new File(stateDir, potId + ".json"))) {
            writer.append("{\n" +
                    "    \"variants\": {\n" +
                    "        \"\": {\n" +
                    "            \"model\": \"botanypotstiers:block/" + potId + "\"\n" +
                    "        }\n" +
                    "    }\n" +
                    "}");
        }
    }

    public static void generateItemModel(PotTiers tier, ResourceLocation blockId, String suffix) throws IOException {
        final String potId = tier.getName() + "_" + blockId.getPath() + "_" + suffix;

        try (FileWriter writer = new FileWriter(new File(itemDir, potId + ".json"))) {
            writer.append("{\n" +
                    "    \"parent\": \"botanypotstiers:block/" + potId + "\"\n" +
                    "}");
        }
    }

    public static void generateBlockModel(PotTiers tier, ResourceLocation blockId, String suffix, boolean hopper) throws IOException {
        final String potId = tier.getName() + "_" + blockId.getPath() + "_" + suffix;
        final String parent = hopper ? "hopper_botany_pot_base" : "botany_pot_base";

        try (FileWriter writer = new FileWriter(new File(blockDir, potId + ".json"))) {
            writer.append("{\n" +
                    "    \"parent\": \"botanypotstiers:block/" + parent + "\",\n" +
                    "    \"textures\": {\n" +
                    "        \"terracotta\": \"minecraft:block/" + blockId.getPath() + "\",\n" +
                    "        \"stripe\": \"botanypotstiers:block/" + tier.getName() + "\",\n" +
                    "        \"particle\": \"minecraft:block/" + blockId.getPath() + "\"\n" +
                    "    }\n" +
                    "}");
        }
    }

    private static File makeDir(String path) {
        final File dir = new File(new File("datagen_out"), path);

        if (!dir.exists()) {
            dir.mkdirs();
        }

        return dir;
    }
}