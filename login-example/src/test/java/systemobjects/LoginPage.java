package systemobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPage {
	
	private By userNameBy = By.id("username");
	private By passwordBy = By.id("password");
	private By loginBtnBy = By.tagName("button");
	private By registerLnkBy = By.linkText("Register");
	private By alertDivBy = By.className("alert");
	

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void typeToUserNameTb(String userName) {
		driver.findElement(userNameBy).sendKeys(userName);
	}

	public void typeToPasswordTb(String password) {
		driver.findElement(passwordBy).sendKeys(password);
	}

	public HomePage clickOnLoginBtnAndGoToHomePage() {
		driver.findElement(loginBtnBy).click();
		return new HomePage(driver);
	}

	public void clickOnLoginBtnAndDoNotLogin() {
		driver.findElement(loginBtnBy).click();
	}

	public RegisterPage clickOnRegisterLnkAndGoToRegisterPage() {
		driver.findElement(registerLnkBy).click();
		return new RegisterPage(driver);
	}

	public String waitForAlertMessage() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement alertElement = wait.until(ExpectedConditions.visibilityOfElementLocated(alertDivBy));
		return alertElement.getText();
	}

}
