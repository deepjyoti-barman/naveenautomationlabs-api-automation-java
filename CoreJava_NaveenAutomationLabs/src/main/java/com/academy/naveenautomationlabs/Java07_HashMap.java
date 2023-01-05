package com.academy.naveenautomationlabs;

import org.testng.annotations.Test;

import java.util.HashMap;

public class Java07_HashMap {

    @Test
    public void demo() {
        // HashMap stores the values in the form of key-value pair
        // Default virtual capacity of HashMap is 16
        // Based on the key of the HashMap, Java will generate a hash code which in an integer number
        // and based on that integer Java will calculate and place that object into a random index of the memory (0 - 15)
        // this is the reason why in HashMap the elements will not maintain any order
        // IMPORTANT: If a key results in the same hash code / evaluates same index which has been pre-occupied, the object then
        // will be saved in the same segment/index in the form of LinkedList (2nd node of the LinkedList), this is called collision in HashMap
        // For larger applications through Hashing if we keep on getting same index for different keys it will create a long chain of nodes
        // which in turn will decrease the performance of the system - O(n) complexity to search a node in the LinkedList of a segment/index
        // Hence in Java 8: They set the threshold value of the LinkedList nodes to 8
        // and on adding 9th element the LinkedList will be converted into a balanced binary tree - O(log N) complexity to search a node in the balanced binary tree
        // How it will calculate the HashCode? Java will call the hashCode() method that Object class has on the key and will generate the hash code
        // then Java will perform modulo operator on the hash code with the default virtual capacity (i.e. 16) and will calculate the index
        HashMap<String, String> empMap = new HashMap<>();

        empMap.put("A", "Tom");
        empMap.put("B", "Naveen");
        empMap.put("C", "Lisa");
        empMap.put("D", "Peter");

        System.out.println(empMap.get("B"));
        System.out.println(empMap.size());
    }
}
