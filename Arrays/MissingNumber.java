/*
Problem: Missing Number
Platform: LeetCode
Approach: XOR
Time Complexity: O(n)
Space Complexity: O(1)
*/

import java.util.*;

public class MissingNumber {

    public static int missingNumber(int[] nums) {

        int xor = nums.length;

        for(int i = 0; i < nums.length; i++) {
            xor ^= i ^ nums[i];
        }

        return xor;
    }

    public static void main(String[] args) {

        int[] nums = {3, 0, 1};

        int result = missingNumber(nums);

        System.out.println("Missing Number: " + result);
    }
}