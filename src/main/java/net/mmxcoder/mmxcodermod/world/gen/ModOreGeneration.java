package net.mmxcoder.mmxcodermod.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.mmxcoder.mmxcodermod.world.ModPlacedFeatures;

public class ModOreGeneration {
    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.overworld_ores_placed_key);

        /* Example for individual Biomes
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.BADLANDS),
        GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.overworld_ores_placed_key);

        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.end_ores_placed_key); */

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.SMALL_END_ISLANDS, BiomeKeys.END_HIGHLANDS ,BiomeKeys.END_MIDLANDS, BiomeKeys.END_BARRENS), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.common_end_ores_placed_key);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.SMALL_END_ISLANDS, BiomeKeys.END_HIGHLANDS ,BiomeKeys.END_MIDLANDS, BiomeKeys.END_BARRENS), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.end_ores_placed_key);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.SMALL_END_ISLANDS, BiomeKeys.END_HIGHLANDS ,BiomeKeys.END_MIDLANDS, BiomeKeys.END_BARRENS), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.rare_end_ores_placed_key);

        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.nether_ores_placed_key);
    }
}
