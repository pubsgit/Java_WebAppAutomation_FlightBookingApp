package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightFilter {
	
	WebDriver driver;
	By filterbutton = By.xpath("//button[@id='flight-filters-button-bound0']");
	
	
	public void selectApplyFilter() {
		driver.findElement(filterbutton).click();
	}
	
	public FlightFilter(WebDriver driver) {
		// TODO Auto-generated constructor stub	
		this.driver=driver;
		
	}
}