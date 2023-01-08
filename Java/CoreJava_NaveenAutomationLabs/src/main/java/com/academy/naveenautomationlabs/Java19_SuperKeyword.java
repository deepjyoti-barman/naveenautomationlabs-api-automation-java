package com.academy.naveenautomationlabs;

import org.testng.annotations.Test;

class Page {
    int loadTime = 30;

    public Page() {
        System.out.println("Page constructor");
    }

    public Page(int time) {
        // this() call is used to call the constructor of the same class, i.e. constructor chaining
        this();
        System.out.println("Page constructor with time: " + time);
    }

    public void pageTitle() {
        System.out.println("Page title");
    }
}

class LoginPage extends Page {
    int loadTime = 20;

    public LoginPage(int time) {
        // At the time of object creation of the child class internally child class will call the default constructor of the parent class
        // The following call will be going automatically even if we comment out the code
        // NOTE: super() keyword should be the first statement of the constructor inside the child class
        // NOTE: we can't have two super() calls inside the child class constructor
//        super();
        super(time);
        System.out.println("Login page constructor");
    }

    // `super` keyword is used to access the properties and methods of super class
    // Especially used when certain properties and methods are overridden in child class
    void loading() {
        System.out.println("Login page load time: " + loadTime);
        System.out.println("Page load time: " + super.loadTime);

        pageTitle();
        super.pageTitle();
    }

    public void pageTitle() {
        System.out.println("Login page title");
    }
}
public class Java19_SuperKeyword {

    @Test
    public void demo() {
        LoginPage lp = new LoginPage(40);
        lp.loading();
    }
}
