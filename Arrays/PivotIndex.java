/*
Problem: Find Pivot Index
Approach: Prefix Sum
Time Complexity: O(n)
Space Complexity: O(1)
*/

import java.util.*;

public class PivotIndex {

    public static int pivotIndex(int[] nums) {

        int totalSum = 0;

        for(int num : nums){
            totalSum = totalSum + num;
        }

        int leftSum = 0;

        for(int i = 0; i < nums.length; i++){

            int rightSum = totalSum - leftSum - nums[i];

            if(leftSum == rightSum){
                return i;
            }

            leftSum = leftSum + nums[i];
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {1,7,3,6,5,6};

        int result = pivotIndex(nums);

        System.out.println("Pivot Index: " + result);
    }
}