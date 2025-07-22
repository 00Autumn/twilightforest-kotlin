package autumn.twilightforest.init.entity.equipment.client.knightmetal

import net.minecraft.client.model.*
import net.minecraft.client.render.entity.model.BipedEntityModel
import net.minecraft.client.render.entity.model.EntityModelPartNames
import net.minecraft.client.render.entity.state.BipedEntityRenderState

class KnightmetalArmorModel(modelPart: ModelPart) : BipedEntityModel<BipedEntityRenderState>(modelPart) {
    companion object {
        fun getModelData(dilation: Dilation): ModelData {
            val modelData = getModelData(dilation, 0.0f)
            val root = modelData.root
            val head = root.getChild(EntityModelPartNames.HEAD)
            val rightArm = root.getChild(EntityModelPartNames.RIGHT_ARM)
            val leftArm = root.getChild(EntityModelPartNames.LEFT_ARM)

            root.addChild(
                EntityModelPartNames.RIGHT_LEG,
                ModelPartBuilder.create()
                    .uv(0, 16)
                    .cuboid(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, dilation.add(-0.1f)),
                ModelTransform.of(-1.9f, 12.0f, 0.0f, 0.0f, 0.0f, 0.0f)
            )

            root.addChild(
                EntityModelPartNames.LEFT_LEG,
                ModelPartBuilder.create()
                    .uv(0, 16)
                    .mirrored()
                    .cuboid(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, dilation.add(-0.1f)),
                ModelTransform.of(1.9f, 12.0f, 0.0f, 0.0f, 0.0f, 0.0f)
            )

            val rightLeg = root.getChild(EntityModelPartNames.RIGHT_LEG)
            val leftLeg = root.getChild(EntityModelPartNames.LEFT_LEG)

            //CUSTOM PARTS
            val rb1_r1: ModelPartData? = rightLeg.addChild(
                "rb1_r1",
                ModelPartBuilder.create().uv(54, 16).cuboid(-1.5f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f, Dilation(0.0f)),
                ModelTransform.of(-4.4f + 2.0f, -2.0f + 12.0f, 2.0f, 0.0436f, 0.3927f, 0.0f)
            )

            val lb1_r1: ModelPartData? = leftLeg.addChild(
                "lb1_r1",
                ModelPartBuilder.create().uv(54, 16).mirrored()
                    .cuboid(-1.5f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f, Dilation(0.0f)).mirrored(false),
                ModelTransform.of(4.4f - 2.0f, -2.0f + 12.0f, 2.0f, 0.0436f, -0.3927f, 0.0f)
            )

            val rh2_r1: ModelPartData? = head.addChild(
                "rh2_r1",
                ModelPartBuilder.create().uv(0, 0).cuboid(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f, Dilation(0.0f)),
                ModelTransform.of(-9.0f, -31.0f + 24.0f, -4.0f, 0.1309f, -0.2182f, 0.2182f)
            )

            val lh2_r1: ModelPartData? = head.addChild(
                "lh2_r1",
                ModelPartBuilder.create().uv(0, 0).mirrored()
                    .cuboid(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f, Dilation(0.0f)).mirrored(false),
                ModelTransform.of(9.0f, -31.0f + 24.0f, -4.0f, 0.1309f, 0.2182f, -0.2182f)
            )

            val lh1_r1: ModelPartData? = head.addChild(
                "lh1_r1",
                ModelPartBuilder.create().uv(24, 0).mirrored()
                    .cuboid(-0.5f, -1.5f, -1.5f, 5.0f, 3.0f, 3.0f, Dilation(0.0f)).mirrored(false),
                ModelTransform.of(4.5f, -29.5f + 24.0f, -2.5f, 0.0436f, 0.2618f, -0.1745f)
            )

            val rh1_r1: ModelPartData? = head.addChild(
                "rh1_r1",
                ModelPartBuilder.create().uv(24, 0).cuboid(-4.5f, -1.5f, -1.5f, 5.0f, 3.0f, 3.0f, Dilation(0.0f)),
                ModelTransform.of(-4.5f, -29.5f + 24.0f, -2.5f, 0.0436f, -0.2618f, 0.1745f)
            )

            val rs1_r1: ModelPartData? = rightArm.addChild(
                "rs1_r1",
                ModelPartBuilder.create().uv(0, 0).cuboid(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f, Dilation(0.0f)),
                ModelTransform.of(-8.7f + 5.0f, -24.7f + 23.0f, 2.7f, 0.7854f, 0.7854f, 0.0f)
            )

            val ls1_r1: ModelPartData? = leftArm.addChild(
                "ls1_r1",
                ModelPartBuilder.create().uv(0, 0).mirrored()
                    .cuboid(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f, Dilation(0.0f)).mirrored(false),
                ModelTransform.of(8.7f - 5.0f, -24.7f + 23.0f, 2.7f, -0.7854f, -0.7854f, 0.0f)
            )

            return modelData
        }

        fun getTexturedModelData(dilation: Dilation): TexturedModelData {
            return TexturedModelData.of(getModelData(dilation), 64, 32)
        }
    }
}