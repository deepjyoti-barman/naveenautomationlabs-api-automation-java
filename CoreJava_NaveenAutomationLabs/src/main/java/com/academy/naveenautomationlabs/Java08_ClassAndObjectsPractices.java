package com.academy.naveenautomationlabs;

import org.testng.annotations.Test;

public class Java08_ClassAndObjectsPractices {

//    String username = "test@gmail.com";         // hard coding allowed, but not recommended
    String username;
    String password;
    String title;
    String url;

    @Test
    public void demo() {
        Java08_ClassAndObjectsPractices login1 = new Java08_ClassAndObjectsPractices();

        // Bad programming practice
        // To store different values we are creating different objects
        new Java08_ClassAndObjectsPractices().username = "admin@gmail.com";
        new Java08_ClassAndObjectsPractices().password = "admin@123";
    }
}
