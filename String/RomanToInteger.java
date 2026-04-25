/*
Problem: Roman to Integer
Platform: LeetCode
Approach: Traverse from right to left
Time Complexity: O(n)
Space Complexity: O(1)
*/

import java.util.*;

public class RomanToInteger {

    public static int romanToInt(String s) {

        int total = 0;
        int prev = 0;

        for(int i = s.length() - 1; i >= 0; i--) {

            int curr = value(s.charAt(i));

            if(curr < prev) {
                total -= curr;
            }
            else {
                total += curr;
            }

            prev = curr;
        }

        return total;
    }

    public static int value(char c) {

        switch(c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public static void main(String[] args) {

        String s = "MCMXCIV";

        int result = romanToInt(s);

        System.out.println("Integer Value: " + result);
    }
}