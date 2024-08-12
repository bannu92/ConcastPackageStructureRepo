 package com.concast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationInfoPage {
	WebDriver driver;
	public OrganisationInfoPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver,this );
	}
@FindBy(id="dtlview_Industry")
private WebElement industryedit;

@FindBy(id="dtlview_Phone")
private WebElement actphnoedit;

@FindBy(id="dtlview_Type")
private WebElement typeedit;

@FindBy(xpath="//span[@class='dvHeaderText']")
private WebElement headerinfo;
public WebElement getIndustryedit() {
	return industryedit;
}

public WebElement getActphnoedit() {
	return actphnoedit;
}

public WebElement getTypeedit() {
	return typeedit;
}

public WebElement getHeaderinfo() {
	return headerinfo;
}

}
