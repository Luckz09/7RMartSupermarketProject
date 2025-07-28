package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageCategoryPage {
	
	public WebDriver driver;
	
	public ManageCategoryPage(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//p[text()='Manage Category']/ancestor::div[@class='small-box bg-info']/a") WebElement moreInfoIcon;
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']") WebElement searchIcon;
	@FindBy(xpath = "//input[@name='un'] ") WebElement searchCategoryField;
	@FindBy(xpath = "//button[@name='Search'] ") WebElement searchButton;
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']") WebElement newIcon;
	@FindBy(xpath = "//input[@id='category']") WebElement addCategoryField;
	@FindBy(xpath = "//input[@id='main_img']") WebElement chooseFileField;
	@FindBy(xpath = "//button[@name='create']") WebElement saveButton;
	
	@FindBy(xpath = "//td[text()='Apple123']") WebElement searchList;
	
	public void clickOnMoreInfoIcon()
	{
		moreInfoIcon.click();
	}
	
	public void clickOnSearchIcon()
	{
		searchIcon.click();
	}
	public void enterSearchTitleOnSearchCategoryField()
	{
		searchCategoryField.sendKeys("dress");
	}
	public void clickOnSearchButton()
	{
		searchButton.click();
	}
	public void clickOnNewIcon()
	{
		newIcon.click();
	}
	public void enterCategoryOnAddCategoryField()
	{
		addCategoryField.sendKeys("fruits");
	}
	public void uploadImageOnChooseFileField()
	{
		chooseFileField.sendKeys("C:\\Users\\jeevc\\eclipse-workspace\\7RMartSupermarketProject\\src\\test\\resources\\img1.jpg");
	}
	public void scrollDownOfAddCategoryPage()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,750)", "");
	}
	public void clickOnSaveButton()
	{
		//saveButton.click(); 
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", saveButton); 
	}
	public String getSearchedItemFromSearchList()
	{
		return searchList.getText();
	}


}
