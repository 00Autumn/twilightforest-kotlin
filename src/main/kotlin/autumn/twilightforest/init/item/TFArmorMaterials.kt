package autumn.twilightforest.init.item

import autumn.twilightforest.TwilightForest
import autumn.twilightforest.util.TFItemTags
import net.minecraft.item.equipment.ArmorMaterial
import net.minecraft.item.equipment.EquipmentType
import net.minecraft.sound.SoundEvents
import net.minecraft.util.Identifier
import java.util.EnumMap

object TFArmorMaterials {

    val NAGA_SCALE: ArmorMaterial = ArmorMaterial(
        13,
        EnumMap<EquipmentType, Int>(EquipmentType::class.java).apply {
            put(EquipmentType.BOOTS, 2)
            put(EquipmentType.LEGGINGS, 4)
            put(EquipmentType.CHESTPLATE, 6)
            put(EquipmentType.HELMET, 2)
            put(EquipmentType.BODY, 4)
        },
        15,
        SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
        0.5f,
        0.0f,
        TFItemTags.REPAIRS_NAGA_SCALE_ARMOR,
        Identifier.of(TwilightForest.MOD_ID, "naga_scale")
    )
    val IRONWOOD: ArmorMaterial = ArmorMaterial(
        15,
        EnumMap<EquipmentType, Int>(EquipmentType::class.java).apply {
            put(EquipmentType.BOOTS, 2)
            put(EquipmentType.LEGGINGS, 4)
            put(EquipmentType.CHESTPLATE, 6)
            put(EquipmentType.HELMET, 2)
            put(EquipmentType.BODY, 4)
        },
        15,
        SoundEvents.ITEM_ARMOR_EQUIP_IRON,
        0.0f,
        0.0f,
        TFItemTags.REPAIRS_IRONWOOD_ARMOR,
        Identifier.of(TwilightForest.MOD_ID, "ironwood")
    )
    val STEELEAF: ArmorMaterial = ArmorMaterial(
        11,
        EnumMap<EquipmentType, Int>(EquipmentType::class.java).apply {
            put(EquipmentType.BOOTS, 2)
            put(EquipmentType.LEGGINGS, 4)
            put(EquipmentType.CHESTPLATE, 6)
            put(EquipmentType.HELMET, 2)
            put(EquipmentType.BODY, 4)
        },
        9,
        SoundEvents.ITEM_ARMOR_EQUIP_IRON,
        0.0f,
        0.0f,
        TFItemTags.REPAIRS_STEELEAF_ARMOR,
        Identifier.of(TwilightForest.MOD_ID, "steeleaf")
    )
    val KNIGHTMETAL: ArmorMaterial = ArmorMaterial(
        33,
        EnumMap<EquipmentType, Int>(EquipmentType::class.java).apply {
            put(EquipmentType.BOOTS, 2)
            put(EquipmentType.LEGGINGS, 4)
            put(EquipmentType.CHESTPLATE, 6)
            put(EquipmentType.HELMET, 2)
            put(EquipmentType.BODY, 4)
        },
        8,
        SoundEvents.ITEM_ARMOR_EQUIP_IRON,
        1.0f,
        0.0f,
        TFItemTags.REPAIRS_KNIGHTMETAL_ARMOR,
        Identifier.of(TwilightForest.MOD_ID, "knightmetal")
    )
    val PHANTOM: ArmorMaterial = ArmorMaterial(
        37,
        EnumMap<EquipmentType, Int>(EquipmentType::class.java).apply {
            put(EquipmentType.BOOTS, 2)
            put(EquipmentType.LEGGINGS, 4)
            put(EquipmentType.CHESTPLATE, 6)
            put(EquipmentType.HELMET, 2)
            put(EquipmentType.BODY, 4)
        },
        8,
        SoundEvents.ITEM_ARMOR_EQUIP_IRON,
        2.5f,
        0.0f,
        TFItemTags.REPAIRS_KNIGHTMETAL_ARMOR,
        Identifier.of(TwilightForest.MOD_ID, "phantom")
    )
    val FIERY: ArmorMaterial = ArmorMaterial(
        37,
        EnumMap<EquipmentType, Int>(EquipmentType::class.java).apply {
            put(EquipmentType.BOOTS, 2)
            put(EquipmentType.LEGGINGS, 4)
            put(EquipmentType.CHESTPLATE, 6)
            put(EquipmentType.HELMET, 2)
            put(EquipmentType.BODY, 4)
        },
        10,
        SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
        1.5f,
        0.0f,
        TFItemTags.REPAIRS_FIERY_ARMOR,
        Identifier.of(TwilightForest.MOD_ID, "fiery")
    )
    val ARCTIC: ArmorMaterial = ArmorMaterial(
        11,
        EnumMap<EquipmentType, Int>(EquipmentType::class.java).apply {
            put(EquipmentType.BOOTS, 2)
            put(EquipmentType.LEGGINGS, 4)
            put(EquipmentType.CHESTPLATE, 6)
            put(EquipmentType.HELMET, 2)
            put(EquipmentType.BODY, 4)
        },
        8,
        SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
        2.0f,
        0.0f,
        TFItemTags.REPAIRS_ARCTIC_ARMOR,
        Identifier.of(TwilightForest.MOD_ID, "arctic")
    )
    val YETI: ArmorMaterial = ArmorMaterial(
        11,
        EnumMap<EquipmentType, Int>(EquipmentType::class.java).apply {
            put(EquipmentType.BOOTS, 2)
            put(EquipmentType.LEGGINGS, 4)
            put(EquipmentType.CHESTPLATE, 6)
            put(EquipmentType.HELMET, 2)
            put(EquipmentType.BODY, 4)
        },
        15,
        SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
        3.0f,
        0.0f,
        TFItemTags.REPAIRS_YETI_ARMOR,
        Identifier.of(TwilightForest.MOD_ID, "yeti")
    )
}