package com.academy.naveenautomationlabs;

import org.testng.annotations.Test;

public class Java11_ConstructorThisKeyword {

    String name;
    int age;
    String dob;
    String city;
    boolean isPermanent;

    // Constructor is used to initialize the instance variables of an object
    // Name of the constructor will remain same as the class name
    // Constructor will be called at the time of object creation
    // Constructor looks like a function, but it is not a function
    // Constructor will never return a value: no return or no void keywords in constructor, but a function may or may not return a value
    public Java11_ConstructorThisKeyword() {
        System.out.println("Default constructor");
    }

    public Java11_ConstructorThisKeyword(String name) {
        // With the help of `this` keyword we can access all the class variables
        // If we don't want to use `this` keyword then we should name the local variable differently from the class variable
        this.name = name;
    }

    public Java11_ConstructorThisKeyword(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Java11_ConstructorThisKeyword(String name, int age, String dob, String city, boolean isPermanent) {
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.city = city;
        this.isPermanent = isPermanent;
    }

    @Test
    public void demo() {
        Java11_ConstructorThisKeyword emp1 = new Java11_ConstructorThisKeyword("Tom");
        System.out.println(emp1.name);

        Java11_ConstructorThisKeyword emp2 = new Java11_ConstructorThisKeyword("Lisa", 25);
        System.out.println(emp2.name + " " + emp2.age);

        Java11_ConstructorThisKeyword emp3 = new Java11_ConstructorThisKeyword("Peter", 31, "10-01-1990", "London", true);
        System.out.println(emp3.name + " " + emp3.age + " " + emp3.city);
    }
}
