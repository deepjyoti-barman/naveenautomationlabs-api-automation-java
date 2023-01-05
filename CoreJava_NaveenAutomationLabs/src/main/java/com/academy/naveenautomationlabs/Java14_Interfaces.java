package com.academy.naveenautomationlabs;

import org.testng.annotations.Test;

// Interfaces in Java are a set of abstract and public methods we want our classes to implement
// It is the blueprint of a class and contains static constants and abstract methods
// Interface cannot have any method body, it can only have method prototype / method declaration
// Interface is only for building the prototype, achieve abstraction and implement multiple inheritance
// We cannot create the object of an interface
// All the variables in interface are public, static and final in nature by default
// All the methods in interface are public and abstract in nature
// class to class inheritance -> extends
// interface to interface inheritance -> extends
// interface to class inheritance -> implements
// Interface cannot extend a class
interface USMedical {
    int min_fee = 10;
    public void orthoServices();
    public void physioServices();
    public void cardioServices();
    public void emergencyServices();
    public void totalDoctors(int count);

    // After JDK 1.8:
    // 1. We can have static methods in Interface with method body
    // It is allowed because static methods can't be overridden in Java
    public static void hospitalAdmin() {
        System.out.println("USMedical - hospitalAdmin");
    }

    // 2. We can also have default methods
    // The default methods can be overridden
    // NOTE: If a class / interface is inheriting same default methods from multiple interfaces then it will again fall into the Diamond problem, so in such case compile time error will be shown
    // NOTE: If a class is inheriting the default method of an interface and also inheriting the same public method (public method with same method signature as the default method) from another class
    // then the public method of the class will override default method of the interface in the implementing class
    // i.e. in this case public method of the class will be inherited to the child class, and not the default method of the interface
    default void billing() {
        System.out.println("USMedical - billing");
    }
}

interface UKMedical {
    public void pediaServices();
    public void entServices();
    public void emergencyServices();

    // The following is not allowed because it will again create the diamond problem
//    default void billing() {
//        System.out.println("UKMedical - billing");
//    }
}

interface IndiaMedical {
    public void gyncServices();
    public void neuroServices();
    public void oncologyServices();
    public void emergencyServices();

}

class MedicalAssociation {

    public void medicalTraining() {
        System.out.println("MedicalAssociation - medicalTraining");
    }

    // default void billing() is present in USMedical class as well
    // but once inherited this billing() method will override the behaviour of default billing() method
    public void billing() {
        System.out.println("MedicalAssociation - billing");
    }
}

public class Java14_Interfaces extends MedicalAssociation implements USMedical, UKMedical, IndiaMedical {

    // USMedical
    @Override
    public void orthoServices() {
        System.out.println("Java14_Interfaces - orthoServices");
    }

    @Override
    public void physioServices() {
        System.out.println("Java14_Interfaces - physioServices");
    }

    @Override
    public void cardioServices() {
        System.out.println("Java14_Interfaces - cardioServices");
    }

    @Override
    public void totalDoctors(int count) {
        System.out.println("Total doctors = " + count);
    }

    // We can override default methods of interfaces
//    @Override
//    public void billing() {
//        System.out.println("MedicalAssociation - billing");
//    }

    // UKMedical
    @Override
    public void pediaServices() {
        System.out.println("Java14_Interfaces - pediaServices");
    }

    @Override
    public void entServices() {
        System.out.println("Java14_Interfaces - entServices");
    }

    @Override
    public void emergencyServices() {
        System.out.println("Java14_Interfaces - emergencyServices");
    }

    // IndiaMedical
    @Override
    public void gyncServices() {
        System.out.println("Java14_Interfaces - gyncServices");
    }

    @Override
    public void neuroServices() {
        System.out.println("Java14_Interfaces - neuroServices");
    }

    @Override
    public void oncologyServices() {
        System.out.println("Java14_Interfaces - oncologyServices");
    }

    public void pathologyServices() {
        System.out.println("Java14_Interfaces - pathologyServices");
    }

    public void medicalInsurance() {
        System.out.println("Java14_Interfaces - medicalInsurance");
    }

    @Test
    public void demo() {
        Java14_Interfaces hosp1 = new Java14_Interfaces();
        hosp1.cardioServices();
        hosp1.emergencyServices();
        hosp1.entServices();
        hosp1.gyncServices();

        hosp1.pathologyServices();
        hosp1.medicalInsurance();
        hosp1.totalDoctors(100);
        USMedical.hospitalAdmin();

        hosp1.medicalTraining();
        hosp1.billing();                // Calling the overridden method

        System.out.println(USMedical.min_fee);
        System.out.println(Java14_Interfaces.min_fee);

        // Up casting
        USMedical us = new Java14_Interfaces(); // Child class object can be referred by parent interface reference variable
        us.orthoServices();
        us.physioServices();
        us.cardioServices();
        us.emergencyServices();
//        us.pediaServices();                     // Not allowed
//        us.pathologyServices();                 // Not allowed

        // Down-casting
        Java14_Interfaces hosp2 = (Java14_Interfaces) us;           // No class-cast exception
    }
}
