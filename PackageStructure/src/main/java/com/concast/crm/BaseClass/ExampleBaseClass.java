package com.concast.crm.BaseClass;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;



public class ExampleBaseClass {
	
	@BeforeSuite
public void configBS() throws Exception
{
	System.out.println("====connect to db, report config====");
}
@BeforeClass
public void configBC() throws Exception
{

	System.out.println("====launch the browser====");
    

  }



@BeforeMethod
public void configBM() throws Exception
{
	System.out.println("====login to the application====");
	

}
@AfterMethod
public void configAM()
{

	System.out.println("====logout from the application====");
    
}
@AfterClass
public void configAC()
{
	System.out.println("====close the browser====");

}
@AfterSuite
public void configAS() throws Exception
{
	System.out.println("====close the db connection");
}
}


