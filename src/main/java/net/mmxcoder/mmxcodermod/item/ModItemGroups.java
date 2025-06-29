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
                        entries.add(ModBlocks.ruby_ore);
                        entries.add(ModBlocks.deepslate_ruby_ore);
                        entries.add(ModBlocks.small_ruby_ore);
                        entries.add(ModBlocks.deepslate_small_ruby_ore);
                        entries.add(ModBlocks.endstone_ruby_ore);
                        entries.add(ModBlocks.netherrack_ruby_ore);
                        entries.add(ModBlocks.small_gold_ore);
                        entries.add(ModBlocks.deepslate_small_gold_ore);
                        entries.add(ModBlocks.quartz_ore);
                        entries.add(ModBlocks.deepslate_quartz_ore);
                        entries.add(ModBlocks.end_coal_ore);
                        entries.add(ModBlocks.end_copper_ore);
                        entries.add(ModBlocks.end_diamond_ore);
                        entries.add(ModBlocks.end_emerald_ore);
                        entries.add(ModBlocks.end_gold_ore);
                        entries.add(ModBlocks.end_iron_ore);
                        entries.add(ModBlocks.end_lapis_ore);
                        entries.add(ModBlocks.end_nether_gold_ore);
                        entries.add(ModBlocks.end_nether_quartz_ore);
                        entries.add(ModBlocks.end_redstone_ore);
                        entries.add(ModBlocks.nether_coal_ore);
                        entries.add(ModBlocks.nether_copper_ore);
                        entries.add(ModBlocks.nether_diamond_ore);
                        entries.add(ModBlocks.nether_emerald_ore);
                        entries.add(ModBlocks.nether_gold_ore);
                        entries.add(ModBlocks.nether_iron_ore);
                        entries.add(ModBlocks.nether_lapis_ore);
                        entries.add(ModBlocks.nether_redstone_ore);
                    }).build());



    public static void registerItemGroups(){
        MmxcodersMod.LOGGER.info("Registering Item Groups for " + MmxcodersMod.MOD_ID);
    }

}
