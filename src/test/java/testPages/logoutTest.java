package testPages;

import org.openqa.selenium.By;

public class logoutTest extends setUp {

    public void logout() {

        elementFinder(By.id("nav-hamburger-menu")).click();
        elementFinder(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[16]/a")).click();
    }
}
