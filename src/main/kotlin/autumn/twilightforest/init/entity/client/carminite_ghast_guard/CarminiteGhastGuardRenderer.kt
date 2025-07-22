package autumn.twilightforest.init.entity.client.carminite_ghast_guard

import autumn.twilightforest.TwilightForest
import autumn.twilightforest.init.entity.vanilla.carminite_ghast_guard.CarminiteGhastGuardEntity
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.MobEntityRenderer
import net.minecraft.client.render.entity.model.EntityModelLayers
import net.minecraft.client.render.entity.model.GhastEntityModel
import net.minecraft.util.Identifier

class CarminiteGhastGuardRenderer(context: EntityRendererFactory.Context) : MobEntityRenderer<CarminiteGhastGuardEntity, CarminiteGhastGuardRenderState, GhastEntityModel>(context, GhastEntityModel(context.getPart(EntityModelLayers.GHAST)), 1.5F) {
    private val NORMAL = Identifier.of(TwilightForest.MOD_ID, "textures/entity/carminite_ghasts/carminite_ghast.png")
    private val LOOKING = Identifier.of(TwilightForest.MOD_ID, "textures/entity/carminite_ghasts/carminite_ghast_looking.png")
    private val SHOOTING = Identifier.of(TwilightForest.MOD_ID, "textures/entity/carminite_ghasts/carminite_ghast_shooting.png")

    override fun getTexture(state: CarminiteGhastGuardRenderState): Identifier? {
        return if (state.looking) {
            LOOKING
        } else if (state.shooting) {
            SHOOTING
        } else {
            NORMAL
        }
    }

    override fun createRenderState(): CarminiteGhastGuardRenderState? {
        return CarminiteGhastGuardRenderState()
    }

    override fun updateRenderState(entity: CarminiteGhastGuardEntity, state: CarminiteGhastGuardRenderState, tickDelta: Float) {
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