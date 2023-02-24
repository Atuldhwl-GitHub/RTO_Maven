package rto_TestNG_TestClass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Browser;
import pomPackageRTO.RTO_HomePage;
import utils.Utility;

public class VerifyLicenesServices extends Browser  {
	
	private WebDriver driver;
	private RTO_HomePage rTO_HomePage;
	String testID;
	
	@Parameters("browser123")
	
	@BeforeTest
	public void launchBrowser(String browser) {
		if (browser.equals("Chrome"))
		{
			driver = openChromeBrowser();
		}
		
		if (browser.equals("Edge"))
		{
			driver = openEdgeBrowser();
		}
		
		if (browser.equals("Firefox"))
		{
			driver = openFireFoxBrowser();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
	}
	
	@BeforeClass
	public void beforeClass() {
		driver.get("https://parivahan.gov.in/parivahan/");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		rTO_HomePage = new RTO_HomePage(driver);
	}
	
	@Test
	public void VerifyDriversLicense() {
		testID = "T101" ;
//		RTO_HomePage rTO_HomePage = new RTO_HomePage (driver);
		rTO_HomePage.clickOnDriversLicense();
		
		ArrayList<String> addr1 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr1.get(1));
		
		String currentURL = driver.getCurrentUrl();
//		System.out.println(currentURL);
		String currentTitle = driver.getTitle();
//		System.out.println(currentTitle);
		
		String actualURL = "https://sarathi.parivahan.gov.in/sarathiservice/";
		String acutalTitle = "SarathiOnWeb";
		
		if (currentURL.equals(actualURL) && currentTitle.equals(acutalTitle))
		{
			System.out.println("Drivers License Tab Verifed");
		}
		else
		{
			System.out.println("Test Fail");
		}
		
		ArrayList<String> addr2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr2.get(0));
	}
	
	@Test
	public void VerifyDrivingSchool() {
		testID = "T102" ;
//		RTO_HomePage rTO_HomePage = new RTO_HomePage (driver);
		rTO_HomePage.clickOnDrivingSchool();
		
		ArrayList<String> addr1 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr1.get(2));
		
		String currentURL = driver.getCurrentUrl();
		String currentTitle = driver.getTitle();
		
		String actualURL = "https://sarathi.parivahan.gov.in/sarathiservice/";
		String acutalTitle = "SarathiOnWeb";
		
		if (currentURL.equals(actualURL) && currentTitle.equals(acutalTitle))
		{
			System.out.println("Driving School Tab Verifed");
		}
		else
		{
			System.out.println("Test Fail");
		}
		
		ArrayList<String> addr2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr2.get(0));
	}
	
	@Test
	public void VerifyOnlineAppoinment() {
		testID = "T103" ;
//		RTO_HomePage rTO_HomePage = new RTO_HomePage (driver);
		rTO_HomePage.clickOnOnlineAppoinment();
		
		ArrayList<String> addr1 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr1.get(3));
		
		String currentURL = driver.getCurrentUrl();
		String currentTitle = driver.getTitle();
		
		String actualURL = "https://sarathi.parivahan.gov.in/sarathiservice/";
		String acutalTitle = "SarathiOnWeb";
		
		if (currentURL.equals(actualURL) && currentTitle.equals(acutalTitle))
		{
			System.out.println("Online Appoinment Tab Verifed");
		}
		else
		{
			System.out.println("Test Fail");
		}
		
		ArrayList<String> addr2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr2.get(0));
	}
	
	@Test
	public void VerifyOtherServices() {
		testID = "T104" ;
//		RTO_HomePage rTO_HomePage = new RTO_HomePage (driver);
		rTO_HomePage.clickOnOtherServices();
		
		ArrayList<String> addr1 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr1.get(4));
		
		String currentURL = driver.getCurrentUrl();
		String currentTitle = driver.getTitle();
		
		String actualURL = "https://sarathi.parivahan.gov.in/sarathiservice/";
		String acutalTitle = "SarathiOnWeb";
		
		if (currentURL.equals(actualURL) && currentTitle.equals(acutalTitle))
		{
			System.out.println("Other Services Tab Verifed");
		}
		else
		{
			System.out.println("Test Fail");
		}
		
		ArrayList<String> addr2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr2.get(0));
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {	
		if (ITestResult.FAILURE == result.getStatus())
		{
			Utility.captureScreenShot(driver, result.getName());
		}
//		driver.close();
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
		rTO_HomePage = null;
	}
	
	@AfterTest
	public void afterTest() {
		driver = null;
		System.gc();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
