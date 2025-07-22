package autumn.twilightforest.world.biome

import autumn.twilightforest.TwilightForest
import autumn.twilightforest.init.entity.TFEntities
import autumn.twilightforest.world.feature.TFPlacedFeatures
import net.minecraft.block.Block
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnGroup
import net.minecraft.entity.passive.ChickenEntity
import net.minecraft.registry.Registerable
import net.minecraft.registry.RegistryEntryLookup
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier
import net.minecraft.world.biome.Biome
import net.minecraft.world.biome.BiomeEffects
import net.minecraft.world.biome.GenerationSettings
import net.minecraft.world.biome.SpawnSettings
import net.minecraft.world.gen.GenerationStep
import net.minecraft.world.gen.feature.PlacedFeature
import net.minecraft.world.gen.feature.PlacedFeatures

object TFBiomes {

    val FOREST_KEY = registerKey("forest_key")
    val DARK_FOREST_KEY = registerKey("dark_forest_key")
    val ENCHANTED_FOREST_KEY = registerKey("enchanted_forest_key")

    fun bootstrap(context: Registerable<Biome>) {
        var placedFeatures = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE)

        register(context, FOREST_KEY, createForestBiome(placedFeatures))
        register(context, DARK_FOREST_KEY, createDarkForestBiome())
        register(context, ENCHANTED_FOREST_KEY, createEnchantedForestBiome())
    }

    fun createForestBiome(placedFeatures: RegistryEntryLookup<PlacedFeature>): Biome {
        return Biome.Builder()
            .temperature(0.5f)
            .downfall(0.5f)
            .precipitation(true)
            .effects(
                BiomeEffects.Builder()
                    .skyColor(2105930)
                    .fogColor(12648408)
                    .waterColor(4159204)
                    .waterFogColor(329011)
                    .grassColor(0x48B518)
                    .foliageColor(0x48B518)
                    .build()
            )
            .spawnSettings(
                SpawnSettings.Builder()
                    .creatureSpawnProbability(0.15F)
                    .spawn(SpawnGroup.CREATURE, 10, SpawnSettings.SpawnEntry(EntityType.CHICKEN, 4, 4))
                    .spawn(SpawnGroup.CREATURE, 15, SpawnSettings.SpawnEntry(TFEntities.WILD_DEER, 4, 5))
                    .spawn(SpawnGroup.CREATURE, 5, SpawnSettings.SpawnEntry(EntityType.WOLF, 4, 4))
                    .spawn(SpawnGroup.CREATURE, 15, SpawnSettings.SpawnEntry(TFEntities.TINY_BIRD, 4, 8))
                    .spawn(SpawnGroup.CREATURE, 10, SpawnSettings.SpawnEntry(TFEntities.DWARF_RABBIT, 4, 5))
                    .build()
            )
            .generationSettings(
                GenerationSettings.Builder()
                    .feature(GenerationStep.Feature.LOCAL_MODIFICATIONS, placedFeatures.getOrThrow(RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.ofVanilla("disk_sand"))))
                    .feature(GenerationStep.Feature.LOCAL_MODIFICATIONS, placedFeatures.getOrThrow(RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.ofVanilla("disk_clay"))))
                    .feature(GenerationStep.Feature.LOCAL_MODIFICATIONS, placedFeatures.getOrThrow(RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.ofVanilla("disk_gravel"))))

                    .feature(GenerationStep.Feature.VEGETAL_DECORATION, placedFeatures.getOrThrow(RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.ofVanilla("patch_tall_grass"))))
                    .feature(GenerationStep.Feature.VEGETAL_DECORATION, placedFeatures.getOrThrow(RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.ofVanilla("patch_sugar_cane"))))
                    .feature(GenerationStep.Feature.VEGETAL_DECORATION, placedFeatures.getOrThrow(RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.ofVanilla("patch_large_fern"))))
                    .feature(GenerationStep.Feature.VEGETAL_DECORATION, placedFeatures.getOrThrow(TFPlacedFeatures.TWILIGHT_OAK_TREE_KEY))
                    .feature(GenerationStep.Feature.VEGETAL_DECORATION, placedFeatures.getOrThrow(TFPlacedFeatures.LARGE_TWILIGHT_OAK_TREE_KEY))
                    .feature(GenerationStep.Feature.VEGETAL_DECORATION, placedFeatures.getOrThrow(TFPlacedFeatures.CANOPY_TREE_KEY))

                    .feature(GenerationStep.Feature.TOP_LAYER_MODIFICATION, placedFeatures.getOrThrow(RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.ofVanilla("freeze_top_layer"))))
                    .build()
            )
            .build()
    }
    fun createDarkForestBiome(): Biome {
        return Biome.Builder()
            .temperature(0.7f)
            .downfall(0.8f)
            .precipitation(true)
            .effects(
                BiomeEffects.Builder()
                    .skyColor(0x000000)
                    .fogColor(0x000000)
                    .waterColor(4159204)
                    .waterFogColor(329011)
                    .grassColor(0x4B6754)
                    .foliageColor(0x3B5E3F)
                    .build()
            )
            .spawnSettings(
                SpawnSettings.Builder().build()
            )
            .generationSettings(
                GenerationSettings.Builder().build()
            )
            .build()
    }
    fun createEnchantedForestBiome(): Biome {
        return Biome.Builder()
            .temperature(0.5f)
            .downfall(0.5f)
            .precipitation(false)
            .effects(
                BiomeEffects.Builder()
                    .skyColor(2105930)
                    .fogColor(12648408)
                    .waterColor(4159204)
                    .waterFogColor(329011)
                    .grassColor(0x00FFFF)
                    .foliageColor(0x00FFFF)
                    .build()
            )
            .spawnSettings(
                SpawnSettings.Builder().build()
            )
            .generationSettings(
                GenerationSettings.Builder().build()
            )
            .build()
    }

    fun registerKey(name: String): RegistryKey<Biome> {
        return RegistryKey.of(RegistryKeys.BIOME, Identifier.of(TwilightForest.MOD_ID, name))
    }

    private fun register(context: Registerable<Biome>, key: RegistryKey<Biome>, biome: Biome) {
        context.register(key, biome)
    }
}