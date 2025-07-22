package autumn.twilightforest.chest.mixin;

import autumn.twilightforest.util.TFChestTypes;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.enums.ChestType;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TexturedRenderLayers.class)
public class MixinTexturedRenderLayers {

    @Inject(
            method = "getChestTextureId(Lnet/minecraft/block/entity/BlockEntity;Lnet/minecraft/block/enums/ChestType;Z)Lnet/minecraft/client/util/SpriteIdentifier;",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void twilightforest$overrideCustomChestTexture(BlockEntity blockEntity, ChestType chestType, boolean christmas, CallbackInfoReturnable<SpriteIdentifier> cir) {
        TFChestTypes type = TFChestTypes.from(blockEntity);
        if (type != null) {
            cir.setReturnValue(type.getSprite(chestType));
        }
    }
}
