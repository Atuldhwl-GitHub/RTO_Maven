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
import pomPackageRTO.National_Permit;
import pomPackageRTO.RTO_HomePage;
import pomPackageRTO.Vehicle_Registration;
import utils.Utility;

public class VerifyVehicleServices extends Browser {
	
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
	
	@Test (priority = 1)
	public void VerifyVehicleRegistration() {
		testID = "T201" ;
//		RTO_HomePage rTO_HomePage = new RTO_HomePage (driver);
		rTO_HomePage.clickOnVehicleRegistration();
		
		ArrayList<String> addr1 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr1.get(1));
		
		Vehicle_Registration vehicle_Registration = new Vehicle_Registration(driver);
		vehicle_Registration.clickOnSelectState();
		
		String currentURL = driver.getCurrentUrl();
//		System.out.println(currentURL);
		String currentTitle = driver.getTitle();
//		System.out.println(currentTitle);
		
		String actualURL = "https://vahan.parivahan.gov.in/vahanservice/vahan/ui/statevalidation/homepage.xhtml?statecd=Mzc2MzM2MzAzNjY0MzIzODM3NjIzNjY0MzY2MjM3NGQ0OA==";
		String acutalTitle = "VAHAN 4.0 (Citizen Services) ~onlineapp02~150~8001";
		
		if (currentURL.equals(actualURL) && currentTitle.equals(acutalTitle))
		{
			System.out.println("Vehicle Registration Tab Verifed");
		}
		else
		{
			System.out.println(" V R _ Test Fail");
		}
		
		ArrayList<String> addr2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr2.get(0));
		
	}
	
	@Test (priority = 2)
	public void VerifyFancyNumberAllocation() throws InterruptedException {
		testID = "T202" ;
//		RTO_HomePage rTO_HomePage = new RTO_HomePage (driver);
		rTO_HomePage.clickOnFancyNumberAllocation();
		
		ArrayList<String> addr1 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr1.get(1));
		
		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL);
		
		String actualURL = "https://fancy.parivahan.gov.in/fancy/faces/public/login.xhtml";
		
		
		if (currentURL.equals(actualURL))
		{
			System.out.println("Fancy Number Allocation Tab Verifed");
		}
		else
		{
			System.out.println("Test Fail");
		}
		
		ArrayList<String> addr2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr2.get(0));
		
	}
	
	@Test (priority = 3)
	public void VerifyNationalPermit() throws InterruptedException {
		testID = "T203" ;
//		RTO_HomePage rTO_HomePage = new RTO_HomePage (driver);
		rTO_HomePage.clickOnNationalPermit();
		
		ArrayList<String> addr1 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr1.get(3));
		
		National_Permit national_Permit = new National_Permit(driver);
		Thread.sleep(4000);
		String getText1 = national_Permit.getText_TNPA();
		String actualText1 = "Total National Permit Authorization";
		if (getText1.equals(actualText1))
		{
			System.out.println("Total National Permit Text Verified");
		}
		else
		{
			System.out.println("Total National Permit Text Fail");
		}
		
		String getText2 = national_Permit.getText_ITY();
		String actualText2 = "Issued (All Over India) Till Yesterday";
		if (getText2.equals(actualText2))
		{
			System.out.println("Issued Text Verified");
		}
		else
		{
			System.out.println("Isued Text Fail");
		} 
		
		national_Permit.clickOnPermit_SelectState();
		
		String getText3 = national_Permit.getText_TotalPermitCount();
		String actualtext3 = "9,63,888";
		if (getText3.equals(actualtext3))
		{
			System.out.println("Total Permit Text Verified");
		}
		else
		{
			System.out.println("Total Permit Text Fail");
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
