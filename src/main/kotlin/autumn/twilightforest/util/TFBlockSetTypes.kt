package autumn.twilightforest.util

import autumn.twilightforest.TwilightForest
import net.minecraft.block.BlockSetType

object TFBlockSetTypes {
    val TWILIGHT_OAK_BLOCK_SET_TYPE: BlockSetType = BlockSetType(TwilightForest.id("twilight_oak").toString())

    val CANOPY_BLOCK_SET_TYPE: BlockSetType = BlockSetType(TwilightForest.id("canopy").toString())

    val TWILIGHT_MANGROVE_BLOCK_SET_TYPE: BlockSetType = BlockSetType(TwilightForest.id("twilight_mangrove").toString())

    val DARK_BLOCK_SET_TYPE: BlockSetType = BlockSetType(TwilightForest.id("dark").toString())

    val TIME_BLOCK_SET_TYPE: BlockSetType = BlockSetType(TwilightForest.id("time").toString())

    val TRANSFORMATION_BLOCK_SET_TYPE: BlockSetType = BlockSetType(TwilightForest.id("transformation").toString())

    val MINING_BLOCK_SET_TYPE: BlockSetType = BlockSetType(TwilightForest.id("mining").toString())

    val SORTING_BLOCK_SET_TYPE: BlockSetType = BlockSetType(TwilightForest.id("sorting").toString())

    fun registerBlockSetTypes() {
        TwilightForest.logger?.info("Registering block set types for " + TwilightForest.MOD_ID)
    }
}