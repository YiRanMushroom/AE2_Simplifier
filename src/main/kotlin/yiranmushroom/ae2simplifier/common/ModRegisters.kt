package yiranmushroom.ae2simplifier.common

import yiranmushroom.ae2simplifier.AE2Simplifier
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries

object ModRegisters {
    val REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, AE2Simplifier.ID)
//    val registerBlocks = DeferredRegister.create(ForgeRegistries.BLOCKS, AE2Simplifier.ID)
//    val registerBlockEntities = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, AE2Simplifier.ID)
//    val registerItems = DeferredRegister.create(ForgeRegistries.ITEMS, AE2Simplifier.ID)

    // the returned ObjectHolderDelegate can be used as a property delegate
    // this is automatically registered by the deferred registry at the correct times
//    val EXAMPLE_BLOCK by REGISTRY.registerObject("example_block") {
//        ClipContext.Block(BlockBehaviour.Properties.of().lightLevel { 15 }.strength(3.0f))
//    }
}