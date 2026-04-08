/*
Problem: How Many Numbers Are Smaller Than the Current Number
Platform: LeetCode
Approach: Counting Sort / Frequency Array
Time Complexity: O(n + 100)
Space Complexity: O(100)
*/

import java.util.Arrays;

public class SmallerNumbersThanCurrent {

    public static int[] smallerNumbersThanCurrent(int[] nums) {

        int[] count = new int[101];

        for(int num : nums) {
            count[num]++;
        }

        for(int i = 1; i < 101; i++) {
            count[i] = count[i] + count[i - 1];
        }

        int[] res = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {

            if(nums[i] == 0) {
                res[i] = 0;
            }
            else {
                res[i] = count[nums[i] - 1];
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = {8, 1, 2, 2, 3};

        int[] result = smallerNumbersThanCurrent(nums);

        System.out.println("Result: " + Arrays.toString(result));
    }
}