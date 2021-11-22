package com.qa.crud.pages;

import org.openqa.selenium.By;
import com.qa.crud.base.Browser;
import com.qa.crud.utilites.WaitUtil;

public class AddressPage extends Browser  {
	

	private By firstName=By.xpath("//input[@id='address_first_name']");
	private By lastName=By.id("address_last_name");
	private By userAddress=By.id("address_street_address");
	private By city=By.id("address_city");
	private By zipCode=By.id("address_zip_code");
	private By createBtn=By.name("commit");
	private By succssToast=By.cssSelector("div.alert.alert-notice");
	private AddressListing addresslisting = new AddressListing() ;;
	
	



	public AddressPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String fillAddressform(Address address)
	{
		
		WaitUtil.waitForElement(firstName, 20);
		driver.findElement(firstName).clear();
		driver.findElement(firstName).sendKeys(address.getFirstName());
		driver.findElement(lastName).clear();
		driver.findElement(lastName).sendKeys(address.getLastName());
		driver.findElement(userAddress).clear();
		driver.findElement(userAddress).sendKeys(address.getAddress());
		driver.findElement(city).clear();
		driver.findElement(city).sendKeys(address.getCity());
		driver.findElement(zipCode).clear();
		driver.findElement(zipCode).sendKeys(address.getZipcode());
		driver.findElement(createBtn).click();
	    return driver.findElement(succssToast).getText();
		
	
	}
	
	public String addAddress(Address address)
	{
	
		addresslisting.clickOnAddressLink();
		addresslisting.onClickNewAddresslink();
		return fillAddressform(address);
		
		
	}
	
	public String updateAddress(Address address, String fname) 
	{
		
		addresslisting.clickOnAddressLink();
		addresslisting.onClickEditAddress(fname);
		return fillAddressform(address);
				
	}
	
	
}
