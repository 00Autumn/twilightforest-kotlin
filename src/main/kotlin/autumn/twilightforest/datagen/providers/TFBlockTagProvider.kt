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
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
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
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
            .add(
                TFBlocks.ROOT_BLOCK,
                TFBlocks.LIVEROOT_BLOCK,
                TFBlocks.HEDGE,
                TFBlocks.HEDGE_ROSE
            )
        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
            .add(TFBlocks.ARCTIC_FUR_BLOCK)

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
            .add(
                TFBlocks.IRONWOOD_BLOCK,
                TFBlocks.UNDERBRICK,
                TFBlocks.CRACKED_UNDERBRICK,
                TFBlocks.MOSSY_UNDERBRICK,
                TFBlocks.UNDERBRICK_FLOOR
            )
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
            .add(
                TFBlocks.KNIGHTMETAL_BLOCK,
                TFBlocks.FIERY_BLOCK
            )
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
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

        getOrCreateTagBuilder(TFBlockTags.NEEDS_IRONWOOD_TOOL).addTag(BlockTags.NEEDS_IRON_TOOL)
        getOrCreateTagBuilder(TFBlockTags.NEEDS_STEELEAF_TOOL).addTag(BlockTags.NEEDS_DIAMOND_TOOL)
        getOrCreateTagBuilder(TFBlockTags.NEEDS_KNIGHTMETAL_TOOL).addTag(BlockTags.NEEDS_DIAMOND_TOOL)
        getOrCreateTagBuilder(TFBlockTags.NEEDS_FIERY_TOOL).addTag(BlockTags.NEEDS_DIAMOND_TOOL)

        getOrCreateTagBuilder(TFBlockTags.MAZEBREAKER_TOOL_ACCELERATED).add(
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

        getOrCreateTagBuilder(BlockTags.STRIDER_WARM_BLOCKS)
            .add(TFBlocks.FIERY_BLOCK)

        getOrCreateTagBuilder(TFBlockTags.TWILIGHT_FOREST_LOGS).add(
            TFBlocks.TWILIGHT_OAK_LOG,
            TFBlocks.STRIPPED_TWILIGHT_OAK_LOG,
            TFBlocks.TWILIGHT_OAK_WOOD,
            TFBlocks.STRIPPED_TWILIGHT_OAK_WOOD
        )
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
            .addTag(TFBlockTags.TWILIGHT_FOREST_LOGS)
        getOrCreateTagBuilder(BlockTags.LEAVES).add(
            TFBlocks.TWILIGHT_OAK_LEAVES
        )
        getOrCreateTagBuilder(BlockTags.SAPLINGS).add(
            TFBlocks.TWILIGHT_OAK_SAPLING
        )
        getOrCreateTagBuilder(BlockTags.PLANKS).add(
            TFBlocks.TWILIGHT_OAK_PLANKS
        )
        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS).add(
            TFBlocks.TWILIGHT_OAK_DOOR
        )
        getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS).add(
            TFBlocks.TWILIGHT_OAK_TRAPDOOR
        )
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(
            TFBlocks.TWILIGHT_OAK_FENCE
        )
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(
            TFBlocks.TWILIGHT_OAK_FENCE_GATE
        )
        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS).add(
            TFBlocks.TWILIGHT_OAK_STAIRS
        )
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS).add(
            TFBlocks.TWILIGHT_OAK_SLAB
        )
        getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES).add(
            TFBlocks.TWILIGHT_OAK_PRESSURE_PLATE
        )
        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS).add(
            TFBlocks.TWILIGHT_OAK_BUTTON
        )
        /*getOrCreateTagBuilder(BlockTags.STANDING_SIGNS).add(
            TFBlocks.TWILIGHT_OAK_SIGN
        )
        getOrCreateTagBuilder(BlockTags.WALL_SIGNS).add(
            TFBlocks.TWILIGHT_OAK_WALL_SIGN
        )
        getOrCreateTagBuilder(BlockTags.CEILING_HANGING_SIGNS).add(
            TFBlocks.TWILIGHT_OAK_HANGING_SIGN
        )
        getOrCreateTagBuilder(BlockTags.WALL_HANGING_SIGNS).add(
            TFBlocks.TWILIGHT_OAK_WALL_HANGING_SIGN
        )*/

    }
}