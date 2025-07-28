package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUserPage {

	WebDriver driver;

	public AdminUserPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text()='Admin Users']/following::a[1]")
	WebElement adminUserIcon;
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

	@FindBy(xpath = "//td[text()='user1234567']")
	WebElement addedUserName;
	@FindBy(xpath = "//td[text()='user1234567']")
	WebElement searchedUserName;

	public void clickOnAdminIcon() {
		adminUserIcon.click();
	}

	public void clickOnAddNewUserIcon() {
		addNewUSerIcon.click();
	}

	public void enterNewUserNameOnUSerNameField(String newUserName) {
		userNameField.sendKeys(newUserName);
	}

	public void enterNewPasswordOnPasswordField(String newPassword) {
		passwordField.sendKeys(newPassword);
	}

	public void selectUserTypeFromDropDownList() {
		Select select = new Select(dropDownList);
		select.selectByVisibleText("Staff");
	}

	public void clickOnSaveButton() {
		saveButton.click();
	}

	public void clickOnSearchIcon() {
		searchIcon.click();
	}

	public void enterUserNameOnUserNameFiledInSearch() {
		userNameFieldOnSerach.sendKeys("user1234567");
	}

	public void selectUserTypefromDropDownInSearch() {
		Select select = new Select(dropDownListOnSearch);
		select.selectByVisibleText("Staff");
	}

	public void clickOnSearchButton() {
		searchButton.click();
	}

	public String getUserNameFromAddedList() {
		return addedUserName.getText();
	}

	public String getUserNameFromSeachedList() {
		return searchedUserName.getText();
	}
}
