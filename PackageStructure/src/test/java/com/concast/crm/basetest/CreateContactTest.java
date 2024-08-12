package com.concast.crm.basetest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.concast.crm.BaseClass.BaseClass;
import com.concast.crm.ObjectRepositoryUtility.ContactsInfoPage;
import com.concast.crm.ObjectRepositoryUtility.ContactsPage;
import com.concast.crm.ObjectRepositoryUtility.CreateNewContactPage;
import com.concast.crm.ObjectRepositoryUtility.HomPage;
import com.practice.pom.repository.BaseClasss;

public class CreateContactTest extends BaseClass {

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


}
