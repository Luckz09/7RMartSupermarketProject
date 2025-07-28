package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseclass.Base;
import pages.AdminUserPage;
import pages.LoginPage;
import ultilities.ExcelUtility;
import ultilities.FakerUtility;

public class AdminUserTest extends Base {
	@Test
	public void verifyThatAdminCanAddNewUser() throws IOException
	{
		String username=ExcelUtility.getStringData(0, 0,"LoginPage");
		String password=ExcelUtility.getStringData(0,1,"LoginPage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnLoginButton();
		
		AdminUserPage adminuser=new AdminUserPage(driver);
	
		adminuser.clickOnAdminIcon();
		adminuser.clickOnAddNewUserIcon();
		FakerUtility fakerutility=new FakerUtility();
		String newUserName=fakerutility.createRandomUserName();
		String newPassword=fakerutility.createRandomPassword();
		adminuser.enterNewUserNameOnUSerNameField(newUserName);
		adminuser.enterNewPasswordOnPasswordField(newPassword);
		adminuser.selectUserTypeFromDropDownList();
		adminuser.clickOnSaveButton();
		
		String expected="user1234567";
		String actual=adminuser.getUserNameFromAddedList();
		Assert.assertEquals(expected,actual,"Admin was unable to add new user");
	}
	@Test
	public void verifyThatAdminCanSearchOnAddedUser() throws IOException
	{
		String username=ExcelUtility.getStringData(0, 0,"LoginPage");
		String password=ExcelUtility.getStringData(0,1,"LoginPage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnLoginButton();
		
		AdminUserPage adminuser=new AdminUserPage(driver);
		adminuser.clickOnAdminIcon();
		adminuser.clickOnSearchIcon();
		adminuser.enterUserNameOnUserNameFiledInSearch();
		adminuser.selectUserTypefromDropDownInSearch();
		adminuser.clickOnSearchButton();
		

		String expected="user1234567";
		String actual=adminuser.getUserNameFromSeachedList();
		Assert.assertEquals(expected,actual,"Admin was unable to search for a perticular username");
	}

}
