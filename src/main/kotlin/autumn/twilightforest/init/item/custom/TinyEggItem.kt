package autumn.twilightforest.init.item.custom

import autumn.twilightforest.init.entity.custom.tiny_bird.TinyEggEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.projectile.ProjectileEntity
import net.minecraft.entity.projectile.thrown.EggEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.ProjectileItem
import net.minecraft.server.world.ServerWorld
import net.minecraft.sound.SoundCategory
import net.minecraft.sound.SoundEvents
import net.minecraft.stat.Stats
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.math.Direction
import net.minecraft.util.math.Position
import net.minecraft.world.World

class TinyEggItem(settings: Settings) : Item(settings), ProjectileItem{
    val POWER = 1.5F

    override fun use(world: World, user: PlayerEntity, hand: Hand): ActionResult {
        var itemStack = user.getStackInHand(hand)
        world.playSound(
            null, user.x, user.y, user.z, SoundEvents.ENTITY_EGG_THROW, SoundCategory.PLAYERS, 0.5F, 0.4F / (world.random.nextFloat() * 0.4F + 0.8F)
        )
        if(world is ServerWorld) {
            println("SPAWN WAS CALLED")
            ProjectileEntity.spawnWithVelocity(::TinyEggEntity, world, itemStack, user, 0.0f, 1.5f, 1.0f)
        }
        user.incrementStat(Stats.USED.getOrCreateStat(this))
        itemStack.decrementUnlessCreative(1, user)
        return ActionResult.SUCCESS
    }

    override fun createEntity(
        world: World,
        pos: Position,
        stack: ItemStack,
        direction: Direction?
    ): ProjectileEntity {
        println("CREATE WAS CALLED")
        return TinyEggEntity(world, pos.x, pos.y, pos.z, stack)
    }
}