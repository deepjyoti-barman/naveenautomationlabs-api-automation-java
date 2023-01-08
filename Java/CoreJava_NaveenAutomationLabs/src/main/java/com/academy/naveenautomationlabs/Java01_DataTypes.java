package com.academy.naveenautomationlabs;

import org.testng.annotations.Test;

public class Java01_DataTypes {
    @Test
    public void demo() {
        // 1. byte
        // size: 1 byte = 8 bits
        // range: -128 to 127
        byte b = 10;			// memory allocation in RAM
        // byte b = 20;			// re-allocation with the same variable name not allowed
        b = 20;					// re-assignment is allowed
        byte b1 = 0;
        byte b2 = -10;


        // 2. short
        // size: 2 bytes = 16 bits
        // range: -32768 to 32767
        short s = 10;

        // 3. int
        // size: 4 bytes = 32 bits
        // range: -2^31 to 2^31-1
        int i = 10;

        // 4. long (total no of population, distance from earth to moon etc., bank a/c no can be taken as string as we are not performing any calculations on it)
        // size: 8 bytes = 64 bits
        // range: -2^63 to 2^63-1
        long ph = 9999999;
        long distance = 12121212;
        long e = 10;		    // memory wastage, low performing code

        // 5.float
        // size: 4 bytes =  32 bits
        // range: after point it can take upto 7 digits
        float f = 12.33f;
        float g = (float) 34.44;

        // 6. double
        // size: 8 bytes = 64 bits
        // range: after point it can take upto 15 digits
        double d = 12.33333;
        double d1 = -12.444;
        double d2 = 100;	    // possible as 100 will be treated as 100.00

        // 7. char
        // size: 2 bytes = 16 bits
        char c = 'A';			// c = 'aa', multiple characters now allowed
        char c1 = '1';
        char c2 = '$';
        char gender = 'f';

        // 8. boolean
        // size: (approx) 1 bit.
        boolean flat = true;
        boolean flag1 = false;
    }
}
