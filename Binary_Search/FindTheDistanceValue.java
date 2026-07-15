package Binary_Search;

/*
Problem: Find the Distance Value Between Two Arrays
Platform: LeetCode
Approach: Sorting + Binary Search
Time Complexity: O(n log m + m log m)

n = arr1.length
m = arr2.length

Space Complexity: O(1)
*/

import java.util.*;

public class FindTheDistanceValue {

    public static int findTheDistanceValue(
            int[] arr1,
            int[] arr2,
            int d) {

        // Sort second array
        Arrays.sort(arr2);

        int count = 0;

        for(int target : arr1) {

            int low = 0;
            int high = arr2.length - 1;

            // Binary Search:
            // Find first element >= target
            while(low <= high) {

                int mid =
                        low + (high - low) / 2;

                if(arr2[mid] < target) {

                    low = mid + 1;
                }

                else {

                    high = mid - 1;
                }
            }

            boolean valid = true;

            // Check insertion position
            if(low < arr2.length &&
               Math.abs(arr2[low] - target) <= d) {

                valid = false;
            }

            // Check previous element
            if(low > 0 &&
               Math.abs(arr2[low - 1] - target) <= d) {

                valid = false;
            }

            if(valid) {

                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[] arr1 = {4,5,8};

        int[] arr2 = {10,9,1,8};

        int d = 2;

        int result =
                findTheDistanceValue(
                        arr1,
                        arr2,
                        d
                );

        System.out.println(
                "Distance Value: "
                + result
        );
    }
}
