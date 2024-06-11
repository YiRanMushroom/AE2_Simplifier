package ae2s.mixins;

import appeng.api.stacks.AEItemKey;
import appeng.api.stacks.AEKey;
import appeng.api.stacks.AEKeyType;
import appeng.helpers.externalstorage.GenericStackInv;
import it.unimi.dsi.fastutil.objects.Reference2LongMap;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import yiranmushroom.ae2simplifier.mixin.helpers.GenericStackInvFunctions;

@Mixin(GenericStackInv.class)
public abstract class MixinGenericStackInv {
    @Shadow(remap = false)
    public abstract long getCapacity(AEKeyType space);

    @Inject(method = "getMaxAmount", at = @At("HEAD"), cancellable = true, remap = false)
    private void getMaxAmountInj(AEKey key, CallbackInfoReturnable<Long> cir) {
        cir.setReturnValue(GenericStackInvFunctions.INSTANCE
                .getMaxAmount(key, (GenericStackInv) (Object) this));
    }
}
