/*
Problem: Single Number III
Platform: LeetCode
Approach: Bit Manipulation (XOR)
Time Complexity: O(n)
Space Complexity: O(1)
*/

import java.util.Arrays;

public class SingleNumberIII {

    public static int[] singleNumber(int[] nums) {

        int xor = 0;

        for(int num : nums){
            xor ^= num;
        }

        int diff = xor & (-xor);

        int num1 = 0;
        int num2 = 0;

        for(int num : nums){
            if((num & diff) == 0){
                num1 ^= num;
            }
            else{
                num2 ^= num;
            }
        }

        return new int[]{num1, num2};
    }

    public static void main(String[] args) {

        int[] nums = {1,2,1,3,2,5};

        int[] result = singleNumber(nums);

        System.out.println("Unique Numbers: " + Arrays.toString(result));
    }
}