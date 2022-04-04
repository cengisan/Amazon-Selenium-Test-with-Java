package testPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class searchProductAndAddToCartTest extends setUp {

    public void searchProductAndAddToCart() {

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
}
