package autumn.twilightforest.init.entity.vanilla.skeleton_druid

import autumn.twilightforest.init.entity.TFEntities
import autumn.twilightforest.init.entity.client.skeleton_druid.projectile.NatureBolt
import autumn.twilightforest.init.entity.vanilla.hedge_spider.HedgeSpiderEntity
import autumn.twilightforest.init.entity.vanilla.swarm_spider.SwarmSpiderEntity
import autumn.twilightforest.util.tag.TFItemTags
import net.minecraft.entity.EntityType
import net.minecraft.entity.EquipmentSlot
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.attribute.DefaultAttributeContainer
import net.minecraft.entity.attribute.EntityAttributes
import net.minecraft.entity.data.DataTracker
import net.minecraft.entity.data.TrackedData
import net.minecraft.entity.data.TrackedDataHandlerRegistry
import net.minecraft.entity.mob.PathAwareEntity
import net.minecraft.entity.mob.SkeletonEntity
import net.minecraft.entity.projectile.PersistentProjectileEntity
import net.minecraft.entity.projectile.ProjectileEntity
import net.minecraft.entity.projectile.ProjectileUtil
import net.minecraft.item.*
import net.minecraft.registry.tag.TagKey
import net.minecraft.server.world.ServerWorld
import net.minecraft.sound.SoundEvents
import net.minecraft.util.math.random.Random
import net.minecraft.world.LocalDifficulty
import net.minecraft.world.World
import kotlin.math.sqrt

class SkeletonDruidEntity(entityType: EntityType<out SkeletonEntity>, world: World) : SkeletonEntity(entityType, world) {
    //NEARLY JUST A SKELETON

    override fun initDataTracker(builder: DataTracker.Builder) {
        super.initDataTracker(builder)
        builder.add(BABY, false)
    }

    override fun initGoals() {
        super.initGoals()
        this.goalSelector.add(4, HoeAttackGoal(this, 1.0, 15.0F))
    }

    override fun initEquipment(random: Random?, localDifficulty: LocalDifficulty?) {
        this.equipStack(EquipmentSlot.MAINHAND, ItemStack(Items.GOLDEN_HOE))
    }

    override fun tickRiding() {
        super.tickRiding()
        val vehicle = this.controllingVehicle
        if (vehicle is PathAwareEntity) {
            this.bodyYaw = vehicle.bodyYaw
        }
        if(vehicle is HedgeSpiderEntity || vehicle is SwarmSpiderEntity) {
            if(!dataTracker.get(BABY)) {
                dataTracker.set(BABY, true)
            }
        }
    }

    override fun canUseRangedWeapon(weapon: RangedWeaponItem?): Boolean {
        return true
    }

    override fun getPreferredWeapons(): TagKey<Item> {
        return TFItemTags.SKELETON_DRUID_PREFERRED_WEAPON
    }

    override fun shootAt(target: LivingEntity, pullProgress: Float) {

        val handStack = this.getStackInHand(ProjectileUtil.getHandPossiblyHolding(this, Items.GOLDEN_HOE))
        if (!handStack.isOf(Items.GOLDEN_HOE) || this.world !is ServerWorld) {
            return
        }

        val serverWorld = this.world as ServerWorld
        val projectileStack = ItemStack.EMPTY

        val bolt = createBoltProjectile(projectileStack, pullProgress, handStack)

        val dx = target.x - this.x
        val dy = target.getBodyY(1.0 / 3.0) - bolt.y
        val dz = target.z - this.z
        val horizontalDistance = sqrt(dx * dx + dz * dz)

        val velocity = 1.6F
        val inaccuracy = (14.0F - serverWorld.difficulty.id * 4.0F) * 0.75F

        val success = ProjectileEntity.spawnWithVelocity(
            bolt, serverWorld, projectileStack,
            dx, dy + horizontalDistance * 0.2F, dz,
            velocity, inaccuracy
        )
        this.playSound(SoundEvents.ENTITY_SKELETON_SHOOT, 1.0f, 1.0f / (this.random.nextFloat() * 0.4f + 0.8f))
    }

    fun createBoltProjectile(stack: ItemStack, pullProgress: Float, shotFrom: ItemStack): NatureBolt {
        val bolt = NatureBolt(TFEntities.NATURE_BOLT, world)

        bolt.setPos(this.x, this.getEyeY() - 0.1, this.z)

        bolt.owner = this
        bolt.pickupType = PersistentProjectileEntity.PickupPermission.DISALLOWED

        bolt.applyDamageModifier(pullProgress)

        return bolt
    }

    fun getChild() : Boolean {return dataTracker.get(BABY)}

    companion object {
        private var BABY: TrackedData<Boolean> = DataTracker.registerData(SkeletonDruidEntity::class.java, TrackedDataHandlerRegistry.BOOLEAN)

        fun createSkeletonDruidAttributes() : DefaultAttributeContainer.Builder{
            return createHostileAttributes().add(EntityAttributes.MOVEMENT_SPEED, 0.25)
        }
    }
}