package autumn.twilightforest

import autumn.twilightforest.init.block.TFBlocks
import autumn.twilightforest.util.TFWoodTypes
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap
import net.minecraft.client.render.BlockRenderLayer
import net.minecraft.client.render.RenderLayer

object TwilightForestClient : ClientModInitializer {
    override fun onInitializeClient() {
        TFWoodTypes.registerWoodTypes()

        BlockRenderLayerMap.putBlock(TFBlocks.KNIGHTMETAL_BLOCK, BlockRenderLayer.CUTOUT)
        BlockRenderLayerMap.putBlock(TFBlocks.ANTIBUILT_BLOCK, BlockRenderLayer.CUTOUT)

        BlockRenderLayerMap.putBlock(TFBlocks.TWILIGHT_OAK_DOOR, BlockRenderLayer.CUTOUT)
        BlockRenderLayerMap.putBlock(TFBlocks.TWILIGHT_OAK_TRAPDOOR, BlockRenderLayer.CUTOUT)
        BlockRenderLayerMap.putBlock(TFBlocks.TWILIGHT_OAK_LEAVES, BlockRenderLayer.CUTOUT)
        BlockRenderLayerMap.putBlock(TFBlocks.TWILIGHT_OAK_SAPLING, BlockRenderLayer.CUTOUT)
    }
}