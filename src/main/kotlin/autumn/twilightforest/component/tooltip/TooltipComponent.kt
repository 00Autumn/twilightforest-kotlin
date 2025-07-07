package autumn.twilightforest.component.tooltip

import com.mojang.serialization.Codec
import com.mojang.serialization.codecs.RecordCodecBuilder
import net.minecraft.component.ComponentsAccess
import net.minecraft.item.Item
import net.minecraft.item.tooltip.TooltipAppender
import net.minecraft.item.tooltip.TooltipType
import net.minecraft.text.Text
import java.util.function.Consumer

data class TooltipComponent(val key: String) : TooltipAppender {
    override fun appendTooltip(context: Item.TooltipContext, textConsumer: Consumer<Text?>, type: TooltipType, components: ComponentsAccess) {
        textConsumer.accept(Text.translatable(key))
    }
    companion object {
        val CODEC: Codec<TooltipComponent> = RecordCodecBuilder.create { instance ->
            instance.group(
                Codec.STRING.fieldOf("tooltip").forGetter { it.key }
            ).apply(instance, ::TooltipComponent)
        }
    }
}