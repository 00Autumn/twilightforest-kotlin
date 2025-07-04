package autumn.twilightforest.datagen.providers

import autumn.twilightforest.TwilightForest
import autumn.twilightforest.init.block.TFBlocks
import autumn.twilightforest.init.item.TFArmorMaterials
import autumn.twilightforest.init.item.TFItems
import autumn.twilightforest.util.TFBlockFamilies
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.minecraft.client.data.BlockStateModelGenerator
import net.minecraft.client.data.ItemModelGenerator
import net.minecraft.client.data.Models
import net.minecraft.client.data.TextureKey
import net.minecraft.client.data.TextureMap
import net.minecraft.entity.EquipmentSlot
import net.minecraft.item.Item
import net.minecraft.item.equipment.EquipmentAsset
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.util.Identifier

class TFModelProvider(output: FabricDataOutput) : FabricModelProvider(output) {
    override fun generateBlockStateModels(generator: BlockStateModelGenerator) {
        with(generator) {
            registerSimpleCubeAll(TFBlocks.ROOT_BLOCK)
            registerSimpleCubeAll(TFBlocks.LIVEROOT_BLOCK)

            registerSimpleCubeAll(TFBlocks.MAZE_SLIME_BLOCK)
            registerSimpleCubeAll(TFBlocks.IRONWOOD_BLOCK)
            registerSimpleCubeAll(TFBlocks.STEELEAF_BLOCK)
            registerSimpleCubeAll(TFBlocks.KNIGHTMETAL_BLOCK)
            registerSimpleCubeAll(TFBlocks.FIERY_BLOCK)
            registerSimpleCubeAll(TFBlocks.ARCTIC_FUR_BLOCK)

            registerSimpleCubeAll(TFBlocks.MAZESTONE)
            registerSimpleCubeAll(TFBlocks.MAZESTONE_BRICK)
            registerSimpleCubeAll(TFBlocks.MAZESTONE_LARGE_BRICK)
            registerSimpleCubeAll(TFBlocks.CHISELED_MAZESTONE)
            registerSimpleCubeAll(TFBlocks.CUT_MAZESTONE)
            registerSimpleCubeAll(TFBlocks.DECORATIVE_MAZESTONE)
            registerSimpleCubeAll(TFBlocks.CRACKED_MAZESTONE_BRICK)
            registerSimpleCubeAll(TFBlocks.MOSSY_MAZESTONE_BRICK)
            registerSimpleCubeAll(TFBlocks.MAZESTONE_MOSAIC)
            registerSimpleCubeAll(TFBlocks.MAZESTONE_BORDER)

            registerSimpleCubeAll(TFBlocks.STRONGHOLD_SHIELD)
            registerSimpleCubeAll(TFBlocks.UNDERBRICK)
            registerSimpleCubeAll(TFBlocks.CRACKED_UNDERBRICK)
            registerSimpleCubeAll(TFBlocks.MOSSY_UNDERBRICK)
            registerSimpleCubeAll(TFBlocks.UNDERBRICK_FLOOR)

            registerSimpleCubeAll(TFBlocks.TOWERWOOD)
            registerSimpleCubeAll(TFBlocks.ENCASED_TOWERWOOD)
            registerSimpleCubeAll(TFBlocks.CRACKED_TOWERWOOD)
            registerSimpleCubeAll(TFBlocks.MOSSY_TOWERWOOD)
            registerSimpleCubeAll(TFBlocks.INFESTED_TOWERWOOD)
            registerSimpleCubeAll(TFBlocks.ANTIBUILT_BLOCK)
            registerSimpleCubeAll(TFBlocks.FAKE_GOLD)
            registerSimpleCubeAll(TFBlocks.FAKE_DIAMOND)

            registerSimpleCubeAll(TFBlocks.HEDGE)
            registerSimpleCubeAll(TFBlocks.HEDGE_ROSE)

            createLogTexturePool(TFBlocks.TWILIGHT_OAK_LOG).log(TFBlocks.TWILIGHT_OAK_LOG).wood(TFBlocks.TWILIGHT_OAK_WOOD)
            createLogTexturePool(TFBlocks.STRIPPED_TWILIGHT_OAK_LOG).log(TFBlocks.STRIPPED_TWILIGHT_OAK_LOG)
                .wood(TFBlocks.STRIPPED_TWILIGHT_OAK_WOOD)
            val twilightOakFamily = TFBlockFamilies.get(TFBlocks.TWILIGHT_OAK_PLANKS)
            val twilightOakPool = registerCubeAllModelTexturePool(TFBlocks.TWILIGHT_OAK_PLANKS)
            registerSimpleCubeAll(TFBlocks.TWILIGHT_OAK_LEAVES)
            registerTintableCross(TFBlocks.TWILIGHT_OAK_SAPLING, BlockStateModelGenerator.CrossType.NOT_TINTED)
            //registerHangingSign(TFBlocks.STRIPPED_TWILIGHT_OAK_LOG, TFBlocks.TWILIGHT_OAK_HANGING_SIGN, TFBlocks.TWILIGHT_OAK_WALL_HANGING_SIGN)
            twilightOakFamily?.let { twilightOakPool.family(it) }
        }
    }

        override fun generateItemModels(generator: ItemModelGenerator) {
            //SINGLE LAYER
            listOf(
                TFItems.NAGA_SCALE,
                TFItems.LIVEROOT,
                TFItems.RAW_IRONWOOD,
                TFItems.IRONWOOD_INGOT,
                TFItems.STEELEAF_INGOT,
                TFItems.ARMOR_SHARD,
                TFItems.ARMOR_SHARD_CLUSTER,
                TFItems.KNIGHTMETAL_INGOT,
                TFItems.FIERY_BLOOD,
                TFItems.FIERY_TEARS,
                TFItems.FIERY_INGOT,
                TFItems.ARCTIC_FUR,
                TFItems.ALPHA_YETI_FUR,
                TFItems.RAVEN_FEATHER,
                TFItems.MAGIC_MAP_FOCUS,
                TFItems.MAZE_MAP_FOCUS,
                TFItems.CHARM_OF_LIFE_I,
                TFItems.CHARM_OF_LIFE_II,
                TFItems.CHARM_OF_KEEPING_I,
                TFItems.CHARM_OF_KEEPING_II,
                TFItems.CHARM_OF_KEEPING_III,
                TFItems.CARMINITE,
                TFItems.EMPERORS_CLOTH,
                TFItems.CROWN_SPLINTER,
                TFItems.TOWER_KEY,
                TFItems.RAW_VENISON,
                TFItems.COOKED_VENISON,
                TFItems.RAW_MEEF,
                TFItems.COOKED_MEEF,
                TFItems.MEEF_STROGANOFF,
                TFItems.HYDRA_CHOP,
                TFItems.TORCHBERRIES,
                TFItems.EXPERIMENT_115,
                TFItems.MAZE_WAFER,
                TFItems.POCKET_WATCH
            ).forEach { generator.register(it, Models.GENERATED) }
            //DUAL-LAYER
            generator.register(TFItems.BORER_ESSENCE)
            listOf("borer_essence").forEach {
                registerTwoLayerItemModel(generator, it)
            }
            //HANDHELD TOOLS
            listOf(
                TFItems.IRONWOOD_SWORD,
                TFItems.IRONWOOD_PICKAXE,
                TFItems.IRONWOOD_SHOVEL,
                TFItems.IRONWOOD_AXE,
                TFItems.IRONWOOD_HOE,
                TFItems.STEELEAF_SWORD,
                TFItems.STEELEAF_PICKAXE,
                TFItems.STEELEAF_SHOVEL,
                TFItems.STEELEAF_AXE,
                TFItems.STEELEAF_HOE,
                TFItems.KNIGHTMETAL_SWORD,
                TFItems.KNIGHTMETAL_PICKAXE,
                TFItems.KNIGHTMETAL_AXE,
                TFItems.FIERY_SWORD,
                TFItems.FIERY_PICKAXE,
                TFItems.MAZEBREAKER_PICKAXE,
                TFItems.GOLD_MINOTAUR_AXE,
                TFItems.DIAMOND_MINOTAUR_AXE
            ).forEach { generator.register(it, Models.HANDHELD) }
            //ARMOR
            registerArmorSet(
                generator,
                TFArmorMaterials.NAGA_KEY,
                mapOf(
                    EquipmentSlot.CHEST to TFItems.NAGA_CHESTPLATE,
                    EquipmentSlot.LEGS to TFItems.NAGA_LEGGINGS
                )
            )
            registerArmorSet(
                generator,
                TFArmorMaterials.IRONWOOD_KEY,
                mapOf(
                    EquipmentSlot.HEAD to TFItems.IRONWOOD_HELMET,
                    EquipmentSlot.CHEST to TFItems.IRONWOOD_CHESTPLATE,
                    EquipmentSlot.LEGS to TFItems.IRONWOOD_LEGGINGS,
                    EquipmentSlot.FEET to TFItems.IRONWOOD_BOOTS
                )
            )
            registerArmorSet(
                generator,
                TFArmorMaterials.STEELEAF_KEY,
                mapOf(
                    EquipmentSlot.HEAD to TFItems.STEELEAF_HELMET,
                    EquipmentSlot.CHEST to TFItems.STEELEAF_CHESTPLATE,
                    EquipmentSlot.LEGS to TFItems.STEELEAF_LEGGINGS,
                    EquipmentSlot.FEET to TFItems.STEELEAF_BOOTS
                )
            )
            registerArmorSet(
                generator,
                TFArmorMaterials.KNIGHTMETAL_KEY,
                mapOf(
                    EquipmentSlot.HEAD to TFItems.KNIGHTMETAL_HELMET,
                    EquipmentSlot.CHEST to TFItems.KNIGHTMETAL_CHESTPLATE,
                    EquipmentSlot.LEGS to TFItems.KNIGHTMETAL_LEGGINGS,
                    EquipmentSlot.FEET to TFItems.KNIGHTMETAL_BOOTS
                )
            )
            registerArmorSet(
                generator,
                TFArmorMaterials.PHANTOM_KEY,
                mapOf(
                    EquipmentSlot.HEAD to TFItems.PHANTOM_HELMET,
                    EquipmentSlot.CHEST to TFItems.PHANTOM_CHESTPLATE
                )
            )
            registerArmorSet(
                generator,
                TFArmorMaterials.FIERY_KEY,
                mapOf(
                    EquipmentSlot.HEAD to TFItems.FIERY_HELMET,
                    EquipmentSlot.CHEST to TFItems.FIERY_CHESTPLATE,
                    EquipmentSlot.LEGS to TFItems.FIERY_LEGGINGS,
                    EquipmentSlot.FEET to TFItems.FIERY_BOOTS
                )
            )
            registerDyeableArmorSet(
                generator,
                TFArmorMaterials.ARCTIC_KEY,
                mapOf(
                    EquipmentSlot.HEAD to TFItems.ARCTIC_HELMET,
                    EquipmentSlot.CHEST to TFItems.ARCTIC_CHESTPLATE,
                    EquipmentSlot.LEGS to TFItems.ARCTIC_LEGGINGS,
                    EquipmentSlot.FEET to TFItems.ARCTIC_BOOTS
                )
            )
            registerArmorSet(
                generator,
                TFArmorMaterials.YETI_KEY,
                mapOf(
                    EquipmentSlot.HEAD to TFItems.YETI_HELMET,
                    EquipmentSlot.CHEST to TFItems.YETI_CHESTPLATE,
                    EquipmentSlot.LEGS to TFItems.YETI_LEGGINGS,
                    EquipmentSlot.FEET to TFItems.YETI_BOOTS
                )
            )
        }

    fun registerArmorSet(
        generator: ItemModelGenerator,
        armorKey: RegistryKey<EquipmentAsset>,
        items: Map<EquipmentSlot, Item>
    ) {
        items.forEach { (slot, item) ->
            val trimPrefix = when (slot) {
                EquipmentSlot.HEAD -> ItemModelGenerator.HELMET_TRIM_ID_PREFIX
                EquipmentSlot.CHEST -> ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX
                EquipmentSlot.LEGS -> ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX
                EquipmentSlot.FEET -> ItemModelGenerator.BOOTS_TRIM_ID_PREFIX
                else -> null
            }

            if (trimPrefix != null) {
                generator.registerArmor(item, armorKey, trimPrefix, false)
            }
        }
    }
    fun registerDyeableArmorSet(
        generator: ItemModelGenerator,
        armorKey: RegistryKey<EquipmentAsset>,
        items: Map<EquipmentSlot, Item>
    ) {
        items.forEach { (slot, item) ->
            val trimPrefix = when (slot) {
                EquipmentSlot.HEAD -> ItemModelGenerator.HELMET_TRIM_ID_PREFIX
                EquipmentSlot.CHEST -> ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX
                EquipmentSlot.LEGS -> ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX
                EquipmentSlot.FEET -> ItemModelGenerator.BOOTS_TRIM_ID_PREFIX
                else -> null
            }

            if (trimPrefix != null) {
                generator.registerArmor(item, armorKey, trimPrefix, true)
            }
        }
    }
    fun registerTwoLayerItemModel(
        generator: ItemModelGenerator,
        name: String
    ) {
        val modId = TwilightForest.MOD_ID
        val id = Identifier.of(modId, "item/$name")
        Models.GENERATED_TWO_LAYERS.upload(
            id,
            TextureMap.layered(
                Identifier.of(modId, "item/$name"),
                Identifier.of(modId, "item/${name}_overlay")
            ),
            generator.modelCollector
        )
    }
}

