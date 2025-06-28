package net.mmxcoder.mmxcodermod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mmxcoder.mmxcodermod.MmxcodersMod;

public class ModItems {
    public static final Item ruby_item = registerItem("ruby_item", new Item(new Item.Settings()));
    public static final Item raw_ruby_item = registerItem("raw_ruby_item", new Item(new Item.Settings()));
    public static final Item ruby_nugget_item = registerItem("ruby_nugget_item", new Item(new Item.Settings()));


    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(MmxcodersMod.MOD_ID, name), item);
    }

    public static void registerModItem(){
        MmxcodersMod.LOGGER.info("Registering Mod Items for " + MmxcodersMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(ruby_item);
            entries.add(raw_ruby_item);
            entries.add(ruby_nugget_item);
        });
    }
}