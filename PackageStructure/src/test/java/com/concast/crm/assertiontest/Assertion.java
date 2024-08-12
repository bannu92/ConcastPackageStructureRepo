package com.concast.crm.assertiontest;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertion {
@Test
public void homePageTest(Method mtd) {
	System.out.println(mtd.getName()+" "+"test start");
	String Expectedtitle="Home";
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.manage().window().maximize();
	driver.get("http://localhost:8888/");
	
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	String acttitle=driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
	Assert.assertEquals(acttitle, Expectedtitle);
			System.out.println(Expectedtitle +" "+"is not verified");

			driver.close();
	
	System.out.println(mtd.getName()+" "+"method ends");
}

@Test
public void verifyLogoHomePageTest(Method mtd)
{
	System.out.println(mtd.getName()+" "+"test starts");
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.manage().window().maximize();
	driver.get("http://localhost:8888/");
	
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	boolean status=driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
Assert.assertTrue(status);
	driver.close();
	System.out.println(mtd.getName()+" "+"method ends");
}
}
