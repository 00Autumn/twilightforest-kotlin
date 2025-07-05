package autumn.twilightforest.util

import autumn.twilightforest.TwilightForest
import net.minecraft.block.WoodType
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.sound.SoundEvents

object TFWoodTypes {
    val TWILIGHT_OAK_WOOD_TYPE: WoodType = WoodType(
        TwilightForest.id("twilight_oak").toString(),
        TFBlockSetTypes.TWILIGHT_OAK_BLOCK_SET_TYPE,
        BlockSoundGroup.WOOD,
        BlockSoundGroup.HANGING_SIGN,
        SoundEvents.BLOCK_FENCE_GATE_CLOSE,
        SoundEvents.BLOCK_FENCE_GATE_OPEN
    )

    val CANOPY_WOOD_TYPE: WoodType = WoodType(
        TwilightForest.id("canopy").toString(),
        TFBlockSetTypes.CANOPY_BLOCK_SET_TYPE,
        BlockSoundGroup.WOOD,
        BlockSoundGroup.HANGING_SIGN,
        SoundEvents.BLOCK_FENCE_GATE_CLOSE,
        SoundEvents.BLOCK_FENCE_GATE_OPEN
    )

    val TWILIGHT_MANGROVE_WOOD_TYPE: WoodType = WoodType(
        TwilightForest.id("twilight_mangrove").toString(),
        TFBlockSetTypes.TWILIGHT_MANGROVE_BLOCK_SET_TYPE,
        BlockSoundGroup.WOOD,
        BlockSoundGroup.HANGING_SIGN,
        SoundEvents.BLOCK_FENCE_GATE_CLOSE,
        SoundEvents.BLOCK_FENCE_GATE_OPEN
    )

    val DARK_WOOD_TYPE: WoodType = WoodType(
        TwilightForest.id("dark").toString(),
        TFBlockSetTypes.DARK_BLOCK_SET_TYPE,
        BlockSoundGroup.WOOD,
        BlockSoundGroup.HANGING_SIGN,
        SoundEvents.BLOCK_FENCE_GATE_CLOSE,
        SoundEvents.BLOCK_FENCE_GATE_OPEN
    )

    val TIME_WOOD_TYPE: WoodType = WoodType(
        TwilightForest.id("time").toString(),
        TFBlockSetTypes.TIME_BLOCK_SET_TYPE,
        BlockSoundGroup.WOOD,
        BlockSoundGroup.HANGING_SIGN,
        SoundEvents.BLOCK_FENCE_GATE_CLOSE,
        SoundEvents.BLOCK_FENCE_GATE_OPEN
    )

    val TRANSFORMATION_WOOD_TYPE: WoodType = WoodType(
        TwilightForest.id("transformation").toString(),
        TFBlockSetTypes.TRANSFORMATION_BLOCK_SET_TYPE,
        BlockSoundGroup.WOOD,
        BlockSoundGroup.HANGING_SIGN,
        SoundEvents.BLOCK_FENCE_GATE_CLOSE,
        SoundEvents.BLOCK_FENCE_GATE_OPEN
    )

    val MINING_WOOD_TYPE: WoodType = WoodType(
        TwilightForest.id("mining").toString(),
        TFBlockSetTypes.MINING_BLOCK_SET_TYPE,
        BlockSoundGroup.WOOD,
        BlockSoundGroup.HANGING_SIGN,
        SoundEvents.BLOCK_FENCE_GATE_CLOSE,
        SoundEvents.BLOCK_FENCE_GATE_OPEN
    )

    val SORTING_WOOD_TYPE: WoodType = WoodType(
        TwilightForest.id("sorting").toString(),
        TFBlockSetTypes.SORTING_BLOCK_SET_TYPE,
        BlockSoundGroup.WOOD,
        BlockSoundGroup.HANGING_SIGN,
        SoundEvents.BLOCK_FENCE_GATE_CLOSE,
        SoundEvents.BLOCK_FENCE_GATE_OPEN
    )

    fun registerWoodTypes() {
        TwilightForest.logger?.info("Registering wood types for " + TwilightForest.MOD_ID)
    }
}