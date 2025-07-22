package autumn.twilightforest.init.entity.client.knight_phantom

import autumn.twilightforest.TwilightForest
import autumn.twilightforest.init.entity.vanilla.knight_phantom.KnightPhantomEntity
import autumn.twilightforest.init.item.TFItems
import net.minecraft.client.model.Dilation
import net.minecraft.client.render.VertexConsumerProvider
import net.minecraft.client.render.entity.BipedEntityRenderer
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer
import net.minecraft.client.render.entity.model.BipedEntityModel
import net.minecraft.client.render.entity.model.EntityModelLayers
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.util.Arm
import net.minecraft.util.Identifier

class KnightPhantomRenderer(context: EntityRendererFactory.Context) : BipedEntityRenderer<KnightPhantomEntity, KnightPhantomRenderState, KnightPhantomModel>(context, KnightPhantomModel(context.getPart(EntityModelLayers.SKELETON)), 0.5F) {

    init {
        addFeature(
            ArmorFeatureRenderer(
                this,
                KnightPhantomModel(context.getPart(EntityModelLayers.SKELETON_INNER_ARMOR), Dilation(0.5f)),
                KnightPhantomModel(context.getPart(EntityModelLayers.SKELETON_OUTER_ARMOR), Dilation(1.0f)),
                context.equipmentRenderer
            )
        )
    }

    override fun getTexture(state: KnightPhantomRenderState): Identifier {
        return Identifier.of(TwilightForest.MOD_ID, "textures/entity/knight_phantom/knight_phantom.png")
    }

    override fun createRenderState(): KnightPhantomRenderState {
        return KnightPhantomRenderState()
    }

    override fun render(livingEntityRenderState: KnightPhantomRenderState, matrixStack: MatrixStack, vertexConsumerProvider: VertexConsumerProvider, i: Int) {
        super.render(livingEntityRenderState, matrixStack, vertexConsumerProvider, i)
    }

    override fun updateRenderState(
        entity: KnightPhantomEntity,
        state: KnightPhantomRenderState,
        tickDelta: Float
    ) {
        super.updateRenderState(entity, state, tickDelta)
        state.attacking = entity.isAttacking
        state.holdingKnightmetalSword = entity.mainHandStack.isOf(TFItems.KNIGHTMETAL_SWORD)
        state.floatAnimationState.copyFrom(entity.floatAnimationState)
    }

    override fun getArmPose(
        entity: KnightPhantomEntity,
        arm: Arm
    ): BipedEntityModel.ArmPose {
        val stack = entity.mainHandStack
        return if (entity.mainArm == arm && entity.isAttacking && stack.isOf(TFItems.KNIGHTMETAL_SWORD)) {
            BipedEntityModel.ArmPose.ITEM
        } else {
            BipedEntityModel.ArmPose.EMPTY
        }
    }
}