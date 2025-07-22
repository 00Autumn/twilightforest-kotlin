package autumn.twilightforest.init.entity.vanilla.carminite_broodling

import net.minecraft.entity.EntityData
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnReason
import net.minecraft.entity.attribute.DefaultAttributeContainer
import net.minecraft.entity.attribute.EntityAttributes
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.mob.SpiderEntity
import net.minecraft.world.Difficulty
import net.minecraft.world.LocalDifficulty
import net.minecraft.world.ServerWorldAccess
import net.minecraft.world.World

class CarminiteBroodlingEntity(entityType: EntityType<out SpiderEntity>, world: World) : SpiderEntity(entityType, world) {
    //NEARLY JUST A SPIDER...

    //DISABLED JOCKEY
    override fun initialize(
        world: ServerWorldAccess,
        difficulty: LocalDifficulty,
        spawnReason: SpawnReason,
        entityData: EntityData?
    ): EntityData? {
        var data = super.initialize(world, difficulty, spawnReason, entityData)
        val random = world.random

        if (data == null) {
            data = SpiderEntity.SpiderData()
            if (
                world.difficulty == Difficulty.HARD &&
                random.nextFloat() < 0.1f * difficulty.clampedLocalDifficulty
            ) {
                (data as SpiderEntity.SpiderData).setEffect(random)
            }
        }

        if (data is SpiderEntity.SpiderData) {
            val registryEntry = data.effect
            if (registryEntry != null) {
                this.addStatusEffect(StatusEffectInstance(registryEntry, -1))
            }
        }

        return data
    }

    companion object {
        fun createCarminiteBroodlingAtrributes(): DefaultAttributeContainer.Builder {
            return createHostileAttributes().add(EntityAttributes.MAX_HEALTH, 14.0)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.3)
        }
    }
}