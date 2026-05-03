/*
Problem: Kth Largest Element in an Array
Platform: LeetCode
Approach: Min Heap (PriorityQueue)
Time Complexity: O(n log k)
Space Complexity: O(k)
*/

import java.util.*;

public class KthLargestElement {

    public static int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num : nums) {

            pq.add(num);

            if(pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }

    public static void main(String[] args) {

        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        int result = findKthLargest(nums, k);

        System.out.println("Kth Largest Element: " + result);
    }
}