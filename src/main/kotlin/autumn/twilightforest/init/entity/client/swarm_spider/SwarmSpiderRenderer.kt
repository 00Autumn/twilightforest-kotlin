package autumn.twilightforest.init.entity.client.swarm_spider

import autumn.twilightforest.TwilightForest
import autumn.twilightforest.init.entity.vanilla.swarm_spider.SwarmSpiderEntity
import net.minecraft.client.render.VertexConsumerProvider
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.MobEntityRenderer
import net.minecraft.client.render.entity.feature.SpiderEyesFeatureRenderer
import net.minecraft.client.render.entity.model.EntityModelLayer
import net.minecraft.client.render.entity.model.EntityModelLayers
import net.minecraft.client.render.entity.model.SpiderEntityModel
import net.minecraft.client.render.entity.state.LivingEntityRenderState
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.util.Identifier

class SwarmSpiderRenderer(context: EntityRendererFactory.Context, layer: EntityModelLayer = EntityModelLayers.SPIDER) : MobEntityRenderer<SwarmSpiderEntity, LivingEntityRenderState, SpiderEntityModel>(context, SpiderEntityModel(context.getPart(layer)), 0.8F) {

    init {
        addFeature(SpiderEyesFeatureRenderer(this))
    }

    override fun getLyingPositionRotationDegrees(): Float {
        return 180.0f
    }

    override fun render(livingEntityRenderState: LivingEntityRenderState?, matrixStack: MatrixStack?, vertexConsumerProvider: VertexConsumerProvider?, i: Int) {
        matrixStack?.scale(0.5F, 0.5F, 0.5F)
        super.render(livingEntityRenderState, matrixStack, vertexConsumerProvider, i)
    }

    override fun getTexture(state: LivingEntityRenderState): Identifier {
        return Identifier.of(TwilightForest.MOD_ID, "textures/entity/swarm_spider/swarm_spider.png")
    }

    override fun createRenderState(): LivingEntityRenderState {
        return LivingEntityRenderState()
    }

    override fun updateRenderState(entity: SwarmSpiderEntity, state: LivingEntityRenderState, tickDelta: Float) {
        super.updateRenderState(entity, state, tickDelta)
    }
}