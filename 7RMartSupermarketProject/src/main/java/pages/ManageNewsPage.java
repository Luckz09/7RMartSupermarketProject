package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constants;


public class ManageNewsPage {
	
	WebDriver driver;
	
	public ManageNewsPage(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		}
	
	
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']") WebElement addIcon;
	@FindBy(xpath ="//textarea[@name='news']") WebElement enterNewsArea;
	@FindBy(xpath = "//button[@class='btn btn-danger']") WebElement saveButton;
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']") WebElement searchIcon;
	@FindBy(xpath = "//input[@name='un']") WebElement searchNewsField;
	@FindBy(xpath = "//button[@name='Search']") WebElement searchButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement alertMsg;
	@FindBy(xpath = "//td[text()='Testing News Area']") WebElement searchedNewsfield;
	
	
	
	public ManageNewsPage clickOnAddIcon()
	{
		addIcon.click();
		return this;
	}
	public ManageNewsPage enteringNewNews()
	{
		enterNewsArea.sendKeys("Testing News Area");
		return this;
	}
	public ManageNewsPage clickOnSaveButton()
	{
		saveButton.click();
		return this;
	}
	public ManageNewsPage clickOnSearchIcon()
	{
		searchIcon.click();
		return this;
	}
	public ManageNewsPage enteringNewsTitleOnSearchNewsField()
	{
		searchNewsField.sendKeys(Constants.NEWSCONTENT);
		return this;
	}
	public ManageNewsPage clickOnSearchButton()
	{
		searchButton.click();
		return this;
	}
	public boolean isCreatedSuccessfullyAlertDisplayed()
	{
		return alertMsg.isDisplayed();
	}
	public String getNewsFromSearchedList()
	{
		return searchedNewsfield.getText();
	}

}
