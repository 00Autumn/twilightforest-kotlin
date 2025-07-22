package autumn.twilightforest.init.entity.vanilla.knight_phantom

import autumn.twilightforest.init.item.TFItems
import autumn.twilightforest.util.tag.TFItemTags
import net.minecraft.entity.AnimationState
import net.minecraft.entity.EntityType
import net.minecraft.entity.EquipmentSlot
import net.minecraft.entity.ai.goal.*
import net.minecraft.entity.attribute.DefaultAttributeContainer
import net.minecraft.entity.attribute.EntityAttributes
import net.minecraft.entity.mob.SkeletonEntity
import net.minecraft.entity.passive.IronGolemEntity
import net.minecraft.entity.passive.WolfEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.RangedWeaponItem
import net.minecraft.registry.tag.TagKey
import net.minecraft.util.math.random.Random
import net.minecraft.world.LocalDifficulty
import net.minecraft.world.World

class KnightPhantomEntity(entityType: EntityType<out SkeletonEntity>, world: World) : SkeletonEntity(entityType, world) {

    var floatAnimationState: AnimationState = AnimationState()
    private var floatAnimationTimeout = 80

    override fun getGravity(): Double {
        return 0.06
    }

    private fun setupAnimationStates() {
        if(this.floatAnimationTimeout <= 0) {
            floatAnimationTimeout = 80
            this.floatAnimationState.start(this.age)
        } else {
            --this.floatAnimationTimeout
        }
    }

    override fun tick() {
        super.tick()

        if(this.world.isClient) {
            this.setupAnimationStates()
        }
    }

    override fun initGoals() {
        this.goalSelector.add(2, AvoidSunlightGoal(this))
        this.goalSelector.add(3, EscapeSunlightGoal(this, 1.0))
        this.goalSelector.add(3, FleeEntityGoal(this, WolfEntity::class.java, 6.0f, 1.0, 1.2))
        this.goalSelector.add(4, MeleeAttackGoal(this, 1.2, false))
        this.goalSelector.add(6, LookAtEntityGoal(this, PlayerEntity::class.java, 8.0f))
        this.goalSelector.add(6, LookAroundGoal(this))
        this.targetSelector.add(1, RevengeGoal(this))
        this.targetSelector.add(2, ActiveTargetGoal(this, PlayerEntity::class.java, true))
        this.targetSelector.add(3, ActiveTargetGoal(this, IronGolemEntity::class.java, true))
    }

    override fun initEquipment(random: Random?, localDifficulty: LocalDifficulty?) {
        this.equipStack(EquipmentSlot.MAINHAND, ItemStack(TFItems.KNIGHTMETAL_SWORD))
        this.equipStack(EquipmentSlot.HEAD, ItemStack(TFItems.PHANTOM_HELMET))
        this.equipStack(EquipmentSlot.CHEST, ItemStack(TFItems.PHANTOM_CHESTPLATE))
    }

    override fun canUseRangedWeapon(weapon: RangedWeaponItem?): Boolean {
        return false
    }

    override fun getPreferredWeapons(): TagKey<Item> {
        return TFItemTags.SKELETON_DRUID_PREFERRED_WEAPON
    }

    companion object {
        fun creatKnightPhantomAttributes() : DefaultAttributeContainer.Builder {
            return createHostileAttributes().add(EntityAttributes.MOVEMENT_SPEED, 0.25)
        }
    }
}