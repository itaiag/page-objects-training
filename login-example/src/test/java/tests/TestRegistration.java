package tests;

import org.junit.Assert;
import org.junit.Test;

import systemobjects.HomePage;
import systemobjects.LoginPage;
import systemobjects.RegisterPage;
import tests.base.InitializeDriverTestCase;

public class TestRegistration extends InitializeDriverTestCase {
	private static final String FIRST_NAME = "Itai";
	private static final String LAST_NAME = "Agmon";
	private static final String PASSWORD = "s3cret";

	@Test
	public void testRegisterAndLogin() throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		RegisterPage registerPage = loginPage.
				clickOnRegisterLnkAndGoToRegisterPage();

		String userName = FIRST_NAME + String.valueOf(System.currentTimeMillis());
		loginPage = registerPage.
				typeToFirstName(FIRST_NAME).
				typeToLastName(LAST_NAME).
				typeToUserName(userName).
				typeToPasswordTb(PASSWORD).
				clickOnRegisterBtnAndGoToLoginPage();
		

		// OH MY GOD... DON'T USE SLEEP!!!
		Thread.sleep(1000);

		HomePage homePage = loginPage.
				typeToUserNameTb(userName).
				typeToPasswordTb(PASSWORD).
				clickOnLoginBtnAndGoToHomePage();
		

		homePage.clickOnLogoutBtnAndGoLoginPage();

	}

	@Test
	public void testLoginWithWrongPassword() throws Exception {
		String text = new LoginPage(driver).
				typeToUserNameTb(FIRST_NAME).
				typeToPasswordTb("WRONG PASSWORD").
				clickOnLoginBtnAndDoNotLogin().
				waitForAlertMessage();
		
		Assert.assertEquals("Username or password is incorrect", text);
	}

}
