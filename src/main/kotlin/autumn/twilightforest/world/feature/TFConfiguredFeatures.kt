package autumn.twilightforest.world.feature

import autumn.twilightforest.TwilightForest
import autumn.twilightforest.init.block.TFBlocks
import autumn.twilightforest.world.foliage.custom.CanopyFoliagePlacer
import autumn.twilightforest.world.foliage.custom.DarkFoliagePlacer
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.registry.Registerable
import net.minecraft.registry.RegistryEntryLookup
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier
import net.minecraft.util.math.intprovider.ConstantIntProvider
import net.minecraft.world.gen.feature.ConfiguredFeature
import net.minecraft.world.gen.feature.Feature
import net.minecraft.world.gen.feature.FeatureConfig
import net.minecraft.world.gen.feature.TreeFeatureConfig
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize
import net.minecraft.world.gen.foliage.BlobFoliagePlacer
import net.minecraft.world.gen.foliage.LargeOakFoliagePlacer
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider
import net.minecraft.world.gen.trunk.LargeOakTrunkPlacer
import net.minecraft.world.gen.trunk.StraightTrunkPlacer
import java.util.*

object TFConfiguredFeatures {

    val TWILIGHT_OAK_TREE_KEY = registerKey("twilight_oak_tree_key")
    val LARGE_TWILIGHT_OAK_TREE_KEY = registerKey("large_twilight_oak_tree_key")
    val CANOPY_TREE_KEY = registerKey("canopy_tree_key")
    val DARKWOOD_TREE_KEY = registerKey("darkwood_tree_key")

    fun bootstrap(context: Registerable<ConfiguredFeature<*, *>>) {
        val registryEntryLookup: RegistryEntryLookup<Block?> = context.getRegistryLookup<Block?>(RegistryKeys.BLOCK)

        register(context, TWILIGHT_OAK_TREE_KEY, Feature.TREE, TreeFeatureConfig.Builder(
            SimpleBlockStateProvider.of(TFBlocks.TWILIGHT_OAK_LOG),
            StraightTrunkPlacer(4, 2, 0),
            SimpleBlockStateProvider.of(TFBlocks.TWILIGHT_OAK_LEAVES),
            BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
            TwoLayersFeatureSize(1, 0, 1)
        ).build())

        register(context, LARGE_TWILIGHT_OAK_TREE_KEY, Feature.TREE, TreeFeatureConfig.Builder(
            SimpleBlockStateProvider.of(TFBlocks.TWILIGHT_OAK_LOG),
            LargeOakTrunkPlacer(3, 11, 0),
            SimpleBlockStateProvider.of(TFBlocks.TWILIGHT_OAK_LEAVES),
            LargeOakFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(4), 4),
            TwoLayersFeatureSize(4, 1, 0, OptionalInt.of(4))
        ).build())

        register(context,CANOPY_TREE_KEY, Feature.TREE,TreeFeatureConfig.Builder(
            SimpleBlockStateProvider.of(TFBlocks.CANOPY_LOG),
            StraightTrunkPlacer(25, 5, 5),
            SimpleBlockStateProvider.of(TFBlocks.CANOPY_LEAVES),
            CanopyFoliagePlacer(
                7.5,4.0,ConstantIntProvider.create(0),0.85f,24),
            TwoLayersFeatureSize(1, 1, 2))
            .dirtProvider(SimpleBlockStateProvider.of(Blocks.DIRT))
            .ignoreVines()
            .build())

        register(
            context,DARKWOOD_TREE_KEY, Feature.TREE, TreeFeatureConfig.Builder(
                SimpleBlockStateProvider.of(TFBlocks.DARK_LOG),
                StraightTrunkPlacer(10, 3, 1),
                SimpleBlockStateProvider.of(TFBlocks.DARK_LEAVES),
                DarkFoliagePlacer(7.0,3.5,ConstantIntProvider.create(0),0.9f,16),
                TwoLayersFeatureSize(1, 0, 2))
                .dirtProvider(SimpleBlockStateProvider.of(Blocks.DIRT))
                .ignoreVines()
                .build())
    }

    fun registerKey(name: String): RegistryKey<ConfiguredFeature<*, *>> {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(TwilightForest.MOD_ID, name))
    }

    private fun <FC : FeatureConfig, F : Feature<FC>> register(context: Registerable<ConfiguredFeature<*, *>>, key: RegistryKey<ConfiguredFeature<*, *>>, feature: F, configuration: FC) {
        context.register(key, ConfiguredFeature(feature, configuration))
    }
}