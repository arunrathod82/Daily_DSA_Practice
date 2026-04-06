/*
Problem: Maximum Average Subarray I
Platform: LeetCode
Approach: Sliding Window
Time Complexity: O(n)
Space Complexity: O(1)
*/

import java.util.*;

public class MaximumAverageSubarray {

    public static double findMaxAverage(int[] nums, int k) {

        int windowSum = 0;

        for(int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        int maxSum = windowSum;

        for(int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return (double) maxSum / k;
    }

    public static void main(String[] args) {

        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;

        double result = findMaxAverage(nums, k);

        System.out.println("Maximum Average: " + result);
    }
}