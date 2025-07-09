package autumn.twilightforest.init.entity.custom

import autumn.twilightforest.init.entity.TFEntities
import net.minecraft.entity.EntityData
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnReason
import net.minecraft.entity.ai.goal.*
import net.minecraft.entity.attribute.DefaultAttributeContainer
import net.minecraft.entity.attribute.EntityAttributes
import net.minecraft.entity.data.DataTracker
import net.minecraft.entity.data.TrackedData
import net.minecraft.entity.data.TrackedDataHandlerRegistry
import net.minecraft.entity.mob.HostileEntity
import net.minecraft.entity.mob.MobEntity
import net.minecraft.entity.passive.AnimalEntity
import net.minecraft.entity.passive.PassiveEntity
import net.minecraft.entity.passive.WolfEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.recipe.Ingredient
import net.minecraft.server.world.ServerWorld
import net.minecraft.storage.ReadView
import net.minecraft.storage.WriteView
import net.minecraft.util.Util
import net.minecraft.world.LocalDifficulty
import net.minecraft.world.ServerWorldAccess
import net.minecraft.world.World


class DwarfRabbitEntity(entityType: EntityType<out AnimalEntity>, world: World) : AnimalEntity(entityType, world) {

    override fun initGoals() {
        this.goalSelector.add(0, SwimGoal(this))

        this.goalSelector.add(1, EscapeDangerGoal(this, 2.2))
        this.goalSelector.add(1, AnimalMateGoal(this, 1.15))
        this.goalSelector.add(2, TemptGoal(this, 1.25, Ingredient.ofItems(Items.CARROT), false))

        this.goalSelector.add(3, FollowParentGoal(this, 1.1))
        this.goalSelector.add(3, FleeEntityGoal(this, WolfEntity::class.java, 10.0F, 2.2, 2.2))
        this.goalSelector.add(3, FleeEntityGoal(this, PlayerEntity::class.java, 8.0F, 2.2, 2.2))
        this.goalSelector.add(3, FleeEntityGoal(this, HostileEntity::class.java, 4.0F, 2.2, 2.2))

        this.goalSelector.add(4, WanderAroundFarGoal(this, 1.0))
        this.goalSelector.add(5, LookAtEntityGoal(this, PlayerEntity::class.java, 4.0f))
        this.goalSelector.add(6, LookAroundGoal(this))
    }

    override fun isBreedingItem(stack: ItemStack?): Boolean {
        return stack?.isOf(Items.CARROT) == true
    }

    override fun createChild(world: ServerWorld?, entity: PassiveEntity?): PassiveEntity? {
       var baby = TFEntities.DWARF_RABBIT.create(world, SpawnReason.BREEDING)
        var variant = Util.getRandom(DwarfRabbitVariant.values(), this.random)
        baby?.setVariant(variant)
        return baby
    }

    override fun initDataTracker(builder: DataTracker.Builder) {
        super.initDataTracker(builder)
        builder.add(DATA_ID_TYPE_VARIANT, 0)
    }

    fun getVariant(): DwarfRabbitVariant {
        return DwarfRabbitVariant.byId(typeVariant and 255)
    }

    private val typeVariant: Int
        get() = dataTracker.get(DATA_ID_TYPE_VARIANT)

    private fun setVariant(variant: DwarfRabbitVariant) {
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

    override fun initialize(
        world: ServerWorldAccess,
        difficulty: LocalDifficulty,
        spawnReason: SpawnReason,
        entityData: EntityData?
    ): EntityData? {
        val variant = Util.getRandom(DwarfRabbitVariant.values(), random)
        setVariant(variant)
        return super.initialize(world, difficulty, spawnReason, entityData)
    }

    companion object {
        val DATA_ID_TYPE_VARIANT: TrackedData<Int> = DataTracker.registerData(
            DwarfRabbitEntity::class.java,
            TrackedDataHandlerRegistry.INTEGER
        )

        fun createAttributes() : DefaultAttributeContainer.Builder {
            return MobEntity.createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 2.0)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.35)
                .add(EntityAttributes.ATTACK_DAMAGE, 0.0)
                .add(EntityAttributes.FOLLOW_RANGE, 20.0)
                .add(EntityAttributes.TEMPT_RANGE, 12.0)
        }
    }
}