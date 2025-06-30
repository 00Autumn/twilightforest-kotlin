package autumn.twilightforest.init.item

import autumn.twilightforest.util.TFBlockTags
import com.google.common.base.Suppliers
import net.minecraft.block.Block
import net.minecraft.item.ToolMaterial
import net.minecraft.recipe.Ingredient
import net.minecraft.registry.tag.TagKey
import java.util.function.Supplier

enum class TFToolMaterials(private val inverseTagKey: TagKey<Block>, private val itemDurability: Int, private val miningSpeed: Float, private val attackDamage: Float, private val enchantability: Int, repairSupplier: () -> Ingredient) : ToolMaterial {

    IRONWOOD(
        TFBlockTags.INCORRECT_FOR_IRONWOOD_TOOL,
        512, 6.5f, 2f, 25,
        { Ingredient.ofItems(TFItems.IRONWOOD_INGOT) }
    ),

    STEELEAF(
        TFBlockTags.INCORRECT_FOR_STEELEAF_TOOL,
        131, 8.0f, 3f, 9,
        { Ingredient.ofItems(TFItems.STEELEAF_INGOT) }
    ),

    KNIGHTMETAL(
        TFBlockTags.INCORRECT_FOR_KNIGHTMETAL_TOOL,
        512, 8.0f, 3f, 8,
        { Ingredient.ofItems(TFItems.KNIGHTMETAL_INGOT) }
    ),

    FIERY(
        TFBlockTags.INCORRECT_FOR_FIERY_TOOL,
        1024, 9.0f, 4f, 10,
        { Ingredient.ofItems(TFItems.FIERY_INGOT) }
    );

    private val repairIngredient: Supplier<Ingredient> = Suppliers.memoize(repairSupplier)

    override fun getDurability(): Int = itemDurability

    override fun getMiningSpeedMultiplier(): Float = miningSpeed

    override fun getAttackDamage(): Float = attackDamage

    override fun getEnchantability(): Int = enchantability

    override fun getRepairIngredient(): Ingredient = repairIngredient.get()

    override fun getInverseTag(): TagKey<Block> = inverseTagKey
}