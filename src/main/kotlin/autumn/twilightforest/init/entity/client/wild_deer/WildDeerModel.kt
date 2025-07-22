package autumn.twilightforest.init.entity.client.wild_deer

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
import org.joml.Vector3f

class WildDeerModel(root: ModelPart) : EntityModel<WildDeerRenderState>(root) {
    private val modelRoot: ModelPart = root.getChild("root")
    private val wildDeer: ModelPart = modelRoot.getChild("wild_deer")
    private val head: ModelPart = this.wildDeer.getChild("head")
    private val antlers: ModelPart = this.head.getChild("antlers")
    private val r: ModelPart? = this.antlers.getChild("r")
    private val l: ModelPart? = this.antlers.getChild("l")
    private val neck: ModelPart? = this.wildDeer.getChild("neck")
    private val body: ModelPart? = this.wildDeer.getChild("body")
    private val bl_leg: ModelPart? = this.wildDeer.getChild("bl_leg")
    private val fl_leg: ModelPart? = this.wildDeer.getChild("fl_leg")
    private val br_leg: ModelPart? = this.wildDeer.getChild("br_leg")
    private val fr_leg: ModelPart? = this.wildDeer.getChild("fr_leg")

    companion object {
        val WILD_DEER = EntityModelLayer(Identifier.of(TwilightForest.MOD_ID, "wild_deer"), "main")

        fun getTexturedModelData(): TexturedModelData {
                val modelData = ModelData()
                val modelPartData = modelData.root
                val root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.of(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f))
                val wildDeer = root.addChild(
                    "wild_deer",
                    ModelPartBuilder.create(),
                    ModelTransform.of(1.0f, 24.0f, -6.0f,0.0f, 0.0f, 0.0f)
                )

                val head: ModelPartData = wildDeer.addChild(
                    "head",
                    ModelPartBuilder.create().uv(0, 26).cuboid(-2.0f, -3.75f, -0.75f, 4.0f, 6.0f, 6.0f, Dilation(0.0f))
                        .uv(30, 41).cuboid(-1.5f, -0.75f, -3.75f, 3.0f, 3.0f, 3.0f, Dilation(0.0f)),
                    ModelTransform.of(-1.0f, -24.25f, -5.25f,0.0f, 0.0f, 0.0f)
                )

                val antlers: ModelPartData =
                    head.addChild("antlers", ModelPartBuilder.create(), ModelTransform.of(1.0f, 19.25f, 0.25f,0.0f, 0.0f, 0.0f))

                val r: ModelPartData? = antlers.addChild(
                    "r",
                    ModelPartBuilder.create().uv(44, 37).cuboid(-4.0f, -25.0f, 2.0f, 2.0f, 2.0f, 2.0f, Dilation(0.0f))
                        .uv(48, 5).cuboid(-5.0f, -25.0f, 3.0f, 1.0f, 1.0f, 3.0f, Dilation(0.0f))
                        .uv(42, 41).cuboid(-6.0f, -26.0f, 5.0f, 1.0f, 1.0f, 5.0f, Dilation(0.0f))
                        .uv(52, 37).cuboid(-6.0f, -29.0f, 6.0f, 1.0f, 3.0f, 1.0f, Dilation(0.0f))
                        .uv(48, 9).cuboid(-7.0f, -28.0f, 4.0f, 1.0f, 1.0f, 3.0f, Dilation(0.0f))
                        .uv(46, 52).cuboid(-7.0f, -32.0f, 7.0f, 1.0f, 4.0f, 1.0f, Dilation(0.0f))
                        .uv(44, 32).cuboid(-7.0f, -29.0f, 1.0f, 1.0f, 1.0f, 4.0f, Dilation(0.0f))
                        .uv(30, 52).cuboid(-8.0f, -33.0f, 3.0f, 1.0f, 5.0f, 1.0f, Dilation(0.0f))
                        .uv(30, 47).cuboid(-8.0f, -30.0f, -2.0f, 1.0f, 1.0f, 4.0f, Dilation(0.0f))
                        .uv(34, 52).cuboid(-7.0f, -34.0f, -2.0f, 1.0f, 5.0f, 1.0f, Dilation(0.0f))
                        .uv(48, 13).cuboid(-7.0f, -31.0f, -5.0f, 1.0f, 1.0f, 3.0f, Dilation(0.0f)),
                    ModelTransform.of(0.0f, 0.0f, 0.0f,0.0f, 0.0f, 0.0f)
                )

                val l: ModelPartData? = antlers.addChild(
                    "l",
                    ModelPartBuilder.create().uv(48, 17).cuboid(-4.0f, -25.0f, 2.0f, 2.0f, 2.0f, 2.0f, Dilation(0.0f))
                        .uv(48, 21).cuboid(-2.0f, -25.0f, 3.0f, 1.0f, 1.0f, 3.0f, Dilation(0.0f))
                        .uv(44, 26).cuboid(-1.0f, -26.0f, 5.0f, 1.0f, 1.0f, 5.0f, Dilation(0.0f))
                        .uv(4, 53).cuboid(-1.0f, -29.0f, 6.0f, 1.0f, 3.0f, 1.0f, Dilation(0.0f))
                        .uv(50, 47).cuboid(0.0f, -28.0f, 4.0f, 1.0f, 1.0f, 3.0f, Dilation(0.0f))
                        .uv(0, 53).cuboid(0.0f, -32.0f, 7.0f, 1.0f, 4.0f, 1.0f, Dilation(0.0f))
                        .uv(40, 47).cuboid(0.0f, -29.0f, 1.0f, 1.0f, 1.0f, 4.0f, Dilation(0.0f))
                        .uv(38, 52).cuboid(1.0f, -33.0f, 3.0f, 1.0f, 5.0f, 1.0f, Dilation(0.0f))
                        .uv(48, 0).cuboid(1.0f, -30.0f, -2.0f, 1.0f, 1.0f, 4.0f, Dilation(0.0f))
                        .uv(42, 52).cuboid(0.0f, -34.0f, -2.0f, 1.0f, 5.0f, 1.0f, Dilation(0.0f))
                        .uv(50, 51).cuboid(0.0f, -31.0f, -5.0f, 1.0f, 1.0f, 3.0f, Dilation(0.0f)),
                    ModelTransform.of(4.0f, 0.0f, 0.0f,0.0f, 0.0f, 0.0f)
                )

                val neck: ModelPartData? = wildDeer.addChild(
                    "neck",
                    ModelPartBuilder.create().uv(20, 26).cuboid(-1.5f, -8.5f, -2.0f, 3.0f, 9.0f, 4.0f, Dilation(0.0f)),
                    ModelTransform.of(-1.0f, -17.4532f, 0.7887f, 0.3491f, 0.0f, 0.0f)
                )

                val body: ModelPartData? = wildDeer.addChild(
                    "body",
                    ModelPartBuilder.create().uv(0, 0).cuboid(-3.0f, -4.0f, -9.0f, 6.0f, 8.0f, 18.0f, Dilation(0.0f)),
                    ModelTransform.of(-1.0f, -16.0f, 8.0f,0.0f, 0.0f, 0.0f)
                )

                val bl_leg: ModelPartData? = wildDeer.addChild(
                    "bl_leg",
                    ModelPartBuilder.create().uv(34, 26).cuboid(-1.0f, 0.0f, -1.5f, 2.0f, 12.0f, 3.0f, Dilation(0.0f)),
                    ModelTransform.of(1.0f, -12.0f, 15.5f,0.0f, 0.0f, 0.0f)
                )

                val fl_leg: ModelPartData? = wildDeer.addChild(
                    "fl_leg",
                    ModelPartBuilder.create().uv(10, 38).cuboid(-1.0f, 0.0f, -1.5f, 2.0f, 12.0f, 3.0f, Dilation(0.0f)),
                    ModelTransform.of(1.0f, -12.0f, 1.5f,0.0f, 0.0f, 0.0f)
                )

                val br_leg: ModelPartData? = wildDeer.addChild(
                    "br_leg",
                    ModelPartBuilder.create().uv(0, 38).cuboid(-1.0f, 0.0f, -1.5f, 2.0f, 12.0f, 3.0f, Dilation(0.0f)),
                    ModelTransform.of(-3.0f, -12.0f, 15.5f,0.0f, 0.0f, 0.0f)
                )

                val fr_leg: ModelPartData? = wildDeer.addChild(
                    "fr_leg",
                    ModelPartBuilder.create().uv(20, 39).cuboid(-1.0f, 0.0f, -1.5f, 2.0f, 12.0f, 3.0f, Dilation(0.0f)),
                    ModelTransform.of(-3.0f, -12.0f, 1.5f,0.0f, 0.0f, 0.0f)
                )
                return TexturedModelData.of(modelData, 64, 64)
            }
    }

    private val walkingAnimation: Animation? = WildDeerAnim.ANIM_WILD_DEER_WALK?.createAnimation(modelRoot)
    private val eatingAnimation: Animation? = WildDeerAnim.ANIM_WILD_DEER_EAT?.createAnimation(modelRoot)

    override fun setAngles(state: WildDeerRenderState) {
        super.setAngles(state)
        setHeadAngles(state.relativeHeadYaw, state.pitch)

        this.antlers.visible = !state.baby

        if (state.baby) {
            head.scale(Vector3f(0.65f, 0.65f, 0.65f))
        }

        walkingAnimation?.applyWalking(state.limbSwingAnimationProgress, state.limbSwingAmplitude, 2f, 2.5f)
        eatingAnimation?.apply(state.eatAnimationState, state.age, 1f)
    }

    private fun setHeadAngles(headYaw: Float, headPitch: Float) {
        val clampedYaw = MathHelper.clamp(headYaw, -30.0f, 30.0f)
        val clampedPitch = MathHelper.clamp(headPitch, -25.0f, 45.0f)

        head.yaw = clampedYaw * 0.017453292f
        head.pitch = clampedPitch * 0.017453292f
    }
}