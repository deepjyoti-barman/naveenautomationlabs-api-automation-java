package com.academy.naveenautomationlabs;

import org.testng.annotations.Test;

public class Java08_ClassAndObjectsGC {

    // Class variables having global scope
    // These variables is going to work like a template to create multiple objects
    // We can access the class variables with the help of the object reference, and not directly
    String name;
    int age;
    double salary;
    boolean isActive;

    @Test
    public void demo() {
        // Create object of the class
        // new Java08_ClassAndObjectsGCCrossReference() creates the object
        // emp1 is the object reference name that points to the object created
        // Inside the object Java will create copy of all the class variables
        // There is no limitation to create an object we can create any number of objects
        // Java will create the object in the heap memory
        // Object reference will be created in the stack memory
        // Head memory is also divided into multiple parts - permanent generation, small generation (search on the web)
        // JVM runs the Garbage collector automatically, whenever JVM finds that heap memory getting occupied heavily
        // Garbage collector will then remove those objects which are not having any references
        // Garbage collector will destroy the objects having no name, or having the null reference name
        // Garbage collector will not come inside stack memory
        Java08_ClassAndObjectsGC emp1 = new Java08_ClassAndObjectsGC();
        System.out.println(emp1.name);          // null
        System.out.println(emp1.age);           // 0
        System.out.println(emp1.salary);        // 0.0
        System.out.println(emp1.isActive);      // false

        emp1.name = "Tom";
        emp1.age = 25;
        emp1.salary = 34.44;
        emp1.isActive = true;

        // Object having no references, ready for garbage collection
        new Java08_ClassAndObjectsGC();

        // null reference, ready for garbage collection
        Java08_ClassAndObjectsGC emp2 = new Java08_ClassAndObjectsGC();
        emp2 = null;
        emp2.name = "Testing";              // NullPointerException

        // System.gc() can be used to call the Garbage collector to erase the unreferenced objects from the memory
        // But, this call does not guarantee to go inside the heap and cleanup memory
        // Even before going inside the heap it will check with the JVM and if JVM finds out the still there is some space available
        // it may not allow the GC to run
//        System.gc();
    }
}
