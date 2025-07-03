package autumn.twilightforest.datagen.providers

import autumn.twilightforest.init.block.TFBlocks
import autumn.twilightforest.util.TFBlockTags
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.registry.RegistryWrapper
import net.minecraft.registry.tag.BlockTags
import java.util.concurrent.CompletableFuture

class TFBlockTagProvider(output: FabricDataOutput, registriesFuture: CompletableFuture<RegistryWrapper.WrapperLookup>) : FabricTagProvider.BlockTagProvider(output, registriesFuture) {
    override fun configure(wrapperLookup: RegistryWrapper.WrapperLookup) {
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE)
            .add(
                TFBlocks.IRONWOOD_BLOCK,
                TFBlocks.STEELEAF_BLOCK,
                TFBlocks.KNIGHTMETAL_BLOCK,
                TFBlocks.FIERY_BLOCK,

                TFBlocks.MAZESTONE,
                TFBlocks.MAZESTONE_BRICK,
                TFBlocks.MAZESTONE_LARGE_BRICK,
                TFBlocks.CHISELED_MAZESTONE,
                TFBlocks.CUT_MAZESTONE,
                TFBlocks.DECORATIVE_MAZESTONE,
                TFBlocks.CRACKED_MAZESTONE,
                TFBlocks.MAZESTONE_MOSAIC,
                TFBlocks.MAZESTONE_BORDER,

                TFBlocks.UNDERBRICK,
                TFBlocks.MOSSY_UNDERBRICK,
                TFBlocks.CRACKED_UNDERBRICK,
                TFBlocks.UNDERBRICK_FLOOR
            )
        valueLookupBuilder(BlockTags.AXE_MINEABLE)
            .add(
                TFBlocks.ROOT_BLOCK,
                TFBlocks.LIVEROOT_BLOCK,
                TFBlocks.HEDGE,
                TFBlocks.HEDGE_ROSE
            )
        valueLookupBuilder(BlockTags.HOE_MINEABLE)
            .add(TFBlocks.ARCTIC_FUR_BLOCK)

        valueLookupBuilder(BlockTags.NEEDS_STONE_TOOL)
            .add(
                TFBlocks.IRONWOOD_BLOCK,
                TFBlocks.UNDERBRICK,
                TFBlocks.CRACKED_UNDERBRICK,
                TFBlocks.MOSSY_UNDERBRICK,
                TFBlocks.UNDERBRICK_FLOOR
            )
        valueLookupBuilder(BlockTags.NEEDS_IRON_TOOL)
            .add(
                TFBlocks.KNIGHTMETAL_BLOCK,
                TFBlocks.FIERY_BLOCK
            )
        valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
            .add(
                TFBlocks.MAZESTONE,
                TFBlocks.MAZESTONE_BRICK,
                TFBlocks.MAZESTONE_LARGE_BRICK,
                TFBlocks.CHISELED_MAZESTONE,
                TFBlocks.CUT_MAZESTONE,
                TFBlocks.DECORATIVE_MAZESTONE,
                TFBlocks.CRACKED_MAZESTONE,
                TFBlocks.MAZESTONE_MOSAIC,
                TFBlocks.MAZESTONE_BORDER
            )

        valueLookupBuilder(TFBlockTags.NEEDS_IRONWOOD_TOOL).addTag(BlockTags.NEEDS_IRON_TOOL)
        valueLookupBuilder(TFBlockTags.NEEDS_STEELEAF_TOOL).addTag(BlockTags.NEEDS_DIAMOND_TOOL)
        valueLookupBuilder(TFBlockTags.NEEDS_KNIGHTMETAL_TOOL).addTag(BlockTags.NEEDS_DIAMOND_TOOL)
        valueLookupBuilder(TFBlockTags.NEEDS_FIERY_TOOL).addTag(BlockTags.NEEDS_DIAMOND_TOOL)

        valueLookupBuilder(TFBlockTags.MAZEBREAKER_TOOL_ACCELERATED).add(
            TFBlocks.MAZESTONE,
            TFBlocks.MAZESTONE_BRICK,
            TFBlocks.MAZESTONE_LARGE_BRICK,
            TFBlocks.CHISELED_MAZESTONE,
            TFBlocks.CUT_MAZESTONE,
            TFBlocks.DECORATIVE_MAZESTONE,
            TFBlocks.CRACKED_MAZESTONE,
            TFBlocks.MAZESTONE_MOSAIC,
            TFBlocks.MAZESTONE_BORDER
        )

        valueLookupBuilder(BlockTags.STRIDER_WARM_BLOCKS)
            .add(TFBlocks.FIERY_BLOCK)

        valueLookupBuilder(TFBlockTags.TWILIGHT_FOREST_LOGS).add(
            TFBlocks.TWILIGHT_OAK_LOG,
            TFBlocks.STRIPPED_TWILIGHT_OAK_LOG,
            TFBlocks.TWILIGHT_OAK_WOOD,
            TFBlocks.STRIPPED_TWILIGHT_OAK_WOOD
        )
        valueLookupBuilder(BlockTags.LOGS_THAT_BURN)
            .addTag(TFBlockTags.TWILIGHT_FOREST_LOGS)
        valueLookupBuilder(BlockTags.LEAVES).add(
            TFBlocks.TWILIGHT_OAK_LEAVES
        )
        valueLookupBuilder(BlockTags.SAPLINGS).add(
            TFBlocks.TWILIGHT_OAK_SAPLING
        )
        valueLookupBuilder(BlockTags.PLANKS).add(
            TFBlocks.TWILIGHT_OAK_PLANKS
        )
        valueLookupBuilder(BlockTags.WOODEN_DOORS).add(
            TFBlocks.TWILIGHT_OAK_DOOR
        )
        valueLookupBuilder(BlockTags.WOODEN_TRAPDOORS).add(
            TFBlocks.TWILIGHT_OAK_TRAPDOOR
        )
        valueLookupBuilder(BlockTags.WOODEN_FENCES).add(
            TFBlocks.TWILIGHT_OAK_FENCE
        )
        valueLookupBuilder(BlockTags.FENCE_GATES).add(
            TFBlocks.TWILIGHT_OAK_FENCE_GATE
        )
        valueLookupBuilder(BlockTags.WOODEN_STAIRS).add(
            TFBlocks.TWILIGHT_OAK_STAIRS
        )
        valueLookupBuilder(BlockTags.WOODEN_SLABS).add(
            TFBlocks.TWILIGHT_OAK_SLAB
        )
        valueLookupBuilder(BlockTags.WOODEN_PRESSURE_PLATES).add(
            TFBlocks.TWILIGHT_OAK_PRESSURE_PLATE
        )
        valueLookupBuilder(BlockTags.WOODEN_BUTTONS).add(
            TFBlocks.TWILIGHT_OAK_BUTTON
        )
        /*valueLookupBuilder(BlockTags.STANDING_SIGNS).add(
            TFBlocks.TWILIGHT_OAK_SIGN
        )
        valueLookupBuilder(BlockTags.WALL_SIGNS).add(
            TFBlocks.TWILIGHT_OAK_WALL_SIGN
        )
        valueLookupBuilder(BlockTags.CEILING_HANGING_SIGNS).add(
            TFBlocks.TWILIGHT_OAK_HANGING_SIGN
        )
        valueLookupBuilder(BlockTags.WALL_HANGING_SIGNS).add(
            TFBlocks.TWILIGHT_OAK_WALL_HANGING_SIGN
        )*/

    }
}