package methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.webconnector;

public class homepagemethods {
	
	@FindBy(id="buy")
    public static WebElement clickOnArrangementbutton;
	
	
	public static void clickbutton(){
try {
	Thread.sleep(2000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		clickOnArrangementbutton.isEnabled();
		clickOnArrangementbutton.click();
	}

	
	public static void handleAlert(){
	webconnector.driver.switchTo().alert().accept();
	}
	
}
