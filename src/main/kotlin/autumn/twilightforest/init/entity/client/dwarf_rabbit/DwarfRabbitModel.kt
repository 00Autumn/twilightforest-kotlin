import autumn.twilightforest.TwilightForest
import autumn.twilightforest.init.entity.client.dwarf_rabbit.DwarfRabbitAnim
import autumn.twilightforest.init.entity.client.dwarf_rabbit.DwarfRabbitRenderState
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

// Made with Blockbench 4.12.5
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
class DwarfRabbitModel(root: ModelPart) : EntityModel<DwarfRabbitRenderState>(root) {
    private val modelRoot: ModelPart = root.getChild("root")
    private val dwarfRabbit: ModelPart = modelRoot.getChild("dwarf_rabbit")
    private val head: ModelPart = dwarfRabbit.getChild("head")
    private val rEar: ModelPart = dwarfRabbit.getChild("r_ear")
    private val lEar: ModelPart = dwarfRabbit.getChild("l_ear")
    private val body: ModelPart = dwarfRabbit.getChild("body")
    private val frLeg: ModelPart = dwarfRabbit.getChild("fr_leg")
    private val brLeg: ModelPart = dwarfRabbit.getChild("br_leg")
    private val flLeg: ModelPart = dwarfRabbit.getChild("fl_leg")
    private val blLeg: ModelPart = dwarfRabbit.getChild("bl_leg")
    private val tail: ModelPart = dwarfRabbit.getChild("tail")

    companion object {
        val DWARF_RABBIT = EntityModelLayer(Identifier.of(TwilightForest.MOD_ID, "dwarf_rabbit"), "main")

        fun getTexturedModelData(): TexturedModelData {
            val modelData = ModelData()
            val modelPartData = modelData.root
            val root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.of(0.0f, 24.0f, 0.0f, 0.0f, 0.0f, 0.0f))
            val dwarfRabbit = root.addChild(
                "dwarf_rabbit", ModelPartBuilder.create(),
                ModelTransform.of(-1.0f, 3.0f, -6.0f, 0.0f, 1.5708f, 0.0f)
            )

            dwarfRabbit.addChild(
                "head", ModelPartBuilder.create().uv(0, 7)
                    .cuboid(-2.0f, -2.0f, -2.0f, 4.0f, 4.0f, 4.0f, Dilation(0.1f)),
                ModelTransform.of(-3.0f, -7.0f, 1.0f, 0.0f, 0.0f, 0.0f)
            )
            dwarfRabbit.addChild(
                "r_ear", ModelPartBuilder.create().uv(8, 15)
                    .cuboid(-0.5f, -4.0f, -4.0f, 1.0f, 4.0f, 2.0f, Dilation(0.1f)),
                ModelTransform.of(-4.5f, -9.0f, 2.5f, 0.0f, 0.0f, 0.0f)
            )
            dwarfRabbit.addChild(
                "l_ear", ModelPartBuilder.create().uv(14, 15)
                    .cuboid(-0.5f, -4.0f, 2.0f, 1.0f, 4.0f, 2.0f, Dilation(0.1f)),
                ModelTransform.of(-4.5f, -9.0f, -0.5f, 0.0f, 0.0f, 0.0f)
            )
            dwarfRabbit.addChild(
                "body", ModelPartBuilder.create().uv(0, 0)
                    .cuboid(-2.5f, -1.5f, -2.0f, 5.0f, 3.0f, 4.0f, Dilation(0.0f)),
                ModelTransform.of(-5.5f, -5.5f, 1.0f, 0.0f, 0.0f, 0.0f)
            )
            dwarfRabbit.addChild(
                "fr_leg", ModelPartBuilder.create().uv(16, 7)
                    .cuboid(-0.5f, 0.0f, -0.5f, 1.0f, 1.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.of(-3.5f, -4.0f, -0.5f, 0.0f, 0.0f, 0.0f)
            )
            dwarfRabbit.addChild(
                "br_leg", ModelPartBuilder.create().uv(16, 9)
                    .cuboid(-0.5f, 0.0f, -0.5f, 1.0f, 1.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.of(-7.5f, -4.0f, -0.5f, 0.0f, 0.0f, 0.0f)
            )
            dwarfRabbit.addChild(
                "fl_leg", ModelPartBuilder.create().uv(16, 13)
                    .cuboid(-0.5f, 0.0f, -0.5f, 1.0f, 1.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.of(-3.5f, -4.0f, 2.5f, 0.0f, 0.0f, 0.0f)
            )
            dwarfRabbit.addChild(
                "bl_leg", ModelPartBuilder.create().uv(16, 11)
                    .cuboid(-0.5f, 0.0f, -0.5f, 1.0f, 1.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.of(-7.5f, -4.0f, 2.5f, 0.0f, 0.0f, 0.0f)
            )
            dwarfRabbit.addChild(
                "tail", ModelPartBuilder.create().uv(0, 15)
                    .cuboid(-2.0f, -2.0f, -1.0f, 2.0f, 2.0f, 2.0f, Dilation(0.0f)),
                ModelTransform.of(-8.0f, -6.0f, 1.0f, 0.0f, 0.0f, 0.0f)
            )

            return TexturedModelData.of(modelData, 32, 32)
        }
    }

    private val walkingAnimation: Animation? = DwarfRabbitAnim.ANIM_DWARF_RABBIT_WALK?.createAnimation(modelRoot)

    override fun setAngles(state: DwarfRabbitRenderState) {
        super.setAngles(state)
        setHeadAngles(state.relativeHeadYaw, state.pitch)

        walkingAnimation?.applyWalking(state.limbSwingAnimationProgress, state.limbSwingAmplitude, 2f, 2.5f)
    }

    private fun setHeadAngles(headYaw: Float, headPitch: Float) {
        val clampedYaw = MathHelper.clamp(headYaw, -30.0f, 30.0f)
        val clampedPitch = MathHelper.clamp(headPitch, -25.0f, 45.0f)

        head.yaw = clampedYaw * 0.017453292f
        head.pitch = clampedPitch * 0.017453292f
    }
}
