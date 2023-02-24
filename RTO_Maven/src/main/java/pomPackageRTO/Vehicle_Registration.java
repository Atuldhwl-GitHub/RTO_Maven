package pomPackageRTO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Vehicle_Registration {
	
private static final WebDriver WebDriver = null;
	
	private WebDriver driver;
	
	private Actions act;
	
	private WebDriverWait wait;
	
	@FindBy (xpath = "//select[@name='aa']")
	private WebElement selectState ;
	
	
	
	
	
	
	public Vehicle_Registration(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		act = new Actions(driver);
		wait = new WebDriverWait(driver, 10);
	}
	
	public void clickOnSelectState () {
		selectState.click();
		Select s = new Select (selectState);
		s.selectByValue("MH");
	}
	

}
