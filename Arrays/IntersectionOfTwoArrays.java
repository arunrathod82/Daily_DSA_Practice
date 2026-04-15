/*
Problem: Intersection of Two Arrays
Platform: LeetCode
Approach: HashSet
Time Complexity: O(n + m)
Space Complexity: O(n + m)
*/

import java.util.*;

public class IntersectionOfTwoArrays {

    public static int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for(int num : nums1) {
            set1.add(num);
        }

        for(int num : nums2) {
            if(set1.contains(num)) {
                set2.add(num);
            }
        }

        int[] res = new int[set2.size()];
        int index = 0;

        for(int num : set2) {
            res[index++] = num;
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        int[] result = intersection(nums1, nums2);

        System.out.println("Intersection: " + Arrays.toString(result));
    }
}