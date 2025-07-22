package autumn.twilightforest.init.entity.client.maze_slime

import autumn.twilightforest.TwilightForest
import net.minecraft.client.render.RenderLayer
import net.minecraft.client.render.VertexConsumer
import net.minecraft.client.render.VertexConsumerProvider
import net.minecraft.client.render.entity.LivingEntityRenderer
import net.minecraft.client.render.entity.feature.FeatureRenderer
import net.minecraft.client.render.entity.feature.FeatureRendererContext
import net.minecraft.client.render.entity.model.EntityModelLayers
import net.minecraft.client.render.entity.model.LoadedEntityModels
import net.minecraft.client.render.entity.model.SlimeEntityModel
import net.minecraft.client.render.entity.state.SlimeEntityRenderState
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.util.Identifier

class MazeSlimeOverlayFeatureRenderer(context: FeatureRendererContext<SlimeEntityRenderState, SlimeEntityModel>, loader: LoadedEntityModels) : FeatureRenderer<SlimeEntityRenderState, SlimeEntityModel>(context) {
    private val model: SlimeEntityModel = SlimeEntityModel(loader.getModelPart(EntityModelLayers.SLIME_OUTER))

    override fun render(matrixStack: MatrixStack, vertexConsumerProvider: VertexConsumerProvider, i: Int, slimeEntityRenderState: SlimeEntityRenderState, f: Float, g: Float) {
        val bl = slimeEntityRenderState.hasOutline && slimeEntityRenderState.invisible
        if (!slimeEntityRenderState.invisible || bl) {
            val vertexConsumer: VertexConsumer
            if(bl) {
                vertexConsumer = vertexConsumerProvider.getBuffer(RenderLayer.getOutline(Identifier.of(TwilightForest.MOD_ID, "textures/entity/maze_slime/maze_slime.png")))
            } else {
                vertexConsumer = vertexConsumerProvider.getBuffer(RenderLayer.getEntityTranslucent(Identifier.of(TwilightForest.MOD_ID, "textures/entity/maze_slime/maze_slime.png")))
            }

            this.model.setAngles(slimeEntityRenderState)
            this.model.render(matrixStack, vertexConsumer, i, LivingEntityRenderer.getOverlay(slimeEntityRenderState, 0.0F))
        }
    }
}