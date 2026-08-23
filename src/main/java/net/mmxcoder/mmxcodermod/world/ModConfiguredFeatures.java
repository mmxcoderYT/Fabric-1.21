package net.mmxcoder.mmxcodermod.world;

import net.minecraft.block.Blocks;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.mmxcoder.mmxcodermod.MmxcodersMod;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.mmxcoder.mmxcodermod.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> overworld_ores_key = registerKey("overworld_ores");
    public static final RegistryKey<ConfiguredFeature<?, ?>> common_end_ores_key = registerKey("common_end_ores");
    public static final RegistryKey<ConfiguredFeature<?, ?>> end_ores_key = registerKey("end_ores");
    public static final RegistryKey<ConfiguredFeature<?, ?>> rare_end_ores_key = registerKey("rare_end_ores");
    public static final RegistryKey<ConfiguredFeature<?, ?>> nether_ores_key = registerKey("nether_ores");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> overworldOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.ruby_ore.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.deepslate_ruby_ore.getDefaultState()));

        List<OreFeatureConfig.Target> common_endOres =
                List.of(OreFeatureConfig.createTarget(endReplaceables, ModBlocks.end_coal_ore.getDefaultState()),
                        OreFeatureConfig.createTarget(endReplaceables, ModBlocks.end_copper_ore.getDefaultState()),
                        OreFeatureConfig.createTarget(endReplaceables, ModBlocks.end_nether_gold_ore.getDefaultState()),
                        OreFeatureConfig.createTarget(endReplaceables, ModBlocks.end_nether_quartz_ore.getDefaultState()));

        List<OreFeatureConfig.Target> endOres =
                List.of(OreFeatureConfig.createTarget(endReplaceables, ModBlocks.endstone_ruby_ore.getDefaultState()),
                        OreFeatureConfig.createTarget(endReplaceables, ModBlocks.end_gold_ore.getDefaultState()),
                        OreFeatureConfig.createTarget(endReplaceables, ModBlocks.end_iron_ore.getDefaultState()),
                        OreFeatureConfig.createTarget(endReplaceables, ModBlocks.end_lapis_ore.getDefaultState()),
                        OreFeatureConfig.createTarget(endReplaceables, ModBlocks.end_redstone_ore.getDefaultState()));

        List<OreFeatureConfig.Target> rare_endOres =
                List.of(OreFeatureConfig.createTarget(endReplaceables, ModBlocks.end_diamond_ore.getDefaultState()),
                        OreFeatureConfig.createTarget(endReplaceables, ModBlocks.end_emerald_ore.getDefaultState()));

        List<OreFeatureConfig.Target> netherOres =
                List.of(OreFeatureConfig.createTarget(netherReplaceables, ModBlocks.netherrack_ruby_ore.getDefaultState()));

        register(context, overworld_ores_key, Feature.ORE, new OreFeatureConfig(overworldOres, 12));
        register(context, nether_ores_key, Feature.ORE, new OreFeatureConfig(netherOres, 12));
        register(context, common_end_ores_key, Feature.ORE, new OreFeatureConfig(common_endOres, 12));
        register(context, end_ores_key, Feature.ORE, new OreFeatureConfig(endOres, 9));
        register(context, rare_end_ores_key, Feature.ORE, new OreFeatureConfig(rare_endOres, 6));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(MmxcodersMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}