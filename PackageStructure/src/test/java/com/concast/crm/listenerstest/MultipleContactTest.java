package com.concast.crm.listenerstest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.concast.crm.BaseClass.BaseClass;
import com.concast.crm.ObjectRepositoryUtility.ContactsInfoPage;
import com.concast.crm.ObjectRepositoryUtility.ContactsPage;
import com.concast.crm.ObjectRepositoryUtility.ContactsSearchPage;
import com.concast.crm.ObjectRepositoryUtility.CreateNewContactPage;
import com.concast.crm.ObjectRepositoryUtility.CreateNewOrganisationPage;
import com.concast.crm.ObjectRepositoryUtility.HomPage;
import com.concast.crm.ObjectRepositoryUtility.OrganisationInfoPage;
import com.concast.crm.ObjectRepositoryUtility.OrganisationsPage;

public class MultipleContactTest extends BaseClass {

		@Test
		public void create_Contact_Test() throws Exception
		{
			
			 String lastname=eu.getDataFromExcel("contact", 1, 9)+ju.getRandomNumber();
			//Step 4: Click on Contacts Link
			 HomPage hp=new HomPage(driver);
			 hp.getContactstab().click();
				//step 5:Click on Create Contact Look Image
			 ContactsPage cp=new ContactsPage(driver);
			 cp.getCreatecontactbtn().click();

			//step 6:Create New Contact
			//step 7:Save
			 CreateNewContactPage  cnp= new CreateNewContactPage(driver);
			 cnp.getLastnameedit().sendKeys("lastname");;
		 	//  Assert.fail();
			//step 8: Validate

			 
			 ContactsInfoPage cip = new ContactsInfoPage(driver);
			 
			 String contactHeader= cip.getConheaderinfo().getText();
			
			 Assert.assertTrue(contactHeader.contains(lastname));
			 System.out.println(contactHeader);
		
	    }



@Test
public void contactWithOrganisation() throws Exception
        {
	
		        String orgname=eu.getDataFromExcel("contact", 1, 8)+ju.getRandomNumber();
		        String lastname=eu.getDataFromExcel("contact", 1, 9);
		  
wdu.waitForPageToLoad(driver);
	wdu.maximize(driver);
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


@Test
public void startDateEndDate() throws Exception
{
	        
	        String lastname=eu.getDataFromExcel("contact", 4, 9)+ju.getRandomNumber();
	wdu.waitForPageToLoad(driver);
wdu.maximize(driver);
	  
	
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

