package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseclass.Base;
import pages.LoginPage;
import ultilities.ExcelUtility;

public class LoginTest extends Base {
	@Test(retryAnalyzer = retry.ReTry.class,priority = 1 ,description="Veify user login with valid credentials" )
	public void verifyLoginWithValidCredentials() throws IOException
	{
		String username=ExcelUtility.getStringData(0, 0,"LoginPage");
		String password=ExcelUtility.getStringData(0,1,"LoginPage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnLoginButton();
		
		boolean dashboarddisplayed=loginpage.isDashBoardDisplayed();
		Assert.assertTrue(dashboarddisplayed,"User was unable to login with valid credentials");
		
		
		//boolean alertdisplayed=loginpage.isAlertDisplayed();
		//Assert.assertFalse(alertdisplayed,"User was unable to login with valid credentials");
	}
	@Test(priority = 2,groups = {"smoke"})
	public void verifyLoginwithInvalidUserNameAndValidPassword() throws IOException
	{
		String username=ExcelUtility.getStringData(1, 0, "LoginPage");
		String password=ExcelUtility.getStringData(1, 1, "LoginPage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnLoginButton();
		
		String expected="7rmart supermarket"; 
		String actual=loginpage.getTextFromTitle();
		Assert.assertEquals(actual,expected,"User was able to login with invalid username");
		
	}
	@Test(priority = 3,groups = {"smoke"})
	public void verifyLoginWithValidUserNameAndInvalidPassword() throws IOException
	{
		String username=ExcelUtility.getStringData(2, 0,"LoginPage");
		String password=ExcelUtility.getStringData(2, 1, "LoginPage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnLoginButton();
		
		String expected="7rmart supermarket";
		String actual=loginpage.getTextFromTitle();
		Assert.assertEquals(actual,expected,"User was able to login with invalid username");
	}
	@Test(priority = 4)
	public void verifyLoginWithInValidCredentials() throws IOException
	{
		String username=ExcelUtility.getStringData(3, 0,"LoginPage");
		String password=ExcelUtility.getStringData(3, 1, "LoginPage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnLoginButton();
		
		String expected="7rmart supermarket";
		String actual=loginpage.getTextFromTitle();
		Assert.assertEquals(actual,expected,"User was able to login with invalid username");
	}
	
	
	

}
