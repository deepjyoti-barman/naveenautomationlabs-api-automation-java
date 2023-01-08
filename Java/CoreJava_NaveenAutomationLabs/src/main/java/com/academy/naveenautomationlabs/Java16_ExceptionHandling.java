package com.academy.naveenautomationlabs;

import org.testng.annotations.Test;

public class Java16_ExceptionHandling {

    String name;

    @Test
    public void demo() {
        System.out.println("Hi");
        System.out.println("Hi");
        System.out.println("Hi");

        try {
            // Program flow will only go through the catch block of the exception is occurred
            Java16_ExceptionHandling obj = new Java16_ExceptionHandling();
            obj = null;
            obj.name = "Tom";
            System.out.println(obj.name);

            int i = 9 / 0;              // java.lang.ArithmeticException
            System.out.println("Bye");  // If the exception is occurred this line of code will not be executed
        } catch (ArithmeticException ae) {
            System.out.println("ArithmeticException has occurred");
            ae.printStackTrace();
        } catch(NullPointerException npe) {
            System.out.println("NullPointerException has occurred");
            npe.printStackTrace();
        }

        System.out.println("Hello");
        System.out.println("Hello");
        System.out.println("Hello");
    }
}
