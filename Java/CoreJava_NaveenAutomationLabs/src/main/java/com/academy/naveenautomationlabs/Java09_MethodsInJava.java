package com.academy.naveenautomationlabs;

import org.testng.annotations.Test;

public class Java09_MethodsInJava {

    // 1. No input and no return value
    public void test() {
        System.out.println("Test method");
    }

    // 2. No input but with some return value
    public int getMarks() {
        System.out.println("Get Marks");
        int total = 100;
        int bonus = 50;
        int totalMarks = total + bonus;

        return totalMarks;
    }
    // 3. Some input and some return value
    public int sum(int a, int b) {
        System.out.println("Sum method");
        int c = a + b;
        return c;
    }

    // 4. Some input but no return value
    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }

    // Method overloading
    // Practical example in e-commerce application
    // Without method overloading we may need to provide longer names to support using different methods
    public void search() { }
    public void search(String name) {
        System.out.println("Searching for " + name);
    }
    public void search(String name, int price) { }
    public void search(String name, int price, String color) { }
    public void search(int price, String name, String model) { }

    public void login(String un, String pwd) {
        System.out.println("Logged in with username = " + un + ", password = " + pwd);
    }
    public void login(String un, String pwd, int otp) { }
    public void login(String un, String pwd, int otp, String role) { }
    public void login(String un, String pwd, int otp, long captchaNumber) { }

    public void doPayment(String UPI) { }
    public void doPayment(String phone, int otp) { }
    public void doPayment(long creditCardNo, int cvv) {
        System.out.println("Payment is done with credit card no " + creditCardNo + " and CVV " + cvv);
    }

    @Test
    public void demo() {
        // Method is a block or generic piece of code which is responsible for performing a certain task
        // Limitation: We cannot create a method inside another method
        // main() method is the entry point of the program execution
        // JVM will never store any static method inside the object, only non-static methods will be stored
        // main() method is void in nature because it is focused towards executing the program and not returning any value to JVM
        // Method overloading (OOP - Polymorphism - Compile time polymorphism):
        // 1. with-in the same class when we have different methods with the same name and
        // 2. different parameters and
        // 3. sequence of the parameters are also different
        // Poly = many, morphs = forms -> it can have two things method overloading and method overriding
        Java09_MethodsInJava obj1 = new Java09_MethodsInJava();
        obj1.test();

        int p = obj1.getMarks();
        System.out.println(p);

        int s1 = obj1.sum(10, 20);
        System.out.println(s1);

        obj1.sayHello("Naveen");

        obj1.login("Naveen", "abc@123");
        obj1.search("iPhone 14");
        obj1.doPayment(171245896, 129);
    }
}
