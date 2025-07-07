package autumn.twilightforest.world.feature

import autumn.twilightforest.TwilightForest
import autumn.twilightforest.init.block.TFBlocks
import net.minecraft.registry.Registerable
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.entry.RegistryEntry
import net.minecraft.util.Identifier
import net.minecraft.world.gen.feature.ConfiguredFeature
import net.minecraft.world.gen.feature.Feature
import net.minecraft.world.gen.feature.FeatureConfig
import net.minecraft.world.gen.feature.PlacedFeature
import net.minecraft.world.gen.feature.PlacedFeatures
import net.minecraft.world.gen.feature.VegetationPlacedFeatures
import net.minecraft.world.gen.placementmodifier.PlacementModifier

object TFPlacedFeatures {

    val TWILIGHT_OAK_TREE_KEY = registerKey("twilight_oak_tree_key")
    val LARGE_TWILIGHT_OAK_TREE_KEY = registerKey("large_twilight_oak_tree_key")
    val CANOPY_TREE_KEY = registerKey("canopy_tree_key")

    fun bootstrap(context: Registerable<PlacedFeature>) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE)

        register(context, TWILIGHT_OAK_TREE_KEY, configuredFeatures.getOrThrow(TFConfiguredFeatures.TWILIGHT_OAK_TREE_KEY),
            VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                PlacedFeatures.createCountExtraModifier(1, 0.1F, 1),
                TFBlocks.TWILIGHT_OAK_SAPLING
            ))
        register(context, LARGE_TWILIGHT_OAK_TREE_KEY, configuredFeatures.getOrThrow(TFConfiguredFeatures.LARGE_TWILIGHT_OAK_TREE_KEY),
            VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                PlacedFeatures.createCountExtraModifier(1, 0.1F, 1),
                TFBlocks.TWILIGHT_OAK_SAPLING
            ))
        register(context, CANOPY_TREE_KEY, configuredFeatures.getOrThrow(TFConfiguredFeatures.CANOPY_TREE_KEY),
            VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                PlacedFeatures.createCountExtraModifier(7, 0.1F, 1),
                TFBlocks.CANOPY_SAPLING
            ))
    }

    fun registerKey(name: String): RegistryKey<PlacedFeature> {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(TwilightForest.MOD_ID, name))
    }

    private fun register(context: Registerable<PlacedFeature>, key: RegistryKey<PlacedFeature>, configuration: RegistryEntry<ConfiguredFeature<*, *>>, modifiers: List<PlacementModifier>) {
        context.register(key, PlacedFeature(configuration, modifiers.toList()))
    }

    private fun <FC : FeatureConfig, F : Feature<FC>> register(context: Registerable<PlacedFeature>, key: RegistryKey<PlacedFeature>, configuration: RegistryEntry<ConfiguredFeature<*, *>>, vararg modifiers: PlacementModifier) {
        register(context, key, configuration, modifiers.toList())
    }
}
