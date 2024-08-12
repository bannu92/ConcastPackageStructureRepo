package com.concast.crm.orgbasetest;

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
import org.testng.annotations.Test;

import com.concast.crm.BaseClass.BaseClass;
import com.concast.crm.ObjectRepositoryUtility.CreateNewOrganisationPage;
import com.concast.crm.ObjectRepositoryUtility.HomPage;
import com.concast.crm.ObjectRepositoryUtility.LoginPage;
import com.concast.crm.ObjectRepositoryUtility.OrganisationInfoPage;
import com.concast.crm.ObjectRepositoryUtility.OrganisationsPage;
import com.concast.crm.generic.fileutility.ExcelUtility;
import com.concast.crm.generic.fileutility.FileUtility;
import com.concast.crm.generic.webdriverutility.WebDriverUtility;
import com.concast.generic.JavaUtility.JavaUtility;

public class CreateOrganisationwithCtNo extends BaseClass{
@Test
public void organisationWithcontact() throws Exception
{
		String orgname=eu.getDataFromExcel("contact", 1, 2)+ju.getRandomNumber();
		String phno=eu.getDataFromExcel("contact", 1, 7);
		       
	wdu.waitForPageToLoad(driver);
	wdu.maximize(driver);
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