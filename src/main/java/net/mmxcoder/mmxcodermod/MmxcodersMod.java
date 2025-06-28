package net.mmxcoder.mmxcodermod;

import net.fabricmc.api.ModInitializer;

import net.mmxcoder.mmxcodermod.block.ModBlocks;
import net.mmxcoder.mmxcodermod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MmxcodersMod implements ModInitializer {
	public static final String MOD_ID = "mmxcodermod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItem();
		ModBlocks.registerModBlocks();
	}
}