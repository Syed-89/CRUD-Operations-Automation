package com.qa.crud.utilites;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.crud.base.Browser;

public class WaitUtil extends Browser {
	
	
	
	private static WebDriverWait wait;
	
	
	
	
	public static void waitForElement(By locator, int time)
	{
		try
		{
			
			wait= new WebDriverWait(driver,time);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			
			
			
		}
		
		catch(Exception e)
		{
			
			System.out.println("Some error occured while waiting for the element"+ locator.toString());
			e.printStackTrace();
			
		}
	}
		
		public static void waitForAlert(int time)
		{
			
			wait= new WebDriverWait(driver,time);
			wait.until(ExpectedConditions.alertIsPresent()).accept();
			
			
		}
		
		
		
		
		
	}
	
	

