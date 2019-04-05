package com.flightbook.Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flightbook.Helper.FrameHelper;
import com.flightbook.TestBase.TestBase;

public class Loginpage  extends TestBase{
	
	
	
	public FrameHelper fram = null;
	
	@FindBy(css ="get_sign_in")
	WebElement Signin;
	
	@FindBy(xpath ="//span/a[contains(text(),'Sign up')]")
	WebElement Signin1;
	
	
	@FindBy(css="span[class ='fl padB3']")
	WebElement Logo;
	
	@FindBy(xpath="//input[@id='authMobile']")
	WebElement mobilenum;
	
	@FindBy(css="span>button#mobileSubmitBtn")
	WebElement singButton;
	
	
	
	@FindBy(css="span#authMobileErrorMsg")
	WebElement error;
	@FindBy(xpath = "//div/span[contains(text(),'Round trip')]")
	WebElement roundtrip;
	
	@FindBy(xpath = "//div[@id='authOverlay']/div/a")
	WebElement close;
	

	public Loginpage()
	{
		PageFactory.initElements(driver,this);
	}
	
	
	
	
	public void login(String mobile) throws InterruptedException
	{
		fram = new FrameHelper();
		roundtrip.click();
		Signin1.click();
		fram.switchByid("authiframe");
		
		System.out.println("swithc the frame");
		Thread.sleep(2000);
		mobilenum.sendKeys(mobile);
		logoispresent();
		singButton.click();
		System.out.println("clicked on singbutton");
//	String errortext=	error.getText();
//	System.out.println("error msg "+errortext);
//	WebDriverWait wait = new WebDriverWait(driver,30);
//	wait.until(ExpectedConditions.elementToBeSelected(close));
		driver.switchTo().defaultContent();
		// thread sleep to see the the alert box for demo
		Thread.sleep(5000);
		//click on the cross[X] button of the pop up
		driver.findElement(By.xpath("//div[@class='popContent']/a")).click();
		Thread.sleep(5000);
	//System.out.println("browser is closed");
	driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
	Thread.sleep(5000);
	driver.findElement(By.xpath("//a[@class='close']")).click();
	Thread.sleep(5000);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("document.getElementById('gosuggest_inputSrc').value='Pune (PNQ)'");
	js.executeScript("document.getElementById('gosuggest_inputDest').value='Mumbai (BOM)'");
	js.executeScript("document.getElementsByClassName('inputSrch curPointFlt')[0].value='Tue, 5 Jul'");
	js.executeScript("document.getElementsByClassName('inputSrch curPointFlt')[1].value='Tue, 10 Jul'");
	
//	driver.findElement(By.xpath("//span[@id='pax_label']")).click();
//	
//	js.executeScript("document.getElementById('adultPaxBox').value='1'");
//	js.executeScript("document.getElementById('childPaxBox').value='1'");
//	js.executeScript("document.getElementById('infantPaxBox').value='1'");
//	
//	js.executeScript("document.getElementById('gi_class').value='E'");
	Thread.sleep(5000);
	//driver.findElement(By.xpath("//span[@id='pax_label']")).sendKeys("2 Travellers,Business");
	
	//driver.switchTo().frame("_we_wk_data_store");
	//driver.findElement(By.xpath("//a[@id='pax_close']")).click();
//	driver.switchTo().defaultContent();
	//driver.findElement(By.xpath("//div/a[@id='pax_close']")).click();
	//js.executeScript("document.getElementById('pax_close').click();");
	System.out.println("close popup");
	Thread.sleep(5000);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
//	js.executeScript("document.getElementById('gi_search_btn').click();");
	System.out.println("clicked on search");
	//Thread.sleep(5000);
	//driver.findElement(By.xpath("//button[@value='Search']")).click();
	
	}
	public void logoispresent()
	{
	boolean flag	=Logo.isDisplayed();
	if(flag == true)
	{
		System.out.println("logo is present");
	}
	else
	{
		System.out.println("logo is not present");
	}
	}
	
	
}