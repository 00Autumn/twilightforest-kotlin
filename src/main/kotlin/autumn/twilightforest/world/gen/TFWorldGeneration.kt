package autumn.twilightforest.world.gen

import autumn.twilightforest.world.feature.TFPlacedFeatures
import autumn.twilightforest.world.biome.TFBiomes
import net.fabricmc.fabric.api.biome.v1.BiomeModifications
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors
import net.minecraft.world.gen.GenerationStep

object TFWorldGeneration {
    fun generateWorldGen() {

        BiomeModifications.addFeature(
            BiomeSelectors.includeByKey(TFBiomes.FOREST_KEY),
            GenerationStep.Feature.VEGETAL_DECORATION,
            TFPlacedFeatures.TWILIGHT_OAK_TREE_KEY
        )
        BiomeModifications.addFeature(
            BiomeSelectors.includeByKey(TFBiomes.FOREST_KEY),
            GenerationStep.Feature.VEGETAL_DECORATION,
            TFPlacedFeatures.LARGE_TWILIGHT_OAK_TREE_KEY
        )
        BiomeModifications.addFeature(
            BiomeSelectors.includeByKey(TFBiomes.FOREST_KEY),
            GenerationStep.Feature.VEGETAL_DECORATION,
            TFPlacedFeatures.CANOPY_TREE_KEY
        )

        BiomeModifications.addFeature(
            BiomeSelectors.includeByKey(TFBiomes.DARK_FOREST_KEY),
            GenerationStep.Feature.VEGETAL_DECORATION,
            TFPlacedFeatures.DARKWOOD_TREE_KEY
        )

        BiomeModifications.addFeature(
            BiomeSelectors.includeByKey(TFBiomes.ENCHANTED_FOREST_KEY),
            GenerationStep.Feature.VEGETAL_DECORATION,
            TFPlacedFeatures.RAINBOW_OAK_TREE_KEY
        )
        BiomeModifications.addFeature(
            BiomeSelectors.includeByKey(TFBiomes.ENCHANTED_FOREST_KEY),
            GenerationStep.Feature.VEGETAL_DECORATION,
            TFPlacedFeatures.LARGE_RAINBOW_OAK_TREE_KEY
        )
    }
}