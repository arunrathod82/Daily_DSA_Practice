/*
Problem: Top K Frequent Elements
Platform: LeetCode
Approach: Bucket Sort
Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.*;

public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        for(int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        for(int key : freq.keySet()) {
            int f = freq.get(key);
            bucket[f].add(key);
        }

        int[] result = new int[k];
        int idx = 0;

        for(int i = bucket.length - 1; i >= 0 && idx < k; i--) {

            for(int num : bucket[i]) {
                result[idx++] = num;
                if(idx == k) break;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        int[] result = topKFrequent(nums, k);

        System.out.println("Top K Frequent Elements: " + Arrays.toString(result));
    }
}