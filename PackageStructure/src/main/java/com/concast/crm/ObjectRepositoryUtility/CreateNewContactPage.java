
package com.concast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {
	WebDriver driver;
	public CreateNewContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver,this );
	}

	@FindBy(name="lastname")
	private WebElement lastnameedit;
@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement savebtn;

@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
private WebElement organisationbtn;

@FindBy(name="support_start_date")
private WebElement startdateedit;

@FindBy(name="support_end_date")
private WebElement enddateedit;

public WebElement getLastnameedit() {
	return lastnameedit;
}
public WebElement getSavebtn() {
	return savebtn;
}
public WebElement getOrganisationbtn() {
	return organisationbtn;
}
public WebElement getStartdateedit() {
	return startdateedit;
}
public WebElement getEnddateedit() {
	return enddateedit;
}


}
