package autumn.twilightforest.world.foliage.custom

import autumn.twilightforest.init.block.TFBlocks
import autumn.twilightforest.world.foliage.TFFoliagePlacerTypes
import com.mojang.serialization.Codec
import com.mojang.serialization.MapCodec
import com.mojang.serialization.codecs.RecordCodecBuilder
import net.minecraft.registry.tag.BlockTags
import net.minecraft.state.property.Properties
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.util.math.intprovider.ConstantIntProvider
import net.minecraft.util.math.intprovider.IntProvider
import net.minecraft.util.math.random.Random
import net.minecraft.world.StructureWorldAccess
import net.minecraft.world.TestableWorld
import net.minecraft.world.gen.feature.TreeFeatureConfig
import net.minecraft.world.gen.foliage.FoliagePlacer
import net.minecraft.world.gen.foliage.FoliagePlacerType
import kotlin.math.abs
import kotlin.math.ceil
import kotlin.math.sign

class SpheroidFoliagePlacer(
    val radiusHorizontal: Double,
    val radiusVertical: Double,
    val radiusOffset: IntProvider,
    val foliageDensity: Float,
    val height: Int
) : FoliagePlacer(ConstantIntProvider.create(0), radiusOffset) {

    companion object {
        val CODEC: MapCodec<SpheroidFoliagePlacer> = RecordCodecBuilder.mapCodec { instance ->
            instance.group(
                Codec.DOUBLE.fieldOf("radius_horizontal").forGetter { it.radiusHorizontal },
                Codec.DOUBLE.fieldOf("radius_vertical").forGetter { it.radiusVertical },
                IntProvider.VALUE_CODEC.fieldOf("radius_offset").forGetter { it.radiusOffset },
                Codec.FLOAT.fieldOf("foliage_density").forGetter { it.foliageDensity },
                Codec.INT.fieldOf("height").forGetter { it.height }
            ).apply(instance, ::SpheroidFoliagePlacer)
        }
    }

    override fun getType(): FoliagePlacerType<*> = TFFoliagePlacerTypes.SPHEROID_FOLIAGE_TYPE

    override fun generate(
        world: TestableWorld,
        placer: FoliagePlacer.BlockPlacer,
        random: Random,
        config: TreeFeatureConfig,
        trunkHeight: Int,
        treeNode: FoliagePlacer.TreeNode,
        foliageHeight: Int,
        radius: Int,
        offset: Int
    ) {
        val center = treeNode.center
        val canopyBaseY = center.y
        val baseRadius = radiusHorizontal * 0.8

        val centralPancakeCenter = BlockPos(center.x, canopyBaseY + 1, center.z)

        generatePancake(world, placer, random, config, centralPancakeCenter, canopyBaseY + 1, baseRadius * 1.15)

        val directions = listOf(
            BlockPos(random.nextBetween(4, 8), 0, 0),    // East
            BlockPos(-random.nextBetween(4, 8), 0, 0),   // West
            BlockPos(0, 0, random.nextBetween(4, 8)),    // South
            BlockPos(0, 0, -random.nextBetween(4, 8))    // North
        )

        for (dir in directions) {
            val verticalOffset = random.nextBetween(2, 3)
            val layerY = canopyBaseY + 1 - verticalOffset
            val layerCenter = BlockPos(center.x + dir.x, layerY, center.z + dir.z)

            generatePancake(world, placer, random, config, layerCenter, layerY, baseRadius * 1.15)

            val canopyWoodPos = layerCenter.down(2)
            placeCanopyWood(placer, canopyWoodPos)

            val branchStartY = canopyWoodPos.y - random.nextBetween(5, 9)
            drawBranch(world, canopyWoodPos, center.withY(canopyWoodPos.y), random)
        }
    }

    private fun generatePancake(
        world: TestableWorld,
        placer: FoliagePlacer.BlockPlacer,
        random: Random,
        config: TreeFeatureConfig,
        center: BlockPos,
        layerY: Int,
        baseRadius: Double
    ) {
        for (dy in -1..1) {
            val yPos = layerY + dy
            val radiusFactor = if (dy == 0) 1.0 else 0.75
            val radius = baseRadius * radiusFactor * (0.85 + random.nextDouble() * 0.3)
            val radiusInt = ceil(radius).toInt()

            for (dx in -radiusInt..radiusInt) {
                for (dz in -radiusInt..radiusInt) {
                    val fx = dx.toDouble()
                    val fz = dz.toDouble()
                    val distSq = (fx * fx + fz * fz) / (radius * radius)

                    if (distSq <= 1.0) {
                        val pos = BlockPos(center.x + dx, yPos, center.z + dz)
                        placeFoliageBlock(world, placer, random, config, pos)
                    }
                }
            }
        }
    }

    private fun placeCanopyWood(
        placer: FoliagePlacer.BlockPlacer,
        pos: BlockPos
    ) {
        placer.placeBlock(pos, TFBlocks.CANOPY_WOOD.defaultState)
    }


    private fun drawBranch(world: TestableWorld, startPos: BlockPos, trunkCenter: BlockPos, random: net.minecraft.util.math.random.Random) {
        var current = startPos

        while (true) {
            val dx = current.x - trunkCenter.x
            val dz = current.z - trunkCenter.z

            if (abs(dx) <= 1 && abs(dz) <= 1) break

            val stackHeight = if (random.nextFloat() < 0.15f) 0 else 1

            repeat(stackHeight) {
                current = current.down()
                placeDirectionalLog(world, current, Direction.Axis.Y)
            }

            current = current.down()

            val moveX = abs(dx) >= abs(dz) && dx != 0
            if (moveX) {
                current = current.add(-dx.sign, 0, 0)
                placeDirectionalLog(world, current, Direction.Axis.X)
            } else if (dz != 0) {
                current = current.add(0, 0, -dz.sign)
                placeDirectionalLog(world, current, Direction.Axis.Z)
            }
        }
    }

    private fun placeDirectionalLog(world: TestableWorld, pos: BlockPos, axis: Direction.Axis) {
        val state = TFBlocks.CANOPY_WOOD.defaultState.with(Properties.AXIS, axis)
        if (world.testBlockState(pos) { it.isAir || it.isIn(BlockTags.LEAVES) }) {
            (world as? StructureWorldAccess)?.setBlockState(pos, state, 3)
        }

    }

    override fun getRandomHeight(random: Random, trunkHeight: Int, config: TreeFeatureConfig): Int = height

    override fun isInvalidForLeaves(random: Random, dx: Int, y: Int, dz: Int, radius: Int, giantTrunk: Boolean): Boolean {
        return false
    }
}