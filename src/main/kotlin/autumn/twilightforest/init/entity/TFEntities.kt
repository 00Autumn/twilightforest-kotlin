package autumn.twilightforest.init.entity

import autumn.twilightforest.TwilightForest
import autumn.twilightforest.init.entity.custom.DwarfRabbitEntity
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnGroup
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier

object TFEntities {

    val DWARF_RABBIT_KEY = RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(TwilightForest.MOD_ID, "dwarf_rabbit"))
    val DWARF_RABBIT = Registry.register(Registries.ENTITY_TYPE,
        Identifier.of(TwilightForest.MOD_ID, "dwarf_rabbit"),
        EntityType.Builder.create(::DwarfRabbitEntity, SpawnGroup.CREATURE)
            .dimensions(0.5F, 0.5F).build(DWARF_RABBIT_KEY))

    fun registerEntities() {
        TwilightForest.logger?.info("Registering entities for " + TwilightForest.MOD_ID)
    }
}