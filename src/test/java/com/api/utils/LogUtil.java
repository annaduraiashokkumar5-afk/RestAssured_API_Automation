package com.api.utils;

import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogUtil {
    private static final Logger log = LogManager.getLogger(LogUtil.class);

    public static void info(String message) {
        log.info(message);

        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().log(Status.INFO, message);
        }
    }

    public static void pass(String message) {
        log.info(message);

        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().log(Status.PASS, message);
        }
    }

    public static void fail(String message) {
        log.error(message);

        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().log(Status.FAIL, message);
        }
    }

    public static void warning(String message) {
        log.warn(message);

        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().log(Status.WARNING, message);
        }
    }
}
