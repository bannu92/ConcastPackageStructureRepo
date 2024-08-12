package com.concast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationsPage {
	WebDriver driver;
	public OrganisationsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver,this );
	
	}
@FindBy(xpath="//img[@title='Create Organization...']")
private WebElement createorganisationbutton;
@FindBy(id="phone")
private WebElement phoneedit;
@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement savebtn;
@FindBy(name="search_text")
private WebElement searchtext;
@FindBy(name="search_field")
private WebElement searchfield;
@FindBy(name="submit")
private WebElement searchbtn;
public WebElement getCreateorganisationbutton() {
	return createorganisationbutton;
}
public WebElement getPhoneedit() {
	return phoneedit;
}
public WebElement getSavebtn() {
	return savebtn;

}
public WebElement getSearchtext() {
	return searchtext;
}
public WebElement getSearchfield() {
	return searchfield;
}
public WebElement getSearchbtn() {
	return searchbtn;
}



}

