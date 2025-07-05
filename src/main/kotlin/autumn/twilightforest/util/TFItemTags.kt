package autumn.twilightforest.util

import autumn.twilightforest.TwilightForest
import net.minecraft.item.Item
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.tag.TagKey
import net.minecraft.util.Identifier

object TFItemTags {
    val MAZEBREAKER_TOOL: TagKey<Item> = createTag("mazebreaker_tool")
    val FIERY_TOOL: TagKey<Item> = createTag("fiery_tool")

    val KEPT_ON_DEATH: TagKey<Item> = createTag("kept_on_death")

    val IS_FIERY_VIAL: TagKey<Item> = createTag("is_fiery_vial")

    val NAGA_SCALES: TagKey<Item> = createTag("naga_scales")
    val IRONWOOD_INGOTS: TagKey<Item> = createTag("ironwood_ingots")
    val STEELEAF_INGOTS: TagKey<Item> = createTag("steeleaf_ingots")
    val KNIGHTMETAL_INGOTS: TagKey<Item> = createTag("knightmetal_ingots")
    val FIERY_INGOTS: TagKey<Item> = createTag("fiery_ingots")
    val ARCTIC_FURS: TagKey<Item> = createTag("arctic_furs")
    val ALPHA_YETI_FURS: TagKey<Item> = createTag("alpha_yeti_furs")

    val REPAIRS_IRONWOOD_TOOLS: TagKey<Item> = createTag("repairs_ironwood_tools")
    val REPAIRS_STEELEAF_TOOLS: TagKey<Item> = createTag("repairs_steeleaf_tools")
    val REPAIRS_KNIGHTMETAL_TOOLS: TagKey<Item> = createTag("repairs_knightmetal_tools")
    val REPAIRS_FIERY_TOOLS: TagKey<Item> = createTag("repairs_fiery_tools")

    val REPAIRS_NAGA_SCALE_ARMOR: TagKey<Item> = createTag("repairs_naga_scale_armor")
    val REPAIRS_IRONWOOD_ARMOR: TagKey<Item> = createTag("repairs_ironwood_armor")
    val REPAIRS_STEELEAF_ARMOR: TagKey<Item> = createTag("repairs_steeleaf_armor")
    val REPAIRS_KNIGHTMETAL_ARMOR: TagKey<Item> = createTag("repairs_knightmetal_armor")
    val REPAIRS_PHANTOM_ARMOR: TagKey<Item> = createTag("repairs_phantom_armor")
    val REPAIRS_FIERY_ARMOR: TagKey<Item> = createTag("repairs_fiery_armor")
    val REPAIRS_ARCTIC_ARMOR: TagKey<Item> = createTag("repairs_arctic_armor")
    val REPAIRS_YETI_ARMOR: TagKey<Item> = createTag("repairs_yeti_armor")

    val TWILIGHT_FOREST_LOGS: TagKey<Item> = createTag("twilight_forest_logs")

    private fun createTag(name: String): TagKey<Item> {
        return TagKey.of(RegistryKeys.ITEM, Identifier.of(TwilightForest.MOD_ID, name))
    }
}