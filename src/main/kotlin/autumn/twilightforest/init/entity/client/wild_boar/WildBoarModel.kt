package autumn.twilightforest.init.entity.client.wild_boar

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
import net.minecraft.client.render.entity.state.LivingEntityRenderState
import net.minecraft.util.Identifier
import net.minecraft.util.math.MathHelper
import org.joml.Vector3f

class WildBoarModel(root: ModelPart) : EntityModel<LivingEntityRenderState>(root) {
    private val modelRoot: ModelPart = root.getChild("root")
    private val wildBoar: ModelPart = modelRoot.getChild("wild_boar")
    private val head: ModelPart = wildBoar.getChild("head")
    private val tusks = this.head.getChild("tusks")
    private val body: ModelPart = wildBoar.getChild("body")
    private val frLeg: ModelPart = wildBoar.getChild("fr_leg")
    private val brLeg: ModelPart = wildBoar.getChild("br_leg")
    private val flLeg: ModelPart = wildBoar.getChild("fl_leg")
    private val blLeg: ModelPart = wildBoar.getChild("bl_leg")

    companion object {
        val WILD_BOAR = EntityModelLayer(Identifier.of(TwilightForest.MOD_ID, "wild_boar"), "main")

        fun getTexturedModelData(): TexturedModelData {
            val modelData = ModelData()
            val modelPartData = modelData.root
            val root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.of(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f))
            val wildBoar = root.addChild(
                "wild_boar",
                ModelPartBuilder.create(),
                ModelTransform.of(3.0f, 26.0f, -9.0f, 0.0f, 0.0f, 0.0f)
            )

            val head = wildBoar.addChild("head", ModelPartBuilder.create()
                .uv(0, 22).cuboid(-4.0f, -4.625f, -6.0f, 8.0f, 7.0f, 6.0f, Dilation(0.0f))
                .uv(32, 42).cuboid(-3.0f, -1.625f, -9.0f, 6.0f, 4.0f, 3.0f, Dilation(0.0f)),
                ModelTransform.of(-3.0f, -11.375f, 5.0f,0.0f, 0.0f, 0.0f)
            )

            val tusks = head.addChild("tusks", ModelPartBuilder.create()
                .uv(16, 35).cuboid(3.0f, -0.625f, -9.0f, 1.0f, 2.0f, 1.0f, Dilation(0.0f))
                .uv(20, 35).cuboid(-4.0f, -0.625f, -9.0f, 1.0f, 2.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.of(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f)
            )

            wildBoar.addChild("body", ModelPartBuilder.create()
                .uv(0, 0).cuboid(-5.0f, -4.0f, -7.0f, 10.0f, 8.0f, 14.0f, Dilation(0.0f)),
                ModelTransform.of(-3.0f, -12.0f, 12.0f, 0.0f, 0.0f, 0.0f)
            )

            wildBoar.addChild("fr_leg", ModelPartBuilder.create()
                .uv(28, 22).cuboid(-2.0f, 0.0f, -2.0f, 4.0f, 6.0f, 4.0f, Dilation(0.0f)),
                ModelTransform.of(-6.0f, -8.0f, 7.0f, 0.0f, 0.0f, 0.0f)
            )

            wildBoar.addChild("br_leg", ModelPartBuilder.create()
                .uv(28, 32).cuboid(-2.0f, 0.0f, -2.0f, 4.0f, 6.0f, 4.0f, Dilation(0.0f)),
                ModelTransform.of(-6.0f, -8.0f, 18.0f, 0.0f, 0.0f, 0.0f)
            )

            wildBoar.addChild("fl_leg", ModelPartBuilder.create()
                .uv(16, 42).cuboid(-2.0f, 0.0f, -2.0f, 4.0f, 6.0f, 4.0f, Dilation(0.0f)),
                ModelTransform.of(0.0f, -8.0f, 7.0f, 0.0f, 0.0f, 0.0f)
            )

            wildBoar.addChild("bl_leg", ModelPartBuilder.create()
                .uv(0, 35).cuboid(-2.0f, 0.0f, -2.0f, 4.0f, 6.0f, 4.0f, Dilation(0.0f)),
                ModelTransform.of(0.0f, -8.0f, 18.0f, 0.0f, 0.0f, 0.0f)
            )

            return TexturedModelData.of(modelData, 64, 64)
        }
    }

    private val walkingAnimation: Animation? = WildBoarAnim.ANIM_WILD_BOAR_WALK?.createAnimation(modelRoot)

    override fun setAngles(state: LivingEntityRenderState) {
        super.setAngles(state)
        setHeadAngles(state.relativeHeadYaw, state.pitch)

        this.tusks.visible = !state.baby

        if (state.baby) {
            head.scale(Vector3f(1.0f, 1.0f, 1.0f))
        }

        walkingAnimation?.applyWalking(state.limbSwingAnimationProgress, state.limbSwingAmplitude, 2f, 2.5f)
    }

    private fun setHeadAngles(headYaw: Float, headPitch: Float) {
        val clampedYaw = MathHelper.clamp(headYaw, -30.0f, 30.0f)
        val clampedPitch = MathHelper.clamp(headPitch, -25.0f, 45.0f)

        head.yaw = clampedYaw * 0.017453292f
        head.pitch = clampedPitch * 0.017453292f
    }
}