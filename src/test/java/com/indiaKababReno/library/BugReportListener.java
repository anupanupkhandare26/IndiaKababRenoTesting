package com.indiaKababReno.library;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class BugReportListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult result) {
        super.onTestFailure(result);
        String testCaseName = result.getMethod().getMethodName();
        String errorMessage = result.getThrowable().getMessage();
        BugReportUtility.reportBug(System.getProperty("user.dir")+"//Reports//BugReport.xlsx", testCaseName, errorMessage);
    }
}
