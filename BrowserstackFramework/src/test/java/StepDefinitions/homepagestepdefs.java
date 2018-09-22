package StepDefinitions;

import java.io.IOException;


import org.openqa.selenium.support.PageFactory;

import Utilities.util;
import Utilities.webconnector;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import methods.homepagemethods;

public class homepagestepdefs {

	public homepagemethods homepage_method;

	//dfkdjfjf
	//fdsfhfdshf
    public homepagestepdefs() throws IOException {
    	webconnector.intialise();
      homepage_method  =PageFactory.initElements(webconnector.open_browser(),homepagemethods.class);

    }
    
	@Before()
	public void firstbefore() throws IOException{
		System.out.println("Before Method");
	//	webconnector.intialise();
		webconnector.open_browser();
		System.out.println("*************");
    	webconnector.gotowebsite();
		
	}
	
	/*@After()
	public void firstafter(){
		System.out.println("after Method");
		webconnector.driver.quit();
		
	}*/
	
	/*@After("@web")
	public void secondafter(){
		
		webconnector.driver.quit();
	}
	*/
	
	@Given("^First scenario first line$")
	public void first_scenario_first_line()  {
	    System.out.println("First Line First Scenario");
	    homepage_method.clickbutton();

	}

	
	@Then("^First scenario handle alert$")
	public void first_scenario_handle_alert()  {
	    homepage_method.handleAlert();
	}
	
}
