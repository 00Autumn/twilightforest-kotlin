package autumn.twilightforest.init.block.custom

import net.minecraft.block.AbstractBlock
import net.minecraft.block.BlockState
import net.minecraft.block.HayBlock
import net.minecraft.entity.Entity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.tooltip.TooltipType
import net.minecraft.text.Text
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class ArcticFurBlock(settings: AbstractBlock.Settings) : HayBlock(settings) {
    override fun onLandedUpon(world: World, state: BlockState, pos: BlockPos, entity: Entity, fallDistance: Float) {
        entity.handleFallDamage(fallDistance, 0.1f, world.damageSources.fall())
    }

    override fun appendTooltip(stack: ItemStack, context: Item.TooltipContext, tooltip: MutableList<Text>, type: TooltipType) {
        tooltip.add(
            Text.translatable("tooltip.twilightforest.arctic_fur_block.tooltip")
                .withColor(15269631)
        )
        super.appendTooltip(stack, context, tooltip, type)
    }
}