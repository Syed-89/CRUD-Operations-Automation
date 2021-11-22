package com.qa.crud.pages;

import org.openqa.selenium.By;
import com.qa.crud.base.Browser;
import com.qa.crud.utilites.WaitUtil;

public class AddressListing extends Browser{
	
	
	private By addressLink=By.linkText("Addresses");
	private By newAddressLink=By.linkText("New Address");
	private By firstNamevalue= By.xpath("//span[@data-test='first_name']");
	private By succssToast=By.cssSelector("div.alert.alert-notice");
  



public AddressListing() {
		super();
		// TODO Auto-generated constructor stub
	}

public void clickOnAddressLink()
{
	
 driver.findElement(addressLink).click();

}

public AddressPage onClickNewAddresslink()
{
	WaitUtil.waitForElement(newAddressLink, 20);
	driver.findElement(newAddressLink).click();
    return new AddressPage();
}

public AddressPage onClickEditAddress(String fname) 
{
	
	By editlink= By.xpath("//td[text()='"+fname+"']//following-sibling::td/a[text()='Edit']");
	WaitUtil.waitForElement(editlink, 10);
	driver.findElement(editlink).click();
	return new AddressPage();
}

public void onClickDestroy(String fname) {
	
	By destroylink= By.xpath("//td[text()='"+fname+"']//following-sibling::td/a[text()='Destroy']");
	WaitUtil.waitForElement(destroylink, 10);
	driver.findElement(destroylink).click();
	WaitUtil.waitForAlert(10);
	
}

public String onClickShow(String fname)
{
	clickOnAddressLink();
	By show= By.xpath("//td[text()='"+fname+"']//following-sibling::td/a[text()='Show']");
    WaitUtil.waitForElement(show, 10);
	driver.findElement(show).click();
	WaitUtil.waitForElement(firstNamevalue, 5);
	return driver.findElement(firstNamevalue).getText();
	
	


}

public String deleteAddress(String fname)
{
   clickOnAddressLink();
   onClickDestroy(fname);
   return driver.findElement(succssToast).getText();
}
}



