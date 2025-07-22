package autumn.twilightforest.init.block.custom

import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.CarpetBlock
import net.minecraft.item.ItemPlacementContext
import net.minecraft.state.StateManager
import net.minecraft.state.property.BooleanProperty
import net.minecraft.state.property.Properties
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.util.math.random.Random
import net.minecraft.world.WorldView
import net.minecraft.world.tick.ScheduledTickView

class TFConnectedCarpetBlock(settings: Settings) : CarpetBlock(settings) {
    companion object {
        val NORTH_EAST = BooleanProperty.of("north_east")
        val NORTH_WEST = BooleanProperty.of("north_west")
        val SOUTH_EAST = BooleanProperty.of("south_east")
        val SOUTH_WEST = BooleanProperty.of("south_west")

        val HORIZONTAL_FACING_PROPERTIES = mapOf(
            Direction.NORTH to Properties.NORTH,
            Direction.EAST to Properties.EAST,
            Direction.SOUTH to Properties.SOUTH,
            Direction.WEST to Properties.WEST
        )
    }

    override fun appendProperties(builder: StateManager.Builder<Block, BlockState?>) {
        builder.add(
            Properties.NORTH,
            Properties.EAST,
            Properties.SOUTH,
            Properties.WEST,
            NORTH_EAST,
            NORTH_WEST,
            SOUTH_EAST,
            SOUTH_WEST)
    }

    override fun getPlacementState(ctx: ItemPlacementContext): BlockState {
        val world = ctx.world
        val pos = ctx.blockPos

        return defaultState
            .with(Properties.NORTH, canConnect(world.getBlockState(pos.north())))
            .with(Properties.EAST, canConnect(world.getBlockState(pos.east())))
            .with(Properties.SOUTH, canConnect(world.getBlockState(pos.south())))
            .with(Properties.WEST, canConnect(world.getBlockState(pos.west())))
            .with(NORTH_EAST, canConnect(world.getBlockState(pos.north().east())))
            .with(NORTH_WEST, canConnect(world.getBlockState(pos.north().west())))
            .with(SOUTH_EAST, canConnect(world.getBlockState(pos.south().east())))
            .with(SOUTH_WEST, canConnect(world.getBlockState(pos.south().west())))
    }

    override fun getStateForNeighborUpdate(
        state: BlockState,
        world: WorldView,
        tickView: ScheduledTickView,
        pos: BlockPos,
        direction: Direction,
        neighborPos: BlockPos,
        neighborState: BlockState,
        random: Random
    ): BlockState? {
        var newState = state

        // Update cardinal direction if applicable
        HORIZONTAL_FACING_PROPERTIES[direction]?.let { prop ->
            newState = newState.with(prop, canConnect(neighborState))
        }

        // Check if the update affects diagonal connections
        // For example, if direction is NORTH or EAST, north_east might be affected
        // So recalculate diagonal properties based on current neighbors

        val posN = pos.north()
        val posE = pos.east()
        val posS = pos.south()
        val posW = pos.west()

        newState = newState
            .with(NORTH_EAST, canConnect(world.getBlockState(posN.east())))
            .with(NORTH_WEST, canConnect(world.getBlockState(posN.west())))
            .with(SOUTH_EAST, canConnect(world.getBlockState(posS.east())))
            .with(SOUTH_WEST, canConnect(world.getBlockState(posS.west())))

        return newState
    }

    private fun canConnect(state: BlockState) : Boolean {
        return state.isOf(this)
    }
}