package autumn.twilightforest.init.item

import autumn.twilightforest.TwilightForest
import net.minecraft.component.type.FoodComponent
import net.minecraft.entity.effect.StatusEffect
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.item.Items
import net.minecraft.registry.entry.RegistryEntry

object TFFoodComponents {

    val RAW_VENISON = createFood(3, 0.3F).build()
    val COOKED_VENISON = createFood(8, 0.8F).build()
    val RAW_MEEF = createFood(2, 0.3F).build()
    val COOKED_MEEF = createFood(6, 0.6F).build()
    val MEEF_STROGANOFF = createStew(8).build()
    val HYDRA_CHOP = createFoodWithEffect(18, 2.0F, StatusEffects.REGENERATION, 100, 1.0F).build()
    val TORCHBERRIES = createFoodWithEffect(0, 0.0F, StatusEffects.GLOWING, 100, 0.75F).alwaysEdible().build()
    val EXPERIMENT_115 = createFood(4, 0.3F).build()
    val MAZE_WAFER = createFood(4, 0.0F).build()

    fun createFoodWithEffect(nutrition: Int, saturation: Float, effect: RegistryEntry<StatusEffect>, duration: Int, chance: Float): FoodComponent.Builder {
        return FoodComponent.Builder()
            .nutrition(nutrition)
            .saturationModifier(saturation)
            .statusEffect(StatusEffectInstance(effect, duration), chance)
    }

    fun createFood(nutrition: Int, saturation: Float): FoodComponent.Builder {
        return FoodComponent.Builder()
            .nutrition(nutrition)
            .saturationModifier(saturation)
    }

    fun createStew(nutrition: Int): FoodComponent.Builder {
        return FoodComponent.Builder()
            .nutrition(nutrition)
            .saturationModifier(0.6F)
            .usingConvertsTo(Items.BOWL)
    }

    fun registerFoodComponents() {
        TwilightForest.logger.info("Registering food components for " + TwilightForest.MOD_ID)
    }
}