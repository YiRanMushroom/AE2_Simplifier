package ae2s.mixins;

import appeng.api.behaviors.GenericSlotCapacities;
import appeng.api.stacks.AEFluidKey;
import appeng.api.stacks.AEKeyType;
import appeng.util.CowMap;
import com.google.common.base.Preconditions;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import yiranmushroom.ae2simplifier.mixin.helpers.GenericSlotCapacitiesFunction;
import yiranmushroom.ae2simplifier.mixin.helpers.GenericStackInvFunctions;

@Mixin(GenericSlotCapacities.class)
public class MixinGenericSlotCapacities {
    @Final
    @Shadow(remap = false)
    private static CowMap<AEKeyType, Long> map;

    @Inject(method = "<clinit>", at = @At(value = "INVOKE", target = "Lappeng/api/behaviors/GenericSlotCapacities;register(Lappeng/api/stacks/AEKeyType;Ljava/lang/Long;)V"), remap = false)
    private static void clinitInj(CallbackInfo ci) {
        GenericSlotCapacitiesFunction.INSTANCE.register(map);
    }
}
