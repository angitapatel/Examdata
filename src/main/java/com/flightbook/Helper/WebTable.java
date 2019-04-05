package com.flightbook.Helper;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebTable {

	public static WebDriver driver;
	static int colmnno =8;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "src/main/java/com/flightbook/Driver/chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.get("http://demo.automationtesting.in/WebTable.html");
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

//	List<WebElement> list = driver.findElements(By.xpath("//div[@role='rowgroup']/descendant::div"));
//
//		int size = list.size();
//		System.out.println("total Size :-> " + size);
//
//		for (WebElement ele : list) {
//			System.out.println(ele.getText());
//		}
//		
		String	Startxpath = ".ui-grid-coluiGrid-000";
		//"//div[@class='ui-grid-canvas']/descendant::div[@class='ui-grid-cell ng-scope ui-grid-coluiGrid-000";
		String Endxpath =">div";
				//"']";
		System.out.println(Startxpath+ colmnno +Endxpath);
		List<WebElement> listcolms = driver
				.findElements(By.cssSelector(Startxpath+colmnno+Endxpath));

		int listcolmnsize = listcolms.size();
		System.out.println("colmnsize ->  " + listcolmnsize);
		
		for(WebElement e : listcolms)
		{
			
			
			System.out.println(e.getText());
		}
		
	
		
		
		
		


	

	
}
	public static void selectrowdata(WebDriver driver, int colmnno)
	{
		
	
	}
}