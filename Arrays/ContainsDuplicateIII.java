/*
Problem: Contains Duplicate III
Platform: LeetCode
Approach: Sliding Window + TreeSet
Time Complexity: O(n log k)
Space Complexity: O(k)
*/

import java.util.*;

public class ContainsDuplicateIII {

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {

        if(indexDiff <= 0 || valueDiff < 0){
            return false;
        }

        TreeSet<Long> set = new TreeSet<>();

        for(int i = 0; i < nums.length; i++){

            long curr = nums[i];

            Long cand = set.ceiling(curr - valueDiff);

            if(cand != null && cand <= curr + valueDiff){
                return true;
            }

            set.add(curr);

            if(i >= indexDiff){
                set.remove((long) nums[i - indexDiff]);
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1};
        int indexDiff = 3;
        int valueDiff = 0;

        boolean result = containsNearbyAlmostDuplicate(nums, indexDiff, valueDiff);

        System.out.println("Contains Nearby Almost Duplicate: " + result);
    }
}