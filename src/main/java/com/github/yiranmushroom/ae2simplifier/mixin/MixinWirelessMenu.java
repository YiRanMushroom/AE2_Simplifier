package com.github.yiranmushroom.ae2simplifier.mixin;

import appeng.menu.implementations.WirelessAccessPointMenu;
import appeng.menu.slot.RestrictedInputSlot;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static com.github.yiranmushroom.ae2simplifier.Config.BuffWireless;

@Mixin(value = WirelessAccessPointMenu.class)
public abstract class MixinWirelessMenu {
    @Inject(method = "getRange", at = @At("HEAD"), cancellable = true, remap = false)
    private void broadcastChanges(CallbackInfoReturnable<Long> cir) {
        if (BuffWireless.get()) {
            cir.setReturnValue(Long.MAX_VALUE);
        }
    }
}