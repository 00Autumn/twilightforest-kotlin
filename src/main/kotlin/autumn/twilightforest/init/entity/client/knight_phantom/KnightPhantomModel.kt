package autumn.twilightforest.init.entity.client.knight_phantom

import net.minecraft.client.model.*
import net.minecraft.client.render.entity.animation.Animation
import net.minecraft.client.render.entity.model.ArmPosing
import net.minecraft.client.render.entity.model.BipedEntityModel
import net.minecraft.client.render.entity.model.EntityModelPartNames
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.util.Arm
import net.minecraft.util.math.MathHelper

class KnightPhantomModel(
    root: ModelPart,
    private val dilation: Dilation = Dilation.NONE
) : BipedEntityModel<KnightPhantomRenderState>(root) {

    val floatingAnimation: Animation? = KnightPhantomAnim.ANIM_KNIGHT_PHANTOM_FLOAT.createAnimation(root)

    override fun setAngles(state: KnightPhantomRenderState) {
        super.setAngles(state)

        rightLeg.pitch = 0.1309f
        leftLeg.pitch = 0.1309f

        floatingAnimation?.apply(state.floatAnimationState, state.age, 1.0f)

        if (state.attacking && !state.holdingKnightmetalSword) {
            val swing = state.handSwingProgress
            val g = MathHelper.sin(swing * Math.PI.toFloat())
            val h = MathHelper.sin((1.0f - (1.0f - swing) * (1.0f - swing)) * Math.PI.toFloat())

            rightArm.roll = 0.0f
            leftArm.roll = 0.0f
            rightArm.yaw = -(0.1f - g * 0.6f)
            leftArm.yaw = 0.1f - g * 0.6f
            rightArm.pitch = (-Math.PI / 2).toFloat()
            leftArm.pitch = (-Math.PI / 2).toFloat()
            rightArm.pitch -= g * 1.2f - h * 0.4f
            leftArm.pitch -= g * 1.2f - h * 0.4f

            ArmPosing.swingArms(rightArm, leftArm, state.age)
        }
    }

    override fun setArmAngle(arm: Arm, matrices: MatrixStack) {
        rootPart.applyTransform(matrices)
        val f = if (arm == Arm.RIGHT) 1.0f else -1.0f
        val modelPart = getArm(arm)
        modelPart.originX += f
        modelPart.applyTransform(matrices)
        modelPart.originX -= f
    }

    companion object {
        fun getTexturedModelData(dilation: Dilation = Dilation.NONE): TexturedModelData {
            val modelData = getModelData(dilation, 0.0f)
            val modelPartData = modelData.root
            addLimbs(modelPartData, dilation)
            return TexturedModelData.of(modelData, 64, 32)
        }

        private fun addLimbs(data: ModelPartData, dilation: Dilation) {
            data.addChild(
                EntityModelPartNames.RIGHT_ARM,
                ModelPartBuilder.create().uv(0, 16).cuboid(-1.0f, -2.0f, -1.0f, 2.0f, 12.0f, 2.0f, dilation),
                ModelTransform.origin(-5.0f, 2.0f, 0.0f)
            )
            data.addChild(
                EntityModelPartNames.LEFT_ARM,
                ModelPartBuilder.create().uv(0, 16).mirrored().cuboid(-1.0f, -2.0f, -1.0f, 2.0f, 12.0f, 2.0f, dilation),
                ModelTransform.origin(5.0f, 2.0f, 0.0f)
            )
            data.addChild(
                EntityModelPartNames.RIGHT_LEG,
                ModelPartBuilder.create().uv(0, 16).cuboid(-1.0f, 0.0f, -1.0f, 2.0f, 12.0f, 2.0f, dilation),
                ModelTransform.origin(-2.0f, 12.0f, 0.1f)
            )
            data.addChild(
                EntityModelPartNames.LEFT_LEG,
                ModelPartBuilder.create().uv(0, 16).mirrored().cuboid(-1.0f, 0.0f, -1.0f, 2.0f, 12.0f, 2.0f, dilation),
                ModelTransform.origin(2.0f, 12.0f, 0.1f)
            )
        }
    }
}
