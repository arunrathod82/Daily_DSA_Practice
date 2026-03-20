/*
Problem: Single Number
Approach: XOR
Time Complexity: O(n)
Space Complexity: O(1)
*/

import java.util.*;

public class SingleNumber {

    public static int singleNumber(int[] nums) {

        int xor = 0;

        for(int num : nums){
            xor ^= num;
        }

        return xor;
    }

    public static void main(String[] args) {

        int[] nums = {4, 1, 2, 1, 2};

        int result = singleNumber(nums);

        System.out.println("Single Number: " + result);
    }
}