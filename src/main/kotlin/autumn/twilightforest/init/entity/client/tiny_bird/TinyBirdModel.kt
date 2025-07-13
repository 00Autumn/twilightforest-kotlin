package autumn.twilightforest.init.entity.client.tiny_bird

import autumn.twilightforest.TwilightForest
import net.minecraft.client.model.Dilation
import net.minecraft.client.model.ModelData
import net.minecraft.client.model.ModelPart
import net.minecraft.client.model.ModelPartBuilder
import net.minecraft.client.model.ModelTransform
import net.minecraft.client.model.TexturedModelData
import net.minecraft.client.render.entity.animation.Animation
import net.minecraft.client.render.entity.model.EntityModel
import net.minecraft.client.render.entity.model.EntityModelLayer
import net.minecraft.util.Identifier
import net.minecraft.util.math.MathHelper

class TinyBirdModel(root: ModelPart) : EntityModel<TinyBirdRenderState>(root) {
    private val modelRoot: ModelPart = root.getChild("root")
    private val tinyBird: ModelPart = modelRoot.getChild("tiny_bird")
    private val head: ModelPart = tinyBird.getChild("head")
    private val body: ModelPart = tinyBird.getChild("body")
    private val r_wing: ModelPart = tinyBird.getChild("r_wing")
    private val l_wing: ModelPart = tinyBird.getChild("l_wing")
    private val r_foot: ModelPart = tinyBird.getChild("r_foot")
    private val l_foot: ModelPart = tinyBird.getChild("l_foot")

    companion object {
        val TINY_BIRD = EntityModelLayer(Identifier.of(TwilightForest.MOD_ID, "tiny_bird"), "main")

        fun getTexturedModelData(): TexturedModelData {
            val modelData = ModelData()
            val modelPartData = modelData.root
            val root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.of(0.0f, 24.0f, 0.0f, 0.0f, 0.0f, 0.0f))
            val tinyBird = root.addChild(
                "tiny_bird",
                ModelPartBuilder.create(),
                ModelTransform.of(1.0f, 3.0f, -3.0f, 0.0f, 0.0f, 0.0f)
            )

            tinyBird.addChild(
                "head",
                ModelPartBuilder.create()
                    .uv(0, 0).cuboid(-1.5f, -1.5f, -1.5f, 3.0f, 3.0f, 3.0f, Dilation(0.0f))
                    .uv(12, 0).cuboid(-0.5f, 0.5f, -2.5f, 1.0f, 1.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.of(-1.0f, -6.5f, 1.5f, 0.0f, 0.0f, 0.0f)
            )

            tinyBird.addChild(
                "body",
                ModelPartBuilder.create()
                    .uv(0, 6).cuboid(-1.5f, -1.5f, -0.5f, 3.0f, 3.0f, 3.0f, Dilation(0.0f))
                    .uv(0, 14).cuboid(-1.5f, 0.0f, 2.5f, 3.0f, 1.0f, 2.0f, Dilation(0.0f)),
                ModelTransform.of(-1.0f, -5.5f, 1.5f, 0.0f, 0.0f, 0.0f)
            )

            tinyBird.addChild(
                "r_wing",
                ModelPartBuilder.create()
                    .uv(12, 2).cuboid(-0.5f, -0.5f, -1.5f, 1.0f, 2.0f, 3.0f, Dilation(0.0f)),
                ModelTransform.of(-3.0f, -6.0f, 3.0f, 0.0f, 0.0f, 0.0f)
            )

            tinyBird.addChild(
                "l_wing",
                ModelPartBuilder.create()
                    .uv(12, 2).cuboid(-0.5f, -0.5f, -1.5f, 1.0f, 2.0f, 3.0f, Dilation(0.0f)),
                ModelTransform.of(1.0f, -6.0f, 3.0f, 0.0f, 0.0f, 0.0f)
            )

            tinyBird.addChild(
                "r_foot",
                ModelPartBuilder.create()
                    .uv(13, 0).cuboid(-0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, Dilation(0.0f))
                    .uv(12, 1).cuboid(-0.5f, 1.0f, -1.0f, 1.0f, 0.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.of(-2.0f, -4.0f, 3.0f, 0.0f, 0.0f, 0.0f)
            )

            tinyBird.addChild(
                "l_foot",
                ModelPartBuilder.create()
                    .uv(13, 1).cuboid(-0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, Dilation(0.0f))
                    .uv(12, 0).cuboid(-0.5f, 1.0f, -1.0f, 1.0f, 0.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.of(0.0f, -4.0f, 3.0f, 0.0f, 0.0f, 0.0f)
            )

            return TexturedModelData.of(modelData, 32, 32)
        }
    }

        private val walkingAnimation: Animation? = TinyBirdAnim.ANIM_TINY_BIRD_WALK?.createAnimation(modelRoot)
        private val flyingAnimation: Animation? = TinyBirdAnim.ANIM_TINY_BIRD_FLY?.createAnimation(modelRoot)

        override fun setAngles(state: TinyBirdRenderState) {
            super.setAngles(state)
            setHeadAngles(state.relativeHeadYaw, state.pitch)

            walkingAnimation?.applyWalking(state.limbSwingAnimationProgress, state.limbSwingAmplitude, 2f, 2.5f)
            flyingAnimation?.apply(state.flyAnimationState, state.age, 1f)
        }

        private fun setHeadAngles(headYaw: Float, headPitch: Float) {
            val clampedYaw = MathHelper.clamp(headYaw, -30.0f, 30.0f)
            val clampedPitch = MathHelper.clamp(headPitch, -25.0f, 45.0f)

            head.yaw = clampedYaw * 0.017453292f
            head.pitch = clampedPitch * 0.017453292f
        }
    }

