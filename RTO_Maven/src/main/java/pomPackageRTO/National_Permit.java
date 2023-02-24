package pomPackageRTO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class National_Permit {
	
private static final WebDriver WebDriver = null;
	
	private WebDriver driver;
	
	private Actions act;
	
	private WebDriverWait wait;
	
	@FindBy (xpath = "(//div[@class='center-position container']//h1)[1]")
	private WebElement tNPA ;
	
	@FindBy (xpath = "(//div[@class='center-position container']//h1)[2]")
	private WebElement iTY ;
	
	@FindBy (xpath ="//select[@name='main-content:cm_PERMIT_TRANSACTION']")
	private WebElement permit_SelectState;
	
	@FindBy (xpath ="(//div[@class='col-md-6 text-center']//div)[2]")
	private WebElement totalPermitCount;
	
	
	public National_Permit(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		act = new Actions(driver);
		wait = new WebDriverWait(driver, 15);
	}
	
	
	public String getText_TNPA() {
		wait.until(ExpectedConditions.visibilityOf(tNPA));
		String text1 = tNPA.getText();
		System.out.println(text1);
		return text1 ;
	}
	
	public String getText_ITY() {
		
		String text2 = iTY.getText();
		System.out.println(text2);
		return text2 ;
	}
	
	public void clickOnPermit_SelectState() {
		permit_SelectState.click();
		Select s = new Select(permit_SelectState);
		s.selectByValue("MH");
	}
	
	public String getText_TotalPermitCount() {
		String text3 = totalPermitCount.getText();
		System.out.println(text3);
		return text3 ;
	}

}
