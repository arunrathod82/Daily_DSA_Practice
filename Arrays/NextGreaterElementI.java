/*
Problem: Next Greater Element I
Platform: LeetCode
Approach: Monotonic Stack + HashMap
Time Complexity: O(n + m)
Space Complexity: O(n)
*/

import java.util.*;

public class NextGreaterElementI {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Deque<Integer> stack = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums2.length; i++) {

            while(!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {

                int popIndex = stack.pop();
                map.put(nums2[popIndex], nums2[i]);
            }

            stack.push(i);
        }

        while(!stack.isEmpty()) {
            map.put(nums2[stack.pop()], -1);
        }

        int[] result = new int[nums1.length];

        for(int j = 0; j < nums1.length; j++) {
            result[j] = map.get(nums1[j]);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};

        int[] result = nextGreaterElement(nums1, nums2);

        System.out.println("Next Greater Elements: " + Arrays.toString(result));
    }
}