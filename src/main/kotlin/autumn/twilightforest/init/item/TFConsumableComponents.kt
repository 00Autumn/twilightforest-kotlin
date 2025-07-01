package autumn.twilightforest.init.item

import net.minecraft.component.type.ConsumableComponent
import net.minecraft.component.type.ConsumableComponents
import net.minecraft.entity.effect.StatusEffect
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.item.consume.ApplyEffectsConsumeEffect
import net.minecraft.registry.entry.RegistryEntry

object TFConsumableComponents {
    val HYDRA_CHOP_EFFECT = createConsumableComponent(StatusEffects.REGENERATION, 100, 1.0F)
    val TORCHBERRIES_EFFECT = createConsumableComponent(StatusEffects.GLOWING, 100, 0.75F)

    fun createConsumableComponent(effect: RegistryEntry<StatusEffect>, duration: Int, chance: Float): ConsumableComponent {
        return ConsumableComponents.food()
            .consumeEffect(ApplyEffectsConsumeEffect(StatusEffectInstance(effect, duration), chance)).build()
    }
}