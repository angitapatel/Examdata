package com.flightbook.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestBase {
	

public static WebDriver driver = null;
	public Properties prop;
	public  File src;
	public FileInputStream fis;
	
	

	public void init() throws IOException
	{
		
		src = new File("src/main/java/com/flightbook/Config/config.properties");
		fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		
		
	System.out.println("browser "+ prop.getProperty("browser"));
	String browser =  prop.getProperty("browser");
	
	if(browser.equalsIgnoreCase("chrome"))
	{
		System.setProperty("webdriver.chrome.driver","src/main/java/com/flightbook/Driver/chromedriver.exe");
		driver = new ChromeDriver();
		
	}
 else if (browser.equalsIgnoreCase("IE"))
	{
		
	 System.setProperty("webdriver.ie.driver","src/main/java/com/flightbook/Driver/IEDriverServer.exe");
	 driver =new  InternetExplorerDriver();
	 
	 }
	
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
		
	driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
	
	driver.get(prop.getProperty("url"));
	
	
	}
	
	
	
	

}
