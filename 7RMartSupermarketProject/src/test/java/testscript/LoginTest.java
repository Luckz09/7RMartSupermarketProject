package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseclass.Base;
import constant.Messages;
import pages.HomePage;
import pages.LoginPage;
import ultilities.ExcelUtility;

public class LoginTest extends Base {
	HomePage homepage;

	@Test(retryAnalyzer = retry.ReTry.class, priority = 1, description = "Veify user login with valid credentials")
	public void verifyLoginWithValidCredentials() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password);
		homepage = loginpage.clickOnLoginButton();

		boolean dashboarddisplayed = loginpage.isDashBoardDisplayed();
		Assert.assertTrue(dashboarddisplayed, Messages.VALIDCREDENTIALMSG);

	}

	@Test(priority = 2, groups = { "smoke" }, description = "Veify user login with invalid username and valid password")
	public void verifyLoginwithInvalidUserNameAndValidPassword() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnLoginButton();

		String expected = "7rmart supermarket";
		String actual = loginpage.getTextFromTitle();
		Assert.assertEquals(actual, expected, Messages.INVALIDUSERNAMEMSG);

	}

	@Test(priority = 3, groups = { "smoke" }, description = "Veify user login with valid username and invalid password")
	public void verifyLoginWithValidUserNameAndInvalidPassword() throws IOException {
		String username = ExcelUtility.getStringData(2, 0, "LoginPage");
		String password = ExcelUtility.getStringData(2, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnLoginButton();

		String expected = "7rmart supermarket";
		String actual = loginpage.getTextFromTitle();
		Assert.assertEquals(actual, expected, Messages.INVALIDPASSWORDMSG);
	}

	@Test(priority = 4, description = "Veify user login with invalid credentials", dataProvider = "loginProvider")
	public void verifyLoginWithInValidCredentials(String username, String password) throws IOException {
		// String username=ExcelUtility.getStringData(3, 0,"LoginPage");
		// String password=ExcelUtility.getStringData(3, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnLoginButton();

		String expected = "7rmart supermarket";
		String actual = loginpage.getTextFromTitle();
		Assert.assertEquals(actual, expected, Messages.INVALIDCREDENTIALS);
	}

	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {
		return new Object[][] { new Object[] { "admin", "admin234" }, new Object[] { "admin123", "123" },
				// new Object[] {ExcelUtility.getStringData(3,
				// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
		};
	}

}
