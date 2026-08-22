package net.mmxcoder.mmxcodermod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.mmxcoder.mmxcodermod.block.ModBlocks;
import net.mmxcoder.mmxcodermod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.ruby_block);
        addDrop(ModBlocks.raw_ruby_block);


        addDrop(ModBlocks.ruby_ore, oreDrops(ModBlocks.ruby_ore, ModItems.raw_ruby_item));
        addDrop(ModBlocks.deepslate_ruby_ore, oreDrops(ModBlocks.deepslate_ruby_ore, ModItems.raw_ruby_item));
        addDrop(ModBlocks.small_ruby_ore, multipleOreDrops(ModBlocks.small_ruby_ore, ModItems.ruby_nugget_item, 5, 9));
        addDrop(ModBlocks.deepslate_small_ruby_ore, multipleOreDrops(ModBlocks.deepslate_small_ruby_ore, ModItems.ruby_nugget_item, 5, 9));
        addDrop(ModBlocks.endstone_ruby_ore, oreDrops(ModBlocks.endstone_ruby_ore, ModItems.raw_ruby_item));
        addDrop(ModBlocks.netherrack_ruby_ore, oreDrops(ModBlocks.netherrack_ruby_ore, ModItems.raw_ruby_item));
        addDrop(ModBlocks.small_gold_ore, multipleOreDrops(ModBlocks.ruby_ore, ModItems.raw_ruby_item, 5, 9));
        addDrop(ModBlocks.deepslate_small_gold_ore, multipleOreDrops(ModBlocks.ruby_ore, ModItems.raw_ruby_item, 5, 9));
        addDrop(ModBlocks.quartz_ore, multipleOreDrops(ModBlocks.ruby_ore, ModItems.raw_ruby_item, 5, 9));
        addDrop(ModBlocks.deepslate_quartz_ore, multipleOreDrops(ModBlocks.ruby_ore, ModItems.raw_ruby_item, 5, 9));
        addDrop(ModBlocks.end_coal_ore, multipleOreDrops(ModBlocks.ruby_ore, ModItems.raw_ruby_item, 5, 9));
        addDrop(ModBlocks.end_copper_ore, multipleOreDrops(ModBlocks.ruby_ore, ModItems.raw_ruby_item, 5, 9));
        addDrop(ModBlocks.end_diamond_ore, oreDrops(ModBlocks.end_diamond_ore, Items.DIAMOND));
        addDrop(ModBlocks.end_emerald_ore, oreDrops(ModBlocks.end_emerald_ore, Items.EMERALD));
        addDrop(ModBlocks.end_gold_ore, oreDrops(ModBlocks.end_gold_ore, Items.RAW_GOLD));
        addDrop(ModBlocks.end_iron_ore, oreDrops(ModBlocks.end_iron_ore, Items.RAW_IRON));
        addDrop(ModBlocks.end_lapis_ore, multipleOreDrops(ModBlocks.end_lapis_ore, Items.LAPIS_LAZULI, 4, 9));
        addDrop(ModBlocks.end_nether_gold_ore, multipleOreDrops(ModBlocks.ruby_ore, ModItems.raw_ruby_item, 5, 9));
        addDrop(ModBlocks.end_nether_quartz_ore, multipleOreDrops(ModBlocks.ruby_ore, ModItems.raw_ruby_item, 5, 9));
        addDrop(ModBlocks.end_redstone_ore, multipleOreDrops(ModBlocks.ruby_ore, ModItems.raw_ruby_item, 5, 9));
        addDrop(ModBlocks.nether_coal_ore, multipleOreDrops(ModBlocks.ruby_ore, ModItems.raw_ruby_item, 5, 9));
        addDrop(ModBlocks.nether_copper_ore, multipleOreDrops(ModBlocks.ruby_ore, ModItems.raw_ruby_item, 5, 9));
        addDrop(ModBlocks.nether_diamond_ore, oreDrops(ModBlocks.nether_diamond_ore, Items.DIAMOND));
        addDrop(ModBlocks.nether_emerald_ore, oreDrops(ModBlocks.nether_emerald_ore, Items.EMERALD));
        addDrop(ModBlocks.nether_gold_ore, oreDrops(ModBlocks.nether_gold_ore, Items.RAW_GOLD));
        addDrop(ModBlocks.nether_iron_ore, oreDrops(ModBlocks.nether_iron_ore, Items.RAW_IRON));
        addDrop(ModBlocks.nether_lapis_ore, multipleOreDrops(ModBlocks.nether_lapis_ore, Items.LAPIS_LAZULI, 4, 9));
        addDrop(ModBlocks.nether_redstone_ore, multipleOreDrops(ModBlocks.ruby_ore, ModItems.raw_ruby_item, 5, 9));

    }

        public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
            RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
            return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                    ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                    .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
