package com.flightbook.Helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.flightbook.TestBase.TestBase;

public class FrameHelper extends TestBase {
	
	
	
	public void switchByid(String Id)
	{
		driver.switchTo().frame(Id);
		
	}
	
	public void SwithByXpath(String xpath)
	{
	WebElement ele = driver.findElement(By.xpath( "+ xpath +"));
		
	driver.switchTo().frame(ele);
	ele.click();
	}

}
