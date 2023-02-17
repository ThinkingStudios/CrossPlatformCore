package org.thinkingstudio.crossplatformcore;

import dev.architectury.injectables.annotations.ExpectPlatform;
import dev.architectury.platform.Platform;

import java.nio.file.Path;

public class CrossPlatformCoreExpectPlatform {
    /**
     * We can use {@link Platform#getConfigFolder()} but this is just an example of {@link ExpectPlatform}.
     * <p>
     * This must be a <b>public static</b> method. The platform-implemented solution must be placed under a
     * platform sub-package, with its class suffixed with {@code Impl}.
     * <p>
     * Example:
     * Expect: org.thinkingstudio.crossplatformcore.CrossPlatformCoreExpectPlatform#getConfigDirectory()
     * Actual Fabric: org.thinkingstudio.crossplatformcore.fabric.CrossPlatformCoreExpectPlatformImpl#getConfigDirectory()
     * Actual Forge: org.thinkingstudio.crossplatformcore.forge.CrossPlatformCoreExpectPlatformImpl#getConfigDirectory()
     * <p>
     */
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
