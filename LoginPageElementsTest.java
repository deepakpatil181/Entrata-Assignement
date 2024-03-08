package EntrataAssignment.EntrataAssignment;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageElementsTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
   
    	WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver instance
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void validateLoginPageElements() {
        // Step 1: Open the Entrata Login page
        driver.get("https://www.entrata.com/sign-in");
        
        // Step 2: Accept cookies if the element is present
        try {
            WebElement acceptCookiesButton = driver.findElement(By.xpath("//button[@id='rcc-confirm-button']")); 
            acceptCookiesButton.click();
        } catch (Exception e) {
            // Ignore if the accept cookies button is not present or clickable
        }
          
        driver.findElement(By.xpath("//a[@title='Client Login Button']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Step 2: Use explicit wait to wait for the username field to be present
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement usernameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='entrata-username']")));

        // Step 3: Assert that the username field is found and displayed
        Assert.assertTrue(usernameField.isDisplayed(), "Username field is not displayed");

        // Step 4: Use explicit wait to wait for the password field to be present
        WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='entrata-password']")));

        // Step 5: Assert that the password field is found and displayed
        Assert.assertTrue(passwordField.isDisplayed(), "Password field is not displayed");
        
        WebElement SigninBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@type='submit']"))); 
        Assert.assertTrue(SigninBtn.isDisplayed(), "Sign In Button is not displayed");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
