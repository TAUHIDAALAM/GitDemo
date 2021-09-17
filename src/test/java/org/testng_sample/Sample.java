package org.testng_sample;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample extends BaseClass {

	WebDriver driver;
	String Browser = "chrome";

	@Test
	public void testCase1() throws InterruptedException {
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
		try {
			driver.findElement(By.xpath("//*[@id=\"nav-main\"]/div[1]/div/div/div[3]/span[1]/span/input")).click();
			driver.findElement(By.xpath("//*[@id=\"aee-xop-dismiss\"]/input")).click();
		} catch (Exception e) {
		}

		driver.findElement(By.xpath("//a[contains(text(),\"Today's Deals\")]")).click();// to select Todays deal

		driver.findElement(By.xpath("//span[contains(text(),'Beauty')]")).click();// to select beauty

		driver.findElement(By.xpath("//button[@id='100 a9d5d1b4-announce']")).click();//click on add to cart

		String text = driver.findElement(By.xpath("//div[contains(text(),'Added to Cart')]")).getText();//verify add to cart

		System.out.println("Actual Text 1=" +text);
		AssertJUnit.assertEquals(text, "Added to Cart");
		driver.quit();
		st.assertAll();

	}

}
