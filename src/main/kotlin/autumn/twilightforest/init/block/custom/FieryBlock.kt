package autumn.twilightforest.init.block.custom

import net.minecraft.block.AbstractBlock
import net.minecraft.block.BlockState
import net.minecraft.block.MagmaBlock
import net.minecraft.entity.Entity
import net.minecraft.entity.EntityCollisionHandler
import net.minecraft.entity.ItemEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.tooltip.TooltipType
import net.minecraft.text.Text
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class FieryBlock(settings: AbstractBlock.Settings) : MagmaBlock(settings) {

    override fun onEntityCollision(state: BlockState, world: World, pos: BlockPos, entity: Entity, handler: EntityCollisionHandler) {
        if (shouldDamage(entity)) {
            entity.setOnFireFor(3.0F)
        }
    }

    private fun shouldDamage(entity: Entity): Boolean {
        return entity !is ItemEntity &&
                !entity.isSpectator &&
                !entity.isSneaking &&
                !entity.isFireImmune
    }
}