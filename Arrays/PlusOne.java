/*
Problem: Plus One
Platform: LeetCode
Approach: Simulate addition from the last digit
Time Complexity: O(n)
Space Complexity: O(1) (or O(n) when creating new array)
*/

import java.util.Arrays;

public class PlusOne {

    public static int[] plusOne(int[] digits) {

        for(int i = digits.length - 1; i >= 0; i--) {

            if(digits[i] < 9) {
                digits[i] = digits[i] + 1;
                return digits;
            }

            digits[i] = 0;
        }

        int[] res = new int[digits.length + 1];
        res[0] = 1;

        return res;
    }

    public static void main(String[] args) {

        int[] digits = {9, 9, 9};

        int[] result = plusOne(digits);

        System.out.println("Result: " + Arrays.toString(result));
    }
}