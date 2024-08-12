package com.concast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsSearchPage {
	WebDriver driver;
	public ContactsSearchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver,this );
	}

@FindBy(name="search_text")
private WebElement searchedit;

@FindBy(name="search")
private WebElement searchbtn;


@FindBy(xpath="//a[text()='']")
private WebElement dynamicxpath;

public WebElement getSearchedit() {
	return searchedit;
}

public WebElement getSearchbtn() {
	return searchbtn;
}

public WebElement getDynamicxpath() {
	return dynamicxpath;
}


}
