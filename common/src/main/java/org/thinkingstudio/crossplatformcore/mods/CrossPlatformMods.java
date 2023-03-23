package org.thinkingstudio.crossplatformcore.mods;

import org.thinkingstudio.crossplatformcore.CrossPlatformCoreExpectPlatform;

//TODO: Deprecate in 1.0.2 or later
public class CrossPlatformMods {
    public static boolean isModLoaded(String id) {
        return CrossPlatformCoreExpectPlatform.isModLoaded(id);
    }

    public static boolean isDevEnvironment() {
        return CrossPlatformCoreExpectPlatform.isDevEnvironment();
    }
}
