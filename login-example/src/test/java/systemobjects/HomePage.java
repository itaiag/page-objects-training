package systemobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage {
	
	private By logoutLnkBy = By.linkText("Logout");

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public LoginPage clickOnLogoutBtnAndGoToLoginPage() {
		driver.findElement(logoutLnkBy).click();
		return new LoginPage(driver);
	}

}
