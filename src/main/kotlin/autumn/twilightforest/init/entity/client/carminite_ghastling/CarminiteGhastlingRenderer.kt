package autumn.twilightforest.init.entity.client.carminite_ghastling

import autumn.twilightforest.TwilightForest
import autumn.twilightforest.init.entity.vanilla.carminite_ghastling.CarminiteGhastlingEntity
import net.minecraft.client.render.VertexConsumerProvider
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.MobEntityRenderer
import net.minecraft.client.render.entity.model.EntityModelLayers
import net.minecraft.client.render.entity.model.GhastEntityModel
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.util.Identifier

class CarminiteGhastlingRenderer(context: EntityRendererFactory.Context) : MobEntityRenderer<CarminiteGhastlingEntity, CarminiteGhastlingRenderState, GhastEntityModel>(context, GhastEntityModel(context.getPart(EntityModelLayers.GHAST)), 1.5F) {
    private val NORMAL = Identifier.of(TwilightForest.MOD_ID, "textures/entity/carminite_ghasts/carminite_ghast.png")
    private val LOOKING = Identifier.of(TwilightForest.MOD_ID, "textures/entity/carminite_ghasts/carminite_ghast_looking.png")
    private val SHOOTING = Identifier.of(TwilightForest.MOD_ID, "textures/entity/carminite_ghasts/carminite_ghast_shooting.png")

    override fun getTexture(state: CarminiteGhastlingRenderState): Identifier? {
        return if (state.looking) {
            LOOKING
        } else if (state.shooting) {
            SHOOTING
        } else {
            NORMAL
        }
    }

    override fun render(livingEntityRenderState: CarminiteGhastlingRenderState?, matrixStack: MatrixStack?, vertexConsumerProvider: VertexConsumerProvider?, i: Int) {
        matrixStack?.scale(0.25F, 0.25F, 0.25F)
        super.render(livingEntityRenderState, matrixStack, vertexConsumerProvider, i)
    }

    override fun createRenderState(): CarminiteGhastlingRenderState? {
        return CarminiteGhastlingRenderState()
    }

    override fun updateRenderState(entity: CarminiteGhastlingEntity, state: CarminiteGhastlingRenderState, tickDelta: Float) {
        super.updateRenderState(entity, state, tickDelta)
        state.shooting = entity.isShooting

        val maxTargetingRange = 10.0
        val lookingRange = maxTargetingRange * 5
        val closestPlayer = entity.world.getClosestPlayer(entity, lookingRange)
        state.looking = closestPlayer != null &&
                entity.canSee(closestPlayer) &&
                entity.squaredDistanceTo(closestPlayer) < lookingRange * lookingRange
    }
}