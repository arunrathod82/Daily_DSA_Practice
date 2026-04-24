/*
Problem: Maximum Product Subarray
Platform: LeetCode
Approach: Track max and min product (handles negatives)
Time Complexity: O(n)
Space Complexity: O(1)
*/

import java.util.*;

public class MaximumProductSubarray {

    public static int maxProduct(int[] nums) {

        int maxProd = nums[0];
        int minProd = nums[0];
        int result = nums[0];

        for(int i = 1; i < nums.length; i++) {

            int tempMax = Math.max(nums[i],
                            Math.max(nums[i] * maxProd, nums[i] * minProd));

            minProd = Math.min(nums[i],
                        Math.min(nums[i] * maxProd, nums[i] * minProd));

            maxProd = tempMax;

            result = Math.max(result, maxProd);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, -2, 4};

        int result = maxProduct(nums);

        System.out.println("Maximum Product Subarray: " + result);
    }
}