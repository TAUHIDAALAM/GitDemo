package org.testng_sample;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.assertthat.selenium_shutterbug.core.Shutterbug;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot {

	
	WebDriver driver;
	String Browser = "chrome";

	@Test
	public void testCase3() throws InterruptedException, Throwable {
		SoftAssert st = new SoftAssert();

		if (Browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (Browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else if (Browser.equalsIgnoreCase("mozilla")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.get("https://www.amazon.com/");// open browser
		driver.manage().window().maximize(); // maximize browser
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//			File screenshotAs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//			FileHandler.copy(screenshotAs, new File("test.png"));
		
		//Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE).withName("TestFullpage").save();// Full page screenshot
		
		WebElement flag = driver.findElement(By.xpath("//*[@id='icp-nav-flyout']/span/span[2]/span[1]"));
		Shutterbug.shootElement(driver, flag).withName("flag1").save();//particular image in a page
		
	

}
}
