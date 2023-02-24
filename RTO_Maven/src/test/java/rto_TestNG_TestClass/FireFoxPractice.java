package rto_TestNG_TestClass;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pomPackageRTO.RTO_HomePage;

public class FireFoxPractice {
	
	private WebDriver driver;
	private RTO_HomePage rTO_HomePage;
	
//	@Parameters("browser123")
//	
//	@BeforeTest
//	public void launchBrowser(String browser) {
//		if (browser.equals("Chrome"))
//		{
//			System.setProperty("webdriver.chrome.driver", "C:\\Users\\shipali.rana\\Desktop\\Test KWD\\chromedriver_win32\\chromedriver.exe");
//			driver = new ChromeDriver();
//		}
//		
//		if (browser.equals("Edge"))
//		{
//			System.setProperty("webdriver.edge.driver", "C:\\Users\\shipali.rana\\Desktop\\Test KWD\\edgedriver_win64\\msedgedriver.exe");
//			driver = new EdgeDriver();
//		}
//		
//		if (browser.equals("Firefox"))
//		{
//			System.setProperty("webdriver.gecko.driver", "C:\\Users\\shipali.rana\\Desktop\\Test KWD\\geckodriver-v0.32.0-win32\\geckodriver.exe");
//			driver = new FirefoxDriver();
//		}
//		
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.manage().window().maximize();	
//	}
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\shipali.rana\\Desktop\\Test KWD\\geckodriver-v0.32.0-win32\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
		
		driver.get("https://parivahan.gov.in/parivahan/");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		rTO_HomePage = new RTO_HomePage(driver);
	}
	
	@Test 
	public void VerifyDriversLicense() throws InterruptedException {
//		RTO_HomePage rTO_HomePage = new RTO_HomePage (driver);
		rTO_HomePage.clickOnDriversLicense();
		
		ArrayList<String> addr1 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr1.get(1));
		
		Thread.sleep(1000);
		
		String currentURL = driver.getCurrentUrl();
//		System.out.println(currentURL);
		String currentTitle = driver.getTitle();
//		System.out.println(currentTitle);
		
		String actualURL = "https://sarathi.parivahan.gov.in/sarathiservice/";
		String acutalTitle = "SarathiOnWeb";
//		String actualPage = "Sarathi";
		
		Assert.assertEquals(actualURL, currentURL);
		
//		if (currentURL.equals(actualURL) && currentTitle.equals(acutalTitle))
//		{
//			System.out.println("Drivers License Tab Verifed");
//		}
//		else
//		{
//			System.out.println("Test Fail");
//		}
//		
//		ArrayList<String> addr2 = new ArrayList<String>(driver.getWindowHandles());
//		driver.switchTo().window(addr2.get(0));
		
		Thread.sleep(1000);
	}
	
	@Test (enabled = false)
	public void VerifyDrivingSchool() throws InterruptedException {
//		RTO_HomePage rTO_HomePage = new RTO_HomePage (driver);
		rTO_HomePage.clickOnDrivingSchool();
		
		ArrayList<String> addr1 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr1.get(2));
		
		Thread.sleep(1000);
		
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
		
		Thread.sleep(1000);
	}
	
	@Test (enabled = false)
	public void VerifyOnlineAppoinment() throws InterruptedException {
//		RTO_HomePage rTO_HomePage = new RTO_HomePage (driver);
		rTO_HomePage.clickOnOnlineAppoinment();
		
		ArrayList<String> addr1 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr1.get(3));
		
		Thread.sleep(1000);
		
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
		
		Thread.sleep(1000);
	}
	
	@Test (enabled = false)
	public void VerifyOtherServices() throws InterruptedException {
//		RTO_HomePage rTO_HomePage = new RTO_HomePage (driver);
		rTO_HomePage.clickOnOtherServices();
		
		ArrayList<String> addr1 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr1.get(4));
		
		Thread.sleep(1000);
		
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
		
		Thread.sleep(1000);
	}
	
	@AfterMethod
	public void afterMethod() {	
//		driver.close();
	}
	
	@AfterClass
	public void afterClass() {
//		driver.quit();
	}
	
	

}
