package autumn.twilightforest.init.entity.client.wild_boar

import autumn.twilightforest.TwilightForest
import autumn.twilightforest.init.entity.custom.wild_boar.WildBoarEntity
import net.minecraft.client.render.VertexConsumerProvider
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.MobEntityRenderer
import net.minecraft.client.render.entity.state.LivingEntityRenderState
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.util.Identifier

class WildBoarRenderer(context: EntityRendererFactory.Context) : MobEntityRenderer<WildBoarEntity, LivingEntityRenderState, WildBoarModel>(context, WildBoarModel(context.getPart(WildBoarModel.WILD_BOAR)), 0.7F){
    override fun getTexture(state: LivingEntityRenderState?): Identifier? {
        return Identifier.of(TwilightForest.MOD_ID, "textures/entity/wild_boar/wild_boar.png")
    }

    override fun render(
        livingEntityRenderState: LivingEntityRenderState?,
        matrixStack: MatrixStack?,
        vertexConsumerProvider: VertexConsumerProvider?,
        i: Int
    ) {
        if(livingEntityRenderState?.baby == true) {
            matrixStack?.scale(0.5F, 0.5F, 0.5F)
        } else {
            matrixStack?.scale(1.0F, 1.0F, 1.0F)
        }
        super.render(livingEntityRenderState, matrixStack, vertexConsumerProvider, i)
    }

    override fun createRenderState(): LivingEntityRenderState? {
        return LivingEntityRenderState()
    }
}