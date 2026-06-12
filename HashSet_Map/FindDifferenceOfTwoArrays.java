/*
Problem: Find the Difference of Two Arrays
Platform: LeetCode
Approach: HashSet
Time Complexity: O(n + m)
Space Complexity: O(n + m)
*/

import java.util.*;

public class FindDifferenceOfTwoArrays {

    public static List<List<Integer>> findDifference(
            int[] nums1,
            int[] nums2) {

        HashSet<Integer> set1 =
                new HashSet<>();

        HashSet<Integer> set2 =
                new HashSet<>();

        // Store unique elements
        for(int num : nums1) {
            set1.add(num);
        }

        for(int num : nums2) {
            set2.add(num);
        }

        List<Integer> first =
                new ArrayList<>();

        // Elements present in set1 but not in set2
        for(int num : set1) {

            if(!set2.contains(num)) {
                first.add(num);
            }
        }

        List<Integer> second =
                new ArrayList<>();

        // Elements present in set2 but not in set1
        for(int num : set2) {

            if(!set1.contains(num)) {
                second.add(num);
            }
        }

        List<List<Integer>> answer =
                new ArrayList<>();

        answer.add(first);
        answer.add(second);

        return answer;
    }

    public static void main(String[] args) {

        int[] nums1 = {1,2,3};
        int[] nums2 = {2,4,6};

        List<List<Integer>> result =
                findDifference(nums1, nums2);

        System.out.println(
                "Difference Arrays: "
                + result
        );
    }
}