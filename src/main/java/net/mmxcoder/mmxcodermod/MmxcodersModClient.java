package net.mmxcoder.mmxcodermod;

import net.fabricmc.api.ClientModInitializer;
import net.mmxcoder.mmxcodermod.client.OreXray;

public class MmxcodersModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        OreXray.register();
    }
}
