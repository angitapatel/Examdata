package com.flightbook.Helper;

import org.openqa.selenium.Alert;

import com.flightbook.TestBase.TestBase;

public class Alerthelper extends TestBase{

	
	public Alert alert;
	String alerttext;
	public void Alertaccept()
	{
		driver.switchTo().alert();
		alert.accept();
	}
	
	public void AlertDissmiss()
	{
		driver.switchTo().alert();
		alert.dismiss();
	}
	
	public void Alerttext()
	{
		driver.switchTo().alert();
		alerttext=	alert.getText();
		System.out.println("Alert Text :-> "+ alerttext);
		
	}
	
	public void AlertEnterval()
	{
		driver.switchTo().alert();
		alert.sendKeys("9552519252");
	}
}
