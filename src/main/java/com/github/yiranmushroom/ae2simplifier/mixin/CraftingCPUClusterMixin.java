package com.github.yiranmushroom.ae2simplifier.mixin;

import appeng.me.cluster.implementations.CraftingCPUCluster;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static com.github.yiranmushroom.ae2simplifier.Config.BuffCoprocessors;

@Mixin(CraftingCPUCluster.class)
public abstract class CraftingCPUClusterMixin {
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
        if (BuffCoprocessors.get()) {
            if (this.threads == 0) {
                this.threads = (int) (this.getAvailableStorage() / 1024);
                int multiplied = 0;
                while (this.threads <= 65536 && multiplied < this.accelerator) {
                    this.threads *= 2;
                    multiplied++;
                }
            }
            cir.setReturnValue(this.threads);
        }
    }
}
