package autumn.twilightforest

import autumn.twilightforest.datagen.providers.TFBlockTagProvider
import autumn.twilightforest.datagen.providers.TFEnglishLanguageProvider
import autumn.twilightforest.datagen.providers.TFItemTagProvider
import autumn.twilightforest.datagen.providers.TFLootTableProvider
import autumn.twilightforest.datagen.providers.TFModelProvider
import autumn.twilightforest.datagen.providers.TFRecipeProvider
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator

object TwilightForestDataGenerator : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(fabricDataGenerator: FabricDataGenerator) {
        val pack = fabricDataGenerator.createPack()

        pack.addProvider(::TFBlockTagProvider)
        pack.addProvider(::TFItemTagProvider)
        pack.addProvider(::TFLootTableProvider)
        pack.addProvider(::TFModelProvider)
        pack.addProvider(::TFRecipeProvider)
        pack.addProvider(::TFEnglishLanguageProvider)
    }
}