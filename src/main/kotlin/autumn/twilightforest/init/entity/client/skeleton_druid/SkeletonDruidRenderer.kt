package autumn.twilightforest.init.entity.client.skeleton_druid

import autumn.twilightforest.TwilightForest
import autumn.twilightforest.init.entity.vanilla.skeleton_druid.SkeletonDruidEntity
import net.minecraft.client.render.VertexConsumerProvider
import net.minecraft.client.render.entity.BipedEntityRenderer
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.model.BipedEntityModel
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.item.Items
import net.minecraft.util.Arm
import net.minecraft.util.Identifier

class SkeletonDruidRenderer(
    context: EntityRendererFactory.Context,
) : BipedEntityRenderer<SkeletonDruidEntity, SkeletonDruidRenderState, SkeletonDruidModel>(
    context,
    SkeletonDruidModel(context.getPart(SkeletonDruidModel.SKELETON_DRUID)),
    0.5F
) {

    override fun getTexture(state: SkeletonDruidRenderState): Identifier {
        return Identifier.of(TwilightForest.MOD_ID, "textures/entity/skeleton_druid/skeleton_druid.png")
    }

    override fun createRenderState(): SkeletonDruidRenderState {
        return SkeletonDruidRenderState()
    }

    override fun render(livingEntityRenderState: SkeletonDruidRenderState, matrixStack: MatrixStack, vertexConsumerProvider: VertexConsumerProvider, i: Int) {
        if(livingEntityRenderState.child) {
            matrixStack.scale(0.5F, 0.5F, 0.5F)
        }
        super.render(livingEntityRenderState, matrixStack, vertexConsumerProvider, i)
    }

    override fun updateRenderState(
        entity: SkeletonDruidEntity,
        state: SkeletonDruidRenderState,
        tickDelta: Float
    ) {
        super.updateRenderState(entity, state, tickDelta)
        state.attacking = entity.isAttacking
        state.holdingHoe = entity.mainHandStack.isOf(Items.GOLDEN_HOE)
        state.child = entity.getChild()
    }

    override fun getArmPose(
        entity: SkeletonDruidEntity,
        arm: Arm
    ): BipedEntityModel.ArmPose {
        val stack = entity.mainHandStack
        return if (entity.mainArm == arm && entity.isAttacking && stack.isOf(Items.GOLDEN_HOE)) {
            BipedEntityModel.ArmPose.ITEM
        } else {
            BipedEntityModel.ArmPose.EMPTY
        }
    }
}