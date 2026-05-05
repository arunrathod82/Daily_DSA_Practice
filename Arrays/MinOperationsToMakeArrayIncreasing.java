/*
Problem: Minimum Operations to Make the Array Increasing
Platform: LeetCode
Approach: Greedy
Time Complexity: O(n)
Space Complexity: O(1)
*/

import java.util.*;

public class MinOperationsToMakeArrayIncreasing {

    public static int minOperations(int[] nums) {

        int operations = 0;

        for(int i = 1; i < nums.length; i++) {

            int newVal = Math.max(nums[i - 1] + 1, nums[i]);

            operations += (newVal - nums[i]);

            nums[i] = newVal;
        }

        return operations;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1};

        int result = minOperations(nums);

        System.out.println("Minimum Operations: " + result);
        System.out.println("Modified Array: " + Arrays.toString(nums));
    }
}