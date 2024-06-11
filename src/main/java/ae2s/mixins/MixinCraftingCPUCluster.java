package ae2s.mixins;

import org.spongepowered.asm.mixin.Mixin;
import appeng.me.cluster.implementations.CraftingCPUCluster;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import yiranmushroom.ae2simplifier.Config;
import yiranmushroom.ae2simplifier.mixin.helpers.CraftingCPUClusterFunctions;

import static yiranmushroom.ae2simplifier.ConfigKt.getConfigs;

@Mixin(CraftingCPUCluster.class)
public abstract class MixinCraftingCPUCluster {
    @Shadow(remap = false)
    private int accelerator;

    @Shadow(remap = false)
    public abstract long getAvailableStorage();

    @Unique
    private int threads = 0;

    /**
     * @author YiranMushroom
     * @reason change logic for getCoProcessors
     */
    @Inject(method = "getCoProcessors", at = @At("HEAD"), remap = false, cancellable = true)
    public void getCoProcessors(CallbackInfoReturnable<Integer> cir) {
        if (threads == 0) {
            threads = CraftingCPUClusterFunctions.INSTANCE.getCoProcessors(accelerator, getAvailableStorage());
        }
        cir.setReturnValue(threads);
    }
}
