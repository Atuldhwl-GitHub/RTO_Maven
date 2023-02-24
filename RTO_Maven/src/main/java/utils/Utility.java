package utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
private static WebDriver driver;
	
	public static void captureScreenShot (WebDriver driver, String testID) throws IOException {
		
		
	
	// How to Take ScreenShot in Selenium ============================================================================
	
			TakesScreenshot t = (TakesScreenshot)driver;
			Date d = new Date();
	//		System.out.println(d);
			
			File src = t.getScreenshotAs(OutputType.FILE);
			
			String filename= d.toString().replace(" ", "_").replace(":", "_");
	//		System.out.println(filename);
			
			File dest = new File("C:\\Users\\shipali.rana\\Desktop\\Atul-TDG\\Selenium Screenshot\\Selenium"+testID+filename+".jpg");
			
			FileHandler.copy(src, dest);
			
	}		

}
