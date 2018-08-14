import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoTest {
	
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
	public void loginTest() {

		driver.manage().window().maximize();
		driver.get("http://thedemosite.co.uk/addauser.php");
		WebElement username = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement register = driver.findElement(By.name("FormsButton2"));
		
	    username.sendKeys("Notorious");
	    password.sendKeys("password");
	    register.submit();
	    
	    driver.get("http://thedemosite.co.uk/login.php");
	    WebElement loginName = driver.findElement(By.name("username"));
	    WebElement loginPass = driver.findElement(By.name("password"));
	    WebElement login = driver.findElement(By.name("FormsButton2"));
	    
	    loginName.sendKeys("Notorious");
	    loginPass.sendKeys("password");
	    login.submit();
	    
	    WebElement isLoggedIn = driver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > big > blockquote > blockquote > font > center > b"));
	    
	    assertTrue(isLoggedIn.getText().equals("**Successful Login**"));
	    
	}

}
