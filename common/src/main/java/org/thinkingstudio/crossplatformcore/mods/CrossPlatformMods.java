package org.thinkingstudio.crossplatformcore.mods;

import org.thinkingstudio.crossplatformcore.loader.CrossPlatformLoader;

//TODO: Deprecated in 1.0.2 or later
public class CrossPlatformMods {
    public static boolean isModLoaded(String modid) {
        return CrossPlatformLoader.isModLoaded(modid);
    }

    public static boolean isDevEnvironment() {
        return CrossPlatformLoader.isDevEnv();
    }
}
