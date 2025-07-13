package autumn.twilightforest.init.entity.client.dwarf_rabbit

import autumn.twilightforest.init.entity.custom.dwarf_rabbit.DwarfRabbitVariant
import net.minecraft.client.render.entity.state.LivingEntityRenderState
import net.minecraft.entity.AnimationState

class DwarfRabbitRenderState : LivingEntityRenderState() {
    val idleAnimationState = AnimationState()
    var variant: DwarfRabbitVariant? = null
}