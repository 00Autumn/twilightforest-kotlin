package autumn.twilightforest.init.entity.vanilla.bighorn_sheep

import autumn.twilightforest.init.entity.TFEntities
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnReason
import net.minecraft.entity.passive.PassiveEntity
import net.minecraft.entity.passive.SheepEntity
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.DyeColor
import net.minecraft.world.World

class BighornSheepEntity(entityType: EntityType<out SheepEntity>, world: World) : SheepEntity(entityType, world) {
    //BASICALLY JUST A SHEEP

    override fun createChild(world: ServerWorld, other: PassiveEntity): BighornSheepEntity? {
        val child = TFEntities.BIGHORN_SHEEP.create(world, SpawnReason.BREEDING)
        if (child != null && other is BighornSheepEntity) {
            val color1 = this.color
            val color2 = other.color
            child.color = DyeColor.mixColors(world, color1, color2)
        }
        return child
    }
}