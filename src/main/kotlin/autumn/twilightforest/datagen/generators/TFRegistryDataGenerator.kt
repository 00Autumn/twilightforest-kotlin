package autumn.twilightforest.datagen.generators

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.RegistryWrapper
import java.util.concurrent.CompletableFuture

class TFRegistryDataGenerator(output: FabricDataOutput, registriesFuture: CompletableFuture<RegistryWrapper.WrapperLookup>) : FabricDynamicRegistryProvider(output, registriesFuture) {
    override fun configure(registries: RegistryWrapper.WrapperLookup?, entries: Entries?) {
        entries?.addAll(registries?.getOrThrow(RegistryKeys.BIOME))
        entries?.addAll(registries?.getOrThrow(RegistryKeys.CONFIGURED_FEATURE))
        entries?.addAll(registries?.getOrThrow(RegistryKeys.PLACED_FEATURE))
    }

    override fun getName(): String? {
        return ""
    }
}