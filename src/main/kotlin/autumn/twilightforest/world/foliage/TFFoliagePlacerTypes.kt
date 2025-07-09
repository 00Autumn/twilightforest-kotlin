package autumn.twilightforest.world.foliage

import autumn.twilightforest.TwilightForest
import autumn.twilightforest.world.foliage.custom.CanopyFoliagePlacer
import autumn.twilightforest.world.foliage.custom.DarkFoliagePlacer
import com.mojang.serialization.MapCodec
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier
import net.minecraft.world.gen.foliage.FoliagePlacer
import net.minecraft.world.gen.foliage.FoliagePlacerType

object TFFoliagePlacerTypes {

    val CANOPY_FOLIAGE_PLACER_TYPE = registerFoliagePlacerType("canopy_foliage_placer", CanopyFoliagePlacer.CODEC)
    val DARK_FOLIAGE_PLACER_TYPE = registerFoliagePlacerType("dark_foliage_placer", DarkFoliagePlacer.CODEC)

    fun <T : FoliagePlacer> registerFoliagePlacerType(name: String, codec: MapCodec<T>): FoliagePlacerType<T> {
        val id = Identifier.of(TwilightForest.MOD_ID, name)
        val type = FoliagePlacerType(codec)
        return Registry.register(Registries.FOLIAGE_PLACER_TYPE, id, type)
    }

    fun registerFoliagePlacerTypes() {
        TwilightForest.logger?.info("Registering foliage types for " + TwilightForest.MOD_ID)
    }

}