/*
Problem: Maximum Subarray
Platform: LeetCode
Approach: Kadane’s Algorithm
Time Complexity: O(n)
Space Complexity: O(1)
*/

import java.util.*;

public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {

        int currSum = nums[0];
        int max = nums[0];

        for(int i = 1; i < nums.length; i++) {

            currSum = Math.max(nums[i], currSum + nums[i]);
            max = Math.max(currSum, max);
        }

        return max;
    }

    public static void main(String[] args) {

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int result = maxSubArray(nums);

        System.out.println("Maximum Subarray Sum: " + result);
    }
}