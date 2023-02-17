package org.thinkingstudio.crossplatformcore.fabric;

import org.thinkingstudio.crossplatformcore.CrossPlatformCoreExpectPlatform;
import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;

public class CrossPlatformCoreExpectPlatformImpl {
    /**
     * This is our actual method to {@link CrossPlatformCoreExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }

    public static Path getGameDirectory() {
        return FabricLoader.getInstance().getGameDir();
    }

    public static Path getModsDirectory() {
        return FabricLoader.getInstance().getGameDir().resolve("mods");
    }

    public static boolean isModLoaded(String modid) {
        return FabricLoader.getInstance().isModLoaded(modid);
    }

}
