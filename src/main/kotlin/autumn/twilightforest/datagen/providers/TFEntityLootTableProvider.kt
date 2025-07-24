package autumn.twilightforest.datagen.providers

import autumn.twilightforest.init.entity.TFEntities
import autumn.twilightforest.init.item.TFItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricEntityLootTableProvider
import net.minecraft.data.loottable.LootTableData
import net.minecraft.item.Items
import net.minecraft.loot.LootPool
import net.minecraft.loot.LootTable
import net.minecraft.loot.LootTables
import net.minecraft.loot.condition.RandomChanceWithEnchantedBonusLootCondition
import net.minecraft.loot.entry.ItemEntry
import net.minecraft.loot.function.EnchantedCountIncreaseLootFunction
import net.minecraft.loot.function.FurnaceSmeltLootFunction
import net.minecraft.loot.function.SetCountLootFunction
import net.minecraft.loot.provider.number.ConstantLootNumberProvider
import net.minecraft.loot.provider.number.UniformLootNumberProvider
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryWrapper
import java.util.concurrent.CompletableFuture

class TFEntityLootTableProvider(output: FabricDataOutput, registryLookup: CompletableFuture<RegistryWrapper.WrapperLookup>) : FabricEntityLootTableProvider(output, registryLookup) {
    override fun generate() {

        register(TFEntities.DWARF_RABBIT, LootTable.Builder().pool(
            LootPool.Builder()
                .rolls(ConstantLootNumberProvider.create(1.0F))
                .with(
                    ItemEntry.builder(Items.RABBIT_FOOT)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0F, 1.0F)))
                )
        ))

        register(TFEntities.TINY_BIRD, LootTable.Builder().pool(
            LootPool.Builder()
                .rolls(ConstantLootNumberProvider.create(1.0F))
                .with(
                    ItemEntry.builder(Items.FEATHER)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0F, 1.0F)))
                )
        ))

        register(
            TFEntities.WILD_DEER,
            LootTable.builder()
                .pool(
                    LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(
                            ItemEntry.builder(Items.LEATHER)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0F, 2.0F)))
                                .apply(EnchantedCountIncreaseLootFunction.builder(registries, UniformLootNumberProvider.create(0.0F, 1.0F)))
                        )
                )
                .pool(
                    LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(
                            ItemEntry.builder(TFItems.RAW_VENISON)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 3.0F)))
                                .apply(FurnaceSmeltLootFunction.builder().conditionally(createSmeltLootCondition()))
                                .apply(EnchantedCountIncreaseLootFunction.builder(registries, UniformLootNumberProvider.create(0.0F, 1.0F)))
                        )
                )
        )

        register(TFEntities.SQUIRREL, LootTable.Builder().pool(
            LootPool.Builder()
                .rolls(ConstantLootNumberProvider.create(1.0F))
                .with(
                    ItemEntry.builder(Items.WHEAT_SEEDS)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0F, 1.0F)))
                )
        ))

        register(TFEntities.MAZE_SLIME, LootTable.Builder().pool(
            LootPool.Builder()
                .rolls(ConstantLootNumberProvider.create(1.0F))
                .with(
                    ItemEntry.builder(Items.SLIME_BALL)
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F)))
                        .apply(EnchantedCountIncreaseLootFunction.builder(registries, UniformLootNumberProvider.create(0.0F, 1.0F)))
                )
        )
            .pool(
                LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1.0F))
                    .bonusRolls(ConstantLootNumberProvider.create(0.0F))
                    .conditionally(
                        RandomChanceWithEnchantedBonusLootCondition
                            .builder(registries, 0.02F, 0.005F)
                    )
                    .with(
                        ItemEntry.builder(TFItems.CHARM_OF_KEEPING_I)
                    )
            )
        )

        register(TFEntities.CARMINITE_BROODLING, LootTable.Builder().pool(
            LootPool.Builder()
                .rolls(ConstantLootNumberProvider.create(1.0F))
                .with(
                    ItemEntry.builder(Items.STRING)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0F, 2.0F)))
                )
        )
            .pool(LootPool.Builder()
                .rolls(ConstantLootNumberProvider.create(1.0F))
                .with(
                    ItemEntry.builder(Items.SPIDER_EYE)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0F, 1.0F)))
                )
            )
        )

        register(TFEntities.KING_SPIDER, LootTable.Builder().pool(
            LootPool.Builder()
                .rolls(ConstantLootNumberProvider.create(1.0F))
                .with(
                    ItemEntry.builder(Items.STRING)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0F, 4.0F)))
                )
        )
            .pool(LootPool.Builder()
                .rolls(ConstantLootNumberProvider.create(1.0F))
                .with(
                    ItemEntry.builder(Items.SPIDER_EYE)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0F, 2.0F)))
                )
            )
        )

        register(TFEntities.SKELETON_DRUID, LootTable.Builder().pool(
            LootPool.Builder()
                .rolls(ConstantLootNumberProvider.create(1.0F))
                .with(
                    ItemEntry.builder(Items.BONE)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0F, 2.0F)))
                )
        )
            .pool(LootPool.Builder()
                .rolls(ConstantLootNumberProvider.create(1.0F))
                .with(
                    ItemEntry.builder(TFItems.TORCHBERRIES)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0F, 2.0F)))
                )
            )
            .pool(LootPool.Builder()
                .rolls(ConstantLootNumberProvider.create(0.5F))
                .with(
                    ItemEntry.builder(Items.GOLDEN_HOE)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0F, 1.0F)))
                )
            )
        )

        register(TFEntities.HEDGE_SPIDER, LootTable.Builder().pool(
            LootPool.Builder()
                .rolls(ConstantLootNumberProvider.create(1.0F))
                .with(
                    ItemEntry.builder(Items.STRING)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0F, 2.0F)))
                )
        )
            .pool(LootPool.Builder()
                .rolls(ConstantLootNumberProvider.create(1.0F))
                .with(
                    ItemEntry.builder(Items.SPIDER_EYE)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0F, 1.0F)))
                )
            )
        )

        register(TFEntities.SWARM_SPIDER, LootTable.Builder().pool(
            LootPool.Builder()
                .rolls(ConstantLootNumberProvider.create(0.5F))
                .with(
                    ItemEntry.builder(Items.STRING)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0F, 1.0F)))
                )
        )
            .pool(LootPool.Builder()
                .rolls(ConstantLootNumberProvider.create(0.5F))
                .with(
                    ItemEntry.builder(Items.SPIDER_EYE)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0F, 1.0F)))
                )
            )
        )

        register(TFEntities.MIST_WOLF, LootTable.Builder().pool(
            LootPool.Builder()
                .rolls(ConstantLootNumberProvider.create(1.0F))
                .with(
                    ItemEntry.builder(Items.BONE)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0F, 2.0F)))
                )
        ))

        register(TFEntities.WINTER_WOLF, LootTable.Builder().pool(
            LootPool.Builder()
                .rolls(ConstantLootNumberProvider.create(1.0F))
                .with(
                    ItemEntry.builder(TFItems.ARCTIC_FUR)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0F, 2.0F)))
                )
        ))

        register(TFEntities.CARMINITE_GHAST_GUARD, LootTable.Builder().pool(
            LootPool.Builder()
                .rolls(ConstantLootNumberProvider.create(1.0F))
                .with(
                    ItemEntry.builder(Items.GHAST_TEAR)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0F, 1.0F)))
                )
        )
            .pool(LootPool.Builder()
                .rolls(ConstantLootNumberProvider.create(0.5F))
                .with(
                    ItemEntry.builder(TFItems.CARMINITE)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0F, 2.0F)))
                )
            )
        )

        register(TFEntities.CARMINITE_GHASTLING, LootTable.Builder().pool(
            LootPool.Builder()
                .rolls(ConstantLootNumberProvider.create(1.0F))
                .with(
                    ItemEntry.builder(Items.GHAST_TEAR)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0F, 1.0F)))
                )
        ))

        register(TFEntities.KNIGHT_PHANTOM, LootTable.Builder().pool(
            LootPool.Builder()
                .rolls(ConstantLootNumberProvider.create(0.5F))
                .with(
                    ItemEntry.builder(TFItems.KNIGHTMETAL_SWORD)
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F))
                )
        )
        )
            .pool(LootPool.Builder()
                .rolls(ConstantLootNumberProvider.create(0.5F))
                .with(
                    ItemEntry.builder(TFItems.PHANTOM_HELMET)
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F)))
                )
            )
            .pool(LootPool.Builder()
                .rolls(ConstantLootNumberProvider.create(0.5F))
                .with(
                    ItemEntry.builder(TFItems.PHANTOM_CHESTPLATE)
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F)))
                )
            )
        )

        register(TFEntities.BIGHORN_SHEEP, LootTable.builder().pool(
                    LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(
                            ItemEntry.builder(Items.MUTTON)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F)))
                                .apply(FurnaceSmeltLootFunction.builder().conditionally(createSmeltLootCondition()))
                                .apply(EnchantedCountIncreaseLootFunction.builder(registries, UniformLootNumberProvider.create(0.0F, 1.0F)))
                        )
                )
                .pool(createForSheep(LootTables.SHEEP_DROPS_FROM_DYE_COLOR))
        )
        LootTableData.WOOL_FROM_DYE_COLOR.forEach { (color, wool) ->
            register(
                TFEntities.BIGHORN_SHEEP,
                LootTables.SHEEP_DROPS_FROM_DYE_COLOR[color] as RegistryKey<LootTable>,
                LootTable.builder().pool(
                    LootPool.builder().with(
                        ItemEntry.builder(wool)
                    )
                )
            )
        }

        register(TFEntities.WILD_BOAR, LootTable.Builder().pool(
            LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1.0F))
                .with(
                    ItemEntry.builder(Items.PORKCHOP)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 3.0F)))
                        .apply(FurnaceSmeltLootFunction.builder().conditionally(this.createSmeltLootCondition()))
                        .apply(EnchantedCountIncreaseLootFunction.builder(this.registries, UniformLootNumberProvider.create(0.0F, 1.0F)))
                )
        ))
    }
}