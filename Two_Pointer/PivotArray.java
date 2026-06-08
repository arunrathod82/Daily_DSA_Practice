/*
Problem: Partition Array According to Given Pivot
Platform: LeetCode
Approach: Two Pass / Three Sections
Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.*;

public class PivotArray {

    public static int[] pivotArray(int[] nums, int pivot) {

        int[] result = new int[nums.length];

        int left = 0;
        int right = nums.length - 1;

        // Place smaller elements on left
        // Place greater elements on right
        for(int i = 0, j = nums.length - 1;
            i < nums.length;
            i++, j--) {

            if(nums[i] < pivot) {

                result[left] = nums[i];
                left++;
            }

            if(nums[j] > pivot) {

                result[right] = nums[j];
                right--;
            }
        }

        // Fill remaining positions with pivot
        while(left <= right) {

            result[left] = pivot;
            left++;
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {9,12,5,10,14,3,10};
        int pivot = 10;

        int[] result = pivotArray(nums, pivot);

        System.out.println(
                "Pivot Array: "
                + Arrays.toString(result)
        );
    }
}