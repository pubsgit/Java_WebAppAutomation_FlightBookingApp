package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class base {

	public static WebDriver driver;
	public Properties prop;
public WebDriver initializeDriver() throws IOException
{
	
prop= new Properties();
FileInputStream fis=new FileInputStream("C:\\Users\\Arjun\\Desktop\\Learning\\Web_Selenium\\domesticflight\\src\\main\\java\\resources\\data.properties");

prop.load(fis);
String browserName=prop.getProperty("browser");
System.out.println(browserName);

if(browserName.equals("chrome"))
{    ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");	
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Arjun\\Desktop\\Learning\\Web_Selenium\\webbrowserdrives\\chromedriver.exe");
	driver= new ChromeDriver(options);
	//execute in chrome driver
	
}
else if (browserName.equals("firefox"))
{
	System.setProperty("webdriver.firefox.driver", "C:\\Users\\Arjun\\Desktop\\Learning\\Web_Selenium\\webbrowserdrives\\geckodriver.exe");
	 driver= new FirefoxDriver();
	//firefox code
}
else if (browserName.equals("IE"))
{
	System.setProperty("webdriver.firefox.driver", "C:\\Users\\Arjun\\Desktop\\Learning\\Web_Selenium\\webbrowserdrives\\msedgedriver.exe");
	driver= new EdgeDriver();
}

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//Maximize window
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//scroll down
driver.get(prop.getProperty("url"));
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("window.scrollBy(0,500)");
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//Actions clickSource=new Actions(driver);
//driver.findElement(By.id("typeahead-input-from")).sendKeys("sydney");
//driver.findElement(By.id("typeahead-input-to")).sendKeys("brisbane");
//driver.findElement(By.xpath("//labe[@for='typeahead-input-from']")).click();
return driver;


}


public void getScreenshot(String result) throws IOException
{
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("C://test//"+result+"screenshot.png"));
	
}



}
