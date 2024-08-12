package com.concast.crm.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.concast.crm.ObjectRepositoryUtility.LoginPage;
import com.concast.crm.generic.databaseutility.DataBaseUtility;
import com.concast.crm.generic.fileutility.ExcelUtility;
import com.concast.crm.generic.fileutility.FileUtility;
import com.concast.crm.generic.webdriverutility.WebDriverUtility;
import com.concast.generic.JavaUtility.JavaUtility;
public class BaseClass {
	public DataBaseUtility dbu=new DataBaseUtility();
	public FileUtility fu=new FileUtility();
	public WebDriverUtility wdu=new WebDriverUtility();
	public WebDriver driver;
	public static WebDriver sdriver=null;
	public JavaUtility ju=new JavaUtility();
	public ExcelUtility eu=new ExcelUtility();
	
	@BeforeSuite
public void configBS() throws Exception
{
	System.out.println("====connect to db, report config====");

	dbu.getDBConnection();
}
@Parameters("browser")
@BeforeClass
public void configBC(String browser) throws Exception
{
	String BROWSER=browser;	
//String Browser=	fu.getDataFromPropertiesFile("browser");
	System.out.println("====launch the browser====");
    
  
  if(BROWSER.equals("chrome"))
  {
	  driver =new ChromeDriver();
  }
  else if(BROWSER.equals("edge"))
  {
	  driver=new EdgeDriver();
  }
  else
  {
	  driver=new ChromeDriver();
  }
  sdriver=driver;

}

@BeforeMethod
public void configBM() throws Exception
{
	System.out.println("====login to the application====");
	String URL=fu.getDataFromPropertiesFile("url");
	String usn=fu.getDataFromPropertiesFile("username");
	String pwd=fu.getDataFromPropertiesFile("password");
	driver.get(URL);
	LoginPage lp=new LoginPage(driver);
	lp.loginToapp(usn, pwd);
	

}
@AfterMethod
public void configAM()
{

	System.out.println("====logout from the application====");
  LoginPage lp=new LoginPage(driver); 
  lp.logout();
}
@AfterClass
public void configAC()
{
	System.out.println("====close the browser====");

driver.close();
}
@AfterSuite
public void configAS() throws Exception
{
	System.out.println("====close the db connection");
dbu.closeDBConnection();

}
}
