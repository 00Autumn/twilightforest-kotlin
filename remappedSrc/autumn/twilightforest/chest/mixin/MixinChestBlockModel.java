package autumn.twilightforest.chest.mixin;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.block.entity.model.ChestBlockModel;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ChestBlockModel.class)
public abstract class MixinChestBlockModel {
    @Shadow @Final private ModelPart lock;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void twilightforest$hideLock(CallbackInfo ci) {
        if (shouldBeLockless()) {
            lock.visible = false;
        }
    }

    @Unique
    private boolean shouldBeLockless() {
        for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
            String fullLine = element.toString().toLowerCase(); // to catch 'Lockless' or 'LOCKLESS'
            if (fullLine.contains("lockless")) {
                return true;
            }
        }
        return false;
    }
}