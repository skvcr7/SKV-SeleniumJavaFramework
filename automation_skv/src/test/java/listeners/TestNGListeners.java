package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
//import org.testng.ITestNGListener;
//import org.testng.internal.annotations.ITest;

public class TestNGListeners implements ITestListener{

	@Override
	public void onFinish(ITestContext result) {
		System.out.println("Test started : "+result.getName());
		
	}

	@Override
	public void onStart(ITestContext result) {
		System.out.println("Test succesful : "+result.getName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		//System.out.println("Test failed : "+result.getName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test failed : "+result.getName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test skipped : "+result.getName());
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult context) {
		System.out.println("Test completed : "+context.getName());
		
	}

}
