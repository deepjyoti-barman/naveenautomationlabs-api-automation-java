package com.academy.naveenautomationlabs;

import org.testng.annotations.Test;

class Car {
    int engine = 10;

    protected void start() {
        System.out.println("Car - start()");
    }

    public void stop() {
        System.out.println("Car - stop()");
    }

    public void refuel() {
        System.out.println("Car - refuel()");
    }

    public static void sunRoof() {
        System.out.println("Car - sunRoof()");
    }

}

public class Java13_InheritanceAndMethodOverriding extends Car {

    // Overridden method
    @Override
    public void start() {
        System.out.println("Java13_InheritanceAndMethodOverriding - start()");
    }

    public void autoParking() {
        System.out.println("Java13_InheritanceAndMethodOverriding - autoParking()");
    }

    // static methods can't be overridden in Java, because static methods are not a part of the object
    // but method overloading is allowed, below is a normal method
    public static void sunRoof() {
        System.out.println("Java13_InheritanceAndMethodOverriding - sunRoof()");
    }

    @Test
    public void demo() {
        // Inheritance: Inheritance is an object-oriented programming concept in which one class acquires the properties and behavior of another class
        // It represents a parent-child relationship between two classes. This parent-child relationship is also known as an IS-A relationship
        // Inheritance provides code re-usability
        // A superclass, also known as parent class or base class
        // A subclass, also known as child class or derived class
        // Multiple inheritance is not allowed in Java, because it creates the famous Diamond problem
        // Diamond Problem:
        // -> If same method is there in both the parent classes then child class is not sure which one to inherit
        // -> When we are creating an object of the child class, child class is not sure which parent class's constructor to be called
        // Diamond is solved with the help of interfaces
        // Method overriding: When we have a parent class having the same method with same name and same number of parameters in child class. For method overriding
        // -> The method name should be same
        // -> The no of parameters of the methods in child and parent classes should be same
        // -> The order of parameter of the methods in child and parent classes should be same
        // -> The return type of the methods in both the classes should be same
        // -> Access specified in child class should be equal or greater than that of the parent class
        // e.g. if parent method is protected, child can have method as protected or public but not default or private
        Java13_InheritanceAndMethodOverriding car1 = new Java13_InheritanceAndMethodOverriding();
        car1.start();                   // Calling the overridden method
        car1.stop();
        car1.refuel();
        car1.autoParking();
        car1.sunRoof();                 // Java13_InheritanceAndMethodOverriding - sunRoof()
        Java13_InheritanceAndMethodOverriding.sunRoof();        // Java13_InheritanceAndMethodOverriding - sunRoof()
        System.out.println(car1.engine);

        Car car2 = new Car();
        car2.start();
        car2.stop();
        car2.refuel();
//        car2.autoParking();             // Can't acces
        car2.sunRoof();                 // Car - sunRoof()
        Car.sunRoof();                  // Car - sunRoof()
        System.out.println(car2.engine);

        // Up casting / Top casting: Child class object can be referred by parent class reference variable
        // Method overriding -> Dynamic or run time polymorphism, as start() method is present in both parent and child class so compiler does the reference type check
        // and takes the decision at runtime to execute the respective method based on the object passed
        // Reference type check does not allow a parent class reference variable to call a method which is present only in child class
        Car car3 = new Java13_InheritanceAndMethodOverriding();
        car3.start();
        car3.stop();
//        car3.autoParking();             // Can't access, because of reference type check
        car3.sunRoof();                 // Car - sunRoof()
        Car.sunRoof();                  // Car - sunRoof()

        // Down casting: Parent class object is referred by child class reference variable
        // Down casting is allowed during compile time
        // Down casting at runtime will give you `java.lang.ClassCastException`
//        Java13_InheritanceAndMethodOverriding car4 = (Java13_InheritanceAndMethodOverriding) new Car();         // java.lang.ClassCastException
        // If a method is declared as `final` then the method can't be overridden
        // If a class is declared as `final` then the class can't be extended / inherited
        // If a variable is declared as `final` then the value of variable can't be changed
    }
}
