package autumn.twilightforest.init.block

import autumn.twilightforest.TwilightForest
import autumn.twilightforest.datacomponent.TFDataComponentTypes
import autumn.twilightforest.datacomponent.tooltip.TooltipComponent
import autumn.twilightforest.init.block.TFBlocks.registerCopyBlock
import autumn.twilightforest.init.block.custom.ArcticFurBlock
import autumn.twilightforest.init.block.custom.FieryBlock
import autumn.twilightforest.init.block.custom.HedgeBlock
import autumn.twilightforest.init.block.custom.KnightmetalBlock
import autumn.twilightforest.sign.TFSignBlockHelper
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
import net.minecraft.block.HangingSignBlock
import net.minecraft.block.InfestedBlock
import net.minecraft.block.MapColor
import net.minecraft.block.PillarBlock
import net.minecraft.block.PressurePlateBlock
import net.minecraft.block.SaplingBlock
import net.minecraft.block.SignBlock
import net.minecraft.block.SlabBlock
import net.minecraft.block.SlimeBlock
import net.minecraft.block.StairsBlock
import net.minecraft.block.TintedParticleLeavesBlock
import net.minecraft.block.TrapdoorBlock
import net.minecraft.block.WallHangingSignBlock
import net.minecraft.block.WallSignBlock
import net.minecraft.block.WoodType
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

    //STORAGE BLOCKS
    val MAZE_SLIME_BLOCK = registerCopyBlock("maze_slime_block", Blocks.SLIME_BLOCK) { settings -> SlimeBlock(settings.mapColor(MapColor.LIGHT_GRAY)) }
    val IRONWOOD_BLOCK = registerCopyBlock("ironwood_block", Blocks.IRON_BLOCK) { settings -> Block(settings.mapColor(MapColor.LICHEN_GREEN).sounds(BlockSoundGroup.METAL)) }
    val STEELEAF_BLOCK = registerCopyBlock("steeleaf_block", Blocks.DIAMOND_BLOCK) { settings -> Block(settings.mapColor(MapColor.GREEN).sounds(BlockSoundGroup.METAL)) }
    val KNIGHTMETAL_BLOCK = registerCopyBlock("knightmetal_block", Blocks.DIAMOND_BLOCK) { settings -> KnightmetalBlock(settings.mapColor(MapColor.LIGHT_GRAY).sounds(BlockSoundGroup.ANVIL)) }
    val FIERY_BLOCK = registerBlockWithTooltip(name = "fiery_block", baseBlock = Blocks.DIAMOND_BLOCK, tooltipKey = "tooltip.twilightforest.fiery_block.tooltip") { settings -> FieryBlock(settings.mapColor(MapColor.TERRACOTTA_RED).sounds(BlockSoundGroup.METAL)) }
    val ARCTIC_FUR_BLOCK = registerCopyBlock("arctic_fur_block", Blocks.WHITE_WOOL) { settings -> ArcticFurBlock(settings) }

    // LABYRINTH BLOCKS
    val MAZESTONE = registerBlock("mazestone") { settings -> Block(settings.instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.LIGHT_GRAY).requiresTool().sounds(BlockSoundGroup.STONE).strength(100.0f, 5.0f)) }
    val MAZESTONE_BRICK = registerCopyBlock("mazestone_brick", MAZESTONE) { settings -> Block(settings) }
    val MAZESTONE_LARGE_BRICK = registerCopyBlock("mazestone_large_brick", MAZESTONE) { settings -> Block(settings) }
    val CHISELED_MAZESTONE = registerCopyBlock("chiseled_mazestone", MAZESTONE) { settings -> Block(settings) }
    val CUT_MAZESTONE = registerCopyBlock("cut_mazestone", MAZESTONE) { settings -> Block(settings) }
    val DECORATIVE_MAZESTONE = registerCopyBlock("decorative_mazestone", MAZESTONE) { settings -> Block(settings) }
    val CRACKED_MAZESTONE_BRICK = registerCopyBlock("cracked_mazestone_brick", MAZESTONE) { settings -> Block(settings) }
    val MOSSY_MAZESTONE_BRICK = registerCopyBlock("mossy_mazestone_brick", MAZESTONE) { settings -> Block(settings) }
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
    val TWILIGHT_OAK_WOOD_TYPE: WoodType = TFSignBlockHelper.registerDefaultWoodType(TwilightForest.id("twilight_oak"))
    private val SIGN_SETTINGS = AbstractBlock.Settings.create().strength(1.0f).noCollision()
    val TWILIGHT_OAK_SIGN: Block = TFSignBlockHelper.registerSignBlock(TwilightForest.id("twilight_oak_sign"), { settings -> SignBlock(TWILIGHT_OAK_WOOD_TYPE, settings) }, SIGN_SETTINGS)
    val TWILIGHT_OAK_WALL_SIGN: Block = TFSignBlockHelper.registerSignBlock(TwilightForest.id("twilight_oak_wall_sign"), { settings -> WallSignBlock(TWILIGHT_OAK_WOOD_TYPE, settings) }, SIGN_SETTINGS)
    val TWILIGHT_OAK_HANGING_SIGN: Block = TFSignBlockHelper.registerSignBlock(TwilightForest.id("twilight_oak_hanging_sign"), { settings -> HangingSignBlock(TWILIGHT_OAK_WOOD_TYPE, settings) }, SIGN_SETTINGS)
    val TWILIGHT_OAK_WALL_HANGING_SIGN: Block = TFSignBlockHelper.registerSignBlock(TwilightForest.id("twilight_oak_wall_hanging_sign"), { settings -> WallHangingSignBlock(TWILIGHT_OAK_WOOD_TYPE, settings) }, SIGN_SETTINGS)

    val CANOPY_LOG = registerVanillaBlock("canopy_log", Blocks.JUNGLE_LOG) { settings -> PillarBlock(settings) }
    val STRIPPED_CANOPY_LOG = registerVanillaBlock("stripped_canopy_log", Blocks.STRIPPED_JUNGLE_LOG) { settings -> PillarBlock(settings) }
    val CANOPY_WOOD = registerCopyBlock("canopy_wood", Blocks.JUNGLE_WOOD) { settings -> PillarBlock(settings) }
    val STRIPPED_CANOPY_WOOD = registerCopyBlock("stripped_canopy_wood", Blocks.STRIPPED_JUNGLE_WOOD) { settings -> PillarBlock(settings) }
    val CANOPY_LEAVES = registerVanillaBlock("canopy_leaves", Blocks.JUNGLE_LEAVES) { settings -> TintedParticleLeavesBlock(0.02F, settings) }
    val CANOPY_SAPLING = registerCopyBlock("canopy_sapling", Blocks.JUNGLE_SAPLING) { settings -> SaplingBlock(null, settings) }
    val CANOPY_PLANKS = registerCopyBlock("canopy_planks", Blocks.JUNGLE_PLANKS) { settings -> Block(settings) }
    val CANOPY_DOOR = registerCopyBlock("canopy_door", Blocks.JUNGLE_DOOR) { settings -> DoorBlock(TFBlockSetTypes.CANOPY_BLOCK_SET_TYPE, settings) }
    val CANOPY_TRAPDOOR = registerCopyBlock("canopy_trapdoor", Blocks.JUNGLE_TRAPDOOR) {settings -> TrapdoorBlock(TFBlockSetTypes.CANOPY_BLOCK_SET_TYPE, settings) }
    val CANOPY_FENCE = registerCopyBlock("canopy_fence", Blocks.JUNGLE_FENCE) { settings -> FenceBlock(settings) }
    val CANOPY_FENCE_GATE = registerCopyBlock("canopy_fence_gate", Blocks.JUNGLE_FENCE_GATE) { settings -> FenceGateBlock(TFWoodTypes.CANOPY_WOOD_TYPE, settings) }
    val CANOPY_STAIRS = registerCopyBlock("canopy_stairs", Blocks.JUNGLE_STAIRS) { settings -> StairsBlock(CANOPY_PLANKS.defaultState, settings) }
    val CANOPY_SLAB = registerCopyBlock("canopy_slab", Blocks.JUNGLE_SLAB) { settings -> SlabBlock(settings) }
    val CANOPY_PRESSURE_PLATE = registerCopyBlock("canopy_pressure_plate", Blocks.JUNGLE_PRESSURE_PLATE) { settings -> PressurePlateBlock(TFBlockSetTypes.CANOPY_BLOCK_SET_TYPE, settings) }
    val CANOPY_BUTTON = registerVanillaBlock("canopy_button", Blocks.JUNGLE_BUTTON) { settings -> ButtonBlock(TFBlockSetTypes.CANOPY_BLOCK_SET_TYPE, 10, settings) }
    val CANOPY_WOOD_TYPE: WoodType = TFSignBlockHelper.registerDefaultWoodType(TwilightForest.id("canopy"))
    val CANOPY_SIGN: Block = TFSignBlockHelper.registerSignBlock(TwilightForest.id("canopy_sign"), { settings -> SignBlock(CANOPY_WOOD_TYPE, settings) }, SIGN_SETTINGS)
    val CANOPY_WALL_SIGN: Block = TFSignBlockHelper.registerSignBlock(TwilightForest.id("canopy_wall_sign"), { settings -> WallSignBlock(CANOPY_WOOD_TYPE, settings) }, SIGN_SETTINGS)
    val CANOPY_HANGING_SIGN: Block = TFSignBlockHelper.registerSignBlock(TwilightForest.id("canopy_hanging_sign"), { settings -> HangingSignBlock(CANOPY_WOOD_TYPE, settings) }, SIGN_SETTINGS)
    val CANOPY_WALL_HANGING_SIGN: Block = TFSignBlockHelper.registerSignBlock(TwilightForest.id("canopy_wall_hanging_sign"), { settings -> WallHangingSignBlock(CANOPY_WOOD_TYPE, settings) }, SIGN_SETTINGS)

    val TWILIGHT_MANGROVE_LOG = registerVanillaBlock("twilight_mangrove_log", Blocks.MANGROVE_LOG) { settings -> PillarBlock(settings) }
    val STRIPPED_TWILIGHT_MANGROVE_LOG = registerVanillaBlock("stripped_twilight_mangrove_log", Blocks.STRIPPED_MANGROVE_LOG) { settings -> PillarBlock(settings) }
    val TWILIGHT_MANGROVE_WOOD = registerCopyBlock("twilight_mangrove_wood", Blocks.MANGROVE_WOOD) { settings -> PillarBlock(settings) }
    val STRIPPED_TWILIGHT_MANGROVE_WOOD = registerCopyBlock("stripped_twilight_mangrove_wood", Blocks.STRIPPED_MANGROVE_WOOD) { settings -> PillarBlock(settings) }
    val TWILIGHT_MANGROVE_LEAVES = registerVanillaBlock("twilight_mangrove_leaves", Blocks.MANGROVE_LEAVES) { settings -> TintedParticleLeavesBlock(0.02F, settings) }
    val TWILIGHT_MANGROVE_SAPLING = registerCopyBlock("twilight_mangrove_sapling", Blocks.JUNGLE_SAPLING) { settings -> SaplingBlock(null, settings) }
    val TWILIGHT_MANGROVE_PLANKS = registerCopyBlock("twilight_mangrove_planks", Blocks.MANGROVE_PLANKS) { settings -> Block(settings) }
    val TWILIGHT_MANGROVE_DOOR = registerCopyBlock("twilight_mangrove_door", Blocks.MANGROVE_DOOR) { settings -> DoorBlock(TFBlockSetTypes.TWILIGHT_MANGROVE_BLOCK_SET_TYPE, settings) }
    val TWILIGHT_MANGROVE_TRAPDOOR = registerCopyBlock("twilight_mangrove_trapdoor", Blocks.MANGROVE_TRAPDOOR) {settings -> TrapdoorBlock(TFBlockSetTypes.TWILIGHT_MANGROVE_BLOCK_SET_TYPE, settings) }
    val TWILIGHT_MANGROVE_FENCE = registerCopyBlock("twilight_mangrove_fence", Blocks.MANGROVE_FENCE) { settings -> FenceBlock(settings) }
    val TWILIGHT_MANGROVE_FENCE_GATE = registerCopyBlock("twilight_mangrove_fence_gate", Blocks.MANGROVE_FENCE_GATE) { settings -> FenceGateBlock(TFWoodTypes.TWILIGHT_MANGROVE_WOOD_TYPE, settings) }
    val TWILIGHT_MANGROVE_STAIRS = registerCopyBlock("twilight_mangrove_stairs", Blocks.MANGROVE_STAIRS) { settings -> StairsBlock(TWILIGHT_MANGROVE_PLANKS.defaultState, settings) }
    val TWILIGHT_MANGROVE_SLAB = registerCopyBlock("twilight_mangrove_slab", Blocks.MANGROVE_SLAB) { settings -> SlabBlock(settings) }
    val TWILIGHT_MANGROVE_PRESSURE_PLATE = registerCopyBlock("twilight_mangrove_pressure_plate", Blocks.MANGROVE_PRESSURE_PLATE) { settings -> PressurePlateBlock(TFBlockSetTypes.TWILIGHT_MANGROVE_BLOCK_SET_TYPE, settings) }
    val TWILIGHT_MANGROVE_BUTTON = registerVanillaBlock("twilight_mangrove_button", Blocks.MANGROVE_BUTTON) { settings -> ButtonBlock(TFBlockSetTypes.TWILIGHT_MANGROVE_BLOCK_SET_TYPE, 10, settings) }
    val TWILIGHT_MANGROVE_WOOD_TYPE: WoodType = TFSignBlockHelper.registerDefaultWoodType(TwilightForest.id("twilight_mangrove"))
    val TWILIGHT_MANGROVE_SIGN: Block = TFSignBlockHelper.registerSignBlock(TwilightForest.id("twilight_mangrove_sign"), { settings -> SignBlock(TWILIGHT_MANGROVE_WOOD_TYPE, settings) }, SIGN_SETTINGS)
    val TWILIGHT_MANGROVE_WALL_SIGN: Block = TFSignBlockHelper.registerSignBlock(TwilightForest.id("twilight_mangrove_wall_sign"), { settings -> WallSignBlock(TWILIGHT_MANGROVE_WOOD_TYPE, settings) }, SIGN_SETTINGS)
    val TWILIGHT_MANGROVE_HANGING_SIGN: Block = TFSignBlockHelper.registerSignBlock(TwilightForest.id("twilight_mangrove_hanging_sign"), { settings -> HangingSignBlock(TWILIGHT_MANGROVE_WOOD_TYPE, settings) }, SIGN_SETTINGS)
    val TWILIGHT_MANGROVE_WALL_HANGING_SIGN: Block = TFSignBlockHelper.registerSignBlock(TwilightForest.id("twilight_mangrove_wall_hanging_sign"), { settings -> WallHangingSignBlock(TWILIGHT_MANGROVE_WOOD_TYPE, settings) }, SIGN_SETTINGS)

    val DARK_LOG = registerVanillaBlock("dark_log", Blocks.SPRUCE_LOG) { settings -> PillarBlock(settings) }
    val STRIPPED_DARK_LOG = registerVanillaBlock("stripped_dark_log", Blocks.STRIPPED_SPRUCE_LOG) { settings -> PillarBlock(settings) }
    val DARK_WOOD = registerCopyBlock("dark_wood", Blocks.SPRUCE_WOOD) { settings -> PillarBlock(settings) }
    val STRIPPED_DARK_WOOD = registerCopyBlock("stripped_dark_wood", Blocks.STRIPPED_SPRUCE_WOOD) { settings -> PillarBlock(settings) }
    val DARK_LEAVES = registerVanillaBlock("dark_leaves", Blocks.SPRUCE_LEAVES) { settings -> TintedParticleLeavesBlock(0.02F, settings) }
    val DARK_SAPLING = registerCopyBlock("dark_sapling", Blocks.SPRUCE_SAPLING) { settings -> SaplingBlock(null, settings) }
    val DARK_PLANKS = registerCopyBlock("dark_planks", Blocks.SPRUCE_PLANKS) { settings -> Block(settings) }
    val DARK_DOOR = registerCopyBlock("dark_door", Blocks.SPRUCE_DOOR) { settings -> DoorBlock(TFBlockSetTypes.DARK_BLOCK_SET_TYPE, settings) }
    val DARK_TRAPDOOR = registerCopyBlock("dark_trapdoor", Blocks.SPRUCE_TRAPDOOR) { settings -> TrapdoorBlock(TFBlockSetTypes.DARK_BLOCK_SET_TYPE, settings) }
    val DARK_FENCE = registerCopyBlock("dark_fence", Blocks.SPRUCE_FENCE) { settings -> FenceBlock(settings) }
    val DARK_FENCE_GATE = registerCopyBlock("dark_fence_gate", Blocks.SPRUCE_FENCE_GATE) { settings -> FenceGateBlock(TFWoodTypes.DARK_WOOD_TYPE, settings) }
    val DARK_STAIRS = registerCopyBlock("dark_stairs", Blocks.SPRUCE_STAIRS) { settings -> StairsBlock(DARK_PLANKS.defaultState, settings) }
    val DARK_SLAB = registerCopyBlock("dark_slab", Blocks.SPRUCE_SLAB) { settings -> SlabBlock(settings) }
    val DARK_PRESSURE_PLATE = registerCopyBlock("dark_pressure_plate", Blocks.SPRUCE_PRESSURE_PLATE) { settings -> PressurePlateBlock(TFBlockSetTypes.DARK_BLOCK_SET_TYPE, settings) }
    val DARK_BUTTON = registerVanillaBlock("dark_button", Blocks.SPRUCE_BUTTON) { settings -> ButtonBlock(TFBlockSetTypes.DARK_BLOCK_SET_TYPE, 10, settings) }
    val DARK_WOOD_TYPE: WoodType = TFSignBlockHelper.registerDefaultWoodType(TwilightForest.id("dark"))
    val DARK_SIGN: Block = TFSignBlockHelper.registerSignBlock(TwilightForest.id("dark_sign"), { settings -> SignBlock(DARK_WOOD_TYPE, settings) }, SIGN_SETTINGS)
    val DARK_WALL_SIGN: Block = TFSignBlockHelper.registerSignBlock(TwilightForest.id("dark_wall_sign"), { settings -> WallSignBlock(DARK_WOOD_TYPE, settings) }, SIGN_SETTINGS)
    val DARK_HANGING_SIGN: Block = TFSignBlockHelper.registerSignBlock(TwilightForest.id("dark_hanging_sign"), { settings -> HangingSignBlock(DARK_WOOD_TYPE, settings) }, SIGN_SETTINGS)
    val DARK_WALL_HANGING_SIGN: Block = TFSignBlockHelper.registerSignBlock(TwilightForest.id("dark_wall_hanging_sign"), { settings -> WallHangingSignBlock(DARK_WOOD_TYPE, settings) }, SIGN_SETTINGS)

    val TIME_LOG = registerVanillaBlock("time_log", Blocks.SPRUCE_LOG) { settings -> PillarBlock(settings) }
    val STRIPPED_TIME_LOG = registerVanillaBlock("stripped_time_log", Blocks.STRIPPED_SPRUCE_LOG) { settings -> PillarBlock(settings) }
    val TIME_WOOD = registerCopyBlock("time_wood", Blocks.SPRUCE_WOOD) { settings -> PillarBlock(settings) }
    val STRIPPED_TIME_WOOD = registerCopyBlock("stripped_time_wood", Blocks.STRIPPED_SPRUCE_WOOD) { settings -> PillarBlock(settings) }
    val TIME_LEAVES = registerVanillaBlock("time_leaves", Blocks.SPRUCE_LEAVES) { settings -> TintedParticleLeavesBlock(0.02F, settings) }
    val TIME_SAPLING = registerCopyBlock("time_sapling", Blocks.SPRUCE_SAPLING) { settings -> SaplingBlock(null, settings) }
    val TIME_PLANKS = registerCopyBlock("time_planks", Blocks.SPRUCE_PLANKS) { settings -> Block(settings) }
    val TIME_DOOR = registerCopyBlock("time_door", Blocks.SPRUCE_DOOR) { settings -> DoorBlock(TFBlockSetTypes.TIME_BLOCK_SET_TYPE, settings) }
    val TIME_TRAPDOOR = registerCopyBlock("time_trapdoor", Blocks.SPRUCE_TRAPDOOR) { settings -> TrapdoorBlock(TFBlockSetTypes.TIME_BLOCK_SET_TYPE, settings) }
    val TIME_FENCE = registerCopyBlock("time_fence", Blocks.SPRUCE_FENCE) { settings -> FenceBlock(settings) }
    val TIME_FENCE_GATE = registerCopyBlock("time_fence_gate", Blocks.SPRUCE_FENCE_GATE) { settings -> FenceGateBlock(TFWoodTypes.TIME_WOOD_TYPE, settings) }
    val TIME_STAIRS = registerCopyBlock("time_stairs", Blocks.SPRUCE_STAIRS) { settings -> StairsBlock(TIME_PLANKS.defaultState, settings) }
    val TIME_SLAB = registerCopyBlock("time_slab", Blocks.SPRUCE_SLAB) { settings -> SlabBlock(settings) }
    val TIME_PRESSURE_PLATE = registerCopyBlock("time_pressure_plate", Blocks.SPRUCE_PRESSURE_PLATE) { settings -> PressurePlateBlock(TFBlockSetTypes.TIME_BLOCK_SET_TYPE, settings) }
    val TIME_BUTTON = registerVanillaBlock("time_button", Blocks.SPRUCE_BUTTON) { settings -> ButtonBlock(TFBlockSetTypes.TIME_BLOCK_SET_TYPE, 10, settings) }
    val TIME_WOOD_TYPE: WoodType = TFSignBlockHelper.registerDefaultWoodType(TwilightForest.id("time"))
    val TIME_SIGN: Block = TFSignBlockHelper.registerSignBlock(TwilightForest.id("time_sign"), { settings -> SignBlock(TIME_WOOD_TYPE, settings) }, SIGN_SETTINGS)
    val TIME_WALL_SIGN: Block = TFSignBlockHelper.registerSignBlock(TwilightForest.id("time_wall_sign"), { settings -> WallSignBlock(TIME_WOOD_TYPE, settings) }, SIGN_SETTINGS)
    val TIME_HANGING_SIGN: Block = TFSignBlockHelper.registerSignBlock(TwilightForest.id("time_hanging_sign"), { settings -> HangingSignBlock(TIME_WOOD_TYPE, settings) }, SIGN_SETTINGS)
    val TIME_WALL_HANGING_SIGN: Block = TFSignBlockHelper.registerSignBlock(TwilightForest.id("time_wall_hanging_sign"), { settings -> WallHangingSignBlock(TIME_WOOD_TYPE, settings) }, SIGN_SETTINGS)

    val TRANSFORMATION_LOG = registerVanillaBlock("transformation_log", Blocks.SPRUCE_LOG) { settings -> PillarBlock(settings) }
    val STRIPPED_TRANSFORMATION_LOG = registerVanillaBlock("stripped_transformation_log", Blocks.STRIPPED_SPRUCE_LOG) { settings -> PillarBlock(settings) }
    val TRANSFORMATION_WOOD = registerCopyBlock("transformation_wood", Blocks.SPRUCE_WOOD) { settings -> PillarBlock(settings) }
    val STRIPPED_TRANSFORMATION_WOOD = registerCopyBlock("stripped_transformation_wood", Blocks.STRIPPED_SPRUCE_WOOD) { settings -> PillarBlock(settings) }
    val TRANSFORMATION_LEAVES = registerVanillaBlock("transformation_leaves", Blocks.SPRUCE_LEAVES) { settings -> TintedParticleLeavesBlock(0.02F, settings) }
    val TRANSFORMATION_SAPLING = registerCopyBlock("transformation_sapling", Blocks.SPRUCE_SAPLING) { settings -> SaplingBlock(null, settings) }
    val TRANSFORMATION_PLANKS = registerCopyBlock("transformation_planks", Blocks.SPRUCE_PLANKS) { settings -> Block(settings) }
    val TRANSFORMATION_DOOR = registerCopyBlock("transformation_door", Blocks.SPRUCE_DOOR) { settings -> DoorBlock(TFBlockSetTypes.TRANSFORMATION_BLOCK_SET_TYPE, settings) }
    val TRANSFORMATION_TRAPDOOR = registerCopyBlock("transformation_trapdoor", Blocks.SPRUCE_TRAPDOOR) { settings -> TrapdoorBlock(TFBlockSetTypes.TRANSFORMATION_BLOCK_SET_TYPE, settings) }
    val TRANSFORMATION_FENCE = registerCopyBlock("transformation_fence", Blocks.SPRUCE_FENCE) { settings -> FenceBlock(settings) }
    val TRANSFORMATION_FENCE_GATE = registerCopyBlock("transformation_fence_gate", Blocks.SPRUCE_FENCE_GATE) { settings -> FenceGateBlock(TFWoodTypes.TRANSFORMATION_WOOD_TYPE, settings) }
    val TRANSFORMATION_STAIRS = registerCopyBlock("transformation_stairs", Blocks.SPRUCE_STAIRS) { settings -> StairsBlock(TRANSFORMATION_PLANKS.defaultState, settings) }
    val TRANSFORMATION_SLAB = registerCopyBlock("transformation_slab", Blocks.SPRUCE_SLAB) { settings -> SlabBlock(settings) }
    val TRANSFORMATION_PRESSURE_PLATE = registerCopyBlock("transformation_pressure_plate", Blocks.SPRUCE_PRESSURE_PLATE) { settings -> PressurePlateBlock(TFBlockSetTypes.TRANSFORMATION_BLOCK_SET_TYPE, settings) }
    val TRANSFORMATION_BUTTON = registerVanillaBlock("transformation_button", Blocks.SPRUCE_BUTTON) { settings -> ButtonBlock(TFBlockSetTypes.TRANSFORMATION_BLOCK_SET_TYPE, 10, settings) }
    val TRANSFORMATION_WOOD_TYPE: WoodType = TFSignBlockHelper.registerDefaultWoodType(TwilightForest.id("transformation"))
    val TRANSFORMATION_SIGN: Block = TFSignBlockHelper.registerSignBlock(TwilightForest.id("transformation_sign"), { settings -> SignBlock(TRANSFORMATION_WOOD_TYPE, settings) }, SIGN_SETTINGS)
    val TRANSFORMATION_WALL_SIGN: Block = TFSignBlockHelper.registerSignBlock(TwilightForest.id("transformation_wall_sign"), { settings -> WallSignBlock(TRANSFORMATION_WOOD_TYPE, settings) }, SIGN_SETTINGS)
    val TRANSFORMATION_HANGING_SIGN: Block = TFSignBlockHelper.registerSignBlock(TwilightForest.id("transformation_hanging_sign"), { settings -> HangingSignBlock(TRANSFORMATION_WOOD_TYPE, settings) }, SIGN_SETTINGS)
    val TRANSFORMATION_WALL_HANGING_SIGN: Block = TFSignBlockHelper.registerSignBlock(TwilightForest.id("transformation_wall_hanging_sign"), { settings -> WallHangingSignBlock(TRANSFORMATION_WOOD_TYPE, settings) }, SIGN_SETTINGS)

    val MINING_LOG = registerVanillaBlock("mining_log", Blocks.SPRUCE_LOG) { settings -> PillarBlock(settings) }
    val STRIPPED_MINING_LOG = registerVanillaBlock("stripped_mining_log", Blocks.STRIPPED_SPRUCE_LOG) { settings -> PillarBlock(settings) }
    val MINING_WOOD = registerCopyBlock("mining_wood", Blocks.SPRUCE_WOOD) { settings -> PillarBlock(settings) }
    val STRIPPED_MINING_WOOD = registerCopyBlock("stripped_mining_wood", Blocks.STRIPPED_SPRUCE_WOOD) { settings -> PillarBlock(settings) }
    val MINING_LEAVES = registerVanillaBlock("mining_leaves", Blocks.SPRUCE_LEAVES) { settings -> TintedParticleLeavesBlock(0.02F, settings) }
    val MINING_SAPLING = registerCopyBlock("mining_sapling", Blocks.SPRUCE_SAPLING) { settings -> SaplingBlock(null, settings) }
    val MINING_PLANKS = registerCopyBlock("mining_planks", Blocks.SPRUCE_PLANKS) { settings -> Block(settings) }
    val MINING_DOOR = registerCopyBlock("mining_door", Blocks.SPRUCE_DOOR) { settings -> DoorBlock(TFBlockSetTypes.MINING_BLOCK_SET_TYPE, settings) }
    val MINING_TRAPDOOR = registerCopyBlock("mining_trapdoor", Blocks.SPRUCE_TRAPDOOR) { settings -> TrapdoorBlock(TFBlockSetTypes.MINING_BLOCK_SET_TYPE, settings) }
    val MINING_FENCE = registerCopyBlock("mining_fence", Blocks.SPRUCE_FENCE) { settings -> FenceBlock(settings) }
    val MINING_FENCE_GATE = registerCopyBlock("mining_fence_gate", Blocks.SPRUCE_FENCE_GATE) { settings -> FenceGateBlock(TFWoodTypes.MINING_WOOD_TYPE, settings) }
    val MINING_STAIRS = registerCopyBlock("mining_stairs", Blocks.SPRUCE_STAIRS) { settings -> StairsBlock(MINING_PLANKS.defaultState, settings) }
    val MINING_SLAB = registerCopyBlock("mining_slab", Blocks.SPRUCE_SLAB) { settings -> SlabBlock(settings) }
    val MINING_PRESSURE_PLATE = registerCopyBlock("mining_pressure_plate", Blocks.SPRUCE_PRESSURE_PLATE) { settings -> PressurePlateBlock(TFBlockSetTypes.MINING_BLOCK_SET_TYPE, settings) }
    val MINING_BUTTON = registerVanillaBlock("mining_button", Blocks.SPRUCE_BUTTON) { settings -> ButtonBlock(TFBlockSetTypes.MINING_BLOCK_SET_TYPE, 10, settings) }
    val MINING_WOOD_TYPE: WoodType = TFSignBlockHelper.registerDefaultWoodType(TwilightForest.id("mining"))
    val MINING_SIGN: Block = TFSignBlockHelper.registerSignBlock(TwilightForest.id("mining_sign"), { settings -> SignBlock(MINING_WOOD_TYPE, settings) }, SIGN_SETTINGS)
    val MINING_WALL_SIGN: Block = TFSignBlockHelper.registerSignBlock(TwilightForest.id("mining_wall_sign"), { settings -> WallSignBlock(MINING_WOOD_TYPE, settings) }, SIGN_SETTINGS)
    val MINING_HANGING_SIGN: Block = TFSignBlockHelper.registerSignBlock(TwilightForest.id("mining_hanging_sign"), { settings -> HangingSignBlock(MINING_WOOD_TYPE, settings) }, SIGN_SETTINGS)
    val MINING_WALL_HANGING_SIGN: Block = TFSignBlockHelper.registerSignBlock(TwilightForest.id("mining_wall_hanging_sign"), { settings -> WallHangingSignBlock(MINING_WOOD_TYPE, settings) }, SIGN_SETTINGS)

    val SORTING_LOG = registerVanillaBlock("sorting_log", Blocks.SPRUCE_LOG) { settings -> PillarBlock(settings) }
    val STRIPPED_SORTING_LOG = registerVanillaBlock("stripped_sorting_log", Blocks.STRIPPED_SPRUCE_LOG) { settings -> PillarBlock(settings) }
    val SORTING_WOOD = registerCopyBlock("sorting_wood", Blocks.SPRUCE_WOOD) { settings -> PillarBlock(settings) }
    val STRIPPED_SORTING_WOOD = registerCopyBlock("stripped_sorting_wood", Blocks.STRIPPED_SPRUCE_WOOD) { settings -> PillarBlock(settings) }
    val SORTING_LEAVES = registerVanillaBlock("sorting_leaves", Blocks.SPRUCE_LEAVES) { settings -> TintedParticleLeavesBlock(0.02F, settings) }
    val SORTING_SAPLING = registerCopyBlock("sorting_sapling", Blocks.SPRUCE_SAPLING) { settings -> SaplingBlock(null, settings) }
    val SORTING_PLANKS = registerCopyBlock("sorting_planks", Blocks.SPRUCE_PLANKS) { settings -> Block(settings) }
    val SORTING_DOOR = registerCopyBlock("sorting_door", Blocks.SPRUCE_DOOR) { settings -> DoorBlock(TFBlockSetTypes.SORTING_BLOCK_SET_TYPE, settings) }
    val SORTING_TRAPDOOR = registerCopyBlock("sorting_trapdoor", Blocks.SPRUCE_TRAPDOOR) { settings -> TrapdoorBlock(TFBlockSetTypes.SORTING_BLOCK_SET_TYPE, settings) }
    val SORTING_FENCE = registerCopyBlock("sorting_fence", Blocks.SPRUCE_FENCE) { settings -> FenceBlock(settings) }
    val SORTING_FENCE_GATE = registerCopyBlock("sorting_fence_gate", Blocks.SPRUCE_FENCE_GATE) { settings -> FenceGateBlock(TFWoodTypes.SORTING_WOOD_TYPE, settings) }
    val SORTING_STAIRS = registerCopyBlock("sorting_stairs", Blocks.SPRUCE_STAIRS) { settings -> StairsBlock(SORTING_PLANKS.defaultState, settings) }
    val SORTING_SLAB = registerCopyBlock("sorting_slab", Blocks.SPRUCE_SLAB) { settings -> SlabBlock(settings) }
    val SORTING_PRESSURE_PLATE = registerCopyBlock("sorting_pressure_plate", Blocks.SPRUCE_PRESSURE_PLATE) { settings -> PressurePlateBlock(TFBlockSetTypes.SORTING_BLOCK_SET_TYPE, settings) }
    val SORTING_BUTTON = registerVanillaBlock("sorting_button", Blocks.SPRUCE_BUTTON) { settings -> ButtonBlock(TFBlockSetTypes.SORTING_BLOCK_SET_TYPE, 10, settings) }
    val SORTING_WOOD_TYPE: WoodType = TFSignBlockHelper.registerDefaultWoodType(TwilightForest.id("sorting"))
    val SORTING_SIGN: Block = TFSignBlockHelper.registerSignBlock(TwilightForest.id("sorting_sign"), { settings -> SignBlock(SORTING_WOOD_TYPE, settings) }, SIGN_SETTINGS)
    val SORTING_WALL_SIGN: Block = TFSignBlockHelper.registerSignBlock(TwilightForest.id("sorting_wall_sign"), { settings -> WallSignBlock(SORTING_WOOD_TYPE, settings) }, SIGN_SETTINGS)
    val SORTING_HANGING_SIGN: Block = TFSignBlockHelper.registerSignBlock(TwilightForest.id("sorting_hanging_sign"), { settings -> HangingSignBlock(SORTING_WOOD_TYPE, settings) }, SIGN_SETTINGS)
    val SORTING_WALL_HANGING_SIGN: Block = TFSignBlockHelper.registerSignBlock(TwilightForest.id("sorting_wall_hanging_sign"), { settings -> WallHangingSignBlock(SORTING_WOOD_TYPE, settings) }, SIGN_SETTINGS)

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

    private fun registerBlockWithTooltip(name: String, baseBlock: Block, tooltipKey: String, blockFactory: (AbstractBlock.Settings) -> Block): Block {
        val id = Identifier.of(TwilightForest.MOD_ID, name)
        val blockKey = RegistryKey.of(RegistryKeys.BLOCK, id)
        val blockSettings = AbstractBlock.Settings.copy(baseBlock).registryKey(blockKey)
        val block = blockFactory(blockSettings)
        val registeredBlock = Registry.register(Registries.BLOCK, id, block)
        val tooltipComponent = TooltipComponent(tooltipKey)
        val itemKey = RegistryKey.of(RegistryKeys.ITEM, id)
        val itemSettings = Item.Settings()
            .useBlockPrefixedTranslationKey()
            .registryKey(itemKey)
            .component(TFDataComponentTypes.TOOLTIP, tooltipComponent)

        val blockItem = BlockItem(block, itemSettings)
        Registry.register(Registries.ITEM, id, blockItem)

        return registeredBlock
    }

    fun registerBlocks() {
        TwilightForest.logger?.info("Registering blocks for " + TwilightForest.MOD_ID)
    }
}