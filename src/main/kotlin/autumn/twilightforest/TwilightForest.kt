package autumn.twilightforest

import autumn.twilightforest.component.TFDataComponentTypes
import autumn.twilightforest.init.block.TFBlocks
import autumn.twilightforest.init.entity.TFEntities
import autumn.twilightforest.init.entity.custom.DwarfRabbitEntity
import autumn.twilightforest.init.item.TFFoodComponents
import autumn.twilightforest.init.item.TFItemGroups
import autumn.twilightforest.init.item.TFItems
import autumn.twilightforest.util.TFBlockFamilies
import autumn.twilightforest.util.TFBlockSetTypes
import autumn.twilightforest.util.TFWoodTypes
import autumn.twilightforest.world.biome.TFBiomes
import autumn.twilightforest.world.foliage.TFFoliagePlacerTypes
import autumn.twilightforest.world.gen.TFWorldGeneration
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.`object`.builder.v1.entity.FabricDefaultAttributeRegistry
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object TwilightForest : ModInitializer {
	const val MOD_ID = "twilightforest"
    val logger: Logger? = LoggerFactory.getLogger(MOD_ID)

	override fun onInitialize() {
		TFBlockSetTypes.registerBlockSetTypes()
		TFWoodTypes.registerWoodTypes()
		TFBlockFamilies.registerBlockFamilies()
		TFBlocks.registerBlocks()
		TFItems.registerItems()
		TFFoodComponents.registerFoodComponents()
		TFItemGroups.registerItemGroups()
		TFDataComponentTypes.registerDataComponentTypes()
		TFFoliagePlacerTypes.registerFoliagePlacerTypes()
		TFWorldGeneration.generateWorldGen()
		TFEntities.registerEntities()

		FabricDefaultAttributeRegistry.register(TFEntities.DWARF_RABBIT, DwarfRabbitEntity.createAttributes())
	}

	fun id(path: String): Identifier {
		return Identifier.of(MOD_ID, path)
	}
}