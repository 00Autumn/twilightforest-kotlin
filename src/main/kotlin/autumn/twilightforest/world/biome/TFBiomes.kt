package autumn.twilightforest.world.biome

import autumn.twilightforest.TwilightForest
import net.minecraft.registry.Registerable
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier
import net.minecraft.world.biome.Biome
import net.minecraft.world.biome.BiomeEffects
import net.minecraft.world.biome.GenerationSettings
import net.minecraft.world.biome.SpawnSettings

object TFBiomes {
    val FOREST_KEY = registerKey("forest_key")
    val DARK_FOREST_KEY = registerKey("dark_forest_key")
    val ENCHANTED_FOREST_KEY = registerKey("enchanted_forest_key")

    fun bootstrap(context: Registerable<Biome>) {
        register(context, FOREST_KEY, createForestBiome())
        register(context, DARK_FOREST_KEY, createDarkForestBiome())
        register(context, ENCHANTED_FOREST_KEY, createEnchantedForestBiome())
    }

    fun createForestBiome(): Biome {
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
                SpawnSettings.Builder().build()
            )
            .generationSettings(
                GenerationSettings.Builder().build()
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