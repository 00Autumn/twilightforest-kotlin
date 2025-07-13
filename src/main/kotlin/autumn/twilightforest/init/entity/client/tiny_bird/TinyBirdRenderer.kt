package autumn.twilightforest.init.entity.client.tiny_bird

import autumn.twilightforest.TwilightForest
import autumn.twilightforest.init.entity.custom.tiny_bird.TinyBirdEntity
import autumn.twilightforest.init.entity.custom.tiny_bird.TinyBirdVariant
import net.minecraft.client.render.VertexConsumerProvider
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.MobEntityRenderer
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.util.Identifier

class TinyBirdRenderer(context: EntityRendererFactory.Context) : MobEntityRenderer<TinyBirdEntity, TinyBirdRenderState, TinyBirdModel>(context, TinyBirdModel(context.getPart(TinyBirdModel.TINY_BIRD)), 0.125F) {
    override fun getTexture(state: TinyBirdRenderState): Identifier? {
        return LOCATION_BY_VARIANT[state.variant]
    }

    override fun render(livingEntityRenderState: TinyBirdRenderState?, matrixStack: MatrixStack?, vertexConsumerProvider: VertexConsumerProvider?, i: Int) {
        if(livingEntityRenderState?.baby == true) {
            matrixStack?.scale(0.5F, 0.5F, 0.5F)
        } else {
            matrixStack?.scale(1.0F, 1.0F, 1.0F)
        }

        super.render(livingEntityRenderState, matrixStack, vertexConsumerProvider, i)
    }

    override fun createRenderState(): TinyBirdRenderState {
        return TinyBirdRenderState()
    }

    override fun updateRenderState(entity: TinyBirdEntity, state: TinyBirdRenderState, tickDelta: Float) {
        super.updateRenderState(entity, state, tickDelta)
        state.flyAnimationState.copyFrom(entity.flyAnimationState)
        state.variant = entity.getVariant()
    }

    private val DEFAULT_TEXTURE = Identifier.of(TwilightForest.MOD_ID, "textures/entity/tiny_bird/tiny_bird_red.png")

    private val LOCATION_BY_VARIANT: Map<TinyBirdVariant, Identifier> =
        buildMap {
            put(TinyBirdVariant.RED, DEFAULT_TEXTURE)
            put(TinyBirdVariant.BLUE, Identifier.of(TwilightForest.MOD_ID, "textures/entity/tiny_bird/tiny_bird_blue.png"))
            put(TinyBirdVariant.GOLD, Identifier.of(TwilightForest.MOD_ID, "textures/entity/tiny_bird/tiny_bird_gold.png"))
            put(TinyBirdVariant.BROWN, Identifier.of(TwilightForest.MOD_ID, "textures/entity/tiny_bird/tiny_bird_brown.png"))
        }

}