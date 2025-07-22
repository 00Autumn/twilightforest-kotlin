package autumn.twilightforest.init.entity.client.squirrel

import autumn.twilightforest.TwilightForest
import net.minecraft.client.model.Dilation
import net.minecraft.client.model.ModelData
import net.minecraft.client.model.ModelPart
import net.minecraft.client.model.ModelPartBuilder
import net.minecraft.client.model.ModelPartData
import net.minecraft.client.model.ModelTransform
import net.minecraft.client.model.TexturedModelData
import net.minecraft.client.render.entity.animation.Animation
import net.minecraft.client.render.entity.model.EntityModel
import net.minecraft.client.render.entity.model.EntityModelLayer
import net.minecraft.util.Identifier
import net.minecraft.util.math.MathHelper

class SquirrelModel(root: ModelPart) : EntityModel<SquirrelRenderState>(root) {
    private val modelRoot: ModelPart = root.getChild("root")
    private val squirrel: ModelPart = modelRoot.getChild("squirrel")
    private val head: ModelPart = this.squirrel.getChild("head")
    private val body: ModelPart = this.squirrel.getChild("body")
    private val fr_leg: ModelPart = this.squirrel.getChild("fr_leg")
    private val br_leg: ModelPart = this.squirrel.getChild("br_leg")
    private val fl_leg: ModelPart = this.squirrel.getChild("fl_leg")
    private val bl_leg: ModelPart = this.squirrel.getChild("bl_leg")
    private val tail: ModelPart = this.squirrel.getChild("tail")
    private val tail_base: ModelPart = this.tail.getChild("tail_base")
    private val tail_segment_1: ModelPart = this.tail.getChild("tail_segment_1")
    private val tail_segment_2: ModelPart = this.tail.getChild("tail_segment_2")
    private val tail_segment_3: ModelPart = this.tail.getChild("tail_segment_3")

    companion object {
        val SQUIRREL = EntityModelLayer(Identifier.of(TwilightForest.MOD_ID, "squirrel"), "main")

        fun getTexturedModelData() : TexturedModelData {
                val modelData = ModelData()
                val modelPartData: ModelPartData = modelData.root
                val root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.of(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f))
                val squirrel = root.addChild(
                    "squirrel",
                    ModelPartBuilder.create(),
                    ModelTransform.of(5.0f, 24.0f, -7.0f, 0.0f, 1.5708f, 0.0f)
                )

                val head = squirrel.addChild(
                    "head",
                    ModelPartBuilder.create().uv(0, 7).cuboid(-2.0f, -2.0f, -2.0f, 4.0f, 4.0f, 4.0f, Dilation(0.1f))
                        .uv(20, 13).cuboid(-1.5f, -3.0f, -2.0f, 1.0f, 1.0f, 1.0f, Dilation(0.1f))
                        .uv(0, 21).cuboid(-1.5f, -3.0f, 1.0f, 1.0f, 1.0f, 1.0f, Dilation(0.1f)),
                    ModelTransform.of(-3.0f, -5.0f, -5.0f,0.0f, 0.0f, 0.0f)
                )

                val body = squirrel.addChild(
                    "body",
                    ModelPartBuilder.create().uv(0, 0).cuboid(-2.5f, -1.5f, -2.0f, 5.0f, 3.0f, 4.0f, Dilation(0.0f)),
                    ModelTransform.of(-6.5f, -2.5f, -5.0f, 0.0f, 0.0f, 0.0f)
                )

                val fr_leg = squirrel.addChild(
                    "fr_leg",
                    ModelPartBuilder.create().uv(16, 13).cuboid(-0.5f, 0.0f, -0.5f, 1.0f, 1.0f, 1.0f, Dilation(0.0f)),
                    ModelTransform.of(-4.5f, -1.0f, -6.5f, 0.0f, 0.0f, 0.0f)
                )

                val br_leg = squirrel.addChild(
                    "br_leg",
                    ModelPartBuilder.create().uv(18, 0).cuboid(-0.5f, 0.0f, -0.5f, 1.0f, 1.0f, 1.0f, Dilation(0.0f)),
                    ModelTransform.of(-8.5f, -1.0f, -6.5f, 0.0f, 0.0f, 0.0f)
                )

                val fl_leg = squirrel.addChild(
                    "fl_leg",
                    ModelPartBuilder.create().uv(18, 2).cuboid(-0.5f, 0.0f, -0.5f, 1.0f, 1.0f, 1.0f, Dilation(0.0f)),
                    ModelTransform.of(-4.5f, -1.0f, -3.5f, 0.0f, 0.0f, 0.0f)
                )

                val bl_leg = squirrel.addChild(
                    "bl_leg",
                    ModelPartBuilder.create().uv(18, 4).cuboid(-0.5f, 0.0f, -0.5f, 1.0f, 1.0f, 1.0f, Dilation(0.0f)),
                    ModelTransform.of(-8.5f, -1.0f, -3.5f, 0.0f, 0.0f, 0.0f)
                )

                val tail = squirrel.addChild(
                    "tail",
                    ModelPartBuilder.create(),
                    ModelTransform.of(-9.0f, -4.0f, -5.0f, 0.0f, 0.0f, 0.0873f)
                )

                val tail_base = tail.addChild(
                    "tail_base",
                    ModelPartBuilder.create().uv(4, 21).cuboid(-4.5f, -4.5f, -12.5f, 1.0f, 1.0f, 1.0f, Dilation(0.0f)),
                    ModelTransform.of(4.0f, 4.0f, 12.0f, 0.0f, 0.0f, 0.0f)
                )

                val tail_segment_1 = tail.addChild(
                    "tail_segment_1",
                    ModelPartBuilder.create().uv(0, 15).cuboid(-7.0f, -7.0f, -13.5f, 3.0f, 3.0f, 3.0f, Dilation(0.0f)),
                    ModelTransform.of(4.0f, 4.0f, 12.0f, 0.0f, 0.0f, 0.0f)
                )

                val tail_segment_2 = tail.addChild("tail_segment_2", ModelPartBuilder.create(), ModelTransform.of(4.0f, 4.0f, 12.0f, 0.0f, 0.0f, 0.0f))

                val c1_r1 = tail_segment_2.addChild(
                    "c1_r1",
                    ModelPartBuilder.create().uv(12, 15).cuboid(-1.15f, -1.5f, -1.5f, 3.0f, 3.0f, 3.0f, Dilation(0.0f)),
                    ModelTransform.of(-5.5f, -8.5f, -12.0f, 0.0f, 0.0f, 0.1745f)
                )

                val tail_segment_3 = tail.addChild("tail_segment_3", ModelPartBuilder.create(), ModelTransform.of(4.0f, 4.0f, 12.0f, 0.0f, 0.0f, 0.0f))

                val c1_r2 = tail_segment_3.addChild(
                    "c1_r2",
                    ModelPartBuilder.create().uv(16, 7).cuboid(-0.25f, -1.75f, -1.5f, 3.0f, 3.0f, 3.0f, Dilation(0.0f)),
                    ModelTransform.of(-5.5f, -11.5f, -12.0f, 0.0f, 0.0f, 0.3491f)
                )
            
                return TexturedModelData.of(modelData, 32, 32)
        }
    }
    
    private val walkingAnimation: Animation? = SquirrelAnim.ANIM_SQUIRREL_WALK?.createAnimation(modelRoot)
    private val flyingAnimation: Animation? = SquirrelAnim.ANIM_SQUIRREL_IDLE?.createAnimation(modelRoot)

    override fun setAngles(state: SquirrelRenderState) {
        super.setAngles(state)
        setHeadAngles(state.relativeHeadYaw, state.pitch)

        walkingAnimation?.applyWalking(state.limbSwingAnimationProgress, state.limbSwingAmplitude, 2f, 2.5f)
        flyingAnimation?.apply(state.idleAnimationState, state.age, 1f)
    }

    private fun setHeadAngles(headYaw: Float, headPitch: Float) {
        val clampedYaw = MathHelper.clamp(headYaw, -30.0f, 30.0f)
        val clampedPitch = MathHelper.clamp(headPitch, -25.0f, 45.0f)

        head.yaw = clampedYaw * 0.017453292f
        head.pitch = clampedPitch * 0.017453292f
    }
}