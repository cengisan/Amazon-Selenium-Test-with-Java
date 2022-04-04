package testPages;

import org.openqa.selenium.By;

public class deleteOrdersTest extends setUp {

    public void deleteOrders() {

        for (int i = Integer.parseInt(elementFinder(By.id("nav-cart-count")).getText()) ; i > 0 ; i--) {

            elementFinder(By.xpath("//div[contains(@data-item-index," + i + ")]"));
            elementFinder(By.className("a-color-link")).click();
        }

    }
}
