package com.flightbook.TestBase;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class FlipKart {

	WebDriver driver = null;

	@Test
	public void init() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "src/main/java/com/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//div/button[@class='_2AkmmA _29YdH8']")).click();
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("DEll " + Keys.ENTER);
		System.out.println("entered the dell details");

		Thread.sleep(5000);

		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(5000);

		List<WebElement> list = driver.findElements(By.xpath("//div[@class='_3O0U0u']"));
		int Sizerow = list.size();
		System.out.println(Sizerow);

		for (int i = 1; i <Sizerow; i++) {

			String xpath = "//div[@class='_3O0U0u']["+i+"]/div/div/a[@class='_1Vfi6u']";
			System.out.println(xpath);
			List<WebElement> productdata = driver.findElements(By.xpath(xpath));
			int productsize = productdata.size();
			System.out.println(productsize);
			//div[@class='_3O0U0u'][1]/div/div[1]/a[@class='_1Vfi6u']
			for (WebElement e : productdata) {
		String	Xpathprice =	"//div[@class='_1vC4OE'][contains(text(),'₹')]";
		List<WebElement> listprice = driver.findElements(By.xpath(Xpathprice));
				for(WebElement price:listprice)
				{
					String val = price.getText().replaceAll(",", "").substring(1);
				//System.out.println(price.getText().replaceAll(",", "").substring(1));
				if (val.contentEquals("22985"))
					{
					System.out.println("price clicked");
					price.click();
					}
				
				}
			}
		}
	}
}
