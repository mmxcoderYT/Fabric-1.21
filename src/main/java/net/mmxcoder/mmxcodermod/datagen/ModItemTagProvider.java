package net.mmxcoder.mmxcodermod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.mmxcoder.mmxcodermod.block.ModBlocks;
import net.mmxcoder.mmxcodermod.item.ModItems;
import net.mmxcoder.mmxcodermod.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.RUBYS)
                .add(ModItems.raw_ruby_item)
                .add(ModItems.ruby_item)
                .add(ModItems.ruby_nugget_item)
                /* .add(Items.EMERALD_BLOCK) */;
    }
}
