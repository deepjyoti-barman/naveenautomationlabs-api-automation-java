package com.academy.naveenautomationlabs;

import org.testng.annotations.Test;

public class Java16_ThrowKeyword {

    @Test
    public void demo() {

        try {
            throw new Exception("Excel Cell Data is Blank");
        } catch (Exception e) {
            System.out.println("Some exception has occurred");
            e.printStackTrace();
        }
    }
}
