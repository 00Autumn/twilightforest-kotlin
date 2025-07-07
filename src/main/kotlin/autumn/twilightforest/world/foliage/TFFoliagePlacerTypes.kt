package autumn.twilightforest.world.foliage

import autumn.twilightforest.TwilightForest
import autumn.twilightforest.world.foliage.custom.SpheroidFoliagePlacer
import com.mojang.serialization.MapCodec
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier
import net.minecraft.world.gen.foliage.FoliagePlacer
import net.minecraft.world.gen.foliage.FoliagePlacerType

object TFFoliagePlacerTypes {

    val SPHEROID_FOLIAGE_TYPE = registerFoliagePlacerType("spheroid_foliage_placer", SpheroidFoliagePlacer.CODEC)

    fun <T : FoliagePlacer> registerFoliagePlacerType(name: String, codec: MapCodec<T>): FoliagePlacerType<T> {
        val id = Identifier.of(TwilightForest.MOD_ID, name)
        val type = FoliagePlacerType(codec)
        return Registry.register(Registries.FOLIAGE_PLACER_TYPE, id, type)
    }

    fun registerFoliagePlacerTypes() {
        TwilightForest.logger?.info("Registering foliage types for " + TwilightForest.MOD_ID)
    }

}