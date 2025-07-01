package autumn.twilightforest.util

import autumn.twilightforest.init.block.TFBlocks
import net.minecraft.block.Block
import net.minecraft.data.family.BlockFamily
import net.minecraft.registry.Registries

object TFBlockFamilies {
    private val BASE_BLOCKS_TO_FAMILIES: MutableMap<Block, BlockFamily> = mutableMapOf()

    fun registerBlockFamily(baseBlock: Block): BlockFamily.Builder {
        val builder = BlockFamily.Builder(baseBlock)
        val blockFamily = BASE_BLOCKS_TO_FAMILIES.put(baseBlock, builder.build())
        if (blockFamily != null) {
            throw IllegalStateException("Duplicate family definition for ${Registries.BLOCK.getId(baseBlock)}")
        } else {
            return builder
        }
    }

    fun get(baseBlock: Block): BlockFamily? {
        return BASE_BLOCKS_TO_FAMILIES[baseBlock]
    }

    fun registerBlockFamilies() {
        val TWILIGHT_OAK: BlockFamily = registerBlockFamily(TFBlocks.TWILIGHT_OAK_PLANKS)
            .button(TFBlocks.TWILIGHT_OAK_BUTTON)
            .pressurePlate(TFBlocks.TWILIGHT_OAK_PRESSURE_PLATE)
            //.sign(TFBlocks.TWILIGHT_OAK_SIGN, TFBlocks.TWILIGHT_OAK_WALL_SIGN)
            .fence(TFBlocks.TWILIGHT_OAK_FENCE)
            .fenceGate(TFBlocks.TWILIGHT_OAK_FENCE_GATE)
            .stairs(TFBlocks.TWILIGHT_OAK_STAIRS)
            .slab(TFBlocks.TWILIGHT_OAK_SLAB)
            .door(TFBlocks.TWILIGHT_OAK_DOOR)
            .trapdoor(TFBlocks.TWILIGHT_OAK_TRAPDOOR)
            .group("wooden")
            .unlockCriterionName("has_planks")
            .build()
    }
}