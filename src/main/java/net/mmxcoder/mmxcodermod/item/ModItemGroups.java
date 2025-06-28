package net.mmxcoder.mmxcodermod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.mmxcoder.mmxcodermod.MmxcodersMod;
import net.mmxcoder.mmxcodermod.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup MMXCODERS_TAB = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MmxcodersMod.MOD_ID, "mmxcoders_tab"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.ruby_item))
                    .displayName(Text.translatable("itemgroup.mmxcodermod.mmxcoders_tab"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.ruby_item);
                        entries.add(ModItems.raw_ruby_item);
                        entries.add(ModItems.ruby_nugget_item);
                        entries.add(ModBlocks.ruby_block);
                        entries.add(ModBlocks.raw_ruby_block);
                    }).build());



    public static void registerItemGroups(){
        MmxcodersMod.LOGGER.info("Registering Item Groups for " + MmxcodersMod.MOD_ID);
    }

}
