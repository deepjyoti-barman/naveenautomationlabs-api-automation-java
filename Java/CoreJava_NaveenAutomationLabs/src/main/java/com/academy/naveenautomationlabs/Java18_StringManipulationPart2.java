package com.academy.naveenautomationlabs;

import org.testng.annotations.Test;

import java.util.Arrays;

public class Java18_StringManipulationPart2 {

    @Test
    public void demo() {

        // trim(): Remove whitespaces from both the end
        String s = "   hello world        ";
        System.out.println("trim(): " + s.trim());

        // replace(char, char): Replace a character of the string with another character
        String dob = "01-01-1990";
        System.out.println("replace(char, char): " + dob.replace('-', '/'));

        // replace(CharSequence, CharSequence): Replace a part of string with another string
        String s1 = "Hello Java and I am happy with Java";
        System.out.println("replace(CharSequence, CharSequence): " + s1.replace("Java", "Python"));

        // replaceAll(String regex, String replacement): Replace the given regex of the string with another string
        String sentence = "Dolly dances very well";
        System.out.println("replaceAll(String regex, String replacement): " + sentence.replaceAll("dances", "sings"));

        // replaceFirst(String regex, String replacement): Replace the first occurrence of a part of string with another string
        System.out.println("replaceFirst(String regex, String replacement): " + s1.replaceFirst("Java", "C++"));

        // contains(): Check whether a given value is present in the string
        String s2 = "welcome admin";
        System.out.println("contains(): " + s2.contains("admin"));

        // concat(): Join to strings together
        String s11 = "Hello";
        String s12 = " Selenium";
        System.out.println("concat(): " + s11.concat(s12).concat(" Test automation"));

        // equals(): Compare two strings
        String s3 = "this is my java code";
        String s4 = "This is my java code";
        System.out.println("equals(): " + s3.equals(s4));

        // equalsIgnoreCase(): Compare two strings ignoring cases
        System.out.println("equalsIgnoreCase(): " + s3.equalsIgnoreCase(s4));

        // substring(): Retrieve a small part of string from a larger string
        String s5 = "This is my order id 12345";
        System.out.println("substring(): " + s5.substring(11));
        System.out.println(s5.substring(0, 9));         // get the string from 0 to endIndex - 1
        System.out.println(s5.substring(s5.indexOf("id") + 3, s5.length()));

        // split(): Split the string into multiple strings and return a String array
        String test = "Java|Python|JavaScript|Ruby";
        String[] strArr = test.split("\\|");
        System.out.print("split(): ");
        Arrays.stream(strArr).forEach(e -> System.out.printf("%s ", e));
        System.out.println();

        // Data conversion
        // String to int
        String x = "100";
        int i = Integer.parseInt(x);
        System.out.println("parseInt(): " + (i + 20));                      // 120

        String y = "200A";
//        int j = Integer.parseInt(y);                                      // java.lang.NumberFormatException

        // int to String
        int total = 1000;

        System.out.println("valueOf(): " + String.valueOf(total) + 20);     // 10020
        System.out.println(total + "" + 20);                                // 10020
    }
}
