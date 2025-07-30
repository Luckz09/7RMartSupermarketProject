package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constants;
import ultilities.PageUtility;

public class AdminUserPage {

	WebDriver driver;
	PageUtility page=new PageUtility();

	public AdminUserPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement addNewUSerIcon;
	@FindBy(xpath = "//input[@id='username']")
	WebElement userNameField;
	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordField;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement dropDownList;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement saveButton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchIcon;
	@FindBy(xpath = "//input[@id='un']")
	WebElement userNameFieldOnSerach;
	@FindBy(xpath = "//select[@name='ut']")
	WebElement dropDownListOnSearch;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchButton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	WebElement resetIcon;

	@FindBy(xpath = "//td[text()='user1234567']")
	WebElement searchedUserName;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMessage;

	

	public AdminUserPage clickOnAddNewUserIcon() {
		addNewUSerIcon.click();
		return this;
	}

	public AdminUserPage enterNewUserNameOnUSerNameField(String newUserName) {
		userNameField.sendKeys(newUserName);
		return this;
	}

	public AdminUserPage enterNewPasswordOnPasswordField(String newPassword) {
		passwordField.sendKeys(newPassword);
		return this;
	}

	public AdminUserPage selectUserTypeFromDropDownList() {
		page.selectDropDownWithVisibleText(dropDownList,Constants.USERTYPEDROPDOWN);
		return this;
	}

	public AdminUserPage clickOnSaveButton() {
		saveButton.click();
		return this;
	}

	public AdminUserPage clickOnSearchIcon() {
		searchIcon.click();
		return this;
	}

	public AdminUserPage enterUserNameOnUserNameFiledInSearch() {
		userNameFieldOnSerach.sendKeys(Constants.SEARCHUSERNAMEBYADMIN);
		return this;
	}

	public AdminUserPage selectUserTypefromDropDownInSearch() {
		page.selectDropDownWithVisibleText(dropDownListOnSearch,Constants.USERTYPEDROPDOWN);
		return this;
	}

	public AdminUserPage clickOnSearchButton() {
		searchButton.click();
		return this;
	}
	public AdminUserPage clickOnResetIcon() {
		resetIcon.click();
		return this;
	}
	public boolean getAlertMessage() {
		return alertMessage.isDisplayed();
	}

	public String getUserNameFromSeachedList() {
		return searchedUserName.getText();
	}
}
