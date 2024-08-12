package com.concast.crm.listenerstest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.concast.crm.BaseClass.BaseClass;

public class InvoiceTest extends BaseClass{
@Test
public void createInvoice()
{
	System.out.println("execute create invoice test");
	String actTitle=driver.getTitle();
	Assert.assertEquals(actTitle, "Home");
	System.out.println("step-1");
	System.out.println("step-2");
	System.out.println("step-3");
	System.out.println("step-4");
}
@Test
public void createInvoiceWithContactTest()
{
	System.out.println("execute createInvoiceWithContactTest");
	System.out.println("step-1");
	System.out.println("step-2");
	System.out.println("step-3");
	System.out.println("step-4");
}
}
