package org.thinkingstudio.crossplatformcore.fabric;

import org.thinkingstudio.crossplatformcore.CrossPlatformCore;
import net.fabricmc.api.ModInitializer;

public class CrossPlatformCoreFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        CrossPlatformCore.init();
    }
}
