/*
Problem: Move Zeroes
Platform: LeetCode
Approach: Two Pointers
Time Complexity: O(n)
Space Complexity: O(1)
*/

import java.util.Arrays;

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {

        int left = 0;

        for(int i = 0; i < nums.length; i++) {

            if(nums[i] != 0) {

                int temp = nums[left];
                nums[left] = nums[i];
                nums[i] = temp;

                left++;
            }
        }
    }

    public static void main(String[] args) {

        int[] nums = {0, 1, 0, 3, 12};

        moveZeroes(nums);

        System.out.println("After Moving Zeroes: " + Arrays.toString(nums));
    }
}