package org.testng_sample;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testngpractice2 extends BaseClass {

	// @Parameters({ "Username", "password" })
	// @Test(dataProvider = "login",dataproviderclass= classname.class)//to import
	// data provider from diff class
	@Test(dataProvider = "login")

	private void homepage(String names, String passed) {

		chromeBrowser();
		openUrl("https://www.facebook.com/");
		WebElement number = driver.findElement(By.name("email"));
		number.sendKeys(names);
		WebElement pwd = driver.findElement(By.name("pass"));
		pwd.sendKeys(passed);
		WebElement logbut = driver.findElement(By.name("login"));
		logbut.click();

	}

	@DataProvider(name = "login")

	private Object[][] inpo() {

		return new Object[][] { { "java", "java@123" }, { "python", "python@123" }, { "sql", "sql@123" } };
	}

}