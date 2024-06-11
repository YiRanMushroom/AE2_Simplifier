package ae2s.mixins;

import appeng.util.CowMap;
import com.google.gson.internal.LinkedTreeMap;
import org.checkerframework.checker.units.qual.K;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(CowMap.class)
public class MixinCowMap<K, V> {
    @Shadow(remap = false)
    private volatile Map<K, V> map;

    @Inject(method = "putIfAbsent", at = @At("HEAD"), remap = false, cancellable = true)
    private void putIfAbsent(K key, V value, CallbackInfo ci) {
        synchronized (this) {
            if (this.map.containsKey(key)) ci.cancel();
        }
    }
}
