package net.mmxcoder.mmxcodermod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.mmxcoder.mmxcodermod.MmxcodersMod;
import net.mmxcoder.mmxcodermod.block.ModBlocks;
import net.mmxcoder.mmxcodermod.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> ruby_item_smeltables = List.of(ModItems.raw_ruby_item, ModBlocks.ruby_ore, ModBlocks.deepslate_ruby_ore, ModBlocks.small_ruby_ore,
                ModBlocks.deepslate_small_ruby_ore, ModBlocks.endstone_ruby_ore, ModBlocks.netherrack_ruby_ore);

        offerSmelting(exporter, ruby_item_smeltables, RecipeCategory.MISC, ModItems.ruby_item, 0.7f, 200, "ruby_item");
        offerBlasting(exporter, ruby_item_smeltables, RecipeCategory.MISC, ModItems.ruby_item, 1.4f, 100, "ruby_item");

        //offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.ruby_item, RecipeCategory.MISC, ModBlocks.ruby_block);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.raw_ruby_block)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.raw_ruby_item)
                .criterion(hasItem(ModItems.raw_ruby_item), conditionsFromItem(ModItems.raw_ruby_item))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.raw_ruby_item, 9)
                .input(ModBlocks.raw_ruby_block)
                .criterion(hasItem(ModBlocks.raw_ruby_block), conditionsFromItem(ModBlocks.raw_ruby_block))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ruby_block)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.ruby_item)
                .criterion(hasItem(ModItems.ruby_item), conditionsFromItem(ModItems.ruby_item))
                .offerTo(exporter, Identifier.of(MmxcodersMod.MOD_ID, "ruby_block_from_ruby_item"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ruby_item, 9)
                .input(ModBlocks.ruby_block)
                .criterion(hasItem(ModBlocks.ruby_block), conditionsFromItem(ModBlocks.ruby_block))
                .group("ruby")
                .offerTo(exporter, Identifier.of(MmxcodersMod.MOD_ID, "ruby_item_from_ruby_block"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ruby_item)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.ruby_nugget_item)
                .criterion(hasItem(ModItems.ruby_nugget_item), conditionsFromItem(ModItems.ruby_nugget_item))
                .group("ruby")
                .offerTo(exporter, Identifier.of(MmxcodersMod.MOD_ID, "ruby_item_from_ruby_nugget_item"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ruby_nugget_item, 9)
                .input(ModItems.ruby_item)
                .criterion(hasItem(ModItems.ruby_item), conditionsFromItem(ModItems.ruby_item))
                .offerTo(exporter, Identifier.of(MmxcodersMod.MOD_ID, "ruby_nugget_item_from_ruby_item"));

        /* ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.raw_ruby_item, 32)
                .input(ModBlocks.ruby_ore)
                .criterion(hasItem(ModBlocks.ruby_ore), conditionsFromItem(ModBlocks.ruby_ore))
                .offerTo(exporter, Identifier.of(MmxcodersMod.MOD_ID, "raw_ruby_item_from_ruby_ore")); */

        List<ItemConvertible> redstone = List.of(ModBlocks.end_redstone_ore, ModBlocks.nether_redstone_ore);

        offerSmelting(exporter, redstone, RecipeCategory.MISC, Items.REDSTONE, 0.7f, 200, "REDSTONE");
        offerBlasting(exporter, redstone, RecipeCategory.MISC, Items.REDSTONE, 0.7f, 100, "REDSTONE");

        List<ItemConvertible> copper = List.of(ModBlocks.end_copper_ore, ModBlocks.nether_copper_ore);

        offerSmelting(exporter, copper, RecipeCategory.MISC, Items.COPPER_INGOT, 0.7f, 200, "COPPER_INGOT");
        offerBlasting(exporter, copper, RecipeCategory.MISC, Items.COPPER_INGOT, 0.7f, 100, "COPPER_INGOT");

        List<ItemConvertible> coal = List.of(ModBlocks.end_coal_ore, ModBlocks.nether_coal_ore);

        offerSmelting(exporter, coal, RecipeCategory.MISC, Items.COAL, 0.7f, 200, "COAL");
        offerBlasting(exporter, coal, RecipeCategory.MISC, Items.COAL, 0.7f, 100, "COAL");

        List<ItemConvertible> quartz = List.of(ModBlocks.end_nether_quartz_ore, ModBlocks.quartz_ore, ModBlocks.deepslate_quartz_ore);

        offerSmelting(exporter, quartz, RecipeCategory.MISC, Items.QUARTZ, 0.2f, 200, "QUARTZ");
        offerBlasting(exporter, quartz, RecipeCategory.MISC, Items.QUARTZ, 0.2f, 100, "QUARTZ");

        List<ItemConvertible> lapis = List.of(ModBlocks.end_lapis_ore, ModBlocks.nether_lapis_ore);

        offerSmelting(exporter, lapis, RecipeCategory.MISC, Items.LAPIS_LAZULI, 0.2f, 200, "LAPIS_LAZULI");
        offerBlasting(exporter, lapis, RecipeCategory.MISC, Items.LAPIS_LAZULI, 0.2f, 100, "LAPIS_LAZULI");

        List<ItemConvertible> iron = List.of(ModBlocks.end_iron_ore, ModBlocks.nether_iron_ore);

        offerSmelting(exporter, iron, RecipeCategory.MISC, Items.IRON_INGOT, 0.7f, 200, "IRON_INGOT");
        offerBlasting(exporter, iron, RecipeCategory.MISC, Items.IRON_INGOT, 0.7f, 100, "IRON_INGOT");

        List<ItemConvertible> gold = List.of(ModBlocks.end_gold_ore, ModBlocks.nether_gold_ore, ModBlocks.end_nether_gold_ore,
                ModBlocks.small_gold_ore ,ModBlocks.deepslate_small_gold_ore);

        offerSmelting(exporter, gold, RecipeCategory.MISC, Items.GOLD_INGOT, 1.0f, 200, "GOLD_INGOT");
        offerBlasting(exporter, gold, RecipeCategory.MISC, Items.GOLD_INGOT, 1.0f, 100, "GOLD_INGOT");

        List<ItemConvertible> diamond = List.of(ModBlocks.end_diamond_ore, ModBlocks.nether_diamond_ore);

        offerSmelting(exporter, diamond, RecipeCategory.MISC, Items.DIAMOND, 1.0f, 200, "DIAMOND");
        offerBlasting(exporter, diamond, RecipeCategory.MISC, Items.DIAMOND, 1.0f, 100, "DIAMOND");

        List<ItemConvertible> emerald = List.of(ModBlocks.end_emerald_ore, ModBlocks.nether_emerald_ore);

        offerSmelting(exporter, emerald, RecipeCategory.MISC, Items.EMERALD, 1.0f, 200, "EMERALD");
        offerBlasting(exporter, emerald, RecipeCategory.MISC, Items.EMERALD, 1.0f, 100, "EMERALD");

    }
}
