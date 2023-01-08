package com.academy.naveenautomationlabs;

import org.testng.annotations.Test;

public class Java16_FinallyBlock {

    public static int getMarks(String name) {

        if (name.equals("Sonam")) {
            return 90;
        } else if (name.equals("Tom")) {
            try {
//                int i = 9 / 0;
                int i = 9 / 3;
                return 45;
            } catch (Exception e) {
                return 50;
            } finally {
                return 10;
            }
        } else if (name.equals("Sujan")) {
            return 95;
        }

        return -1;
    }

    @Test
    public void demo() {
        System.out.println("A");

        try {
            int i = 9 / 0;
        } catch(ArithmeticException ae) {
            System.out.println("Exception is caught");
        } finally {
            System.out.println("Bye");
        }

        System.out.println(getMarks("Tom"));            // 10, irrespective of whether exception has occurred or not
        System.out.println(getMarks("Naveen"));         // -1
    }
}
