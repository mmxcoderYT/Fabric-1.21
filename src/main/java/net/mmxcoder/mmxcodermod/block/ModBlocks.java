package net.mmxcoder.mmxcodermod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.mmxcoder.mmxcodermod.MmxcodersMod;

public class ModBlocks {
    public static final Block ruby_block = registerBlock("ruby_block",
            new Block(AbstractBlock.Settings.create().strength(5.0F, 6.0F)
                    .requiresTool().sounds(BlockSoundGroup.METAL)));
    public static final Block raw_ruby_block = registerBlock("raw_ruby_block",
            new Block(AbstractBlock.Settings.create().strength(5.0F, 6.0F)
                    .requiresTool()));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(MmxcodersMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(MmxcodersMod.MOD_ID, name),
        new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks(){
        MmxcodersMod.LOGGER.info("Registering Mod Blocks for " + MmxcodersMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.ruby_block);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(ModBlocks.raw_ruby_block);
        });
    }
}
