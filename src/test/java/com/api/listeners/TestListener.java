package com.api.listeners;

import com.api.utils.ExtentManager;
import com.api.utils.ExtentTestManager;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static final Logger logger = LogManager.getLogger(TestListener.class);

    public void onStart(ITestContext context) {

        logger.info("Test Suite Started!!!");

    }
    public void onTestStart(ITestResult result) {
        ExtentTestManager.setTest(ExtentManager.getInstance().createTest(result.getMethod().getMethodName(), result.getMethod().getDescription()));
        ExtentTestManager.getTest()
                .log(Status.INFO, "Test started: " + result.getMethod().getMethodName());
        logger.info("Started!!"+ result.getMethod().getMethodName());
        logger.info("Description!!"+ result.getMethod().getDescription());
    }

    public void onTestSuccess(ITestResult result) {
        ExtentTestManager.getTest()
                .log(Status.PASS, "Test passed: " + result.getMethod().getMethodName());
        logger.info("Passed!!"+ result.getMethod().getMethodName());
    }

    public void onTestFailure(ITestResult result) {
        ExtentTestManager.getTest()
                .log(Status.FAIL, "Test failed: " + result.getMethod().getMethodName());

        ExtentTestManager.getTest()
                .log(Status.FAIL, result.getThrowable());
        logger.error("Failed!!"+ result.getMethod().getMethodName());
    }

    public void onTestSkipped(ITestResult result) {
        ExtentTestManager.getTest()
                .log(Status.SKIP, "Test skipped: " + result.getMethod().getMethodName());
        logger.info("Skipped!!"+ result.getMethod().getMethodName());
    }
    public void onFinish(ITestContext context) {
        ExtentManager.getInstance().flush();
        ExtentTestManager.removeTest();
        logger.info("Test Suite Completed!!!");
    }
}
