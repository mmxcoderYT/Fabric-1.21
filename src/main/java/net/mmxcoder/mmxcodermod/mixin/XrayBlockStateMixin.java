package net.mmxcoder.mmxcodermod.mixin;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.mmxcoder.mmxcodermod.client.OreXray;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractBlock.AbstractBlockState.class)
public class XrayBlockStateMixin {
    @Inject(method = "getRenderType", at = @At("HEAD"), cancellable = true)
    private void mmxcodermod$hideFillerBlocks(CallbackInfoReturnable<BlockRenderType> cir) {
        BlockState state = (BlockState) (Object) this;
        if (OreXray.shouldHide(state)) {
            cir.setReturnValue(BlockRenderType.INVISIBLE);
        }
    }

    @Inject(method = "isOpaque", at = @At("HEAD"), cancellable = true)
    private void mmxcodermod$dontCullOreFaces(CallbackInfoReturnable<Boolean> cir) {
        BlockState state = (BlockState) (Object) this;
        if (OreXray.shouldHide(state)) {
            cir.setReturnValue(false);
        }
    }
}
