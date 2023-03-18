package org.thinkingstudio.crossplatformcore.path;

import org.thinkingstudio.crossplatformcore.loader.CrossPlatformLoader;

import java.nio.file.Path;

//TODO: Deprecated in 1.0.2 or later
public class CrossPlatformPath {
    public static Path getGameDir() {
        return CrossPlatformLoader.getGameDir();
    }
    public static Path getConfigDir() {
        return CrossPlatformLoader.getConfigDir();
    }
    public static Path getModsDir(){
        return CrossPlatformLoader.getModsDir();
    }
}
