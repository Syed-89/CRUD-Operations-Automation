package com.qa.crud.pages;

import org.openqa.selenium.By;

import com.qa.crud.base.Browser;

public class SignIn extends Browser{
	
	
	
	private static By email=By.id("session_email");
	private static By password=By.id("session_password");
	private static By signBtn=By.name("commit");

	
	
	public static void userSignIn()
	
	
	{
		driver.findElement(email).sendKeys(pro.getProperty("Username"));
		driver.findElement(password).sendKeys(pro.getProperty("Password"));
		driver.findElement(signBtn).click();
		
		
	}
}
