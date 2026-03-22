/*
Problem: Single Number II
Approach: Bit Manipulation
Time Complexity: O(n)
Space Complexity: O(1)
*/

import java.util.*;
class SingleNumberII {
    public static int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = (ones ^ num) & (~twos);
            twos = (twos ^ num) & (~ones);
        }
        return ones;
    }

    public static void main(String[] args){
        int[] nums = {2,2,3,2};
        int result = singleNumber(nums);
        System.out.println("Single Number II:" + result);
    }
}