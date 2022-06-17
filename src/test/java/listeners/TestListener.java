package listeners;

import org.testng.IResultMap;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.logging.Logger;

public class TestListener implements ITestListener {

    final static Logger logger = Logger.getLogger(String.valueOf(TestListener.class));

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("The method " + result.getMethod().getMethodName() + " has started running now.");
    }


    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("The Test" + result.getName() + "is passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.info("One more failure with test " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.info("The test" + result.getName() + "was skipped");
    }


    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        logger.info("The test was failed cause of timeout");
    }

    @Override
    public void onStart(ITestContext result) {
        logger.info("The tests start running. God bless us!");
    }

    @Override
    public void onFinish(ITestContext result) {
        logger.info("Well! It was expected! \n");
        logger.info("Tests passed: " + result.getPassedTests());
        logger.info("Tests failed: " + result.getFailedTests());
    }


}

