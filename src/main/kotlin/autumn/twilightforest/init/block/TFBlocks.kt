package autumn.twilightforest.init.block

import autumn.twilightforest.TwilightForest
import autumn.twilightforest.init.block.custom.ArcticFurBlock
import autumn.twilightforest.init.block.custom.FieryBlock
import autumn.twilightforest.init.block.custom.HedgeBlock
import autumn.twilightforest.init.block.custom.KnightmetalBlock
import autumn.twilightforest.sign.api.block.TFHangingSignBlock
import autumn.twilightforest.sign.api.block.TFSignBlock
import autumn.twilightforest.sign.api.block.TFWallHangingSignBlock
import autumn.twilightforest.sign.api.block.TFWallSignBlock
import autumn.twilightforest.util.TFBlockSetTypes
import autumn.twilightforest.util.TFWoodTypes
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.block.DoorBlock
import net.minecraft.block.FenceBlock
import net.minecraft.block.FenceGateBlock
import net.minecraft.block.HangingSignBlock
import net.minecraft.block.InfestedBlock
import net.minecraft.block.LeavesBlock
import net.minecraft.block.MapColor
import net.minecraft.block.PillarBlock
import net.minecraft.block.PressurePlateBlock
import net.minecraft.block.SaplingBlock
import net.minecraft.block.SignBlock
import net.minecraft.block.SlabBlock
import net.minecraft.block.SlimeBlock
import net.minecraft.block.StairsBlock
import net.minecraft.block.TrapdoorBlock
import net.minecraft.block.WallHangingSignBlock
import net.minecraft.block.WallSignBlock
import net.minecraft.block.enums.NoteBlockInstrument
import net.minecraft.block.piston.PistonBehavior
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.Identifier

object TFBlocks {

    //NATURAL BLOCKS
    val ROOT_BLOCK = registerBlock("root_block",
        Block(AbstractBlock.Settings.create().burnable().mapColor(MapColor.BROWN).sounds(BlockSoundGroup.WOOD).strength(2.0F, 3.0F)))
    val LIVEROOT_BLOCK = registerBlock("liveroot_block",
        Block(AbstractBlock.Settings.create().burnable().mapColor(MapColor.LICHEN_GREEN).sounds(BlockSoundGroup.WOOD).strength(2.0F, 3.0F)))

    //STORAGE BLOCKS
    val MAZE_SLIME_BLOCK = registerBlock("maze_slime_block",
        SlimeBlock(AbstractBlock.Settings.copy(Blocks.SLIME_BLOCK).mapColor(MapColor.LIGHT_GRAY)))
    val IRONWOOD_BLOCK = registerBlock("ironwood_block",
        Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).mapColor(MapColor.LICHEN_GREEN).sounds(BlockSoundGroup.METAL)))
    val STEELEAF_BLOCK = registerBlock("steeleaf_block",
        Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_BLOCK).mapColor(MapColor.GREEN).sounds(BlockSoundGroup.METAL)))
    val KNIGHTMETAL_BLOCK = registerBlock("knightmetal_block",
        KnightmetalBlock(AbstractBlock.Settings.copy(Blocks.DIAMOND_BLOCK).mapColor(MapColor.LIGHT_GRAY).sounds(BlockSoundGroup.ANVIL)))
    val FIERY_BLOCK = registerBlock("fiery_block",
        FieryBlock(AbstractBlock.Settings.copy(Blocks.DIAMOND_BLOCK).mapColor(MapColor.TERRACOTTA_RED).sounds(BlockSoundGroup.METAL)))
    val ARCTIC_FUR_BLOCK = registerBlock("arctic_fur_block",
        ArcticFurBlock(AbstractBlock.Settings.copy(Blocks.WHITE_WOOL)))

    //LABYRINTH BLOCKS
    val MAZESTONE = registerBlock("mazestone",
        Block(AbstractBlock.Settings.create().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.LIGHT_GRAY).requiresTool().sounds(BlockSoundGroup.STONE).strength(100.0f, 5.0f)))
    val MAZESTONE_BRICK = registerBlock("mazestone_brick", Block(AbstractBlock.Settings.copy(MAZESTONE)))
    val MAZESTONE_LARGE_BRICK = registerBlock("mazestone_large_brick", Block(AbstractBlock.Settings.copy(MAZESTONE)))
    val CHISELED_MAZESTONE = registerBlock("chiseled_mazestone", Block(AbstractBlock.Settings.copy(MAZESTONE)))
    val CUT_MAZESTONE = registerBlock("cut_mazestone", Block(AbstractBlock.Settings.copy(MAZESTONE)))
    val DECORATIVE_MAZESTONE = registerBlock("decorative_mazestone", Block(AbstractBlock.Settings.copy(MAZESTONE)))
    val CRACKED_MAZESTONE = registerBlock("cracked_mazestone", Block(AbstractBlock.Settings.copy(MAZESTONE)))
    val MOSSY_MAZESTONE = registerBlock("mossy_mazestone", Block(AbstractBlock.Settings.copy(MAZESTONE)))
    val MAZESTONE_MOSAIC = registerBlock("mazestone_mosaic", Block(AbstractBlock.Settings.copy(MAZESTONE)))
    val MAZESTONE_BORDER = registerBlock("mazestone_border", Block(AbstractBlock.Settings.copy(MAZESTONE)))

    //STRONGHOLD BLOCKS
    val STRONGHOLD_SHIELD = registerBlock("stronghold_shield",
        Block(AbstractBlock.Settings.create().dropsNothing().mapColor(MapColor.LIGHT_GRAY).pistonBehavior(PistonBehavior.BLOCK).requiresTool().sounds(BlockSoundGroup.METAL).strength(-1.0f, 6000000.0f)))
    val UNDERBRICK = registerBlock("underbrick",
        Block(AbstractBlock.Settings.create().mapColor(MapColor.BROWN).requiresTool().sounds(BlockSoundGroup.DEEPSLATE_BRICKS).strength(1.5f, 6.0f)))
    val MOSSY_UNDERBRICK = registerBlock("mossy_underbrick", Block(AbstractBlock.Settings.copy(UNDERBRICK)))
    val CRACKED_UNDERBRICK = registerBlock("cracked_underbrick", Block(AbstractBlock.Settings.copy(UNDERBRICK)))
    val UNDERBRICK_FLOOR = registerBlock("underbrick_floor", Block(AbstractBlock.Settings.copy(UNDERBRICK)))

    //DARK TOWER BLOCKS
    val TOWERWOOD = registerBlock("towerwood",
        Block(AbstractBlock.Settings.create().burnable().instrument(NoteBlockInstrument.BASS).mapColor(MapColor.ORANGE).sounds(BlockSoundGroup.WOOD).strength(40.0f, 6.0f).requiresTool()))
    val ENCASED_TOWERWOOD = registerBlock("encased_towerwood",
        Block(AbstractBlock.Settings.copy(TOWERWOOD).mapColor(MapColor.PALE_YELLOW)))
    val CRACKED_TOWERWOOD = registerBlock("cracked_towerwood",
        Block(AbstractBlock.Settings.copy(TOWERWOOD)))
    val MOSSY_TOWERWOOD = registerBlock("mossy_towerwood",
        Block(AbstractBlock.Settings.copy(TOWERWOOD)))
    val INFESTED_TOWERWOOD = registerBlock("infested_towerwood",
        InfestedBlock(TOWERWOOD, AbstractBlock.Settings.copy(TOWERWOOD).dropsNothing().instrument(NoteBlockInstrument.FLUTE).strength(2.0f, 6.0f))) as InfestedBlock
    val ANTIBUILT_BLOCK = registerBlock("antibuilt_block",
        Block(AbstractBlock.Settings.create().dropsNothing().nonOpaque().pistonBehavior(PistonBehavior.BLOCK).sounds(BlockSoundGroup.WOOD).strength(0.3f, 2000.0f).requiresTool()))
    val FAKE_GOLD = registerBlock("fake_gold",
        Block(AbstractBlock.Settings.create().dropsNothing().pistonBehavior(PistonBehavior.BLOCK).sounds(BlockSoundGroup.METAL).strength(50.0f, 2000.0f).requiresTool()))
    val FAKE_DIAMOND = registerBlock("fake_diamond",
        Block(AbstractBlock.Settings.copy(FAKE_GOLD)))

    //MISC BLOCKS
    val HEDGE = registerBlock("hedge",
        HedgeBlock(AbstractBlock.Settings.create().mapColor(MapColor.GREEN).pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.GRASS).strength(2.0F, 6.0F)))
    val HEDGE_ROSE = registerBlock("hedge_rose",
        HedgeBlock(AbstractBlock.Settings.copy(HEDGE).mapColor(MapColor.DARK_RED)))

    //WOOD BLOCKS
    val TWILIGHT_OAK_LOG = registerBlock("twilight_oak_log",
        Blocks.createLogBlock(MapColor.OAK_TAN, MapColor.WHITE))
    val STRIPPED_TWILIGHT_OAK_LOG = registerBlock("stripped_twilight_oak_log",
        Blocks.createLogBlock(MapColor.OAK_TAN, MapColor.WHITE))
    val TWILIGHT_OAK_WOOD = registerBlock("twilight_oak_wood",
        PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD)))
    val STRIPPED_TWILIGHT_OAK_WOOD = registerBlock("stripped_twilight_oak_wood",
        PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD)))
    val TWILIGHT_OAK_LEAVES = registerBlock("twilight_oak_leaves",
        LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)))
    val TWILIGHT_OAK_SAPLING = registerBlock("twilight_oak_sapling",
        SaplingBlock(null, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)))
    val TWILIGHT_OAK_PLANKS = registerBlock("twilight_oak_planks",
        Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)))
    val TWILIGHT_OAK_DOOR = registerBlock("twilight_oak_door",
        DoorBlock(TFBlockSetTypes.TWILIGHT_OAK_BLOCK_SET_TYPE, AbstractBlock.Settings.copy(Blocks.OAK_DOOR)))
    val TWILIGHT_OAK_TRAPDOOR = registerBlock("twilight_oak_trapdoor",
        TrapdoorBlock(TFBlockSetTypes.TWILIGHT_OAK_BLOCK_SET_TYPE, AbstractBlock.Settings.copy(Blocks.OAK_TRAPDOOR)))
    val TWILIGHT_OAK_FENCE = registerBlock("twilight_oak_fence",
        FenceBlock(AbstractBlock.Settings.copy(Blocks.OAK_FENCE)))
    val TWILIGHT_OAK_FENCE_GATE = registerBlock("twilight_oak_fence_gate",
        FenceGateBlock(TFWoodTypes.TWILIGHT_OAK_WOOD_TYPE, AbstractBlock.Settings.copy(Blocks.OAK_FENCE_GATE)))
    val TWILIGHT_OAK_STAIRS = registerBlock("twilight_oak_stairs",
        StairsBlock(TWILIGHT_OAK_PLANKS.defaultState, AbstractBlock.Settings.copy(Blocks.OAK_STAIRS)))
    val TWILIGHT_OAK_SLAB = registerBlock("twilight_oak_slab",
        SlabBlock(AbstractBlock.Settings.copy(Blocks.OAK_SLAB)))
    val TWILIGHT_OAK_PRESSURE_PLATE = registerBlock("twilight_oak_pressure_plate",
        PressurePlateBlock(TFBlockSetTypes.TWILIGHT_OAK_BLOCK_SET_TYPE,AbstractBlock.Settings.copy(Blocks.OAK_PRESSURE_PLATE)))
    val TWILIGHT_OAK_BUTTON = registerBlock("twilight_oak_button",
        Blocks.createWoodenButtonBlock(TFBlockSetTypes.TWILIGHT_OAK_BLOCK_SET_TYPE))
    private val TWILIGHT_OAK_SIGN_TEXTURE: Identifier = TwilightForest.id("entity/signs/twilight_oak")
    private val TWILIGHT_OAK_HANGING_SIGN_TEXTURE: Identifier = TwilightForest.id("entity/signs/hanging/twilight_oak")
    private val TWILIGHT_OAK_HANGING_SIGN_GUI_TEXTURE: Identifier = TwilightForest.id("textures/gui/hanging_signs/twilight_oak")
    val TWILIGHT_OAK_SIGN: TFSignBlock = registerBlockWithoutItem("twilight_oak_sign",
        TFSignBlock(
            TWILIGHT_OAK_SIGN_TEXTURE,
            TFWoodTypes.TWILIGHT_OAK_WOOD_TYPE,
            AbstractBlock.Settings.copy(Blocks.OAK_SIGN))
    )
    val TWILIGHT_OAK_WALL_SIGN: TFWallSignBlock = registerBlockWithoutItem("twilight_oak_wall_sign",
        TFWallSignBlock(
            TWILIGHT_OAK_SIGN_TEXTURE,
            TFWoodTypes.TWILIGHT_OAK_WOOD_TYPE,
            AbstractBlock.Settings.copy(Blocks.OAK_WALL_SIGN)
        )
    )
    val TWILIGHT_OAK_HANGING_SIGN: TFHangingSignBlock = registerBlockWithoutItem("twilight_oak_hanging_sign",
        TFHangingSignBlock(
            TWILIGHT_OAK_HANGING_SIGN_TEXTURE,
            TWILIGHT_OAK_HANGING_SIGN_GUI_TEXTURE,
            TFWoodTypes.TWILIGHT_OAK_WOOD_TYPE,
            AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN)
        )
    )
    val TWILIGHT_OAK_WALL_HANGING_SIGN: TFWallHangingSignBlock = registerBlockWithoutItem("twilight_oak_wall_hanging_sign",
        TFWallHangingSignBlock(
            TWILIGHT_OAK_HANGING_SIGN_TEXTURE,
            TWILIGHT_OAK_HANGING_SIGN_GUI_TEXTURE,
            TFWoodTypes.TWILIGHT_OAK_WOOD_TYPE,
            AbstractBlock.Settings.copy(Blocks.OAK_WALL_HANGING_SIGN)
        )
    )

    private fun <T: Block> registerBlock(name: String, block: T): T {
        registerBlockWithItem(name, block)
        return Registry.register(Registries.BLOCK, Identifier.of(TwilightForest.MOD_ID, name), block)
    }

    private fun <T: Block> registerBlockWithoutItem(name: String, block: T): T {
        return Registry.register(Registries.BLOCK, Identifier.of(TwilightForest.MOD_ID, name), block)
    }

    private fun registerBlockWithItem(name: String, block: Block) {
        Registry.register(
            Registries.ITEM,
            Identifier.of(TwilightForest.MOD_ID, name),
            BlockItem(block, Item.Settings())
        )
    }

    fun registerBlocks() {
        TwilightForest.logger.info("Registering blocks for " + TwilightForest.MOD_ID)

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