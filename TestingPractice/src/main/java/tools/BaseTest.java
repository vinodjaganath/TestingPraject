package tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	public static WebDriver driver; 

	@BeforeSuite
	public static void start() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\0045OI744\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	/*
	 * @AfterSuite public static void close() {
	 * 
	 * driver.close(); }
	 */
	}
