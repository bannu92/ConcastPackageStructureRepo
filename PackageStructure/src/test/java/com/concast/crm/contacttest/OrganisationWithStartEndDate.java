package com.concast.crm.contacttest;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.concast.crm.ObjectRepositoryUtility.ContactsInfoPage;
import com.concast.crm.ObjectRepositoryUtility.ContactsPage;
import com.concast.crm.ObjectRepositoryUtility.CreateNewContactPage;
import com.concast.crm.ObjectRepositoryUtility.HomPage;
import com.concast.crm.ObjectRepositoryUtility.LoginPage;
import com.concast.crm.generic.fileutility.ExcelUtility;
import com.concast.crm.generic.fileutility.FileUtility;
import com.concast.crm.generic.webdriverutility.WebDriverUtility;
import com.concast.generic.JavaUtility.JavaUtility;

public class OrganisationWithStartEndDate {
public static void main(String[] args) throws Exception {
	JavaUtility ju=new JavaUtility();
	FileUtility fiu=new FileUtility();
  WebDriverUtility wdu=new WebDriverUtility();
	String BROWSER = fiu.getDataFromPropertiesFile("browser");
	String URL = fiu.getDataFromPropertiesFile("url");
	String USN = fiu.getDataFromPropertiesFile("username");
	String PWD = fiu.getDataFromPropertiesFile("password");
	ExcelUtility eu=new ExcelUtility();        
	        String lastname=eu.getDataFromExcel("contact", 4, 9)+ju.getRandomNumber();
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
	HomPage h=new HomPage(driver);
	 h.getContactstab().click();
	 ContactsPage cp=new ContactsPage(driver); 
	 cp.getCreatecontactbtn().click();
	  String startdate=ju.getSystemDateYYYYDDMM();
	 String enddate=ju.getRequiredDateYYYYDDMM(30);
	  
	  CreateNewContactPage cncp=new CreateNewContactPage(driver);
	  cncp.getLastnameedit().sendKeys(lastname);
	 cncp.getStartdateedit().clear();
	  cncp.getStartdateedit().sendKeys(startdate);
	  cncp.getEnddateedit().clear();
	  cncp.getEnddateedit().sendKeys(enddate);
	  cncp.getSavebtn().click();
	 ContactsInfoPage cip=new ContactsInfoPage(driver);
String stdt=cip.getStartdate().getText();
if(stdt.contains(startdate))
{
	System.out.println(startdate + " " +"is verified====pass");
}
else
{
	System.out.println(startdate + " "+ "is not verified");
}
String reqdate=cip.getEnddate().getText();
if(reqdate.contains(enddate))
{
	System.out.println(enddate + " "+"is verified====pass");
}
else
{
	System.out.println(enddate + " "+"is not verified ======fail" );
}
}
}

