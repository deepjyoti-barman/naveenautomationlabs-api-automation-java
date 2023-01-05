package com.academy.naveenautomationlabs;

import org.testng.annotations.Test;

import java.util.Arrays;

public class Java05_StaticArray {

    @Test
    public void demo() {
        // Arrays can be of int, double, char, boolean, String etc. types
        int[] i = new int[4];
//        i[-1] = 5;                      // java.lang.ArrayIndexOutOfBoundsException
        i[0] = 10;
        i[1] = 20;
        i[2] = 30;
        i[3] = 40;

        int length = i.length;
        System.out.println("Length: " + length);
        System.out.println("Lowest Index: " + 0);
        System.out.println("Highest Index: " + (length - 1));

        // Printing individual elements
        System.out.println(i[0]);       // 10
        System.out.println(i[1]);       // 20
//        System.out.println(i[4]);       // java.lang.ArrayIndexOutOfBoundsException
//        System.out.println(i[-1]);      // java.lang.ArrayIndexOutOfBoundsException

        // Printing all the elements
        // In-built method
        System.out.println(Arrays.toString(i));

        // for loop
        for (int k = 0; k < i.length; k++) {
            System.out.printf("%d ", i[k]);
        }
        System.out.println();

        // for-each loop
        // Time complexity for iterating 1D array: O(n)
        // Time complexity for iterating 2D array: O(n^2)
        // Time complexity for iterating 3D array: O(n^3)
        for (Integer k : i) {
            System.out.printf("%d ", k);
        }
        System.out.println();
    }
}
