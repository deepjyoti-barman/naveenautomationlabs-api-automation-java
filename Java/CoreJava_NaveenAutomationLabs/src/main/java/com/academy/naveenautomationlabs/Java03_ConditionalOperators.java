package com.academy.naveenautomationlabs;

import org.testng.annotations.Test;

public class Java03_ConditionalOperators {

    @Test
    public void demo() {
        // < : Less than operator
        // > : Greater than operator
        // <= : Less than or equal
        // >= : Greater than or equal
        // == : Equality operator
        // != : In-equality operator
        int a = 10;
        int b = 20;
        System.out.println(a == b);

        if (a == b)
            System.out.println("If");
        else
            System.out.println("Bye");

        if (true) {
            System.out.println("Testing");
        } else {            // Example of dead / unreachable code
            System.out.println("Development");
        }

        String s1 = "Selenium";
        String s2 = "selenium";

        if (s1.equals(s2)) {
            System.out.println("Both strings are equal");
        } else {
            System.out.println("Both string are not equal");
        }

        if (s1.equalsIgnoreCase(s2)) {
            System.out.println("Both are equal");
        } else {
            System.out.println("Both are not equal");
        }

        // Comparing string references
//        if (s1 == s2) {
//            System.out.println("Both are equal");
//        } else {
//            System.out.println("Both are not equal");
//        }

        // Nested if
        int marks = 60;
        if (marks >= 50) {
            if (marks <= 100)
                System.out.println("S Grade");
            if (marks <= 90)
                System.out.println("A grade");
            if (marks <= 80)
                System.out.println("B grade");
            if (marks <= 60)
                System.out.println("C grade");
        } else {
            System.out.println("Fail");
        }

        // Example in selenium
        // It is a bad practice to use multiple if blocks such as the following
        // Because if the first condition is satisfied then unnecessarily checking all the conditions below
        // from top to bottom will impact the performance of the system
        String browser = "chrome";
        if (browser.equals("chrome"))
            System.out.println("Launch chrome");
        if (browser.equals("firefox"))
            System.out.println("Launch firefox");
        if (browser.equals("safari"))
            System.out.println("Launch safari");

        // if-elseif
        // Solution of previous approach
        // But this approach we got a down-side as well, if only the last if condition is satisfied for a value then
        // we will be unnecessarily checking all the conditions above it which will again impact the performance
        // of the system
        if (browser.equals("chrome")) {
            System.out.println("Launch chrome");
        } else if (browser.equals("firefox")) {
            System.out.println("Launch firefox");
        } else if (browser.equals("safari")) {
            System.out.println("Launch safari");
        } else {
            System.out.println("Please pass the correct browser information...");
        }

        // switch-case
        // Solution of previous two approaches
        // Limitation of switch is it works only with: 'char, byte, short, int, Character, Byte, Short, Integer, String, or an enum'
        // It does not work with: long, float, double and boolean values
        // We can't pass any condition / expression to switch-case
        switch (browser) {
            case "chrome":
                System.out.println("Launch chrome");
                break;
            case "firefox":
                System.out.println("Launch firefox");
                break;
            case "safari":
                System.out.println("Launch safari");
                break;
            default:
                System.out.println("Please pass the correct browser information...");
        }

        // Write a program the largest among three numbers
        int x = 100;
        int y = 200;
        int z = 300;

        if (x > y && x > z) {
            System.out.println("x is having the largest value");
        } else if (y > z) {
            System.out.println("y is having the largest value");
        } else {
            System.out.println("z is having the largest value");
        }

        double d1 = 12.33;
        double d2 = 12.33;
        if (d1 == d2) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        char c1 = 'a';
        char c2 = 'a';
        if (c1 == c2) {
            System.out.println("Hello");            // Hello
        }

        if (c1 == 97) {
            System.out.println("Hey");              // Hey
        }
    }
}
