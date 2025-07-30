package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseclass.Base;
import constant.Constants;
import constant.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategoryPage;
import ultilities.ExcelUtility;

public class ManageCategoryTest extends Base {

	HomePage homepage;
	ManageCategoryPage managecategory;

	@Test(description = "Verify that the user can search for the added category")
	public void searchingTheAddedCategory() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password);
		homepage = loginpage.clickOnLoginButton();

		// ManageCategoryPage manageCategory=new ManageCategoryPage(driver);
		managecategory = homepage.clickOnManageCategoryIcon();
		managecategory.clickOnSearchIcon().enterSearchTitleOnSearchCategoryField().clickOnSearchButton();

		String expected = Constants.CATEGORYSEARCHINPUT;
		String actual = managecategory.getSearchedItemFromSearchList();
		Assert.assertEquals(actual, expected, Messages.ADDEDCATEGORYSEARCHERROR);
	}

}
