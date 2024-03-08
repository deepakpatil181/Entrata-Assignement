package EntrataAssignment.EntrataAssignment;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WatchDemoFormPresenceTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
  
    	WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver instance
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void validateWatchDemoFormPresence() {
        // Step 1: Open the Entrata Watch Demo page
        driver.get("https://go.entrata.com/watch-demo.html");
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Step 2: Find the element for the Watch Demo form using its ID or other attributes
        WebElement watchDemoForm = driver.findElement(By.xpath("//*[@id=\"lpeCDiv_47777\"]/span"));

        // Step 3: Assert that the found element is not null
        Assert.assertNotNull(watchDemoForm, "Watch Demo form is not present on the page");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
