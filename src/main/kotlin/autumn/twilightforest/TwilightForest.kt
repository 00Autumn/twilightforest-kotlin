package autumn.twilightforest

import autumn.twilightforest.component.TFDataComponentTypes
import autumn.twilightforest.init.block.TFBlocks
import autumn.twilightforest.init.block.entity.TFBlockEntities
import autumn.twilightforest.init.entity.TFEntities
import autumn.twilightforest.init.entity.custom.dwarf_rabbit.DwarfRabbitEntity
import autumn.twilightforest.init.item.TFFoodComponents
import autumn.twilightforest.init.item.TFItemGroups
import autumn.twilightforest.init.item.TFItems
import autumn.twilightforest.client.screen.TFScreenHandlers
import autumn.twilightforest.init.entity.custom.squirrel.SquirrelEntity
import autumn.twilightforest.init.entity.custom.tiny_bird.TinyBirdEntity
import autumn.twilightforest.init.entity.custom.wild_deer.WildDeerEntity
import autumn.twilightforest.init.entity.vanilla.bighorn_sheep.BighornSheepEntity
import autumn.twilightforest.init.entity.vanilla.carminite_broodling.CarminiteBroodlingEntity
import autumn.twilightforest.init.entity.vanilla.king_spider.KingSpiderEntity
import autumn.twilightforest.init.entity.vanilla.knight_phantom.KnightPhantomEntity
import autumn.twilightforest.init.entity.vanilla.mist_wolf.MistWolfEntity
import autumn.twilightforest.init.entity.vanilla.skeleton_druid.SkeletonDruidEntity
import autumn.twilightforest.init.entity.vanilla.swarm_spider.SwarmSpiderEntity
import autumn.twilightforest.init.entity.vanilla.winter_wolf.WinterWolfEntity
import autumn.twilightforest.util.TFBlockFamilies
import autumn.twilightforest.util.TFBlockSetTypes
import autumn.twilightforest.util.TFLootTables
import autumn.twilightforest.util.TFWoodTypes
import autumn.twilightforest.world.foliage.TFFoliagePlacerTypes
import autumn.twilightforest.world.gen.TFWorldGeneration
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.`object`.builder.v1.entity.FabricDefaultAttributeRegistry
import net.minecraft.entity.mob.GhastEntity
import net.minecraft.entity.mob.HostileEntity
import net.minecraft.entity.mob.SilverfishEntity
import net.minecraft.entity.mob.SpiderEntity
import net.minecraft.entity.passive.SheepEntity
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
		TFLootTables.registerLootTables()
		TFEntities.registerEntities()
		TFBlockEntities.registerBlockEntities()
		TFScreenHandlers.registerScreenHandlers()

		FabricDefaultAttributeRegistry.register(TFEntities.DWARF_RABBIT, DwarfRabbitEntity.createAttributes())
		FabricDefaultAttributeRegistry.register(TFEntities.TINY_BIRD, TinyBirdEntity.createAttributes())
		FabricDefaultAttributeRegistry.register(TFEntities.WILD_DEER, WildDeerEntity.createAttributes())
		FabricDefaultAttributeRegistry.register(TFEntities.TOWERWOOD_BORER, SilverfishEntity.createSilverfishAttributes())
		FabricDefaultAttributeRegistry.register(TFEntities.SQUIRREL, SquirrelEntity.createAttributes())
		FabricDefaultAttributeRegistry.register(TFEntities.MAZE_SLIME, HostileEntity.createHostileAttributes())
		FabricDefaultAttributeRegistry.register(TFEntities.CARMINITE_BROODLING, CarminiteBroodlingEntity.createCarminiteBroodlingAtrributes())
		FabricDefaultAttributeRegistry.register(TFEntities.KING_SPIDER, KingSpiderEntity.createKingSpiderAtrributes())
		FabricDefaultAttributeRegistry.register(TFEntities.SKELETON_DRUID, SkeletonDruidEntity.createSkeletonDruidAttributes())
		FabricDefaultAttributeRegistry.register(TFEntities.HEDGE_SPIDER, SpiderEntity.createSpiderAttributes())
		FabricDefaultAttributeRegistry.register(TFEntities.SWARM_SPIDER, SwarmSpiderEntity.createSwarmSpiderAtrributes())
		FabricDefaultAttributeRegistry.register(TFEntities.MIST_WOLF, MistWolfEntity.createMistWolfAttributes())
		FabricDefaultAttributeRegistry.register(TFEntities.WINTER_WOLF, WinterWolfEntity.createWinterWolfAttributes())
		FabricDefaultAttributeRegistry.register(TFEntities.CARMINITE_GHAST_GUARD, GhastEntity.createGhastAttributes())
		FabricDefaultAttributeRegistry.register(TFEntities.CARMINITE_GHASTLING, GhastEntity.createGhastAttributes())
		FabricDefaultAttributeRegistry.register(TFEntities.KNIGHT_PHANTOM, KnightPhantomEntity.creatKnightPhantomAttributes())
		FabricDefaultAttributeRegistry.register(TFEntities.BIGHORN_SHEEP, SheepEntity.createSheepAttributes())
	}

	fun id(path: String): Identifier {
		return Identifier.of(MOD_ID, path)
	}
}