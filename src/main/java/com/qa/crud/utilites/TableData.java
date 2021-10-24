package com.qa.crud.utilites;

import org.openqa.selenium.By;

import com.qa.crud.base.Browser;

public class TableData extends Browser{
	
	
	private static By tableRows=By.xpath("//table[@class='table']//tr");
	private static By tableColumns=By.xpath("//table[@class='table']//th");
	static int rowSize=driver.findElements(tableRows).size();
	static int colSize=driver.findElements(tableColumns).size();
    static String text;
	
	public static String searchTextInTable(String firstName)
	{
		
	for(int i=1; i<=rowSize; i++)
	{
		
		
		for(int j=1; j<=colSize; j++)
		{
			
		text=driver.findElement(By.xpath("//table[@class='table']/tbody/tr["+i+"]/td["+j+"]")).getText();
		
		if(text.equals(firstName))
		{
			System.out.println(text);
			break;
			
	
		}
		
		else
		{
		
			System.out.println("text nor found in the grid");
		
		}
		
		
		}
		
		
	}
	
	
	return firstName;
		
		
		
	}

}
