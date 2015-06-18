package systemobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionBot {
	
	private final WebDriver driver;
	
	public ActionBot(WebDriver driver){
		this.driver = driver;
	}
	
	public void clickOnElementLocatedBy(By by){
		WebElement element = driver.findElement(by);
		element.clear();
		element.click();
	}
	
	public void sendKeysToElementLocatedBy(By by,String keys){
		WebElement element = driver.findElement(by);
		element.sendKeys(keys);
	}
	
}
