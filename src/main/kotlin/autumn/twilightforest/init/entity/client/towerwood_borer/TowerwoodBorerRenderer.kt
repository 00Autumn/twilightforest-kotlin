package autumn.twilightforest.init.entity.client.towerwood_borer

import autumn.twilightforest.TwilightForest
import autumn.twilightforest.init.entity.vanilla.towerwood_borer.TowerwoodBorerEntity
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.MobEntityRenderer
import net.minecraft.client.render.entity.model.EntityModelLayers
import net.minecraft.client.render.entity.model.SilverfishEntityModel
import net.minecraft.client.render.entity.state.LivingEntityRenderState
import net.minecraft.util.Identifier

class TowerwoodBorerRenderer(context: EntityRendererFactory.Context) : MobEntityRenderer<TowerwoodBorerEntity, LivingEntityRenderState, SilverfishEntityModel>(context, SilverfishEntityModel(context.getPart(EntityModelLayers.SILVERFISH)), 0.3F) {
    override fun getTexture(state: LivingEntityRenderState): Identifier {
        return Identifier.of(TwilightForest.MOD_ID, "textures/entity/towerwood_borer/towerwood_borer.png")
    }

    override fun getLyingPositionRotationDegrees(): Float {
        return 180.0F
    }

    override fun createRenderState(): LivingEntityRenderState {
        return LivingEntityRenderState()
    }
}