package com.concast.crm.organisationtest;

import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.concast.crm.ObjectRepositoryUtility.CreateNewOrganisationPage;
import com.concast.crm.ObjectRepositoryUtility.HomPage;
import com.concast.crm.ObjectRepositoryUtility.LoginPage;
import com.concast.crm.ObjectRepositoryUtility.OrganisationInfoPage;
import com.concast.crm.ObjectRepositoryUtility.OrganisationsPage;
import com.concast.crm.generic.fileutility.ExcelUtility;
import com.concast.crm.generic.fileutility.FileUtility;
import com.concast.crm.generic.webdriverutility.UtilityClassObject;
import com.concast.crm.generic.webdriverutility.WebDriverUtility;
import com.concast.generic.JavaUtility.JavaUtility;

public class Vtigerorg {
	@Test
	public void screenshot() throws Exception
	{
		FileUtility fu=new FileUtility();
		WebDriverUtility wdu=new WebDriverUtility();
		ExcelUtility eu=new ExcelUtility();
		WebDriver driver=new ChromeDriver();
		 wdu.waitForPageToLoad(driver);
		 wdu.maximize(driver);
		driver.get("http://localhost:8888/");
		 LoginPage l= new LoginPage(driver);
		  l.loginToapp("admin", "admin");
		  HomPage h=new HomPage(driver);
		  h.getOrganisationstab().click();
		   OrganisationsPage o=new OrganisationsPage(driver);
		   o.getCreateorganisationbutton().click();
		  CreateNewOrganisationPage cnop=new CreateNewOrganisationPage(driver);
		  String orgname=eu.getDataFromExcel("Sheet1", 1, 2);
		  cnop.getOrganisationEdit().sendKeys(orgname);
		  o.getSavebtn().click();
OrganisationInfoPage oip=new OrganisationInfoPage(driver);
String orgheadname=oip.getHeaderinfo().getText();
Assert.assertEquals(false, orgheadname.contains(orgname));
File screenshot=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
FileHandler.copy(screenshot,new File("./ScreenShot/failure.png"));


	}




}



