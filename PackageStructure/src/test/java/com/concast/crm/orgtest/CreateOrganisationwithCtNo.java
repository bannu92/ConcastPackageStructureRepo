package com.concast.crm.orgtest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import com.concast.crm.ObjectRepositoryUtility.CreateNewOrganisationPage;
import com.concast.crm.ObjectRepositoryUtility.HomPage;
import com.concast.crm.ObjectRepositoryUtility.LoginPage;
import com.concast.crm.ObjectRepositoryUtility.OrganisationInfoPage;
import com.concast.crm.ObjectRepositoryUtility.OrganisationsPage;
import com.concast.crm.generic.fileutility.ExcelUtility;
import com.concast.crm.generic.fileutility.FileUtility;
import com.concast.crm.generic.webdriverutility.WebDriverUtility;
import com.concast.generic.JavaUtility.JavaUtility;

public class CreateOrganisationwithCtNo {
	public static void main(String[] args) throws Exception {
        JavaUtility ju=new JavaUtility();
		FileUtility fiu=new FileUtility();
WebDriverUtility wdu=new WebDriverUtility();
		String BROWSER = fiu.getDataFromPropertiesFile("browser");
		String URL = fiu.getDataFromPropertiesFile("url");
		String USN = fiu.getDataFromPropertiesFile("username");
		String PWD = fiu.getDataFromPropertiesFile("password");
		ExcelUtility eu=new ExcelUtility();
		String orgname=eu.getDataFromExcel("contact", 1, 2)+ju.getRandomNumber();
		String phno=eu.getDataFromExcel("contact", 1, 7);
		       
		  WebDriver driver=null;
		  if(BROWSER.equals("chrome"))
		  {
			  driver =new ChromeDriver();
		  }
		  else if(BROWSER.equals("edge"))
		  {
			  driver=new EdgeDriver();
		  }
		  else
		  {
			  driver=new ChromeDriver();
		  }
	wdu.waitForPageToLoad(driver);
	wdu.maximize(driver);
		  driver.get(URL); 
        LoginPage l=new LoginPage(driver);
        l.loginToapp("admin", "admin");
        OrganisationsPage o=new OrganisationsPage(driver);
        OrganisationInfoPage oip=new OrganisationInfoPage(driver);
		HomPage h=new HomPage(driver);
		h.getOrganisationstab().click();
		 o.getCreateorganisationbutton().click();
		CreateNewOrganisationPage cnop=new CreateNewOrganisationPage(driver);
		 cnop.getOrganisationEdit().sendKeys(orgname);
		  o.getPhoneedit().sendKeys(phno);
		  
		 	  
		  o.getSavebtn().click();
		  
String actno=	oip.getActphnoedit().getText();

	if(actno.contains(phno))
	{
	System.out.println(phno +" "+ "is verified");	
	}
	else
	{
		System.out.println(phno +" " + "is not verified");
	}
	


}
}