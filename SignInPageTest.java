package EntrataAssignment.EntrataAssignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class SignInPageTest {
	WebDriver driver;

    @BeforeClass
    public void setUp() {

    	WebDriverManager.chromedriver().setup();
        // Initialize ChromeDriver instance
        driver = new ChromeDriver();
        // Maximize the browser window
        driver.manage().window().maximize();
    }

    @Test
    public void verifySignInTitle() {
        // Open the Entrata website
        driver.get("https://www.entrata.com/sign-in");

        // Get the actual title of the page
        String actualTitle = driver.getTitle();

        // Expected title
        String expectedTitle = "Entrata Sign In";
        Assert.assertEquals(actualTitle, expectedTitle, "Title mismatch");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}

