package autumn.twilightforest

import autumn.twilightforest.boat.api.client.TFBoatClientHelper
import autumn.twilightforest.client.foliage.TFColorHandlers
import autumn.twilightforest.init.block.TFBlocks
import autumn.twilightforest.init.entity.TFEntities
import autumn.twilightforest.init.entity.client.bighorn_sheep.BighornSheepModel
import autumn.twilightforest.init.entity.client.bighorn_sheep.BighornSheepRenderer
import autumn.twilightforest.init.entity.client.carminite_broodling.CarminiteBroodlingRenderer
import autumn.twilightforest.init.entity.client.carminite_ghast_guard.CarminiteGhastGuardRenderer
import autumn.twilightforest.init.entity.client.carminite_ghastling.CarminiteGhastlingRenderer
import autumn.twilightforest.init.entity.client.dwarf_rabbit.DwarfRabbitModel
import autumn.twilightforest.init.entity.client.dwarf_rabbit.DwarfRabbitRenderer
import autumn.twilightforest.init.entity.client.hedge_spider.HedgeSpiderRenderer
import autumn.twilightforest.init.entity.client.king_spider.KingSpiderRenderer
import autumn.twilightforest.init.entity.client.knight_phantom.KnightPhantomRenderer
import autumn.twilightforest.init.entity.client.maze_slime.MazeSlimeRenderer
import autumn.twilightforest.init.entity.client.mist_wolf.MistWolfRenderer
import autumn.twilightforest.init.entity.client.skeleton_druid.SkeletonDruidModel
import autumn.twilightforest.init.entity.client.skeleton_druid.SkeletonDruidRenderer
import autumn.twilightforest.init.entity.client.skeleton_druid.projectile.NatureBoltEntityRenderer
import autumn.twilightforest.init.entity.client.squirrel.SquirrelModel
import autumn.twilightforest.init.entity.client.squirrel.SquirrelRenderer
import autumn.twilightforest.init.entity.client.swarm_spider.SwarmSpiderRenderer
import autumn.twilightforest.init.entity.client.tiny_bird.TinyBirdModel
import autumn.twilightforest.init.entity.client.tiny_bird.TinyBirdRenderer
import autumn.twilightforest.init.entity.client.towerwood_borer.TowerwoodBorerRenderer
import autumn.twilightforest.init.entity.client.wild_deer.WildDeerModel
import autumn.twilightforest.init.entity.client.wild_deer.WildDeerRenderer
import autumn.twilightforest.init.entity.client.winter_wolf.WinterWolfRenderer
import autumn.twilightforest.init.entity.equipment.client.knightmetal.KnightmetalArmorRenderer
import autumn.twilightforest.init.entity.equipment.client.phantom.PhantomArmorRenderer
import autumn.twilightforest.init.item.TFItems
import autumn.twilightforest.util.TFWoodTypes
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry
import net.minecraft.client.render.BlockRenderLayer
import net.minecraft.client.render.entity.FlyingItemEntityRenderer
import net.minecraft.client.render.entity.model.EntityModelLayers
import net.minecraft.util.Identifier

object TwilightForestClient : ClientModInitializer {

    override fun onInitializeClient() {
        TFWoodTypes.registerWoodTypes()
        TFColorHandlers.registerBlockColors()

        ArmorRenderer.register(KnightmetalArmorRenderer, TFItems.KNIGHTMETAL_HELMET, TFItems.KNIGHTMETAL_CHESTPLATE, TFItems.KNIGHTMETAL_LEGGINGS, TFItems.KNIGHTMETAL_BOOTS)
        ArmorRenderer.register(PhantomArmorRenderer, TFItems.PHANTOM_HELMET, TFItems.PHANTOM_CHESTPLATE)

        val cutoutBlocks = listOf(
            TFBlocks.KNIGHTMETAL_BLOCK, TFBlocks.ANTIBUILT_BLOCK,
            TFBlocks.TWILIGHT_OAK_DOOR, TFBlocks.TWILIGHT_OAK_TRAPDOOR, TFBlocks.TWILIGHT_OAK_LEAVES, TFBlocks.TWILIGHT_OAK_SAPLING, TFBlocks.RAINBOW_OAK_LEAVES, TFBlocks.RAINBOW_OAK_SAPLING, TFBlocks.TWILIGHT_OAK_SIGN, TFBlocks.TWILIGHT_OAK_HANGING_SIGN,
            TFBlocks.CANOPY_DOOR, TFBlocks.CANOPY_TRAPDOOR, TFBlocks.CANOPY_LEAVES, TFBlocks.CANOPY_SAPLING, TFBlocks.CANOPY_SIGN, TFBlocks.CANOPY_HANGING_SIGN,
            TFBlocks.TWILIGHT_MANGROVE_DOOR, TFBlocks.TWILIGHT_MANGROVE_TRAPDOOR, TFBlocks.TWILIGHT_MANGROVE_LEAVES, TFBlocks.TWILIGHT_MANGROVE_SAPLING, TFBlocks.TWILIGHT_MANGROVE_SIGN, TFBlocks.TWILIGHT_MANGROVE_HANGING_SIGN,
            TFBlocks.DARK_DOOR, TFBlocks.DARK_TRAPDOOR, TFBlocks.DARK_LEAVES, TFBlocks.DARK_SAPLING, TFBlocks.DARK_SIGN, TFBlocks.DARK_HANGING_SIGN,
            TFBlocks.TIME_DOOR, TFBlocks.TIME_TRAPDOOR, TFBlocks.TIME_LEAVES, TFBlocks.TIME_SAPLING, TFBlocks.TIME_SIGN, TFBlocks.TIME_HANGING_SIGN,
            TFBlocks.TRANSFORMATION_DOOR, TFBlocks.TRANSFORMATION_TRAPDOOR, TFBlocks.TRANSFORMATION_LEAVES, TFBlocks.TRANSFORMATION_SAPLING, TFBlocks.TRANSFORMATION_SIGN, TFBlocks.TRANSFORMATION_HANGING_SIGN,
            TFBlocks.MINING_DOOR, TFBlocks.MINING_TRAPDOOR, TFBlocks.MINING_LEAVES, TFBlocks.MINING_SAPLING, TFBlocks.MINING_SIGN, TFBlocks.MINING_HANGING_SIGN,
            TFBlocks.SORTING_DOOR, TFBlocks.SORTING_TRAPDOOR, TFBlocks.SORTING_LEAVES, TFBlocks.SORTING_SAPLING, TFBlocks.SORTING_SIGN, TFBlocks.SORTING_HANGING_SIGN
        )
        cutoutBlocks.forEach { BlockRenderLayerMap.putBlock(it, BlockRenderLayer.CUTOUT) }

        val cutoutMippedBlocks = listOf(
            TFBlocks.SHIMMERING_GRASS_BLOCK
        )
        cutoutMippedBlocks.forEach { BlockRenderLayerMap.putBlock(it, BlockRenderLayer.CUTOUT_MIPPED) }

        TFBoatClientHelper.registerModelLayers(Identifier.of(TwilightForest.MOD_ID, "twilight_oak"))
        TFBoatClientHelper.registerModelLayers(Identifier.of(TwilightForest.MOD_ID, "canopy"))
        TFBoatClientHelper.registerModelLayers(Identifier.of(TwilightForest.MOD_ID, "twilight_mangrove"))
        TFBoatClientHelper.registerModelLayers(Identifier.of(TwilightForest.MOD_ID, "dark"))
        TFBoatClientHelper.registerModelLayers(Identifier.of(TwilightForest.MOD_ID, "time"))
        TFBoatClientHelper.registerModelLayers(Identifier.of(TwilightForest.MOD_ID, "transformation"))
        TFBoatClientHelper.registerModelLayers(Identifier.of(TwilightForest.MOD_ID, "mining"))
        TFBoatClientHelper.registerModelLayers(Identifier.of(TwilightForest.MOD_ID, "sorting"))

        EntityModelLayerRegistry.registerModelLayer(DwarfRabbitModel.DWARF_RABBIT, DwarfRabbitModel::getTexturedModelData)
        EntityRendererRegistry.register(TFEntities.DWARF_RABBIT, ::DwarfRabbitRenderer)

        EntityModelLayerRegistry.registerModelLayer(TinyBirdModel.TINY_BIRD, TinyBirdModel::getTexturedModelData)
        EntityRendererRegistry.register(TFEntities.TINY_BIRD, ::TinyBirdRenderer)
        EntityRendererRegistry.register(TFEntities.TINY_EGG, ::FlyingItemEntityRenderer)

        EntityModelLayerRegistry.registerModelLayer(WildDeerModel.WILD_DEER, WildDeerModel::getTexturedModelData)
        EntityRendererRegistry.register(TFEntities.WILD_DEER, ::WildDeerRenderer)

        EntityRendererRegistry.register(TFEntities.TOWERWOOD_BORER, ::TowerwoodBorerRenderer)

        EntityModelLayerRegistry.registerModelLayer(SquirrelModel.SQUIRREL, SquirrelModel::getTexturedModelData)
        EntityRendererRegistry.register(TFEntities.SQUIRREL, ::SquirrelRenderer)

        EntityRendererRegistry.register(TFEntities.MAZE_SLIME, ::MazeSlimeRenderer)

        EntityRendererRegistry.register(TFEntities.CARMINITE_BROODLING, ::CarminiteBroodlingRenderer)

        EntityRendererRegistry.register(TFEntities.KING_SPIDER, ::KingSpiderRenderer)

        EntityModelLayerRegistry.registerModelLayer(SkeletonDruidModel.SKELETON_DRUID, SkeletonDruidModel::getTexturedModelData)
        EntityRendererRegistry.register(TFEntities.SKELETON_DRUID, ::SkeletonDruidRenderer)
        EntityRendererRegistry.register(TFEntities.NATURE_BOLT, ::NatureBoltEntityRenderer)

        EntityRendererRegistry.register(TFEntities.HEDGE_SPIDER, ::HedgeSpiderRenderer)

        EntityRendererRegistry.register(TFEntities.SWARM_SPIDER, ::SwarmSpiderRenderer)

        EntityRendererRegistry.register(TFEntities.MIST_WOLF, ::MistWolfRenderer)

        EntityRendererRegistry.register(TFEntities.WINTER_WOLF, ::WinterWolfRenderer)

        EntityRendererRegistry.register(TFEntities.CARMINITE_GHAST_GUARD, ::CarminiteGhastGuardRenderer)
        EntityRendererRegistry.register(TFEntities.CARMINITE_GHASTLING, ::CarminiteGhastlingRenderer)

        EntityRendererRegistry.register(TFEntities.KNIGHT_PHANTOM, ::KnightPhantomRenderer)

        EntityModelLayerRegistry.registerModelLayer(BighornSheepModel.BIGHORN_SHEEP, BighornSheepModel::getTexturedModelData)
        EntityRendererRegistry.register(TFEntities.BIGHORN_SHEEP, ::BighornSheepRenderer)
    }
}
