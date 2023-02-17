package org.thinkingstudio.crossplatformcore.forge;

import me.shedaniel.architectury.platform.forge.EventBuses;
import org.thinkingstudio.crossplatformcore.CrossPlatformCore;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(CrossPlatformCore.MOD_ID)
public class CrossPlatformCoreModForge {
    public CrossPlatformCoreModForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(CrossPlatformCore.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        CrossPlatformCore.init();
    }
}
