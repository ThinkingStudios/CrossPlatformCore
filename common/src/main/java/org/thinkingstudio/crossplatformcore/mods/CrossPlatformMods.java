package org.thinkingstudio.crossplatformcore.mods;

import org.thinkingstudio.crossplatformcore.loader.CrossPlatformLoader;

//TODO: Deprecated in 1.0.2 or later
public class CrossPlatformMods {
    public static boolean isModLoaded(String id) {
        return CrossPlatformLoader.isModLoaded(id);
    }

    public static boolean isDevEnvironment() {
        return CrossPlatformLoader.isDevEnv();
    }
}
