package autumn.twilightforest.init.item

import autumn.twilightforest.TwilightForest
import autumn.twilightforest.boat.api.item.TFBoatItemHelper
import autumn.twilightforest.component.TFDataComponentTypes
import autumn.twilightforest.component.tooltip.TooltipComponent
import autumn.twilightforest.init.block.TFBlocks
import autumn.twilightforest.init.item.custom.FieryItem
import autumn.twilightforest.init.item.custom.PocketWatchItem
import net.minecraft.item.BoatItem
import net.minecraft.item.HangingSignItem
import net.minecraft.item.Item
import net.minecraft.item.Items
import net.minecraft.item.SignItem
import net.minecraft.item.ToolMaterial
import net.minecraft.item.equipment.EquipmentType
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier
import net.minecraft.util.Rarity

object TFItems {


    val NAGA_SCALE = registerItem("naga_scale") { it.rarity(Rarity.UNCOMMON); Item(it) }
    val LIVEROOT = registerItem("liveroot") { Item(it) }
    val RAW_IRONWOOD = registerItem("raw_ironwood") { Item(it) }
    val IRONWOOD_INGOT = registerItem("ironwood_ingot") { Item(it) }
    val STEELEAF_INGOT = registerItem("steeleaf_ingot") { Item(it) }
    val ARMOR_SHARD = registerItem("armor_shard") { Item(it) }
    val ARMOR_SHARD_CLUSTER = registerItem("armor_shard_cluster") { Item(it) }
    val KNIGHTMETAL_INGOT = registerItem("knightmetal_ingot") { Item(it) }
    val FIERY_BLOOD = registerItem("fiery_blood") { it.rarity(Rarity.UNCOMMON); Item(it) }
    val FIERY_TEARS = registerItem("fiery_tears") { it.rarity(Rarity.UNCOMMON); Item(it) }
    val FIERY_INGOT = registerItem("fiery_ingot") { it.rarity(Rarity.UNCOMMON); FieryItem(it) }
    val ARCTIC_FUR = registerItem("arctic_fur") { Item(it) }
    val ALPHA_YETI_FUR = registerItem("alpha_yeti_fur") { it.rarity(Rarity.UNCOMMON); Item(it) }

    // MISC INGREDIENTS
    val RAVEN_FEATHER = registerItem("raven_feather") { Item(it) }
    val MAGIC_MAP_FOCUS = registerItem("magic_map_focus") { Item(it) }
    val MAZE_MAP_FOCUS = registerItem("maze_map_focus") { Item(it) }
    val CHARM_OF_LIFE_I = registerItem("charm_of_life_i") { Item(it.rarity(Rarity.UNCOMMON)) }
    val CHARM_OF_LIFE_II = registerItem("charm_of_life_ii") { Item(it.rarity(Rarity.UNCOMMON)) }
    val CHARM_OF_KEEPING_I = registerItem("charm_of_keeping_i") { Item(it.rarity(Rarity.UNCOMMON)) }
    val CHARM_OF_KEEPING_II = registerItem("charm_of_keeping_ii") { Item(it.rarity(Rarity.UNCOMMON)) }
    val CHARM_OF_KEEPING_III = registerItem("charm_of_keeping_iii") { Item(it.rarity(Rarity.UNCOMMON)) }
    val BORER_ESSENCE = registerItem("borer_essence") { Item(it) }
    val CARMINITE = registerItem("carminite") { Item(it) }
    val EMPERORS_CLOTH = registerItem("emperors_cloth") { Item(it.rarity(Rarity.UNCOMMON)) }
    val CROWN_SPLINTER = registerItem("crown_splinter") { Item(it.rarity(Rarity.UNCOMMON)) }

    // MISC ITEMS
    val TOWER_KEY = registerItem("tower_key") { Item(it.fireproof().rarity(Rarity.UNCOMMON)) }

    // FOOD ITEMS
    val RAW_VENISON = registerItem("raw_venison") { Item(it.food(TFFoodComponents.RAW_VENISON)) }
    val COOKED_VENISON = registerItem("cooked_venison") { Item(it.food(TFFoodComponents.COOKED_VENISON)) }
    val RAW_MEEF = registerItem("raw_meef") { Item(it.food(TFFoodComponents.RAW_MEEF)) }
    val COOKED_MEEF = registerItem("cooked_meef") { Item(it.food(TFFoodComponents.COOKED_MEEF)) }
    val MEEF_STROGANOFF = registerItem("meef_stroganoff") { Item(it.maxCount(1).food(TFFoodComponents.MEEF_STROGANOFF).useRemainder(Items.BOWL).rarity(Rarity.UNCOMMON)) }
    val HYDRA_CHOP = registerItem("hydra_chop") { Item(it.food(TFFoodComponents.HYDRA_CHOP, TFConsumableComponents.HYDRA_CHOP_EFFECT).fireproof().rarity(Rarity.UNCOMMON)) }
    val TORCHBERRIES = registerItem("torchberries") { Item(it.food(TFFoodComponents.TORCHBERRIES, TFConsumableComponents.TORCHBERRIES_EFFECT)) }
    val EXPERIMENT_115 = registerItem("experiment_115") { Item(it.food(TFFoodComponents.EXPERIMENT_115).component(
        TFDataComponentTypes.TOOLTIP, TooltipComponent("tooltip.twilightforest.experiment_115.tooltip"))) }
    val MAZE_WAFER = registerItem("maze_wafer") { Item(it.food(TFFoodComponents.MAZE_WAFER)) }

    // EQUIPMENT & TRINKETS
    val POCKET_WATCH = registerItem("pocket_watch") { PocketWatchItem(it.maxCount(1).rarity(Rarity.RARE).component(
        TFDataComponentTypes.TOOLTIP, TooltipComponent("tooltip.twilightforest.pocket_watch.tooltip"))) }

    val NAGA_LEGGINGS = registerItem("naga_leggings") { Item(it.armor(TFArmorMaterials.NAGA_ARMOR_MATERIAL, EquipmentType.LEGGINGS)) }
    val NAGA_CHESTPLATE = registerItem("naga_chestplate") { Item(it.armor(TFArmorMaterials.NAGA_ARMOR_MATERIAL, EquipmentType.CHESTPLATE)) }

    val IRONWOOD_BOOTS = registerItem("ironwood_boots") { Item(it.armor(TFArmorMaterials.IRONWOOD_ARMOR_MATERIAL, EquipmentType.BOOTS)) }
    val IRONWOOD_LEGGINGS = registerItem("ironwood_leggings") { Item(it.armor(TFArmorMaterials.IRONWOOD_ARMOR_MATERIAL, EquipmentType.LEGGINGS)) }
    val IRONWOOD_CHESTPLATE = registerItem("ironwood_chestplate") { Item(it.armor(TFArmorMaterials.IRONWOOD_ARMOR_MATERIAL, EquipmentType.CHESTPLATE)) }
    val IRONWOOD_HELMET = registerItem("ironwood_helmet") { Item(it.armor(TFArmorMaterials.IRONWOOD_ARMOR_MATERIAL, EquipmentType.HELMET)) }
    val IRONWOOD_SWORD = registerItem("ironwood_sword") { Item(it.sword(TFToolMaterials.IRONWOOD, 4.0F, -2.4F)) }
    val IRONWOOD_PICKAXE = registerItem("ironwood_pickaxe") { Item(it.pickaxe(TFToolMaterials.IRONWOOD, 2.0F, -2.8F)) }
    val IRONWOOD_SHOVEL = registerItem("ironwood_shovel") { Item(it.shovel(TFToolMaterials.IRONWOOD, 2.5F, -3.0F)) }
    val IRONWOOD_AXE = registerItem("ironwood_axe") { Item(it.axe(TFToolMaterials.IRONWOOD, 7.0F, -3.1F)) }
    val IRONWOOD_HOE = registerItem("ironwood_hoe") { Item(it.hoe(TFToolMaterials.IRONWOOD, -1.0F, -1.0F)) }

    val STEELEAF_BOOTS = registerItem("steeleaf_boots") { Item(it.armor(TFArmorMaterials.STEELEAF_ARMOR_MATERIAL, EquipmentType.BOOTS)) }
    val STEELEAF_LEGGINGS = registerItem("steeleaf_leggings") { Item(it.armor(TFArmorMaterials.STEELEAF_ARMOR_MATERIAL, EquipmentType.LEGGINGS)) }
    val STEELEAF_CHESTPLATE = registerItem("steeleaf_chestplate") { Item(it.armor(TFArmorMaterials.STEELEAF_ARMOR_MATERIAL, EquipmentType.CHESTPLATE)) }
    val STEELEAF_HELMET = registerItem("steeleaf_helmet") { Item(it.armor(TFArmorMaterials.STEELEAF_ARMOR_MATERIAL, EquipmentType.HELMET)) }
    val STEELEAF_SWORD = registerItem("steeleaf_sword") { Item(it.sword(TFToolMaterials.STEELEAF, 4.0F, -2.4F)) }
    val STEELEAF_PICKAXE = registerItem("steeleaf_pickaxe") { Item(it.pickaxe(TFToolMaterials.STEELEAF, 2.0F, -2.8F)) }
    val STEELEAF_SHOVEL = registerItem("steeleaf_shovel") { Item(it.shovel(TFToolMaterials.STEELEAF, 2.5F, -3.0F)) }
    val STEELEAF_AXE = registerItem("steeleaf_axe") { Item(it.axe(TFToolMaterials.STEELEAF, 7.0F, -3.0F)) }
    val STEELEAF_HOE = registerItem("steeleaf_hoe") { Item(it.hoe(TFToolMaterials.STEELEAF, -2.0F, -0.5F)) }

    val GOLD_MINOTAUR_AXE = registerItem("gold_minotaur_axe") { Item(it.axe(ToolMaterial.GOLD, 7.0F, -2.8F)) }
    val DIAMOND_MINOTAUR_AXE = registerItem("diamond_minotaur_axe") { Item(it.axe(ToolMaterial.DIAMOND, 7.0F, -3.0F).rarity(Rarity.RARE)) }
    val MAZEBREAKER_PICKAXE = registerItem("mazebreaker_pickaxe") { Item(it.pickaxe(ToolMaterial.DIAMOND, 2.0F, -2.8F).rarity(Rarity.EPIC)) }

    val KNIGHTMETAL_BOOTS = registerItem("knightmetal_boots") { Item(it.armor(TFArmorMaterials.KNIGHTMETAL_ARMOR_MATERIAL, EquipmentType.BOOTS)) }
    val KNIGHTMETAL_LEGGINGS = registerItem("knightmetal_leggings") { Item(it.armor(TFArmorMaterials.KNIGHTMETAL_ARMOR_MATERIAL, EquipmentType.LEGGINGS)) }
    val KNIGHTMETAL_CHESTPLATE = registerItem("knightmetal_chestplate") { Item(it.armor(TFArmorMaterials.KNIGHTMETAL_ARMOR_MATERIAL, EquipmentType.CHESTPLATE)) }
    val KNIGHTMETAL_HELMET = registerItem("knightmetal_helmet") { Item(it.armor(TFArmorMaterials.KNIGHTMETAL_ARMOR_MATERIAL, EquipmentType.HELMET)) }
    val KNIGHTMETAL_SWORD = registerItem("knightmetal_sword") { Item(it.sword(TFToolMaterials.KNIGHTMETAL, 4.0F, -2.4F)) }
    val KNIGHTMETAL_PICKAXE = registerItem("knightmetal_pickaxe") { Item(it.pickaxe(TFToolMaterials.KNIGHTMETAL, 2.0F, -2.8F)) }
    val KNIGHTMETAL_AXE = registerItem("knightmetal_axe") { Item(it.axe(TFToolMaterials.KNIGHTMETAL, 7.0F, -3.0F)) }

    val PHANTOM_CHESTPLATE = registerItem("phantom_chestplate") { Item(it.armor(TFArmorMaterials.PHANTOM_ARMOR_MATERIAL, EquipmentType.CHESTPLATE).rarity(Rarity.EPIC)) }
    val PHANTOM_HELMET = registerItem("phantom_helmet") { Item(it.armor(TFArmorMaterials.PHANTOM_ARMOR_MATERIAL, EquipmentType.HELMET).rarity(Rarity.EPIC)) }

    val FIERY_BOOTS = registerItem("fiery_boots") { FieryItem(it.armor(TFArmorMaterials.FIERY_ARMOR_MATERIAL, EquipmentType.BOOTS)) }
    val FIERY_LEGGINGS = registerItem("fiery_leggings") { FieryItem(it.armor(TFArmorMaterials.FIERY_ARMOR_MATERIAL, EquipmentType.LEGGINGS)) }
    val FIERY_CHESTPLATE = registerItem("fiery_chestplate") { FieryItem(it.armor(TFArmorMaterials.FIERY_ARMOR_MATERIAL, EquipmentType.CHESTPLATE)) }
    val FIERY_HELMET = registerItem("fiery_helmet") { FieryItem(it.armor(TFArmorMaterials.FIERY_ARMOR_MATERIAL, EquipmentType.HELMET)) }
    val FIERY_SWORD = registerItem("fiery_sword") { FieryItem(it.sword(TFToolMaterials.FIERY, 4.0F, -2.4F)) }
    val FIERY_PICKAXE = registerItem("fiery_pickaxe") { FieryItem(it.pickaxe(TFToolMaterials.FIERY, 2.0F, -2.8F)) }

    val ARCTIC_BOOTS = registerItem("arctic_boots") { Item(it.armor(TFArmorMaterials.ARCTIC_ARMOR_MATERIAL, EquipmentType.BOOTS)) }
    val ARCTIC_LEGGINGS = registerItem("arctic_leggings") { Item(it.armor(TFArmorMaterials.ARCTIC_ARMOR_MATERIAL, EquipmentType.LEGGINGS)) }
    val ARCTIC_CHESTPLATE = registerItem("arctic_chestplate") { Item(it.armor(TFArmorMaterials.ARCTIC_ARMOR_MATERIAL, EquipmentType.CHESTPLATE)) }
    val ARCTIC_HELMET = registerItem("arctic_helmet") { Item(it.armor(TFArmorMaterials.ARCTIC_ARMOR_MATERIAL, EquipmentType.HELMET)) }

    val YETI_BOOTS = registerItem("yeti_boots") { Item(it.armor(TFArmorMaterials.YETI_ARMOR_MATERIAL, EquipmentType.BOOTS)) }
    val YETI_LEGGINGS = registerItem("yeti_leggings") { Item(it.armor(TFArmorMaterials.YETI_ARMOR_MATERIAL, EquipmentType.LEGGINGS)) }
    val YETI_CHESTPLATE = registerItem("yeti_chestplate") { Item(it.armor(TFArmorMaterials.YETI_ARMOR_MATERIAL, EquipmentType.CHESTPLATE)) }
    val YETI_HELMET = registerItem("yeti_helmet") { Item(it.armor(TFArmorMaterials.YETI_ARMOR_MATERIAL, EquipmentType.HELMET)) }

    //WOOD
    val TWILIGHT_OAK_SIGN = registerItem("twilight_oak_sign") { SignItem(TFBlocks.TWILIGHT_OAK_SIGN, TFBlocks.TWILIGHT_OAK_WALL_SIGN, it.maxCount(16)) }
    val TWILIGHT_OAK_HANGING_SIGN = registerItem("twilight_oak_hanging_sign") { HangingSignItem(TFBlocks.TWILIGHT_OAK_HANGING_SIGN, TFBlocks.TWILIGHT_OAK_WALL_HANGING_SIGN, it.maxCount(16)) }
    val TWILIGHT_OAK_BOAT: BoatItem = TFBoatItemHelper.registerBoatItem(Identifier.of(TwilightForest.MOD_ID, "twilight_oak"), false)
    val TWILIGHT_OAK_CHEST_BOAT: BoatItem = TFBoatItemHelper.registerBoatItem(Identifier.of(TwilightForest.MOD_ID, "twilight_oak"), true)

    val CANOPY_SIGN = registerItem("canopy_sign") { SignItem(TFBlocks.CANOPY_SIGN, TFBlocks.CANOPY_WALL_SIGN, it.maxCount(16)) }
    val CANOPY_HANGING_SIGN = registerItem("canopy_hanging_sign") { HangingSignItem(TFBlocks.CANOPY_HANGING_SIGN, TFBlocks.CANOPY_WALL_HANGING_SIGN, it.maxCount(16)) }
    val CANOPY_BOAT: BoatItem = TFBoatItemHelper.registerBoatItem(Identifier.of(TwilightForest.MOD_ID, "canopy"), false)
    val CANOPY_CHEST_BOAT: BoatItem = TFBoatItemHelper.registerBoatItem(Identifier.of(TwilightForest.MOD_ID, "canopy"), true)

    val TWILIGHT_MANGROVE_SIGN = registerItem("twilight_mangrove_sign") { SignItem(TFBlocks.TWILIGHT_MANGROVE_SIGN, TFBlocks.TWILIGHT_MANGROVE_WALL_SIGN, it.maxCount(16)) }
    val TWILIGHT_MANGROVE_HANGING_SIGN = registerItem("twilight_mangrove_hanging_sign") { HangingSignItem(TFBlocks.TWILIGHT_MANGROVE_HANGING_SIGN, TFBlocks.TWILIGHT_MANGROVE_WALL_HANGING_SIGN, it.maxCount(16)) }
    val TWILIGHT_MANGROVE_BOAT: BoatItem = TFBoatItemHelper.registerBoatItem(Identifier.of(TwilightForest.MOD_ID, "twilight_mangrove"), false)
    val TWILIGHT_MANGROVE_CHEST_BOAT: BoatItem = TFBoatItemHelper.registerBoatItem(Identifier.of(TwilightForest.MOD_ID, "twilight_mangrove"), true)

    val DARK_SIGN = registerItem("dark_sign") { SignItem(TFBlocks.DARK_SIGN, TFBlocks.DARK_WALL_SIGN, it.maxCount(16)) }
    val DARK_HANGING_SIGN = registerItem("dark_hanging_sign") { HangingSignItem(TFBlocks.DARK_HANGING_SIGN, TFBlocks.DARK_WALL_HANGING_SIGN, it.maxCount(16)) }
    val DARK_BOAT: BoatItem = TFBoatItemHelper.registerBoatItem(Identifier.of(TwilightForest.MOD_ID, "dark"), false)
    val DARK_CHEST_BOAT: BoatItem = TFBoatItemHelper.registerBoatItem(Identifier.of(TwilightForest.MOD_ID, "dark"), true)

    val TIME_SIGN = registerItem("time_sign") { SignItem(TFBlocks.TIME_SIGN, TFBlocks.TIME_WALL_SIGN, it.maxCount(16)) }
    val TIME_HANGING_SIGN = registerItem("time_hanging_sign") { HangingSignItem(TFBlocks.TIME_HANGING_SIGN, TFBlocks.TIME_WALL_HANGING_SIGN, it.maxCount(16)) }
    val TIME_BOAT: BoatItem = TFBoatItemHelper.registerBoatItem(Identifier.of(TwilightForest.MOD_ID, "time"), false)
    val TIME_CHEST_BOAT: BoatItem = TFBoatItemHelper.registerBoatItem(Identifier.of(TwilightForest.MOD_ID, "time"), true)

    val TRANSFORMATION_SIGN = registerItem("transformation_sign") { SignItem(TFBlocks.TRANSFORMATION_SIGN, TFBlocks.TRANSFORMATION_WALL_SIGN, it.maxCount(16)) }
    val TRANSFORMATION_HANGING_SIGN = registerItem("transformation_hanging_sign") { HangingSignItem(TFBlocks.TRANSFORMATION_HANGING_SIGN, TFBlocks.TRANSFORMATION_WALL_HANGING_SIGN, it.maxCount(16)) }
    val TRANSFORMATION_BOAT: BoatItem = TFBoatItemHelper.registerBoatItem(Identifier.of(TwilightForest.MOD_ID, "transformation"), false)
    val TRANSFORMATION_CHEST_BOAT: BoatItem = TFBoatItemHelper.registerBoatItem(Identifier.of(TwilightForest.MOD_ID, "transformation"), true)

    val MINING_SIGN = registerItem("mining_sign") { SignItem(TFBlocks.MINING_SIGN, TFBlocks.MINING_WALL_SIGN, it.maxCount(16)) }
    val MINING_HANGING_SIGN = registerItem("mining_hanging_sign") { HangingSignItem(TFBlocks.MINING_HANGING_SIGN, TFBlocks.MINING_WALL_HANGING_SIGN, it.maxCount(16)) }
    val MINING_BOAT: BoatItem = TFBoatItemHelper.registerBoatItem(Identifier.of(TwilightForest.MOD_ID, "mining"), false)
    val MINING_CHEST_BOAT: BoatItem = TFBoatItemHelper.registerBoatItem(Identifier.of(TwilightForest.MOD_ID, "mining"), true)

    val SORTING_SIGN = registerItem("sorting_sign") { SignItem(TFBlocks.SORTING_SIGN, TFBlocks.SORTING_WALL_SIGN, it.maxCount(16)) }
    val SORTING_HANGING_SIGN = registerItem("sorting_hanging_sign") { HangingSignItem(TFBlocks.SORTING_HANGING_SIGN, TFBlocks.SORTING_WALL_HANGING_SIGN, it.maxCount(16)) }
    val SORTING_BOAT: BoatItem = TFBoatItemHelper.registerBoatItem(Identifier.of(TwilightForest.MOD_ID, "sorting"), false)
    val SORTING_CHEST_BOAT: BoatItem = TFBoatItemHelper.registerBoatItem(Identifier.of(TwilightForest.MOD_ID, "sorting"), true)

    private fun registerItem(name: String, factory: (Item.Settings) -> Item): Item {
        val id = Identifier.of(TwilightForest.MOD_ID, name)
        val key = RegistryKey.of(RegistryKeys.ITEM, id)
        val settings = Item.Settings().registryKey(key)
        val item = factory(settings)

        return Registry.register(Registries.ITEM, key, item)
    }

    fun registerItems() {
        TwilightForest.logger?.info("Registering items for" + TwilightForest.MOD_ID)
    }
}