package testPages;


import org.openqa.selenium.By;

public class loginTest {

    setUp setup = new setUp();

    public void login(String email, String password) {
        setup.set_Up();
        setup.elementFinder(By.id("nav-link-accountList")).click();
        setup.elementFinder(By.id("ap_email")).sendKeys(email);
        setup.elementFinder(By.id("continue")).click();
        setup.elementFinder(By.id("ap_password")).sendKeys(password);
        setup.elementFinder(By.id("signInSubmit")).click();
    }
}
