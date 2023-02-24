package pomPackageRTO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RTO_HomePage {
	
private static final WebDriver WebDriver = null;
	
	private WebDriver driver;
	
	private Actions act;
	
	private WebDriverWait wait;
	
	
	@FindBy (xpath = "(//a[text()='More'])[1]")
	private WebElement driversLicense ;
	
	@FindBy (xpath = "(//a[text()='More'])[2]")
	private WebElement drivingSchool ;
	
	@FindBy (xpath = "(//a[text()='More'])[3]")
	private WebElement onlineAppoinment ;
	
	@FindBy (xpath = "(//a[text()='More'])[4]")
	private WebElement otherServices ;
	
	@FindBy (xpath = "(//a[@target='_blank'])[23]")
	private WebElement vehicleRegistration ;
	
	@FindBy (xpath = "(//a[@target='_blank'])[25]")
	private WebElement fancyNumberAllocation ;
	
	@FindBy (xpath = "(//a[@target='_blank'])[27]")
	private WebElement nationalPermit ;
	
	
	public RTO_HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		act = new Actions(driver);
		wait = new WebDriverWait(driver, 10);
	}
	
	
	public void clickOnDriversLicense() {
		driversLicense.click();
	}
	
	public void clickOnDrivingSchool() {
		drivingSchool.click();
	}
	
	public void clickOnOnlineAppoinment() {
		onlineAppoinment.click();
	}
	
	public void clickOnOtherServices() {
		otherServices.click();
	}
	
	public void clickOnVehicleRegistration() {
		vehicleRegistration.click();
	}
	
	public void clickOnFancyNumberAllocation() {
		fancyNumberAllocation.click();
	}
	
	public void clickOnNationalPermit() {
		nationalPermit.click();
	}

}
