package autumn.twilightforest.init.entity.vanilla.swarm_spider

import autumn.twilightforest.init.entity.TFEntities
import net.minecraft.entity.EntityData
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnReason
import net.minecraft.entity.attribute.DefaultAttributeContainer
import net.minecraft.entity.attribute.EntityAttributes
import net.minecraft.entity.mob.SpiderEntity
import net.minecraft.server.world.ServerWorld
import net.minecraft.world.LocalDifficulty
import net.minecraft.world.ServerWorldAccess
import net.minecraft.world.World

class SwarmSpiderEntity(entityType: EntityType<out SpiderEntity>, world: World) : SpiderEntity(entityType, world) {
    //NEARLY JUST A SPIDER...

    override fun initialize(
        world: ServerWorldAccess,
        difficulty: LocalDifficulty,
        spawnReason: SpawnReason,
        entityData: EntityData?
    ): EntityData? {
        val data = super.initialize(world, difficulty, spawnReason, entityData)

        if (random.nextFloat() < 0.05F) {
            val serverWorld = this.world as? ServerWorld
            if (serverWorld != null) {
                val druid = TFEntities.SKELETON_DRUID.create(serverWorld, SpawnReason.JOCKEY)
                if (druid != null) {
                    druid.refreshPositionAndAngles(this.x, this.y, this.z, this.yaw, 0f)
                    druid.initialize(world, difficulty, spawnReason, null)
                    druid.startRiding(this)
                }
            }
        }
        return data
    }

    companion object {
        fun createSwarmSpiderAtrributes(): DefaultAttributeContainer.Builder {
            return createHostileAttributes().add(EntityAttributes.MAX_HEALTH, 3.0)
                .add(EntityAttributes.ATTACK_DAMAGE, 1.0)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.3)
        }
    }
}