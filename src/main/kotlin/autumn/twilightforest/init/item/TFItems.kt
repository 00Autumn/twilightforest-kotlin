package autumn.twilightforest.init.item

import autumn.twilightforest.TwilightForest
import autumn.twilightforest.init.block.TFBlocks
import autumn.twilightforest.init.item.custom.PocketWatchItem
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.item.ArmorItem
import net.minecraft.item.AxeItem
import net.minecraft.item.HangingSignItem
import net.minecraft.item.HoeItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.item.ItemStack
import net.minecraft.item.PickaxeItem
import net.minecraft.item.ShovelItem
import net.minecraft.item.SignItem
import net.minecraft.item.SwordItem
import net.minecraft.item.ToolMaterials
import net.minecraft.item.tooltip.TooltipType
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import net.minecraft.util.Rarity

object TFItems {

    //EQUIPMENT INGREDIENTS
    val NAGA_SCALE = registerItem("naga_scale", Item(Item.Settings().rarity(Rarity.UNCOMMON)))
    val LIVEROOT = registerItem("liveroot", Item(Item.Settings()))
    val RAW_IRONWOOD = registerItem("raw_ironwood", Item(Item.Settings()))
    val IRONWOOD_INGOT = registerItem("ironwood_ingot", Item(Item.Settings()))
    val STEELEAF_INGOT = registerItem("steeleaf_ingot", Item(Item.Settings()))
    val ARMOR_SHARD = registerItem("armor_shard", Item(Item.Settings()))
    val ARMOR_SHARD_CLUSTER = registerItem("armor_shard_cluster", Item(Item.Settings()))
    val KNIGHTMETAL_INGOT = registerItem("knightmetal_ingot", Item(Item.Settings()))
    val FIERY_BLOOD = registerItem("fiery_blood", Item(Item.Settings().rarity(Rarity.UNCOMMON)))
    val FIERY_TEARS = registerItem("fiery_tears", Item(Item.Settings().rarity(Rarity.UNCOMMON)))
    val FIERY_INGOT = registerItem("fiery_ingot", Item(Item.Settings().rarity(Rarity.UNCOMMON)))
    val ARCTIC_FUR = registerItem("arctic_fur", Item(Item.Settings()))
    val ALPHA_YETI_FUR = registerItem("alpha_yeti_fur", Item(Item.Settings().rarity(Rarity.UNCOMMON)))

    //MISC INGREDIENTS
    val RAVEN_FEATHER = registerItem("raven_feather", Item(Item.Settings()))
    val MAGIC_MAP_FOCUS = registerItem("magic_map_focus", Item(Item.Settings()))
    val MAZE_MAP_FOCUS = registerItem("maze_map_focus", Item(Item.Settings()))
    val CHARM_OF_LIFE_I = registerItem("charm_of_life_i", Item(Item.Settings().rarity(Rarity.UNCOMMON)))
    val CHARM_OF_LIFE_II = registerItem("charm_of_life_ii", Item(Item.Settings().rarity(Rarity.UNCOMMON)))
    val CHARM_OF_KEEPING_I = registerItem("charm_of_keeping_i", Item(Item.Settings().rarity(Rarity.UNCOMMON)))
    val CHARM_OF_KEEPING_II = registerItem("charm_of_keeping_ii", Item(Item.Settings().rarity(Rarity.UNCOMMON)))
    val CHARM_OF_KEEPING_III = registerItem("charm_of_keeping_iii", Item(Item.Settings().rarity(Rarity.UNCOMMON)))
    val BORER_ESSENCE = registerItem("borer_essence", Item(Item.Settings()))
    val CARMINITE = registerItem("carminite", Item(Item.Settings()))
    val EMPERORS_CLOTH = registerItem("emperors_cloth", Item(Item.Settings().rarity(Rarity.UNCOMMON)))
    val CROWN_SPLINTER = registerItem("crown_splinter", Item(Item.Settings().rarity(Rarity.UNCOMMON)))

    //MISC ITEMS
    val TOWER_KEY = registerItem("tower_key", Item(Item.Settings().fireproof().rarity(Rarity.UNCOMMON)))

    //FOOD ITEMS
    val RAW_VENISON = registerItem("raw_venison", Item(Item.Settings().food(TFFoodComponents.RAW_VENISON)))
    val COOKED_VENISON = registerItem("cooked_venison", Item(Item.Settings().food(TFFoodComponents.COOKED_VENISON)))
    val RAW_MEEF = registerItem("raw_meef", Item(Item.Settings().food(TFFoodComponents.RAW_MEEF)))
    val COOKED_MEEF = registerItem("cooked_meef", Item(Item.Settings().food(TFFoodComponents.COOKED_MEEF)))
    val MEEF_STROGANOFF = registerItem("meef_stroganoff", Item(Item.Settings().maxCount(1).food(TFFoodComponents.MEEF_STROGANOFF).rarity(Rarity.UNCOMMON)))
    val HYDRA_CHOP = registerItem("hydra_chop", Item(Item.Settings().food(TFFoodComponents.HYDRA_CHOP).fireproof().rarity(Rarity.UNCOMMON)))
    val TORCHBERRIES = registerItem("torchberries", Item(Item.Settings().food(TFFoodComponents.TORCHBERRIES)))
    val EXPERIMENT_115 = registerItem("experiment_115", object : Item(Item.Settings().food(TFFoodComponents.EXPERIMENT_115)) {
        override fun appendTooltip(stack: ItemStack, context: TooltipContext, tooltip: MutableList<Text>, type: TooltipType) {
            tooltip.add(Text.translatable("tooltip.twilightforest.experiment_115.tooltip").withColor(16717824))
            super.appendTooltip(stack, context, tooltip, type)
        }
    })
    val MAZE_WAFER = registerItem("maze_wafer", Item(Item.Settings().food(TFFoodComponents.MAZE_WAFER)))

    //EQUIPMENT & TRINKETS
    val POCKET_WATCH = registerItem("pocket_watch", PocketWatchItem(Item.Settings().maxCount(1).rarity(Rarity.RARE)))

    val NAGA_LEGGINGS = registerItem("naga_leggings", ArmorItem(TFArmorMaterials.NAGA_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))))
    val NAGA_CHESTPLATE = registerItem("naga_chestplate", ArmorItem(TFArmorMaterials.NAGA_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))))

    val IRONWOOD_BOOTS = registerItem("ironwood_boots", ArmorItem(TFArmorMaterials.IRONWOOD_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))))
    val IRONWOOD_LEGGINGS = registerItem("ironwood_leggings", ArmorItem(TFArmorMaterials.IRONWOOD_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))))
    val IRONWOOD_CHESTPLATE = registerItem("ironwood_chestplate", ArmorItem(TFArmorMaterials.IRONWOOD_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))))
    val IRONWOOD_HELMET = registerItem("ironwood_helmet", ArmorItem(TFArmorMaterials.IRONWOOD_ARMOR_MATERIAL, ArmorItem.Type.HELMET, Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))))
    val IRONWOOD_SWORD = registerItem("ironwood_sword", SwordItem(TFToolMaterials.IRONWOOD, Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(TFToolMaterials.IRONWOOD, 4, -2.4f))))
    val IRONWOOD_PICKAXE = registerItem("ironwood_pickaxe", PickaxeItem(TFToolMaterials.IRONWOOD, Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(TFToolMaterials.IRONWOOD, 2.0F, -2.8F))))
    val IRONWOOD_SHOVEL = registerItem("ironwood_shovel", ShovelItem(TFToolMaterials.IRONWOOD, Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(TFToolMaterials.IRONWOOD, 2.5F, -3.0F))))
    val IRONWOOD_AXE = registerItem("ironwood_axe", AxeItem(TFToolMaterials.IRONWOOD, Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(TFToolMaterials.IRONWOOD, 7.0F, -3.1F))))
    val IRONWOOD_HOE = registerItem("ironwood_hoe", HoeItem(TFToolMaterials.IRONWOOD, Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(TFToolMaterials.IRONWOOD, -1.0F, -1.0F))))

    val STEELEAF_BOOTS = registerItem("steeleaf_boots", ArmorItem(TFArmorMaterials.STEELEAF_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))))
    val STEELEAF_LEGGINGS = registerItem("steeleaf_leggings", ArmorItem(TFArmorMaterials.STEELEAF_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))))
    val STEELEAF_CHESTPLATE = registerItem("steeleaf_chestplate", ArmorItem(TFArmorMaterials.STEELEAF_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))))
    val STEELEAF_HELMET = registerItem("steeleaf_helmet", ArmorItem(TFArmorMaterials.STEELEAF_ARMOR_MATERIAL, ArmorItem.Type.HELMET, Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))))
    val STEELEAF_SWORD = registerItem("steeleaf_sword", SwordItem(TFToolMaterials.STEELEAF, Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(TFToolMaterials.STEELEAF, 4, -2.4F))))
    val STEELEAF_PICKAXE = registerItem("steeleaf_pickaxe", PickaxeItem(TFToolMaterials.STEELEAF, Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(TFToolMaterials.STEELEAF, 2.0F, -2.8f))))
    val STEELEAF_SHOVEL = registerItem("steeleaf_shovel", ShovelItem(TFToolMaterials.STEELEAF, Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(TFToolMaterials.STEELEAF, 2.5f, -3.0f))))
    val STEELEAF_AXE = registerItem("steeleaf_axe", AxeItem(TFToolMaterials.STEELEAF, Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(TFToolMaterials.STEELEAF, 7.0F, -3.0F))))
    val STEELEAF_HOE = registerItem("steeleaf_hoe", HoeItem(TFToolMaterials.STEELEAF, Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(TFToolMaterials.STEELEAF, -2.0F, -0.5F))))

    val GOLD_MINOTAUR_AXE = registerItem("gold_minotaur_axe", AxeItem(ToolMaterials.GOLD, Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ToolMaterials.GOLD, 7.0F, -2.8f))))
    val DIAMOND_MINOTAUR_AXE = registerItem("diamond_minotaur_axe", AxeItem(ToolMaterials.DIAMOND, Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ToolMaterials.DIAMOND, 7.0F, -3.0f)).rarity(Rarity.RARE)))
    val MAZEBREAKER_PICKAXE = registerItem("mazebreaker_pickaxe", PickaxeItem(ToolMaterials.DIAMOND, Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.DIAMOND, 2.0F, -2.8f)).rarity(Rarity.EPIC)))

    val KNIGHTMETAL_BOOTS = registerItem("knightmetal_boots", ArmorItem(TFArmorMaterials.KNIGHTMETAL_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))))
    val KNIGHTMETAL_LEGGINGS = registerItem("knightmetal_leggings", ArmorItem(TFArmorMaterials.KNIGHTMETAL_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))))
    val KNIGHTMETAL_CHESTPLATE = registerItem("knightmetal_chestplate", ArmorItem(TFArmorMaterials.KNIGHTMETAL_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))))
    val KNIGHTMETAL_HELMET = registerItem("knightmetal_helmet", ArmorItem(TFArmorMaterials.KNIGHTMETAL_ARMOR_MATERIAL, ArmorItem.Type.HELMET, Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))))
    val KNIGHTMETAL_SWORD = registerItem("knightmetal_sword", SwordItem(TFToolMaterials.KNIGHTMETAL, Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(TFToolMaterials.KNIGHTMETAL, 4, -2.4F))))
    val KNIGHTMETAL_PICKAXE = registerItem("knightmetal_pickaxe", PickaxeItem(TFToolMaterials.KNIGHTMETAL, Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(TFToolMaterials.KNIGHTMETAL, 2.0F, -2.8F))))
    val KNIGHTMETAL_AXE = registerItem("knightmetal_axe", AxeItem(TFToolMaterials.KNIGHTMETAL, Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(TFToolMaterials.KNIGHTMETAL, 7.0F, -3.0F))))
    val PHANTOM_CHESTPLATE = registerItem("phantom_chestplate", ArmorItem(TFArmorMaterials.PHANTOM_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15)).rarity(Rarity.EPIC)))
    val PHANTOM_HELMET = registerItem("phantom_helmet", ArmorItem(TFArmorMaterials.PHANTOM_ARMOR_MATERIAL, ArmorItem.Type.HELMET, Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15)).rarity(Rarity.EPIC)))

    val FIERY_BOOTS = registerItem("fiery_boots", ArmorItem(TFArmorMaterials.FIERY_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))))
    val FIERY_LEGGINGS = registerItem("fiery_leggings", ArmorItem(TFArmorMaterials.FIERY_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))))
    val FIERY_CHESTPLATE = registerItem("fiery_chestplate", ArmorItem(TFArmorMaterials.FIERY_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))))
    val FIERY_HELMET = registerItem("fiery_helmet", ArmorItem(TFArmorMaterials.FIERY_ARMOR_MATERIAL, ArmorItem.Type.HELMET, Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))))
    val FIERY_SWORD = registerItem("fiery_sword", SwordItem(TFToolMaterials.FIERY, Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(TFToolMaterials.FIERY, 4, -2.4F))))
    val FIERY_PICKAXE = registerItem("fiery_pickaxe", PickaxeItem(TFToolMaterials.FIERY, Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(TFToolMaterials.FIERY, 2.0F, -2.8F))))

    val ARCTIC_BOOTS = registerItem("arctic_boots", ArmorItem(TFArmorMaterials.ARCTIC_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))))
    val ARCTIC_LEGGINGS = registerItem("arctic_leggings", ArmorItem(TFArmorMaterials.ARCTIC_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))))
    val ARCTIC_CHESTPLATE = registerItem("arctic_chestplate", ArmorItem(TFArmorMaterials.ARCTIC_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))))
    val ARCTIC_HELMET = registerItem("arctic_helmet", ArmorItem(TFArmorMaterials.ARCTIC_ARMOR_MATERIAL, ArmorItem.Type.HELMET, Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))))

    val YETI_BOOTS = registerItem("yeti_boots", ArmorItem(TFArmorMaterials.YETI_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))))
    val YETI_LEGGINGS = registerItem("yeti_leggings", ArmorItem(TFArmorMaterials.YETI_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))))
    val YETI_CHESTPLATE = registerItem("yeti_chestplate", ArmorItem(TFArmorMaterials.YETI_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))))
    val YETI_HELMET = registerItem("yeti_helmet", ArmorItem(TFArmorMaterials.YETI_ARMOR_MATERIAL, ArmorItem.Type.HELMET, Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))))

    //WOOD ITEMS
    val TWILIGHT_OAK_SIGN = registerItem("twilight_oak_sign", SignItem(Item.Settings().maxCount(16), TFBlocks.TWILIGHT_OAK_SIGN, TFBlocks.TWILIGHT_OAK_WALL_SIGN))
    val TWILIGHT_OAK_HANGING_SIGN = registerItem("twilight_oak_hanging_sign", HangingSignItem(TFBlocks.TWILIGHT_OAK_HANGING_SIGN, TFBlocks.TWILIGHT_OAK_WALL_HANGING_SIGN, Item.Settings().maxCount(16)))

    private fun registerItem(name: String, item: Item): Item {
        return Registry.register(Registries.ITEM, Identifier.of(TwilightForest.MOD_ID, name), item)
    }

    fun registerItems() {
        TwilightForest.logger.info("Registering items for" + TwilightForest.MOD_ID)

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
            entries.add(TWILIGHT_OAK_SIGN)
            entries.add(TWILIGHT_OAK_HANGING_SIGN)
        }
    }
}