package testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import baseclass.Base;
import pages.HomePage;
import pages.LoginPage;
import ultilities.ExcelUtility;

public class HomeTest extends Base {
	@Test
	public void verifyWhetherTheUserIsAbleToLogout() throws IOException
	{
		String username=ExcelUtility.getStringData(0, 0,"LoginPage");
		String password=ExcelUtility.getStringData(0, 1,"LoginPage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnLoginButton();
		
		HomePage homepage=new HomePage(driver);
		homepage.clickOnAdminButton();
		homepage.clickOnLoginButton();
		
		
	}
	
	

}
