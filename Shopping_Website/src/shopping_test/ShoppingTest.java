package shopping_test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShoppingTest {
	
	static WebDriver driver;
	
    @Before
    public void setup() {
    	
    	System.setProperty("webdriver.chrome.driver","C:/Users/Admin/Downloads/chromedriver.exe");
    	driver = new ChromeDriver();
    }
    
	
	@After
	public void tearDown() {
		
		driver.quit();
	}
	
	@Test
	public void searchTest() {
		
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		
		WebElement search = driver.findElement(By.id("search_query_top"));
		WebElement searchBtn = driver.findElement(By.name("submit_search"));
		
		search.sendKeys("Dress");
		searchBtn.submit();
		
		List<WebElement> searchResults = driver.findElements(By.className("product-container"));
		assertFalse(searchResults.isEmpty());
	}

}
