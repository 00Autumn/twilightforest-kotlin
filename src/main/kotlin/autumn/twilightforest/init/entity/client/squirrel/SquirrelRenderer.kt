package autumn.twilightforest.init.entity.client.squirrel

import autumn.twilightforest.TwilightForest
import autumn.twilightforest.init.entity.custom.squirrel.SquirrelEntity
import net.minecraft.client.render.VertexConsumerProvider
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.MobEntityRenderer
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.util.Identifier

class SquirrelRenderer(context: EntityRendererFactory.Context) : MobEntityRenderer<SquirrelEntity, SquirrelRenderState, SquirrelModel>(context, SquirrelModel(context.getPart(SquirrelModel.SQUIRREL)), 0.25F) {
    override fun getTexture(state: SquirrelRenderState?): Identifier? {
        return Identifier.of(TwilightForest.MOD_ID, "textures/entity/squirrel/squirrel.png")
    }

    override fun render(livingEntityRenderState: SquirrelRenderState?, matrixStack: MatrixStack?, vertexConsumerProvider: VertexConsumerProvider?, i: Int) {
        if(livingEntityRenderState?.baby == true) {
            matrixStack?.scale(0.5F, 0.5F, 0.5F)
        } else {
            matrixStack?.scale(1.0F, 1.0F, 1.0F)
        }

        super.render(livingEntityRenderState, matrixStack, vertexConsumerProvider, i)
    }

    override fun createRenderState(): SquirrelRenderState {
        return SquirrelRenderState()
    }

    override fun updateRenderState(entity: SquirrelEntity, state: SquirrelRenderState, tickDelta: Float) {
        super.updateRenderState(entity, state, tickDelta)
        state.idleAnimationState.copyFrom(entity.idleAnimationState)
    }
}