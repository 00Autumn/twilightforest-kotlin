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

    fun bootstrap(context: Registerable<Biome>) {
        register(context, FOREST_KEY, createForestBiome())
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

    fun registerKey(name: String): RegistryKey<Biome> {
        return RegistryKey.of(RegistryKeys.BIOME, Identifier.of(TwilightForest.MOD_ID, name))
    }

    private fun register(context: Registerable<Biome>, key: RegistryKey<Biome>, biome: Biome) {
        context.register(key, biome)
    }
}