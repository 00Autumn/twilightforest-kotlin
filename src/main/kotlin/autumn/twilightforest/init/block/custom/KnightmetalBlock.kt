package autumn.twilightforest.init.block.custom

import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.ShapeContext
import net.minecraft.entity.Entity
import net.minecraft.entity.EntityCollisionHandler
import net.minecraft.entity.ItemEntity
import net.minecraft.entity.ai.pathing.NavigationType
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.tooltip.TooltipType
import net.minecraft.server.world.ServerWorld
import net.minecraft.text.Text
import net.minecraft.util.math.BlockPos
import net.minecraft.util.shape.VoxelShape
import net.minecraft.world.BlockView
import net.minecraft.world.World


class KnightmetalBlock(settings: AbstractBlock.Settings) : Block(settings) {
    companion object {
        private const val DAMAGE = 4
        private val KNIGHTMETAL_BLOCK_BB: VoxelShape =
            createCuboidShape(1.0, 1.0, 1.0, 15.0, 15.0, 15.0)
    }

    override fun getCollisionShape(state: BlockState, world: BlockView, pos: BlockPos, context: ShapeContext): VoxelShape = KNIGHTMETAL_BLOCK_BB
    override fun getOutlineShape(state: BlockState, world: BlockView, pos: BlockPos, context: ShapeContext): VoxelShape = KNIGHTMETAL_BLOCK_BB

    override fun onEntityCollision(state: BlockState, world: World, pos: BlockPos, entity: Entity, handler: EntityCollisionHandler) {
        if (shouldDamage(entity) && world is ServerWorld) {
            entity.damage(world, world.damageSources.cactus(), DAMAGE.toFloat())
        }
    }

    override fun canPathfindThrough(state: BlockState, type: NavigationType): Boolean = false

    private fun shouldDamage(entity: Entity): Boolean {
        return entity !is ItemEntity && !entity.isSpectator && !entity.isSneaking
    }
}