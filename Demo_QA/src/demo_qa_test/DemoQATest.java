package demo_qa_test;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DemoQATest {
	
static WebDriver driver;
static ExtentReports extent;
	
    @BeforeClass
    public static void init() {
    	
    	System.setProperty("webdriver.chrome.driver","C:/Users/Admin/Downloads/chromedriver.exe");
    	extent = new ExtentReports("C:\\Users\\Admin\\Desktop\\Automated-Testing\\Demo_QA\\extent report\\DemoQAReport.html", true);
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
	public void dropTest() {
		
		ExtentTest dropTest = extent.startTest("Drop Test");
		
		WebElement dropBtn = driver.findElement(By.id("menu-item-141"));
		dropBtn.click();
		
		dropTest.log(LogStatus.INFO, "Navigated to drop page");
		
		WebElement draggable = driver.findElement(By.id("draggableview"));
		WebElement droppable = driver.findElement(By.id("droppableview"));
		
		Actions builder = new Actions(driver);
		Action dragAndDrop = builder.clickAndHold(draggable)
				                    .moveToElement(droppable)
				                    .release(droppable)
				                    .build();
		dragAndDrop.perform();
		
		dropTest.log(LogStatus.INFO, "Drag and dropped item");
		
		assertTrue(droppable.getText().equals("Dropped!"));
		
		dropTest.log(LogStatus.PASS, "Item dropped successfully");
	}
	
	@Test
	public void selectTest() {
		
		ExtentTest selectTest = extent.startTest("Select Test");
		
		WebElement selectBtn = driver.findElement(By.id("menu-item-142"));
		selectBtn.click();
		
		selectTest.log(LogStatus.INFO, "Navigated to select page");
		
		WebElement item1 = driver.findElement(By.xpath("//*[@id=\"selectable\"]/li[1]"));
		item1.click();
		
		selectTest.log(LogStatus.INFO, "Selected item");
		
		assertTrue(item1.getAttribute("class").contains("ui-selected"));
		
		selectTest.log(LogStatus.INFO, "Item highlighted");
		selectTest.log(LogStatus.PASS, "Item selected and highlighted successfully");
	}
	
	@Test
	public void accordionTest() {
		
		ExtentTest accordionTest = extent.startTest("Accordion Test");
		
		WebElement accordionBtn = driver.findElement(By.id("menu-item-144"));
		accordionBtn.click();
		
		accordionTest.log(LogStatus.INFO, "Selected item");
		
		WebElement section2 = driver.findElement(By.id("ui-id-6"));
		section2.click();
		WebElement section1 = driver.findElement(By.id("ui-id-4"));
		WebElement section3 = driver.findElement(By.id("ui-id-8"));
		WebElement section4 = driver.findElement(By.id("ui-id-10"));
		
			
		assertTrue(section2.getAttribute("class").contains("ui-state-active")
				&& section1.getAttribute("class").contains("ui-state-default")
				&& section3.getAttribute("class").contains("ui-state-default")
				&& section4.getAttribute("class").contains("ui-state-default")
				  );
		
		accordionTest.log(LogStatus.INFO, "Selected item maximized");
		accordionTest.log(LogStatus.INFO, "Non-selected items minimized");
		accordionTest.log(LogStatus.PASS, "Selected item maximized and other items minimized successfully");		
	}
	

    
	@Test
	public void autoTest() {
		
		ExtentTest autoTest = extent.startTest("Autocomplete Test");
		
		WebElement autoBtn = driver.findElement(By.id("menu-item-145"));
		autoBtn.click();
		
		autoTest.log(LogStatus.INFO, "Navigated to autocomplete page");
		
		WebElement textbox = driver.findElement(By.id("tagss"));
		textbox.sendKeys("act");
		
		autoTest.log(LogStatus.INFO, "Typed input ('act')");
		
		WebElement suggestions= (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.className("ui-menu-item")));
		
		autoTest.log(LogStatus.INFO, "Recieved suggestion");
				
		assertTrue(suggestions.getText().equals("ActionScript"));
		
		autoTest.log(LogStatus.PASS, "Correct suggestion recieved after input");	
	}
}
