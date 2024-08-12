package com.practice.pom.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class WithPOM {

	@FindBy(name="user_name")
	WebElement ele1;
	
@FindBy(name="user_password")
WebElement ele2;



@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@type='submit']")})
private WebElement ele3;
@Test
public void SampleTest()
{
	WebDriver driver=new ChromeDriver();
	driver.get("http://localhost:8888");
WithPOM p=	PageFactory.initElements(driver,WithPOM.class);
p.ele1.sendKeys("admin");
p.ele2.sendKeys("admin");
driver.navigate().refresh();
p.ele1.sendKeys("admin");
p.ele2.sendKeys("admin");
p.ele3.click();
}
}

