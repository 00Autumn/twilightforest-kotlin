package autumn.twilightforest.init.entity.client.tiny_bird

import autumn.twilightforest.init.entity.custom.tiny_bird.TinyBirdVariant
import net.minecraft.client.render.entity.state.LivingEntityRenderState
import net.minecraft.entity.AnimationState

class TinyBirdRenderState : LivingEntityRenderState() {
    var variant: TinyBirdVariant? = null
    val flyAnimationState = AnimationState()
}