package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import practiceProjects.p.BaseClass;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {


    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        WebDriver driver = ((BaseClass) testClass).driver; 
        ScreenshotUtil.captureScreenshot(driver, result.getName());
    }

}
