/*
Problem: Squares of a Sorted Array
Platform: LeetCode
Approach: Two Pointers
Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.Arrays;

public class SortedSquares {

    public static int[] sortedSquares(int[] nums) {

        int[] result = new int[nums.length];

        int left = 0;
        int right = nums.length - 1;
        int index = nums.length - 1;

        while(left <= right) {

            int leftSqr = nums[left] * nums[left];
            int rightSqr = nums[right] * nums[right];

            if(leftSqr < rightSqr) {
                result[index] = rightSqr;
                right--;
            }
            else {
                result[index] = leftSqr;
                left++;
            }

            index--;
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {-4, -1, 0, 3, 10};

        int[] result = sortedSquares(nums);

        System.out.println("Sorted Squares: " + Arrays.toString(result));
    }
}