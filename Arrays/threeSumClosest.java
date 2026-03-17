/*
Problem: 3Sum Closest
Approach: Sorting + Two Pointers
Time Complexity: O(n^2)
Space Complexity: O(1)
*/

import java.util.Arrays;

public class threeSumClosest {

    public static int sumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        int n = nums.length;

        for(int i = 0; i < n - 2; i++) {

            int left = i + 1;
            int right = n - 1;

            while(left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if(Math.abs(target - sum) < Math.abs(target - closest)) {
                    closest = sum;
                }

                if(sum < target) {
                    left++;
                }
                else if(sum > target) {
                    right--;
                }
                else {
                    return sum;
                }
            }
        }

        return closest;
    }

    public static void main(String[] args) {

        int[] nums = {-1, 2, 1, -4};
        int target = 1;

        int result = sumClosest(nums, target);

        System.out.println("Closest Sum: " + result);
    }
}