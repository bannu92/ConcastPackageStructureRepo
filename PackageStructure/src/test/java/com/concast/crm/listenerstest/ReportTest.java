package com.concast.crm.listenerstest;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportTest {
	ExtentReports report;
	@BeforeSuite
	public void configBS()
	{
		//spark report config
				ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report.html");
				spark.config().setDocumentTitle("CRM Document");
				spark.config().setReportName("CRM report");
				spark.config().setTheme(Theme.STANDARD);
				//add environment information and create test
				report=new ExtentReports();
				report.attachReporter(spark);
				report.setSystemInfo("OS", "windows 11");
				report.setSystemInfo("Btowser", "chrome-64");		

	}
	@AfterSuite
	public void configAS()
	{
		report.flush();
	}
@Test
public void createTest() {

	ExtentTest test=report.createTest("CreateTest");
	test.log(Status.INFO,"login to application");
	test.log(Status.INFO,"navigate to contact page");
	test.log(Status.INFO,"create contact");
	if("hdfc".equals("hdfc"))
	{
		test.log(Status.PASS,"contact is created");
	}
	else
	{
		test.log(Status.FAIL,"contact is not created");
	}
}
	@Test
	public void createContactWithOrg()
	{
		ExtentTest test=report.createTest("createContactWithOrg");
		test.log(Status.INFO,"login to application");
		test.log(Status.INFO,"navigate to contact page");
		test.log(Status.INFO,"create contact");
		if("hdfc".equals("hdfc"))
		{
			test.log(Status.PASS,"contact is created");
		}
		else
		{
			test.log(Status.FAIL,"contact is not created");
		}
		
	}
@Test
public void createContactWithPhNo()
{
	WebDriver driver=new ChromeDriver();
	driver.get("http://localhost:8888");
    TakesScreenshot ts=(TakesScreenshot) driver;
    String file=ts.getScreenshotAs(OutputType.BASE64);
    
	ExtentTest test=report.createTest("createContactWithPhNo");
	test.log(Status.INFO,"login to application");
	test.log(Status.INFO,"navigate to contact page");
	test.log(Status.INFO,"create contact");
	if("hdfc".equals("hfc"))
	{
		test.log(Status.PASS,"contact is created");
	}
	else
	{
		test.addScreenCaptureFromBase64String(file,"ErrorFile");
	}
	driver.close();
}
	
}

