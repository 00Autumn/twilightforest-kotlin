package autumn.twilightforest.init.item.custom

import autumn.twilightforest.component.TFDataComponentTypes
import net.minecraft.component.DataComponentTypes
import net.minecraft.component.type.NbtComponent
import net.minecraft.entity.Entity
import net.minecraft.entity.EquipmentSlot
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NbtCompound
import net.minecraft.server.world.ServerWorld
import net.minecraft.text.Text
import net.minecraft.nbt.NbtIntArray
import java.nio.ByteBuffer
import java.util.UUID

class PocketWatchItem(settings: Settings) : Item(settings) {

    override fun inventoryTick(stack: ItemStack, world: ServerWorld, entity: Entity, slot: EquipmentSlot?) {
        val player = entity as? PlayerEntity ?: return
        val ownerUUID = getOwnerUUID(stack)
        if (ownerUUID == null || ownerUUID != player.uuid) return

        player.addStatusEffect(StatusEffectInstance(StatusEffects.SPEED))
        player.addStatusEffect(StatusEffectInstance(StatusEffects.JUMP_BOOST))

        if (player.mainHandStack === stack) {
            player.addStatusEffect(StatusEffectInstance(StatusEffects.HASTE))
        }
    }

    override fun onCraftByPlayer(stack: ItemStack, player: PlayerEntity) {
        if (!isSoulbound(stack)) {
            bindToPlayer(stack, player)
        }
        if (stack.get(DataComponentTypes.CUSTOM_NAME) == null) {
            stack.set(DataComponentTypes.CUSTOM_NAME, Text.literal("${player.name.string}'s Pocket Watch"))
        }
    }

    companion object {
        fun bindToPlayer(stack: ItemStack, player: PlayerEntity) {
            val uuidArray = uuidToIntArray(player.uuid)
            val nbt = NbtCompound().apply {
                putIntArray("OwnerUUID", uuidArray)
                putString("OwnerName", player.name.string)
            }

            val component = NbtComponent.of(nbt)
            stack.set(TFDataComponentTypes.SOULBOUND, component)
        }

        fun getOwnerUUID(stack: ItemStack): UUID? {
            val component = stack.get(TFDataComponentTypes.SOULBOUND) ?: return null
            val nbt = component.nbt
            val uuidTag = nbt.get("OwnerUUID") as? NbtIntArray ?: return null
            val uuidArray = uuidTag.intArray

            return if (uuidArray.size == 4) intArrayToUuid(uuidArray) else null
        }

        fun isSoulbound(stack: ItemStack): Boolean {
            return stack.get(TFDataComponentTypes.SOULBOUND) != null
        }

        private fun uuidToIntArray(uuid: UUID): IntArray {
            val bb = ByteBuffer.wrap(ByteArray(16))
            bb.putLong(uuid.mostSignificantBits)
            bb.putLong(uuid.leastSignificantBits)
            return IntArray(4) { bb.getInt(it * 4) }
        }

        private fun intArrayToUuid(array: IntArray): UUID {
            val bb = ByteBuffer.allocate(16)
            array.forEach { bb.putInt(it) }
            bb.flip()
            val most = bb.long
            val least = bb.long
            return UUID(most, least)
        }
    }
}