package org.thinkingstudio.crossplatformcore.path;

import org.thinkingstudio.crossplatformcore.CrossPlatformCoreExpectPlatform;

import java.nio.file.Path;

//TODO: Deprecated in 1.0.2 or later
public class CrossPlatformPath {
    public static Path getGameDir() {
        return CrossPlatformCoreExpectPlatform.getGameDir();
    }
    public static Path getConfigDir() {
        return CrossPlatformCoreExpectPlatform.getConfigDir();
    }
    public static Path getModsDir(){
        return CrossPlatformCoreExpectPlatform.getModsDir();
    }
}
