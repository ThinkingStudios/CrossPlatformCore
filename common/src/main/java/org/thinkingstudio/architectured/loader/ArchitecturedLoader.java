package org.thinkingstudio.architectured.loader;

import org.thinkingstudio.architectured.ArchitecturedExpectPlatform;

import java.nio.file.Path;

public class ArchitecturedLoader {

    static boolean isModLoaded(String id) {
        return ArchitecturedExpectPlatform.isModLoaded(id);
    }

    static boolean isDevEnv() {
        return ArchitecturedExpectPlatform.isDevEnvironment();
    }

    static Path getGameDir() {
        return ArchitecturedExpectPlatform.getGameDir();
    }

    static Path getConfigDir() {
        return ArchitecturedExpectPlatform.getConfigDir();
    }

    static Path getModsDir(){
        return ArchitecturedExpectPlatform.getModsDir();
    }
}
