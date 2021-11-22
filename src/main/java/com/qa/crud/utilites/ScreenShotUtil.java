package com.qa.crud.utilites;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.crud.base.Browser;

public class ScreenShotUtil extends Browser {
	
	
	public void screenShotForFailedTestCase(String testMethod)
	{
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try
		{
			
			FileUtils.copyFile(src, new File("./screenshot/"+testMethod+"_"+".png"));
			
			
		}
		catch(IOException e)
		{
			
			e.printStackTrace();
			
		}
		
		
		
		
	}
	

}
