/*
Problem: Sum and Multiply
Approach: Math
Time Complexity: O(d)
Space Complexity: O(1)

d = number of digits
*/

import java.util.*;

public class SumAndMultiply {

    public static long sumAndMultiply(int n) {

        int original = n;

        int reversed = 0;
        int sum = 0;

        while(n > 0) {

            int digit = n % 10;

            // Ignore zero digits
            if(digit != 0) {

                reversed =
                        reversed * 10 + digit;

                sum += digit;
            }

            n /= 10;
        }

        // Reverse again to restore order
        int number = 0;

        while(reversed > 0) {

            int digit = reversed % 10;

            number =
                    number * 10 + digit;

            reversed /= 10;
        }

        return (long) number * sum;
    }

    public static void main(String[] args) {

        int n = 1023;

        long result =
                sumAndMultiply(n);

        System.out.println(
                "Result: "
                + result
        );
    }
}