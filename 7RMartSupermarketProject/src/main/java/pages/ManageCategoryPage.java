package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constants;

public class ManageCategoryPage {

	public WebDriver driver;

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchIcon;
	@FindBy(xpath = "//input[@name='un'] ")
	WebElement searchCategoryField;
	@FindBy(xpath = "//button[@name='Search'] ")
	WebElement searchButton;

	@FindBy(xpath = "//td[text()='fruits']")
	WebElement searchList;

	public ManageCategoryPage clickOnSearchIcon() {
		searchIcon.click();
		return this;
	}

	public ManageCategoryPage enterSearchTitleOnSearchCategoryField() {
		searchCategoryField.sendKeys(Constants.CATEGORYSEARCHINPUT);
		return this;
	}

	public ManageCategoryPage clickOnSearchButton() {
		searchButton.click();
		return this;
	}

	public String getSearchedItemFromSearchList() {
		return searchList.getText();
	}

}
