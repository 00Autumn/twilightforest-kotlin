package autumn.twilightforest.datagen.providers

import autumn.twilightforest.TwilightForest
import autumn.twilightforest.init.block.TFBlocks
import autumn.twilightforest.init.item.TFItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider
import net.minecraft.registry.RegistryWrapper
import net.minecraft.text.Text
import net.minecraft.text.TranslatableTextContent
import java.util.concurrent.CompletableFuture

class TFEnglishLanguageProvider(output: FabricDataOutput, registryLookup: CompletableFuture<RegistryWrapper.WrapperLookup>) : FabricLanguageProvider(output, registryLookup) {

    private fun addText(builder: TranslationBuilder?, text: Text, value: String) {
        val content = text.content
        if (content is TranslatableTextContent) {
            builder?.add(content.key, value)
        } else {
            TwilightForest.logger?.warn("Failed to add translation for text: {}", text.string)
        }
    }

    override fun generateTranslations(p0: RegistryWrapper.WrapperLookup?, entries: TranslationBuilder?) {
        entries?.add(TFItems.NAGA_SCALE, "Naga Scale")
        entries?.add(TFItems.LIVEROOT, "Liveroot")
        entries?.add(TFItems.RAW_IRONWOOD, "Raw Ironwood")
        entries?.add(TFItems.IRONWOOD_INGOT, "Ironwood Ingot")
        entries?.add(TFItems.STEELEAF_INGOT, "Steeleaf Ingot")
        entries?.add(TFItems.ARMOR_SHARD, "Armor Shard")
        entries?.add(TFItems.ARMOR_SHARD_CLUSTER, "Armor Shard Cluster")
        entries?.add(TFItems.KNIGHTMETAL_INGOT, "Knightmetal Ingot")
        entries?.add(TFItems.FIERY_BLOOD, "Fiery Blood")
        entries?.add(TFItems.FIERY_TEARS, "Fiery Tears")
        entries?.add(TFItems.FIERY_INGOT, "Fiery Ingot")
        entries?.add(TFItems.ARCTIC_FUR, "Arctic Fur")
        entries?.add(TFItems.ALPHA_YETI_FUR, "Alpha Yeti Fur")

        entries?.add(TFItems.RAVEN_FEATHER, "Raven Feather")
        entries?.add(TFItems.MAGIC_MAP_FOCUS, "Magic Map Focus")
        entries?.add(TFItems.MAZE_MAP_FOCUS, "Maze Map Focus")
        entries?.add(TFItems.CHARM_OF_LIFE_I, "Charm of Life I")
        entries?.add(TFItems.CHARM_OF_LIFE_II, "Charm of Life II")
        entries?.add(TFItems.CHARM_OF_KEEPING_I, "Charm of Keeping I")
        entries?.add(TFItems.CHARM_OF_KEEPING_II, "Charm of Keeping II")
        entries?.add(TFItems.CHARM_OF_KEEPING_III, "Charm of Keeping II")
        entries?.add(TFItems.BORER_ESSENCE, "Borer Essence")
        entries?.add(TFItems.CARMINITE, "Carminite")
        entries?.add(TFItems.EMPERORS_CLOTH, "Emperor's Cloth")
        entries?.add(TFItems.CROWN_SPLINTER, "Crown Splinter")

        entries?.add(TFItems.TOWER_KEY, "Tower Key")

        entries?.add(TFItems.RAW_VENISON, "Raw Venison")
        entries?.add(TFItems.COOKED_VENISON, "Venison Steak")
        entries?.add(TFItems.RAW_MEEF, "Raw Meef")
        entries?.add(TFItems.COOKED_MEEF, "Meef Steak")
        entries?.add(TFItems.MEEF_STROGANOFF, "Meef Stroganoff")
        entries?.add(TFItems.HYDRA_CHOP, "Hydra Chop")
        entries?.add(TFItems.TORCHBERRIES, "Torchberries")
        entries?.add(TFItems.EXPERIMENT_115, "Experiment 115")
        entries?.add(TFItems.MAZE_WAFER, "Maze Wafer")

        entries?.add(TFItems.POCKET_WATCH, "Rabbit's Pocket Watch")

        entries?.add(TFItems.NAGA_LEGGINGS, "Naga Leggings")
        entries?.add(TFItems.NAGA_CHESTPLATE, "Naga Chestplate")

        entries?.add(TFItems.IRONWOOD_BOOTS, "Ironwood Boots")
        entries?.add(TFItems.IRONWOOD_LEGGINGS, "Ironwood Leggings")
        entries?.add(TFItems.IRONWOOD_CHESTPLATE, "Ironwood Chestplate")
        entries?.add(TFItems.IRONWOOD_HELMET, "Ironwood Helmet")
        entries?.add(TFItems.IRONWOOD_SWORD, "Ironwood Sword")
        entries?.add(TFItems.IRONWOOD_PICKAXE ,"Ironwood Pickaxe")
        entries?.add(TFItems.IRONWOOD_SHOVEL, "Ironwood Shovel")
        entries?.add(TFItems.IRONWOOD_AXE, "Ironwood Axe")
        entries?.add(TFItems.IRONWOOD_HOE, "Ironwood Hoe")

        entries?.add(TFItems.STEELEAF_BOOTS, "Steeleaf Boots")
        entries?.add(TFItems.STEELEAF_LEGGINGS, "Steeleaf Leggings")
        entries?.add(TFItems.STEELEAF_CHESTPLATE, "Steeleaf Chestplate")
        entries?.add(TFItems.STEELEAF_HELMET, "Steeleaf Helmet")
        entries?.add(TFItems.STEELEAF_SWORD, "Steeleaf Sword")
        entries?.add(TFItems.STEELEAF_PICKAXE, "Steeleaf Pickaxe")
        entries?.add(TFItems.STEELEAF_SHOVEL, "Steeleaf Shovel")
        entries?.add(TFItems.STEELEAF_AXE, "Steeleaf Axe")
        entries?.add(TFItems.STEELEAF_HOE, "Steeleaf Hoe")

        entries?.add(TFItems.GOLD_MINOTAUR_AXE, "Gold Minotaur Axe")
        entries?.add(TFItems.DIAMOND_MINOTAUR_AXE, "Diamond Minotaur Axe")
        entries?.add(TFItems.MAZEBREAKER_PICKAXE, "Mazebreaker")

        entries?.add(TFItems.KNIGHTMETAL_BOOTS, "Knightmetal Boots")
        entries?.add(TFItems.KNIGHTMETAL_LEGGINGS, "Knightmetal Leggings")
        entries?.add(TFItems.KNIGHTMETAL_CHESTPLATE, "Knightmetal Chestplate")
        entries?.add(TFItems.KNIGHTMETAL_HELMET, "Knightmetal Helmet")
        entries?.add(TFItems.KNIGHTMETAL_SWORD, "Knightmetal Sword")
        entries?.add(TFItems.KNIGHTMETAL_PICKAXE, "Knightmetal Pickaxe")
        entries?.add(TFItems.KNIGHTMETAL_AXE, "Knightmetal Axe")
        entries?.add(TFItems.PHANTOM_CHESTPLATE, "Phantom Chestplate")
        entries?.add(TFItems.PHANTOM_HELMET, "Phantom Helmet")

        entries?.add(TFItems.FIERY_BOOTS, "Fiery Boots")
        entries?.add(TFItems.FIERY_LEGGINGS, "Fiery Leggings")
        entries?.add(TFItems.FIERY_CHESTPLATE, "Fiery Chestplate")
        entries?.add(TFItems.FIERY_HELMET, "Fiery Helmet")
        entries?.add(TFItems.FIERY_SWORD, "Fiery Sword")
        entries?.add(TFItems.FIERY_PICKAXE, "Fiery Pickaxe")

        entries?.add(TFItems.ARCTIC_BOOTS, "Arctic Boots")
        entries?.add(TFItems.ARCTIC_LEGGINGS, "Arctic Boots")
        entries?.add(TFItems.ARCTIC_CHESTPLATE, "Arctic Boots")
        entries?.add(TFItems.ARCTIC_HELMET, "Arctic Helmet")

        entries?.add(TFItems.YETI_BOOTS, "Yeti Boots")
        entries?.add(TFItems.YETI_LEGGINGS, "Yeti Leggings")
        entries?.add(TFItems.YETI_CHESTPLATE, "Yeti Chestplate")
        entries?.add(TFItems.YETI_HELMET ,"Yeti Helmet")

        entries?.add(TFBlocks.ROOT_BLOCK.asItem(), "Root Block")
        entries?.add(TFBlocks.LIVEROOT_BLOCK.asItem(), "Liveroot Block")

        entries?.add(TFBlocks.IRONWOOD_BLOCK.asItem(), "Block of Ironwood")
        entries?.add(TFBlocks.STEELEAF_BLOCK.asItem(), "Block of Steeleaf")
        entries?.add(TFBlocks.KNIGHTMETAL_BLOCK.asItem(), "Block of Knightmetal")
        entries?.add(TFBlocks.FIERY_BLOCK.asItem(), "Block of Fiery Metal")
        entries?.add(TFBlocks.ARCTIC_FUR_BLOCK.asItem(), "Block of Arctic Fur")

        entries?.add(TFBlocks.MAZESTONE.asItem(), "Mazestone")
        entries?.add(TFBlocks.MAZESTONE_BRICK.asItem(), "Mazestone Brick")
        entries?.add(TFBlocks.MAZESTONE_LARGE_BRICK.asItem(), "Large Mazestone Brick")
        entries?.add(TFBlocks.CHISELED_MAZESTONE.asItem(), "Chiseled Mazestone")
        entries?.add(TFBlocks.CUT_MAZESTONE.asItem(), "Cut Mazestone")
        entries?.add(TFBlocks.DECORATIVE_MAZESTONE.asItem(), "Decorative Mazestone")
        entries?.add(TFBlocks.CRACKED_MAZESTONE_BRICK.asItem(), "Cracked Mazestone Brick")
        entries?.add(TFBlocks.MOSSY_MAZESTONE_BRICK.asItem(), "Mossy Mazestone Brick")
        entries?.add(TFBlocks.MAZESTONE_MOSAIC.asItem(), "Mazestone Mosaic")
        entries?.add(TFBlocks.MAZESTONE_BORDER.asItem(), "Mazestone Border")

        entries?.add(TFBlocks.UNDERBRICK.asItem(), "Underbrick")
        entries?.add(TFBlocks.MOSSY_UNDERBRICK.asItem(), "Mossy Underbrick")
        entries?.add(TFBlocks.CRACKED_UNDERBRICK.asItem(), "Cracked Underbrick")
        entries?.add(TFBlocks.UNDERBRICK_FLOOR.asItem(), "Underbrick Floor")

        entries?.add(TFBlocks.TOWERWOOD.asItem(), "Towerwood")
        entries?.add(TFBlocks.ENCASED_TOWERWOOD.asItem(), "Encased Towerwood")
        entries?.add(TFBlocks.CRACKED_TOWERWOOD.asItem(), "Cracked Towerwood")

        entries?.add(TFBlocks.HEDGE.asItem(), "Hedge")
        entries?.add(TFBlocks.HEDGE_ROSE.asItem(), "Flowering Hedge")

        entries?.add(TFBlocks.STRONGHOLD_SHIELD.asItem(), "Stronghold Shield")

        entries?.add(TFBlocks.INFESTED_TOWERWOOD.asItem(), "Infested Towerwood")
        entries?.add(TFBlocks.ANTIBUILT_BLOCK.asItem(), "Antibuilt Block")
        entries?.add(TFBlocks.FAKE_GOLD.asItem(), "Fake Gold")
        entries?.add(TFBlocks.FAKE_DIAMOND.asItem(), "Fake Diamond")

        entries?.add(TFBlocks.MAZE_SLIME_BLOCK.asItem(), "Maze Slime Block")

        entries?.add(TFBlocks.TWILIGHT_OAK_LOG.asItem(), "Twilight Oak Log")
        entries?.add(TFBlocks.STRIPPED_TWILIGHT_OAK_LOG.asItem(), "Twilight Oak Log")
        entries?.add(TFBlocks.TWILIGHT_OAK_LEAVES.asItem(), "Twilight Oak Leaves")
        entries?.add(TFBlocks.TWILIGHT_OAK_SAPLING.asItem(), "Twilight Oak Sapling")
        entries?.add(TFBlocks.TWILIGHT_OAK_PLANKS.asItem(), "Twilight Oak Planks")
        entries?.add(TFBlocks.TWILIGHT_OAK_DOOR.asItem(), "Twilight Oak Door")
        entries?.add(TFBlocks.TWILIGHT_OAK_TRAPDOOR.asItem(), "Twilight Oak Trapdoor")
        entries?.add(TFBlocks.TWILIGHT_OAK_FENCE.asItem(), "Twilight Oak Fence")
        entries?.add(TFBlocks.TWILIGHT_OAK_FENCE_GATE.asItem(), "Twilight Oak Fence Gate")
        entries?.add(TFBlocks.TWILIGHT_OAK_STAIRS.asItem(), "Twilight Oak Stairs")
        entries?.add(TFBlocks.TWILIGHT_OAK_SLAB.asItem(), "Twilight Oak Slab")
        entries?.add(TFBlocks.TWILIGHT_OAK_PRESSURE_PLATE.asItem(), "Twilight Oak Pressure Plate")
        entries?.add(TFBlocks.TWILIGHT_OAK_BUTTON.asItem(), "Twilight Oak Button")

        addText(entries, Text.translatable("itemgroup.twilightforest.twilight_forest_items"), "Twilight Forest: Items")
        addText(entries, Text.translatable("itemgroup.twilightforest.twilight_forest_blocks"), "Twilight Forest: Blocks")
        addText(entries, Text.translatable("itemgroup.twilightforest.twilight_forest_equipment"), "Twilight Forest: Equipment")

        addText(entries,Text.translatable("tooltip.twilightforest.experiment_115.tooltip"), "It's not quite cake...")
        addText(entries,Text.translatable("tooltip.twilightforest.pocket_watch.tooltip"), "It seems to always be running late")
        addText(entries,Text.translatable("tooltip.twilightforest.arctic_fur_block.tooltip"), "Here for your own safety!")
        addText(entries,Text.translatable("tooltip.twilightforest.fiery_block.tooltip"), "Watch your step...")
        addText(entries,Text.translatable("tooltip.twilightforest.knightmetal_block.tooltip"), "The cactus but more METAL!")
    }
}