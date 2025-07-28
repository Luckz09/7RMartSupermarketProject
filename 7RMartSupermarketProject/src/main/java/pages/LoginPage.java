package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  {
	
	public WebDriver driver;
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
		}
	@FindBy(xpath ="//input[@name='username']") WebElement userName;
	@FindBy(xpath ="//input[@name='password']") WebElement passWord;
	@FindBy(xpath ="//button[@class='btn btn-dark btn-block']") WebElement signInButton;
	@FindBy(xpath = "//p[text()='Dashboard']") WebElement dashBoard;
	@FindBy(xpath = "//i[@class='icon fas fa-ban']") WebElement alert;
	@FindBy(xpath = "//b[text()='7rmart supermarket']") WebElement pageTitle;
	
	
	public void enterUserNameOnUserNameField(String username)
	{
		userName.sendKeys(username);
	}
	public void enterPasswordOnPasswordField(String password)
	{
		passWord.sendKeys(password);
	}
	public void clickOnLoginButton()
	{
		 signInButton.click();
	}
	public boolean isDashBoardDisplayed()
	{
		return dashBoard.isDisplayed();
	}
	public String getTextFromTitle()
	{
		return pageTitle.getText();
	}
	

}
