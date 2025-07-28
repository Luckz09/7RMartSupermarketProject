package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
		
		}
	
	@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']") WebElement logoutButton;
	@FindBy(xpath ="//a[@data-toggle='dropdown']") WebElement adminIcon;
	
	
	public void clickOnAdminButton()
	{
		adminIcon.click();
	}
	public void clickOnLoginButton()
	{
		logoutButton.click();
	}

}

