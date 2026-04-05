/*
Problem: Third Maximum Number
Platform: LeetCode
Approach: Track Top 3 Distinct Maximums
Time Complexity: O(n)
Space Complexity: O(1)
*/

import java.util.*;

public class ThirdMaximumNumber {

    public static int thirdMax(int[] nums) {

        Long max1 = null;
        Long max2 = null;
        Long max3 = null;

        for(int num : nums) {

            if((max1 != null && num == max1) ||
               (max2 != null && num == max2) ||
               (max3 != null && num == max3)) {
                continue;
            }

            if(max1 == null || num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = (long) num;
            }

            else if(max2 == null || num > max2) {
                max3 = max2;
                max2 = (long) num;
            }

            else if(max3 == null || num > max3) {
                max3 = (long) num;
            }
        }

        if(max3 == null) {
            return max1.intValue();
        }

        return max3.intValue();
    }

    public static void main(String[] args) {

        int[] nums = {2, 2, 3, 1};

        int result = thirdMax(nums);

        System.out.println("Third Maximum Number: " + result);
    }
}