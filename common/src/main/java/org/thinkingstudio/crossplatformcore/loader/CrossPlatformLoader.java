package org.thinkingstudio.crossplatformcore.loader;

import org.thinkingstudio.crossplatformcore.mods.CrossPlatformMods;
import org.thinkingstudio.crossplatformcore.path.CrossPlatformPath;

import java.nio.file.Path;

public interface CrossPlatformLoader {

    static boolean isModLoaded(String id) {
        return CrossPlatformMods.isModLoaded(id);
    }

    static boolean isDevEnv() {
        return CrossPlatformMods.isDevEnvironment();
    }

    static Path getGameDir() {
        return CrossPlatformPath.getGameDir();
    }

    static Path getConfigDir() {
        return CrossPlatformPath.getConfigDir();
    }

    static Path getModsDir(){
        return CrossPlatformPath.getModsDir();
    }
}