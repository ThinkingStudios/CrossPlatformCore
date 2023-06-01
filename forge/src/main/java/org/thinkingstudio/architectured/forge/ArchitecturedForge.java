package org.thinkingstudio.architectured.forge;

import dev.architectury.platform.forge.EventBuses;
import org.thinkingstudio.architectured.Architectured;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Architectured.MOD_ID)
public class ArchitecturedForge {
    public ArchitecturedForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(Architectured.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        Architectured.init();
    }
}
