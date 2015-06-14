package systemobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void clickOnLogoutBtn() {
		driver.findElement(By.linkText("Logout")).click();
	}

}
