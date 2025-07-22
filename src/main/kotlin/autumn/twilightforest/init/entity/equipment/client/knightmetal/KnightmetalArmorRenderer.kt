package autumn.twilightforest.init.entity.equipment.client.knightmetal

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

object KnightmetalArmorRenderer : ArmorRenderer {

    val innerModel = KnightmetalArmorModel(KnightmetalArmorModel.getTexturedModelData(Dilation(0.5f)).createModel())
    val outerModel = KnightmetalArmorModel(KnightmetalArmorModel.getTexturedModelData(Dilation(1.0f)).createModel())

    override fun render(
        matrices: MatrixStack,
        vertexConsumers: VertexConsumerProvider,
        stack: ItemStack,
        bipedEntityRenderState: BipedEntityRenderState,
        slot: EquipmentSlot,
        light: Int,
        contextModel: BipedEntityModel<BipedEntityRenderState>
    ) {
        val model = when (slot) {
            EquipmentSlot.LEGS -> innerModel
            else -> outerModel
        }

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
                model.rightLeg.visible = true
                model.leftLeg.visible = true
            }
            EquipmentSlot.FEET -> {
                model.rightLeg.visible = true
                model.leftLeg.visible = true
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
            EquipmentSlot.HEAD -> Identifier.of(TwilightForest.MOD_ID, "textures/entity/equipment/humanoid/knightmetal.png")
            EquipmentSlot.CHEST -> Identifier.of(TwilightForest.MOD_ID, "textures/entity/equipment/humanoid/knightmetal.png")
            EquipmentSlot.LEGS -> Identifier.of(TwilightForest.MOD_ID, "textures/entity/equipment/humanoid_leggings/knightmetal.png")
            EquipmentSlot.FEET -> Identifier.of(TwilightForest.MOD_ID, "textures/entity/equipment/humanoid/knightmetal.png")

            else -> {
                Identifier.of("")
            }
        }
    }
}