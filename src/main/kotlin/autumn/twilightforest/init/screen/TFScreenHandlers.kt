package autumn.twilightforest.init.screen

import autumn.twilightforest.TwilightForest
import autumn.twilightforest.init.screen.custom.UncraftingScreenHandler
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.screen.ScreenHandlerType
import net.minecraft.util.Identifier
import net.minecraft.util.math.BlockPos

object TFScreenHandlers {
    val UNCRAFTING_SCREEN_HANDLER: ScreenHandlerType<UncraftingScreenHandler> = Registry.register(
        Registries.SCREEN_HANDLER, Identifier.of(TwilightForest.MOD_ID, "uncrafting_screen_handler"),
        ExtendedScreenHandlerType(::UncraftingScreenHandler, BlockPos.PACKET_CODEC))

    fun registerScreenHandlers() {
        TwilightForest.logger?.info("Registering screen handlers for " + TwilightForest.MOD_ID)
    }
}