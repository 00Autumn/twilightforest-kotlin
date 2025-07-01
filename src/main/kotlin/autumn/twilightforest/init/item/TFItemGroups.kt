package autumn.twilightforest.init.item

import autumn.twilightforest.TwilightForest
import autumn.twilightforest.init.block.TFBlocks
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.text.Text
import net.minecraft.util.Identifier

object TFItemGroups {
    val TWILIGHT_FOREST_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
        Identifier.of(TwilightForest.MOD_ID, "twilight_forest_items"),
        FabricItemGroup.builder().icon { ItemStack(TFItems.STEELEAF_INGOT)}
            .displayName(Text.translatable("itemgroup.twilightforest.twilight_forest_items"))
            .entries {displayContext, entries ->
                entries.add(TFItems.NAGA_SCALE)
                entries.add(TFItems.LIVEROOT)
                entries.add(TFItems.RAW_IRONWOOD)
                entries.add(TFItems.IRONWOOD_INGOT)
                entries.add(TFItems.STEELEAF_INGOT)
                entries.add(TFItems.ARMOR_SHARD)
                entries.add(TFItems.ARMOR_SHARD_CLUSTER)
                entries.add(TFItems.KNIGHTMETAL_INGOT)
                entries.add(TFItems.FIERY_BLOOD)
                entries.add(TFItems.FIERY_TEARS)
                entries.add(TFItems.FIERY_INGOT)
                entries.add(TFItems.ARCTIC_FUR)
                entries.add(TFItems.ALPHA_YETI_FUR)

                entries.add(TFItems.RAVEN_FEATHER)
                entries.add(TFItems.MAGIC_MAP_FOCUS)
                entries.add(TFItems.MAZE_MAP_FOCUS)
                entries.add(TFItems.CHARM_OF_LIFE_I)
                entries.add(TFItems.CHARM_OF_LIFE_II)
                entries.add(TFItems.CHARM_OF_KEEPING_I)
                entries.add(TFItems.CHARM_OF_KEEPING_II)
                entries.add(TFItems.CHARM_OF_KEEPING_III)
                entries.add(TFItems.BORER_ESSENCE)
                entries.add(TFItems.CARMINITE)
                entries.add(TFItems.EMPERORS_CLOTH)
                entries.add(TFItems.CROWN_SPLINTER)

                entries.add(TFItems.TOWER_KEY)

                entries.add(TFItems.RAW_VENISON)
                entries.add(TFItems.COOKED_VENISON)
                entries.add(TFItems.RAW_MEEF)
                entries.add(TFItems.COOKED_MEEF)
                entries.add(TFItems.MEEF_STROGANOFF)
                entries.add(TFItems.HYDRA_CHOP)
                entries.add(TFItems.TORCHBERRIES)
                entries.add(TFItems.EXPERIMENT_115)
                entries.add(TFItems.MAZE_WAFER)
            }.build()
    )
    val TWILIGHT_FOREST_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
        Identifier.of(TwilightForest.MOD_ID, "twilight_forest_blocks"),
        FabricItemGroup.builder().icon { ItemStack(TFBlocks.MOSSY_UNDERBRICK)}
            .displayName(Text.translatable("itemgroup.twilightforest.twilight_forest_blocks"))
            .entries {displayContext, entries ->
                entries.add(TFBlocks.ROOT_BLOCK)
                entries.add(TFBlocks.LIVEROOT_BLOCK)

                entries.add(TFBlocks.IRONWOOD_BLOCK)
                entries.add(TFBlocks.STEELEAF_BLOCK)
                entries.add(TFBlocks.KNIGHTMETAL_BLOCK)
                entries.add(TFBlocks.FIERY_BLOCK)
                entries.add(TFBlocks.ARCTIC_FUR_BLOCK)

                entries.add(TFBlocks.MAZESTONE)
                entries.add(TFBlocks.MAZESTONE_BRICK)
                entries.add(TFBlocks.MAZESTONE_LARGE_BRICK)
                entries.add(TFBlocks.CHISELED_MAZESTONE)
                entries.add(TFBlocks.CUT_MAZESTONE)
                entries.add(TFBlocks.DECORATIVE_MAZESTONE)
                entries.add(TFBlocks.CRACKED_MAZESTONE)
                entries.add(TFBlocks.MOSSY_MAZESTONE)
                entries.add(TFBlocks.MAZESTONE_MOSAIC)
                entries.add(TFBlocks.MAZESTONE_BORDER)

                entries.add(TFBlocks.UNDERBRICK)
                entries.add(TFBlocks.MOSSY_UNDERBRICK)
                entries.add(TFBlocks.CRACKED_UNDERBRICK)
                entries.add(TFBlocks.UNDERBRICK_FLOOR)

                entries.add(TFBlocks.TOWERWOOD)
                entries.add(TFBlocks.ENCASED_TOWERWOOD)
                entries.add(TFBlocks.CRACKED_TOWERWOOD)

                entries.add(TFBlocks.HEDGE)
                entries.add(TFBlocks.HEDGE_ROSE)

                entries.add(TFBlocks.STRONGHOLD_SHIELD);

                entries.add(TFBlocks.INFESTED_TOWERWOOD)
                entries.add(TFBlocks.ANTIBUILT_BLOCK)
                entries.add(TFBlocks.FAKE_GOLD)
                entries.add(TFBlocks.FAKE_DIAMOND)

                entries.add(TFBlocks.MAZE_SLIME_BLOCK)

                entries.add(TFBlocks.TWILIGHT_OAK_LOG)
                entries.add(TFBlocks.STRIPPED_TWILIGHT_OAK_LOG)
                entries.add(TFBlocks.TWILIGHT_OAK_LEAVES)
                entries.add(TFBlocks.TWILIGHT_OAK_SAPLING)
                entries.add(TFBlocks.TWILIGHT_OAK_PLANKS)
                entries.add(TFBlocks.TWILIGHT_OAK_DOOR)
                entries.add(TFBlocks.TWILIGHT_OAK_TRAPDOOR)
                entries.add(TFBlocks.TWILIGHT_OAK_FENCE)
                entries.add(TFBlocks.TWILIGHT_OAK_FENCE_GATE)
                entries.add(TFBlocks.TWILIGHT_OAK_STAIRS)
                entries.add(TFBlocks.TWILIGHT_OAK_SLAB)
                entries.add(TFBlocks.TWILIGHT_OAK_PRESSURE_PLATE)
                entries.add(TFBlocks.TWILIGHT_OAK_BUTTON)
            }.build()
    )
    val TWILIGHT_FOREST_EQUIPMENT_GROUP = Registry.register(Registries.ITEM_GROUP,
        Identifier.of(TwilightForest.MOD_ID, "twilight_forest_equipment"),
        FabricItemGroup.builder().icon { ItemStack(TFItems.CHARM_OF_KEEPING_III)}
            .displayName(Text.translatable("itemgroup.twilightforest.twilight_forest_equipment"))
            .entries {displayContext, entries ->
                entries.add(TFItems.POCKET_WATCH)

                entries.add(TFItems.NAGA_LEGGINGS)
                entries.add(TFItems.NAGA_CHESTPLATE)

                entries.add(TFItems.IRONWOOD_BOOTS)
                entries.add(TFItems.IRONWOOD_LEGGINGS)
                entries.add(TFItems.IRONWOOD_CHESTPLATE)
                entries.add(TFItems.IRONWOOD_HELMET)
                entries.add(TFItems.IRONWOOD_SWORD)
                entries.add(TFItems.IRONWOOD_PICKAXE)
                entries.add(TFItems.IRONWOOD_SHOVEL)
                entries.add(TFItems.IRONWOOD_AXE)
                entries.add(TFItems.IRONWOOD_HOE)

                entries.add(TFItems.STEELEAF_BOOTS)
                entries.add(TFItems.STEELEAF_LEGGINGS)
                entries.add(TFItems.STEELEAF_CHESTPLATE)
                entries.add(TFItems.STEELEAF_HELMET)
                entries.add(TFItems.STEELEAF_SWORD)
                entries.add(TFItems.STEELEAF_PICKAXE)
                entries.add(TFItems.STEELEAF_SHOVEL)
                entries.add(TFItems.STEELEAF_AXE)
                entries.add(TFItems.STEELEAF_HOE)

                entries.add(TFItems.GOLD_MINOTAUR_AXE)
                entries.add(TFItems.DIAMOND_MINOTAUR_AXE)
                entries.add(TFItems.MAZEBREAKER_PICKAXE)

                entries.add(TFItems.KNIGHTMETAL_BOOTS)
                entries.add(TFItems.KNIGHTMETAL_LEGGINGS)
                entries.add(TFItems.KNIGHTMETAL_CHESTPLATE)
                entries.add(TFItems.KNIGHTMETAL_HELMET)
                entries.add(TFItems.KNIGHTMETAL_SWORD)
                entries.add(TFItems.KNIGHTMETAL_PICKAXE)
                entries.add(TFItems.KNIGHTMETAL_AXE)
                entries.add(TFItems.PHANTOM_CHESTPLATE)
                entries.add(TFItems.PHANTOM_HELMET)

                entries.add(TFItems.FIERY_BOOTS)
                entries.add(TFItems.FIERY_LEGGINGS)
                entries.add(TFItems.FIERY_CHESTPLATE)
                entries.add(TFItems.FIERY_HELMET)
                entries.add(TFItems.FIERY_SWORD)
                entries.add(TFItems.FIERY_PICKAXE)

                entries.add(TFItems.ARCTIC_BOOTS)
                entries.add(TFItems.ARCTIC_LEGGINGS)
                entries.add(TFItems.ARCTIC_CHESTPLATE)
                entries.add(TFItems.ARCTIC_HELMET)

                entries.add(TFItems.YETI_BOOTS)
                entries.add(TFItems.YETI_LEGGINGS)
                entries.add(TFItems.YETI_CHESTPLATE)
                entries.add(TFItems.YETI_HELMET)
            }.build()
    )

    fun registerItemGroups() {
        TwilightForest.logger?.info("Registering item groups for " + TwilightForest.MOD_ID)
    }
}