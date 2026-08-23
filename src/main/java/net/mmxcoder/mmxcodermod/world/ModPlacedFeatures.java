package net.mmxcoder.mmxcodermod.world;

import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.mmxcoder.mmxcodermod.MmxcodersMod;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> overworld_ores_placed_key = registerKey("overworld_ores_placed");
    public static final RegistryKey<PlacedFeature> common_end_ores_placed_key = registerKey("common_end_ores_placed");
    public static final RegistryKey<PlacedFeature> end_ores_placed_key = registerKey("end_ores_placed");
    public static final RegistryKey<PlacedFeature> rare_end_ores_placed_key = registerKey("rare_end_ores_placed");
    public static final RegistryKey<PlacedFeature> nether_ores_placed_key = registerKey("nether_ores_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, overworld_ores_placed_key, configuredFeatures.getOrThrow(ModConfiguredFeatures.overworld_ores_key),
                ModOrePlacement.modifiersWithCount(14,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(80))));

        register(context, common_end_ores_placed_key, configuredFeatures.getOrThrow(ModConfiguredFeatures.common_end_ores_key),
                ModOrePlacement.modifiersWithRarity(4,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));

        register(context, end_ores_placed_key, configuredFeatures.getOrThrow(ModConfiguredFeatures.end_ores_key),
                ModOrePlacement.modifiersWithRarity(8,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));

        register(context, rare_end_ores_placed_key, configuredFeatures.getOrThrow(ModConfiguredFeatures.rare_end_ores_key),
                ModOrePlacement.modifiersWithRarity(16,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));

        register(context, nether_ores_placed_key, configuredFeatures.getOrThrow(ModConfiguredFeatures.nether_ores_key),
                ModOrePlacement.modifiersWithCount(14,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));

    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MmxcodersMod.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}