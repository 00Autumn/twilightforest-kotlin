package autumn.twilightforest.init.entity.client.skeleton_druid.projectile

import net.minecraft.entity.Entity
import net.minecraft.entity.EntityType
import net.minecraft.entity.LazyEntityReference
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.data.DataTracker
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.entity.projectile.PersistentProjectileEntity
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.particle.ParticleEffect
import net.minecraft.particle.ParticleTypes
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.hit.EntityHitResult
import net.minecraft.world.Difficulty
import net.minecraft.world.World

class NatureBolt(entityType: EntityType<out PersistentProjectileEntity>, world: World) : PersistentProjectileEntity(entityType, world) {
    private var ticksInGround = 0
    private val maxTicksInGround = 60  // For example, 6 seconds (20 ticks/sec * 6)

    override fun initDataTracker(builder: DataTracker.Builder?) {
        super.initDataTracker(builder)
        //Maybe implement later
    }

    override fun tick() {
        super.tick()

        makeTrail(ParticleTypes.HAPPY_VILLAGER, 0.0, 0.0, 0.0, 5)

        if (this.inGroundTime >= maxTicksInGround) {
            println("TOO MUCH")
            this.remove(RemovalReason.DISCARDED)
        }
    }

    override fun getGravity(): Double {
        return 0.03
    }

    override fun onBlockHit(result: BlockHitResult) {
        //Maybe implement later
    }

    override fun getDefaultItemStack(): ItemStack? {
        return ItemStack(Items.WHEAT_SEEDS)
    }

    override fun onEntityHit(result: EntityHitResult) {
        super.onEntityHit(result)
        val hit = result.entity
        val realOwner = LazyEntityReference.resolve(this.owner, this.world, Entity::class.java) ?: return

        if (realOwner.isConnectedThroughVehicle(hit)) return

        val serverWorld = this.world
        if (serverWorld is ServerWorld && hit is LivingEntity) {
            hit.damage(serverWorld, serverWorld.damageSources.magic(), 2.0F)
            if (serverWorld.difficulty != Difficulty.PEACEFUL && serverWorld.difficulty != Difficulty.EASY) {
                val poisonTime = if (serverWorld.difficulty == Difficulty.HARD) 7 else 3
                hit.addStatusEffect(StatusEffectInstance(StatusEffects.POISON, poisonTime * 20, 0, false, false))
            }
        }
    }

    fun makeTrail(particle: ParticleEffect, r: Double, g: Double, b: Double, amount: Int) {
        repeat(amount) {
            val dx = x + 0.5 * (random.nextDouble() - random.nextDouble())
            val dy = y + 0.5 * (random.nextDouble() - random.nextDouble())
            val dz = z + 0.5 * (random.nextDouble() - random.nextDouble())
            world.addParticleClient(particle, dx, dy, dz, r, g, b)
        }
    }
}