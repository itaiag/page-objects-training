package systemobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

	public LoginPage clickOnRegisterBtnAndGoToLoginPage() {
		driver.findElement(By.tagName("button")).click();
		return new LoginPage(driver);
	}

	public LoginPage clickOnCancelLnk() {
		driver.findElement(By.linkText("Cancel")).click();
		return new LoginPage(driver);
	}

	public String waitForAlertMessage() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement alertElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert")));
		return alertElement.getText();
	}
}
