package autumn.twilightforest.client

import autumn.twilightforest.TwilightForest
import autumn.twilightforest.init.block.TFBlocks
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry
import net.minecraft.block.Block
import net.minecraft.client.color.block.BlockColorProvider
import net.minecraft.client.color.world.BiomeColors
import net.minecraft.world.biome.FoliageColors

object TFColorHandlers {

    val CANOPY_COLORIZER: (Int) -> Int = { color -> 0xFF000000.toInt() or (((color and 0xFEFEFE) + 0x469A66) / 2) }
    val TWILIGHT_MANGROVE_COLORIZER: (Int) -> Int = { color -> 0xFF000000.toInt() or (((color and 0xFEFEFE) + 0xC0E694) / 2) }

    val LEAF_COLOR_PROVIDER = BlockColorProvider { state, world, pos, tintIndex ->
        when (state.block) {
            TFBlocks.TWILIGHT_OAK_LEAVES -> 0x3C8031
            TFBlocks.DARK_LEAVES -> 3890751

            TFBlocks.CANOPY_LEAVES -> {
                val baseColor = if (world != null && pos != null) BiomeColors.getFoliageColor(world, pos) else FoliageColors.SPRUCE
                CANOPY_COLORIZER(baseColor)
            }

            TFBlocks.TWILIGHT_MANGROVE_LEAVES -> {
                val baseColor = if (world != null && pos != null) BiomeColors.getFoliageColor(world, pos) else FoliageColors.BIRCH
                TWILIGHT_MANGROVE_COLORIZER(baseColor)
            }

            TFBlocks.TIME_LEAVES -> {
                if (world == null || pos == null) 0xFF364C03.toInt() // fallback color (54, 76, 3)
                else {
                    val fade = (pos.x * 63 + pos.y * 63 + pos.z * 63).let {
                        var v = it
                        if ((v and 256) != 0) v = 255 - (v and 255)
                        v and 255
                    }
                    val spring = (255 - fade) / 255f
                    val fall = fade / 255f
                    val red = (spring * 54 + fall * 168).toInt()
                    val green = (spring * 76 + fall * 199).toInt()
                    val blue = (spring * 3 + fall * 43).toInt()
                    (0xFF shl 24) or (red shl 16) or (green shl 8) or blue
                }
            }

            TFBlocks.TRANSFORMATION_LEAVES -> {
                if (world == null || pos == null) 0xFF6CCAEA.toInt() // fallback color (108, 204, 234)
                else {
                    val fade = (pos.x * 27 + pos.y * 63 + pos.z * 39).let {
                        var v = it
                        if ((v and 256) != 0) v = 255 - (v and 255)
                        v and 255
                    }
                    val spring = (255 - fade) / 255f
                    val fall = fade / 255f
                    val red = (spring * 108 + fall * 96).toInt()
                    val green = (spring * 204 + fall * 107).toInt()
                    val blue = (spring * 234 + fall * 121).toInt()
                    (0xFF shl 24) or (red shl 16) or (green shl 8) or blue
                }
            }

            TFBlocks.MINING_LEAVES -> {
                if (world == null || pos == null) 0xFFFDF144.toInt() // fallback color (252, 241, 68)
                else {
                    val fade = (pos.x * 31 + pos.y * 33 + pos.z * 32).let {
                        var v = it
                        if ((v and 256) != 0) v = 255 - (v and 255)
                        v and 255
                    }
                    val spring = (255 - fade) / 255f
                    val fall = fade / 255f
                    val red = (spring * 252 + fall * 237).toInt()
                    val green = (spring * 241 + fall * 172).toInt()
                    val blue = (spring * 68 + fall * 9).toInt()
                    (0xFF shl 24) or (red shl 16) or (green shl 8) or blue
                }
            }

            TFBlocks.SORTING_LEAVES -> {
                if (world == null || pos == null) {
                    -1
                } else {
                    // Use biome average foliage color as a simple substitute
                    BiomeColors.getFoliageColor(world, pos)
                }
            }

            else -> if (world != null && pos != null) BiomeColors.getFoliageColor(world, pos) else FoliageColors.DEFAULT
        }
    }

    fun registerBlockColor(provider: BlockColorProvider, vararg blocks: Block) {
        ColorProviderRegistry.BLOCK.register(provider, *blocks)
    }

    fun registerBlockColors() {
        TwilightForest.logger?.info("Registering block color providers for " + TwilightForest.MOD_ID)

        registerBlockColor(
            LEAF_COLOR_PROVIDER,
            TFBlocks.TWILIGHT_OAK_LEAVES,
            TFBlocks.CANOPY_LEAVES,
            TFBlocks.TWILIGHT_MANGROVE_LEAVES,
            TFBlocks.DARK_LEAVES,
            TFBlocks.TIME_LEAVES,
            TFBlocks.TRANSFORMATION_LEAVES,
            TFBlocks.MINING_LEAVES,
            TFBlocks.SORTING_LEAVES
            // Add other leaves if needed here
        )
    }
}