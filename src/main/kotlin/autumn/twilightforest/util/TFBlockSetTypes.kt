package autumn.twilightforest.util

import autumn.twilightforest.TwilightForest
import net.minecraft.block.BlockSetType

object TFBlockSetTypes {
    val TWILIGHT_OAK_BLOCK_SET_TYPE: BlockSetType = BlockSetType(TwilightForest.id("twilight_oak").toString())

    fun registerBlockSetTypes() {
        TwilightForest.logger.info("Registering block set types for " + TwilightForest.MOD_ID)
    }
}