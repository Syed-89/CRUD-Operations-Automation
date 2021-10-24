package com.qa.crud.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.crud.base.Browser;
import com.qa.crud.pages.Address;
import com.qa.crud.pages.AddressPage;
import com.qa.crud.utilites.ReadExcel;

public class AddressPageTest extends Browser {

	
	private AddressPage addresspage	= new AddressPage();
	private Address add;

	
@DataProvider
public Object[][] getTestData()
{
	
Object[][]data=ReadExcel.getdata("Add");

return data;

}

@DataProvider
public Object[][] updateTestData()
{
	
Object[][]updatedata=ReadExcel.getdata("Update");

return updatedata;

}

	
@Test(dataProvider="getTestData")
public void createAddressTest(String fname, String lastName, String address, String city, String zipCode)
{
	

add=new Address(fname,lastName,address,city,zipCode);
String msg=addresspage.addAddress(add);
Assert.assertEquals(msg, "Address was successfully created.");
}

@Test(dataProvider="updateTestData")
public void updateAddressTest(String fname, String lastName, String address, String city, String zipCode)
{
add=new Address(fname,lastName,address,city,zipCode);
addresspage.addAddress(add);
add.setLastName(lastName);
add.setAddress(address);
String msg=addresspage.updateAddress(add,add.getFirstName());
Assert.assertEquals(msg, "Address was successfully updated.");
}







}

