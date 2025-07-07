package autumn.twilightforest.init.item

import autumn.twilightforest.TwilightForest
import autumn.twilightforest.util.tag.TFItemTags
import net.minecraft.item.equipment.ArmorMaterial
import net.minecraft.item.equipment.EquipmentAsset
import net.minecraft.item.equipment.EquipmentType
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.sound.SoundEvents
import net.minecraft.util.Identifier
import java.util.EnumMap

object TFArmorMaterials {

    val REGISTRY_KEY: RegistryKey<out Registry<EquipmentAsset>> = RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset"))

    val NAGA_KEY: RegistryKey<EquipmentAsset> =
        RegistryKey.of(REGISTRY_KEY, Identifier.of(TwilightForest.MOD_ID, "naga"))
    val IRONWOOD_KEY: RegistryKey<EquipmentAsset> =
        RegistryKey.of(REGISTRY_KEY, Identifier.of(TwilightForest.MOD_ID, "ironwood"))
    val STEELEAF_KEY: RegistryKey<EquipmentAsset> =
        RegistryKey.of(REGISTRY_KEY, Identifier.of(TwilightForest.MOD_ID, "steeleaf"))
    val KNIGHTMETAL_KEY: RegistryKey<EquipmentAsset> =
        RegistryKey.of(REGISTRY_KEY, Identifier.of(TwilightForest.MOD_ID, "knightmetal"))
    val PHANTOM_KEY: RegistryKey<EquipmentAsset> =
        RegistryKey.of(REGISTRY_KEY, Identifier.of(TwilightForest.MOD_ID, "phantom"))
    val FIERY_KEY: RegistryKey<EquipmentAsset> =
        RegistryKey.of(REGISTRY_KEY, Identifier.of(TwilightForest.MOD_ID, "fiery"))
    val ARCTIC_KEY: RegistryKey<EquipmentAsset> =
        RegistryKey.of(REGISTRY_KEY, Identifier.of(TwilightForest.MOD_ID, "arctic"))
    val YETI_KEY: RegistryKey<EquipmentAsset> =
        RegistryKey.of(REGISTRY_KEY, Identifier.of(TwilightForest.MOD_ID, "yeti"))

    val NAGA_ARMOR_MATERIAL: ArmorMaterial = ArmorMaterial(
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
        NAGA_KEY
    )
    val IRONWOOD_ARMOR_MATERIAL: ArmorMaterial = ArmorMaterial(
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
        IRONWOOD_KEY
    )
    val STEELEAF_ARMOR_MATERIAL: ArmorMaterial = ArmorMaterial(
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
        STEELEAF_KEY
    )
    val KNIGHTMETAL_ARMOR_MATERIAL: ArmorMaterial = ArmorMaterial(
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
        KNIGHTMETAL_KEY
    )
    val PHANTOM_ARMOR_MATERIAL: ArmorMaterial = ArmorMaterial(
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
        PHANTOM_KEY
    )
    val FIERY_ARMOR_MATERIAL: ArmorMaterial = ArmorMaterial(
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
        FIERY_KEY
    )
    val ARCTIC_ARMOR_MATERIAL: ArmorMaterial = ArmorMaterial(
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
        ARCTIC_KEY
    )
    val YETI_ARMOR_MATERIAL: ArmorMaterial = ArmorMaterial(
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
        YETI_KEY
    )
}