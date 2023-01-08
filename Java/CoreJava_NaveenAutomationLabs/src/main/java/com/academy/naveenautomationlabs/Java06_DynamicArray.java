package com.academy.naveenautomationlabs;

import org.testng.annotations.Test;

import java.util.ArrayList;

public class Java06_DynamicArray {

    @Test
    public void demo() {
        // Dynamic arrays are implemented by creating object the class ArrayList
        // ArrayList is an index based linear collection
        // Virtual/Initial capacity: How many elements can be stored inside the array
        // Physical/Actual capacity: How many elements are actually stored inside the array, arr.size() method will return the physical capacity
        // ArrayList internally will create a static array and will allocate memory to store 10 elements (default virtual capacity = 10)
        // Upon adding the 11th element the virtual capacity of the array will increase by 5

        ArrayList ar = new ArrayList();     // Virtual capacity = 10, Physical capacity = 0
        ar.add(100);
        ar.add(200);
        ar.add(300);
        ar.add(400);                        // Virtual capacity = 6, Physical capacity = 4
        ar.add(500);
        ar.add(600);
        ar.add(700);
        ar.add(800);
        ar.add(900);
        ar.add(1000);                       // Virtual capacity = 0, Physical capacity = 10
        ar.add(1100);                       // Virtual capacity = 4, Physical capacity = 11
        System.out.println("Size of the ArrayList: " + ar.size());

        // We can increase the Virtual capacity of the ArrayList by passing it as an argument to the ArrayList object
        ArrayList ar1 = new ArrayList(20);

        // ArrayList without generic or type are considered as raw type
        // We can add generics/types for ArrayList
        // Generic or type should be non-primitive
        // Practical use of ArrayList / dynamic arrays to store links in amazon where the count change every week
        ArrayList<Integer> ar2 = new ArrayList<>();
        ar2.add(1);
        ar2.add(2);
        ar2.add(3);
        ar2.add(4);
        ar2.add(5);
        System.out.println("ar2[0] = " + ar2.get(0));         // 1
        ar2.remove(2);
        System.out.println("Size = " + ar2.size());
        System.out.println("ar2 = " + ar2);
//        System.out.println(ar2.get(6));         // java.lang.IndexOutOfBoundsException
//        System.out.println(ar2.get(-1));        // java.lang.IndexOutOfBoundsException
    }
}
