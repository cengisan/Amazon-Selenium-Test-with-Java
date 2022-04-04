package testCases;

import database.UserDataJsonParser;
import testPages.*;

import org.testng.annotations.Test;

public class test extends UserDataJsonParser {


    @Test(priority = 1)
    public void login_Test() {
        new setUp();
        loginTest singin = new loginTest();
        singin.login(user.getEmail(), user.getPassword());
    }

    @Test(priority = 2)
    public void search_Product_And_Add_To_Cart() {
        searchProductAndAddToCartTest search = new searchProductAndAddToCartTest();
        search.searchProductAndAddToCart();
    }

    @Test(priority = 3)
    public void add_To_Cart_Another_Order() {

        addToCartAnotherOrderTest add = new addToCartAnotherOrderTest();
        add.addToCartAnotherOrder();
    }

    @Test(priority = 4)
    public void delete_Orders() {

        deleteOrdersTest delete = new deleteOrdersTest();
        delete.deleteOrders();
    }

    @Test(priority = 5)
    public void log_out() {

        logoutTest signout = new logoutTest();
        signout.logout();
    }
}
