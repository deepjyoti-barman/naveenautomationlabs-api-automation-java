package com.academy.naveenautomationlabs;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;

public class Java07_ArrayListMethods {

    @Test
    public void demo() {
        ArrayList<String> ar =new ArrayList<>();
        ar.add("A");
        ar.add("B");
        ar.add("C");

        System.out.println(ar);
        System.out.println(ar.size());

        // Clear the contents of the ArrayList
        ar.clear();

        System.out.println(ar);
        System.out.println(ar.size());

        ArrayList<String> ar1 =new ArrayList<>();
        ar1.add("A");
        ar1.add("B");
        ar1.add("C");
        ar1.add("D");

        // Shallow copy of ArrayList
        System.out.println(ar1);
        ArrayList<String> ar2 = (ArrayList<String>) ar1.clone();
        System.out.println(ar2);

        // Checking if an element is present
        System.out.println(ar1.contains("D"));

        // Get the index of the element if present else returns -1
        System.out.println(ar1.indexOf("B") > 0);

        ArrayList<String> ar3 = new ArrayList<String>(2);
        ar3.add("Test");
        ar3.add("Selenium");

        System.out.println(ar3);

        // Increase the virtual capacity of an ArrayList
        ar3.ensureCapacity(15);

        // Java 8 Lambdas - loop through and print the elements
        ar1.forEach(e -> System.out.printf("%s ", e));
        System.out.println();
        ar1.forEach(e -> System.out.printf("%s ", e.toLowerCase()));
        System.out.println();

        ArrayList<String> empList = new ArrayList<>();
        empList.add("Tom");
        empList.add("Daisy");
        empList.add("Naveen");
        empList.add("Peter");


        // Sorting the ArrayList
        System.out.println(empList);
        Collections.sort(empList);
        System.out.println(empList);
//        Collections.sort(empList, Collections.reverseOrder());
        empList.sort(Collections.reverseOrder());
        System.out.println(empList);
    }
}