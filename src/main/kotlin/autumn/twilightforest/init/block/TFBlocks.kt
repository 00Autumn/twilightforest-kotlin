package autumn.twilightforest.init.block

import autumn.twilightforest.TwilightForest
import autumn.twilightforest.init.block.custom.ArcticFurBlock
import autumn.twilightforest.init.block.custom.FieryBlock
import autumn.twilightforest.init.block.custom.HedgeBlock
import autumn.twilightforest.init.block.custom.KnightmetalBlock
import autumn.twilightforest.util.TFBlockSetTypes
import autumn.twilightforest.util.TFWoodTypes
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.block.ButtonBlock
import net.minecraft.block.DoorBlock
import net.minecraft.block.FenceBlock
import net.minecraft.block.FenceGateBlock
import net.minecraft.block.InfestedBlock
import net.minecraft.block.MapColor
import net.minecraft.block.PillarBlock
import net.minecraft.block.PressurePlateBlock
import net.minecraft.block.SaplingBlock
import net.minecraft.block.SlabBlock
import net.minecraft.block.SlimeBlock
import net.minecraft.block.StairsBlock
import net.minecraft.block.TintedParticleLeavesBlock
import net.minecraft.block.TrapdoorBlock
import net.minecraft.block.enums.NoteBlockInstrument
import net.minecraft.block.piston.PistonBehavior
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.Identifier

object TFBlocks {

    // NATURAL BLOCKS
    val ROOT_BLOCK = registerBlock("root_block") { settings -> Block(settings.burnable().mapColor(MapColor.BROWN).sounds(BlockSoundGroup.WOOD).strength(2.0F, 3.0F)) }
    val LIVEROOT_BLOCK = registerBlock("liveroot_block") { settings -> Block(settings.burnable().mapColor(MapColor.LICHEN_GREEN).sounds(BlockSoundGroup.WOOD).strength(2.0F, 3.0F)) }
    val MAZE_SLIME_BLOCK = registerCopyBlock("maze_slime_block", Blocks.SLIME_BLOCK) { settings -> SlimeBlock(settings.mapColor(MapColor.LIGHT_GRAY)) }
    val IRONWOOD_BLOCK = registerCopyBlock("ironwood_block", Blocks.IRON_BLOCK) { settings -> Block(settings.mapColor(MapColor.LICHEN_GREEN).sounds(BlockSoundGroup.METAL)) }
    val STEELEAF_BLOCK = registerCopyBlock("steeleaf_block", Blocks.DIAMOND_BLOCK) { settings -> Block(settings.mapColor(MapColor.GREEN).sounds(BlockSoundGroup.METAL)) }
    val KNIGHTMETAL_BLOCK = registerCopyBlock("knightmetal_block", Blocks.DIAMOND_BLOCK) { settings -> KnightmetalBlock(settings.mapColor(MapColor.LIGHT_GRAY).sounds(BlockSoundGroup.ANVIL)) }
    val FIERY_BLOCK = registerCopyBlock("fiery_block", Blocks.DIAMOND_BLOCK) { settings -> FieryBlock(settings.mapColor(MapColor.TERRACOTTA_RED).sounds(BlockSoundGroup.METAL)) }
    val ARCTIC_FUR_BLOCK = registerCopyBlock("arctic_fur_block", Blocks.WHITE_WOOL) { settings -> ArcticFurBlock(settings) }

    // LABYRINTH BLOCKS
    val MAZESTONE = registerBlock("mazestone") { settings -> Block(settings.instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.LIGHT_GRAY).requiresTool().sounds(BlockSoundGroup.STONE).strength(100.0f, 5.0f)) }
    val MAZESTONE_BRICK = registerCopyBlock("mazestone_brick", MAZESTONE) { settings -> Block(settings) }
    val MAZESTONE_LARGE_BRICK = registerCopyBlock("mazestone_large_brick", MAZESTONE) { settings -> Block(settings) }
    val CHISELED_MAZESTONE = registerCopyBlock("chiseled_mazestone", MAZESTONE) { settings -> Block(settings) }
    val CUT_MAZESTONE = registerCopyBlock("cut_mazestone", MAZESTONE) { settings -> Block(settings) }
    val DECORATIVE_MAZESTONE = registerCopyBlock("decorative_mazestone", MAZESTONE) { settings -> Block(settings) }
    val CRACKED_MAZESTONE = registerCopyBlock("cracked_mazestone", MAZESTONE) { settings -> Block(settings) }
    val MOSSY_MAZESTONE = registerCopyBlock("mossy_mazestone", MAZESTONE) { settings -> Block(settings) }
    val MAZESTONE_MOSAIC = registerCopyBlock("mazestone_mosaic", MAZESTONE) { settings -> Block(settings) }
    val MAZESTONE_BORDER = registerCopyBlock("mazestone_border", MAZESTONE) { settings -> Block(settings) }

    // STRONGHOLD BLOCKS
    val STRONGHOLD_SHIELD = registerBlock("stronghold_shield") { settings -> Block(settings.dropsNothing().mapColor(MapColor.LIGHT_GRAY).pistonBehavior(PistonBehavior.BLOCK).requiresTool().sounds(BlockSoundGroup.METAL).strength(-1.0f, 6_000_000.0f)) }
    val UNDERBRICK = registerBlock("underbrick") { settings -> Block(settings.mapColor(MapColor.BROWN).requiresTool().sounds(BlockSoundGroup.DEEPSLATE_BRICKS).strength(1.5f, 6.0f)) }
    val MOSSY_UNDERBRICK = registerCopyBlock("mossy_underbrick", UNDERBRICK) { settings -> Block(settings) }
    val CRACKED_UNDERBRICK = registerCopyBlock("cracked_underbrick", UNDERBRICK) { settings -> Block(settings) }
    val UNDERBRICK_FLOOR = registerCopyBlock("underbrick_floor", UNDERBRICK) { settings -> Block(settings) }

    // DARK TOWER BLOCKS
    val TOWERWOOD = registerBlock("towerwood") { settings -> Block(settings.burnable().instrument(NoteBlockInstrument.BASS).mapColor(MapColor.ORANGE).sounds(BlockSoundGroup.WOOD).strength(40.0f, 6.0f).requiresTool()) }
    val ENCASED_TOWERWOOD = registerCopyBlock("encased_towerwood", TOWERWOOD) { settings -> Block(settings.mapColor(MapColor.PALE_YELLOW)) }
    val CRACKED_TOWERWOOD = registerCopyBlock("cracked_towerwood", TOWERWOOD) { settings -> Block(settings) }
    val MOSSY_TOWERWOOD = registerCopyBlock("mossy_towerwood", TOWERWOOD) { settings -> Block(settings) }
    val INFESTED_TOWERWOOD = registerCopyBlock("infested_towerwood", TOWERWOOD) { settings -> InfestedBlock(TOWERWOOD, settings.dropsNothing().instrument(NoteBlockInstrument.FLUTE).strength(2.0f, 6.0f)) }

    // MISC
    val ANTIBUILT_BLOCK = registerBlock("antibuilt_block") { settings -> Block(settings.dropsNothing().nonOpaque().pistonBehavior(PistonBehavior.BLOCK).sounds(BlockSoundGroup.WOOD).strength(0.3f, 2000.0f).requiresTool()) }
    val FAKE_GOLD = registerBlock("fake_gold") { settings -> Block(settings.dropsNothing().pistonBehavior(PistonBehavior.BLOCK).sounds(BlockSoundGroup.METAL).strength(50.0f, 2000.0f).requiresTool()) }
    val FAKE_DIAMOND = registerCopyBlock("fake_diamond", FAKE_GOLD) { settings -> Block(settings) }

    // MISC BLOCKS
    val HEDGE = registerBlock("hedge") { settings -> HedgeBlock(settings.mapColor(MapColor.GREEN).pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.GRASS).strength(2.0F, 6.0F)) }
    val HEDGE_ROSE = registerCopyBlock("hedge_rose", HEDGE) { settings -> HedgeBlock(settings.mapColor(MapColor.DARK_RED)) }

    // WOOD BLOCKS
    val TWILIGHT_OAK_LOG = registerVanillaBlock("twilight_oak_log", Blocks.OAK_LOG) { settings -> PillarBlock(settings) }
    val STRIPPED_TWILIGHT_OAK_LOG = registerVanillaBlock("stripped_twilight_oak_log", Blocks.STRIPPED_OAK_LOG) { settings -> PillarBlock(settings) }
    val TWILIGHT_OAK_WOOD = registerCopyBlock("twilight_oak_wood", Blocks.OAK_WOOD) { settings -> PillarBlock(settings) }
    val STRIPPED_TWILIGHT_OAK_WOOD = registerCopyBlock("stripped_twilight_oak_wood", Blocks.STRIPPED_OAK_WOOD) { settings -> PillarBlock(settings) }
    val TWILIGHT_OAK_LEAVES = registerVanillaBlock("twilight_oak_leaves", Blocks.OAK_LEAVES) { settings -> TintedParticleLeavesBlock(0.02F, settings) }
    val TWILIGHT_OAK_SAPLING = registerCopyBlock("twilight_oak_sapling", Blocks.OAK_SAPLING) { settings -> SaplingBlock(null, settings) }
    val TWILIGHT_OAK_PLANKS = registerCopyBlock("twilight_oak_planks", Blocks.OAK_PLANKS) { settings -> Block(settings) }
    val TWILIGHT_OAK_DOOR = registerCopyBlock("twilight_oak_door", Blocks.OAK_DOOR) { settings -> DoorBlock(TFBlockSetTypes.TWILIGHT_OAK_BLOCK_SET_TYPE, settings) }
    val TWILIGHT_OAK_TRAPDOOR = registerCopyBlock("twilight_oak_trapdoor", Blocks.OAK_TRAPDOOR) { settings -> TrapdoorBlock(TFBlockSetTypes.TWILIGHT_OAK_BLOCK_SET_TYPE, settings) }
    val TWILIGHT_OAK_FENCE = registerCopyBlock("twilight_oak_fence", Blocks.OAK_FENCE) { settings -> FenceBlock(settings) }
    val TWILIGHT_OAK_FENCE_GATE = registerCopyBlock("twilight_oak_fence_gate", Blocks.OAK_FENCE_GATE) { settings -> FenceGateBlock(TFWoodTypes.TWILIGHT_OAK_WOOD_TYPE, settings) }
    val TWILIGHT_OAK_STAIRS = registerCopyBlock("twilight_oak_stairs", Blocks.OAK_STAIRS) { settings -> StairsBlock(TWILIGHT_OAK_PLANKS.defaultState, settings) }
    val TWILIGHT_OAK_SLAB = registerCopyBlock("twilight_oak_slab", Blocks.OAK_SLAB) { settings -> SlabBlock(settings) }
    val TWILIGHT_OAK_PRESSURE_PLATE = registerCopyBlock("twilight_oak_pressure_plate", Blocks.OAK_PRESSURE_PLATE) { settings -> PressurePlateBlock(TFBlockSetTypes.TWILIGHT_OAK_BLOCK_SET_TYPE, settings) }
    val TWILIGHT_OAK_BUTTON = registerVanillaBlock("twilight_oak_button", Blocks.OAK_BUTTON) { settings -> ButtonBlock(TFBlockSetTypes.TWILIGHT_OAK_BLOCK_SET_TYPE, 10, settings) }

    private fun registerBlock(name: String, function: (AbstractBlock.Settings) -> Block): Block {
        val id = Identifier.of(TwilightForest.MOD_ID, name)
        val blockKey = RegistryKey.of(RegistryKeys.BLOCK, id)
        val settings = AbstractBlock.Settings.create().registryKey(blockKey)
        val block = function(settings)
        registerBlockItem(name, block)
        return Registry.register(Registries.BLOCK, id, block)
    }

    private fun registerCopyBlock(name: String, baseBlock: Block, function: (AbstractBlock.Settings) -> Block): Block {
        val id = Identifier.of(TwilightForest.MOD_ID, name)
        val blockKey = RegistryKey.of(RegistryKeys.BLOCK, id)
        val settings = AbstractBlock.Settings.copy(baseBlock).registryKey(blockKey)
        val block = function(settings)
        registerBlockItem(name, block)
        return Registry.register(Registries.BLOCK, id, block)
    }

    private fun registerVanillaBlock(name: String, vanillaBlock: Block, function: (AbstractBlock.Settings) -> Block): Block {
        val id = Identifier.of(TwilightForest.MOD_ID, name)
        // Use vanilla block's settings as-is, do NOT call registryKey() here
        val settings = vanillaBlock.settings
        val block = function(settings)
        registerBlockItem(name, block)
        return Registry.register(Registries.BLOCK, id, block)
    }

    private fun registerBlockWithoutBlockItem(name: String, function: (AbstractBlock.Settings) -> Block): Block {
        val id = Identifier.of(TwilightForest.MOD_ID, name)
        val blockKey = RegistryKey.of(RegistryKeys.BLOCK, id)
        val settings = AbstractBlock.Settings.create().registryKey(blockKey)
        return Registry.register(Registries.BLOCK, id, function(settings))
    }

    private fun registerBlockItem(name: String, block: Block) {
        val id = Identifier.of(TwilightForest.MOD_ID, name)
        val itemKey = RegistryKey.of(RegistryKeys.ITEM, id)
        val itemSettings = Item.Settings()
            .useBlockPrefixedTranslationKey()
            .registryKey(itemKey)
        val blockItem = BlockItem(block, itemSettings)
        Registry.register(Registries.ITEM, id, blockItem)
    }

    fun registerBlocks() {
        TwilightForest.logger?.info("Registering blocks for " + TwilightForest.MOD_ID)

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register { entries ->
            entries.add(ROOT_BLOCK)
            entries.add(LIVEROOT_BLOCK)
        }
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register { entries ->
            entries.add(IRONWOOD_BLOCK)
            entries.add(STEELEAF_BLOCK)
            entries.add(KNIGHTMETAL_BLOCK)
            entries.add(FIERY_BLOCK)
            entries.add(ARCTIC_FUR_BLOCK)

            entries.add(MAZESTONE)
            entries.add(MAZESTONE_BRICK)
            entries.add(MAZESTONE_LARGE_BRICK)
            entries.add(CHISELED_MAZESTONE)
            entries.add(CUT_MAZESTONE)
            entries.add(DECORATIVE_MAZESTONE)
            entries.add(CRACKED_MAZESTONE)
            entries.add(MOSSY_MAZESTONE)
            entries.add(MAZESTONE_MOSAIC)
            entries.add(MAZESTONE_BORDER)

            entries.add(UNDERBRICK)
            entries.add(MOSSY_UNDERBRICK)
            entries.add(CRACKED_UNDERBRICK)
            entries.add(UNDERBRICK_FLOOR)

            entries.add(TOWERWOOD)
            entries.add(ENCASED_TOWERWOOD)
            entries.add(CRACKED_TOWERWOOD)

            entries.add(HEDGE)
            entries.add(HEDGE_ROSE)

            entries.add(TWILIGHT_OAK_LOG)
            entries.add(STRIPPED_TWILIGHT_OAK_LOG)
            entries.add(TWILIGHT_OAK_LEAVES)
            entries.add(TWILIGHT_OAK_SAPLING)
            entries.add(TWILIGHT_OAK_PLANKS)
            entries.add(TWILIGHT_OAK_DOOR)
            entries.add(TWILIGHT_OAK_TRAPDOOR)
            entries.add(TWILIGHT_OAK_FENCE)
            entries.add(TWILIGHT_OAK_FENCE_GATE)
            entries.add(TWILIGHT_OAK_STAIRS)
            entries.add(TWILIGHT_OAK_SLAB)
            entries.add(TWILIGHT_OAK_PRESSURE_PLATE)
            entries.add(TWILIGHT_OAK_BUTTON)
        }
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register { entries ->
            entries.add(STRONGHOLD_SHIELD);

            entries.add(INFESTED_TOWERWOOD)
            entries.add(ANTIBUILT_BLOCK)
            entries.add(FAKE_GOLD)
            entries.add(FAKE_DIAMOND)
        }
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register { entries ->
            entries.add(MAZE_SLIME_BLOCK)
        }
    }
}