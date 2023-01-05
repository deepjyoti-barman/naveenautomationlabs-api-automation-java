package com.academy.naveenautomationlabs;

import org.testng.annotations.Test;

class Employee {
    public String name;
    public int age;
    private int salary;

    private int calculateBonus() {
        double bonus = this.salary * 0.25;
        return (int) bonus;
    }

    // Getter and setter methods
    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }
}

public class Java12_EncapsulationGetterSetter {

    public String name;
    public int empCount;
    private int sharePrice;

    public String getCEOName() {
        return "Tom";
    }

    private int totalSharePrice() {
        return 7000;
    }

    @Test
    public void demo() {

        // Encapsulation: Data Encapsulation can be defined as wrapping the code or methods (properties) and the related fields or variables together as a single unit
        // In object-oriented programming, we call this single unit - a class, interface, etc
        // Data encapsulation helps organize thousands of lines of code for better readability and management. At the same time, it protects the sensitive data as well by restricting access to internal implementation details
        // Data Hiding: Wrapping the (private, default, protected) properties and methods in a unit and restrict direct access to them,
        // then create a public layer (method) so that anyone from outside (the class) can have access of them
        // The basic difference between encapsulation and data hiding is that Encapsulation is a way of bundling data whereas Data Hiding prevents external unauthorized access to the sensitive data
        Java12_EncapsulationGetterSetter obj = new Java12_EncapsulationGetterSetter();
        obj.name = "IBM";
        obj.sharePrice = 500;
        obj.sharePrice = 400;                       // private variables are accessible within the same class but not outside the class

        System.out.println(obj.getCEOName());
        System.out.println(obj.totalSharePrice());  // private methods are also accessible within the same class

        Employee e1 = new Employee();
        e1.setSalary(1000);
        System.out.println(e1.getSalary());
    }
}
