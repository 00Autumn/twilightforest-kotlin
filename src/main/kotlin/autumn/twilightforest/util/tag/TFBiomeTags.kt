package autumn.twilightforest.util.tag

import autumn.twilightforest.TwilightForest
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.tag.TagKey
import net.minecraft.util.Identifier
import net.minecraft.world.biome.Biome

object TFBiomeTags {
    val TWILIGHT_BIOMES = createTag("twilight_biomes")

    private fun createTag(name: String): TagKey<Biome> {
        return TagKey.of(RegistryKeys.BIOME, Identifier.of(TwilightForest.MOD_ID, name))
    }
}