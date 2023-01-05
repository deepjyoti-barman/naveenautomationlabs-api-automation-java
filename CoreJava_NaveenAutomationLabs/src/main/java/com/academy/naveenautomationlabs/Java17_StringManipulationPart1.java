package com.academy.naveenautomationlabs;

import org.testng.annotations.Test;

public class Java17_StringManipulationPart1 {

    @Test
    public void demo() {
        String str = "This is my java code and I am so happy";

        // length(): Length of the string
        int len = str.length();
        int lowIndex = 0;
        int highIndex = len - 1;
        System.out.println("len(): " + len);
        System.out.println(lowIndex);
        System.out.println(highIndex);

        // charAt(): Get the character at the given index
        System.out.println("charAt(): " + str.charAt(2));
//        System.out.println(str.charAt(highIndex));                  // java.lang.StringIndexOutOfBoundsException

        // indexOf(): Get the index of the given character
        int firstOccIndex = str.indexOf('s');
        System.out.println("indexOf(): " + firstOccIndex);                          // 1st occurrence
        System.out.println(str.indexOf('s', firstOccIndex + 1));     // 2nd Occurrence
        System.out.println(str.indexOf("java"));
        System.out.println(str.indexOf("Hello"));

        // toLowerCase(): Convert the string into lowercase
        System.out.println("toLowerCase(): " + str.toLowerCase());

        // toUpperCase(): Convert the string into uppercase
        System.out.println("toUpperCase(): " + str.toUpperCase());
    }
}
