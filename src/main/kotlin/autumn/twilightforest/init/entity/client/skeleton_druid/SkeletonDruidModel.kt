package autumn.twilightforest.init.entity.client.skeleton_druid

import autumn.twilightforest.TwilightForest
import net.minecraft.client.model.Dilation
import net.minecraft.client.model.ModelPart
import net.minecraft.client.model.ModelPartBuilder
import net.minecraft.client.model.ModelPartData
import net.minecraft.client.model.ModelTransform
import net.minecraft.client.model.TexturedModelData
import net.minecraft.client.render.entity.model.ArmPosing
import net.minecraft.client.render.entity.model.BipedEntityModel
import net.minecraft.client.render.entity.model.EntityModelLayer
import net.minecraft.client.render.entity.model.EntityModelPartNames
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.util.Arm
import net.minecraft.util.Identifier
import net.minecraft.util.math.MathHelper

class SkeletonDruidModel(root: ModelPart) : BipedEntityModel<SkeletonDruidRenderState>(root) {

    private val drapes: ModelPart = root.getChild("drapes")

    override fun setAngles(state: SkeletonDruidRenderState) {
        super.setAngles(state)
        if (state.attacking && !state.holdingHoe) { //CHANGED TO "holdingHoe"
            val f = state.handSwingProgress
            val g = MathHelper.sin(f * Math.PI.toFloat())
            val h = MathHelper.sin((1.0f - (1.0f - f) * (1.0f - f)) * Math.PI.toFloat())
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
        val SKELETON_DRUID = EntityModelLayer(Identifier.of(TwilightForest.MOD_ID, "skeleton"), "main")

        fun getTexturedModelData(): TexturedModelData {
            val modelData = getModelData(Dilation.NONE, 0.0f)
            val modelPartData = modelData.root

            //CUSTOM PART
            modelPartData.addChild(
                "drapes",
                ModelPartBuilder.create().uv(40, 21)
                    .cuboid(-4.0f, -12.0f, -2.0f, 8.0f, 7.0f, 4.0f, Dilation(0.0f)),
                ModelTransform.of(0.0f, 24.0f, 0.0f, 0.0f, 0.0f, 0.0f)
            )

            addLimbs(modelPartData)
            return TexturedModelData.of(modelData, 64, 32)
        }

        private fun addLimbs(data: ModelPartData) {
            data.addChild(
                EntityModelPartNames.RIGHT_ARM,
                ModelPartBuilder.create().uv(0, 16).cuboid(-1.0f, -2.0f, -1.0f, 2.0f, 12.0f, 2.0f),
                ModelTransform.origin(-5.0f, 2.0f, 0.0f)
            )
            data.addChild(
                EntityModelPartNames.LEFT_ARM,
                ModelPartBuilder.create().uv(0, 16).mirrored().cuboid(-1.0f, -2.0f, -1.0f, 2.0f, 12.0f, 2.0f),
                ModelTransform.origin(5.0f, 2.0f, 0.0f)
            )
            data.addChild(
                EntityModelPartNames.RIGHT_LEG,
                ModelPartBuilder.create().uv(0, 16).cuboid(-1.0f, 0.0f, -1.0f, 2.0f, 12.0f, 2.0f),
                ModelTransform.origin(-2.0f, 12.0f, 0.0f)
            )
            data.addChild(
                EntityModelPartNames.LEFT_LEG,
                ModelPartBuilder.create().uv(0, 16).mirrored().cuboid(-1.0f, 0.0f, -1.0f, 2.0f, 12.0f, 2.0f),
                ModelTransform.origin(2.0f, 12.0f, 0.0f)
            )
        }
    }
}