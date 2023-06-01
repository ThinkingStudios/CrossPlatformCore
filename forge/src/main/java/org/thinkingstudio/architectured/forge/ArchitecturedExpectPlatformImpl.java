package org.thinkingstudio.architectured.forge;;

import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLLoader;
import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

public class ArchitecturedExpectPlatformImpl {
    public static Path getConfigDir() {
        return FMLPaths.FMLCONFIG.get();
    }

    public static Path getGameDir() {
        return FMLPaths.GAMEDIR.get();
    }

    public static Path getModsDir() {
        return FMLPaths.MODSDIR.get();
    }

    public static boolean isModLoaded(String id) {
            return ModList.get().isLoaded(id);
    }

    public static boolean isDevEnvironment() {
        return !FMLLoader.isProduction();
    }


}
