package autumn.twilightforest.init.block.custom

import net.minecraft.block.AbstractBlock
import net.minecraft.block.BlockState
import net.minecraft.block.HayBlock
import net.minecraft.entity.Entity
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class ArcticFurBlock(settings: AbstractBlock.Settings) : HayBlock(settings) {
    override fun onLandedUpon(world: World, state: BlockState, pos: BlockPos, entity: Entity, fallDistance: Double) {
        entity.handleFallDamage(fallDistance, 0.1f, world.damageSources.fall())
    }
}