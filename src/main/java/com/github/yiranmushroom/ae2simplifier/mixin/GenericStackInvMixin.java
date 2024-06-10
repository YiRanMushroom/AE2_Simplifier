package com.github.yiranmushroom.ae2simplifier.mixin;

import appeng.api.stacks.AEItemKey;
import appeng.api.stacks.AEKey;
import appeng.api.stacks.AEKeyType;
import appeng.helpers.externalstorage.GenericStackInv;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static com.github.yiranmushroom.ae2simplifier.Config.InterfaceItemStacks;

@Mixin(GenericStackInv.class)
public abstract class GenericStackInvMixin {
    @Shadow(remap = false)
    public abstract long getCapacity(AEKeyType space);

    @Inject(method = "getMaxAmount", at = @At("HEAD"), cancellable = true, remap = false)
    private void getMaxAmountInj(AEKey key, CallbackInfoReturnable<Long> cir){
        if (key instanceof AEItemKey itemKey) {
            cir.setReturnValue(Math.min(itemKey.getMaxStackSize(), getCapacity(key.getType())) * InterfaceItemStacks.get());
        } else {
            cir.setReturnValue(getCapacity(key.getType()));
        }
    }
}
