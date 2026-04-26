/*
Problem: Degree of an Array
Platform: LeetCode
Approach: HashMap for frequency, first index, and last index
Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.*;

public class DegreeOfAnArray {

    public static int findShortestSubArray(int[] nums) {

        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Integer> first = new HashMap<>();
        HashMap<Integer, Integer> last = new HashMap<>();

        int degree = 0;

        for(int i = 0; i < nums.length; i++) {

            if(!first.containsKey(nums[i])) {
                first.put(nums[i], i);
            }

            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            last.put(nums[i], i);

            degree = Math.max(degree, freq.get(nums[i]));
        }

        int answer = nums.length;

        for(int num : freq.keySet()) {

            if(freq.get(num) == degree) {

                int length = last.get(num) - first.get(num) + 1;
                answer = Math.min(answer, length);
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 2, 3, 1, 4, 2};

        int result = findShortestSubArray(nums);

        System.out.println("Shortest Subarray Length: " + result);
    }
}