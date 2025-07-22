package autumn.twilightforest.util

import autumn.twilightforest.TwilightForest
import net.minecraft.loot.LootTable
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier


object TFLootTables {
    private val LOOT_TABLES: MutableSet<RegistryKey<LootTable>> = mutableSetOf()
    val TINY_BIRD_LAY_GAMEPLAY: RegistryKey<LootTable> = register("gameplay/tiny_bird_lay")

    fun register(name: String): RegistryKey<LootTable> {
        val identifier = Identifier.of(TwilightForest.MOD_ID, name)
        val key = RegistryKey.of(RegistryKeys.LOOT_TABLE, identifier)
        if (!LOOT_TABLES.add(key)) {
            throw IllegalArgumentException("${key.value} is already a registered built-in loot table")
        }
        return key
    }

    fun registerLootTables() {
        TwilightForest.logger?.info("Registering loot tables for " + TwilightForest.MOD_ID)
    }
}