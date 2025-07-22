package autumn.twilightforest.init.entity.client.bighorn_sheep

import autumn.twilightforest.TwilightForest
import autumn.twilightforest.init.entity.vanilla.bighorn_sheep.BighornSheepEntity
import net.minecraft.client.render.entity.AgeableMobEntityRenderer
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.feature.SheepWoolFeatureRenderer
import net.minecraft.client.render.entity.feature.SheepWoolUndercoatFeatureRenderer
import net.minecraft.client.render.entity.model.EntityModelLayers
import net.minecraft.client.render.entity.model.SheepEntityModel
import net.minecraft.client.render.entity.state.SheepEntityRenderState
import net.minecraft.util.Identifier

class BighornSheepRenderer(context: EntityRendererFactory.Context) : AgeableMobEntityRenderer<BighornSheepEntity, SheepEntityRenderState, SheepEntityModel>(context, SheepEntityModel(context.getPart(BighornSheepModel.BIGHORN_SHEEP)), SheepEntityModel(context.getPart(EntityModelLayers.SHEEP_BABY)), 0.7F) {

    init {
        this.addFeature(SheepWoolUndercoatFeatureRenderer(this, context.entityModels))
        this.addFeature(SheepWoolFeatureRenderer(this, context.entityModels))
    }

    override fun getTexture(state: SheepEntityRenderState?): Identifier? {
        return Identifier.of(TwilightForest.MOD_ID, "textures/entity/bighorn_sheep/bighorn_sheep.png")
    }

    override fun createRenderState(): SheepEntityRenderState? {
        return SheepEntityRenderState()
    }

    override fun updateRenderState(sheepEntity: BighornSheepEntity, sheepEntityRenderState: SheepEntityRenderState, f: Float) {
        super.updateRenderState(sheepEntity, sheepEntityRenderState, f)
        sheepEntityRenderState.headAngle = sheepEntity.getHeadAngle(f)
        sheepEntityRenderState.neckAngle = sheepEntity.getNeckAngle(f)
        sheepEntityRenderState.sheared = sheepEntity.isSheared
        sheepEntityRenderState.color = sheepEntity.color
        sheepEntityRenderState.id = sheepEntity.id
    }
}