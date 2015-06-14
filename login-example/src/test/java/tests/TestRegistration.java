package tests;

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
		RegisterPage registerPage = loginPage.clickOnRegisterLnkAndGoToRegisterPage();

		registerPage.typeToFirstName(FIRST_NAME);
		registerPage.typeToLastName(LAST_NAME);
		String userName = FIRST_NAME + String.valueOf(System.currentTimeMillis());
		registerPage.typeToUserName(userName);
		registerPage.typeToPasswordTb(PASSWORD);
		loginPage = registerPage.clickOnRegisterBtnAndGoToLoginPage();

		// OH MY GOD... DON'T USE SLEEP!!!
		Thread.sleep(1000);

		loginPage.typeToUserNameTb(userName);
		loginPage.typeToPasswordTb(PASSWORD);
		HomePage homePage = loginPage.clickOnLoginBtnAndGoToHomePage();

		homePage.clickOnLogoutBtnAndGoToHomePage();

	}

	@Test
	public void testLoginWithWrongPassword() throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		RegisterPage registerPage = loginPage.clickOnRegisterLnkAndGoToRegisterPage();

		registerPage.typeToFirstName(FIRST_NAME);
		registerPage.typeToLastName(LAST_NAME);
		String userName = FIRST_NAME + String.valueOf(System.currentTimeMillis());
		registerPage.typeToUserName(userName);
		registerPage.typeToPasswordTb(PASSWORD);
		loginPage = registerPage.clickOnRegisterBtnAndGoToLoginPage();

		// OH MY GOD... DON'T USE SLEEP!!!
		Thread.sleep(1000);

		loginPage.typeToUserNameTb(userName);
		loginPage.typeToPasswordTb("WRONG PASSWORD");
		loginPage.clickOnLoginBtnAndGoToHomePage();

	}

}
