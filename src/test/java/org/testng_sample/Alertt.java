package org.testng_sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alertt {

	
	WebDriver driver;
	String Browser = "chrome";

	@Test
	public void testCase3() throws InterruptedException {
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

		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");// open browser
		driver.manage().window().maximize(); // maximize browser
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[2]/div[2]/input[2]")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		Thread.sleep(3000);

		System.out.println("Alert text is" + alert.getText());
		
		driver.findElement(By.xpath("//input[@id='login1']")).sendKeys("shakemohammad");
		st.assertAll();
		
}
}