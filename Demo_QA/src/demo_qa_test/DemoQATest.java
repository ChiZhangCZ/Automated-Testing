package demo_qa_test;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoQATest {
	
static WebDriver driver;
	
    @Before
    public void setup() {
    	
    	System.setProperty("webdriver.chrome.driver","C:/Users/Admin/Downloads/chromedriver.exe");
    	driver = new ChromeDriver();
    	driver.manage().window().maximize();
		driver.get("http://demoqa.com/");
    }
    
	
	@After
	public void tearDown() {
		
		driver.quit();
	}
	
	@Test
	public void dropTest() {
		
		WebElement dropBtn = driver.findElement(By.id("menu-item-141"));
		dropBtn.click();
		
		WebElement draggable = driver.findElement(By.id("draggableview"));
		WebElement droppable = driver.findElement(By.id("droppableview"));
		
		Actions builder = new Actions(driver);
		Action dragAndDrop = builder.clickAndHold(draggable)
				                    .moveToElement(droppable)
				                    .release(droppable)
				                    .build();
		dragAndDrop.perform();
		
		assertTrue(droppable.getText().equals("Dropped!"));
	}
	
	@Test
	public void selectTest() {
		
		WebElement selectBtn = driver.findElement(By.id("menu-item-142"));
		selectBtn.click();
		
		WebElement item1 = driver.findElement(By.xpath("//*[@id=\"selectable\"]/li[1]"));
		item1.click();
		
		assertTrue(item1.getAttribute("class").contains("ui-selected"));
	}
	
	@Test
	public void accordionTest() {
		
		WebElement accordionBtn = driver.findElement(By.id("menu-item-144"));
		accordionBtn.click();
		
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
		
	}
	

    
	@Test
	public void autoTest() {
		
		WebElement autoBtn = driver.findElement(By.id("menu-item-145"));
		autoBtn.click();
		
		WebElement textbox = driver.findElement(By.id("tagss"));
		textbox.sendKeys("act");
		
		WebElement suggestions= (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.className("ui-menu-item")));
				
		assertTrue(suggestions.getText().equals("ActionScript"));
		
	}

}
