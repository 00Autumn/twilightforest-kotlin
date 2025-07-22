package autumn.twilightforest.init.entity.client.knight_phantom

import net.minecraft.client.render.entity.state.SkeletonEntityRenderState
import net.minecraft.entity.AnimationState

class KnightPhantomRenderState : SkeletonEntityRenderState() {
    var isReal: Boolean = true
    var holdingKnightmetalSword: Boolean = false
    var floatAnimationState = AnimationState()
}