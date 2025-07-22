package autumn.twilightforest.init.entity.client.bighorn_sheep

import net.minecraft.client.model.Dilation
import net.minecraft.client.model.ModelPart
import net.minecraft.client.model.ModelPartBuilder
import net.minecraft.client.model.ModelTransform
import net.minecraft.client.model.TexturedModelData
import net.minecraft.client.render.entity.model.EntityModelLayer
import net.minecraft.client.render.entity.model.EntityModelPartNames
import net.minecraft.client.render.entity.model.QuadrupedEntityModel
import net.minecraft.client.render.entity.state.SheepEntityRenderState
import net.minecraft.util.Identifier

class BighornSheepModel(modelPart: ModelPart) : QuadrupedEntityModel<SheepEntityRenderState>(modelPart) {
    companion object {
        val BIGHORN_SHEEP: EntityModelLayer = EntityModelLayer(
            Identifier.of("twilightforest", "bighorn_sheep"), "main"
        )

        fun getTexturedModelData() : TexturedModelData {
            val modelData = getModelData(12, false, true, Dilation.NONE)
            val modelPartData = modelData.root

            modelPartData.addChild(
                EntityModelPartNames.HEAD,
                ModelPartBuilder.create().uv(0, 0).cuboid(-3.0f, -4.0f, -6.0f, 6.0f, 6.0f, 8.0f),
                ModelTransform.origin(0.0f, 6.0f, -8.0f)
            )
            modelPartData.addChild(
                EntityModelPartNames.BODY,
                ModelPartBuilder.create().uv(28, 8).cuboid(-4.0f, -10.0f, -7.0f, 8.0f, 16.0f, 6.0f),
                ModelTransform.of(0.0f, 5.0f, 2.0f, (Math.PI / 2).toFloat(), 0.0f, 0.0f)
            )

            val head = modelPartData.getChild(EntityModelPartNames.HEAD)

            head.addChild(
                "r_horn",
                ModelPartBuilder.create().uv(56, 26).cuboid(-5.0f, -22.0f, -12.0f, 2.0f, 2.0f, 2.0f, Dilation(0.0f))
                    .uv(52, 2).cuboid(-6.0f, -23.0f, -11.0f, 2.0f, 2.0f, 4.0f, Dilation(0.0f))
                    .uv(56, 17).cuboid(-7.0f, -22.0f, -8.0f, 2.0f, 5.0f, 2.0f, Dilation(0.0f))
                    .uv(21, 2).cuboid(-8.0f, -18.0f, -10.0f, 2.0f, 2.0f, 3.0f, Dilation(0.0f))
                    .uv(35, 3).cuboid(-9.0f, -19.0f, -11.0f, 2.0f, 2.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.of(0.0f, 18.0f, 8.0f, 0.0f, 0.0f, 0.0f)
            )

            head.addChild(
                "l_horn",
                ModelPartBuilder.create().uv(56, 26).mirrored()
                    .cuboid(3.0f, -22.0f, -12.0f, 2.0f, 2.0f, 2.0f, Dilation(0.0f)).mirrored(false)
                    .uv(52, 2).mirrored().cuboid(4.0f, -23.0f, -11.0f, 2.0f, 2.0f, 4.0f, Dilation(0.0f)).mirrored(false)
                    .uv(56, 17).mirrored().cuboid(5.0f, -22.0f, -8.0f, 2.0f, 5.0f, 2.0f, Dilation(0.0f)).mirrored(false)
                    .uv(21, 2).mirrored().cuboid(6.0f, -18.0f, -10.0f, 2.0f, 2.0f, 3.0f, Dilation(0.0f)).mirrored(false)
                    .uv(35, 3).mirrored().cuboid(7.0f, -19.0f, -11.0f, 2.0f, 2.0f, 1.0f, Dilation(0.0f))
                    .mirrored(false),
                ModelTransform.of(0.0f, 18.0f, 8.0f,0.0f, 0.0f, 0.0f)
            )
            return TexturedModelData.of(modelData, 64, 32)
        }
    }
    override fun setAngles(state: SheepEntityRenderState) {
        super.setAngles(state)
        head.originY += state.neckAngle * 9.0f * state.ageScale
        head.pitch = state.headAngle
    }
}