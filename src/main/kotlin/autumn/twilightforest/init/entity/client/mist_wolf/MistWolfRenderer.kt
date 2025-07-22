package autumn.twilightforest.init.entity.client.mist_wolf

import autumn.twilightforest.TwilightForest
import autumn.twilightforest.init.entity.vanilla.mist_wolf.MistWolfEntity
import net.minecraft.client.render.RenderLayer
import net.minecraft.client.render.VertexConsumerProvider
import net.minecraft.client.render.entity.AgeableMobEntityRenderer
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.feature.WolfArmorFeatureRenderer
import net.minecraft.client.render.entity.feature.WolfCollarFeatureRenderer
import net.minecraft.client.render.entity.model.EntityModelLayers
import net.minecraft.client.render.entity.model.WolfEntityModel
import net.minecraft.client.render.entity.state.WolfEntityRenderState
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.util.Identifier
import net.minecraft.util.math.ColorHelper

class MistWolfRenderer(context: EntityRendererFactory.Context) : AgeableMobEntityRenderer<MistWolfEntity, WolfEntityRenderState, WolfEntityModel>(context, WolfEntityModel(context.getPart(EntityModelLayers.WOLF)), WolfEntityModel(context.getPart(EntityModelLayers.WOLF_BABY)), 0.5F) {

    init {
        addFeature(WolfArmorFeatureRenderer(this, context.entityModels, context.equipmentRenderer))
        addFeature(WolfCollarFeatureRenderer(this))
    }

    override fun render(state: WolfEntityRenderState?, matrices: MatrixStack?, vertexConsumers: VertexConsumerProvider?, light: Int) {
        matrices?.scale(2.0F, 2.0F, 2.0F)
        super.render(state, matrices, vertexConsumers, light)
    }

    override fun getRenderLayer(state: WolfEntityRenderState?, showBody: Boolean, translucent: Boolean, showOutline: Boolean): RenderLayer? {
        val texture = getTexture(state)
        return RenderLayer.getEntityTranslucent(texture)
    }

    override fun getMixColor(state: WolfEntityRenderState): Int {
        val brightness = (state as? MistWolfRenderState)?.lightLevel ?: 1.0F
        val invBrightness = (1.0F - brightness).coerceIn(0.0F, 1.0F)
        val alpha = (invBrightness * 0.7F + 0.3F).coerceAtMost(1.0F)  // between 0.3 and 1.0 for subtle transparency
        val rgb = 1.0F

        return ColorHelper.fromFloats(alpha, rgb, rgb, rgb)
    }

    override fun getTexture(state: WolfEntityRenderState?): Identifier {
        return Identifier.of(TwilightForest.MOD_ID, "textures/entity/mist_wolf/mist_wolf.png")
    }

    override fun createRenderState(): WolfEntityRenderState {
        return MistWolfRenderState()
    }

    override fun updateRenderState(
        entity: MistWolfEntity,
        state: WolfEntityRenderState,
        tickDelta: Float
    ) {
        super.updateRenderState(entity, state, tickDelta)
        if (state is MistWolfRenderState) {
            state.lightLevel = entity.world.getLightLevel(entity.blockPos).toFloat() / 15.0F
        }

        state.angerTime = entity.hasAngerTime()
        state.inSittingPose = entity.isInSittingPose
        state.tailAngle = entity.tailAngle
        state.begAnimationProgress = entity.getBegAnimationProgress(tickDelta)
        state.shakeProgress = entity.getShakeProgress(tickDelta)
        state.furWetBrightnessMultiplier = entity.getFurWetBrightnessMultiplier(tickDelta)
        state.collarColor = if (entity.isTamed) entity.collarColor else null
        state.bodyArmor = entity.bodyArmor.copy()
    }
}