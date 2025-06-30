package autumn.twilightforest.datagen.providers

import autumn.twilightforest.init.block.TFBlocks
import autumn.twilightforest.init.item.TFItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import net.minecraft.registry.RegistryWrapper
import java.util.concurrent.CompletableFuture

class TFLootTableProvider(dataOutput: FabricDataOutput, registryLookup: CompletableFuture<RegistryWrapper.WrapperLookup>) : FabricBlockLootTableProvider(dataOutput, registryLookup) {
    override fun generate() {
        addDrop(TFBlocks.ROOT_BLOCK)
        addDrop(TFBlocks.LIVEROOT_BLOCK, TFItems.LIVEROOT)

        addDrop(TFBlocks.MAZE_SLIME_BLOCK)
        addDrop(TFBlocks.IRONWOOD_BLOCK)
        addDrop(TFBlocks.STEELEAF_BLOCK)
        addDrop(TFBlocks.KNIGHTMETAL_BLOCK)
        addDrop(TFBlocks.FIERY_BLOCK)
        addDrop(TFBlocks.ARCTIC_FUR_BLOCK)

        addDrop(TFBlocks.MAZESTONE)
        addDrop(TFBlocks.MAZESTONE_BRICK)
        addDrop(TFBlocks.MAZESTONE_LARGE_BRICK)
        addDrop(TFBlocks.CHISELED_MAZESTONE)
        addDrop(TFBlocks.CUT_MAZESTONE)
        addDrop(TFBlocks.DECORATIVE_MAZESTONE)
        addDrop(TFBlocks.CRACKED_MAZESTONE)
        addDrop(TFBlocks.MOSSY_MAZESTONE)
        addDrop(TFBlocks.MAZESTONE_MOSAIC)
        addDrop(TFBlocks.MAZESTONE_BORDER)

        addDrop(TFBlocks.UNDERBRICK)
        addDrop(TFBlocks.CRACKED_UNDERBRICK)
        addDrop(TFBlocks.MOSSY_UNDERBRICK)
        addDrop(TFBlocks.UNDERBRICK_FLOOR)

        addDrop(TFBlocks.TOWERWOOD)
        addDrop(TFBlocks.ENCASED_TOWERWOOD)
        addDrop(TFBlocks.CRACKED_TOWERWOOD)
        addDrop(TFBlocks.MOSSY_TOWERWOOD)
        addDropWithSilkTouch(TFBlocks.INFESTED_TOWERWOOD, TFBlocks.TOWERWOOD)

        addDrop(TFBlocks.HEDGE)
        addDrop(TFBlocks.HEDGE_ROSE, TFBlocks.HEDGE)

        addDrop(TFBlocks.TWILIGHT_OAK_LOG)
        addDrop(TFBlocks.STRIPPED_TWILIGHT_OAK_LOG)
        addDrop(TFBlocks.TWILIGHT_OAK_WOOD)
        addDrop(TFBlocks.STRIPPED_TWILIGHT_OAK_WOOD)
        leavesDrops(TFBlocks.TWILIGHT_OAK_LEAVES, TFBlocks.TWILIGHT_OAK_SAPLING, SAPLING_DROP_CHANCE.component1())
        addDrop(TFBlocks.TWILIGHT_OAK_DOOR)
        addDrop(TFBlocks.TWILIGHT_OAK_TRAPDOOR)
        addDrop(TFBlocks.TWILIGHT_OAK_FENCE)
        addDrop(TFBlocks.TWILIGHT_OAK_FENCE_GATE)
        addDrop(TFBlocks.TWILIGHT_OAK_STAIRS)
        addDrop(TFBlocks.TWILIGHT_OAK_SLAB)
        addDrop(TFBlocks.TWILIGHT_OAK_PRESSURE_PLATE)
        addDrop(TFBlocks.TWILIGHT_OAK_BUTTON)
        /*addDrop(TFBlocks.TWILIGHT_OAK_SIGN, TFItems.TWILIGHT_OAK_SIGN)
        addDrop(TFBlocks.TWILIGHT_OAK_WALL_SIGN, TFItems.TWILIGHT_OAK_SIGN)
        addDrop(TFBlocks.TWILIGHT_OAK_HANGING_SIGN, TFItems.TWILIGHT_OAK_HANGING_SIGN)
        addDrop(TFBlocks.TWILIGHT_OAK_WALL_HANGING_SIGN, TFItems.TWILIGHT_OAK_HANGING_SIGN)*/
    }
}