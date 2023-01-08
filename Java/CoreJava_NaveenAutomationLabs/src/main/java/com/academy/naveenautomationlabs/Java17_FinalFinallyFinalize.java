package com.academy.naveenautomationlabs;

import org.testng.annotations.Test;

class Company {
    String cmpName;
    String address;
}

public class Java17_FinalFinallyFinalize {

    public static int getMarks(String name) {
        if (name.equals("Tom")) {
            try {
                int i = 9 / 0;
            } catch (ArithmeticException ae) {
                return 98;
            }

            try {
                int p = 10 / 0;
                return 95;
            } catch (Exception e) {
                return 65;
            } finally {
                return 60;
            }
        } else {
            System.out.println("Name not found");
            return -1;
        }
    }

    @Override
    public void finalize() {
        System.out.println("Inside the finalize() method of Java17_FinalFinallyFinalize class");
    }

    @Test
    public void demo() {

        // demo of final keyword
        final int a = 10;
        final int b;
        b = 20;
//        b = 30;                         // CTE

//        a = 20;                         // CTE
//        System.out.println(a++);        // CTE
        System.out.println(a);
        System.out.println(b);


        // demo of finally block
        int p = 10;

        try {
            int div = p / 0;
        } catch (ArithmeticException ae) {
            System.out.println("Arithmetic Exception has occurred");
        } finally {
            System.out.println("Inside finally block");
        }

        System.out.println("Bye");
        System.out.println(getMarks("Tom"));            // 98


        // demo of finalize()
        // finalize() method will be called before destroying this class object
        Java17_FinalFinallyFinalize obj = new Java17_FinalFinallyFinalize();
        obj = null;

        // finalize() method will not be called before destroying this class object
        // Because we did not have any finalize() method associated with the Company class
        Company obj2 = new Company();
        obj2 = null;

        System.gc();
        System.out.println("Bye Bye");
    }
}
