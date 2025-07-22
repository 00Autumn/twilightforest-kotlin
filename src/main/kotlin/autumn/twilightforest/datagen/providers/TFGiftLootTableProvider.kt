package autumn.twilightforest.datagen.providers

import autumn.twilightforest.init.item.TFItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider
import net.minecraft.item.Items
import net.minecraft.loot.LootPool
import net.minecraft.loot.LootTable
import net.minecraft.loot.entry.ItemEntry
import net.minecraft.loot.provider.number.ConstantLootNumberProvider
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.RegistryWrapper
import net.minecraft.util.Identifier
import net.minecraft.util.context.ContextType
import java.util.concurrent.CompletableFuture
import java.util.function.BiConsumer

class TFGiftLootTableProvider(output: FabricDataOutput, registryLookup: CompletableFuture<RegistryWrapper.WrapperLookup>, contextType: ContextType) : SimpleFabricLootTableProvider(output, registryLookup, contextType) {
    override fun accept(lootTableBiConsumer: BiConsumer<RegistryKey<LootTable?>?, LootTable.Builder?>?) {
        val id = Identifier.of("twilightforest", "gameplay/tiny_bird_lay")
        val key = RegistryKey.of(RegistryKeys.LOOT_TABLE, id)

        val table = LootTable.builder()
            .pool(
                LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1.0f))
                    .with(ItemEntry.builder(TFItems.TINY_EGG))
            )

        lootTableBiConsumer?.accept(key, table)
    }
}