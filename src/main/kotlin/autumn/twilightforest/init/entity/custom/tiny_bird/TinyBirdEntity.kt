package autumn.twilightforest.init.entity.custom.tiny_bird

import autumn.twilightforest.init.entity.TFEntities
import autumn.twilightforest.util.TFLootTables
import net.minecraft.entity.AnimationState
import net.minecraft.entity.EntityData
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnReason
import net.minecraft.entity.ai.goal.*
import net.minecraft.entity.attribute.DefaultAttributeContainer
import net.minecraft.entity.attribute.EntityAttributes
import net.minecraft.entity.data.DataTracker
import net.minecraft.entity.data.TrackedData
import net.minecraft.entity.data.TrackedDataHandlerRegistry
import net.minecraft.entity.passive.AnimalEntity
import net.minecraft.entity.passive.PassiveEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.registry.tag.ItemTags
import net.minecraft.server.world.ServerWorld
import net.minecraft.sound.SoundEvents
import net.minecraft.storage.ReadView
import net.minecraft.storage.WriteView
import net.minecraft.util.Util
import net.minecraft.world.LocalDifficulty
import net.minecraft.world.ServerWorldAccess
import net.minecraft.world.World
import net.minecraft.world.event.GameEvent
import java.util.function.Predicate

class TinyBirdEntity(entityType: EntityType<out AnimalEntity>, world: World) : AnimalEntity(entityType, world) {
    val flyAnimationState: AnimationState = AnimationState()
    private var eggLayTime: Int
    private var flyAnimationTimeout = 400

    init {
        eggLayTime = random.nextInt(6000) + 6000
    }

    override fun initGoals() {
        this.goalSelector.add(0, SwimGoal(this))
        this.goalSelector.add(1, EscapeDangerGoal(this, 1.4))
        this.goalSelector.add(2, AnimalMateGoal(this, 1.0))
        this.goalSelector.add(3, TemptGoal(this, 1.0, Predicate { stack: ItemStack? -> stack!!.isIn(ItemTags.CHICKEN_FOOD) }, false))
        this.goalSelector.add(4, FollowParentGoal(this, 1.1))
        this.goalSelector.add(5, WanderAroundFarGoal(this, 1.0))
        this.goalSelector.add(6, LookAtEntityGoal(this, PlayerEntity::class.java, 6.0f))
        this.goalSelector.add(7, LookAroundGoal(this))
    }

    override fun isBreedingItem(stack: ItemStack): Boolean {
        return stack.isIn(ItemTags.CHICKEN_FOOD)
    }

    private fun setupAnimationStates() {
        if(this.flyAnimationTimeout <= 0) {
            flyAnimationTimeout = random.nextInt(700) + 300
            this.flyAnimationState.start(this.age)
        } else {
            --this.flyAnimationTimeout
        }
    }

    override fun tick() {
        super.tick()

        if(this.world.isClient) {
            this.setupAnimationStates()
        }
    }

    override fun tickMovement() {
        super.tickMovement()
        val serverWorld = world as? ServerWorld
        if (serverWorld != null && isAlive && !isBaby && --eggLayTime <= 0) {
            if (forEachGiftedItem(serverWorld, TFLootTables.TINY_BIRD_LAY_GAMEPLAY, this::dropStack)) {
                playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0f, (random.nextFloat() - random.nextFloat()) * 0.2f + 1.0f)
                emitGameEvent(GameEvent.ENTITY_PLACE)
            }

            eggLayTime = random.nextInt(6000) + 6000
        }
    }

    override fun createChild(world: ServerWorld?, entity: PassiveEntity?): PassiveEntity? {
        var baby = TFEntities.TINY_BIRD.create(world, SpawnReason.BREEDING)
        var variant = Util.getRandom(TinyBirdVariant.values(), this.random)
        baby?.setVariant(variant)
        return baby
    }

    override fun initDataTracker(builder: DataTracker.Builder) {
        super.initDataTracker(builder)
        builder.add(DATA_ID_TYPE_VARIANT, 0)
    }

    fun getVariant(): TinyBirdVariant {
        return TinyBirdVariant.byId(typeVariant and 255)
    }

    private val typeVariant: Int
        get() = dataTracker.get(DATA_ID_TYPE_VARIANT)

    fun setVariant(variant: TinyBirdVariant) {
        dataTracker.set(DATA_ID_TYPE_VARIANT, variant.id and 255)
    }

    override fun writeData(view: WriteView) {
        super.writeData(view)
        view.putInt("Variant", typeVariant)
    }

    override fun readData(view: ReadView) {
        super.readData(view)
        dataTracker.set(DATA_ID_TYPE_VARIANT, view.getInt("Variant", 0))
    }

    override fun writeCustomData(view: WriteView) {
        super.writeCustomData(view)
        view.putInt("EggLayTime", eggLayTime)
    }

    override fun readCustomData(view: ReadView) {
        super.readCustomData(view)
        eggLayTime = view.getInt("EggLayTime", 0)
    }

    override fun initialize(
        world: ServerWorldAccess,
        difficulty: LocalDifficulty,
        spawnReason: SpawnReason,
        entityData: EntityData?
    ): EntityData? {
        val variant = Util.getRandom(TinyBirdVariant.values(), random)
        setVariant(variant)
        return super.initialize(world, difficulty, spawnReason, entityData)
    }

    companion object {
        val DATA_ID_TYPE_VARIANT: TrackedData<Int> = DataTracker.registerData(
            TinyBirdEntity::class.java,
            TrackedDataHandlerRegistry.INTEGER
        )

        fun createAttributes() : DefaultAttributeContainer.Builder {
            return createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 1.0)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.25)
                .add(EntityAttributes.ATTACK_DAMAGE, 0.0)
                .add(EntityAttributes.FOLLOW_RANGE, 20.0)
                .add(EntityAttributes.TEMPT_RANGE, 12.0)
        }
    }
}