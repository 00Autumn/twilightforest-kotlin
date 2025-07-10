package autumn.twilightforest.init.screen.custom

import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.minecraft.client.gl.RenderPipelines
import net.minecraft.client.gui.DrawContext
import net.minecraft.client.gui.ScreenPos
import net.minecraft.client.gui.screen.ingame.RecipeBookScreen
import net.minecraft.client.gui.screen.recipebook.AbstractCraftingRecipeBookWidget
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.text.Text
import net.minecraft.util.Identifier

@Environment(EnvType.CLIENT)
class UncraftingScreen(
    handler: UncraftingScreenHandler,
    inventory: PlayerInventory,
    title: Text
) : RecipeBookScreen<UncraftingScreenHandler>(handler, AbstractCraftingRecipeBookWidget(handler), inventory, title) {

    companion object {
        val TEXTURE = Identifier.of("twilightforest", "textures/gui/container/uncrafting_table.png")
    }

    override fun init() {
        super.init()
        this.titleX = 29 // adjust as needed
    }

    override fun getRecipeBookButtonPos(): ScreenPos {
        return ScreenPos(this.x + 5, this.height / 2 - 49)
    }

    override fun drawBackground(context: DrawContext, deltaTicks: Float, mouseX: Int, mouseY: Int) {
        val i = this.x
        val j = (this.height - this.backgroundHeight) / 2
        context.drawTexture(RenderPipelines.GUI_TEXTURED, TEXTURE, i, j, 0f, 0f, this.backgroundWidth, this.backgroundHeight, 256, 256)
    }
}