/*
Problem: Two Sum
Approach: Using distance between indices (j - i)
Time Complexity: O(n^2)
Space Complexity: O(1)
*/

import java.util.*;

public class TwoSum{

    public static int[] twoSum(int[] nums, int target) {

        for(int i = 1; i < nums.length; i++) {

            for(int j = i; j < nums.length; j++) {

                if((nums[j - i] + nums[j]) == target) {
                    return new int[]{j - i, j};
                }

            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);

        System.out.println("Indexes: " + result[0] + " " + result[1]);
    }
}