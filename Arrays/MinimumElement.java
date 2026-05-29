/*
Problem: Minimum Element After Replacement With Digit Sum
Platform: LeetCode
Approach: Digit Sum
Time Complexity: O(n * d)
Space Complexity: O(1)

where d = number of digits
*/

import java.util.*;

public class MinimumElement {

    public static int minElement(int[] nums) {

        int min = Integer.MAX_VALUE;

        for(int num : nums) {

            int sum = 0;

            while(num > 0) {

                int digit = num % 10;
                sum += digit;
                num /= 10;
            }

            min = Math.min(min, sum);
        }

        return min;
    }

    public static void main(String[] args) {

        int[] nums = {10, 12, 13, 14};

        int result = minElement(nums);

        System.out.println("Minimum Element After Digit Sum: " + result);
    }
}