package org.thinkingstudio.crossplatformcore.mods;

import org.thinkingstudio.crossplatformcore.CrossPlatformCoreExpectPlatform;

//TODO: Deprecated in 1.0.2 or later
public class CrossPlatformMods {
    public static boolean isModLoaded(String modid) {
        return CrossPlatformCoreExpectPlatform.isModLoaded(modid);
    }

    public static boolean isDevEnvironment() {
        return CrossPlatformCoreExpectPlatform.isDevEnvironment();
    }
}
