package com.concast.crm.contacttest;

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

import com.concast.crm.BaseClass.BaseClass;
import com.concast.crm.ObjectRepositoryUtility.ContactsInfoPage;
import com.concast.crm.ObjectRepositoryUtility.ContactsPage;
import com.concast.crm.ObjectRepositoryUtility.CreateNewContactPage;
import com.concast.crm.ObjectRepositoryUtility.HomPage;
import com.concast.crm.ObjectRepositoryUtility.LoginPage;
import com.concast.crm.generic.fileutility.ExcelUtility;
import com.concast.crm.generic.fileutility.FileUtility;
import com.concast.crm.generic.webdriverutility.WebDriverUtility;
import com.concast.generic.JavaUtility.JavaUtility;
import com.practice.pom.repository.BaseClasss;
class CreateContactTest{
public static void main(String[] args) throws Exception {
    JavaUtility ju=new JavaUtility(); 
    FileUtility fiu=new FileUtility();
	ExcelUtility eu=new ExcelUtility();
WebDriverUtility wdu=new WebDriverUtility();
	String BROWSER = fiu.getDataFromPropertiesFile("browser");
	String URL = fiu.getDataFromPropertiesFile("url");
	String USN = fiu.getDataFromPropertiesFile("username");
	String PWD = fiu.getDataFromPropertiesFile("password");
	
	        
	        String lastname=eu.getDataFromExcel("contact", 1, 9)+ju.getRandomNumber();
	       
	       
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

		  ContactsPage cp=new ContactsPage(driver);
		  cp.getCreatecontactbtn().click();
	 
	  CreateNewContactPage cncp=new CreateNewContactPage(driver);
	  cncp.getLastnameedit().sendKeys(lastname);
	 	  
	 cncp.getSavebtn().click();
	  ContactsInfoPage cip=new ContactsInfoPage(driver);
     String actln=cip.getConheaderinfo().getText();

if(actln.contains(lastname))
{
System.out.println(lastname +" "+ "is verified");	
}
else
{
	System.out.println(lastname +" " + "is not verified");
}





}
}
