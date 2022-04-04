package testPages;

import org.openqa.selenium.By;

public class addToCartAnotherOrderTest extends setUp {

    public void addToCartAnotherOrder() {
        //add another order
        elementFinder(By.id("twotabsearchtextbox")).sendKeys("xiaomi headphones");
        elementFinder(By.id("nav-search-submit-button")).click();
        elementFinder(By.xpath("//img[contains(@data-image-index,2)]")).click();
        elementFinder(By.id("add-to-cart-button")).click();
        elementFinder(By.xpath("//*[@id=\"sw-gtc\"]/span/a")).click();

    }
}
