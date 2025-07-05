package autumn.twilightforest

import autumn.twilightforest.boat.api.client.TFBoatClientHelper
import autumn.twilightforest.init.block.TFBlocks
import autumn.twilightforest.util.TFWoodTypes
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap
import net.minecraft.client.render.BlockRenderLayer
import net.minecraft.util.Identifier

object TwilightForestClient : ClientModInitializer {
    override fun onInitializeClient() {
        TFWoodTypes.registerWoodTypes()

        BlockRenderLayerMap.putBlock(TFBlocks.KNIGHTMETAL_BLOCK, BlockRenderLayer.CUTOUT)
        BlockRenderLayerMap.putBlock(TFBlocks.ANTIBUILT_BLOCK, BlockRenderLayer.CUTOUT)

        BlockRenderLayerMap.putBlock(TFBlocks.TWILIGHT_OAK_DOOR, BlockRenderLayer.CUTOUT)
        BlockRenderLayerMap.putBlock(TFBlocks.TWILIGHT_OAK_TRAPDOOR, BlockRenderLayer.CUTOUT)
        BlockRenderLayerMap.putBlock(TFBlocks.TWILIGHT_OAK_LEAVES, BlockRenderLayer.CUTOUT)
        BlockRenderLayerMap.putBlock(TFBlocks.TWILIGHT_OAK_SAPLING, BlockRenderLayer.CUTOUT)
        BlockRenderLayerMap.putBlock(TFBlocks.TWILIGHT_OAK_SIGN, BlockRenderLayer.CUTOUT)
        BlockRenderLayerMap.putBlock(TFBlocks.TWILIGHT_OAK_HANGING_SIGN, BlockRenderLayer.CUTOUT)
        TFBoatClientHelper.registerModelLayers(Identifier.of(TwilightForest.MOD_ID, "twilight_oak"))

        BlockRenderLayerMap.putBlock(TFBlocks.CANOPY_DOOR, BlockRenderLayer.CUTOUT)
        BlockRenderLayerMap.putBlock(TFBlocks.CANOPY_TRAPDOOR, BlockRenderLayer.CUTOUT)
        BlockRenderLayerMap.putBlock(TFBlocks.CANOPY_LEAVES, BlockRenderLayer.CUTOUT)
        BlockRenderLayerMap.putBlock(TFBlocks.CANOPY_SAPLING, BlockRenderLayer.CUTOUT)
        BlockRenderLayerMap.putBlock(TFBlocks.CANOPY_SIGN, BlockRenderLayer.CUTOUT)
        BlockRenderLayerMap.putBlock(TFBlocks.CANOPY_HANGING_SIGN, BlockRenderLayer.CUTOUT)
        TFBoatClientHelper.registerModelLayers(Identifier.of(TwilightForest.MOD_ID, "canopy"))

        BlockRenderLayerMap.putBlock(TFBlocks.TWILIGHT_MANGROVE_DOOR, BlockRenderLayer.CUTOUT)
        BlockRenderLayerMap.putBlock(TFBlocks.TWILIGHT_MANGROVE_TRAPDOOR, BlockRenderLayer.CUTOUT)
        BlockRenderLayerMap.putBlock(TFBlocks.TWILIGHT_MANGROVE_LEAVES, BlockRenderLayer.CUTOUT)
        BlockRenderLayerMap.putBlock(TFBlocks.TWILIGHT_MANGROVE_SAPLING, BlockRenderLayer.CUTOUT)
        BlockRenderLayerMap.putBlock(TFBlocks.TWILIGHT_MANGROVE_SIGN, BlockRenderLayer.CUTOUT)
        BlockRenderLayerMap.putBlock(TFBlocks.TWILIGHT_MANGROVE_HANGING_SIGN, BlockRenderLayer.CUTOUT)
        TFBoatClientHelper.registerModelLayers(Identifier.of(TwilightForest.MOD_ID, "twilight_mangrove"))

        BlockRenderLayerMap.putBlock(TFBlocks.DARK_DOOR, BlockRenderLayer.CUTOUT)
        BlockRenderLayerMap.putBlock(TFBlocks.DARK_TRAPDOOR, BlockRenderLayer.CUTOUT)
        BlockRenderLayerMap.putBlock(TFBlocks.DARK_LEAVES, BlockRenderLayer.CUTOUT)
        BlockRenderLayerMap.putBlock(TFBlocks.DARK_SAPLING, BlockRenderLayer.CUTOUT)
        BlockRenderLayerMap.putBlock(TFBlocks.DARK_SIGN, BlockRenderLayer.CUTOUT)
        BlockRenderLayerMap.putBlock(TFBlocks.DARK_HANGING_SIGN, BlockRenderLayer.CUTOUT)
        TFBoatClientHelper.registerModelLayers(Identifier.of(TwilightForest.MOD_ID, "dark"))

        BlockRenderLayerMap.putBlock(TFBlocks.TIME_DOOR, BlockRenderLayer.CUTOUT)
        BlockRenderLayerMap.putBlock(TFBlocks.TIME_TRAPDOOR, BlockRenderLayer.CUTOUT)
        BlockRenderLayerMap.putBlock(TFBlocks.TIME_LEAVES, BlockRenderLayer.CUTOUT)
        BlockRenderLayerMap.putBlock(TFBlocks.TIME_SAPLING, BlockRenderLayer.CUTOUT)
        BlockRenderLayerMap.putBlock(TFBlocks.TIME_SIGN, BlockRenderLayer.CUTOUT)
        BlockRenderLayerMap.putBlock(TFBlocks.TIME_HANGING_SIGN, BlockRenderLayer.CUTOUT)
        TFBoatClientHelper.registerModelLayers(Identifier.of(TwilightForest.MOD_ID, "time"))

        BlockRenderLayerMap.putBlock(TFBlocks.TRANSFORMATION_DOOR, BlockRenderLayer.CUTOUT)
        BlockRenderLayerMap.putBlock(TFBlocks.TRANSFORMATION_TRAPDOOR, BlockRenderLayer.CUTOUT)
        BlockRenderLayerMap.putBlock(TFBlocks.TRANSFORMATION_LEAVES, BlockRenderLayer.CUTOUT)
        BlockRenderLayerMap.putBlock(TFBlocks.TRANSFORMATION_SAPLING, BlockRenderLayer.CUTOUT)
        BlockRenderLayerMap.putBlock(TFBlocks.TRANSFORMATION_SIGN, BlockRenderLayer.CUTOUT)
        BlockRenderLayerMap.putBlock(TFBlocks.TRANSFORMATION_HANGING_SIGN, BlockRenderLayer.CUTOUT)
        TFBoatClientHelper.registerModelLayers(Identifier.of(TwilightForest.MOD_ID, "transformation"))

        BlockRenderLayerMap.putBlock(TFBlocks.MINING_DOOR, BlockRenderLayer.CUTOUT)
        BlockRenderLayerMap.putBlock(TFBlocks.MINING_TRAPDOOR, BlockRenderLayer.CUTOUT)
        BlockRenderLayerMap.putBlock(TFBlocks.MINING_LEAVES, BlockRenderLayer.CUTOUT)
        BlockRenderLayerMap.putBlock(TFBlocks.MINING_SAPLING, BlockRenderLayer.CUTOUT)
        BlockRenderLayerMap.putBlock(TFBlocks.MINING_SIGN, BlockRenderLayer.CUTOUT)
        BlockRenderLayerMap.putBlock(TFBlocks.MINING_HANGING_SIGN, BlockRenderLayer.CUTOUT)
        TFBoatClientHelper.registerModelLayers(Identifier.of(TwilightForest.MOD_ID, "mining"))

        BlockRenderLayerMap.putBlock(TFBlocks.SORTING_DOOR, BlockRenderLayer.CUTOUT)
        BlockRenderLayerMap.putBlock(TFBlocks.SORTING_TRAPDOOR, BlockRenderLayer.CUTOUT)
        BlockRenderLayerMap.putBlock(TFBlocks.SORTING_LEAVES, BlockRenderLayer.CUTOUT)
        BlockRenderLayerMap.putBlock(TFBlocks.SORTING_SAPLING, BlockRenderLayer.CUTOUT)
        BlockRenderLayerMap.putBlock(TFBlocks.SORTING_SIGN, BlockRenderLayer.CUTOUT)
        BlockRenderLayerMap.putBlock(TFBlocks.SORTING_HANGING_SIGN, BlockRenderLayer.CUTOUT)
        TFBoatClientHelper.registerModelLayers(Identifier.of(TwilightForest.MOD_ID, "sorting"))
    }
}