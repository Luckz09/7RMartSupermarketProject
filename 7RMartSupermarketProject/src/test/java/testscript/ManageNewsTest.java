package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseclass.Base;
import constant.Constants;
import constant.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import ultilities.ExcelUtility;

public class ManageNewsTest extends Base{
	HomePage homepage;
	ManageNewsPage managenews;
	@Test
	public void verifyWhetherUserCanAddNewNews() throws IOException
	{
		String username=ExcelUtility.getStringData(0, 0,"LoginPage");
		String password=ExcelUtility.getStringData(0, 1,"LoginPage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password);
		homepage=loginpage.clickOnLoginButton();
		
		//ManageNewsPage managenews=new ManageNewsPage(driver);
		managenews=homepage.clickOnManageNewsIcon();

        managenews.clickOnAddIcon().enteringNewNews().clickOnSaveButton();
		
		boolean alertDisplayed=managenews.isCreatedSuccessfullyAlertDisplayed();
		Assert.assertTrue(alertDisplayed,Messages.USERADDEDNEWSERRORMSG);
		
	}
	@Test
	public void verifyWhetherUserCanSearchAddedNews() throws IOException
	{
		String username=ExcelUtility.getStringData(0, 0,"LoginPage");
		String password=ExcelUtility.getStringData(0, 1,"LoginPage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password);
		homepage=loginpage.clickOnLoginButton();
		
		//ManageNewsPage managenews=new ManageNewsPage(driver);
		managenews=homepage.clickOnManageNewsIcon();
		
		managenews.clickOnSearchIcon().enteringNewsTitleOnSearchNewsField().clickOnSearchButton();
		
		String expected=Constants.NEWSCONTENT;
		String actual=managenews.getNewsFromSearchedList();
		Assert.assertEquals(expected,actual,Messages.USERSEARCHADDEDNEWSERRORMSG);
		
		
	}

}
