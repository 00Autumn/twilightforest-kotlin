package autumn.twilightforest.datacomponent

import autumn.twilightforest.TwilightForest
import net.minecraft.component.ComponentType
import net.minecraft.component.type.NbtComponent
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

object TFDataComponentTypes {
    val SOULBOUND: ComponentType<NbtComponent> = registerDataComponentType("soulbound") {
        it.codec(NbtComponent.CODEC)
    }

    private fun <T> registerDataComponentType(
        name: String,
        builderOperator: (ComponentType.Builder<T>) -> ComponentType.Builder<T>
    ): ComponentType<T> {
        return Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(TwilightForest.MOD_ID, name),
            builderOperator(ComponentType.builder()).build()
        )
    }

    fun registerDataComponentTypes() {
        TwilightForest.logger.info("Registering data component types for" + TwilightForest.MOD_ID)
    }
}