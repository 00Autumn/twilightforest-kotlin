package autumn.twilightforest.init.item.custom

import autumn.twilightforest.datacomponent.TFDataComponentTypes
import net.minecraft.component.DataComponentTypes
import net.minecraft.component.type.NbtComponent
import net.minecraft.entity.Entity
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.tooltip.TooltipType
import net.minecraft.nbt.NbtCompound
import net.minecraft.text.Text
import net.minecraft.world.World
import java.util.UUID

class PocketWatchItem(settings: Settings) : Item(settings) {

    override fun inventoryTick(stack: ItemStack, world: World, entity: Entity, slot: Int, selected: Boolean) {
        val player = entity as? PlayerEntity ?: return
        val ownerUUID = getOwnerUUID(stack)
        if (ownerUUID == null || ownerUUID != player.uuid) return

        if (slot in 0..8 || slot == PlayerInventory.OFF_HAND_SLOT) {
            player.addStatusEffect(StatusEffectInstance(StatusEffects.SPEED))
            player.addStatusEffect(StatusEffectInstance(StatusEffects.JUMP_BOOST))
        }

        if (player.isHolding(this)) {
            player.addStatusEffect(StatusEffectInstance(StatusEffects.HASTE))
        }
    }

    override fun appendTooltip(stack: ItemStack, context: TooltipContext, tooltip: MutableList<Text>, type: TooltipType) {
        tooltip.add(Text.translatable("tooltip.twilightforest.pocket_watch.tooltip").withColor(16773271))
        super.appendTooltip(stack, context, tooltip, type)
    }

    override fun onCraftByPlayer(stack: ItemStack, world: World, player: PlayerEntity) {
        if (!isSoulbound(stack)) {
            bindToPlayer(stack, player)
        }
        if (stack.get(DataComponentTypes.CUSTOM_NAME) == null) {
            stack.set(DataComponentTypes.CUSTOM_NAME, Text.literal("${player.name.string}'s Pocket Watch"))
        }
    }

    companion object {
        fun bindToPlayer(stack: ItemStack, player: PlayerEntity) {
            val nbt = NbtCompound().apply {
                putUuid("OwnerUUID", player.uuid)
                putString("OwnerName", player.name.string)
            }

            val component = NbtComponent.of(nbt)
            stack.set(TFDataComponentTypes.SOULBOUND, component)
        }

        @JvmStatic
        @Suppress("DEPRECATION")
        fun getOwnerUUID(stack: ItemStack): UUID? {
            val component = stack.get(TFDataComponentTypes.SOULBOUND) ?: return null
            val nbt = component.nbt // Deprecated, but safe
            return nbt.getUuid("OwnerUUID")
        }

        fun isSoulbound(stack: ItemStack): Boolean {
            return stack.get(TFDataComponentTypes.SOULBOUND) != null
        }
    }
}