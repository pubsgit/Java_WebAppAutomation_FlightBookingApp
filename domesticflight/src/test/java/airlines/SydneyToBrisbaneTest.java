package airlines;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.FlightFilter;
import pageObjects.LandingPage;
import resources.base;

public class SydneyToBrisbaneTest extends base{
	

	WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		driver =initializeDriver();		
	}
	
	@Test
	public void FlightBooking() throws IOException
	{
 
		LandingPage lp=new LandingPage(driver);
		lp.selectItenary();
		FlightFilter ff=new FlightFilter(driver);
		ff.selectApplyFilter();
		
		
 

		
	}

	@AfterMethod
	public void tearDown() {
//		driver.close();
//		driver=null;
	}
}
