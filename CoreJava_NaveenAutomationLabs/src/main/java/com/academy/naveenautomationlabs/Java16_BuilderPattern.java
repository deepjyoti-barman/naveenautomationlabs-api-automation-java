package com.academy.naveenautomationlabs;

import org.testng.annotations.Test;

class EcomApp {
    // Builder Pattern says that every method can return the same class object
    public EcomApp login() {
        System.out.println("Default login");
        return this;
    }

    public EcomApp login(String un, String pwd) {
        System.out.println("Login with un = " + un + ", pwd = " + pwd);
        return this;
    }

    public EcomApp doSearch(String productName) {
        System.out.println("Search with: " + productName);
        return this;
    }

    public EcomApp doSearch(String productName, int price) {
        System.out.println("Search with: " + productName + ", price: " + price);
        return this;
    }

    public EcomApp selectProduct(String productName) {
        System.out.println("Select the product: " + productName);
        return this;
    }

    public EcomApp addToCart(String productName) {
        System.out.println("Adding the product in card: " + productName);
        return this;
    }

    public EcomApp doPayment(String accName, String pwd) {
        System.out.println("Payment done via: " + accName + ", pwd = " + pwd);
        return this;
    }

    public int generateOrderId() {
        return 10002;
    }

    public EcomApp getEmail() {
        System.out.println("Email is sent successfully");
        return this;
    }

    public EcomApp logout() {
        System.out.println("Logout from the app");
        return this;
    }
}

public class Java16_BuilderPattern {

    @Test
    public void demo() {
        // We can apply the technique of method chaining only to those methods which are not returning anything
        // Disadvantage with this approach is that it violates the POM
        // As here we won't be able to write the assertion, we have to write the assertion/validation within the test method only
        EcomApp shop = new EcomApp();
        shop.login("naveen@gmail.com", "naveen@123")
                .doSearch("Macbook", 1000)
                .addToCart("Macbook")
                .doPayment("ICICI121212", "test123")
                .getEmail()
                .logout()
                .login()
                .doSearch("Nike Shoes")
                .addToCart("Nike Shoes")
                .doPayment("GPAY", "test456")
                .logout();
    }
}
