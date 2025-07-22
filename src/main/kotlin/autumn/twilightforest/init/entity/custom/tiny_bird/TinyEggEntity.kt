package autumn.twilightforest.init.entity.custom.tiny_bird

import autumn.twilightforest.init.entity.TFEntities
import autumn.twilightforest.init.item.TFItems
import net.minecraft.entity.EntityDimensions
import net.minecraft.entity.EntityStatuses
import net.minecraft.entity.EntityType
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.SpawnReason
import net.minecraft.entity.projectile.thrown.ThrownItemEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.particle.ItemStackParticleEffect
import net.minecraft.particle.ParticleTypes
import net.minecraft.util.Util
import net.minecraft.util.hit.EntityHitResult
import net.minecraft.util.hit.HitResult
import net.minecraft.world.World

class TinyEggEntity : ThrownItemEntity {

    val EMPTY_DIMENSIONS = EntityDimensions.fixed(0.0F, 0.0F)

    constructor(type: EntityType<out TinyEggEntity>, world: World) : super(type, world)

    constructor(world: World, owner: LivingEntity, stack: ItemStack)
            : super(TFEntities.TINY_EGG, owner, world, stack)

    constructor(world: World, x: Double, y: Double, z: Double, stack: ItemStack)
            : super(TFEntities.TINY_EGG, x, y, z, world, stack)

    override fun handleStatus(status: Byte) {
        if(status == EntityStatuses.PLAY_DEATH_SOUND_OR_ADD_PROJECTILE_HIT_PARTICLES) {
            val d = 0.08

            repeat(8) {
                world.addParticleClient(
                    ItemStackParticleEffect(ParticleTypes.ITEM, stack),
                    x, y, z,
                    (random.nextFloat() - 0.5) * d,
                    (random.nextFloat() - 0.5) * d,
                    (random.nextFloat() - 0.5) * d
                )
            }
        }
    }

    override fun onEntityHit(entityHitResult: EntityHitResult) {
        super.onEntityHit(entityHitResult)
        entityHitResult.entity.animateDamage(0.0F)
    }

    override fun onCollision(hitResult: HitResult?) {
        super.onCollision(hitResult)
        if (!world.isClient) {
            if (random.nextInt(8) == 0) {
                var count = 1
                if (random.nextInt(32) == 0) {
                    count = 4
                }

                repeat(count) {
                    val tiny_bird = TFEntities.TINY_BIRD.create(world, SpawnReason.TRIGGERED)
                    if (tiny_bird != null) {
                        tiny_bird.breedingAge = -24000
                        tiny_bird.refreshPositionAndAngles(x, y, z, yaw, 0.0f)

                        var variant = Util.getRandom(TinyBirdVariant.values(), this.random)
                        tiny_bird?.setVariant(variant)

                        if (!tiny_bird.recalculateDimensions(EMPTY_DIMENSIONS)) return@repeat

                        world.spawnEntity(tiny_bird)
                    }
                }
            }

            world.sendEntityStatus(this, EntityStatuses.PLAY_DEATH_SOUND_OR_ADD_PROJECTILE_HIT_PARTICLES)
            discard()
        }
    }

    override fun getDefaultItem(): Item? {
        return TFItems.TINY_EGG
    }
}