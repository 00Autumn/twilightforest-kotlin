package autumn.twilightforest.init.entity.client.winter_wolf

import autumn.twilightforest.TwilightForest
import autumn.twilightforest.init.entity.vanilla.winter_wolf.WinterWolfEntity
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

class WinterWolfRenderer(context: EntityRendererFactory.Context) : AgeableMobEntityRenderer<WinterWolfEntity, WolfEntityRenderState, WolfEntityModel>(context, WolfEntityModel(context.getPart(EntityModelLayers.WOLF)), WolfEntityModel(context.getPart(EntityModelLayers.WOLF_BABY)), 0.5F) {

    init {
        addFeature(WolfArmorFeatureRenderer(this, context.entityModels, context.equipmentRenderer))
        addFeature(WolfCollarFeatureRenderer(this))
    }

    override fun render(livingEntityRenderState: WolfEntityRenderState?, matrixStack: MatrixStack?, vertexConsumerProvider: VertexConsumerProvider?, i: Int) {
        matrixStack?.scale(2.0F, 2.0F, 2.0F)
        super.render(livingEntityRenderState, matrixStack, vertexConsumerProvider, i)
    }

    override fun getMixColor(state: WolfEntityRenderState): Int {
        val brightness = state.furWetBrightnessMultiplier
        return if (brightness == 1.0F) -1 else ColorHelper.fromFloats(1.0F, brightness, brightness, brightness)
    }

    override fun getTexture(state: WolfEntityRenderState?): Identifier {
        return Identifier.of(TwilightForest.MOD_ID, "textures/entity/winter_wolf/winter_wolf.png")
    }

    override fun createRenderState(): WolfEntityRenderState {
        return WolfEntityRenderState()
    }

    override fun updateRenderState(
        entity: WinterWolfEntity,
        state: WolfEntityRenderState,
        tickDelta: Float
    ) {
        super.updateRenderState(entity, state, tickDelta)
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