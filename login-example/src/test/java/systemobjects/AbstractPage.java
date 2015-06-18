package systemobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

	protected final WebDriver driver;
	protected final WebDriverWait wait;
	protected final ActionBot actionBot;
	

	public AbstractPage(final WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,30);
		actionBot = new ActionBot(driver);
	}

}
