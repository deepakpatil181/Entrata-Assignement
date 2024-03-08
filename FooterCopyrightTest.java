package EntrataAssignment.EntrataAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Calendar;

public class FooterCopyrightTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
 
    	WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver instance
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void verifyFooterCopyright() {
        // Step 1: Open the Entrata website
        driver.get("https://www.entrata.com");
        
        try {
            WebElement acceptCookiesButton = driver.findElement(By.xpath("//button[@id='rcc-confirm-button']")); 
            acceptCookiesButton.click();
        } catch (Exception e) {
            // Ignore if the accept cookies button is not present or clickable
        }

        // Step 2: Find the element containing the copyright information in the footer
        WebElement footerCopyrightElement = driver.findElement(By.xpath("//span[@class='footer-copyright']"));
        

        // Step 3: Extract the text content from the copyright element
        String footerText = footerCopyrightElement.getText();
        System.out.println(footerText);

        // Step 4: Assert that the extracted text contains the expected string
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        String expectedCopyrightText = "Copyright © " + currentYear + " Entrata";
        Assert.assertTrue(footerText.contains(expectedCopyrightText),
                "Copyright text does not match the expected format");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
