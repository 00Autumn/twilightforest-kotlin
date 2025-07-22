package autumn.twilightforest.init.entity.client.skeleton_druid.projectile

import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.ProjectileEntityRenderer
import net.minecraft.client.render.entity.state.ProjectileEntityRenderState
import net.minecraft.util.Identifier

class NatureBoltEntityRenderer(context: EntityRendererFactory.Context) : ProjectileEntityRenderer<NatureBolt, ProjectileEntityRenderState>(
    context
) {
    override fun getTexture(state: ProjectileEntityRenderState?): Identifier? {
        return Identifier.ofVanilla("textures/particle/glint.png")
    }

    override fun createRenderState(): ProjectileEntityRenderState? {
        return ProjectileEntityRenderState()
    }
}