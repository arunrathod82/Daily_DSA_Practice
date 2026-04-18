/*
Problem: Contiguous Array
Platform: LeetCode
Approach: Prefix Sum + HashMap
Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.*;

public class ContiguousArray {

    public static int findMaxLength(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0;
        int maxLength = 0;

        for(int i = 0; i < nums.length; i++) {

            if(nums[i] == 0) {
                sum -= 1;
            }
            else {
                sum += 1;
            }

            if(map.containsKey(sum)) {
                int length = i - map.get(sum);
                maxLength = Math.max(length, maxLength);
            }
            else {
                map.put(sum, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {

        int[] nums = {0, 1, 0};

        int result = findMaxLength(nums);

        System.out.println("Maximum Length: " + result);
    }
}