package systemobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends AbstractPage {

	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	public void typeToFirstName(String firstName) {
		driver.findElement(By.id("firstName")).sendKeys(firstName);
	}

	public void typeToLastName(String lastName) {
		driver.findElement(By.name("lastName")).sendKeys(lastName);
	}

	public void typeToUserName(String userName) {
		driver.findElement(By.id("username")).sendKeys(userName);
	}

	public void typeToPasswordTb(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	}

	public void clickOnRegisterBtn() {
		driver.findElement(By.tagName("button")).click();
	}

	public void clickOnCancelLnk() {
		driver.findElement(By.linkText("Cancel")).click();
	}
}
