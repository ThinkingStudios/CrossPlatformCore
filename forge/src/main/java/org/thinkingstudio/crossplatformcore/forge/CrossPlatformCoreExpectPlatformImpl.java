package org.thinkingstudio.crossplatformcore.forge;

import net.minecraftforge.fml.ModList;
import org.thinkingstudio.crossplatformcore.CrossPlatformCoreExpectPlatform;
import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

public class CrossPlatformCoreExpectPlatformImpl {
    /**
     * This is our actual method to {@link CrossPlatformCoreExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }

    public static Path getGameDirectory() {
        return FMLPaths.GAMEDIR.get();
    }

    public static Path getModsDirectory() {
        return FMLPaths.MODSDIR.get();
    }

    public static boolean isModLoaded(String modid) {
        return ModList.get().isLoaded(modid);
    }
}
