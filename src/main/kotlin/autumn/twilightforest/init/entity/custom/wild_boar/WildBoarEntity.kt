package autumn.twilightforest.init.entity.custom.wild_boar

import autumn.twilightforest.init.entity.TFEntities
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnReason
import net.minecraft.entity.passive.PassiveEntity
import net.minecraft.entity.passive.PigEntity
import net.minecraft.server.world.ServerWorld
import net.minecraft.world.World

class WildBoarEntity(entityType: EntityType<out PigEntity>, world: World) : PigEntity(entityType, world) {
    //BASICALLY JSUT A PIG

    override fun createChild(serverWorld: ServerWorld?, passiveEntity: PassiveEntity?): WildBoarEntity? {
        return TFEntities.WILD_BOAR.create(world, SpawnReason.BREEDING)
    }
}