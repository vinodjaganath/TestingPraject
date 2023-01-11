package tools;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CommonOperations extends BaseTest{

	
	public static void takeScreenshot()throws IOException {
		TakesScreenshot scrShot =((TakesScreenshot)driver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        String timestamp=new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
        String path="C:\\Users\\0045OI744\\eclipse-workspace\\TestingPractice\\test-output\\Report\\Testing"+timestamp;
        File folder=new File(path);
        folder.mkdirs();
        File DestFile=new File(path+"\\screen"+timestamp+".png");
        FileUtils.copyFile(SrcFile, DestFile);
        
}
	
	public static void navigate(String URL) {
		driver.manage().window().maximize();
		driver.get(URL);
	}
	
	public static void click(String locator) {
		driver.findElement(By.id(locator)).click();
	}

	public static void input(String locator, String input) {
		driver.findElement(By.xpath(locator)).sendKeys(input);
	}

	public static void mousehover(String locator) {
		WebElement e1=driver.findElement(By.xpath(locator));
		  Actions actions = new Actions(driver); 
		  actions.moveToElement(e1);    
	}

	public static void dragAndDrop(String src, String tar) {
		WebElement e1=driver.findElement(By.xpath(src));
		WebElement e2=driver.findElement(By.xpath(src));
		  Actions actions = new Actions(driver); 
		  actions.moveToElement(e1); 
		  actions.clickAndHold();		   
		   actions.moveToElement(e2); 
		   actions.release().perform(); 
	}

	public static void dropDown(String src, String value) {
		Select s1=new Select(driver.findElement(By.xpath(src)));
		s1.selectByVisibleText(value);
	}
public void waitTillLoading() throws InterruptedException {
	Thread.sleep(10000);
}
	
public static void scrollIntoview(String locator) throws InterruptedException {
	 WebElement e1=driver.findElement(By.xpath(locator));
       ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", e1);
     Thread.sleep(800);
}
	

}
