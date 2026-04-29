/*
Problem: Integer to Roman
Platform: LeetCode
Approach: Greedy using value-symbol mapping
Time Complexity: O(1)
Space Complexity: O(1)
*/

import java.util.*;

public class IntegerToRoman {

    public static String intToRoman(int num) {

        int[] values = {
            1000, 900, 500, 400,
            100, 90, 50, 40,
            10, 9, 5, 4, 1
        };

        String[] symbols = {
            "M", "CM", "D", "CD",
            "C", "XC", "L", "XL",
            "X", "IX", "V", "IV", "I"
        };

        StringBuilder result = new StringBuilder();

        for(int i = 0; i < values.length; i++) {

            while(num >= values[i]) {
                num -= values[i];
                result.append(symbols[i]);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        int num = 1994;

        String result = intToRoman(num);

        System.out.println("Roman Numeral: " + result);
    }
}