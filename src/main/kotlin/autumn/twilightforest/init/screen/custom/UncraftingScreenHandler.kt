package autumn.twilightforest.init.screen.custom

import autumn.twilightforest.init.block.TFBlocks
import autumn.twilightforest.init.screen.TFScreenHandlers
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.item.ItemStack
import net.minecraft.recipe.book.RecipeBookType
import net.minecraft.screen.AbstractCraftingScreenHandler
import net.minecraft.screen.ScreenHandler
import net.minecraft.screen.ScreenHandlerContext
import net.minecraft.screen.slot.Slot
import net.minecraft.util.math.BlockPos

class UncraftingScreenHandler(syncId: Int, playerInventory: PlayerInventory, private val pos: BlockPos?) : AbstractCraftingScreenHandler(TFScreenHandlers.UNCRAFTING_SCREEN_HANDLER, syncId, 3, 3) {
    private val context = ScreenHandlerContext.create(playerInventory.player.world, pos)

    init {
        this.addSlot(Slot(this.craftingInventory, 0, 30, 17))

        for (row in 0 until 3) {
            for (col in 0 until 3) {
                this.addSlot(Slot(this.craftingResultInventory, 1 + col + row * 3, 80 + col * 18, 35 + row * 18))
            }
        }

        this.addPlayerSlots(playerInventory, 8, 84)
    }

    override fun getOutputSlot(): Slot? {
        return this.slots[1]
    }

    override fun getInputSlots(): List<Slot> {
        return listOf(this.slots[0])
    }

    fun getAllOutputSlots(): List<Slot> {
        return this.slots.subList(1, 10)
    }


    override fun getPlayer(): PlayerEntity? {
        return this.player
    }

    override fun getCategory(): RecipeBookType? {
        return RecipeBookType.CRAFTING
    }

    override fun quickMove(
        player: PlayerEntity?,
        slot: Int
    ): ItemStack? {
        TODO("Not yet implemented")
    }

    override fun canInsertIntoSlot(stack: ItemStack?, slot: Slot?): Boolean {
        return super.canInsertIntoSlot(stack, slot)
    }

    override fun canUse(player: PlayerEntity?): Boolean {
        return ScreenHandler.canUse(context, player, TFBlocks.UNCRAFTING_TABLE)
    }
}