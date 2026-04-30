/*
Problem: First Missing Positive
Platform: LeetCode
Approach: Cyclic Sort (Place each number at correct index)
Time Complexity: O(n)
Space Complexity: O(1)
*/

import java.util.*;

public class FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {

        for(int i = 0; i < nums.length; i++) {

            while(nums[i] > 0 &&
                  nums[i] <= nums.length &&
                  nums[nums[i] - 1] != nums[i]) {

                int index = nums[i] - 1;

                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
            }
        }

        for(int i = 0; i < nums.length; i++) {

            if(nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }

    public static void main(String[] args) {

        int[] nums = {3, 4, -1, 1};

        int result = firstMissingPositive(nums);

        System.out.println("First Missing Positive: " + result);
    }
}