package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import tests.base.InitializeDriverTestCase;

public class TestRegistration extends InitializeDriverTestCase {
	private static final String FIRST_NAME = "Itai";
	private static final String LAST_NAME = "Agmon";
	private static final String PASSWORD = "s3cret";

	@Test
	public void testRegisterAndLogin() throws Exception {
		String userName = registerNewUser(FIRST_NAME, LAST_NAME, PASSWORD);
		Login(userName, PASSWORD);
		logout();
	}

	private void logout() {
		driver.findElement(By.linkText("Logout")).click();
	}

	private void Login(String userName, String password) {
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.tagName("button")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By
				.xpath("//h1[text()='Hi " + FIRST_NAME + "!']")));
	}

	private String registerNewUser(String firstName, String lastName, String password) {
		// Register new user
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("firstName")).sendKeys(firstName);
		driver.findElement(By.name("lastName")).sendKeys(lastName);
		String userName = FIRST_NAME + String.valueOf(System.currentTimeMillis());
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.tagName("button")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By
				.xpath("//div[text()='Registration successful']")));
		return userName;
	}

}
