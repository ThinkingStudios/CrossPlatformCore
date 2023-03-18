package org.thinkingstudio.crossplatformcore;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CrossPlatformCore {
    public static final String MOD_ID = "crossplatformcore";
    public static final String MOD_NAME = "CrossPlatformCore";
    public static final Logger LOGGER = LogManager.getLogger();

    public static void init() {
        LOGGER.warn(MOD_NAME + "is still in experimental stage, if you have any issues about this mod please go to https://github.com/TexTrueStudio/CrossPlatformCore/issues for feedback.");
    }
}