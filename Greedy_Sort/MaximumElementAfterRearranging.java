/*
Problem: Maximum Element After Decreasing and Rearranging
Platform: LeetCode
Approach: Sorting + Greedy
Time Complexity: O(n log n)
Space Complexity: O(1)
*/

import java.util.*;

public class MaximumElementAfterRearranging {

    public static int maximumElementAfterDecrementingAndRearranging(
            int[] arr) {

        // Sort array
        Arrays.sort(arr);

        // First element must be 1
        arr[0] = 1;

        // Maintain adjacent difference <= 1
        for(int i = 1; i < arr.length; i++) {

            arr[i] = Math.min(
                    arr[i],
                    arr[i - 1] + 1
            );
        }

        return arr[arr.length - 1];
    }

    public static void main(String[] args) {

        int[] arr = {2,2,1,2,1};

        int result =
                maximumElementAfterDecrementingAndRearranging(arr);

        System.out.println(
                "Maximum Element: "
                + result
        );
    }
}