package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

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
	public static WebDriver open_browser() {


		if (driver == null) {

			if (getbrowsername().equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver",
						"C:\\Users\\Chandra\\Desktop\\Ides\\firefoxdriver\\geckodriver.exe");
				driver = new FirefoxDriver();
				// FirefoxProfile fp = new FirefoxProfile();
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
