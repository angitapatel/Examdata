package stepdef;

import com.flightbook.Pageobject.Loginpage;
import com.flightbook.TestBase.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Loginstep extends TestBase {
	
	
	
public 	Loginpage login = null;
	 public TestBase test =new TestBase();
	
	@Given("^open the website page$")
	public void open_the_website_page() throws Throwable {
	test.init();
	login = new Loginpage();
	System.out.println("second step");
		login.login("9552519252");
	
	   
	}

	@When("^user click on signup$")
	public void user_click_on_signup() throws Throwable {
	  
	}

	@Then("^Registration popup should be open$")
	public void registration_popup_should_be_open() throws Throwable {
	  
	}

}
