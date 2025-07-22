package autumn.twilightforest.init.entity.client.maze_slime

import autumn.twilightforest.TwilightForest
import autumn.twilightforest.init.entity.vanilla.maze_slime.MazeSlimeEntity
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.MobEntityRenderer
import net.minecraft.client.render.entity.model.EntityModelLayers
import net.minecraft.client.render.entity.model.SlimeEntityModel
import net.minecraft.client.render.entity.state.SlimeEntityRenderState
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.util.Identifier
import net.minecraft.util.math.MathHelper

class MazeSlimeRenderer(context: EntityRendererFactory.Context) : MobEntityRenderer<MazeSlimeEntity, SlimeEntityRenderState, SlimeEntityModel>(context,
    SlimeEntityModel(context.getPart(EntityModelLayers.SLIME)), 0.25F) {

    init {
        addFeature(MazeSlimeOverlayFeatureRenderer(this, context.entityModels))
    }

    override fun getShadowRadius(state: SlimeEntityRenderState) : Float {
        return state.size * 0.25F
    }

    override fun scale(state: SlimeEntityRenderState, matrices: MatrixStack) {
        val f = 0.999F
        matrices.scale(0.999F, 0.999F, 0.999F)
        matrices.translate(0.0F, 0.001F, 0.0F)
        val g = state.size
        val h = state.stretch / (g * 0.5F + 1.0F)
        val i = 1.0F / (h + 1.0F)
        matrices.scale(i * g, 1.0F / i * g, i * g)
    }

    override fun getTexture(state: SlimeEntityRenderState): Identifier {
        return Identifier.of(TwilightForest.MOD_ID, "textures/entity/maze_slime/maze_slime.png")
    }

    override fun createRenderState(): SlimeEntityRenderState {
        return SlimeEntityRenderState()
    }

    override fun updateRenderState(entity: MazeSlimeEntity, state: SlimeEntityRenderState, tickDelta: Float) {
        super.updateRenderState(entity, state, tickDelta)
        state.stretch = MathHelper.lerp(tickDelta, entity.lastStretch, entity.stretch)
        state.size = entity.size
    }
}