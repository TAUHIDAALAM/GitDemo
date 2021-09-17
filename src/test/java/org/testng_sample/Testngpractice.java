package org.testng_sample;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testngpractice extends BaseClass {

	
	@Parameters({ "Username", "password" })
	@Test

	private void homepage(String names, String passed) {

		chromeBrowser();
		openUrl("https://www.facebook.com/");
		WebElement number = driver.findElement(By.name("email"));
		number.sendKeys(names);
		WebElement pwd = driver.findElement(By.name("pass"));
		pwd.sendKeys(passed);

	}

}
