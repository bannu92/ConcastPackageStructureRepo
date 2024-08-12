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

public class CreateOrganisationWithIndustry extends BaseClass{
	@Test
	public void organisationWithIndustry() throws Exception{
                
		       String orgname=eu.getDataFromExcel("contact", 1, 2)+ju.getRandomNumber();
		       String industry=eu.getDataFromExcel("contact", 1, 5);
		       String type=eu.getDataFromExcel("contact", 1, 6);
		     
	wdu.waitForPageToLoad(driver);
	wdu.maximize(driver);
		
		  OrganisationsPage o=new OrganisationsPage(driver);
		  HomPage h=new HomPage(driver);
		  h.getOrganisationstab().click();
		  OrganisationInfoPage oip=new OrganisationInfoPage(driver);
		  o.getCreateorganisationbutton().click();
		  CreateNewOrganisationPage cnop=new CreateNewOrganisationPage(driver);
		  cnop.getOrganisationEdit().sendKeys(orgname);
		 
		  
		  WebElement industrywe=cnop.getIndustryDropDown();
		  wdu.selectText(industrywe, "Energy" );
		 WebElement typewe=cnop.getTypeDropDown();
		 wdu.selectText(typewe, "Press" );
		  
		 
		  o.getSavebtn().click();
	     String actindustries=oip.getIndustryedit().getText();

	if(actindustries.contains(industry))
	{
	System.out.println(industry +" "+ "is verified");	
	}
	else
	{
		System.out.println(industry +" " + "is not verified");
	}
	String acttype=oip.getTypeedit().getText();

	if(acttype.contains(type))
	{
	System.out.println(acttype +" "+ "is verified");	
	}
	else
	{
		System.out.println(acttype +" " + "is not verified");
	}

	}
}

