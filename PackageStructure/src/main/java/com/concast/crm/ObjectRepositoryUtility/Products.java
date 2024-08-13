
package com.concast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Products {
@FindBy(name="Products")
private WebElement prod;

public WebElement getProducts()
{
	return prod;
}
@findBy(name="prod1")
private WebElement prod1;
public WebElement getProd()
{
	return prod1;
}
}
