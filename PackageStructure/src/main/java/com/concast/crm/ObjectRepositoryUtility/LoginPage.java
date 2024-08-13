package com.concast.crm.ObjectRepositoryUtility;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concast.crm.generic.webdriverutility.WebDriverUtility;

public class LoginPage extends WebDriverUtility {
WebDriver driver;
	public LoginPage(WebDriver driver)
	{
	this.driver=driver;
		PageFactory.initElements( driver,this );
	
	}
@findBy(name="user")
private WebElement user;
public WebElement getUser()
{
	return user;
}
	
@FindBy(name="user_name")
private WebElement usernameEdit;
@FindBy(name="user_password")
private WebElement Passwordedit;
@FindBy(id="submitButton")
private WebElement loginbtn;
@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
private WebElement logoutlink;
@FindBy(linkText = "Sign Out" )
private WebElement signoutlink;
public WebElement getUsernameEdit() {
	return usernameEdit;
}
public WebElement getLogoutlink() {
	return logoutlink;
}
public WebElement getSignoutlink() {
	return signoutlink;
}
public WebElement getPasswordedit() {
	return Passwordedit;
}
public WebElement getLoginbtn() {
	return loginbtn;
}
public void loginToapp(String username, String password)
{
	WebDriverUtility wdu=new WebDriverUtility();
	wdu.waitForPageToLoad(driver);
	usernameEdit.sendKeys(username);
	Passwordedit.sendKeys(password);
	loginbtn.click();
}
public void logout()
{
	WebDriverUtility wd=new WebDriverUtility();
	wd.mousemoveonElement(driver, logoutlink);
	logoutlink.click();
	signoutlink.click();
	
}
}



