package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class ManageNewsPage {
	
	WebDriver driver;
	
	public ManageNewsPage(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath ="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']") WebElement moreInfo;
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']") WebElement addIcon;
	@FindBy(xpath ="//textarea[@name='news']") WebElement enterNewsArea;
	@FindBy(xpath = "//button[@class='btn btn-danger']") WebElement saveButton;
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']") WebElement searchIcon;
	@FindBy(xpath = "//input[@name='un']") WebElement searchNewsField;
	@FindBy(xpath = "//button[@name='Search']") WebElement searchButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement alertMsg;
	@FindBy(xpath = "//td[text()='Testing News Area']") WebElement searchedNewsfield;
	
	
	public void clickMoreInfoIcon()
	{
		moreInfo.click();
	}
	public void clickOnAddIcon()
	{
		addIcon.click();
	}
	public void enteringNewNews()
	{
		enterNewsArea.sendKeys("Testing News Area");
	}
	public void clickOnSaveButton()
	{
		saveButton.click();
	}
	public void clickOnSearchIcon()
	{
		searchIcon.click();
	}
	public void enteringNewsTitleOnSearchNewsField()
	{
		searchNewsField.sendKeys("Testing News Area");
	}
	public void clickOnSearchButton()
	{
		searchButton.click();
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
