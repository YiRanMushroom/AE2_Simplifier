package com.github.yiranmushroom.ae2simplifier.mixin;

import appeng.api.behaviors.GenericSlotCapacities;
import appeng.api.stacks.AEFluidKey;
import appeng.api.stacks.AEKeyType;
import appeng.util.CowMap;
import com.google.common.base.Preconditions;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import static com.github.yiranmushroom.ae2simplifier.Config.InterfaceFluidBuckets;
import static com.github.yiranmushroom.ae2simplifier.Config.InterfaceItemStacks;

@Mixin(GenericSlotCapacities.class)
public class GenericSlotCapacitiesMixin {
    @Final
    @Shadow(remap = false)
    private static CowMap<AEKeyType, Long> map;

    /**
     * @author YiranMushroom
     * @reason Hope this will work since injection didn't
     */
    @Overwrite(remap = false)
    public static void register(AEKeyType type, Long capacity) {
        if (type.equals(AEKeyType.fluids())) {
            map.putIfAbsent(type, (long) InterfaceFluidBuckets.get() * AEFluidKey.AMOUNT_BUCKET);
            return;
        }

        if (type.equals(AEKeyType.items())) {
            map.putIfAbsent(type, 64L * InterfaceItemStacks.get());
            return;
        }

        Preconditions.checkArgument(capacity >= 0L, "capacity >= 0");
        map.putIfAbsent(type, capacity);
    }
}
