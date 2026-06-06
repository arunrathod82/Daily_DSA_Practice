/*
Problem: Left and Right Sum Differences
Platform: LeetCode
Approach: Prefix Sum
Time Complexity: O(n)
Space Complexity: O(1) excluding output array
*/

import java.util.*;

public class LeftRightDifference {

    public static int[] leftRightDifference(int[] nums) {

        int[] result = new int[nums.length];

        int totalSum = 0;

        // Calculate total sum
        for(int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        int leftSum = 0;

        for(int i = 0; i < nums.length; i++) {

            // Right sum
            totalSum -= nums[i];

            int rightSum = totalSum;

            // Absolute difference
            result[i] =
                    Math.abs(leftSum - rightSum);

            // Update left sum
            leftSum += nums[i];
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {10, 4, 8, 3};

        int[] result =
                leftRightDifference(nums);

        System.out.println(
                "Left Right Difference: "
                + Arrays.toString(result)
        );
    }
}