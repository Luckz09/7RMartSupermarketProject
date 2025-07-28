package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseclass.Base;
import pages.LoginPage;
import pages.ManageCategoryPage;
import ultilities.ExcelUtility; 

public class ManageCategoryTest extends Base {
	@Test
	public void addingNewCategoryToCategoryPage() throws IOException
	{
		String username=ExcelUtility.getStringData(0, 0,"LoginPage");
		String password=ExcelUtility.getStringData(0, 1,"LoginPage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnLoginButton();
		
		ManageCategoryPage manageCategory=new ManageCategoryPage(driver);
		manageCategory.clickOnMoreInfoIcon();
		manageCategory.clickOnNewIcon();
		manageCategory.enterCategoryOnAddCategoryField();
		manageCategory.uploadImageOnChooseFileField();
		manageCategory.scrollDownOfAddCategoryPage();
		manageCategory.clickOnSaveButton();
		
	}
	
	@Test
	public void searchingTheAddedCategory() throws IOException
	{
		String username=ExcelUtility.getStringData(0, 0,"LoginPage");
		String password=ExcelUtility.getStringData(0, 1,"LoginPage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnLoginButton();
		
		
		ManageCategoryPage manageCategory=new ManageCategoryPage(driver);
		manageCategory.clickOnMoreInfoIcon();
		manageCategory.clickOnSearchIcon();
		manageCategory.enterSearchTitleOnSearchCategoryField();
		manageCategory.clickOnSearchButton();
		
		String expected="Apple123";
		String actual=manageCategory.getSearchedItemFromSearchList();
		Assert.assertEquals(actual,expected,"User is unable to search items");
	}

}
