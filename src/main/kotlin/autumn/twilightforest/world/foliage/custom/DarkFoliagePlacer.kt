package autumn.twilightforest.world.foliage.custom

import autumn.twilightforest.world.foliage.TFFoliagePlacerTypes
import com.mojang.serialization.Codec
import com.mojang.serialization.MapCodec
import com.mojang.serialization.codecs.RecordCodecBuilder
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.intprovider.ConstantIntProvider
import net.minecraft.util.math.intprovider.IntProvider
import net.minecraft.util.math.random.Random
import net.minecraft.world.TestableWorld
import net.minecraft.world.gen.feature.TreeFeatureConfig
import net.minecraft.world.gen.foliage.FoliagePlacer
import net.minecraft.world.gen.foliage.FoliagePlacerType
import kotlin.math.ceil

class DarkFoliagePlacer(
    val radiusHorizontal: Double,
    val radiusVertical: Double,
    val radiusOffset: IntProvider,
    val foliageDensity: Float,
    val height: Int
) : FoliagePlacer(ConstantIntProvider.create(0), radiusOffset) {

    companion object {
        val CODEC: MapCodec<DarkFoliagePlacer> = RecordCodecBuilder.mapCodec { instance ->
            instance.group(
                Codec.DOUBLE.fieldOf("radius_horizontal").forGetter { it.radiusHorizontal },
                Codec.DOUBLE.fieldOf("radius_vertical").forGetter { it.radiusVertical },
                IntProvider.VALUE_CODEC.fieldOf("radius_offset").forGetter { it.radiusOffset },
                Codec.FLOAT.fieldOf("foliage_density").forGetter { it.foliageDensity },
                Codec.INT.fieldOf("height").forGetter { it.height }
            ).apply(instance, ::DarkFoliagePlacer)
        }
    }

    override fun getType(): FoliagePlacerType<*> = TFFoliagePlacerTypes.DARK_FOLIAGE_PLACER_TYPE

    override fun generate(
        world: TestableWorld,
        placer: BlockPlacer,
        random: Random,
        config: TreeFeatureConfig,
        trunkHeight: Int,
        treeNode: TreeNode,
        foliageHeight: Int,
        radius: Int,
        offset: Int
    ) {
        val center = treeNode.center
        val pancakeRadius = radiusHorizontal

        val directions = listOf(
            BlockPos(5, 0, 0),
            BlockPos(-5, 0, 0),
            BlockPos(0, 0, 5),
            BlockPos(0, 0, -5)
        )

        val usedY = mutableSetOf<Int>()
        val yOffsets = mutableListOf<Int>()
        while (yOffsets.size < 4) {
            val yOffset = random.nextInt(4) - 4
            if (usedY.add(yOffset)) {
                yOffsets.add(yOffset)
            }
        }

        for ((i, direction) in directions.withIndex()) {
            val yOffset = yOffsets[i]
            val pancakeCenter = center.add(direction).add(0, yOffset, 0)
            generateTripleLayeredPancake(
                world,
                placer,
                random,
                config,
                pancakeCenter,
                pancakeCenter.y + 1,
                pancakeRadius
            )
        }
        placeSupportLogs(world, placer, random, config, center)
    }

    private fun placeSupportLogs(
        world: TestableWorld,
        placer: BlockPlacer,
        random: Random,
        config: TreeFeatureConfig,
        trunkTop: BlockPos
    ) {
        val directionPairs = listOf(
            listOf(BlockPos(-1, 0, -1), BlockPos(1, 0, 1)),  // NW & SE
            listOf(BlockPos(-1, 0, 1), BlockPos(1, 0, -1))   // SW & NE
        )
        val chosenPair = directionPairs[random.nextInt(directionPairs.size)]

        for (offset in chosenPair) {
            val basePos = trunkTop.down(2).add(offset)

            val height = random.nextInt(2) + 4

            for (i in 0 until height) {
                val logPos = basePos.down(i)
                val logState = config.trunkProvider.get(random, logPos)
                placer.placeBlock(logPos, logState)
            }
        }
    }

    private fun generateTripleLayeredPancake(
        world: TestableWorld,
        placer: BlockPlacer,
        random: Random,
        config: TreeFeatureConfig,
        center: BlockPos,
        baseY: Int,
        radius: Double
    ) {
        for (dy in -1..1) {
            val y = baseY + dy
            val scale = if (dy == 0) 1.0 else 0.75
            val r = radius * scale * (0.85 + random.nextDouble() * 0.25)
            val rInt = ceil(r).toInt()

            for (dx in -rInt..rInt) {
                for (dz in -rInt..rInt) {
                    val dist = (dx * dx + dz * dz).toDouble() / (r * r)
                    if (dist <= 1.0) {
                        val pos = BlockPos(center.x + dx, y, center.z + dz)
                        placeFoliageBlock(world, placer, random, config, pos)
                    }
                }
            }
        }
    }

    override fun getRandomHeight(
        random: Random,
        trunkHeight: Int,
        config: TreeFeatureConfig
    ): Int = height

    override fun isInvalidForLeaves(
        random: Random,
        dx: Int,
        y: Int,
        dz: Int,
        radius: Int,
        giantTrunk: Boolean
    ): Boolean = false
}
