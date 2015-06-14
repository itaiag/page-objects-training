package systemobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends AbstractPage {

	private By firstNameTbBy = By.id("firstName");
	private By lastNameTbBy = By.name("lastName");
	private By userNameTbBy = By.id("username");
	private By passwordTbBy = By.id("password");
	private By registerBtnBy = By.tagName("button");
	private By cancelLnkBy = By.linkText("Cancel");
	private By alertDivBy = By.className("alert");

	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	public RegisterPage typeToFirstName(String firstName) {
		driver.findElement(firstNameTbBy).sendKeys(firstName);
		return this;
	}

	public RegisterPage typeToLastName(String lastName) {
		driver.findElement(lastNameTbBy).sendKeys(lastName);
		return this;
	}

	public RegisterPage typeToUserName(String userName) {
		driver.findElement(userNameTbBy).sendKeys(userName);
		return this;
	}

	public RegisterPage typeToPasswordTb(String password) {
		driver.findElement(passwordTbBy).sendKeys(password);
		return this;
	}

	public LoginPage clickOnRegisterBtnAndGoToLoginPage() {
		driver.findElement(registerBtnBy).click();
		return new LoginPage(driver);
	}

	public LoginPage clickOnCancelLnk() {
		driver.findElement(cancelLnkBy).click();
		return new LoginPage(driver);
	}

	public String waitForAlertMessage() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement alertElement = wait.until(ExpectedConditions.visibilityOfElementLocated(alertDivBy));
		return alertElement.getText();
	}
}
