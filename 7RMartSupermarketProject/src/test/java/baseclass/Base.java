package baseclass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import ultilities.ScreenShotUtility;

public class Base {
	
	public WebDriver driver; 
	
   @BeforeMethod(alwaysRun = true)
   @Parameters("browser")
	public void initializeBrowser(String browser) throws Exception
	{
	   if(browser.equalsIgnoreCase("chrome"))
	   {
		   driver=new ChromeDriver();  
	   }
	   else if(browser.equalsIgnoreCase("edge"))
	   {
		   driver=new EdgeDriver();  
	   }
	   else if(browser.equalsIgnoreCase("fireFox"))
	   {
		   driver=new FirefoxDriver();  
	   }
	   else
	   {
		   throw new Exception("Invalid Browser");
	   }
		
		driver.get("https://groceryapp.uniqassosiates.com/admin/login\r\n");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
	@AfterMethod(alwaysRun = true)
	public void driverQuit(ITestResult iTestResult) throws IOException
	{
	if(iTestResult.getStatus()==ITestResult.FAILURE)
	{
	ScreenShotUtility screenShot=new ScreenShotUtility();
	screenShot.getScreenshot(driver, iTestResult.getName());
	}
	//driver.quit();

	}
	
}
