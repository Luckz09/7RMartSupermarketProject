package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseclass.Base;
import constant.Messages;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import ultilities.ExcelUtility;
import ultilities.FakerUtility;

public class AdminUserTest extends Base {
	HomePage homepage;
	AdminUserPage adminuser;
	@Test (description = "verify admin can add new user")
	public void verifyThatAdminCanAddNewUser() throws IOException
	{
		String username=ExcelUtility.getStringData(0, 0,"LoginPage");
		String password=ExcelUtility.getStringData(0,1,"LoginPage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password);
		homepage=loginpage.clickOnLoginButton();
		
		//AdminUserPage adminuser=new AdminUserPage(driver);
		adminuser=homepage.clickOnAdminIcon();
		//adminuser.clickOnAdminIcon();
		
		FakerUtility fakerutility=new FakerUtility();
		String newUserName=fakerutility.createRandomUserName();
		String newPassword=fakerutility.createRandomPassword();
		adminuser.clickOnAddNewUserIcon().enterNewUserNameOnUSerNameField(newUserName).enterNewPasswordOnPasswordField(newPassword).selectUserTypeFromDropDownList().clickOnSaveButton();
		
		boolean alertMsg=adminuser.getAlertMessage();
		Assert.assertTrue(alertMsg,Messages.USERADDERRORMSG);
	}
	@Test(description = "verify that admin can search for a added user")
	public void verifyThatAdminCanSearchOnAddedUser() throws IOException
	{
		String username=ExcelUtility.getStringData(0, 0,"LoginPage");
		String password=ExcelUtility.getStringData(0,1,"LoginPage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password);
		homepage=loginpage.clickOnLoginButton();
		
		//AdminUserPage adminuser=new AdminUserPage(driver);
		adminuser=homepage.clickOnAdminIcon();
		adminuser.clickOnSearchIcon().enterUserNameOnUserNameFiledInSearch().selectUserTypefromDropDownInSearch().clickOnSearchButton();
		

		String expected="user1234567";
		String actual=adminuser.getUserNameFromSeachedList();
		Assert.assertEquals(expected,actual,Messages.USERSEARCHERRORMSG);
	}
	@Test(description = "Verify that the admin can use the reset functionality ")
	public void verifyThatAdminCanReset() throws IOException
	{
		String username=ExcelUtility.getStringData(0, 0,"LoginPage");
		String password=ExcelUtility.getStringData(0,1,"LoginPage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password);
		homepage=loginpage.clickOnLoginButton();
		
		//AdminUserPage adminuser=new AdminUserPage(driver);
		adminuser=homepage.clickOnAdminIcon();
		adminuser.clickOnResetIcon();
	}

}
