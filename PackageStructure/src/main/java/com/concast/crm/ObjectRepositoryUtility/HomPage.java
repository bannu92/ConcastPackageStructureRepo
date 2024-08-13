package com.concast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomPage {
	WebDriver driver;
	public HomPage(WebDriver driver)

	{
	this.driver=driver;
		PageFactory.initElements( driver,this );
	
	}

	@FindBy(linkText="Organizations")
private WebElement organisationstab;

	@FindBy(linkText="Contacts")
private WebElement contactstab;

	@FindBy(linkText = "Products")
	private WebElement Products;
	
	public WebElement getProducts()
	{
		return Products;
	}
	public WebElement getOrganisationstab() {
		return organisationstab;
	} 
public WebElement getContactstab()
{
return contactstab;
}
}

