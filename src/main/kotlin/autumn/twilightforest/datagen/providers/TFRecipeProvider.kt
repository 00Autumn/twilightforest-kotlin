package autumn.twilightforest.datagen.providers

import autumn.twilightforest.TwilightForest
import autumn.twilightforest.init.block.TFBlocks
import autumn.twilightforest.init.item.TFItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.block.Blocks
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.data.server.recipe.RecipeGenerator
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder
import net.minecraft.item.ItemConvertible
import net.minecraft.item.Items
import net.minecraft.recipe.book.RecipeCategory
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.RegistryWrapper
import net.minecraft.util.Identifier
import java.util.concurrent.CompletableFuture

class TFRecipeProvider(output: FabricDataOutput, registriesFuture: CompletableFuture<RegistryWrapper.WrapperLookup>) : FabricRecipeProvider(output, registriesFuture) {
    override fun getRecipeGenerator(
        p0: RegistryWrapper.WrapperLookup?,
        p1: RecipeExporter?
    ): RecipeGenerator? {
        return object : RecipeGenerator(p0, p1) {
            override fun generate() {
                // NAGA SET
                createShaped(RecipeCategory.COMBAT, TFItems.NAGA_LEGGINGS, 1)
                    .pattern("NNN")
                    .pattern("N N")
                    .pattern("N N")
                    .input('N', TFItems.NAGA_SCALE)
                    .criterion(hasItem(TFItems.NAGA_SCALE), conditionsFromItem(TFItems.NAGA_SCALE))
                    .offerTo(exporter)
                createShaped(RecipeCategory.COMBAT, TFItems.NAGA_CHESTPLATE, 1)
                    .pattern("N N")
                    .pattern("NNN")
                    .pattern("NNN")
                    .input('N', TFItems.NAGA_SCALE)
                    .criterion(hasItem(TFItems.NAGA_SCALE), conditionsFromItem(TFItems.NAGA_SCALE))
                    .offerTo(exporter)

                // IRONWOOD SET
                val IRONWOOD_SMELTABLES = listOf<ItemConvertible>(TFItems.RAW_IRONWOOD)
                offerSmelting(
                    IRONWOOD_SMELTABLES,
                    RecipeCategory.MISC,
                    TFItems.IRONWOOD_INGOT,
                    0.25f,
                    200,
                    "ironwood"
                )
                offerBlasting(
                    IRONWOOD_SMELTABLES,
                    RecipeCategory.MISC,
                    TFItems.IRONWOOD_INGOT,
                    0.25f,
                    100,
                    "ironwood"
                )
                offerReversibleCompactingRecipes(
                    RecipeCategory.BUILDING_BLOCKS,
                    TFItems.IRONWOOD_INGOT,
                    RecipeCategory.DECORATIONS,
                    TFBlocks.IRONWOOD_BLOCK
                )
                createShapeless(RecipeCategory.MISC, TFItems.RAW_IRONWOOD, 2)
                    .input(TFItems.LIVEROOT)
                    .input(Items.RAW_IRON)
                    .input(Items.GOLD_NUGGET)
                    .criterion(hasItem(TFItems.LIVEROOT), conditionsFromItem(TFItems.LIVEROOT))
                    .offerTo(exporter)
                createShaped(RecipeCategory.COMBAT, TFItems.IRONWOOD_BOOTS, 1)
                    .pattern("   ")
                    .pattern("I I")
                    .pattern("I I")
                    .input('I', TFItems.IRONWOOD_INGOT)
                    .criterion(hasItem(TFItems.IRONWOOD_INGOT), conditionsFromItem(TFItems.IRONWOOD_INGOT))
                    .offerTo(exporter)
                createShaped(RecipeCategory.COMBAT, TFItems.IRONWOOD_LEGGINGS, 1)
                    .pattern("III")
                    .pattern("I I")
                    .pattern("I I")
                    .input('I', TFItems.IRONWOOD_INGOT)
                    .criterion(hasItem(TFItems.IRONWOOD_INGOT), conditionsFromItem(TFItems.IRONWOOD_INGOT))
                    .offerTo(exporter)
                createShaped(RecipeCategory.COMBAT, TFItems.IRONWOOD_CHESTPLATE, 1)
                    .pattern("I I")
                    .pattern("III")
                    .pattern("III")
                    .input('I', TFItems.IRONWOOD_INGOT)
                    .criterion(hasItem(TFItems.IRONWOOD_INGOT), conditionsFromItem(TFItems.IRONWOOD_INGOT))
                    .offerTo(exporter)
                createShaped(RecipeCategory.COMBAT, TFItems.IRONWOOD_HELMET, 1)
                    .pattern("III")
                    .pattern("I I")
                    .pattern("   ")
                    .input('I', TFItems.IRONWOOD_INGOT)
                    .criterion(hasItem(TFItems.IRONWOOD_INGOT), conditionsFromItem(TFItems.IRONWOOD_INGOT))
                    .offerTo(exporter)
                createShaped(RecipeCategory.COMBAT, TFItems.IRONWOOD_SWORD, 1)
                    .pattern(" I ")
                    .pattern(" I ")
                    .pattern(" S ")
                    .input('I', TFItems.IRONWOOD_INGOT)
                    .input('S', Items.STICK)
                    .criterion(hasItem(TFItems.IRONWOOD_INGOT), conditionsFromItem(TFItems.IRONWOOD_INGOT))
                    .offerTo(exporter)
                createShaped(RecipeCategory.TOOLS, TFItems.IRONWOOD_PICKAXE, 1)
                    .pattern("III")
                    .pattern(" S ")
                    .pattern(" S ")
                    .input('I', TFItems.IRONWOOD_INGOT)
                    .input('S', Items.STICK)
                    .criterion(hasItem(TFItems.IRONWOOD_INGOT), conditionsFromItem(TFItems.IRONWOOD_INGOT))
                    .offerTo(exporter)
                createShaped(RecipeCategory.TOOLS, TFItems.IRONWOOD_SHOVEL, 1)
                    .pattern(" I ")
                    .pattern(" S ")
                    .pattern(" S ")
                    .input('I', TFItems.IRONWOOD_INGOT)
                    .input('S', Items.STICK)
                    .criterion(hasItem(TFItems.IRONWOOD_INGOT), conditionsFromItem(TFItems.IRONWOOD_INGOT))
                    .offerTo(exporter)
                createShaped(RecipeCategory.TOOLS, TFItems.IRONWOOD_AXE, 1)
                    .pattern(" II")
                    .pattern(" SI")
                    .pattern(" S ")
                    .input('I', TFItems.IRONWOOD_INGOT)
                    .input('S', Items.STICK)
                    .criterion(hasItem(TFItems.IRONWOOD_INGOT), conditionsFromItem(TFItems.IRONWOOD_INGOT))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,Identifier.of(TwilightForest.MOD_ID, "ironwood_axe")))
                createShaped(RecipeCategory.TOOLS, TFItems.IRONWOOD_AXE, 1)
                    .pattern("II ")
                    .pattern("IS ")
                    .pattern(" S ")
                    .input('I', TFItems.IRONWOOD_INGOT)
                    .input('S', Items.STICK)
                    .criterion(hasItem(TFItems.IRONWOOD_INGOT), conditionsFromItem(TFItems.IRONWOOD_INGOT))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,Identifier.of(TwilightForest.MOD_ID, "ironwood_axe_mirror")))
                createShaped(RecipeCategory.TOOLS, TFItems.IRONWOOD_HOE, 1)
                    .pattern(" II")
                    .pattern(" S ")
                    .pattern(" S ")
                    .input('I', TFItems.IRONWOOD_INGOT)
                    .input('S', Items.STICK)
                    .criterion(hasItem(TFItems.IRONWOOD_INGOT), conditionsFromItem(TFItems.IRONWOOD_INGOT))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,Identifier.of(TwilightForest.MOD_ID, "ironwood_hoe")))
                createShaped(RecipeCategory.TOOLS, TFItems.IRONWOOD_HOE, 1)
                    .pattern("II ")
                    .pattern(" S ")
                    .pattern(" S ")
                    .input('I', TFItems.IRONWOOD_INGOT)
                    .input('S', Items.STICK)
                    .criterion(hasItem(TFItems.IRONWOOD_INGOT), conditionsFromItem(TFItems.IRONWOOD_INGOT))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,Identifier.of(TwilightForest.MOD_ID, "ironwood_hoe_mirror")))

                // STEELEAF SET
                offerReversibleCompactingRecipes(
                    RecipeCategory.BUILDING_BLOCKS,
                    TFItems.STEELEAF_INGOT,
                    RecipeCategory.DECORATIONS,
                    TFBlocks.STEELEAF_BLOCK
                )
                createShaped(RecipeCategory.COMBAT, TFItems.STEELEAF_BOOTS, 1)
                    .pattern("   ")
                    .pattern("S S")
                    .pattern("S S")
                    .input('S', TFItems.STEELEAF_INGOT)
                    .criterion(hasItem(TFItems.STEELEAF_INGOT), conditionsFromItem(TFItems.STEELEAF_INGOT))
                    .offerTo(exporter)
                createShaped(RecipeCategory.COMBAT, TFItems.STEELEAF_LEGGINGS, 1)
                    .pattern("SSS")
                    .pattern("S S")
                    .pattern("S S")
                    .input('S', TFItems.STEELEAF_INGOT)
                    .criterion(hasItem(TFItems.STEELEAF_INGOT), conditionsFromItem(TFItems.STEELEAF_INGOT))
                    .offerTo(exporter)
                createShaped(RecipeCategory.COMBAT, TFItems.STEELEAF_CHESTPLATE, 1)
                    .pattern("S S")
                    .pattern("SSS")
                    .pattern("SSS")
                    .input('S', TFItems.STEELEAF_INGOT)
                    .criterion(hasItem(TFItems.STEELEAF_INGOT), conditionsFromItem(TFItems.STEELEAF_INGOT))
                    .offerTo(exporter)
                createShaped(RecipeCategory.COMBAT, TFItems.STEELEAF_HELMET, 1)
                    .pattern("SSS")
                    .pattern("S S")
                    .pattern("   ")
                    .input('S', TFItems.STEELEAF_INGOT)
                    .criterion(hasItem(TFItems.STEELEAF_INGOT), conditionsFromItem(TFItems.STEELEAF_INGOT))
                    .offerTo(exporter)
                createShaped(RecipeCategory.COMBAT, TFItems.STEELEAF_SWORD, 1)
                    .pattern(" I ")
                    .pattern(" I ")
                    .pattern(" S ")
                    .input('I', TFItems.STEELEAF_INGOT)
                    .input('S', Items.STICK)
                    .criterion(hasItem(TFItems.STEELEAF_INGOT), conditionsFromItem(TFItems.STEELEAF_INGOT))
                    .offerTo(exporter)
                createShaped(RecipeCategory.TOOLS, TFItems.STEELEAF_PICKAXE, 1)
                    .pattern("III")
                    .pattern(" S ")
                    .pattern(" S ")
                    .input('I', TFItems.STEELEAF_INGOT)
                    .input('S', Items.STICK)
                    .criterion(hasItem(TFItems.STEELEAF_INGOT), conditionsFromItem(TFItems.STEELEAF_INGOT))
                    .offerTo(exporter)
                createShaped(RecipeCategory.TOOLS, TFItems.STEELEAF_SHOVEL, 1)
                    .pattern(" I ")
                    .pattern(" S ")
                    .pattern(" S ")
                    .input('I', TFItems.STEELEAF_INGOT)
                    .input('S', Items.STICK)
                    .criterion(hasItem(TFItems.STEELEAF_INGOT), conditionsFromItem(TFItems.STEELEAF_INGOT))
                    .offerTo(exporter)
                createShaped(RecipeCategory.TOOLS, TFItems.STEELEAF_AXE, 1)
                    .pattern(" II")
                    .pattern(" SI")
                    .pattern(" S ")
                    .input('I', TFItems.STEELEAF_INGOT)
                    .input('S', Items.STICK)
                    .criterion(hasItem(TFItems.STEELEAF_INGOT), conditionsFromItem(TFItems.STEELEAF_INGOT))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,Identifier.of(TwilightForest.MOD_ID, "steeleaf_axe")))
                createShaped(RecipeCategory.TOOLS, TFItems.STEELEAF_AXE, 1)
                    .pattern("II ")
                    .pattern("IS ")
                    .pattern(" S ")
                    .input('I', TFItems.STEELEAF_INGOT)
                    .input('S', Items.STICK)
                    .criterion(hasItem(TFItems.STEELEAF_INGOT), conditionsFromItem(TFItems.STEELEAF_INGOT))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,Identifier.of(TwilightForest.MOD_ID, "steeleaf_axe_mirror")))
                createShaped(RecipeCategory.TOOLS, TFItems.STEELEAF_HOE, 1)
                    .pattern(" II")
                    .pattern(" S ")
                    .pattern(" S ")
                    .input('I', TFItems.STEELEAF_INGOT)
                    .input('S', Items.STICK)
                    .criterion(hasItem(TFItems.STEELEAF_INGOT), conditionsFromItem(TFItems.STEELEAF_INGOT))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,Identifier.of(TwilightForest.MOD_ID, "steeleaf_hoe")))
                createShaped(RecipeCategory.TOOLS, TFItems.STEELEAF_HOE, 1)
                    .pattern("II ")
                    .pattern(" S ")
                    .pattern(" S ")
                    .input('I', TFItems.STEELEAF_INGOT)
                    .input('S', Items.STICK)
                    .criterion(hasItem(TFItems.STEELEAF_INGOT), conditionsFromItem(TFItems.STEELEAF_INGOT))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,Identifier.of(TwilightForest.MOD_ID, "steeleaf_hoe_mirror")))

                // KNIGHTMETAL SET
                val KNIGHTMETAL_SMELTABLES = listOf<ItemConvertible>(TFItems.ARMOR_SHARD_CLUSTER)
                offerSmelting(
                    KNIGHTMETAL_SMELTABLES,
                    RecipeCategory.MISC,
                    TFItems.KNIGHTMETAL_INGOT,
                    0.25f,
                    200,
                    "knightmetal"
                )
                offerBlasting(
                    KNIGHTMETAL_SMELTABLES,
                    RecipeCategory.MISC,
                    TFItems.KNIGHTMETAL_INGOT,
                    0.25f,
                    100,
                    "knightmetal"
                )
                offerReversibleCompactingRecipes(
                    RecipeCategory.BUILDING_BLOCKS,
                    TFItems.KNIGHTMETAL_INGOT,
                    RecipeCategory.DECORATIONS,
                    TFBlocks.KNIGHTMETAL_BLOCK
                )
                offerReversibleCompactingRecipes(
                    RecipeCategory.MISC,
                    TFItems.ARMOR_SHARD,
                    RecipeCategory.MISC,
                    TFItems.ARMOR_SHARD_CLUSTER
                )
                createShaped(RecipeCategory.COMBAT, TFItems.KNIGHTMETAL_BOOTS, 1)
                    .pattern("   ")
                    .pattern("K K")
                    .pattern("K K")
                    .input('K', TFItems.KNIGHTMETAL_INGOT)
                    .criterion(hasItem(TFItems.KNIGHTMETAL_INGOT), conditionsFromItem(TFItems.KNIGHTMETAL_INGOT))
                    .offerTo(exporter)
                createShaped(RecipeCategory.COMBAT, TFItems.KNIGHTMETAL_LEGGINGS, 1)
                    .pattern("KKK")
                    .pattern("K K")
                    .pattern("K K")
                    .input('K', TFItems.KNIGHTMETAL_INGOT)
                    .criterion(hasItem(TFItems.KNIGHTMETAL_INGOT), conditionsFromItem(TFItems.KNIGHTMETAL_INGOT))
                    .offerTo(exporter)
                createShaped(RecipeCategory.COMBAT, TFItems.KNIGHTMETAL_CHESTPLATE, 1)
                    .pattern("K K")
                    .pattern("KKK")
                    .pattern("KKK")
                    .input('K', TFItems.KNIGHTMETAL_INGOT)
                    .criterion(hasItem(TFItems.KNIGHTMETAL_INGOT), conditionsFromItem(TFItems.KNIGHTMETAL_INGOT))
                    .offerTo(exporter)
                createShaped(RecipeCategory.COMBAT, TFItems.KNIGHTMETAL_HELMET, 1)
                    .pattern("KKK")
                    .pattern("K K")
                    .pattern("   ")
                    .input('K', TFItems.KNIGHTMETAL_INGOT)
                    .criterion(hasItem(TFItems.KNIGHTMETAL_INGOT), conditionsFromItem(TFItems.KNIGHTMETAL_INGOT))
                    .offerTo(exporter)
                createShaped(RecipeCategory.COMBAT, TFItems.KNIGHTMETAL_SWORD, 1)
                    .pattern(" K ")
                    .pattern(" K ")
                    .pattern(" S ")
                    .input('K', TFItems.KNIGHTMETAL_INGOT)
                    .input('S', Items.STICK)
                    .criterion(hasItem(TFItems.KNIGHTMETAL_INGOT), conditionsFromItem(TFItems.KNIGHTMETAL_INGOT))
                    .offerTo(exporter)
                createShaped(RecipeCategory.TOOLS, TFItems.KNIGHTMETAL_PICKAXE, 1)
                    .pattern("KKK")
                    .pattern(" S ")
                    .pattern(" S ")
                    .input('K', TFItems.KNIGHTMETAL_INGOT)
                    .input('S', Items.STICK)
                    .criterion(hasItem(TFItems.KNIGHTMETAL_INGOT), conditionsFromItem(TFItems.KNIGHTMETAL_INGOT))
                    .offerTo(exporter)
                createShaped(RecipeCategory.TOOLS, TFItems.KNIGHTMETAL_AXE, 1)
                    .pattern(" KK")
                    .pattern(" SK")
                    .pattern(" S ")
                    .input('K', TFItems.KNIGHTMETAL_INGOT)
                    .input('S', Items.STICK)
                    .criterion(hasItem(TFItems.KNIGHTMETAL_INGOT), conditionsFromItem(TFItems.KNIGHTMETAL_INGOT))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,Identifier.of(TwilightForest.MOD_ID, "knightmetal_axe")))
                createShaped(RecipeCategory.TOOLS, TFItems.KNIGHTMETAL_AXE, 1)
                    .pattern("KK ")
                    .pattern("KS ")
                    .pattern(" S ")
                    .input('K', TFItems.KNIGHTMETAL_INGOT)
                    .input('S', Items.STICK)
                    .criterion(hasItem(TFItems.KNIGHTMETAL_INGOT), conditionsFromItem(TFItems.KNIGHTMETAL_INGOT))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,Identifier.of(TwilightForest.MOD_ID, "knightmetal_axe_mirror")))

                // FIERY SET
                offerReversibleCompactingRecipes(
                    RecipeCategory.BUILDING_BLOCKS,
                    TFItems.FIERY_INGOT,
                    RecipeCategory.DECORATIONS,
                    TFBlocks.FIERY_BLOCK
                )
                createShaped(RecipeCategory.COMBAT, TFItems.FIERY_BOOTS, 1)
                    .pattern("   ")
                    .pattern("F F")
                    .pattern("F F")
                    .input('F', TFItems.FIERY_INGOT)
                    .criterion(hasItem(TFItems.FIERY_INGOT), conditionsFromItem(TFItems.FIERY_INGOT))
                    .offerTo(exporter)
                createShaped(RecipeCategory.COMBAT, TFItems.FIERY_LEGGINGS, 1)
                    .pattern("FFF")
                    .pattern("F F")
                    .pattern("F F")
                    .input('F', TFItems.FIERY_INGOT)
                    .criterion(hasItem(TFItems.FIERY_INGOT), conditionsFromItem(TFItems.FIERY_INGOT))
                    .offerTo(exporter)
                createShaped(RecipeCategory.COMBAT, TFItems.FIERY_CHESTPLATE, 1)
                    .pattern("F F")
                    .pattern("FFF")
                    .pattern("FFF")
                    .input('F', TFItems.FIERY_INGOT)
                    .criterion(hasItem(TFItems.FIERY_INGOT), conditionsFromItem(TFItems.FIERY_INGOT))
                    .offerTo(exporter)
                createShaped(RecipeCategory.COMBAT, TFItems.FIERY_HELMET, 1)
                    .pattern("FFF")
                    .pattern("F F")
                    .pattern("   ")
                    .input('F', TFItems.FIERY_INGOT)
                    .criterion(hasItem(TFItems.FIERY_INGOT), conditionsFromItem(TFItems.FIERY_INGOT))
                    .offerTo(exporter)
                createShaped(RecipeCategory.COMBAT, TFItems.FIERY_SWORD, 1)
                    .pattern(" F ")
                    .pattern(" F ")
                    .pattern(" B ")
                    .input('F', TFItems.FIERY_INGOT)
                    .input('B', Items.BLAZE_ROD)
                    .criterion(hasItem(TFItems.FIERY_INGOT), conditionsFromItem(TFItems.FIERY_INGOT))
                    .offerTo(exporter)
                createShaped(RecipeCategory.TOOLS, TFItems.FIERY_PICKAXE, 1)
                    .pattern("FFF")
                    .pattern(" B ")
                    .pattern(" B ")
                    .input('F', TFItems.FIERY_INGOT)
                    .input('B', Items.BLAZE_ROD)
                    .criterion(hasItem(TFItems.FIERY_INGOT), conditionsFromItem(TFItems.FIERY_INGOT))
                    .offerTo(exporter)

                // ARCTIC FUR SET
                offerReversibleCompactingRecipes(
                    RecipeCategory.BUILDING_BLOCKS,
                    TFItems.ARCTIC_FUR,
                    RecipeCategory.DECORATIONS,
                    TFBlocks.ARCTIC_FUR_BLOCK
                )
                createShaped(RecipeCategory.COMBAT, TFItems.ARCTIC_BOOTS, 1)
                    .pattern("   ")
                    .pattern("A A")
                    .pattern("A A")
                    .input('A', TFItems.ARCTIC_FUR)
                    .criterion(hasItem(TFItems.ARCTIC_FUR), conditionsFromItem(TFItems.ARCTIC_FUR))
                    .offerTo(exporter)
                createShaped(RecipeCategory.COMBAT, TFItems.ARCTIC_LEGGINGS, 1)
                    .pattern("AAA")
                    .pattern("A A")
                    .pattern("A A")
                    .input('A', TFItems.ARCTIC_FUR)
                    .criterion(hasItem(TFItems.ARCTIC_FUR), conditionsFromItem(TFItems.ARCTIC_FUR))
                    .offerTo(exporter)
                createShaped(RecipeCategory.COMBAT, TFItems.ARCTIC_CHESTPLATE, 1)
                    .pattern("A A")
                    .pattern("AAA")
                    .pattern("AAA")
                    .input('A', TFItems.ARCTIC_FUR)
                    .criterion(hasItem(TFItems.ARCTIC_FUR), conditionsFromItem(TFItems.ARCTIC_FUR))
                    .offerTo(exporter)
                createShaped(RecipeCategory.COMBAT, TFItems.ARCTIC_HELMET, 1)
                    .pattern("AAA")
                    .pattern("A A")
                    .pattern("   ")
                    .input('A', TFItems.ARCTIC_FUR)
                    .criterion(hasItem(TFItems.ARCTIC_FUR), conditionsFromItem(TFItems.ARCTIC_FUR))
                    .offerTo(exporter)

                // YETI SET
                createShaped(RecipeCategory.COMBAT, TFItems.YETI_BOOTS, 1)
                    .pattern("   ")
                    .pattern("A A")
                    .pattern("A A")
                    .input('A', TFItems.ALPHA_YETI_FUR)
                    .criterion(hasItem(TFItems.ALPHA_YETI_FUR), conditionsFromItem(TFItems.ALPHA_YETI_FUR))
                    .offerTo(exporter)
                createShaped(RecipeCategory.COMBAT, TFItems.YETI_LEGGINGS, 1)
                    .pattern("AAA")
                    .pattern("A A")
                    .pattern("A A")
                    .input('A', TFItems.ALPHA_YETI_FUR)
                    .criterion(hasItem(TFItems.ALPHA_YETI_FUR), conditionsFromItem(TFItems.ALPHA_YETI_FUR))
                    .offerTo(exporter)
                createShaped(RecipeCategory.COMBAT, TFItems.YETI_CHESTPLATE, 1)
                    .pattern("A A")
                    .pattern("AAA")
                    .pattern("AAA")
                    .input('A', TFItems.ALPHA_YETI_FUR)
                    .criterion(hasItem(TFItems.ALPHA_YETI_FUR), conditionsFromItem(TFItems.ALPHA_YETI_FUR))
                    .offerTo(exporter)
                createShaped(RecipeCategory.COMBAT, TFItems.YETI_HELMET, 1)
                    .pattern("AAA")
                    .pattern("A A")
                    .pattern("   ")
                    .input('A', TFItems.ALPHA_YETI_FUR)
                    .criterion(hasItem(TFItems.ALPHA_YETI_FUR), conditionsFromItem(TFItems.ALPHA_YETI_FUR))
                    .offerTo(exporter)

                // MOSSY VARIANTS
                createShapeless(RecipeCategory.BUILDING_BLOCKS, TFBlocks.MOSSY_MAZESTONE, 1)
                    .input(TFBlocks.MAZESTONE_BRICK)
                    .input(Blocks.MOSS_BLOCK)
                    .criterion(hasItem(TFBlocks.MAZESTONE), conditionsFromItem(TFBlocks.MAZESTONE))
                    .offerTo(exporter)
                createShapeless(RecipeCategory.BUILDING_BLOCKS, TFBlocks.MOSSY_UNDERBRICK, 1)
                    .input(TFBlocks.UNDERBRICK)
                    .input(Blocks.MOSS_BLOCK)
                    .criterion(hasItem(TFBlocks.UNDERBRICK), conditionsFromItem(TFBlocks.UNDERBRICK))
                    .offerTo(exporter)
                createShapeless(RecipeCategory.BUILDING_BLOCKS, TFBlocks.MOSSY_TOWERWOOD, 1)
                    .input(TFBlocks.TOWERWOOD)
                    .input(Blocks.MOSS_BLOCK)
                    .criterion(hasItem(TFBlocks.TOWERWOOD), conditionsFromItem(TFBlocks.TOWERWOOD))
                    .offerTo(exporter)

                // CRACKED VARIANTS
                val MAZESTONE_SMELTABLES = listOf<ItemConvertible>(TFBlocks.MAZESTONE_BRICK)
                offerSmelting(
                    MAZESTONE_SMELTABLES,
                    RecipeCategory.BUILDING_BLOCKS,
                    TFBlocks.CRACKED_MAZESTONE,
                    0.25f,
                    200,
                    "mazestone"
                )
                val UNDERBRICK_SMELTABLES = listOf<ItemConvertible>(TFBlocks.UNDERBRICK)
                offerSmelting(
                    UNDERBRICK_SMELTABLES,
                    RecipeCategory.BUILDING_BLOCKS,
                    TFBlocks.CRACKED_UNDERBRICK,
                    0.25f,
                    200,
                    "underbrick"
                )
                val TOWERWOOD_SMELTABLES = listOf<ItemConvertible>(TFBlocks.TOWERWOOD)
                offerSmelting(
                    TOWERWOOD_SMELTABLES,
                    RecipeCategory.BUILDING_BLOCKS,
                    TFBlocks.CRACKED_TOWERWOOD,
                    0.25f,
                    200,
                    "towerwood"
                )

                // CARMINITE
                createShapeless(RecipeCategory.MISC, TFItems.CARMINITE)
                    .input(TFItems.BORER_ESSENCE)
                    .input(Items.REDSTONE)
                    .input(TFItems.BORER_ESSENCE)
                    .input(Items.REDSTONE)
                    .input(Items.GHAST_TEAR)
                    .input(Items.REDSTONE)
                    .input(TFItems.BORER_ESSENCE)
                    .input(Items.REDSTONE)
                    .input(TFItems.BORER_ESSENCE)
                    .criterion(hasItem(TFItems.BORER_ESSENCE), conditionsFromItem(TFItems.BORER_ESSENCE))
                    .offerTo(exporter)

                // CHARMS
                createShapeless(RecipeCategory.MISC, TFItems.CHARM_OF_LIFE_II)
                    .input(TFItems.CHARM_OF_LIFE_I)
                    .input(TFItems.CHARM_OF_LIFE_I)
                    .criterion(hasItem(TFItems.CHARM_OF_LIFE_I), conditionsFromItem(TFItems.CHARM_OF_LIFE_I))
                    .offerTo(exporter)
                createShapeless(RecipeCategory.MISC, TFItems.CHARM_OF_KEEPING_II)
                    .input(TFItems.CHARM_OF_KEEPING_I)
                    .input(TFItems.CHARM_OF_KEEPING_I)
                    .criterion(hasItem(TFItems.CHARM_OF_KEEPING_I), conditionsFromItem(TFItems.CHARM_OF_KEEPING_I))
                    .offerTo(exporter)
                createShapeless(RecipeCategory.MISC, TFItems.CHARM_OF_KEEPING_III)
                    .input(TFItems.CHARM_OF_KEEPING_I)
                    .input(TFItems.CHARM_OF_KEEPING_I)
                    .input(TFItems.CHARM_OF_KEEPING_I)
                    .criterion(hasItem(TFItems.CHARM_OF_KEEPING_I), conditionsFromItem(TFItems.CHARM_OF_KEEPING_I))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,Identifier.of(TwilightForest.MOD_ID, "charm_of_keeping_iii")))
                createShapeless(RecipeCategory.MISC, TFItems.CHARM_OF_KEEPING_III)
                    .input(TFItems.CHARM_OF_KEEPING_II)
                    .input(TFItems.CHARM_OF_KEEPING_I)
                    .criterion(hasItem(TFItems.CHARM_OF_KEEPING_II), conditionsFromItem(TFItems.CHARM_OF_KEEPING_II))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,Identifier.of(TwilightForest.MOD_ID, "charm_of_keeping_iii_alt")))

                // RABBIT POCKET WATCH
                createShaped(RecipeCategory.TOOLS, TFItems.POCKET_WATCH, 1)
                    .pattern(" GC")
                    .pattern("GRG")
                    .pattern(" G ")
                    .input('G', Items.GOLD_INGOT)
                    .input('R', Items.RABBIT_FOOT)
                    .input('C', Items.CHAIN)
                    .criterion(hasItem(Items.RABBIT_FOOT), conditionsFromItem(Items.RABBIT_FOOT))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(TwilightForest.MOD_ID, "pocket_watch")))
                createShaped(RecipeCategory.TOOLS, TFItems.POCKET_WATCH, 1)
                    .pattern("CG ")
                    .pattern("GRG")
                    .pattern(" G ")
                    .input('G', Items.GOLD_INGOT)
                    .input('R', Items.RABBIT_FOOT)
                    .input('C', Items.CHAIN)
                    .criterion(hasItem(Items.RABBIT_FOOT), conditionsFromItem(Items.RABBIT_FOOT))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,Identifier.of(TwilightForest.MOD_ID, "pocket_watch_mirror")))
            }

        }
    }
    override fun getName(): String? {
        return "TFRecipes"
    }
}