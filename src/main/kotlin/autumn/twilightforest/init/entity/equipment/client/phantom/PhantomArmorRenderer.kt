package autumn.twilightforest.init.entity.equipment.client.phantom

import autumn.twilightforest.TwilightForest
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer
import net.minecraft.client.model.Dilation
import net.minecraft.client.render.VertexConsumerProvider
import net.minecraft.client.render.entity.model.BipedEntityModel
import net.minecraft.client.render.entity.state.BipedEntityRenderState
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.entity.EquipmentSlot
import net.minecraft.item.ItemStack
import net.minecraft.util.Identifier

object PhantomArmorRenderer : ArmorRenderer {

    val outerModel = PhantomArmorModel(PhantomArmorModel.getTexturedModelData(Dilation(1.0f)).createModel())

    override fun render(
        matrices: MatrixStack,
        vertexConsumers: VertexConsumerProvider,
        stack: ItemStack,
        bipedEntityRenderState: BipedEntityRenderState,
        slot: EquipmentSlot,
        light: Int,
        contextModel: BipedEntityModel<BipedEntityRenderState>
    ) {
        val model = outerModel

        model.head.visible = false
        model.hat.visible = false
        model.body.visible = false
        model.rightArm.visible = false
        model.leftArm.visible = false
        model.rightLeg.visible = false
        model.leftLeg.visible = false

        when (slot) {
            EquipmentSlot.HEAD -> {
                model.head.visible = true
                model.hat.visible = true
            }

            EquipmentSlot.CHEST -> {
                model.body.visible = true
                model.rightArm.visible = true
                model.leftArm.visible = true
            }

            EquipmentSlot.LEGS -> {
                model.rightLeg.visible = false
                model.leftLeg.visible = false
            }

            EquipmentSlot.FEET -> {
                model.rightLeg.visible = false
                model.leftLeg.visible = false
            }

            else -> {
                model.head.visible = false
                model.hat.visible = false
                model.body.visible = false
                model.rightArm.visible = false
                model.leftArm.visible = false
                model.rightLeg.visible = false
                model.leftLeg.visible = false
            }
        }

        model.setAngles(
            bipedEntityRenderState
        )

        ArmorRenderer.renderPart(
            matrices,
            vertexConsumers,
            light,
            stack,
            model,
            textureForSlot(slot)
        )
    }

    private fun textureForSlot(slot: EquipmentSlot): Identifier {
        return when (slot) {
            EquipmentSlot.HEAD -> Identifier.of(TwilightForest.MOD_ID, "textures/entity/equipment/humanoid/phantom.png")
            EquipmentSlot.CHEST -> Identifier.of(TwilightForest.MOD_ID, "textures/entity/equipment/humanoid/phantom.png")
            EquipmentSlot.LEGS -> Identifier.of(TwilightForest.MOD_ID, "textures/entity/equipment/humanoid_leggings/phantom.png")
            EquipmentSlot.FEET -> Identifier.of(TwilightForest.MOD_ID, "textures/entity/equipment/humanoid/phantom.png")

            else -> {
                Identifier.of("")
            }
        }
    }
}
