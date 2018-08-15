import static org.junit.Assert.*;
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

public class DemoTest {
	
	static WebDriver driver;
	static ExtentReports extent;
	
    @BeforeClass
    public static void init() {
    	
    	System.setProperty("webdriver.chrome.driver","C:/Users/Admin/Downloads/chromedriver.exe");
    	extent = new ExtentReports("C:\\Users\\Admin\\Desktop\\Automated-Testing\\The_Demo_Site\\extent report\\LoginRegistrationReport.html", true);
    }
    
    @Before
    public void setup() {
    	
    	driver = new ChromeDriver();
    	driver.manage().window().maximize();
    }
    
	
	@After
	public void tearDown() {
		
		driver.quit();
		extent.flush();
	}
	
	@Test
	public void loginTest() {
		
		ExtentTest loginTest = extent.startTest("Login Test");

		driver.manage().window().maximize();
		driver.get("http://thedemosite.co.uk/addauser.php");
		
		loginTest.log(LogStatus.INFO, "Browser started");
		
		WebElement username = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement register = driver.findElement(By.name("FormsButton2"));
		
	    username.sendKeys("Notorious");
	    password.sendKeys("password");
	    register.submit();
	    
	    loginTest.log(LogStatus.INFO, "User registered");
	    
	    driver.get("http://thedemosite.co.uk/login.php");
	    WebElement loginName = driver.findElement(By.name("username"));
	    WebElement loginPass = driver.findElement(By.name("password"));
	    WebElement login = driver.findElement(By.name("FormsButton2"));
	    
	    loginName.sendKeys("Notorious");
	    loginPass.sendKeys("password");
	    login.submit();
	    
	    WebElement isLoggedIn = driver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > big > blockquote > blockquote > font > center > b"));
	    assertTrue(isLoggedIn.getText().equals("**Successful Login**"));
	    
	    loginTest.log(LogStatus.INFO, "User logged In");
	    loginTest.log(LogStatus.PASS, "User registered and logged in successfully");
	}

}
