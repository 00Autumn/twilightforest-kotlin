package autumn.twilightforest.init.entity.client.dwarf_rabbit

import DwarfRabbitModel
import autumn.twilightforest.TwilightForest
import autumn.twilightforest.init.entity.custom.DwarfRabbitEntity
import autumn.twilightforest.init.entity.custom.DwarfRabbitVariant
import net.minecraft.client.render.VertexConsumerProvider
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.MobEntityRenderer
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.util.Identifier


class DwarfRabbitRenderer(
    context: EntityRendererFactory.Context
) : MobEntityRenderer<DwarfRabbitEntity, DwarfRabbitRenderState, DwarfRabbitModel>(
    context,
    DwarfRabbitModel(context.getPart(DwarfRabbitModel.DWARF_RABBIT)),
    0.25F
) {

    override fun getTexture(state: DwarfRabbitRenderState): Identifier? {
        return LOCATION_BY_VARIANT[state.variant]
    }

    override fun render(livingEntityRenderState: DwarfRabbitRenderState?, matrixStack: MatrixStack?, vertexConsumerProvider: VertexConsumerProvider?, i: Int) {
        if(livingEntityRenderState?.baby == true) {
            matrixStack?.scale(0.5F, 0.5F, 0.5F)
        } else {
            matrixStack?.scale(1.0F, 1.0F, 1.0F)
        }

        super.render(livingEntityRenderState, matrixStack, vertexConsumerProvider, i)
    }

    override fun createRenderState(): DwarfRabbitRenderState {
        return DwarfRabbitRenderState()
    }

    override fun updateRenderState(entity: DwarfRabbitEntity, state: DwarfRabbitRenderState, tickDelta: Float) {
        super.updateRenderState(entity, state, tickDelta)
        state.variant = entity.getVariant()
    }

    private val DEFAULT_TEXTURE = Identifier.of(TwilightForest.MOD_ID, "textures/entity/dwarf_rabbit/dwarf_rabbit_mocha.png")

    private val LOCATION_BY_VARIANT: Map<DwarfRabbitVariant, Identifier> =
        buildMap {
            put(DwarfRabbitVariant.MOCHA, DEFAULT_TEXTURE)
            put(DwarfRabbitVariant.DUTCH, Identifier.of(TwilightForest.MOD_ID, "textures/entity/dwarf_rabbit/dwarf_rabbit_dutch.png"))
            put(DwarfRabbitVariant.CREAM, Identifier.of(TwilightForest.MOD_ID, "textures/entity/dwarf_rabbit/dwarf_rabbit_cream.png"))
        }
}