package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class webconnector {

	public static WebDriver driver = null;
	public static String browser = null;
	static FileInputStream configfile = null;
	static Properties prop = null;

	public static void intialise() throws IOException {
		configfile = new FileInputStream("src\\main\\java\\Config.properties");
		prop = new Properties();
		prop.load(configfile);

	}

	public static String getbrowser() {
		return browser = prop.getProperty("browser");

	}

	public static String getbrowsername() {
		return browser = "chrome";

	}

	/////////////////////////////////////// OPEN BROWSER////////////////////////////////////////////////////////
	public static WebDriver open_browser() throws MalformedURLException {

		if (driver == null) {
			if (getbrowser().equalsIgnoreCase("Firefox")) {
				DesiredCapabilities capability = DesiredCapabilities.chrome();
			    capability.setPlatform(Platform.WINDOWS);
			    capability.setCapability("build2", "JUnit - Sample");
			    driver = new RemoteWebDriver(
			      new URL("https://chandrasekhar46:t5xApL32c33yw2zEvMZm@hub-cloud.browserstack.com/wd/hub"),capability );

				
				
				
			/*	System.setProperty("webdriver.gecko.driver",
						"C:\\Users\\Chandra\\Desktop\\Ides\\firefoxdriver\\geckodriver.exe");
				driver = new FirefoxDriver();
			*/	// FirefoxProfile fp = new FirefoxProfile();
				// fp.setPreference("xpinstall.signatures.required", false);
				// fp.setPreference("toolkit.telemetry.reportingpolicy.firstRun",
				// false);
				//

			} else if (getbrowser().equalsIgnoreCase("chrome")) {

				System.setProperty("webdriver.chrome.driver", "C:/Users/Chandra/Desktop/Ides/C_dr/chromedriver.exe");
				driver = new ChromeDriver();

				// org.openqa.selenium.Dimension d = new
				// org.openqa.selenium.Dimension(1024,786);
				// driver.manage().window().setSize(d);

				/*
				 * System.setProperty("webdriver.chrome.driver",
				 * "C:\\Users\\Chandra\\Desktop\\Ides\\cdriver\\chromedriver.exe"
				 * ); DesiredCapabilities capabilities =
				 * DesiredCapabilities.chrome(); ChromeOptions options = new
				 * ChromeOptions(); options.addArguments("test-type");
				 * capabilities.setCapability("chrome.binary",
				 * "C:\\Users\\Chandra\\Desktop\\Ides\\cdriver\\chromedriver.exe"
				 * ); capabilities.setCapability(ChromeOptions.CAPABILITY,
				 * options);
				 * 
				 * driver = new ChromeDriver(capabilities);
				 */

			} else if (getbrowsername().equalsIgnoreCase("IE")) {

				System.setProperty("webdriver.ie.driver", "C:\\Users\\Chandra\\Desktop\\Ides\\IE\\IEDriverServer.exe");
				DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
				ieCapabilities.setCapability("nativeEvents", false);
				ieCapabilities.setCapability("unexpectedAlertBehaviour", "accept");
				ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
				ieCapabilities.setCapability("disable-popup-blocking", true);
				ieCapabilities.setCapability("enablePersistentHover", true);
				driver = new InternetExplorerDriver(ieCapabilities);

			}

		}

		System.out.println(driver.getTitle());
		return driver;
	}

	public static void gotowebsite() {

		if (!webconnector.driver.getCurrentUrl().contains("marksandspencer")) {
			System.out.println("goingtoweb");
			webconnector.driver.manage().window().maximize();
			webconnector.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			webconnector.driver.get(prop.getProperty("url"));
		}
	}
}
