package org.thinkingstudio.crossplatformcore;

import dev.architectury.injectables.annotations.ExpectPlatform;

import java.nio.file.Path;

public class CrossPlatformCoreExpectPlatform {
    @ExpectPlatform
    public static Path getConfigDir() {
        // Just throw an error, the content should get replaced at runtime.
        throw new AssertionError();
    }

    @ExpectPlatform
    public static Path getGameDir() {
        // Just throw an error, the content should get replaced at runtime.
        throw new AssertionError();
    }

    @ExpectPlatform
    public static Path getModsDir() {
        // Just throw an error, the content should get replaced at runtime.
        throw new AssertionError();
    }

    @ExpectPlatform
    public static boolean isModLoaded(String id){
        // Just throw an error, the content should get replaced at runtime.
        throw new AssertionError();
    }

    @ExpectPlatform
    public static boolean isDevEnvironment(){
        // Just throw an error, the content should get replaced at runtime.
        throw new AssertionError();
    }
}
