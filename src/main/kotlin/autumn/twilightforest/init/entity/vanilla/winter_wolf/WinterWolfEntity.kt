package autumn.twilightforest.init.entity.vanilla.winter_wolf

import autumn.twilightforest.init.entity.TFEntities
import net.minecraft.entity.Entity
import net.minecraft.entity.EntityType
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.SpawnReason
import net.minecraft.entity.attribute.DefaultAttributeContainer
import net.minecraft.entity.attribute.EntityAttributes
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.entity.passive.PassiveEntity
import net.minecraft.entity.passive.WolfEntity
import net.minecraft.entity.passive.WolfSoundVariants
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.DyeColor
import net.minecraft.world.World

class WinterWolfEntity(entityType: EntityType<out WolfEntity>, world: World) : WolfEntity(entityType, world) {
    //Nearly just a wolf

    override fun updateAttributesForTamed() {
        if (this.isTamed) {
            this.getAttributeInstance(EntityAttributes.MAX_HEALTH)!!.baseValue = 40.0
            this.health = 60.0F
        } else {
            this.getAttributeInstance(EntityAttributes.MAX_HEALTH)!!.baseValue = 30.0
        }
    }

    override fun tryAttack(world: ServerWorld?, target: Entity?): Boolean {
        if (world == null || target == null) return false
        val hit = super.tryAttack(world, target)
        if (hit && target is LivingEntity) {
            target.addStatusEffect(StatusEffectInstance(StatusEffects.SLOWNESS, 60, 1))
        }
        return hit
    }

    override fun createChild(serverWorld: ServerWorld, passiveEntity: PassiveEntity): WinterWolfEntity? {
        val wolfEntity = TFEntities.WINTER_WOLF.create(serverWorld, SpawnReason.BREEDING)
        if (wolfEntity != null && passiveEntity is WinterWolfEntity) {
            val otherWolf = passiveEntity

            if (this.isTamed) {
                wolfEntity.owner = this.owner
                wolfEntity.setTamed(true, true)

                try {
                    val collarColorField = WinterWolfEntity::class.java.getDeclaredField("collarColor")
                    collarColorField.isAccessible = true
                    val mixedColor = DyeColor.mixColors(serverWorld, this.collarColor, otherWolf.collarColor)
                    collarColorField.set(wolfEntity, mixedColor)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

            try {
                val soundVariantField = WinterWolfEntity::class.java.getDeclaredField("soundVariant")
                soundVariantField.isAccessible = true
                val variant = WolfSoundVariants.select(this.registryManager, this.random)
                soundVariantField.set(wolfEntity, variant)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        return wolfEntity
    }

    companion object {
        fun createWinterWolfAttributes() : DefaultAttributeContainer.Builder {
            return createAnimalAttributes()
                .add(EntityAttributes.MOVEMENT_SPEED, 0.3)
                .add(EntityAttributes.MAX_HEALTH, 30.0)
                .add(EntityAttributes.ATTACK_DAMAGE, 6.0)
        }
    }
}