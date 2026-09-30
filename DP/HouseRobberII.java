// Problem: House Robber II
// Platform: LeetCode
// Approach: Dynamic Programming
// Time Complexity: O(n)
// Space Complexity: O(1)

public class HouseRobberII {

    public int rob(int[] nums) {

        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        // Case 1: Rob houses from 0 to n-2
        // Case 2: Rob houses from 1 to n-1
        int case1 = linearRob(nums, 0, n - 2);
        int case2 = linearRob(nums, 1, n - 1);

        return Math.max(case1, case2);
    }

    // Solves the normal House Robber problem for a given range
    private int linearRob(int[] nums, int start, int end) {

        int prev1 = 0;
        int prev2 = 0;

        for (int i = start; i <= end; i++) {

            // Take current house
            int take = nums[i] + prev2;

            // Skip current house
            int skip = prev1;

            int curr = Math.max(take, skip);

            // Move values forward
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public static void main(String[] args) {

        HouseRobberII obj = new HouseRobberII();

        int[] nums = {2, 3, 2};

        System.out.println("Maximum money: " + obj.rob(nums));
    }
}