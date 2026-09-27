// Problem: House Robber
// Platform: LeetCode
// Approach: Dynamic Programming
// Time Complexity: O(n)
// Space Complexity: O(n)

public class HouseRobber {

    public int rob(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];

        // Maximum money when considering the first house
        dp[0] = nums[0];

        // Choose the maximum of robbing or skipping house 2
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {

            // Either skip the current house,
            // or rob it and add money from two houses back
            dp[i] = Math.max(
                dp[i - 1],
                nums[i] + dp[i - 2]
            );
        }

        // Maximum money considering all houses
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {

        HouseRobber obj = new HouseRobber();

        int[] nums = {2, 7, 9, 3, 1};

        System.out.println("Maximum money: " + obj.rob(nums));
    }
}