package autumn.twilightforest.datagen.providers

import autumn.twilightforest.init.block.TFBlocks
import autumn.twilightforest.init.item.TFItems
import autumn.twilightforest.util.TFBlockFamilies
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.minecraft.client.data.BlockStateModelGenerator
import net.minecraft.client.data.ItemModelGenerator
import net.minecraft.client.data.Models
import net.minecraft.item.ArmorItem
import net.minecraft.item.equipment.EquipmentAsset
import net.minecraft.registry.RegistryKey

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
            registerSimpleCubeAll(TFBlocks.CRACKED_MAZESTONE)
            registerSimpleCubeAll(TFBlocks.MOSSY_MAZESTONE)
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

            registerLog(TFBlocks.TWILIGHT_OAK_LOG).log(TFBlocks.TWILIGHT_OAK_LOG).wood(TFBlocks.TWILIGHT_OAK_WOOD)
            registerLog(TFBlocks.STRIPPED_TWILIGHT_OAK_LOG).log(TFBlocks.STRIPPED_TWILIGHT_OAK_LOG)
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
                TFItems.BORER_ESSENCE,
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

            /*
            //ARMOR
            registerArmorSet(
                generator = generator,
                armorKey = TFArmorMaterials.NAGA_SCALE_KEY,
                items = mapOf(
                    "chestplate" to TFItems.NAGA_CHESTPLATE as ArmorItem,
                    "leggings" to TFItems.NAGA_LEGGINGS as ArmorItem,
                )
            )
            registerFullArmorSet(
                generator,
                TFArmorMaterials.IRONWOOD_KEY,
                TFItems.IRONWOOD_HELMET as ArmorItem,
                TFItems.IRONWOOD_CHESTPLATE as ArmorItem,
                TFItems.IRONWOOD_LEGGINGS as ArmorItem,
                TFItems.IRONWOOD_BOOTS as ArmorItem
            )
            registerFullArmorSet(
                generator,
                TFArmorMaterials.STEELEAF_KEY,
                TFItems.STEELEAF_HELMET as ArmorItem,
                TFItems.STEELEAF_CHESTPLATE as ArmorItem,
                TFItems.STEELEAF_LEGGINGS as ArmorItem,
                TFItems.STEELEAF_BOOTS as ArmorItem
            )
            registerFullArmorSet(
                generator,
                TFArmorMaterials.KNIGHTMETAL_KEY,
                TFItems.KNIGHTMETAL_HELMET as ArmorItem,
                TFItems.KNIGHTMETAL_CHESTPLATE as ArmorItem,
                TFItems.KNIGHTMETAL_LEGGINGS as ArmorItem,
                TFItems.KNIGHTMETAL_BOOTS as ArmorItem
            )
            registerArmorSet(
                generator = generator,
                armorKey = TFArmorMaterials.PHANTOM_KEY,
                items = mapOf(
                    "helmet" to TFItems.PHANTOM_HELMET as ArmorItem,
                    "chestplate" to TFItems.PHANTOM_CHESTPLATE as ArmorItem,
                )
            )
            registerFullArmorSet(
                generator,
                TFArmorMaterials.FIERY_KEY,
                TFItems.FIERY_HELMET as ArmorItem,
                TFItems.FIERY_CHESTPLATE as ArmorItem,
                TFItems.FIERY_LEGGINGS as ArmorItem,
                TFItems.FIERY_BOOTS as ArmorItem
            )
            registerFullArmorSet(
                generator,
                TFArmorMaterials.ARCTIC_KEY,
                TFItems.ARCTIC_HELMET as ArmorItem,
                TFItems.ARCTIC_CHESTPLATE as ArmorItem,
                TFItems.ARCTIC_LEGGINGS as ArmorItem,
                TFItems.ARCTIC_BOOTS as ArmorItem
            )
            registerFullArmorSet(
                generator,
                TFArmorMaterials.YETI_KEY,
                TFItems.YETI_HELMET as ArmorItem,
                TFItems.YETI_CHESTPLATE as ArmorItem,
                TFItems.YETI_LEGGINGS as ArmorItem,
                TFItems.YETI_BOOTS as ArmorItem
            )*/
            generator.registerArmor(TFItems.IRONWOOD_HELMET as ArmorItem, ModArmorMaterials.IRONWOOD_KEY, "helmet", false)
            generator.registerArmor(TFItems.IRONWOOD_CHESTPLATE as ArmorItem, ModArmorMaterials.IRONWOOD_KEY, "chestplate", false)
            generator.registerArmor(TFItems.IRONWOOD_LEGGINGS as ArmorItem, ModArmorMaterials.IRONWOOD_KEY, "leggings", false)
            generator.registerArmor(TFItems.IRONWOOD_BOOTS as ArmorItem, ModArmorMaterials.IRONWOOD_KEY, "boots", false)
        }

    fun registerArmorSet(generator: ItemModelGenerator, armorKey: RegistryKey<EquipmentAsset>, items: Map<String, ArmorItem>) {
        items.forEach { (slot, item) ->
            generator.registerArmor(item, armorKey, slot, false)
        }
    }

    fun registerFullArmorSet(generator: ItemModelGenerator, armorKey: RegistryKey<EquipmentAsset>, helmet: ArmorItem, chestplate: ArmorItem, leggings: ArmorItem, boots: ArmorItem) {
        registerArmorSet(generator, armorKey, mapOf(
            "helmet" to helmet,
            "chestplate" to chestplate,
            "leggings" to leggings,
            "boots" to boots
        ))
    }
}

