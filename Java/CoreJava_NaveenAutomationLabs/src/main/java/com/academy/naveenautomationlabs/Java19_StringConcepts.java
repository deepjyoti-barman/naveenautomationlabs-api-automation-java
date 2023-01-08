package com.academy.naveenautomationlabs;

import org.testng.annotations.Test;

public class Java19_StringConcepts {

    public static String reverseString(String value) {
        if (value == null)
            return null;

        int len = value.length();

        if (len == 1)
            return value;

        String rev = "";
        for (int i = len - 1; i >= 0; i--) {
            rev = rev + value.charAt(i);
        }

        return rev;
    }

    @Test
    public void demo() {
        String s1 = "naveen";                           // Object created in String Constant Pool (SCP) area inside the heap
        String s2 = "selenium";
        String s3 = "naveen";                           // Object not created, s3 is pointing to the same string s1 in pointing to in SCP area - advantage of this is memory utilization

        s2.concat(s1);
        System.out.println(s2);                         // selenium, because strings are immutable in nature
        s2 = s1.concat(s2);
        System.out.println(s2);                         // seleniumnaveen, because now the reference variable s1 is pointing to the new object created

        System.out.println(s1 == s3);                   // true
        System.out.println(s1.equals(s3));              // true


        String s4 = new String("naveen");       // New object created directly inside the heap area
        String s5 = new String("naveen");       // New object created directly inside the heap area

        System.out.println(s4 == s5);                   // false
        System.out.println(s4.equals(s5));              // true

        // String reversal programmatically
        System.out.println(reverseString("Deepjyoti"));

        // StringBuffer is mutable class
        // String reversal using StringBuffer class
        StringBuffer sb = new StringBuffer("Selenium");
        sb.reverse();
        System.out.println(sb);
    }
}
