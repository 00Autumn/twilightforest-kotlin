package autumn.twilightforest

import autumn.twilightforest.boat.api.client.TFBoatClientHelper
import autumn.twilightforest.client.TFColorHandlers
import autumn.twilightforest.init.block.TFBlocks
import autumn.twilightforest.util.TFWoodTypes
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap
import net.minecraft.client.render.BlockRenderLayer
import net.minecraft.util.Identifier

object TwilightForestClient : ClientModInitializer {

    override fun onInitializeClient() {
        TFWoodTypes.registerWoodTypes()
        TFColorHandlers.registerBlockColors()

        // Register block render layers
        val cutoutBlocks = listOf(
            TFBlocks.KNIGHTMETAL_BLOCK, TFBlocks.ANTIBUILT_BLOCK,
            TFBlocks.TWILIGHT_OAK_DOOR, TFBlocks.TWILIGHT_OAK_TRAPDOOR, TFBlocks.TWILIGHT_OAK_LEAVES, TFBlocks.TWILIGHT_OAK_SAPLING, TFBlocks.TWILIGHT_OAK_SIGN, TFBlocks.TWILIGHT_OAK_HANGING_SIGN,
            TFBlocks.CANOPY_DOOR, TFBlocks.CANOPY_TRAPDOOR, TFBlocks.CANOPY_LEAVES, TFBlocks.CANOPY_SAPLING, TFBlocks.CANOPY_SIGN, TFBlocks.CANOPY_HANGING_SIGN,
            TFBlocks.TWILIGHT_MANGROVE_DOOR, TFBlocks.TWILIGHT_MANGROVE_TRAPDOOR, TFBlocks.TWILIGHT_MANGROVE_LEAVES, TFBlocks.TWILIGHT_MANGROVE_SAPLING, TFBlocks.TWILIGHT_MANGROVE_SIGN, TFBlocks.TWILIGHT_MANGROVE_HANGING_SIGN,
            TFBlocks.DARK_DOOR, TFBlocks.DARK_TRAPDOOR, TFBlocks.DARK_LEAVES, TFBlocks.DARK_SAPLING, TFBlocks.DARK_SIGN, TFBlocks.DARK_HANGING_SIGN,
            TFBlocks.TIME_DOOR, TFBlocks.TIME_TRAPDOOR, TFBlocks.TIME_LEAVES, TFBlocks.TIME_SAPLING, TFBlocks.TIME_SIGN, TFBlocks.TIME_HANGING_SIGN,
            TFBlocks.TRANSFORMATION_DOOR, TFBlocks.TRANSFORMATION_TRAPDOOR, TFBlocks.TRANSFORMATION_LEAVES, TFBlocks.TRANSFORMATION_SAPLING, TFBlocks.TRANSFORMATION_SIGN, TFBlocks.TRANSFORMATION_HANGING_SIGN,
            TFBlocks.MINING_DOOR, TFBlocks.MINING_TRAPDOOR, TFBlocks.MINING_LEAVES, TFBlocks.MINING_SAPLING, TFBlocks.MINING_SIGN, TFBlocks.MINING_HANGING_SIGN,
            TFBlocks.SORTING_DOOR, TFBlocks.SORTING_TRAPDOOR, TFBlocks.SORTING_LEAVES, TFBlocks.SORTING_SAPLING, TFBlocks.SORTING_SIGN, TFBlocks.SORTING_HANGING_SIGN
        )
        cutoutBlocks.forEach { BlockRenderLayerMap.putBlock(it, BlockRenderLayer.CUTOUT) }

        // Register boat model layers
        TFBoatClientHelper.registerModelLayers(Identifier.of(TwilightForest.MOD_ID, "twilight_oak"))
        TFBoatClientHelper.registerModelLayers(Identifier.of(TwilightForest.MOD_ID, "canopy"))
        TFBoatClientHelper.registerModelLayers(Identifier.of(TwilightForest.MOD_ID, "twilight_mangrove"))
        TFBoatClientHelper.registerModelLayers(Identifier.of(TwilightForest.MOD_ID, "dark"))
        TFBoatClientHelper.registerModelLayers(Identifier.of(TwilightForest.MOD_ID, "time"))
        TFBoatClientHelper.registerModelLayers(Identifier.of(TwilightForest.MOD_ID, "transformation"))
        TFBoatClientHelper.registerModelLayers(Identifier.of(TwilightForest.MOD_ID, "mining"))
        TFBoatClientHelper.registerModelLayers(Identifier.of(TwilightForest.MOD_ID, "sorting"))


    }
}
