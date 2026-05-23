/*
Problem: Check if Array Is Sorted and Rotated
Platform: LeetCode
Approach: Count break points
Time Complexity: O(n)
Space Complexity: O(1)
*/

import java.util.*;

public class CheckSortedAndRotated {

    public static boolean check(int[] nums) {

        int n = nums.length;
        int count = 0;

        for(int i = 0; i < n; i++) {

            if(nums[i] > nums[(i + 1) % n]) {
                count++;
            }
        }

        return count <= 1;
    }

    public static void main(String[] args) {

        int[] nums = {3,4,5,1,2};

        boolean result = check(nums);

        System.out.println("Is Sorted and Rotated: " + result);
    }
}