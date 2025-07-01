package autumn.twilightforest.init.item

import autumn.twilightforest.TwilightForest
import net.minecraft.component.type.ConsumableComponent
import net.minecraft.component.type.ConsumableComponents
import net.minecraft.component.type.FoodComponent
import net.minecraft.entity.effect.StatusEffect
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.item.Items
import net.minecraft.item.consume.ApplyEffectsConsumeEffect
import net.minecraft.registry.entry.RegistryEntry

object TFFoodComponents {

    val RAW_VENISON = createFood(3, 0.3F).build()
    val COOKED_VENISON = createFood(8, 0.8F).build()
    val RAW_MEEF = createFood(2, 0.3F).build()
    val COOKED_MEEF = createFood(6, 0.6F).build()
    val MEEF_STROGANOFF = createFood( 8, 0.6F).build()
    val HYDRA_CHOP = createFood(18, 2.0F).build()
    val TORCHBERRIES = createFood(0, 0.0F).alwaysEdible().build()
    val EXPERIMENT_115 = createFood(4, 0.3F).build()
    val MAZE_WAFER = createFood(4, 0.0F).build()

    fun createFood(nutrition: Int, saturation: Float): FoodComponent.Builder {
        return FoodComponent.Builder()
            .nutrition(nutrition)
            .saturationModifier(saturation)
    }

    fun registerFoodComponents() {
        TwilightForest.logger?.info("Registering food components for " + TwilightForest.MOD_ID)
    }
}