package com.academy.naveenautomationlabs;

import org.testng.annotations.Test;

public class Java02_StringConcatIncrDecrAscii {

    @Test
    public void demo() {
        // String concatenation
        String s1 = "Hello world";
        System.out.println(s1);

        String s2 = "1000";
        System.out.println(s2);

        int a = 100;
        int b = 200;
        double d1 = 12.33;
        double d2 = 23.33;
        String x = "Hello";
        String y = "Selenium";

        System.out.println(a + b);                      // 300, arithmetic operation
        System.out.println(x + y);                      // HelloSelenium, concatenation
        System.out.println(a + b + x + y);              // 300HelloSelenium
        System.out.println(x + y + a + b);              // HelloSelenium100200
        System.out.println(x + y + (a + b));            // HelloSelenium300
        System.out.println(d1 + d2);                    // 35.66
        System.out.println(a + b + d1 + d2);            // 335.65999999999997
        System.out.println(a + b + d1 + d2 + x + y);    // 335.65999999999997HelloSelenium
        System.out.println(x + y + a + b + d1 + d2);    // HelloSelenium10020012.3323.33

        System.out.println("The value of a is: " + a);
        System.out.println("The value of b is: " + b);
        System.out.println("The sum is: " + (a + b));

        // Arithmetic operations
        char c = 'a';       // ASCII = 97
        char c1 = 'b';      // ASCII = 98
        System.out.println(a);                          // a
        System.out.println(c + c1);                     // 195 = 97 + 98 (ASCII values)
        System.out.println(c + a);                      // 197
        System.out.println(x + c);                      // Helloa
        System.out.println(4 / 2);                      // 2
        System.out.println(5 / 2);                      // 2
        System.out.println(5.0 / 2);                    // 2.5
        System.out.println(5 / 2.0);                    // 2.5
        System.out.println(5.0 / 2.0);                  // 2.5
//        System.out.println(9 / 0);                      // java.lang.ArithmeticException
        System.out.println(0 / 10);                     // 0
        System.out.println(4 % 2);                      // 0
        System.out.println(5 % 2);                      // 1
        System.out.println(17 % 3);                     // 2

        // Increment (++) and decrement (--) operators
        // Post-increment (first assign/use and then increment)
        int i = 1;
        int j = i++;
        System.out.println(i);                          // 2
        System.out.println(j);                          // 1

        int cc = -99;
        int dd = cc++;
        System.out.println(cc);                          // -98
        System.out.println(dd);                          // -99

        int g = -1000;
        int h = g++;
        System.out.println(g);                          // -999
        System.out.println(h);                          // -1000

        // Pre-increment (first increment and then assign/use)
        int m = 1;
        int n = ++m;
        System.out.println(m);                          // 2
        System.out.println(n);                          // 2

        int u = -99;
        int o = ++u;
        System.out.println(u);                          // -98
        System.out.println(o);                          // -98

        // Post-decrement
        int num1 = 2;
        int num2 = num1--;
        System.out.println(num1);                       // 1
        System.out.println(num2);                       // 2

        // Pre-decremnt
        int num3 = 3;
        int num4 = --num3;
        System.out.println(num3);                       // 2
        System.out.println(num4);                       // 2

        int total = 100;
        System.out.println(total++);                    // 100
        System.out.println(total);                      // 101

        int bal = 999;
        System.out.println(++bal);                      // 1000

        double d3 = 99.99;
        System.out.println(++d3);                       // 100.99

        char ch = 'a';
        System.out.println(++ch);                       // b

        // Increment and decrement operators can't be used on String and boolean data-types
//        boolean bool = true;
//        System.out.println(++bool);                     // CTE: java: bad operand type boolean for unary operator '++'

    }
}
