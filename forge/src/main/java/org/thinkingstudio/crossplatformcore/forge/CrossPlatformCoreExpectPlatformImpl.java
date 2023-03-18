package org.thinkingstudio.crossplatformcore.forge;

import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLLoader;
import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

public class CrossPlatformCoreExpectPlatformImpl {
    public static Path getConfigDir() {
        return FMLPaths.CONFIGDIR.get();
    }

    public static Path getGameDir() {
        return FMLPaths.GAMEDIR.get();
    }

    public static Path getModsDir() {
        return FMLPaths.MODSDIR.get();
    }

    public static boolean isModLoaded(String modid) {
        return ModList.get().isLoaded(modid);
    }

    public static boolean isDevEnvironment() {
        return !FMLLoader.isProduction();
    }
}
