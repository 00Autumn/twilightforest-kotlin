package autumn.twilightforest.init.item

import autumn.twilightforest.TwilightForest
import net.minecraft.item.ArmorItem
import net.minecraft.item.ArmorMaterial
import net.minecraft.recipe.Ingredient
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.entry.RegistryEntry
import net.minecraft.sound.SoundEvents
import net.minecraft.util.Identifier
import java.util.EnumMap
import java.util.function.Supplier

object TFArmorMaterials {

    val IRONWOOD_ARMOR_MATERIAL: RegistryEntry<ArmorMaterial> = registerArmorMaterial("ironwood") {
        ArmorMaterial(EnumMap<ArmorItem.Type, Int>(ArmorItem.Type::class.java).apply {
            put(ArmorItem.Type.BOOTS, 2)
            put(ArmorItem.Type.LEGGINGS, 4)
            put(ArmorItem.Type.CHESTPLATE, 6)
            put(ArmorItem.Type.HELMET, 2)
            put(ArmorItem.Type.BODY, 4)
        },
            15,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            { Ingredient.ofItems(TFItems.IRONWOOD_INGOT) },
            listOf(ArmorMaterial.Layer(Identifier.of(TwilightForest.MOD_ID, "ironwood"))),
            0.0F,
            0.0F
        )
    }
    val FIERY_ARMOR_MATERIAL: RegistryEntry<ArmorMaterial> = registerArmorMaterial("fiery") {
        ArmorMaterial(EnumMap<ArmorItem.Type, Int>(ArmorItem.Type::class.java).apply {
            put(ArmorItem.Type.BOOTS, 2)
            put(ArmorItem.Type.LEGGINGS, 4)
            put(ArmorItem.Type.CHESTPLATE, 6)
            put(ArmorItem.Type.HELMET, 2)
            put(ArmorItem.Type.BODY, 4)
        },
            10,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            { Ingredient.ofItems(TFItems.FIERY_INGOT) },
            listOf(ArmorMaterial.Layer(Identifier.of(TwilightForest.MOD_ID, "fiery"))),
            1.5F,
            0.0F
        )
    }
    val STEELEAF_ARMOR_MATERIAL: RegistryEntry<ArmorMaterial> = registerArmorMaterial("steeleaf") {
        ArmorMaterial(EnumMap<ArmorItem.Type, Int>(ArmorItem.Type::class.java).apply {
            put(ArmorItem.Type.BOOTS, 2)
            put(ArmorItem.Type.LEGGINGS, 4)
            put(ArmorItem.Type.CHESTPLATE, 6)
            put(ArmorItem.Type.HELMET, 2)
            put(ArmorItem.Type.BODY, 4)
        },
            9,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            { Ingredient.ofItems(TFItems.STEELEAF_INGOT) },
            listOf(ArmorMaterial.Layer(Identifier.of(TwilightForest.MOD_ID, "steeleaf"))),
            0.0F,
            0.0F
        )
    }
    val KNIGHTMETAL_ARMOR_MATERIAL: RegistryEntry<ArmorMaterial> = registerArmorMaterial("knightmetal") {
        ArmorMaterial(EnumMap<ArmorItem.Type, Int>(ArmorItem.Type::class.java).apply {
            put(ArmorItem.Type.BOOTS, 2)
            put(ArmorItem.Type.LEGGINGS, 4)
            put(ArmorItem.Type.CHESTPLATE, 6)
            put(ArmorItem.Type.HELMET, 2)
            put(ArmorItem.Type.BODY, 4)
        },
            8,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            { Ingredient.ofItems(TFItems.KNIGHTMETAL_INGOT) },
            listOf(ArmorMaterial.Layer(Identifier.of(TwilightForest.MOD_ID, "knightmetal"))),
            1.0F,
            0.0F
        )
    }
    val ARCTIC_ARMOR_MATERIAL: RegistryEntry<ArmorMaterial> = registerArmorMaterial("arctic") {
        ArmorMaterial(EnumMap<ArmorItem.Type, Int>(ArmorItem.Type::class.java).apply {
            put(ArmorItem.Type.BOOTS, 2)
            put(ArmorItem.Type.LEGGINGS, 4)
            put(ArmorItem.Type.CHESTPLATE, 6)
            put(ArmorItem.Type.HELMET, 2)
            put(ArmorItem.Type.BODY, 4)
        },
            8,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            { Ingredient.ofItems(TFItems.ARCTIC_FUR) },
            listOf(
                ArmorMaterial.Layer(Identifier.of(TwilightForest.MOD_ID, "arctic"), "", true),
                ArmorMaterial.Layer(Identifier.of(TwilightForest.MOD_ID, "arctic"), "_overlay", false)
            ),
            2.0F,
            0.0F
        )
    }
    val YETI_ARMOR_MATERIAL: RegistryEntry<ArmorMaterial> = registerArmorMaterial("yeti") {
        ArmorMaterial(EnumMap<ArmorItem.Type, Int>(ArmorItem.Type::class.java).apply {
            put(ArmorItem.Type.BOOTS, 2)
            put(ArmorItem.Type.LEGGINGS, 4)
            put(ArmorItem.Type.CHESTPLATE, 6)
            put(ArmorItem.Type.HELMET, 2)
            put(ArmorItem.Type.BODY, 4)
        },
            15,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            { Ingredient.ofItems(TFItems.ALPHA_YETI_FUR) },
            listOf(ArmorMaterial.Layer(Identifier.of(TwilightForest.MOD_ID, "yeti"))),
            3.0F,
            0.0F
        )
    }
    val PHANTOM_ARMOR_MATERIAL: RegistryEntry<ArmorMaterial> = registerArmorMaterial("phantom") {
        ArmorMaterial(EnumMap<ArmorItem.Type, Int>(ArmorItem.Type::class.java).apply {
            put(ArmorItem.Type.BOOTS, 2)
            put(ArmorItem.Type.LEGGINGS, 4)
            put(ArmorItem.Type.CHESTPLATE, 6)
            put(ArmorItem.Type.HELMET, 2)
            put(ArmorItem.Type.BODY, 4)
        },
            8,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            { Ingredient.ofItems(TFItems.KNIGHTMETAL_INGOT) },
            listOf(ArmorMaterial.Layer(Identifier.of(TwilightForest.MOD_ID, "phantom"))),
            2.5F,
            0.0F
        )
    }

    val NAGA_ARMOR_MATERIAL: RegistryEntry<ArmorMaterial> = registerArmorMaterial("naga") {
        ArmorMaterial(EnumMap<ArmorItem.Type, Int>(ArmorItem.Type::class.java).apply {
            put(ArmorItem.Type.BOOTS, 2)
            put(ArmorItem.Type.LEGGINGS, 4)
            put(ArmorItem.Type.CHESTPLATE, 6)
            put(ArmorItem.Type.HELMET, 2)
            put(ArmorItem.Type.BODY, 4)
        },
            15,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            { Ingredient.ofItems(TFItems.NAGA_SCALE) },
            listOf(ArmorMaterial.Layer(Identifier.of(TwilightForest.MOD_ID, "naga"))),
            0.5F,
            0.0F
        )
    }

    fun registerArmorMaterial(name: String, material: Supplier<ArmorMaterial>): RegistryEntry<ArmorMaterial> {
        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(TwilightForest.MOD_ID, name), material.get())
    }
}