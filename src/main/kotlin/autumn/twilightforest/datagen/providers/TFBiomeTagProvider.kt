package autumn.twilightforest.datagen.providers

import autumn.twilightforest.util.tag.TFBiomeTags
import autumn.twilightforest.world.biome.TFBiomes
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryWrapper
import net.minecraft.world.biome.Biome
import java.util.concurrent.CompletableFuture

class TFBiomeTagProvider(
    output: FabricDataOutput,
    registriesFuture: CompletableFuture<RegistryWrapper.WrapperLookup>
) : FabricTagProvider<Biome>(output, net.minecraft.registry.RegistryKeys.BIOME, registriesFuture) {
    override fun configure(wrapperLookup: RegistryWrapper.WrapperLookup) {
        builder(autumn.twilightforest.util.tag.TFBiomeTags.TWILIGHT_BIOMES)
            .add(autumn.twilightforest.world.biome.TFBiomes.FOREST_KEY)
    }
}