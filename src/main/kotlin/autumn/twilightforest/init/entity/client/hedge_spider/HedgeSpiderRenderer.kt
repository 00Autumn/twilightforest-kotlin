package autumn.twilightforest.init.entity.client.hedge_spider

import autumn.twilightforest.TwilightForest
import autumn.twilightforest.init.entity.vanilla.hedge_spider.HedgeSpiderEntity
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.MobEntityRenderer
import net.minecraft.client.render.entity.feature.SpiderEyesFeatureRenderer
import net.minecraft.client.render.entity.model.EntityModelLayer
import net.minecraft.client.render.entity.model.EntityModelLayers
import net.minecraft.client.render.entity.model.SpiderEntityModel
import net.minecraft.client.render.entity.state.LivingEntityRenderState
import net.minecraft.util.Identifier

class HedgeSpiderRenderer(context: EntityRendererFactory.Context, layer: EntityModelLayer = EntityModelLayers.SPIDER) : MobEntityRenderer<HedgeSpiderEntity, LivingEntityRenderState, SpiderEntityModel>(context, SpiderEntityModel(context.getPart(layer)), 0.8F) {

    init {
        addFeature(SpiderEyesFeatureRenderer(this))
    }

    override fun getLyingPositionRotationDegrees(): Float {
        return 180.0f
    }

    override fun getTexture(state: LivingEntityRenderState): Identifier {
        return Identifier.of(TwilightForest.MOD_ID, "textures/entity/hedge_spider/hedge_spider.png")
    }

    override fun createRenderState(): LivingEntityRenderState {
        return LivingEntityRenderState()
    }

    override fun updateRenderState(entity: HedgeSpiderEntity, state: LivingEntityRenderState, tickDelta: Float) {
        super.updateRenderState(entity, state, tickDelta)
    }
}