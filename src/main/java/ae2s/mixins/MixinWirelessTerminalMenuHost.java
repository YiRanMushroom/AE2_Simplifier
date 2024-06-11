package ae2s.mixins;

import appeng.api.implementations.blockentities.IWirelessAccessPoint;
import appeng.helpers.WirelessTerminalMenuHost;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static yiranmushroom.ae2simplifier.Config.INSTANCE;

@Mixin(WirelessTerminalMenuHost.class)
public abstract class MixinWirelessTerminalMenuHost {
    @Inject(method = "getWapSqDistance", at = @At("HEAD"), cancellable = true, remap = false)
    private void testWap(IWirelessAccessPoint wirelessAccessPoint, CallbackInfoReturnable<Double> cir) {
        if (INSTANCE.getBuffWireless().get()) {
            cir.setReturnValue(0D);
        }
    }
}
