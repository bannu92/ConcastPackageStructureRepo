package com.concast.crm.generic.webdriverutility;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.xwpf.usermodel.Document;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
public void waitForPageToLoad(WebDriver driver)
{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
}
public void waitForElementPresent(WebDriver driver,WebElement element)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOf(element));
}
public void waitForElement(WebDriver driver,WebElement element)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));

	wait.until(ExpectedConditions.elementToBeClickable(element));
}
public void waitForElementAlert(WebDriver driver,WebElement element)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));

	wait.until(ExpectedConditions.alertIsPresent());
	
}
public void waitForElementSelected(WebDriver driver,WebElement element)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));

wait.until(ExpectedConditions.elementToBeSelected(element));
}
public void waitForElementInvisibility(WebDriver driver,WebElement element)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));

wait.until(ExpectedConditions.invisibilityOf(element));
	
}
public void switchToNewBrowserTab(WebDriver driver, String partialURL)
		 {
	Set<String> sett=driver.getWindowHandles();
    Iterator<String> its=sett.iterator();
	  while(its.hasNext())
	  {
		  String windowid=its.next();
		  driver.switchTo().window(windowid);
	  
	  String acturl=driver.getCurrentUrl();
	  if(acturl.contains(partialURL)) {
		  break;
	
}
}
}

public void switchToTabonTitle(WebDriver driver, String partialTitle)
{
Set<String> sett=driver.getWindowHandles();
Iterator<String> its=sett.iterator();
while(its.hasNext())
{
 String windowid=its.next();
 driver.switchTo().window(windowid);

String acturl=driver.getTitle();
if(acturl.contains(partialTitle)) {
 break;

}
}
}
public void switchToFrame(WebDriver driver, int Index)
{
	driver.switchTo().frame(Index);
}
public void switchToFrame(WebDriver driver, String name)
{
	driver.switchTo().frame(name);
}
public void switchToFrame(WebDriver driver, WebElement element)
{
	driver.switchTo().frame(element);
}
public void switchToAlertAccept(WebDriver driver)
{
	driver.switchTo().alert().accept();
	}
public void switchToAlertDismiss(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}
public void switchToAlertSendKeys(WebDriver driver, String sendkey)
{
	driver.switchTo().alert().sendKeys("sendkey");
}
public void switchToAlertGetText(WebDriver driver)
{
	driver.switchTo().alert().getText();
}
public void select(WebElement element, int index )
{
	Select sel=new Select(element);
sel.selectByIndex(index);	

}
public void selectText(WebElement element, String text )
{
	Select sel=new Select(element);
	sel.selectByVisibleText(text);
}
public void select(WebElement element,String value)
{
	Select sel=new Select(element);
	sel.selectByValue(value);
}
public void maximize(WebDriver driver)
{
	driver.manage().window().maximize();
}
public void minimize(WebDriver driver)
{
	driver.manage().window().minimize();
}
public void mousemoveonElement(WebDriver driver, WebElement element)
{
	Actions act=new Actions(driver);
	act.moveToElement(element).perform();
}
public void doubleClick(WebDriver driver, WebElement element)
{
	Actions act=new Actions(driver);
	act.doubleClick().perform();
}
public void rightClick(WebDriver driver, WebElement element)
{
	Actions act=new Actions(driver);
	act.contextClick().perform();
}
public void dragAndDrop(WebDriver driver, WebElement source,WebElement destination)
{
	Actions act=new Actions(driver);
	act.dragAndDrop(source, destination).perform();
}
public void scrollDown(WebDriver driver, WebElement element)
{
	Actions act=new Actions(driver);
	act.scrollToElement(element).perform();
}
public void SendKeys(WebDriver driver, WebElement element, String keys)
{
	Actions act=new Actions(driver);
	act.sendKeys(keys).perform();
}
public void takesScreenshots(WebDriver driver, String ScreenShotName) throws Exception
{
	TakesScreenshot ts=(TakesScreenshot)driver;
File src1=ts.getScreenshotAs(OutputType.FILE);
File dest1=new File(".\\ScreenShot"+ScreenShotName+".png");
FileHandler.copy(src1, dest1);
}
public void javaScriptScrollBy(WebDriver driver,WebElement element)
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	int y=element.getLocation().getY();
	js.executeScript("Window.ScrollBy(0."+y+")");
	
}

}
