package com.qa.crud.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.crud.pages.SignIn;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
	
	
	protected static WebDriver driver;
	protected static Properties pro;
	
	public Browser()
	{
		pro= new Properties();
		
		
		try {
			FileInputStream fls = new FileInputStream("C:\\Users\\Syed Danish\\eclipse-workspace\\CrudOperations\\src\\main\\java\\com\\qa\\crud\\configurations\\Config.properties");
			pro.load(fls);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	@BeforeTest
	public static void init_Browser()
	{
		
		String browserName= pro.getProperty("Browser");
		if(browserName.equals("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		
		else
		{
			System.out.println("No Browser Found");
			
		}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(pro.getProperty("Url"));
		SignIn.userSignIn();
		}
		
	@AfterTest
	public void tearDown()
	{
		
		
		driver.quit();
		
	}
		
	}

