/*
Problem: Next Greater Element II
Platform: LeetCode
Approach: Monotonic Stack + Circular Array
Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.*;

public class NextGreaterElementII {

    public static int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];

        Arrays.fill(result, -1);

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < 2 * n; i++) {

            int currentIndex = i % n;

            while(!stack.isEmpty() && nums[currentIndex] > nums[stack.peek()]) {

                int poppedIndex = stack.pop();
                result[poppedIndex] = nums[currentIndex];
            }

            if(i < n) {
                stack.push(currentIndex);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 1};

        int[] result = nextGreaterElements(nums);

        System.out.println("Next Greater Elements: " + Arrays.toString(result));
    }
}