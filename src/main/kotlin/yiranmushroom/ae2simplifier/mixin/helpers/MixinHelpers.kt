package yiranmushroom.ae2simplifier.mixin.helpers

import appeng.api.stacks.*
import appeng.helpers.externalstorage.GenericStackInv
import yiranmushroom.ae2simplifier.getConfigs
import appeng.util.CowMap
import it.unimi.dsi.fastutil.objects.Reference2LongMap
import yiranmushroom.ae2simplifier.AE2Simplifier.LOGGER
import yiranmushroom.ae2simplifier.Config

object CraftingCPUClusterFunctions {
    fun getCoProcessors(accelerator: Int, storage: Long): Int {
        var returnVal: Long = storage / 1024

        for (i in 0 until accelerator) {
            returnVal *= 2
            if (returnVal > 67108864)
                return 67108864
        }

        return returnVal.toInt()
    }
}

object GenericStackInvFunctions {
    fun getMaxAmount(key: AEKey, inv: GenericStackInv): Long {
        return if (key is AEItemKey) {
            key.maxStackSize.toLong().coerceAtMost(
                inv.getCapacity(key.type)
            ) * getConfigs().InterfaceItemStacks.get()
        } else {
            inv.getCapacity(key.type)
        }
    }
}

object GenericSlotCapacitiesFunction {
    fun register(map: CowMap<AEKeyType, Long>) {
        LOGGER.info("Registering AE2Simplifier slot capacities")
        map.putIfAbsent(AEKeyType.items(), Config.InterfaceItemStacks.get() * 64)
        map.putIfAbsent(AEKeyType.fluids(), Config.InterfaceFluidBuckets.get() * AEFluidKey.AMOUNT_BUCKET)
        LOGGER.info("Result: ${AEKeyType.items()} : ${map.map[AEKeyType.items()]}")
        LOGGER.info("Result: ${AEKeyType.fluids()} : ${map.map[AEKeyType.fluids()]}")
    }
}