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
		wait.until(ExpectedConditions.titleContains("AngularJS User Registration"));
	}
	
	public HomePage doLogin(String userName, String password){
		typeToUserNameTb(userName);
		typeToPasswordTb(password);
		return clickOnLoginBtnAndGoToHomePage();
	}

	public LoginPage typeToUserNameTb(String userName) {
		actionBot.sendKeysToElementLocatedBy(userNameBy, userName);
		return this;
	}

	public LoginPage typeToPasswordTb(String password) {
		actionBot.sendKeysToElementLocatedBy(passwordBy, password);
		return this;
	}

	public HomePage clickOnLoginBtnAndGoToHomePage() {
		actionBot.clickOnElementLocatedBy(loginBtnBy);
		return new HomePage(driver);
	}

	public LoginPage clickOnLoginBtnAndDoNotLogin() {
		actionBot.clickOnElementLocatedBy(loginBtnBy);
		return this;
	}

	public RegisterPage clickOnRegisterLnkAndGoToRegisterPage() {
		actionBot.clickOnElementLocatedBy(registerLnkBy);
		return new RegisterPage(driver);
	}

	public String waitForAlertMessage() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement alertElement = wait.until(ExpectedConditions.visibilityOfElementLocated(alertDivBy));
		return alertElement.getText();
	}

}
