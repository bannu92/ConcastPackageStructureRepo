package com.concast.crm.ListenerUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.concast.crm.BaseClass.BaseClass;
import com.concast.crm.generic.webdriverutility.UtilityClassObject;

import lombok.experimental.UtilityClass;

public class ListImpClass implements ITestListener,ISuiteListener {

	public static ExtentReports report;
	public static ExtentTest test; // this static variable can not be shared among multiple threads during parallel exe hence use UtilityObjectClass
	
	@Override
	public void onStart(ISuite suite) {
	
		//Spark report configuration
		String timeStamp=new Date().toString().replace(" ","_").replace(":","_");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report_"+timeStamp+".html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		//add env info and create test
		 report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "windows-10");
		report.setSystemInfo("BROWSER", "edge");
		
	}

	

	@Override
	public void onTestStart(ITestResult result) {
	
		String testName=result.getMethod().getMethodName();
		 test = report.createTest(testName);
		 UtilityClassObject.setTest(test);   // for parallel exe
		test.log(Status.INFO,testName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName=result.getMethod().getMethodName();
		test.log(Status.PASS,testName+"======>PASSED<=====");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
	
		String testName=result.getMethod().getMethodName();
		String timeStamp=new Date().toString().replace(" ","_").replace(":","_");
		TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
		String filePath = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromPath(filePath, testName+"_"+timeStamp);
		test.log(Status.FAIL,testName+"======>FAILED<=====");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	
		String testName=result.getMethod().getMethodName();
		test.log(Status.SKIP,testName+"======>Skipped<=====");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}
	

	@Override
	public void onFinish(ISuite suite) {
	
		
		report.flush(); // mandatory to take report back up
		
	}
	
}