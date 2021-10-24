package com.qa.crud.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.crud.base.Browser;
import com.qa.crud.pages.AddressListing;
import com.qa.crud.utilites.ReadExcel;

public class AddressListTestcases extends Browser {


	private AddressListing addresslisting= new AddressListing();
	
	
	@DataProvider
	public Object[][] deleteTestData()
	{
		
		Object[][] deleteData=ReadExcel.getdata("Delete");
		
		return deleteData;
		
		
	}
	
	@DataProvider
	public Object[][] showTestData()
	{
		
		Object[][] showData=ReadExcel.getdata("Show");
		
		return showData;
		
		
	}
	
	
	@Test(dataProvider="deleteTestData")
	public void deleteAddressTest()
	{
	String msg=addresslisting.deleteAddress("paul");
	Assert.assertEquals(msg, "Address was successfully destroyed.");
	}
	
	
	@Test(dataProvider="showTestData")
	public void getAddressTest(String fName)
	{
	
		String msg=addresslisting.onClickShow(fName);
		Assert.assertEquals(msg, fName);
	
}
}
