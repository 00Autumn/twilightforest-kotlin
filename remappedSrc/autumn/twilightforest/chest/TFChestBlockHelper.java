package autumn.twilightforest.chest;

import autumn.twilightforest.TwilightForest;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.TrappedChestBlock;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

@SuppressWarnings("unused")
public class TFChestBlockHelper {

    private TFChestBlockHelper() {return;}

    /**
     * Registers a chest block and adds it to the vanilla ChestBlockEntity supported blocks list.
     *
     * @param name     The block name (e.g., "twilight_oak_chest")
     * @param factory  Factory to create the chest block using prepared settings
     * @param settings The settings to apply to the chest block
     * @return The registered ChestBlock
     */
    public static ChestBlock registerChestBlock(String name, Function<AbstractBlock.Settings, ChestBlock> factory, AbstractBlock.Settings settings) {
        Identifier id = Identifier.of(TwilightForest.MOD_ID, name);
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, id);
        AbstractBlock.Settings finalSettings = settings.registryKey(key);
        ChestBlock block = factory.apply(finalSettings);
        BlockEntityType.CHEST.addSupportedBlock(block);
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, key, block);
    }

    /**
     * Registers a trapped chest block and adds it to the vanilla TrappedChestBlockEntity supported blocks list.
     *
     * @param name     The block name (e.g., "trapped_twilight_oak_chest")
     * @param factory  Factory to create the trapped chest block using prepared settings
     * @param settings The settings to apply to the trapped chest block
     * @return The registered TrappedChestBlock
     */
    public static TrappedChestBlock registerTrappedChestBlock(String name, Function<AbstractBlock.Settings, TrappedChestBlock> factory, AbstractBlock.Settings settings) {
        Identifier id = Identifier.of(TwilightForest.MOD_ID, name);
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, id);
        AbstractBlock.Settings finalSettings = settings.registryKey(key);
        TrappedChestBlock block = factory.apply(finalSettings);
        BlockEntityType.TRAPPED_CHEST.addSupportedBlock(block);
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, key, block);
    }

    private static void registerBlockItem(String name, Block block) {
        Identifier id = Identifier.of(TwilightForest.MOD_ID, name);
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, id);
        Item.Settings settings = new Item.Settings().useBlockPrefixedTranslationKey().registryKey(itemKey);
        BlockItem blockItem = new BlockItem(block, settings);
        Registry.register(Registries.ITEM, id, blockItem);
    }
}
