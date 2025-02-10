package genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ListenerImplimentation implements ITestListener {

	ExtentReports ereport;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname + "-------> started");

		test = ereport.createTest(methodname);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname + "-------> Success");
		test.log(Status.PASS, methodname + "---sucess");
		test.log(Status.INFO, result.getThrowable());

	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname + "-------> failed");
		test.log(Status.FAIL, methodname + "---failed");
		test.log(Status.INFO, result.getThrowable());

		WebDriverUtility wutil = new WebDriverUtility();
		JavaUtility jutil = new JavaUtility();

		String screenshot = methodname + "-" + jutil.toGetSystemDateAndTime();
		try {
			String path = wutil.toTakeScreenShot(BaseClass.sDriver, screenshot);
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname + "-------> skipped");
		test.log(Status.SKIP, methodname + "---SKIPPED");
		test.log(Status.INFO, result.getThrowable());

	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("shuit execution started");

		ExtentSparkReporter espark = new ExtentSparkReporter(
				"./ExtentReport/Report-" + new JavaUtility().toGetSystemDateAndTime());

		ereport = new ExtentReports();
		ereport.attachReporter(espark);
		ereport.setSystemInfo("base url", " https:/localhost:8888/");
		ereport.setSystemInfo("base browser", " chrome");
		ereport.setSystemInfo("username", " admin");
		ereport.setSystemInfo("password", " password");

	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("shuit execution finish");
		ereport.flush();
	}

}
