/*
Problem: Find the Duplicate Number
Platform: LeetCode
Approach: Floyd's Cycle Detection (Tortoise and Hare)
Time Complexity: O(n)
Space Complexity: O(1)
*/

import java.util.*;

public class FindDuplicate {

    public static int findDuplicate(int[] nums) {

        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);

        slow = nums[0];

        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {

        int[] nums = {1, 3, 4, 2, 2};

        int result = findDuplicate(nums);

        System.out.println("Duplicate Number: " + result);
    }
}