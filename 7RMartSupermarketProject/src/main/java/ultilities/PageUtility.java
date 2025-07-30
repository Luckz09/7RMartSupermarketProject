package ultilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	public void selectDropdownWithValue(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);
		}
	public void selectDropDownWithIndex(WebElement element,int value) {
		Select object=new Select(element);
		object.selectByIndex(value);
	}
	public void selectDropDownWithVisibleText(WebElement element,String value) {
		Select object=new Select(element);
		object.selectByVisibleText(value);
	}
	
	public void scrollUpByjavaScriptExecutor(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("Window.ScrollBy(0,350)"," ");
	   }
		
	public void clickByJavaScriptExecutor(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("argument[0].click();",element);
		}
	public void switchToFrames(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	public void acceptByAlert(WebDriver driver) {
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	
	
	
	
	

}
