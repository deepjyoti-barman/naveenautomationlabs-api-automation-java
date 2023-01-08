package com.academy.naveenautomationlabs;

import org.testng.annotations.Test;

import java.util.Arrays;

public class Java04_Loops {

    @Test
    public void demo() {

        // while loop
        // Used when you are aware of the precondition, want to iterate based on a condition
        int i = 1;
        while (i <= 10) {
            System.out.printf("%d ", i);
//            i = i + 1;
//            i++;
            ++i;
        }
        System.out.println();

        // Infinite loop
//        while (true) {
//            System.out.println("Welcome to my hotel!");
//        }

        // for loop
        // Used when we want to iterate a fixed number of times
        // Specifying initialization and increment/decrement in the loop is optional
        // If we do not specify initialization, condition and increment/decrement then the for loop will act as an
        // infinite loop
        for (int j = 1; j <= 10; j++) {
            System.out.printf("%d ", j);
        }
        System.out.println();

        for (int j = 1; j <= 10; ) {
            System.out.printf("%d ", j);
            j++;
        }
        System.out.println();

        int j = 1;
        for (; j <= 10; ) {
            System.out.printf("%d ", j);
            j++;
        }
        System.out.println();

        // infinite loop
//        for ( ; ; ) {
//            System.out.println("Hello");
//        }

        // Print a to z
        for (char c = 'a'; c <= 'z'; c++) {
            System.out.printf("%c ", c);
        }
        System.out.println();

        // for loop with double
        for (double d = 1.1; d < 10; d++) {
            System.out.printf("%f ", d);
        }
        System.out.println();

        // Dead/un-reachable code
//        while (false) {
//            System.out.println("Hi Java");
//        }

        // do-while loop
        // while loop will immediately check the condition before executing the body of the loop
        // Whereas, do-while will at least execute the body of the loop once and then the condition will be checked
        int p = 1;
        do {
            System.out.printf("%d ", p);
            p++;
        } while (p <= 10);
        System.out.println();

        // for-each loop
        // Useful for iterating arrays and collections
        int[] marks = { 100, 200, 300, 400, 500 };
        for (int mark : marks) {
            System.out.printf("%d ", mark);
        }
        System.out.println();

        // forEach method loop
        Arrays.stream(marks).forEach(e -> System.out.printf("%d ", e));
        System.out.println();

        // Write a program to print only even numbers from 1 to 10
        for (int even = 2; even <= 10; even = even + 2) {
            System.out.printf("%d ", even);
        }
        System.out.println();
    }
}
