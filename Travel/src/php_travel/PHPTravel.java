package php_travel;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PHPTravel {
	
	static WebDriver driver;
	
    @Before
    public void setup() {
    	
    	System.setProperty("webdriver.chrome.driver","C:/Users/Admin/Downloads/chromedriver.exe");
    	driver = new ChromeDriver();
    	driver.manage().window().maximize();
		driver.get("https://www.phptravels.net/");
    }
    
	
//	@After
//	public void tearDown() {
//		
//		driver.quit();
//	}
	
	@Test
	public void travelTest() {
		
		WebElement searchBar = driver.findElement(By.id("s2id_autogen9"));
		searchBar.sendKeys("London");
		
		WebElement locations= new WebDriverWait(driver, 10)
				                  .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"select2-drop\"]/ul/li/ul/li[1]")));
		locations.click();
		
		WebElement startDateInput = driver.findElement(By.id("dpd1"));
        startDateInput.click();
       
//      WebElement startDateCalender = new WebDriverWait(driver, 10)
//                                         .until(ExpectedConditions.presenceOfElementLocated(By.className("datepicker dropdown-menu")));
//      startDateCalender.click();
//		WebElement finishDate = driver.findElement(By.cssSelector("dpd2 > div > input"));
//		finishDate.sendKeys("16/08/2018");
//		WebElement noPeople = driver.findElement(By.id("travellersInput"));
//		noPeople.sendKeys("3 Adult 0 Child");
//		WebElement searchBtn = driver.findElement(By.cssSelector("#HOTELS > form > div.col-md-2.form-group.go-right.col-xs-12.search-button > button"));
//		searchBtn.click();
				
	}

}
