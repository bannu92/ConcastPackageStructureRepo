package com.practice.pom.repository;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class BaseClasss {

@Test
public void createOrgTest()
{
	System.out.println("Execute order test");
}
@BeforeMethod
public void beforeMethod() {
	System.out.println("execute before method");
}
@AfterMethod
public void afterMethod()
{
	System.out.println("execute after method");
}
@Test
public void AnotherTest()
{
	
System.out.println("execute another test");
}
@BeforeClass
public void configBeforeClass() {
	System.out.println("execute before class");
}
@AfterClass
public void configAfterClass() {
	System.out.println("execute after class");
}
@BeforeSuite
public void configBeforeSuite() {
	System.out.println("execute before suite");
}
@AfterSuite
public void aftersuite() {
	System.out.println("execute after suite");
}
}