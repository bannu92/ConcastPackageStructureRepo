package com.concast.crm.orgtest;

import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;

import com.concast.crm.ObjectRepositoryUtility.CreateNewOrganisationPage;
import com.concast.crm.ObjectRepositoryUtility.HomPage;
import com.concast.crm.ObjectRepositoryUtility.LoginPage;
import com.concast.crm.ObjectRepositoryUtility.OrganisationInfoPage;
import com.concast.crm.ObjectRepositoryUtility.OrganisationsPage;
import com.concast.crm.ObjectRepositoryUtility.LoginPage;
import com.concast.crm.generic.fileutility.ExcelUtility;
import com.concast.crm.generic.fileutility.FileUtility;
import com.concast.crm.generic.webdriverutility.WebDriverUtility;
import com.concast.generic.JavaUtility.JavaUtility;

public class CreateOrganisationTest {
	public static void main(String[] args) throws Exception {
        JavaUtility ju=new JavaUtility();
		FileUtility fiu=new FileUtility();
		ExcelUtility eu=new ExcelUtility();
		WebDriverUtility wdu=new WebDriverUtility();
		String BROWSER = fiu.getDataFromPropertiesFile("browser");
		String URL = fiu.getDataFromPropertiesFile("url");
		String USN = fiu.getDataFromPropertiesFile("username");
		String PWD = fiu.getDataFromPropertiesFile("password");
		
		String orgname=eu.getDataFromExcel("contact", 1, 2)+ju.getRandomNumber();
       
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
		System.out.println(orgname);  
		  driver.get(URL); 
		  LoginPage l= new LoginPage(driver);
		  l.loginToapp("admin", "admin");
	HomPage h=new HomPage(driver);
	h.getOrganisationstab().click();
     OrganisationsPage o=new OrganisationsPage(driver);
     o.getCreateorganisationbutton().click();
	CreateNewOrganisationPage cnop=new CreateNewOrganisationPage(driver);
	cnop.getOrganisationEdit().sendKeys(orgname);
	o.getSavebtn().click();
	OrganisationInfoPage oip=new OrganisationInfoPage(driver);
	String orgheadname=oip.getHeaderinfo().getText();
	
	if (orgheadname.contains(orgname))
	{
		System.out.println(orgname + " "+"is verified");
	}
	else
	{
		System.out.println(orgname + " "+ "is not verified");
	}
	l.logout();
	}
}
