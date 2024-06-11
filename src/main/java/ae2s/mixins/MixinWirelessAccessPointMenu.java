package ae2s.mixins;

import appeng.menu.implementations.WirelessAccessPointMenu;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static yiranmushroom.ae2simplifier.ConfigKt.getConfigs;

@Mixin(WirelessAccessPointMenu.class)
public abstract class MixinWirelessAccessPointMenu {
    @Inject(method = "getRange", at = @At("HEAD"), cancellable = true, remap = false)
    private void broadcastChanges(CallbackInfoReturnable<Long> cir) {
        if (getConfigs().getBuffWireless().get()) {
            cir.setReturnValue(Long.MAX_VALUE);
        }
    }
}
