
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
}
