package autumn.twilightforest.init.block.custom

import autumn.twilightforest.init.screen.custom.UncraftingScreenHandler
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.network.PacketByteBuf
import net.minecraft.screen.NamedScreenHandlerFactory
import net.minecraft.screen.ScreenHandler
import net.minecraft.screen.SimpleNamedScreenHandlerFactory
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.text.Text
import net.minecraft.util.ActionResult
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory

class UncraftingTableBlock(settings: Settings) : Block(settings) {
    companion object {
        val TITLE: Text = Text.literal("Uncrafting")
    }

    override fun onUse(
        state: BlockState,
        world: World,
        pos: BlockPos,
        player: PlayerEntity,
        hit: BlockHitResult
    ): ActionResult {
        if (!world.isClient) {
            player.openHandledScreen(createScreenHandlerFactory(state, world, pos))
        }
        return ActionResult.SUCCESS
    }

    override fun createScreenHandlerFactory(
        state: BlockState,
        world: World,
        pos: BlockPos
    ): NamedScreenHandlerFactory {
        return object : ExtendedScreenHandlerFactory<BlockPos> {
            override fun getScreenOpeningData(player: ServerPlayerEntity): BlockPos {
                return pos
            }

            override fun createMenu(
                syncId: Int,
                inventory: PlayerInventory,
                player: PlayerEntity
            ): ScreenHandler {
                return UncraftingScreenHandler(syncId, inventory, pos)
            }

            override fun getDisplayName(): Text = TITLE
        }
    }

}