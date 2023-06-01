package org.thinkingstudio.architectured.fabric;

import org.thinkingstudio.architectured.Architectured;
import net.fabricmc.api.ModInitializer;

public class ArchitecturedFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Architectured.init();
    }
}
