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

}
