/*
Problem: Summary Ranges
Platform: LeetCode
Approach: Traverse and track range boundaries
Time Complexity: O(n)
Space Complexity: O(1) excluding output list
*/

import java.util.*;

public class SummaryRanges {

    public static List<String> summaryRanges(int[] nums) {

        List<String> res = new ArrayList<>();

        if(nums.length == 0) {
            return res;
        }

        int start = nums[0];

        for(int i = 1; i <= nums.length; i++) {

            if(i == nums.length || nums[i] != nums[i - 1] + 1) {

                int end = nums[i - 1];

                if(start == end) {
                    res.add(String.valueOf(start));
                }
                else {
                    res.add(start + "->" + end);
                }

                if(i < nums.length) {
                    start = nums[i];
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = {0, 1, 2, 4, 5, 7};

        List<String> result = summaryRanges(nums);

        System.out.println("Summary Ranges: " + result);
    }
}