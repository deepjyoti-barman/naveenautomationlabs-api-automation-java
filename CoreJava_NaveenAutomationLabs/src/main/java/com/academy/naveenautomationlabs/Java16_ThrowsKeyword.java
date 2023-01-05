package com.academy.naveenautomationlabs;

import org.testng.annotations.Test;

public class Java16_ThrowsKeyword {

    public void m1() throws  ArithmeticException {
        System.out.println("m1");
        m2();
    }

    public void m2() throws ArithmeticException {
        System.out.println("m2");
        m3();

        // We can either handle the exception at the method level or pass it the caller method
//        try {
//            m3();
//        } catch (ArithmeticException ae) {
//            ae.printStackTrace();
//        }
    }

    public void m3() throws ArithmeticException {
        System.out.println("m3");
        m4();
    }

    public void m4() throws ArithmeticException{
        System.out.println("m4");

        int i = 9 / 0;
    }

    @Test
    public void demo() throws ArithmeticException {
        // Methods being called: demo() / main() -> m1() -> m2() -> m3() -> m4(), where the exception is occurred
        // Exception propagation: m4() -> m3() -> m2() -> m1() -> demo() / main() -> JVM
        Java16_ThrowsKeyword obj = new Java16_ThrowsKeyword();
        obj.m1();
    }
}
