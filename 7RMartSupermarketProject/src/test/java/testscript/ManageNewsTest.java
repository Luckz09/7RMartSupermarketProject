package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseclass.Base;
import pages.LoginPage;
import pages.ManageNewsPage;
import ultilities.ExcelUtility;

public class ManageNewsTest extends Base{
	
	@Test
	public void addingNewNews() throws IOException
	{
		String username=ExcelUtility.getStringData(0, 0,"LoginPage");
		String password=ExcelUtility.getStringData(0, 1,"LoginPage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnLoginButton();
		
		ManageNewsPage managenews=new ManageNewsPage(driver);
		managenews.clickMoreInfoIcon();

        managenews.clickOnAddIcon();
		managenews.enteringNewNews();
		managenews.clickOnSaveButton();
		
		boolean alertDisplayed=managenews.isCreatedSuccessfullyAlertDisplayed();
		Assert.assertTrue(alertDisplayed);
		
	}
	@Test
	public void searchAddedNews() throws IOException
	{
		String username=ExcelUtility.getStringData(0, 0,"LoginPage");
		String password=ExcelUtility.getStringData(0, 1,"LoginPage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnLoginButton();
		
		ManageNewsPage managenews=new ManageNewsPage(driver);
		managenews.clickMoreInfoIcon();
		
		managenews.clickOnSearchIcon();
		managenews.enteringNewsTitleOnSearchNewsField();
		managenews.clickOnSearchButton();
		
		String expected="Testing News Area";
		String actual=managenews.getNewsFromSearchedList();
		Assert.assertEquals(expected,actual,"User was unable to search news");
		
		
	}

}
