package autumn.twilightforest.init.block.custom

import net.minecraft.block.BlockState
import net.minecraft.block.TintedParticleLeavesBlock

class TFLeavesBlock(leafParticleChance: Float, settings: Settings) : TintedParticleLeavesBlock(leafParticleChance, settings) {
    override fun shouldDecay(state: BlockState?): Boolean {
        return false
    }
}