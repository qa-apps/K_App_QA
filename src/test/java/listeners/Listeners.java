package listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import pageObjects.MainPage;

public class Listeners implements ITestListener {
    private static Logger logger = LogManager.getLogger(MainPage.class);
    @Override
    public void onTestStart(ITestResult iTestResult) {
        logger.info(iTestResult.getName() + " Started");

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        logger.debug("++++++Hey we here +++ "+iTestResult.getName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("++++++Meow we here +++ "+iTestResult.getName());
    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
