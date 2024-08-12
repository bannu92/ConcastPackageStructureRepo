package com.concast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganisationPage {
	
	WebDriver driver;
	public CreateNewOrganisationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver,this );
	}
	@FindBy(name="accountname")
	private WebElement organisationedit;

	@FindBy(name="industry")
	private WebElement IndustryDropDown;
	@FindBy(name="accounttype")
	private WebElement TypeDropDown;
	
	public WebElement getOrganisationEdit() {
	return organisationedit;
	}
	public WebElement getIndustryDropDown() {
		return IndustryDropDown;
	}

	public WebElement getTypeDropDown() {
		return TypeDropDown;
	}

}
