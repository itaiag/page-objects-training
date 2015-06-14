package systemobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage {
	
	public HomePage(WebDriver driver){
		super(driver);
	}
	
	public HomePage clickOnLogoutBtnAndGoToHomePage(){
		driver.findElement(By.linkText("Logout")).click();
		return new HomePage(driver);
	}
	
}
