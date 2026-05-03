/*
Problem: Longest Consecutive Sequence
Platform: LeetCode
Approach: HashSet
Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.*;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for(int num : nums) {
            set.add(num);
        }

        int max = 0;

        for(int num : set) {

            // start only from the beginning of a sequence
            if(!set.contains(num - 1)) {

                int curr = num;
                int count = 1;

                while(set.contains(curr + 1)) {
                    curr++;
                    count++;
                }

                max = Math.max(max, count);
            }
        }

        return max;
    }

    public static void main(String[] args) {

        int[] nums = {100, 4, 200, 1, 3, 2};

        int result = longestConsecutive(nums);

        System.out.println("Longest Consecutive Length: " + result);
    }
}