package net.mmxcoder.mmxcodermod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.RedstoneOreBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.mmxcoder.mmxcodermod.MmxcodersMod;

import static net.minecraft.block.Blocks.createLightLevelFromLitBlockState;

public class ModBlocks {
    public static final Block ruby_block = registerBlock("ruby_block",
            new Block(AbstractBlock.Settings.create().strength(5.0F, 6.0F)
                    .requiresTool().sounds(BlockSoundGroup.METAL)));
    public static final Block raw_ruby_block = registerBlock("raw_ruby_block",
            new Block(AbstractBlock.Settings.create().strength(5.0F, 6.0F)
                    .requiresTool()));
    public static final Block ruby_ore = registerBlock("ruby_ore",
            new Block(AbstractBlock.Settings.create().strength(3.0F, 3.0F)
                    .requiresTool()));
    public static final Block deepslate_ruby_ore = registerBlock("deepslate_ruby_ore",
            new Block(AbstractBlock.Settings.create().strength(4.5F, 3.0F)
                    .requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block small_ruby_ore = registerBlock("small_ruby_ore",
            new Block(AbstractBlock.Settings.create().strength(3.0f,3.0f)
                    .requiresTool()));
    public static final Block deepslate_small_ruby_ore = registerBlock("deepslate_small_ruby_ore",
            new Block(AbstractBlock.Settings.create().strength(3.0f,3.0f)
                    .requiresTool()));
    public static final Block endstone_ruby_ore = registerBlock("endstone_ruby_ore",
            new Block(AbstractBlock.Settings.create().strength(3.0F, 9.0F)
                    .requiresTool()));
    public static final Block netherrack_ruby_ore = registerBlock("netherrack_ruby_ore",
            new Block(AbstractBlock.Settings.create().strength(0.4F)
                    .requiresTool().sounds(BlockSoundGroup.NETHER_ORE)));
    public static final Block small_gold_ore = registerBlock("small_gold_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(0,1),
                    AbstractBlock.Settings.create().strength(4.5f,3.0f)
                            .requiresTool()));
    public static final Block deepslate_small_gold_ore = registerBlock("deepslate_small_gold_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(0,1),
                    AbstractBlock.Settings.create().strength(4.5f,3.0f)
                            .requiresTool()));
    public static final Block quartz_ore = registerBlock("quartz_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2,5),
                    AbstractBlock.Settings.create().strength(3.0f,3.0f)
                            .requiresTool()));
    public static final Block deepslate_quartz_ore = registerBlock("deepslate_quartz_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2,5),
                    AbstractBlock.Settings.create().strength(3.0f,3.0f)
                            .requiresTool()));
    public static final Block end_coal_ore = registerBlock("end_coal_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(0,2),
            AbstractBlock.Settings.create().strength(3.0F, 9.0F)
                    .requiresTool()));
    public static final Block end_copper_ore = registerBlock("end_copper_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2,5),
                    AbstractBlock.Settings.create().strength(3.0F, 9.0F)
                    .requiresTool()));
    public static final Block end_diamond_ore = registerBlock("end_diamond_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 7),
                    AbstractBlock.Settings.create().strength(3.0F, 9.0F)
                            .requiresTool()));
    public static final Block end_emerald_ore = registerBlock("end_emerald_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3,7),
                    AbstractBlock.Settings.create().strength(3.0f,9.0f)
                            .requiresTool()));
    public static final Block end_gold_ore = registerBlock("end_gold_ore",
            new Block(AbstractBlock.Settings.create().strength(3.0f,9.0f)
                    .requiresTool()));
    public static final Block end_iron_ore = registerBlock("end_iron_ore",
            new Block(AbstractBlock.Settings.create().strength(3.0f,9.0f)
                    .requiresTool()));
    public static final Block end_lapis_ore = registerBlock("end_lapis_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2,5),
                    AbstractBlock.Settings.create().strength(3.0f,9.0f)
                            .requiresTool()));
    public static final Block end_nether_gold_ore =registerBlock("end_nether_gold_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(0,1),
                    AbstractBlock.Settings.create().strength(3.0f,9.0f)
                            .requiresTool()));
    public static final Block end_nether_quartz_ore = registerBlock("end_nether_quartz_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2,5),
                    AbstractBlock.Settings.create().strength(3.0f,9.0f)
                            .requiresTool()));
    public static final Block end_redstone_ore = registerBlock("end_redstone_ore",
            new RedstoneOreBlock(AbstractBlock.Settings.create().ticksRandomly()
                    .luminance(createLightLevelFromLitBlockState(9))
                    .strength(3.0f,9.0f).requiresTool()));
    public static final Block nether_coal_ore = registerBlock("nether_coal_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(0,2),
                    AbstractBlock.Settings.create().strength(3.0F, 9.0F)
                            .requiresTool()));
    public static final Block nether_copper_ore = registerBlock("nether_copper_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2,5),
                    AbstractBlock.Settings.create().strength(3.0F, 9.0F)
                            .requiresTool()));
    public static final Block nether_diamond_ore = registerBlock("nether_diamond_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 7),
                    AbstractBlock.Settings.create().strength(3.0F, 9.0F)
                            .requiresTool()));
    public static final Block nether_emerald_ore = registerBlock("nether_emerald_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3,7),
                    AbstractBlock.Settings.create().strength(3.0f,9.0f)
                            .requiresTool()));
    public static final Block nether_gold_ore = registerBlock("nether_gold_ore",
            new Block(AbstractBlock.Settings.create().strength(3.0f,9.0f)
                    .requiresTool()));
    public static final Block nether_iron_ore = registerBlock("nether_iron_ore",
            new Block(AbstractBlock.Settings.create().strength(3.0f,9.0f)
                    .requiresTool()));
    public static final Block nether_lapis_ore = registerBlock("nether_lapis_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2,5),
                    AbstractBlock.Settings.create().strength(3.0f,9.0f)
                            .requiresTool()));
    public static final Block nether_redstone_ore = registerBlock("nether_redstone_ore",
            new RedstoneOreBlock(AbstractBlock.Settings.create().ticksRandomly()
                    .luminance(createLightLevelFromLitBlockState(9))
                    .strength(3.0f,9.0f).requiresTool()));

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
        });
    }
}
