package practicetest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.concast.crm.generic.fileutility.ExcelUtility;

public class GetProductInfoTest {
@Test(dataProvider = "getData")
public void getProductInfoTest(String brandname, String prodname)
{
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://www.amazon.in/");
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandname,Keys.ENTER);
	WebElement w=driver.findElement(By.xpath("(//span[text()='"+prodname+"'])/../../../../div[3]/div/div[1]/div/div/div/a/span/span[2]/span[2]"));
	String price=w.getText();
	System.out.println(price);
	
}

@DataProvider
public Object[][] getData() throws Throwable{
	ExcelUtility eu=new ExcelUtility();
	eu.getRowcount("Sheet2");
int rowcount=eu.getRowcount("Sheet2");
	Object[][] objarr=new Object[rowcount][2];
	for(int i=0;i<rowcount;i++)
	{
		objarr[i][0]=eu.getDataFromExcel("Sheet2", i+1, 0);
		objarr[i][1]=eu.getDataFromExcel("Sheet2", i+1, 1);
			
	}
	   
    return objarr;
}
}
