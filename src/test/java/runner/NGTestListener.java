package runner;

import Base.ExtendReportUtil;
import com.aventstack.extentreports.gherkin.model.Feature;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

import static Base.BaseUtil.features;
public class NGTestListener implements ITestListener {
    ExtendReportUtil extendReportUtil = new ExtendReportUtil();
    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("On test start");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("On test Sucess");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("On test Failure");
        try {
            extendReportUtil.ExtendReportScreenshot();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("On test skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("On test percentage");
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("On start");
        extendReportUtil.ExtendReport();
        //ToDo: Feature - Hard coding the feature name
        features = extendReportUtil.extent.createTest(Feature.class, "Login Feature");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("On finish");
        extendReportUtil.FlushReport();
    }
}
