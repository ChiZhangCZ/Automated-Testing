package shopping_test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ShoppingTest {
	
	static WebDriver driver;
	static ExtentReports extent;
	
    @BeforeClass
    public static void init() {
    	
    	System.setProperty("webdriver.chrome.driver","C:/Users/Admin/Downloads/chromedriver.exe");
    	extent = new ExtentReports("C:\\Users\\Admin\\Desktop\\Automated-Testing\\Shopping_Website\\extent report\\SearchReport.html", true);
    }
    
    @Before
    public void setup() {
    	
    	driver = new ChromeDriver();
    	driver.manage().window().maximize();
		driver.get("http://demoqa.com/");
    }
    
	
	@After
	public void tearDown() {
		
		driver.quit();
		extent.flush();
	}
	
	@Test
	public void searchTest() {
		
		ExtentTest searchTest = extent.startTest("Search Test");
		
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		
		searchTest.log(LogStatus.INFO, "Browser started");
		
		WebElement search = driver.findElement(By.id("search_query_top"));
		WebElement searchBtn = driver.findElement(By.name("submit_search"));
			
		search.sendKeys("Dress");
		searchBtn.submit();
		
		searchTest.log(LogStatus.INFO, "Search completed");
		
		List<WebElement> searchResults = driver.findElements(By.className("product-container"));
		assertFalse(searchResults.isEmpty());
		
		searchTest.log(LogStatus.INFO, "Search results found");
		searchTest.log(LogStatus.PASS, "Successful search for 'Dress' with results found"); 
	}

}
