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
	
	@FindBy(xpath = "//b[text()='7rmart supermarket']") WebElement prjTitle;

	@FindBy(xpath = "//p[text()='Admin Users']/following::a[1]")
	WebElement adminUserIcon;
	@FindBy(xpath = "//p[text()='Manage Category']/ancestor::div[@class='small-box bg-info']/a")
	WebElement manageCategoryIcon;
	@FindBy(xpath ="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']") WebElement manageNewsIcon;
	
	public HomePage clickOnAdminButton(){
		adminIcon.click();
		return this;
	}
	public LoginPage clickOnLogoutButton(){
		logoutButton.click();
		return new LoginPage(driver);
	}
	public boolean IsProjectTitleDisplayedOnLoginPage(){
		return prjTitle.isDisplayed();
	}
	public AdminUserPage clickOnAdminIcon() {
		adminUserIcon.click();
		return new AdminUserPage(driver);
	}
	public ManageCategoryPage clickOnManageCategoryIcon() {
		manageCategoryIcon.click();
		return new ManageCategoryPage(driver);
	}
	public ManageNewsPage clickOnManageNewsIcon(){
		manageNewsIcon.click();
		return new ManageNewsPage(driver);
	}

}

