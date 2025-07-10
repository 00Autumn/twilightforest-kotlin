package autumn.twilightforest.datagen.providers

import autumn.twilightforest.init.block.TFBlocks
import autumn.twilightforest.init.item.TFItems
import autumn.twilightforest.util.tag.TFItemTags
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.item.Item
import net.minecraft.item.ItemConvertible
import net.minecraft.item.Items
import net.minecraft.loot.LootPool
import net.minecraft.loot.LootTable
import net.minecraft.loot.condition.MatchToolLootCondition
import net.minecraft.loot.entry.AlternativeEntry
import net.minecraft.loot.entry.ItemEntry
import net.minecraft.loot.provider.number.ConstantLootNumberProvider
import net.minecraft.predicate.item.ItemPredicate
import net.minecraft.registry.RegistryEntryLookup
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.RegistryWrapper
import net.minecraft.registry.tag.TagKey
import java.util.concurrent.CompletableFuture

class TFLootTableProvider(dataOutput: FabricDataOutput, private val registryLookupFuture: CompletableFuture<RegistryWrapper.WrapperLookup>) : FabricBlockLootTableProvider(dataOutput, registryLookupFuture) {
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
        addDrop(TFBlocks.CRACKED_MAZESTONE_BRICK)
        addDrop(TFBlocks.MOSSY_MAZESTONE_BRICK)
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

        addDrop(TFBlocks.HEDGE)
        addDrop(TFBlocks.HEDGE_ROSE, TFBlocks.HEDGE)

        addDrop(TFBlocks.TWILIGHT_OAK_LOG)
        addDrop(TFBlocks.STRIPPED_TWILIGHT_OAK_LOG)
        addDrop(TFBlocks.TWILIGHT_OAK_WOOD)
        addDrop(TFBlocks.STRIPPED_TWILIGHT_OAK_WOOD)
        leavesDrops(TFBlocks.TWILIGHT_OAK_LEAVES, TFBlocks.TWILIGHT_OAK_SAPLING, SAPLING_DROP_CHANCE.component1())
        leavesDrops(TFBlocks.RAINBOW_OAK_LEAVES, TFBlocks.RAINBOW_OAK_SAPLING, SAPLING_DROP_CHANCE.component1())
        addDrop(TFBlocks.TWILIGHT_OAK_DOOR)
        addDrop(TFBlocks.TWILIGHT_OAK_TRAPDOOR)
        addDrop(TFBlocks.TWILIGHT_OAK_FENCE)
        addDrop(TFBlocks.TWILIGHT_OAK_FENCE_GATE)
        addDrop(TFBlocks.TWILIGHT_OAK_STAIRS)
        addDrop(TFBlocks.TWILIGHT_OAK_SLAB)
        addDrop(TFBlocks.TWILIGHT_OAK_PRESSURE_PLATE)
        addDrop(TFBlocks.TWILIGHT_OAK_BUTTON)

        addDrop(TFBlocks.CANOPY_LOG)
        addDrop(TFBlocks.STRIPPED_CANOPY_LOG)
        addDrop(TFBlocks.CANOPY_WOOD)
        addDrop(TFBlocks.STRIPPED_CANOPY_WOOD)
        leavesDrops(TFBlocks.CANOPY_LEAVES, TFBlocks.CANOPY_SAPLING, SAPLING_DROP_CHANCE.component1())
        addDrop(TFBlocks.CANOPY_DOOR)
        addDrop(TFBlocks.CANOPY_TRAPDOOR)
        addDrop(TFBlocks.CANOPY_FENCE)
        addDrop(TFBlocks.CANOPY_FENCE_GATE)
        addDrop(TFBlocks.CANOPY_STAIRS)
        addDrop(TFBlocks.CANOPY_SLAB)
        addDrop(TFBlocks.CANOPY_PRESSURE_PLATE)
        addDrop(TFBlocks.CANOPY_BUTTON)

        addDrop(TFBlocks.DARK_LOG)
        addDrop(TFBlocks.STRIPPED_DARK_LOG)
        addDrop(TFBlocks.DARK_WOOD)
        addDrop(TFBlocks.STRIPPED_DARK_WOOD)
        leavesDrops(TFBlocks.DARK_LEAVES, TFBlocks.DARK_SAPLING, SAPLING_DROP_CHANCE.component1())
        addDrop(TFBlocks.DARK_DOOR)
        addDrop(TFBlocks.DARK_TRAPDOOR)
        addDrop(TFBlocks.DARK_FENCE)
        addDrop(TFBlocks.DARK_FENCE_GATE)
        addDrop(TFBlocks.DARK_STAIRS)
        addDrop(TFBlocks.DARK_SLAB)
        addDrop(TFBlocks.DARK_PRESSURE_PLATE)
        addDrop(TFBlocks.DARK_BUTTON)

        //FIERY DROPS
        val itemLookup = registryLookupFuture.get().getOrThrow(RegistryKeys.ITEM)

        val blocks = listOf(
            Blocks.COPPER_ORE,
            Blocks.IRON_ORE,
            Blocks.GOLD_ORE,
            Blocks.ANCIENT_DEBRIS,
            Blocks.DEEPSLATE_COPPER_ORE,
            Blocks.DEEPSLATE_IRON_ORE,
            Blocks.DEEPSLATE_GOLD_ORE,
            Blocks.STONE_BRICKS,
            Blocks.DEEPSLATE_BRICKS,
            Blocks.DEEPSLATE_TILES,
            Blocks.NETHER_BRICKS,
            Blocks.POLISHED_BLACKSTONE_BRICKS,
            Blocks.COBBLESTONE,
            Blocks.COBBLED_DEEPSLATE,
            Blocks.SAND,
            Blocks.RED_SAND,
            Blocks.CLAY,
            Blocks.MUD,
            TFBlocks.MAZESTONE_BRICK,
            TFBlocks.UNDERBRICK,
            TFBlocks.TOWERWOOD
        )

        val defaultDrops = listOf(
            Items.RAW_COPPER,
            Items.RAW_IRON,
            Items.RAW_GOLD,
            Items.ANCIENT_DEBRIS,
            Items.RAW_COPPER,
            Items.RAW_IRON,
            Items.RAW_GOLD,
            Items.STONE_BRICKS,
            Items.DEEPSLATE_BRICKS,
            Items.DEEPSLATE_TILES,
            Items.NETHER_BRICKS,
            Items.POLISHED_BLACKSTONE_BRICKS,
            Items.COBBLESTONE,
            Items.COBBLED_DEEPSLATE,
            Items.SAND,
            Items.RED_SAND,
            Items.CLAY,
            Items.MUD,
            TFBlocks.MAZESTONE.asItem(),
            TFBlocks.UNDERBRICK.asItem(),
            TFBlocks.TOWERWOOD.asItem()
        )

        val newDrops = listOf(
            Items.COPPER_INGOT,
            Items.IRON_INGOT,
            Items.GOLD_INGOT,
            Items.NETHERITE_SCRAP,
            Items.COPPER_INGOT,
            Items.IRON_INGOT,
            Items.GOLD_INGOT,
            Items.CRACKED_STONE_BRICKS,
            Items.CRACKED_DEEPSLATE_BRICKS,
            Items.CRACKED_DEEPSLATE_TILES,
            Items.CRACKED_NETHER_BRICKS,
            Items.CRACKED_POLISHED_BLACKSTONE_BRICKS,
            Items.STONE,
            Items.DEEPSLATE,
            Items.GLASS,
            Items.RED_STAINED_GLASS,
            Items.TERRACOTTA,
            Items.MUD_BRICKS,
            TFBlocks.CRACKED_MAZESTONE_BRICK.asItem(),
            TFBlocks.CRACKED_UNDERBRICK.asItem(),
            TFBlocks.CRACKED_TOWERWOOD.asItem()
        )

        addSmeltableDrops(blocks, defaultDrops, newDrops, TFItemTags.FIERY_TOOL, itemLookup)
    }

    fun createSmeltableLootTable(
        rawDrop: ItemConvertible,
        smeltedDrop: ItemConvertible,
        autoSmeltToolTag: TagKey<Item>,
        itemLookup: RegistryEntryLookup<Item>
    ): LootTable.Builder {
        return LootTable.builder().pool(
            LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1f))
                .with(
                    AlternativeEntry.builder(
                        ItemEntry.builder(smeltedDrop.asItem()).conditionally(
                            MatchToolLootCondition.builder(
                                ItemPredicate.Builder.create().tag(itemLookup, autoSmeltToolTag)
                            )
                        ),
                        ItemEntry.builder(rawDrop.asItem())
                    )
                )
        )
    }

    fun addSmeltableDrops(
        blocks: List<Block>,
        rawDrops: List<ItemConvertible>,
        smeltedDrops: List<ItemConvertible>,
        toolTag: TagKey<Item>,
        itemLookup: RegistryEntryLookup<Item>
    ) {
        for (i in blocks.indices) {
            addDrop(
                blocks[i],
                createSmeltableLootTable(
                    rawDrop = rawDrops[i],
                    smeltedDrop = smeltedDrops[i],
                    autoSmeltToolTag = toolTag,
                    itemLookup = itemLookup
                )
            )
        }
    }
}