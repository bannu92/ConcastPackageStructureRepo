package com.concast.crm.debuggingtest;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.concast.crm.BaseClass.BaseClass;
import com.concast.crm.ListenerUtility.ListImpClass;
import com.concast.crm.ObjectRepositoryUtility.CreateNewOrganisationPage;
import com.concast.crm.ObjectRepositoryUtility.HomPage;
import com.concast.crm.ObjectRepositoryUtility.OrganisationInfoPage;
import com.concast.crm.ObjectRepositoryUtility.OrganisationsPage;
import com.concast.crm.generic.webdriverutility.UtilityClassObject;
@Listeners(com.concast.crm.ListenerUtility.ListImpClass.class)
public class MultipleOrganisationTest extends BaseClass {
@Test
public void organisationTest() throws Exception
{
        UtilityClassObject.getTest().log(Status.INFO,"read daya from Excel");
				String orgname=eu.getDataFromExcel("contact", 1, 2)+ju.getRandomNumber();
				UtilityClassObject.getTest().log(Status.INFO,"navigate to org page");
		 wdu.waitForPageToLoad(driver);
		 wdu.maximize(driver);
	HomPage h=new HomPage(driver);
	h.getOrganisationstab().click();
	UtilityClassObject.getTest().log(Status.INFO,"navigate to create org page");
     OrganisationsPage o=new OrganisationsPage(driver);
     o.getCreateorganisationbutton().click();
     UtilityClassObject.getTest().log(Status.INFO,"create new org");
	CreateNewOrganisationPage cnop=new CreateNewOrganisationPage(driver);
	cnop.getOrganisationEdit().sendKeys(orgname);
	o.getSavebtn().click();
	UtilityClassObject.getTest().log(Status.INFO,"create new org");
	OrganisationInfoPage oip=new OrganisationInfoPage(driver);
	String orgheadname=oip.getHeaderinfo().getText();
	Assert.assertEquals(true, orgheadname.contains(orgname));
	}
	
	

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

