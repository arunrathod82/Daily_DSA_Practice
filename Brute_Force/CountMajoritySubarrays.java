/*
Problem: Count Subarrays Where Target is Majority
Approach: Brute Force
Time Complexity: O(n²)
Space Complexity: O(1)
*/

import java.util.*;

public class CountMajoritySubarrays {

    // Method name must remain same
    public static int countMajoritySubarrays(
            int[] nums,
            int target) {

        int n = nums.length;

        int count = 0;

        // Generate all subarrays
        for(int i = 0; i < n; i++) {

            int targetFreq = 0;

            for(int j = i; j < n; j++) {

                // Count target frequency
                if(nums[j] == target) {

                    targetFreq++;
                }

                // Majority condition
                if(targetFreq * 2 >
                   (j - i + 1)) {

                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {1,1,1,1};

        int target = 1;

        int result =
                countMajoritySubarrays(
                        nums,
                        target
                );

        System.out.println(
                "Majority Subarrays Count: "
                + result
        );
    }
}