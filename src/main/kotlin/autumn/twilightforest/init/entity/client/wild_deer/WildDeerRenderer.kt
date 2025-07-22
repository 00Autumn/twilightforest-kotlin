package autumn.twilightforest.init.entity.client.wild_deer

import autumn.twilightforest.TwilightForest
import autumn.twilightforest.init.entity.custom.wild_deer.WildDeerEntity
import net.minecraft.client.render.VertexConsumerProvider
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.MobEntityRenderer
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.util.Identifier

class WildDeerRenderer(context: EntityRendererFactory.Context) : MobEntityRenderer<WildDeerEntity, WildDeerRenderState, WildDeerModel>(context, WildDeerModel(context.getPart(WildDeerModel.WILD_DEER)), 0.5F) {
    override fun getTexture(state: WildDeerRenderState?): Identifier? {
        return Identifier.of(TwilightForest.MOD_ID, "textures/entity/wild_deer/wild_deer.png")
    }

    override fun render(livingEntityRenderState: WildDeerRenderState?, matrixStack: MatrixStack?, vertexConsumerProvider: VertexConsumerProvider?, i: Int) {
        if(livingEntityRenderState?.baby == true) {
            matrixStack?.scale(0.5F, 0.5F, 0.5F)
        } else {
            matrixStack?.scale(1.0F, 1.0F, 1.0F)
        }
        super.render(livingEntityRenderState, matrixStack, vertexConsumerProvider, i)
    }

    override fun createRenderState(): WildDeerRenderState {
        return WildDeerRenderState()
    }

    override fun updateRenderState(entity: WildDeerEntity, state: WildDeerRenderState, tickDelta: Float) {
        super.updateRenderState(entity, state, tickDelta)
        state.eatAnimationState.copyFrom(entity.eatAnimationState)
    }
}