package org.thinkingstudio.crossplatformcore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CrossPlatformCore {
    public static final String MOD_ID = "crossplatformcore";
    public static final String MOD_NAME = "CrossPlatformCore";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public static void init() {
        LOGGER.warn(MOD_NAME + "is still in experimental stage, if you have any questions about this mod please go to https://github.com/TexTrueStudio/CrossPlatformCore/issues for feedback.");
    }
}