package Utilities;

import java.util.concurrent.TimeUnit;

public class util {

	
	 public static  void  gotowebsite(){

      if(!webconnector.driver.getCurrentUrl().contains("marksandspencer")) {
       System.out.println("gotoweb");
           webconnector.driver.manage().window().maximize();
           webconnector.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
           webconnector.driver.get("http://www.rightmove.co.uk/");
       }



}
}
