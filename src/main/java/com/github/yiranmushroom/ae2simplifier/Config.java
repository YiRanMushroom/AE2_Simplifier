package com.github.yiranmushroom.ae2simplifier;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.config.ModConfigEvent;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Forge's config APIs
@net.minecraftforge.fml.common.Mod.EventBusSubscriber(modid = AE2Simplifier.MODID, bus = net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec.BooleanValue BuffCoprocessors = BUILDER
            .comment("Whether to buff the number of coprocessors on Crafting CPU Cluster")
            .define("BuffCoprocessors", true);

    public static final ForgeConfigSpec.BooleanValue BuffWireless = BUILDER
            .comment("Whether to buff wireless access point range and dimension")
            .define("BuffWireless", true);

    public static final ForgeConfigSpec.IntValue InterfaceFluidBuckets = BUILDER
            .comment("The number of buckets of capacity that an Interface slot's has. Default is 4096.")
            .defineInRange("InterfaceFluidBuckets", 4096, 4, Integer.MAX_VALUE);

    public static final ForgeConfigSpec.IntValue InterfaceItemStacks = BUILDER
            .comment("The number of stacks that an Interface slot's has. Default is 256. which is 16384 item in one slot")
            .defineInRange("InterfaceItemStacks", 256, 1, Integer.MAX_VALUE);

    static final ForgeConfigSpec SPEC = BUILDER.build();

/*    public static boolean logDirtBlock;
    public static int magicNumber;
    public static String magicNumberIntroduction;
    public static Set<Item> items;

    private static boolean validateItemName(final Object obj)
    {
        return obj instanceof final String itemName && ForgeRegistries.ITEMS.containsKey(new ResourceLocation(itemName));
    }*/

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
/*        logDirtBlock = LOG_DIRT_BLOCK.get();
        magicNumber = MAGIC_NUMBER.get();
        magicNumberIntroduction = MAGIC_NUMBER_INTRODUCTION.get();

        // convert the list of strings into a set of items
        items = ITEM_STRINGS.get().stream()
                .map(itemName -> ForgeRegistries.ITEMS.getValue(new ResourceLocation(itemName)))
                .collect(Collectors.toSet());*/
    }
}
