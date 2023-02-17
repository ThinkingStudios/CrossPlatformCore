package org.thinkingstudio.crossplatformcore.path;

import org.thinkingstudio.crossplatformcore.CrossPlatformCoreExpectPlatform;

import java.nio.file.Path;

public class CrossPlatformPath {
    public static Path getGameDir() {
        return CrossPlatformCoreExpectPlatform.getGameDirectory();
    }
    public static Path getConfigDir() {
        return CrossPlatformCoreExpectPlatform.getConfigDirectory();
    }
    public static Path getModsDir(){
        return CrossPlatformCoreExpectPlatform.getModsDirectory();
    }
}
