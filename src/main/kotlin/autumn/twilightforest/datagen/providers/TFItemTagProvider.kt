package autumn.twilightforest.datagen.providers

import autumn.twilightforest.init.block.TFBlocks
import autumn.twilightforest.init.item.TFItems
import autumn.twilightforest.util.TFItemTags
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.registry.RegistryWrapper
import net.minecraft.registry.tag.ItemTags
import java.util.concurrent.CompletableFuture

class TFItemTagProvider(output: FabricDataOutput, registriesFuture: CompletableFuture<RegistryWrapper.WrapperLookup>) : FabricTagProvider.ItemTagProvider(output, registriesFuture) {
    override fun configure(wrapperLookup: RegistryWrapper.WrapperLookup) {
        valueLookupBuilder(ItemTags.WOLF_FOOD)
            .add(TFItems.RAW_VENISON)
            .add(TFItems.COOKED_VENISON)
            .add(TFItems.RAW_MEEF)
            .add(TFItems.COOKED_MEEF)
            .add(TFItems.HYDRA_CHOP)
        valueLookupBuilder(ItemTags.MEAT)
            .add(TFItems.RAW_VENISON)
            .add(TFItems.COOKED_VENISON)
            .add(TFItems.RAW_MEEF)
            .add(TFItems.COOKED_MEEF)
            .add(TFItems.HYDRA_CHOP)

        valueLookupBuilder(TFItemTags.IS_FIERY_VIAL)
            .add(TFItems.FIERY_BLOOD)
            .add(TFItems.FIERY_TEARS)
        valueLookupBuilder(TFItemTags.NAGA_SCALES)
            .add(TFItems.NAGA_SCALE)
        valueLookupBuilder(TFItemTags.IRONWOOD_INGOTS)
            .add(TFItems.IRONWOOD_INGOT)
        valueLookupBuilder(TFItemTags.STEELEAF_INGOTS)
            .add(TFItems.STEELEAF_INGOT)
        valueLookupBuilder(TFItemTags.KNIGHTMETAL_INGOTS)
            .add(TFItems.KNIGHTMETAL_INGOT)
        valueLookupBuilder(TFItemTags.FIERY_INGOTS)
            .add(TFItems.FIERY_INGOT)
        valueLookupBuilder(TFItemTags.ARCTIC_FURS)
            .add(TFItems.ARCTIC_FUR)
        valueLookupBuilder(TFItemTags.ALPHA_YETI_FURS)
            .add(TFItems.ALPHA_YETI_FUR)
        valueLookupBuilder(TFItemTags.REPAIRS_IRONWOOD_TOOLS)
            .addTag(TFItemTags.IRONWOOD_INGOTS)
        valueLookupBuilder(TFItemTags.REPAIRS_STEELEAF_TOOLS)
            .addTag(TFItemTags.STEELEAF_INGOTS)
        valueLookupBuilder(TFItemTags.REPAIRS_KNIGHTMETAL_TOOLS)
            .addTag(TFItemTags.KNIGHTMETAL_INGOTS)
        valueLookupBuilder(TFItemTags.REPAIRS_FIERY_TOOLS)
            .addTag(TFItemTags.FIERY_INGOTS)
        valueLookupBuilder(TFItemTags.REPAIRS_NAGA_SCALE_ARMOR)
            .addTag(TFItemTags.NAGA_SCALES)
        valueLookupBuilder(TFItemTags.REPAIRS_IRONWOOD_ARMOR)
            .addTag(TFItemTags.IRONWOOD_INGOTS)
        valueLookupBuilder(TFItemTags.REPAIRS_STEELEAF_ARMOR)
            .addTag(TFItemTags.STEELEAF_INGOTS)
        valueLookupBuilder(TFItemTags.REPAIRS_KNIGHTMETAL_ARMOR)
            .addTag(TFItemTags.KNIGHTMETAL_INGOTS)
        valueLookupBuilder(TFItemTags.REPAIRS_PHANTOM_ARMOR)
            .addTag(TFItemTags.KNIGHTMETAL_INGOTS)
        valueLookupBuilder(TFItemTags.REPAIRS_FIERY_ARMOR)
            .addTag(TFItemTags.FIERY_INGOTS)
        valueLookupBuilder(TFItemTags.REPAIRS_ARCTIC_ARMOR)
            .addTag(TFItemTags.ARCTIC_FURS)
        valueLookupBuilder(TFItemTags.REPAIRS_YETI_ARMOR)
            .addTag(TFItemTags.ALPHA_YETI_FURS)

        valueLookupBuilder(ItemTags.SWORDS)
            .add(TFItems.IRONWOOD_SWORD)
            .add(TFItems.STEELEAF_SWORD)
            .add(TFItems.KNIGHTMETAL_SWORD)
            .add(TFItems.FIERY_SWORD)
        valueLookupBuilder(ItemTags.PICKAXES)
            .add(TFItems.IRONWOOD_PICKAXE)
            .add(TFItems.STEELEAF_PICKAXE)
            .add(TFItems.KNIGHTMETAL_PICKAXE)
            .add(TFItems.FIERY_PICKAXE)
            .add(TFItems.MAZEBREAKER_PICKAXE)
        valueLookupBuilder(ItemTags.SHOVELS)
            .add(TFItems.IRONWOOD_SHOVEL)
            .add(TFItems.STEELEAF_SHOVEL)
        valueLookupBuilder(ItemTags.AXES)
            .add(TFItems.IRONWOOD_AXE)
            .add(TFItems.STEELEAF_AXE)
            .add(TFItems.KNIGHTMETAL_AXE)
            .add(TFItems.GOLD_MINOTAUR_AXE)
            .add(TFItems.DIAMOND_MINOTAUR_AXE)
        valueLookupBuilder(ItemTags.HOES)
            .add(TFItems.IRONWOOD_HOE)
            .add(TFItems.STEELEAF_HOE)

        valueLookupBuilder(ItemTags.FREEZE_IMMUNE_WEARABLES)
            .add(TFItems.FIERY_BOOTS)
            .add(TFItems.FIERY_LEGGINGS)
            .add(TFItems.FIERY_CHESTPLATE)
            .add(TFItems.FIERY_HELMET)
            .add(TFItems.YETI_BOOTS)
            .add(TFItems.YETI_LEGGINGS)
            .add(TFItems.YETI_CHESTPLATE)
            .add(TFItems.YETI_HELMET)

        valueLookupBuilder(ItemTags.PIGLIN_LOVED)
            .add(TFItems.GOLD_MINOTAUR_AXE)

        valueLookupBuilder(TFItemTags.MAZEBREAKER_ITEM)
            .add(TFItems.MAZEBREAKER_PICKAXE)

        valueLookupBuilder(TFItemTags.KEPT_ON_DEATH)
            .add(TFItems.PHANTOM_CHESTPLATE)
            .add(TFItems.PHANTOM_HELMET)

        valueLookupBuilder(TFItemTags.TWILIGHT_FOREST_LOGS).add(
            TFBlocks.TWILIGHT_OAK_LOG.asItem(),
            TFBlocks.STRIPPED_TWILIGHT_OAK_LOG.asItem(),
        )
        valueLookupBuilder(ItemTags.LOGS_THAT_BURN)
            .addTag(TFItemTags.TWILIGHT_FOREST_LOGS)
        valueLookupBuilder(ItemTags.LEAVES).add(
            TFBlocks.TWILIGHT_OAK_LEAVES.asItem()
        )
        valueLookupBuilder(ItemTags.SAPLINGS).add(
            TFBlocks.TWILIGHT_OAK_SAPLING.asItem()
        )
        valueLookupBuilder(ItemTags.PLANKS).add(
            TFBlocks.TWILIGHT_OAK_PLANKS.asItem()
        )
        valueLookupBuilder(ItemTags.WOODEN_DOORS).add(
            TFBlocks.TWILIGHT_OAK_DOOR.asItem()
        )
        valueLookupBuilder(ItemTags.WOODEN_TRAPDOORS).add(
            TFBlocks.TWILIGHT_OAK_TRAPDOOR.asItem()
        )
        valueLookupBuilder(ItemTags.WOODEN_FENCES).add(
            TFBlocks.TWILIGHT_OAK_FENCE.asItem()
        )
        valueLookupBuilder(ItemTags.FENCE_GATES).add(
            TFBlocks.TWILIGHT_OAK_FENCE_GATE.asItem()
        )
        valueLookupBuilder(ItemTags.WOODEN_STAIRS).add(
            TFBlocks.TWILIGHT_OAK_STAIRS.asItem()
        )
        valueLookupBuilder(ItemTags.WOODEN_SLABS).add(
            TFBlocks.TWILIGHT_OAK_SLAB.asItem()
        )
        valueLookupBuilder(ItemTags.WOODEN_PRESSURE_PLATES).add(
            TFBlocks.TWILIGHT_OAK_PRESSURE_PLATE.asItem()
        )
        valueLookupBuilder(ItemTags.WOODEN_BUTTONS).add(
            TFBlocks.TWILIGHT_OAK_BUTTON.asItem()
        )
    }

}