package pageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {

	
	WebDriver driver;
	public Properties prop;
	By source=By.id("typeahead-input-from");
	By destination=By.id("typeahead-input-to");
	By date=By.id("datepicker-input-departureDate");
	By oneway=By.xpath("//*[@id=\"flight-form\"]/form[1]/div[3]/div/div[2]/div[2]/div[1]/fieldset/div/div[2]/label/div/div");
	By submitButton=By.xpath("//button[@class='qfa1-submit-button__button'][contains(text(),'SEARCH FLIGHTS')]");

	public void selectItenary() throws IOException
	{
	prop= new Properties();
	FileInputStream fis=new FileInputStream("C:\\Users\\Arjun\\Desktop\\Learning\\Web_Selenium\\domesticflight\\src\\main\\java\\resources\\data.properties");
	prop.load(fis);
	String departureName=prop.getProperty("departure");
	String arrivalName=prop.getProperty("arrival");
	System.out.println(" Departing from : " + departureName + "Arriving to: " + arrivalName);	
	WebDriverWait wait = new WebDriverWait(driver,20);
	WebElement waitForSource, waitForDestination, waitForSubmit;

	//Select Source
	waitForSource= wait.until(ExpectedConditions.elementToBeClickable(source));
	driver.findElement(source).click();
	driver.findElement(source).sendKeys(departureName);	
	
	//Select One way
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		waitForSource= wait.until(ExpectedConditions.elementToBeClickable(oneway));
		driver.findElement(oneway).click();
	
	//Select Destination
	System.out.println("Enter destination");
	waitForDestination= wait.until(ExpectedConditions.elementToBeClickable(destination));
	driver.findElement(destination).clear();
	driver.findElement(destination).sendKeys(arrivalName);
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	driver.findElement(destination).sendKeys(Keys.ENTER);
	



	
//Select travel date
//	driver.findElement(date).click();	
//	int noOfDaysInCurrentMonth = java.time.LocalDate.now().lengthOfMonth();
//	System.out.println("days In Current Month = " + noOfDaysInCurrentMonth + " \n");
//	
// 	LocalDate date = LocalDate.now();
// 	int dayOfMonth = date.getDayOfMonth();
//    System.out.println("Day of the Month : " + dayOfMonth + " \n");
//    
//    int fifteenDaysFromNow = date.getDayOfMonth() + 15;
//    System.out.println("Fifteen days fron : " + fifteenDaysFromNow + " \n");
//    
//    int elementIndex, departureDate;
//    if (fifteenDaysFromNow <= noOfDaysInCurrentMonth)
//    {
//    	departureDate = fifteenDaysFromNow;
//    	elementIndex=0;
//    }
//    else
//    {  
//    	departureDate =(noOfDaysInCurrentMonth - dayOfMonth);
//    	elementIndex=1;
//    }

    
// Select 15days from now Login
    
// Dimiss Location alert
//    driver.switchTo().alert().dismiss();
    
//    driver.findElement(By.xpath("//table//span[text()='Integer.toString(departureDate)']")).click();
//   driver.findElement(By.xpath("//*[@id='flight-form']/form[1]/div[3]/div/div[5]/div/div[2]/div/div[4]/div[1]/table/tbody/tr[8]/td[5]/div[2]/span")).click();
//	List<WebElement> spans = driver.findElements(By.xpath("//table//span[text()='Integer.toString(departureDate)']"));
//	int index = 0;
//	for (WebElement span : spans)
//	{
//	    String text = span.getText();
////	    String indexOfSpan = span.
//	    System.out.println("Span Element at index " + index + " is: " + text + "\n");
//	    index++;
//	}
    
    
//	int index=0;
//	for(String s : list){
//	    System.out.println(String.valueOf(index++)+": "+s);
//	}
	
// Submit Details
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		waitForSubmit= wait.until(ExpectedConditions.elementToBeClickable(submitButton));
		driver.findElement(submitButton).click();;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

// Dimiss Location alert
	    driver.switchTo().alert().dismiss();
		
	}
	
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub	
		this.driver=driver;
		
	}


	public WebElement selectSource()
	{
		return driver.findElement(source);
	}

	public WebElement selectDestination()
	{
		return driver.findElement(destination);
	}

	
	
	
}
