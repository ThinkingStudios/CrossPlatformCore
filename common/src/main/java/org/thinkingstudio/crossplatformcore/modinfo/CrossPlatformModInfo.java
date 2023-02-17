package org.thinkingstudio.crossplatformcore.modinfo;

import org.thinkingstudio.crossplatformcore.CrossPlatformCoreExpectPlatform;

public class CrossPlatformModInfo {
    public static boolean isModLoaded(String modid) {
        return CrossPlatformCoreExpectPlatform.isModLoaded(modid);
    }
}
