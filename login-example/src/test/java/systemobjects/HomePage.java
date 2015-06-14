package systemobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends AbstractPage {
	
	private By logoutLnkBy = By.linkText("Logout");
	private By titleHBy = By.tagName("h1");

	public HomePage(WebDriver driver) {
		super(driver);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(titleHBy, "Hi"));
	}

	public LoginPage clickOnLogoutBtnAndGoToLoginPage() {
		driver.findElement(logoutLnkBy).click();
		return new LoginPage(driver);
	}

}
