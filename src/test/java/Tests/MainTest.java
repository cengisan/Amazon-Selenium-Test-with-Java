package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class MainTest extends UserDataJsonParser {

    public WebDriverWait wait;
    protected WebDriver driver;
    public static String baseUrl = "https://www.amazon.com.tr/";

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    public WebElement elementFinder(By selector) {
        //wait until the web element become visible.
        return wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    @Test(priority = 1)
    public void login() {

        driver.get(baseUrl);
        elementFinder(By.id("nav-link-accountList")).click();
        elementFinder(By.id("ap_email")).sendKeys(user.getEmail());
        elementFinder(By.id("continue")).click();
        elementFinder(By.id("ap_password")).sendKeys(user.getPassword());
        elementFinder(By.id("signInSubmit")).click();
    }

    @Test(priority = 2)
    public void searchProductAndAddToCart() throws InterruptedException {

        elementFinder(By.id("twotabsearchtextbox")).sendKeys("Iphone pro max 13");
        elementFinder(By.id("nav-search-submit-button")).click();
        elementFinder(By.xpath("//*[@id=\"a-autoid-0-announce\"]")).click();
        elementFinder(By.xpath("//*[@id=\"s-result-sort-select_2\"]")).click();
        //Set order according to data-index
        elementFinder(By.xpath("//div[contains(@data-index,12)]")).click();
        WebElement a = driver.findElement(By.id("simpleBundleV2_feature_div"));
        boolean value = a.isEnabled();

        if (value) {
            elementFinder(By.xpath("//*[@id=\"simpleBundleV2_feature_div\"]/div/div[1]/div/div/span[1]/div/label/input")).click();
            //add your order
            elementFinder(By.id("add-to-cart-button")).click();
            elementFinder(By.xpath("//*[@id=\"attach-sidesheet-view-cart-button\"]/span/input")).click();

        } else {
            //add your order
            elementFinder(By.id("add-to-cart-button")).click();
            elementFinder(By.xpath("//*[@id=\"sw-gtc\"]/span/a")).click();
        }

        //delete an order
        elementFinder(By.className("a-color-link")).click();
    }

    @Test(priority = 3)
    public void addToCartAnotherOrder() throws InterruptedException {
        //add another order
        elementFinder(By.id("twotabsearchtextbox")).sendKeys("xiaomi headphones");
        elementFinder(By.id("nav-search-submit-button")).click();
        elementFinder(By.xpath("//img[contains(@data-image-index,2)]")).click();
        elementFinder(By.id("add-to-cart-button")).click();
        elementFinder(By.xpath("//*[@id=\"sw-gtc\"]/span/a")).click();

    }

    @Test(priority = 4)
    public void deleteOrders() throws InterruptedException {

        elementFinder(By.className("a-color-link")).click();
        elementFinder(By.className("a-color-link")).click();

    }

    @Test(priority = 5)
    public void logout() throws InterruptedException {

        elementFinder(By.id("nav-hamburger-menu")).click();
        elementFinder(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[16]/a")).click();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
