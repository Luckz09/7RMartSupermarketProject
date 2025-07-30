package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseclass.Base;
import constant.Messages;
import pages.HomePage;
import pages.LoginPage;
import ultilities.ExcelUtility;

public class HomeTest extends Base {
	HomePage homepage;
	@Test (description = "verify user can logout")
	public void verifyWhetherTheUserIsAbleToLogout() throws IOException
	{
		String username=ExcelUtility.getStringData(0, 0,"LoginPage");
		String password=ExcelUtility.getStringData(0, 1,"LoginPage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password);
		homepage=loginpage.clickOnLoginButton();
		
		homepage.clickOnAdminButton();
		loginpage=homepage.clickOnLogoutButton();
		
		boolean prjTitleDisplayed=homepage.IsProjectTitleDisplayedOnLoginPage();
		Assert.assertTrue(prjTitleDisplayed,Messages.USERLOGOUTERRORMSG);
		
	}
	
	

}
