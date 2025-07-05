package autumn.twilightforest.init.item.custom

import net.minecraft.entity.LivingEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack

class FieryItem(settings: Item.Settings) : Item(settings) {
    override fun postHit(stack: ItemStack, target: LivingEntity, attacker: LivingEntity) {
        super.postHit(stack, target, attacker)

        if (!target.world.isClient && !target.isFireImmune) {
            target.setOnFireFor(15.0F)
        }
    }
}