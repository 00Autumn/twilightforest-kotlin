package autumn.twilightforest.init.block.custom

import autumn.twilightforest.init.block.TFBlocks
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.ShapeContext
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.Entity
import net.minecraft.entity.EntityCollisionHandler
import net.minecraft.entity.ItemEntity
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.ai.pathing.NavigationType
import net.minecraft.entity.mob.SpiderEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.math.BlockPos
import net.minecraft.util.shape.VoxelShape
import net.minecraft.world.BlockView
import net.minecraft.world.World

class HedgeBlock(settings: AbstractBlock.Settings) : Block(settings) {
    companion object {
        private val HEDGE_BB: VoxelShape = createCuboidShape(1.0, 0.0, 1.0, 15.0, 15.0, 15.0)
        private const val DAMAGE = 3
    }

    override fun onPlaced(world: World, pos: BlockPos, state: BlockState, placer: LivingEntity?, stack: ItemStack) {
        if (!world.isClient && world.random.nextFloat() < 0.25f) {
            world.setBlockState(pos, TFBlocks.HEDGE_ROSE.defaultState)
        }
    }

    override fun getCollisionShape(state: BlockState, world: BlockView, pos: BlockPos, context: ShapeContext): VoxelShape = HEDGE_BB
    override fun getOutlineShape(state: BlockState, world: BlockView, pos: BlockPos, context: ShapeContext): VoxelShape = HEDGE_BB

    override fun onEntityCollision(state: BlockState, world: World, pos: BlockPos, entity: Entity, handler: EntityCollisionHandler) {
        if (shouldDamage(entity) && world is ServerWorld?) {
            entity.damage(world, world.damageSources.cactus(), DAMAGE.toFloat())
        }
    }

    override fun afterBreak(world: World, player: PlayerEntity, pos: BlockPos, state: BlockState, blockEntity: BlockEntity?, tool: ItemStack) {
        player.damage(world as ServerWorld?,world.damageSources.cactus(),  DAMAGE.toFloat())
        super.afterBreak(world, player, pos, state, blockEntity, tool)
    }

    override fun onBlockBreakStart(state: BlockState, world: World, pos: BlockPos, player: PlayerEntity) {
        if (!world.isClient && shouldDamage(player)) {
            player.damage(world as ServerWorld?, world.damageSources.cactus(), DAMAGE.toFloat())
        }
        super.onBlockBreakStart(state, world, pos, player)
    }

    override fun canPathfindThrough(state: BlockState, type: NavigationType): Boolean = false

    private fun shouldDamage(entity: Entity): Boolean {
        return entity !is SpiderEntity && entity !is ItemEntity && !entity.isSpectator && !entity.isSneaking
    }
}