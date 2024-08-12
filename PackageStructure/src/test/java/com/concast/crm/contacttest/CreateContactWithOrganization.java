package com.concast.crm.contacttest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.concast.crm.ObjectRepositoryUtility.ContactsInfoPage;
import com.concast.crm.ObjectRepositoryUtility.ContactsPage;
import com.concast.crm.ObjectRepositoryUtility.ContactsSearchPage;
import com.concast.crm.ObjectRepositoryUtility.CreateNewContactPage;
import com.concast.crm.ObjectRepositoryUtility.CreateNewOrganisationPage;
import com.concast.crm.ObjectRepositoryUtility.HomPage;
import com.concast.crm.ObjectRepositoryUtility.LoginPage;
import com.concast.crm.ObjectRepositoryUtility.OrganisationInfoPage;
import com.concast.crm.ObjectRepositoryUtility.OrganisationsPage;
import com.concast.crm.generic.fileutility.ExcelUtility;
import com.concast.crm.generic.fileutility.FileUtility;
import com.concast.crm.generic.webdriverutility.WebDriverUtility;
import com.concast.generic.JavaUtility.JavaUtility;

public class CreateContactWithOrganization {
	public static void main(String[] args) throws Exception {
       JavaUtility ju=new JavaUtility(); 
       FileUtility fiu=new FileUtility();
		WebDriverUtility wdu=new WebDriverUtility();
       String BROWSER = fiu.getDataFromPropertiesFile("browser");
		String URL = fiu.getDataFromPropertiesFile("url");
		String USN = fiu.getDataFromPropertiesFile("username");
		String PWD = fiu.getDataFromPropertiesFile("password");
		
		ExcelUtility eu=new ExcelUtility();        
		        String orgname=eu.getDataFromExcel("contact", 1, 8)+ju.getRandomNumber();
		        String lastname=eu.getDataFromExcel("contact", 1, 9);
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
		  h.getOrganisationstab().click();
		  ContactsPage cp=new ContactsPage(driver);
		  OrganisationsPage o=new OrganisationsPage(driver);
		  o.getCreateorganisationbutton().click();
		  CreateNewOrganisationPage cnop=new CreateNewOrganisationPage(driver);
		  cnop.getOrganisationEdit().sendKeys(orgname);
	OrganisationInfoPage oip=new OrganisationInfoPage(driver);
		  o.getSavebtn().click();
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		  String info=oip.getHeaderinfo().getText();
		 if(info.contains(orgname))
		 {
			 System.out.println(orgname + "is created");
		 }
		 else
		 {
			 System.out.println(orgname + " is not created");
		 }
		  h.getContactstab().click();
		  cp.getCreatecontactbtn().click();
		  cncp.getLastnameedit().sendKeys(lastname);
	 	  cncp.getOrganisationbtn().click();
	 	  wdu.switchToNewBrowserTab(driver, "module=Accounts");
	ContactsSearchPage csp=new ContactsSearchPage(driver);
	 	  csp.getSearchedit().sendKeys(orgname);
	 	  csp.getSearchbtn().click();
	 	 driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
	 	wdu.switchToNewBrowserTab(driver, "Contacts&action");
	 	 
	 	 cncp.getSavebtn().click();
	 	 ContactsInfoPage cip=new ContactsInfoPage(driver); 
	 	 info=cip.getConheaderinfo().getText();
		 if(info.contains(orgname))
		 {
			 System.out.println(orgname + "is created");
		 }
		 else
		 {
			 System.out.println(orgname + "is not created");
		 }
		  
     String actualorgname=cip.getOrgname().getText();

	if(actualorgname.trim().contains(orgname))
	{
	System.out.println(orgname +" "+ "is created");	
	}
	else
	{
		System.out.println(orgname +" " + "is not created");
	}
	}
}
