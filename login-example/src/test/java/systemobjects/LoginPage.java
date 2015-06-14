package systemobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void typeToUserNameTb(String userName){
		driver.findElement(By.id("username")).sendKeys(userName);
	}
	
	public void typeToPasswordTb(String password){
		driver.findElement(By.id("password")).sendKeys(password);
	}
	
	public HomePage clickOnLoginBtnAndGoToHomePage(){
		driver.findElement(By.tagName("button")).click();
		return new HomePage(driver);
	}
	
	public void clickOnLoginBtnAndDoNotLogin(){
		driver.findElement(By.tagName("button")).click();
	}

	
	public RegisterPage clickOnRegisterLnkAndGoToRegisterPage(){
		driver.findElement(By.linkText("Register")).click();
		return new RegisterPage(driver);
	}
	
	public String waitForAlertMessage(){
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement alertElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert")));
		return alertElement.getText();
	}
	
}
