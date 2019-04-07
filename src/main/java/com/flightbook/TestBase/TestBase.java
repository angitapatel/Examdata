package com.flightbook.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import bsh.collection.CollectionIterator;
import junit.framework.Assert;

public class TestBase {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "src/main/java/com/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.zoopla.co.uk/");
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String pop = driver.getWindowHandle();
		System.out.println("pop" + pop);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@id='search-input-location']")).sendKeys("London");
		// clcik on search link
		driver.findElement(By.xpath("//button[@id= 'search-submit']")).click();

		Thread.sleep(1000);

		List<WebElement> list = driver.findElements(By.xpath(
				"//li/descendant::div[@class='listing-results-right clearfix']/a[@class='listing-results-price text-price']"));

		int size = list.size();
		System.out.println("total size :" + size);
		for (WebElement ele : list) {
			String data = ele.getText().replaceAll(",", "").substring(1);
			// System.out.println("your product price :->" + data);
			String digit[] = data.replaceAll("[^-?0-9]+", " ").trim().split(" ");

			for (String num : digit) {
				int val = Integer.parseInt(num);
			//	System.out.println(val);
			}
		}

		List<WebElement> listproduct = driver.findElements(By.xpath("//div[@class='listing-results-wrapper']/div/a"));
		for (WebElement e : listproduct) {
			System.out.println(e.getAttribute("href"));
			if (e.getAttribute("href").contains("/51053894")) {
				System.out.println("find the 5 the number product");
				Thread.sleep(2000);
				e.click();

				break;
			}
			else
			{
				System.out.println("not found the product");
			}

		}

		String pop1 = driver.getWindowHandle();
		System.out.println(pop1);
		driver.switchTo().window(pop1);

		WebElement ele = driver.findElement(
				By.xpath("//div[@class='dp-sidebar-wrapper__contact']//a/div/img[@class='js-lazy-loaded']"));
		String data = ele.getAttribute("alt");
		String imageurl = ele.getAttribute("src");
		System.out.println(data);
		System.out.println(imageurl);

		WebElement Agentphone = driver
				.findElement(By.xpath("//div[@class='dp-sidebar-wrapper__contact']//a[@class='ui-link']"));
		String Agnetphonedata = Agentphone.getText();
		String hrefphone = Agentphone.getAttribute("href");
		System.out.println(Agnetphonedata);
		System.out.println(hrefphone);

		WebElement name = driver.findElement(
				By.xpath("//div[@class='dp-sidebar-wrapper__contact']//a/div/h4[@class='ui-agent__name']"));
		String AgentNAme = name.getText();
		System.out.println(AgentNAme);
		name.click();
		String pop2 = driver.getWindowHandle();
		System.out.println(pop2);
		driver.switchTo().window(pop2);
		List<WebElement> listproduct1 = driver.findElements(By.xpath("//div[@class='listing-results-right clearfix']/a"));
		for (WebElement e : listproduct1) {
			System.out.println(e.getAttribute("href"));
			if (e.getAttribute("href").contains("/51049208")) {
				Thread.sleep(2000);
				System.out.println("Agent page properties and selected properties both are same");
			}
		}
	}

}
