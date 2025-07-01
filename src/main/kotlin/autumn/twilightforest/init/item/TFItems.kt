package autumn.twilightforest.init.item

import autumn.twilightforest.TwilightForest
import autumn.twilightforest.init.block.TFBlocks
import autumn.twilightforest.init.item.custom.PocketWatchItem
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.component.DataComponentTypes
import net.minecraft.item.ArmorItem
import net.minecraft.item.AxeItem
import net.minecraft.item.HangingSignItem
import net.minecraft.item.HoeItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.item.PickaxeItem
import net.minecraft.item.ShovelItem
import net.minecraft.item.SignItem
import net.minecraft.item.SwordItem
import net.minecraft.item.ToolMaterial
import net.minecraft.item.equipment.EquipmentType
import net.minecraft.item.tooltip.TooltipType
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.tag.ItemTags
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import net.minecraft.util.Rarity

object TFItems {

    //EQUIPMENT INGREDIENTS
    val NAGA_SCALE = registerItem("naga_scale", Item(Item.Settings().rarity(Rarity.UNCOMMON)
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "naga_scale")))))
    val LIVEROOT = registerItem("liveroot", Item(Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "liveroot")))))
    val RAW_IRONWOOD = registerItem("raw_ironwood", Item(Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "raw_ironwood")))))
    val IRONWOOD_INGOT = registerItem("ironwood_ingot", Item(Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "ironwood_ingot")))))
    val STEELEAF_INGOT = registerItem("steeleaf_ingot", Item(Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "steeleaf_ingot")))))
    val ARMOR_SHARD = registerItem("armor_shard", Item(Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "armor_shard")))))
    val ARMOR_SHARD_CLUSTER = registerItem("armor_shard_cluster", Item(Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "armor_shard_cluster")))))
    val KNIGHTMETAL_INGOT = registerItem("knightmetal_ingot", Item(Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "knightmetal_ingot")))))
    val FIERY_BLOOD = registerItem("fiery_blood", Item(Item.Settings().rarity(Rarity.UNCOMMON)
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "fiery_blood")))))
    val FIERY_TEARS = registerItem("fiery_tears", Item(Item.Settings().rarity(Rarity.UNCOMMON)
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "fiery_tears")))))
    val FIERY_INGOT = registerItem("fiery_ingot", Item(Item.Settings().rarity(Rarity.UNCOMMON)
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "fiery_ingot")))))
    val ARCTIC_FUR = registerItem("arctic_fur", Item(Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "arctic_fur")))))
    val ALPHA_YETI_FUR = registerItem("alpha_yeti_fur", Item(Item.Settings().rarity(Rarity.UNCOMMON)
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "alpha_yeti_fur")))))

    //MISC INGREDIENTS
    val RAVEN_FEATHER = registerItem("raven_feather", Item(Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "raven_feather")))))
    val MAGIC_MAP_FOCUS = registerItem("magic_map_focus", Item(Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "magic_map_focus")))))
    val MAZE_MAP_FOCUS = registerItem("maze_map_focus", Item(Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "maze_map_focus")))))
    val CHARM_OF_LIFE_I = registerItem("charm_of_life_i", Item(Item.Settings().rarity(Rarity.UNCOMMON)
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "charm_of_life_i")))))
    val CHARM_OF_LIFE_II = registerItem("charm_of_life_ii", Item(Item.Settings().rarity(Rarity.UNCOMMON)
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "charm_of_life_ii")))))
    val CHARM_OF_KEEPING_I = registerItem("charm_of_keeping_i", Item(Item.Settings().rarity(Rarity.UNCOMMON)
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "charm_of_keeping_i")))))
    val CHARM_OF_KEEPING_II = registerItem("charm_of_keeping_ii", Item(Item.Settings().rarity(Rarity.UNCOMMON)
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "charm_of_keeping_ii")))))
    val CHARM_OF_KEEPING_III = registerItem("charm_of_keeping_iii", Item(Item.Settings().rarity(Rarity.UNCOMMON)
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "charm_of_keeping_iii")))))
    val BORER_ESSENCE = registerItem("borer_essence", Item(Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "borer_essence")))))
    val CARMINITE = registerItem("carminite", Item(Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "carminite")))))
    val EMPERORS_CLOTH = registerItem("emperors_cloth", Item(Item.Settings().rarity(Rarity.UNCOMMON)
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "emperors_cloth")))))
    val CROWN_SPLINTER = registerItem("crown_splinter", Item(Item.Settings().rarity(Rarity.UNCOMMON)
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "crown_splinter")))))

    //MISC ITEMS
    val TOWER_KEY = registerItem("tower_key", Item(Item.Settings().fireproof().rarity(Rarity.UNCOMMON)
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "tower_key")))))

    //FOOD ITEMS
    val RAW_VENISON = registerItem("raw_venison", Item(Item.Settings().food(TFFoodComponents.RAW_VENISON)
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "raw_venison")))))
    val COOKED_VENISON = registerItem("cooked_venison", Item(Item.Settings().food(TFFoodComponents.COOKED_VENISON)
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "cooked_venison")))))
    val RAW_MEEF = registerItem("raw_meef", Item(Item.Settings().food(TFFoodComponents.RAW_MEEF)
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "raw_meef")))))
    val COOKED_MEEF = registerItem("cooked_meef", Item(Item.Settings().food(TFFoodComponents.COOKED_MEEF)
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "cooked_meef")))))
    val MEEF_STROGANOFF = registerItem("meef_stroganoff", Item(Item.Settings().maxCount(1).food(TFFoodComponents.MEEF_STROGANOFF).useRemainder(Items.BOWL).rarity(Rarity.UNCOMMON)
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "meef_stroganoff")))))
    val HYDRA_CHOP = registerItem("hydra_chop", Item(Item.Settings().food(TFFoodComponents.HYDRA_CHOP, TFConsumableComponents.HYDRA_CHOP_EFFECT).fireproof().rarity(Rarity.UNCOMMON)
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "hydra_chop")))))
    val TORCHBERRIES = registerItem("torchberries", Item(Item.Settings().food(TFFoodComponents.TORCHBERRIES, TFConsumableComponents.TORCHBERRIES_EFFECT)
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "torchberries")))))
    val EXPERIMENT_115 = registerItem("experiment_115", object : Item(Item.Settings().food(TFFoodComponents.EXPERIMENT_115)
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "experiment_115")))) {
        override fun appendTooltip(stack: ItemStack, context: TooltipContext, tooltip: MutableList<Text>, type: TooltipType) {
            tooltip.add(Text.translatable("tooltip.twilightforest.experiment_115.tooltip").withColor(16717824))
            super.appendTooltip(stack, context, tooltip, type)
        }
    })
    val MAZE_WAFER = registerItem("maze_wafer", Item(Item.Settings().food(TFFoodComponents.MAZE_WAFER)
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "maze_wafer")))))

    //EQUIPMENT & TRINKETS
    val POCKET_WATCH = registerItem("pocket_watch", PocketWatchItem(Item.Settings().maxCount(1).rarity(Rarity.RARE)
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "pocket_watch")))))

    val NAGA_LEGGINGS = registerItem("naga_leggings", ArmorItem(TFArmorMaterials.NAGA_SCALE, EquipmentType.LEGGINGS, Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "naga_leggings")))))
    val NAGA_CHESTPLATE = registerItem("naga_chestplate", ArmorItem(TFArmorMaterials.NAGA_SCALE, EquipmentType.CHESTPLATE, Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "naga_chestplate")))))

    val IRONWOOD_BOOTS = registerItem("ironwood_boots", ArmorItem(TFArmorMaterials.IRONWOOD, EquipmentType.BOOTS, Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "ironwood_boots")))))
    val IRONWOOD_LEGGINGS = registerItem("ironwood_leggings", ArmorItem(TFArmorMaterials.IRONWOOD, EquipmentType.LEGGINGS, Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "ironwood_leggings")))))
    val IRONWOOD_CHESTPLATE = registerItem("ironwood_chestplate", ArmorItem(TFArmorMaterials.IRONWOOD, EquipmentType.CHESTPLATE, Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "ironwood_chestplate")))))
    val IRONWOOD_HELMET = registerItem("ironwood_helmet", ArmorItem(TFArmorMaterials.IRONWOOD, EquipmentType.HELMET, Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "ironwood_helmet")))))
    val IRONWOOD_SWORD = registerItem("ironwood_sword", SwordItem(TFToolMaterials.IRONWOOD,  4.0F, -2.4F, Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "ironwood_sword")))))
    val IRONWOOD_PICKAXE = registerItem("ironwood_pickaxe", PickaxeItem(TFToolMaterials.IRONWOOD, 2.0F, -2.8F,  Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "ironwood_pickaxe")))))
    val IRONWOOD_SHOVEL = registerItem("ironwood_shovel", ShovelItem(TFToolMaterials.IRONWOOD, 2.5F, -3.0F,  Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "ironwood_shovel")))))
    val IRONWOOD_AXE = registerItem("ironwood_axe", AxeItem(TFToolMaterials.IRONWOOD,7.0F, -3.1F , Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "ironwood_axe")))))
    val IRONWOOD_HOE = registerItem("ironwood_hoe", HoeItem(TFToolMaterials.IRONWOOD,-1.0F, -1.0F,  Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "ironwood_hoe")))))

    val STEELEAF_BOOTS = registerItem("steeleaf_boots", ArmorItem(TFArmorMaterials.STEELEAF, EquipmentType.BOOTS, Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "steeleaf_boots")))))
    val STEELEAF_LEGGINGS = registerItem("steeleaf_leggings", ArmorItem(TFArmorMaterials.STEELEAF, EquipmentType.LEGGINGS, Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "steeleaf_leggings")))))
    val STEELEAF_CHESTPLATE = registerItem("steeleaf_chestplate", ArmorItem(TFArmorMaterials.STEELEAF, EquipmentType.CHESTPLATE, Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "steeleaf_chestplate")))))
    val STEELEAF_HELMET = registerItem("steeleaf_helmet", ArmorItem(TFArmorMaterials.STEELEAF, EquipmentType.HELMET, Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "steeleaf_helmet")))))
    val STEELEAF_SWORD = registerItem("steeleaf_sword", SwordItem(TFToolMaterials.STEELEAF,4.0F, -2.4F, Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "steeleaf_sword")))))
    val STEELEAF_PICKAXE = registerItem("steeleaf_pickaxe", PickaxeItem(TFToolMaterials.STEELEAF,2.0F, -2.8F,  Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "steeleaf_pickaxe")))))
    val STEELEAF_SHOVEL = registerItem("steeleaf_shovel", ShovelItem(TFToolMaterials.STEELEAF,2.5F, -3.0F,  Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "steeleaf_shovel")))))
    val STEELEAF_AXE = registerItem("steeleaf_axe", AxeItem(TFToolMaterials.STEELEAF, 7.0F, -3.0F, Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "steeleaf_axe")))))
    val STEELEAF_HOE = registerItem("steeleaf_hoe", HoeItem(TFToolMaterials.STEELEAF, -2.0F, -0.5F, Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "steeleaf_hoe")))))

    val GOLD_MINOTAUR_AXE = registerItem("gold_minotaur_axe", AxeItem(ToolMaterial.GOLD, 7.0F, -2.8F, Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "gold_minotaur_axe")))))
    val DIAMOND_MINOTAUR_AXE = registerItem("diamond_minotaur_axe", AxeItem(ToolMaterial.DIAMOND,7.0F, -3.0F, Item.Settings().rarity(Rarity.RARE)
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "diamond_minotaur_axe")))))
    val MAZEBREAKER_PICKAXE = registerItem("mazebreaker_pickaxe", PickaxeItem(ToolMaterial.DIAMOND,2.0F, -2.8F,  Item.Settings().rarity(Rarity.EPIC)
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "mazebreaker_pickaxe")))))

    val KNIGHTMETAL_BOOTS = registerItem("knightmetal_boots", ArmorItem(TFArmorMaterials.KNIGHTMETAL, EquipmentType.BOOTS, Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "knightmetal_boots")))))
    val KNIGHTMETAL_LEGGINGS = registerItem("knightmetal_leggings", ArmorItem(TFArmorMaterials.KNIGHTMETAL, EquipmentType.LEGGINGS, Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "knightmetal_leggings")))))
    val KNIGHTMETAL_CHESTPLATE = registerItem("knightmetal_chestplate", ArmorItem(TFArmorMaterials.KNIGHTMETAL, EquipmentType.CHESTPLATE, Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "knightmetal_chestplate")))))
    val KNIGHTMETAL_HELMET = registerItem("knightmetal_helmet", ArmorItem(TFArmorMaterials.KNIGHTMETAL, EquipmentType.HELMET, Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "knightmetal_helmet")))))
    val KNIGHTMETAL_SWORD = registerItem("knightmetal_sword", SwordItem(TFToolMaterials.KNIGHTMETAL, 4.0F, -2.4F, Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "knightmetal_sword")))))
    val KNIGHTMETAL_PICKAXE = registerItem("knightmetal_pickaxe", PickaxeItem(TFToolMaterials.KNIGHTMETAL, 2.0F, -2.8F, Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "knightmetal_pickaxe")))))
    val KNIGHTMETAL_AXE = registerItem("knightmetal_axe", AxeItem(TFToolMaterials.KNIGHTMETAL, 7.0F, -3.0F, Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "knightmetal_axe")))))
    val PHANTOM_CHESTPLATE = registerItem("phantom_chestplate", ArmorItem(TFArmorMaterials.PHANTOM, EquipmentType.CHESTPLATE, Item.Settings().rarity(Rarity.EPIC)
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "phantom_chestplate")))))
    val PHANTOM_HELMET = registerItem("phantom_helmet", ArmorItem(TFArmorMaterials.PHANTOM, EquipmentType.HELMET, Item.Settings().rarity(Rarity.EPIC)
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "phantom_helmet")))))

    val FIERY_BOOTS = registerItem("fiery_boots", ArmorItem(TFArmorMaterials.FIERY, EquipmentType.BOOTS, Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "fiery_boots")))))
    val FIERY_LEGGINGS = registerItem("fiery_leggings", ArmorItem(TFArmorMaterials.FIERY, EquipmentType.LEGGINGS, Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "fiery_leggings")))))
    val FIERY_CHESTPLATE = registerItem("fiery_chestplate", ArmorItem(TFArmorMaterials.FIERY, EquipmentType.CHESTPLATE, Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "fiery_chestplate")))))
    val FIERY_HELMET = registerItem("fiery_helmet", ArmorItem(TFArmorMaterials.FIERY, EquipmentType.HELMET, Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "fiery_helmet")))))
    val FIERY_SWORD = registerItem("fiery_sword", SwordItem(TFToolMaterials.FIERY, 4.0F, -2.4F,  Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "fiery_sword")))))
    val FIERY_PICKAXE = registerItem("fiery_pickaxe", PickaxeItem(TFToolMaterials.FIERY, 2.0F, -2.8F, Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "fiery_pickaxe")))))

    val ARCTIC_BOOTS = registerItem("arctic_boots", ArmorItem(TFArmorMaterials.ARCTIC, EquipmentType.BOOTS, Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "arctic_boots")))))
    val ARCTIC_LEGGINGS = registerItem("arctic_leggings", ArmorItem(TFArmorMaterials.ARCTIC, EquipmentType.LEGGINGS, Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "arctic_leggings")))))
    val ARCTIC_CHESTPLATE = registerItem("arctic_chestplate", ArmorItem(TFArmorMaterials.ARCTIC, EquipmentType.CHESTPLATE, Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "arctic_chestplate")))))
    val ARCTIC_HELMET = registerItem("arctic_helmet", ArmorItem(TFArmorMaterials.ARCTIC, EquipmentType.HELMET, Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "arctic_helmet")))))

    val YETI_BOOTS = registerItem("yeti_boots", ArmorItem(TFArmorMaterials.YETI, EquipmentType.BOOTS, Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "yeti_boots")))))
    val YETI_LEGGINGS = registerItem("yeti_leggings", ArmorItem(TFArmorMaterials.YETI, EquipmentType.LEGGINGS, Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "yeti_leggings")))))
    val YETI_CHESTPLATE = registerItem("yeti_chestplate", ArmorItem(TFArmorMaterials.YETI, EquipmentType.CHESTPLATE, Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "yeti_chestplate")))))
    val YETI_HELMET = registerItem("yeti_helmet", ArmorItem(TFArmorMaterials.YETI, EquipmentType.HELMET, Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "yeti_helmet")))))

    //WOOD ITEMS
    /*val TWILIGHT_OAK_SIGN = registerItem("twilight_oak_sign", SignItem(TFBlocks.TWILIGHT_OAK_WALL_SIGN, TFBlocks.TWILIGHT_OAK_SIGN, Item.Settings().maxCount(16)
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "twilight_oak_sign")))))
    val TWILIGHT_OAK_HANGING_SIGN = registerItem("twilight_oak_hanging_sign", HangingSignItem(TFBlocks.TWILIGHT_OAK_HANGING_SIGN, TFBlocks.TWILIGHT_OAK_WALL_HANGING_SIGN, Item.Settings().maxCount(16)
        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, "twilight_oak_hanging_sign")))))*/

    private fun registerItem(name: String, item: Item): Item {
        return Registry.register(Registries.ITEM, Identifier.of(TwilightForest.MOD_ID, name), item)
    }

    fun registerItems() {
        TwilightForest.logger?.info("Registering items for" + TwilightForest.MOD_ID)

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register { entries ->
            entries.add(NAGA_SCALE)
            entries.add(LIVEROOT)
            entries.add(RAW_IRONWOOD)
            entries.add(IRONWOOD_INGOT)
            entries.add(STEELEAF_INGOT)
            entries.add(ARMOR_SHARD)
            entries.add(ARMOR_SHARD_CLUSTER)
            entries.add(KNIGHTMETAL_INGOT)
            entries.add(FIERY_BLOOD)
            entries.add(FIERY_TEARS)
            entries.add(FIERY_INGOT)
            entries.add(ARCTIC_FUR)
            entries.add(ALPHA_YETI_FUR)

            entries.add(RAVEN_FEATHER)
            entries.add(MAGIC_MAP_FOCUS)
            entries.add(MAZE_MAP_FOCUS)
            entries.add(CHARM_OF_LIFE_I)
            entries.add(CHARM_OF_LIFE_II)
            entries.add(CHARM_OF_KEEPING_I)
            entries.add(CHARM_OF_KEEPING_II)
            entries.add(CHARM_OF_KEEPING_III)
            entries.add(BORER_ESSENCE)
            entries.add(CARMINITE)
            entries.add(EMPERORS_CLOTH)
            entries.add(CROWN_SPLINTER)
        }
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register { entries ->
            entries.add(TOWER_KEY)
        }
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register { entries ->
            entries.add(RAW_VENISON)
            entries.add(COOKED_VENISON)
            entries.add(RAW_MEEF)
            entries.add(COOKED_MEEF)
            entries.add(MEEF_STROGANOFF)
            entries.add(HYDRA_CHOP)
            entries.add(TORCHBERRIES)
            entries.add(EXPERIMENT_115)
            entries.add(MAZE_WAFER)
        }
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register { entries ->
            entries.add(POCKET_WATCH)

            entries.add(NAGA_LEGGINGS)
            entries.add(NAGA_CHESTPLATE)

            entries.add(IRONWOOD_BOOTS)
            entries.add(IRONWOOD_LEGGINGS)
            entries.add(IRONWOOD_CHESTPLATE)
            entries.add(IRONWOOD_HELMET)
            entries.add(IRONWOOD_SWORD)
            entries.add(IRONWOOD_PICKAXE)
            entries.add(IRONWOOD_SHOVEL)
            entries.add(IRONWOOD_AXE)
            entries.add(IRONWOOD_HOE)

            entries.add(STEELEAF_BOOTS)
            entries.add(STEELEAF_LEGGINGS)
            entries.add(STEELEAF_CHESTPLATE)
            entries.add(STEELEAF_HELMET)
            entries.add(STEELEAF_SWORD)
            entries.add(STEELEAF_PICKAXE)
            entries.add(STEELEAF_SHOVEL)
            entries.add(STEELEAF_AXE)
            entries.add(STEELEAF_HOE)

            entries.add(GOLD_MINOTAUR_AXE)
            entries.add(DIAMOND_MINOTAUR_AXE)
            entries.add(MAZEBREAKER_PICKAXE)

            entries.add(KNIGHTMETAL_BOOTS)
            entries.add(KNIGHTMETAL_LEGGINGS)
            entries.add(KNIGHTMETAL_CHESTPLATE)
            entries.add(KNIGHTMETAL_HELMET)
            entries.add(KNIGHTMETAL_SWORD)
            entries.add(KNIGHTMETAL_PICKAXE)
            entries.add(KNIGHTMETAL_AXE)
            entries.add(PHANTOM_CHESTPLATE)
            entries.add(PHANTOM_HELMET)

            entries.add(FIERY_BOOTS)
            entries.add(FIERY_LEGGINGS)
            entries.add(FIERY_CHESTPLATE)
            entries.add(FIERY_HELMET)
            entries.add(FIERY_SWORD)
            entries.add(FIERY_PICKAXE)

            entries.add(ARCTIC_BOOTS)
            entries.add(ARCTIC_LEGGINGS)
            entries.add(ARCTIC_CHESTPLATE)
            entries.add(ARCTIC_HELMET)

            entries.add(YETI_BOOTS)
            entries.add(YETI_LEGGINGS)
            entries.add(YETI_CHESTPLATE)
            entries.add(YETI_HELMET)
        }
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register { entries ->
            //entries.add(TWILIGHT_OAK_SIGN)
            //entries.add(TWILIGHT_OAK_HANGING_SIGN)
        }
    }
}