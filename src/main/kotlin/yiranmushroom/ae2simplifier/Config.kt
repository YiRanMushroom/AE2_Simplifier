package yiranmushroom.ae2simplifier

import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Item
import net.minecraftforge.common.ForgeConfigSpec
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.config.ModConfigEvent
import java.util.stream.Collectors

@Mod.EventBusSubscriber(modid = AE2Simplifier.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
object Config {
    private val BUILDER = ForgeConfigSpec.Builder()

    /*    private val LOG_DIRT_BLOCK: ForgeConfigSpec.BooleanValue = BUILDER
            .comment("Whether to log the dirt block on common setup")
            .define("logDirtBlock", true)

        private val MAGIC_NUMBER: ForgeConfigSpec.IntValue = BUILDER
            .comment("A magic number")
            .defineInRange("magicNumber", 42, 0, Int.MAX_VALUE)

        val MAGIC_NUMBER_INTRODUCTION: ForgeConfigSpec.ConfigValue<String> = BUILDER
            .comment("What you want the introduction message to be for the magic number")
            .define("magicNumberIntroduction", "The magic number is... ")

        // a list of strings that are treated as resource locations for items
        private val ITEM_STRINGS: ForgeConfigSpec.ConfigValue<List<String>> = BUILDER
            .comment("A list of items to log on common setup.")
            .defineListAllowEmpty("items", listOf("minecraft:iron_ingot"), this::validateItemName)*/

    val BuffCoprocessors: ForgeConfigSpec.ConfigValue<Boolean> = BUILDER
        .comment("Whether to buff the number of coprocessors on Crafting CPU Cluster")
        .define("BuffCoprocessors", true)

    val BuffWireless: ForgeConfigSpec.ConfigValue<Boolean> = BUILDER
        .comment("Whether to buff wireless access point range and dimension")
        .define("BuffWireless", true)

    val InterfaceFluidBuckets: ForgeConfigSpec.ConfigValue<Long> = BUILDER
        .comment("The number of buckets of capacity that an Interface slot's has. Default is 4096.")
        .defineInRange("InterfaceFluidBuckets", 4096, 4, Long.MAX_VALUE)

    val InterfaceItemStacks: ForgeConfigSpec.ConfigValue<Long> = BUILDER
        .comment("The number of stacks that an Interface slot's has. Default is 256. which is 16384 item in one slot")
        .defineInRange("InterfaceItemStacks", 256, 1, Long.MAX_VALUE)

    val SPEC: ForgeConfigSpec = BUILDER.build()

    @SubscribeEvent
    fun onLoad(event: ModConfigEvent) {
        /*        logDirtBlock = LOG_DIRT_BLOCK.get()
                magicNumber = MAGIC_NUMBER.get()
                magicNumberIntroduction = MAGIC_NUMBER_INTRODUCTION.get()

                // convert the list of strings into a set of items
                items = ITEM_STRINGS.get().stream()
                    .map { itemName: String ->
                        BuiltInRegistries.ITEM[ResourceLocation(
                            itemName
                        )]
                    }
                    .collect(Collectors.toSet())*/
    }
}

fun getConfigs(): Config {
    return Config
}