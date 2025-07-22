package autumn.twilightforest.init.entity.vanilla.hedge_spider

import autumn.twilightforest.init.entity.TFEntities
import net.minecraft.entity.EntityData
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnReason
import net.minecraft.entity.mob.SpiderEntity
import net.minecraft.server.world.ServerWorld
import net.minecraft.world.LocalDifficulty
import net.minecraft.world.ServerWorldAccess
import net.minecraft.world.World

class HedgeSpiderEntity(entityType: EntityType<out SpiderEntity>, world: World) : SpiderEntity(entityType, world) {
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
}