package autumn.twilightforest.init.item

import autumn.twilightforest.util.tag.TFBlockTags
import autumn.twilightforest.util.tag.TFItemTags
import net.minecraft.item.ToolMaterial

object TFToolMaterials {
    val IRONWOOD = ToolMaterial(TFBlockTags.INCORRECT_FOR_IRONWOOD_TOOL, 512, 6.5F, 2.0F, 25, TFItemTags.REPAIRS_IRONWOOD_TOOLS)

    val STEELEAF = ToolMaterial(TFBlockTags.INCORRECT_FOR_STEELEAF_TOOL, 131, 8.0F, 3.0F, 9, TFItemTags.REPAIRS_STEELEAF_TOOLS)

    val KNIGHTMETAL = ToolMaterial(TFBlockTags.INCORRECT_FOR_KNIGHTMETAL_TOOL, 512, 8.0F, 3.0F, 8, TFItemTags.REPAIRS_KNIGHTMETAL_TOOLS)

    val FIERY = ToolMaterial(TFBlockTags.INCORRECT_FOR_FIERY_TOOL, 1024, 9.0F, 4.0F, 10, TFItemTags.REPAIRS_FIERY_TOOLS)
}