package autumn.twilightforest.util.tag

import autumn.twilightforest.TwilightForest
import net.minecraft.block.Block
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.tag.TagKey
import net.minecraft.util.Identifier

object TFBlockTags {
    val MAZEBREAKER_TOOL_ACCELERATED: TagKey<Block> = createTag("mazebreaker_tool_accelerated")

    val NEEDS_IRONWOOD_TOOL: TagKey<Block> = createTag("needs_ironwood_tool")
    val NEEDS_STEELEAF_TOOL: TagKey<Block> = createTag("needs_steeleaf_tool")
    val NEEDS_KNIGHTMETAL_TOOL: TagKey<Block> = createTag("needs_knightmetal_tool")
    val NEEDS_FIERY_TOOL: TagKey<Block> = createTag("needs_fiery_tool")

    val INCORRECT_FOR_IRONWOOD_TOOL: TagKey<Block> = createTag("incorrect_for_ironwood_tool")
    val INCORRECT_FOR_STEELEAF_TOOL: TagKey<Block> = createTag("incorrect_for_steeleaf_tool")
    val INCORRECT_FOR_KNIGHTMETAL_TOOL: TagKey<Block> = createTag("incorrect_for_knightmetal_tool")
    val INCORRECT_FOR_FIERY_TOOL: TagKey<Block> = createTag("incorrect_for_fiery_tool")

    val TWILIGHT_FOREST_LOGS: TagKey<Block> = createTag("twilight_forest_logs")

    private fun createTag(name: String): TagKey<Block> {
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of(TwilightForest.MOD_ID, name))
    }
}