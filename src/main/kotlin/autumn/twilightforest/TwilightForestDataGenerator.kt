package autumn.twilightforest

import autumn.twilightforest.datagen.generators.TFRegistryDataGenerator
import autumn.twilightforest.datagen.providers.TFBiomeTagProvider
import autumn.twilightforest.datagen.providers.TFBlockTagProvider
import autumn.twilightforest.datagen.providers.TFEnglishLanguageProvider
import autumn.twilightforest.datagen.providers.TFItemTagProvider
import autumn.twilightforest.datagen.providers.TFLootTableProvider
import autumn.twilightforest.datagen.providers.TFModelProvider
import autumn.twilightforest.datagen.providers.TFRecipeProvider
import autumn.twilightforest.world.feature.TFConfiguredFeatures
import autumn.twilightforest.world.feature.TFPlacedFeatures
import autumn.twilightforest.world.biome.TFBiomes
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.minecraft.registry.RegistryBuilder
import net.minecraft.registry.RegistryKeys

object TwilightForestDataGenerator : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(fabricDataGenerator: FabricDataGenerator) {
        val pack = fabricDataGenerator.createPack()

        pack.addProvider(::TFBlockTagProvider)
        pack.addProvider(::TFItemTagProvider)
        pack.addProvider(::TFBiomeTagProvider)
        pack.addProvider(::TFLootTableProvider)
        pack.addProvider(::TFModelProvider)
        pack.addProvider(::TFRecipeProvider)
        pack.addProvider(::TFEnglishLanguageProvider)

        pack.addProvider(::TFRegistryDataGenerator)
    }

    override fun buildRegistry(registryBuilder: RegistryBuilder?) {
        registryBuilder?.addRegistry(RegistryKeys.BIOME, TFBiomes::bootstrap)
        registryBuilder?.addRegistry(RegistryKeys.CONFIGURED_FEATURE, TFConfiguredFeatures::bootstrap)
        registryBuilder?.addRegistry(RegistryKeys.PLACED_FEATURE, TFPlacedFeatures::bootstrap)
    }
}