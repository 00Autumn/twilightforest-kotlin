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


    fun registerWoodTypes() {
        TwilightForest.logger.info("Registering wood types for " + TwilightForest.MOD_ID)
    }
}