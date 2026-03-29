/*
Problem: Contains Duplicate II
Platform: LeetCode
Approach: Sliding Window + HashSet
Time Complexity: O(n)
Space Complexity: O(k)
*/

import java.util.*;

public class ContainsDuplicateII {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {

            if(set.contains(nums[i])) {
                return true;
            }

            set.add(nums[i]);

            if(set.size() > k) {
                set.remove(nums[i - k]);
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1};
        int k = 3;

        boolean result = containsNearbyDuplicate(nums, k);

        System.out.println("Contains Nearby Duplicate: " + result);
    }
}