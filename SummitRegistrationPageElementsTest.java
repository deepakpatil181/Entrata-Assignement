package EntrataAssignment.EntrataAssignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class SummitRegistrationPageElementsTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
  
    	WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver instance
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void validateSummitRegistrationPageElements() throws InterruptedException {
        // Step 1: Open the Entrata website
        driver.get("https://www.entrata.com");
        
        try {
            WebElement acceptCookiesButton = driver.findElement(By.xpath("//button[@id='rcc-confirm-button']")); 
            acceptCookiesButton.click();
        } catch (Exception e) {
            // Ignore if the accept cookies button is not present or clickable
        }

        // Step 2: Scroll down to find the Summit link and click on it
        WebElement summitLink = driver.findElement(By.xpath("//a[text()='Summit']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", summitLink);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        summitLink.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // Step 3: Click on the "Register Now" button
        WebElement registerNowButton = driver.findElement(By.xpath("//a[@class='header-button w-button']"));
        registerNowButton.click();

        // Step 4: Switch to the new window
        String currentWindowHandle = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(currentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

     // Step 5: Assert all the elements on the registration page
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='56aeaca6-a0ad-4548-8afc-94d8d4361ba1']"))).isDisplayed(), true);
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='cfc98829-80b7-41b6-82b5-b968d43ef1c1']"))).isDisplayed(), true);
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='1e153f32-bbcf-4c01-b101-63847a382051']"))).isDisplayed(), true);
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='227f50d0-f65b-4a72-9a4f-5060ea05f6ab']"))).isDisplayed(), true);
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='228cc308-a4d9-4212-8454-8407dd578c3d']"))).isDisplayed(), true);
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ff919d05-4281-4d9c-aa0d-82e3722d580d']"))).isDisplayed(), true);
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='032e80c1-f29f-44e6-af13-a89e53906422']"))).isDisplayed(), true);
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='032e80c1-f29f-44e6-af13-a89e53906422']"))).isDisplayed(), true);
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='032e80c1-f29f-44e6-af13-a89e53906422']"))).isDisplayed());
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
