package net.mmxcoder.mmxcodermod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.mmxcoder.mmxcodermod.block.ModBlocks;
import net.mmxcoder.mmxcodermod.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ruby_block);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.raw_ruby_block);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ruby_ore);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.deepslate_ruby_ore);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.small_ruby_ore);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.deepslate_small_ruby_ore);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.endstone_ruby_ore);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.netherrack_ruby_ore);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.small_gold_ore);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.deepslate_small_gold_ore);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.quartz_ore);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.deepslate_quartz_ore);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.end_coal_ore);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.end_copper_ore);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.end_diamond_ore);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.end_emerald_ore);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.end_gold_ore);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.end_iron_ore);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.end_lapis_ore);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.end_nether_gold_ore);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.end_nether_quartz_ore);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.end_redstone_ore);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.nether_coal_ore);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.nether_copper_ore);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.nether_diamond_ore);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.nether_emerald_ore);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.nether_gold_ore);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.nether_iron_ore);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.nether_lapis_ore);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.nether_redstone_ore);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.ruby_item, Models.GENERATED);
        itemModelGenerator.register(ModItems.raw_ruby_item, Models.GENERATED);
        itemModelGenerator.register(ModItems.ruby_nugget_item, Models.GENERATED);
    }
}
