package autumn.twilightforest.init.entity.vanilla.skeleton_druid

import net.minecraft.entity.ai.RangedAttackMob
import net.minecraft.entity.ai.goal.Goal
import net.minecraft.entity.mob.HostileEntity
import net.minecraft.item.Items
import java.util.EnumSet

class HoeAttackGoal<T>(
    private val actor: T,
    private val speed: Double,
    range: Float
) : Goal() where T : HostileEntity, T : RangedAttackMob {

    private val squaredRange = range * range
    private var cooldown = 0
    private var targetSeeingTicker = 0
    private var combatTicks = -1

    init {
        controls = EnumSet.of(Control.MOVE, Control.LOOK)
    }

    override fun canStart(): Boolean {
        return actor.target != null && isHoldingHoe()
    }

    override fun shouldContinue(): Boolean {
        return (canStart() || !actor.navigation.isIdle) && isHoldingHoe()
    }

    override fun start() {
        actor.isAttacking = true
        cooldown = 0
    }

    override fun stop() {
        actor.isAttacking = false
        targetSeeingTicker = 0
        cooldown = 0
        combatTicks = -1
    }

    override fun shouldRunEveryTick(): Boolean = true

    override fun tick() {
        val target = actor.target ?: return
        val distSq = actor.squaredDistanceTo(target.x, target.y, target.z)
        val canSee = actor.visibilityCache.canSee(target)

        targetSeeingTicker = if (canSee) targetSeeingTicker + 1 else targetSeeingTicker - 1

        if (distSq <= squaredRange && targetSeeingTicker >= 20) {
            actor.navigation.stop()
        } else {
            actor.navigation.startMovingTo(target, speed)
        }

        actor.lookControl.lookAt(target, 30.0f, 30.0f)

        if (cooldown > 0) {
            cooldown--
        } else if (canSee && distSq <= squaredRange) {
            actor.shootAt(target, 1.0f)
            cooldown = 40
        }
    }

    private fun isHoldingHoe(): Boolean {
        return actor.isHolding(Items.GOLDEN_HOE)
    }
}