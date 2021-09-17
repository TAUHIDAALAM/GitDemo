package org.testng_sample;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Jquery {

	WebDriver driver;
	String Browser = "chrome";

	@Test
	public void testCase1() throws InterruptedException {
		//SoftAssert st = new SoftAssert();

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

		driver.get("https://www.rediff.com/");// open browser
		driver.manage().window().maximize(); // maximize browser
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		List<WebElement> link = driver.findElements(By.tagName("a"));
		System.out.println("total link = " +link.size());
		
		for (WebElement x : link) {
			System.out.println(x.getText());
			
			if (!x.getText().isEmpty()) {
				
				System.out.println(x.getText());
				
			}
			
		}
		
		
		
	
}
}
