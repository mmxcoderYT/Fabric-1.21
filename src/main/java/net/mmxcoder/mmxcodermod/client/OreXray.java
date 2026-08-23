package net.mmxcoder.mmxcodermod.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.util.InputUtil;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.text.Text;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.mmxcoder.mmxcodermod.block.ModBlocks;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

public class OreXray {
    private static final int RADIUS = 20;
    private static final int SCAN_INTERVAL = 10;

    private static final Map<Block, float[]> COLORS = new IdentityHashMap<>();
    private static final List<Highlight> highlights = new ArrayList<>();

    private static KeyBinding toggleKey;
    private static boolean enabled;
    private static int scanCooldown;

    public static void register() {
        COLORS.put(ModBlocks.ruby_ore, color(220, 20, 60));
        COLORS.put(ModBlocks.deepslate_ruby_ore, color(220, 20, 60));
        COLORS.put(ModBlocks.small_ruby_ore, color(255, 80, 110));
        COLORS.put(ModBlocks.deepslate_small_ruby_ore, color(255, 80, 110));
        COLORS.put(ModBlocks.endstone_ruby_ore, color(220, 20, 60));
        COLORS.put(ModBlocks.netherrack_ruby_ore, color(220, 20, 60));
        COLORS.put(ModBlocks.small_gold_ore, color(255, 215, 0));
        COLORS.put(ModBlocks.deepslate_small_gold_ore, color(255, 215, 0));
        COLORS.put(ModBlocks.quartz_ore, color(230, 230, 230));
        COLORS.put(ModBlocks.deepslate_quartz_ore, color(230, 230, 230));
        COLORS.put(ModBlocks.end_coal_ore, color(40, 40, 40));
        COLORS.put(ModBlocks.end_copper_ore, color(200, 110, 70));
        COLORS.put(ModBlocks.end_diamond_ore, color(80, 220, 230));
        COLORS.put(ModBlocks.end_emerald_ore, color(30, 200, 80));
        COLORS.put(ModBlocks.end_gold_ore, color(255, 215, 0));
        COLORS.put(ModBlocks.end_iron_ore, color(210, 180, 140));
        COLORS.put(ModBlocks.end_lapis_ore, color(40, 80, 220));
        COLORS.put(ModBlocks.end_nether_gold_ore, color(255, 215, 0));
        COLORS.put(ModBlocks.end_nether_quartz_ore, color(230, 230, 230));
        COLORS.put(ModBlocks.end_redstone_ore, color(220, 20, 20));
        COLORS.put(ModBlocks.nether_coal_ore, color(40, 40, 40));
        COLORS.put(ModBlocks.nether_copper_ore, color(200, 110, 70));
        COLORS.put(ModBlocks.nether_diamond_ore, color(80, 220, 230));
        COLORS.put(ModBlocks.nether_emerald_ore, color(30, 200, 80));
        COLORS.put(ModBlocks.nether_gold_ore, color(255, 215, 0));
        COLORS.put(ModBlocks.nether_iron_ore, color(210, 180, 140));
        COLORS.put(ModBlocks.nether_lapis_ore, color(40, 80, 220));
        COLORS.put(ModBlocks.nether_redstone_ore, color(220, 20, 20));

        toggleKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.mmxcodermod.ore_xray",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_X,
                "key.category.mmxcodermod"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (toggleKey.wasPressed()) {
                enabled = !enabled;
                highlights.clear();
                scanCooldown = 0;
                if (client.worldRenderer != null) {
                    client.worldRenderer.reload();
                }
                if (client.player != null) {
                    client.player.sendMessage(Text.translatable(
                            enabled ? "message.mmxcodermod.ore_xray.on" : "message.mmxcodermod.ore_xray.off"
                    ), true);
                }
            }

            if (enabled) {
                if (--scanCooldown <= 0) {
                    scan(client);
                    scanCooldown = SCAN_INTERVAL;
                }
            } else if (!highlights.isEmpty()) {
                highlights.clear();
            }
        });

        WorldRenderEvents.AFTER_TRANSLUCENT.register(context -> {
            if (!enabled || highlights.isEmpty()) {
                return;
            }

            MatrixStack matrices = context.matrixStack();
            if (matrices == null) {
                return;
            }

            Vec3d camera = context.camera().getPos();
            matrices.push();
            matrices.translate(-camera.x, -camera.y, -camera.z);

            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            RenderSystem.disableCull();
            RenderSystem.disableDepthTest();
            RenderSystem.setShader(GameRenderer::getRenderTypeLinesProgram);
            RenderSystem.lineWidth(2.0F);

            BufferBuilder buffer = Tessellator.getInstance().begin(VertexFormat.DrawMode.LINES, VertexFormats.LINES);
            for (Highlight highlight : highlights) {
                float[] color = highlight.color;
                WorldRenderer.drawBox(matrices, buffer, highlight.box, color[0], color[1], color[2], 1.0F);
            }
            BufferRenderer.drawWithGlobalProgram(buffer.end());

            RenderSystem.lineWidth(1.0F);
            RenderSystem.enableDepthTest();
            RenderSystem.enableCull();
            RenderSystem.disableBlend();
            matrices.pop();
        });
    }

    private static void scan(MinecraftClient client) {
        highlights.clear();
        ClientWorld world = client.world;
        if (world == null || client.player == null) {
            return;
        }

        BlockPos center = client.player.getBlockPos();
        BlockPos.Mutable pos = new BlockPos.Mutable();

        for (int x = -RADIUS; x <= RADIUS; x++) {
            for (int y = -RADIUS; y <= RADIUS; y++) {
                for (int z = -RADIUS; z <= RADIUS; z++) {
                    pos.set(center.getX() + x, center.getY() + y, center.getZ() + z);
                    BlockState state = world.getBlockState(pos);
                    float[] color = COLORS.get(state.getBlock());
                    if (color != null) {
                        highlights.add(new Highlight(new Box(pos.toImmutable()), color));
                    }
                }
            }
        }
    }

    public static boolean shouldHide(BlockState state) {
        if (!enabled) {
            return false;
        }

        Block block = state.getBlock();
        if (COLORS.containsKey(block)) {
            return false;
        }

        return state.isIn(BlockTags.BASE_STONE_OVERWORLD)
                || state.isIn(BlockTags.BASE_STONE_NETHER)
                || state.isIn(BlockTags.DIRT)
                || state.isIn(BlockTags.SAND)
                || block == Blocks.END_STONE
                || block == Blocks.GRAVEL
                || block == Blocks.MAGMA_BLOCK
                || block == Blocks.SOUL_SAND
                || block == Blocks.SOUL_SOIL
                || block == Blocks.BASALT
                || block == Blocks.SMOOTH_BASALT
                || block == Blocks.BLACKSTONE
                || block == Blocks.CALCITE
                || block == Blocks.DRIPSTONE_BLOCK
                || block == Blocks.TUFF
                || block == Blocks.COBBLESTONE
                || block == Blocks.COBBLED_DEEPSLATE;
    }

    private static float[] color(int red, int green, int blue) {
        return new float[] {red / 255.0F, green / 255.0F, blue / 255.0F};
    }

    private record Highlight(Box box, float[] color) {
    }
}
