package net.mmxcoder.mmxcodermod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.mmxcoder.mmxcodermod.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.raw_ruby_block)
                .add(ModBlocks.ruby_ore)
                .add(ModBlocks.ruby_block)
                .add(ModBlocks.deepslate_ruby_ore)
                .add(ModBlocks.small_ruby_ore)
                .add(ModBlocks.deepslate_small_ruby_ore)
                .add(ModBlocks.endstone_ruby_ore)
                .add(ModBlocks.netherrack_ruby_ore)
                .add(ModBlocks.small_gold_ore)
                .add(ModBlocks.deepslate_small_gold_ore)
                .add(ModBlocks.quartz_ore)
                .add(ModBlocks.deepslate_quartz_ore)
                .add(ModBlocks.end_coal_ore)
                .add(ModBlocks.end_copper_ore)
                .add(ModBlocks.end_diamond_ore)
                .add(ModBlocks.end_emerald_ore)
                .add(ModBlocks.end_gold_ore)
                .add(ModBlocks.end_iron_ore)
                .add(ModBlocks.end_lapis_ore)
                .add(ModBlocks.end_nether_gold_ore)
                .add(ModBlocks.end_nether_quartz_ore)
                .add(ModBlocks.end_redstone_ore)
                .add(ModBlocks.nether_coal_ore)
                .add(ModBlocks.nether_copper_ore)
                .add(ModBlocks.nether_diamond_ore)
                .add(ModBlocks.nether_emerald_ore)
                .add(ModBlocks.nether_gold_ore)
                .add(ModBlocks.nether_iron_ore)
                .add(ModBlocks.nether_lapis_ore)
                .add(ModBlocks.nether_redstone_ore);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.end_copper_ore)
                .add(ModBlocks.end_iron_ore)
                .add(ModBlocks.end_lapis_ore)
                .add(ModBlocks.nether_copper_ore)
                .add(ModBlocks.nether_iron_ore)
                .add(ModBlocks.nether_lapis_ore);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.end_gold_ore)
                .add(ModBlocks.end_redstone_ore)
                .add(ModBlocks.end_emerald_ore)
                .add(ModBlocks.end_diamond_ore)
                .add(ModBlocks.nether_gold_ore)
                .add(ModBlocks.nether_redstone_ore)
                .add(ModBlocks.nether_emerald_ore)
                .add(ModBlocks.nether_diamond_ore)
                .add(ModBlocks.ruby_block)
                .add(ModBlocks.ruby_ore)
                .add(ModBlocks.deepslate_ruby_ore)
                .add(ModBlocks.endstone_ruby_ore)
                .add(ModBlocks.netherrack_ruby_ore)
                .add(ModBlocks.raw_ruby_block);

        /* getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE) */
    }
}
