package org.testng_sample;

import org.testng.annotations.Test;

public class Testngpractice3 {

	@Test(priority=3)

	private void tc111() {
		System.out.println("Test case 111");
	}

	@Test(priority=1)

	private void tc222() {
		System.out.println("Test case 222");
	}

	@Test(priority=2)

	private void tc333() {
		System.out.println("Test case 333");
	}

}
