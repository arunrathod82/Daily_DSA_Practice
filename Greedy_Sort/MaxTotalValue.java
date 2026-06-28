/*
Problem: Maximum Total Value of Array After Operations
Approach: Greedy / Math
Time Complexity: O(n)
Space Complexity: O(1)
*/

import java.util.*;

public class MaxTotalValue {

    public static long maxTotalValue(int[] nums, int k) {

        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;

        // Find minimum and maximum
        for(int num : nums) {

            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // Maximum possible total value
        return (max - min) * k;
    }

    public static void main(String[] args) {

        int[] nums = {1, 3, 6};
        int k = 2;

        long result = maxTotalValue(nums, k);

        System.out.println(
                "Maximum Total Value: "
                + result
        );
    }
}
