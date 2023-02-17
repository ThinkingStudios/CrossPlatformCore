package org.thinkingstudio.crossplatformcore;

import dev.architectury.injectables.annotations.ExpectPlatform;

import java.nio.file.Path;

public class CrossPlatformCoreExpectPlatform {
    @ExpectPlatform
    public static Path getConfigDirectory() {
        // Just throw an error, the content should get replaced at runtime.
        throw new AssertionError();
    }

    @ExpectPlatform
    public static Path getGameDirectory() {
        // Just throw an error, the content should get replaced at runtime.
        throw new AssertionError();
    }

    @ExpectPlatform
    public static Path getModsDirectory() {
        // Just throw an error, the content should get replaced at runtime.
        throw new AssertionError();
    }

    @ExpectPlatform
    public static boolean isModLoaded(String modid){
        // Just throw an error, the content should get replaced at runtime.
        throw new AssertionError();
    }
}
