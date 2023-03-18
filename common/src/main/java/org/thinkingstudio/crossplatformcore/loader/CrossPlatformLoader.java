package org.thinkingstudio.crossplatformcore.loader;

import org.thinkingstudio.crossplatformcore.CrossPlatformCoreExpectPlatform;

import java.nio.file.Path;

public interface CrossPlatformLoader {

    static boolean isModLoaded(String id) {
        return CrossPlatformCoreExpectPlatform.isModLoaded(id);
    }

    static boolean isDevEnv() {
        return CrossPlatformCoreExpectPlatform.isDevEnvironment();
    }

    static Path getGameDir() {
        return CrossPlatformCoreExpectPlatform.getGameDir();
    }

    static Path getConfigDir() {
        return CrossPlatformCoreExpectPlatform.getConfigDir();
    }

    static Path getModsDir(){
        return CrossPlatformCoreExpectPlatform.getModsDir();
    }
}
