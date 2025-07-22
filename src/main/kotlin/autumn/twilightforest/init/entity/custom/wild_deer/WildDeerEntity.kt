package autumn.twilightforest.init.entity.custom.wild_deer

import autumn.twilightforest.init.entity.TFEntities
import net.minecraft.entity.AnimationState
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnReason
import net.minecraft.entity.ai.goal.*
import net.minecraft.entity.attribute.DefaultAttributeContainer
import net.minecraft.entity.attribute.EntityAttributes
import net.minecraft.entity.passive.AnimalEntity
import net.minecraft.entity.passive.PassiveEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.registry.tag.ItemTags
import net.minecraft.server.world.ServerWorld
import net.minecraft.world.World
import java.util.function.Predicate

class WildDeerEntity(entityType: EntityType<out AnimalEntity>, world: World) : AnimalEntity(entityType, world) {
    val eatAnimationState: AnimationState = AnimationState()
    private var eatAnimationTimeout = 400

    override fun initGoals() {
        this.goalSelector.add(0, SwimGoal(this))
        this.goalSelector.add(1, EscapeDangerGoal(this, 1.5))
        this.goalSelector.add(2, AnimalMateGoal(this, 1.0))
        this.goalSelector.add(3, TemptGoal(this, 1.25, Predicate { stack: ItemStack? -> stack!!.isIn(ItemTags.COW_FOOD) }, false))
        this.goalSelector.add(3, FleeEntityGoal(this, PlayerEntity::class.java, 8.0F, 1.5, 1.5))
        this.goalSelector.add(4, FollowParentGoal(this, 1.25))
        this.goalSelector.add(5, WanderAroundFarGoal(this, 1.0))
        this.goalSelector.add(7, LookAroundGoal(this))
    }

    override fun isBreedingItem(stack: ItemStack): Boolean {
        return stack.isIn(ItemTags.COW_FOOD)
    }

    override fun createChild(world: ServerWorld, entity: PassiveEntity): PassiveEntity? {
        return TFEntities.WILD_DEER.create(world, SpawnReason.BREEDING)
    }

    private fun setupAnimationStates() {
        if (this.velocity.horizontalLengthSquared() > 1.0E-6) {
            eatAnimationState.stop()
            return
        }

        if (eatAnimationTimeout <= 0) {
            eatAnimationTimeout = random.nextInt(1200) + 300
            eatAnimationState.start(this.age)
        } else {
            eatAnimationTimeout--
        }
    }

    override fun tick() {
        super.tick()

        if(this.world.isClient) {
            this.setupAnimationStates()
        }
    }

    companion object {
        fun createAttributes(): DefaultAttributeContainer.Builder {
            return createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 10.0)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.25)
                .add(EntityAttributes.ATTACK_DAMAGE, 0.0)
                .add(EntityAttributes.FOLLOW_RANGE, 20.0)
                .add(EntityAttributes.TEMPT_RANGE, 12.0)
        }
    }
}