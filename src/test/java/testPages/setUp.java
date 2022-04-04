package testPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class setUp {
    public static WebDriverWait wait;
    protected static WebDriver driver;
    public static String baseUrl = "https://www.amazon.com.tr/";

    @BeforeSuite
    public void set_Up() {
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));

    }


    public static WebElement elementFinder(By selector) {
        //wait until the web element become visible.
        return wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}

