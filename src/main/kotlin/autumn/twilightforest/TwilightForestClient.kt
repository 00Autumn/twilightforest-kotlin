package autumn.twilightforest

import autumn.twilightforest.init.block.TFBlocks
import autumn.twilightforest.util.TFWoodTypes
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.minecraft.client.render.RenderLayer

object TwilightForestClient : ClientModInitializer {
    override fun onInitializeClient() {
        TFWoodTypes.registerWoodTypes()

        BlockRenderLayerMap.INSTANCE.putBlock(TFBlocks.KNIGHTMETAL_BLOCK, RenderLayer.getCutout())
        BlockRenderLayerMap.INSTANCE.putBlock(TFBlocks.ANTIBUILT_BLOCK, RenderLayer.getCutout())

        BlockRenderLayerMap.INSTANCE.putBlock(TFBlocks.TWILIGHT_OAK_DOOR, RenderLayer.getCutout())
        BlockRenderLayerMap.INSTANCE.putBlock(TFBlocks.TWILIGHT_OAK_TRAPDOOR, RenderLayer.getCutout())
        BlockRenderLayerMap.INSTANCE.putBlock(TFBlocks.TWILIGHT_OAK_LEAVES, RenderLayer.getCutout())
        BlockRenderLayerMap.INSTANCE.putBlock(TFBlocks.TWILIGHT_OAK_SAPLING, RenderLayer.getCutout())
    }
}