package autumn.twilightforest

import autumn.twilightforest.datacomponent.TFDataComponentTypes
import autumn.twilightforest.init.block.TFBlocks
import autumn.twilightforest.init.item.TFFoodComponents
import autumn.twilightforest.init.item.TFItemGroups
import autumn.twilightforest.init.item.TFItems
import autumn.twilightforest.util.TFBlockFamilies
import autumn.twilightforest.util.TFBlockSetTypes
import autumn.twilightforest.util.TFWoodTypes
import net.fabricmc.api.ModInitializer
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
	}

	fun id(path: String): Identifier {
		return Identifier.of(MOD_ID, path)
	}
}