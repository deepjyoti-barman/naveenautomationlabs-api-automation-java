package com.academy.naveenautomationlabs;

import org.testng.annotations.Test;

interface Scalar {
    void scalarAcademy();
    void scalarPrograms();
    void scalarForever();
}

abstract class Student implements Scalar {

    @Override
    public void scalarAcademy() {
        System.out.println("A structured, flexible and guided learning program");
    }

    @Override
    public void scalarPrograms() {
        System.out.println("4 services are provided by Scalar");
    }
}

class InterviewBit extends Student {
    @Override
    public void scalarForever() {
        System.out.println("Limitless learning, collective career growth");
    }
}

public class Java15_Abstraction {

    @Test
    public void demo() {
        InterviewBit ib = new InterviewBit();
        ib.scalarAcademy();
        ib.scalarPrograms();
        ib.scalarForever();
    }
}
