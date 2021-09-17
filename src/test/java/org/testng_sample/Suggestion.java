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

public class Suggestion {

	WebDriver driver;
	String Browser = "chrome";

	@Test
	public void testCase1() throws InterruptedException {
		// SoftAssert st = new SoftAssert();

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

		driver.get("https://in.search.yahoo.com/?fr2=inr");// open browser
		driver.manage().window().maximize(); // maximize browser
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.name("p")).sendKeys("Bang");

		List<WebElement> li = driver.findElements(By.xpath(
				"//body/div[@id='purple-syc']/div[@id='bd']/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li/span[1]"));
		for (WebElement x : li) {

			if (x.getText().equalsIgnoreCase("bangladesh")) {

				x.click();
				break;

			}

		}

	}

}
