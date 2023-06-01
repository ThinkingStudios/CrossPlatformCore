package org.thinkingstudio.architectured.fabric;

import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;

public class ArchitecturedExpectPlatformImpl {
    public static Path getConfigDir() {
        return FabricLoader.getInstance().getConfigDir();
    }

    public static Path getGameDir() {
        return FabricLoader.getInstance().getGameDir();
    }

    public static Path getModsDir() {
        return FabricLoader.getInstance().getGameDir().resolve("mods");
    }

    public static boolean isModLoaded(String id) {
        return FabricLoader.getInstance().isModLoaded(id);
    }

    public static boolean isDevEnvironment() {
        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }



}
