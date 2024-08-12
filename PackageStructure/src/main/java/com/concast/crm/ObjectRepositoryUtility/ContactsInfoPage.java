package com.concast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {
	WebDriver driver;
	public ContactsInfoPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver,this );
	}

	@FindBy(id="dtlview_Last Name")
	private WebElement lastnametext;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement conheaderinfo;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement orgname;
	
	@FindBy(id="dtlview_Support Start Date")
	private WebElement startdate;
	
@FindBy(id="dtlview_Support End Date")
private WebElement enddate;
	
	public WebElement getLastnametext() {
		return lastnametext;
	
	}

	public WebElement getConheaderinfo() {
		return conheaderinfo;
	}

	public WebElement getOrgname() {
		return orgname;
	}

	public WebElement getStartdate() {
		return startdate;
	}

	public WebElement getEnddate() {
		return enddate;
	}


	
}
