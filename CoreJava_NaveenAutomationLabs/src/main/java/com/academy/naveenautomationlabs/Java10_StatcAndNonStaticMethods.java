package com.academy.naveenautomationlabs;

import org.testng.annotations.Test;

public class Java10_StatcAndNonStaticMethods {

    String name;
    static int age;

    public void getName() {
        System.out.println("Get name");
    }

    public static void getInfo() {
        System.out.println("Get info");
    }

    @Test
    public void demo() {

        // Local variables can't be static, it can only be used at the class level (properties and methods having global scope)
        int i = 10;             // local variable

        // Access non-static variables and methods -> via creating the object of the class
        Java10_StatcAndNonStaticMethods obj = new Java10_StatcAndNonStaticMethods();
        obj.name = "Tom";
        System.out.println(obj.name);

        obj.getName();

        // Access static variables and methods
        // -> Within the same class you can access them directly, or via class name, or via creating the object of the class
        // -> Outside the class it can be accessed via the class name, or via creating the object of the class
        age = 25;
        System.out.println(age);

        getInfo();

        Java10_StatcAndNonStaticMethods.age = 50;
        System.out.println(age);
        Java10_StatcAndNonStaticMethods.getInfo();

        // But this way of access static variables and methods via the object reference is discouraged as they are not
        // a part of the object
        obj.age = 40;
        obj.getInfo();

        // Non-static properties and methods are stored inside the object and the object itself is stored inside the Heap memory
        // Object references are stored inside the Stack memory
        // Static properties and methods are stored inside the Permanent Generation / Common Memory Allocation (CMA) / Class Static Area
        // All the objects created will be having access to the Permanent Generation / CMA area
        // Before JDK 1.8 Permanent Generation / CMA was an extended part of the stack memory, but now it's a complete separate area
        // e.g. No of wheels of a cars should be a common property, hence it should be a static variable
        // main() method is static in nature so that JVM can call the main() method without creating the object of the class
        // If main() method is overloaded, JVM will call the main() method having `public static void main(String[] args)` as signature
        // If any static method is called recursively to an extent that it consumes all the CMA memory then JVM will throw `java.lang.StackOverflowError`
        // Heap memory is used for the dynamic memory allocation of Java objects and JRE classes at runtime
        // Heap memory is divided into three parts: New or young generation, Old or tenured generation, Permanent generation
        // Young Generation: This is where all new objects are allocated and aged. A minor Garbage collection occurs when this fills up
        // Young generation has three more parts: Eden, Survivor1 and Survivor2
        // Eden: All the newly created objects are allocated in Eden space
        // S1 and S2: When the Eden is full, a minor garbage collection happens, and the live objects are moved to Survivor1 and then to Survivor2
        // Objects that survive Eden, Survivor1 and Survivor2 are moved to Old generation. In Old generation the garbage is collected less frequently, so Survivor1 and Survivor2 spaces are used to make sure that only long survived objects are moved to tenured generation
        // Old Generation: This is where long surviving objects are stored. When objects are stored in the Young Generation, a threshold for the object's age is set, and when that threshold is reached, the object is moved to the old generation. A major garbage collection runs on the old generation to collect dead objects
        // Permanent Generation: Permanent generation is used by JVM to store metadata about the classes and methods. JVM also stores Java standard libraries in permanent generation. This space is cleaned as a part of full garbage collection
        // Inside the same class
        // -> static to static call: directly / via class-name
        // -> static to non-static call: via creating object
        // -> non-static to static call: directly / via class-name
        // -> non-static to non-static call: directly
    }
}
