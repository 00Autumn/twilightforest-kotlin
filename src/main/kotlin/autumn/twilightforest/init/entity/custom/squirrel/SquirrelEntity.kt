package autumn.twilightforest.init.entity.custom.squirrel

import autumn.twilightforest.init.entity.TFEntities
import net.minecraft.entity.AnimationState
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnReason
import net.minecraft.entity.ai.goal.AnimalMateGoal
import net.minecraft.entity.ai.goal.EscapeDangerGoal
import net.minecraft.entity.ai.goal.FleeEntityGoal
import net.minecraft.entity.ai.goal.FollowParentGoal
import net.minecraft.entity.ai.goal.LookAroundGoal
import net.minecraft.entity.ai.goal.LookAtEntityGoal
import net.minecraft.entity.ai.goal.SwimGoal
import net.minecraft.entity.ai.goal.TemptGoal
import net.minecraft.entity.ai.goal.WanderAroundFarGoal
import net.minecraft.entity.attribute.DefaultAttributeContainer
import net.minecraft.entity.attribute.EntityAttributes
import net.minecraft.entity.mob.HostileEntity
import net.minecraft.entity.passive.AnimalEntity
import net.minecraft.entity.passive.PassiveEntity
import net.minecraft.entity.passive.WolfEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.recipe.Ingredient
import net.minecraft.registry.tag.ItemTags
import net.minecraft.server.world.ServerWorld
import net.minecraft.world.World

class SquirrelEntity(entityType: EntityType<out AnimalEntity>, world: World) : AnimalEntity(entityType, world) {
    val idleAnimationState: AnimationState = AnimationState()
    private var idleAnimationTimeout = 50

    override fun initGoals() {
        this.goalSelector.add(0, SwimGoal(this))
        this.goalSelector.add(1, EscapeDangerGoal(this, 2.2))
        this.goalSelector.add(1, AnimalMateGoal(this, 1.15))
        this.goalSelector.add(2, TemptGoal(this, 1.25, Ingredient.ofItems(Items.WHEAT_SEEDS, Items.MELON_SEEDS, Items.PUMPKIN_SEEDS, Items.BEETROOT_SEEDS), false))
        this.goalSelector.add(3, FollowParentGoal(this, 1.1))
        this.goalSelector.add(3, FleeEntityGoal(this, WolfEntity::class.java, 10.0F, 2.2, 2.2))
        this.goalSelector.add(3, FleeEntityGoal(this, PlayerEntity::class.java, 8.0F, 2.2, 2.2))
        this.goalSelector.add(3, FleeEntityGoal(this, HostileEntity::class.java, 4.0F, 2.2, 2.2))
        this.goalSelector.add(4, WanderAroundFarGoal(this, 1.0))
        this.goalSelector.add(5, LookAtEntityGoal(this, PlayerEntity::class.java, 4.0f))
        this.goalSelector.add(6, LookAroundGoal(this))
    }

    override fun isBreedingItem(stack: ItemStack): Boolean {
        return stack.isIn(ItemTags.CHICKEN_FOOD)
    }

    private fun setupAnimationStates() {
        if(this.idleAnimationTimeout <= 0) {
            idleAnimationTimeout = random.nextInt(20) + 50
            this.idleAnimationState.start(this.age)
        } else {
            --this.idleAnimationTimeout
        }
    }

    override fun tick() {
        super.tick()

        if(this.world.isClient) {
            this.setupAnimationStates()
        }
    }

    override fun createChild(world: ServerWorld, entity: PassiveEntity): PassiveEntity? {
        return TFEntities.SQUIRREL.create(world, SpawnReason.BREEDING)
    }

    companion object {
        fun createAttributes() : DefaultAttributeContainer.Builder {
            return createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 2.0)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.35)
                .add(EntityAttributes.ATTACK_DAMAGE, 0.0)
                .add(EntityAttributes.FOLLOW_RANGE, 20.0)
                .add(EntityAttributes.TEMPT_RANGE, 12.0)
        }
    }
}