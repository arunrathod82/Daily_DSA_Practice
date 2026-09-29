// Problem: Delete and Earn
// Platform: LeetCode
// Approach: Dynamic Programming
// Time Complexity: O(n + maxNum)
// Space Complexity: O(maxNum)

public class DeleteAndEarn {

    public int deleteAndEarn(int[] nums) {

        int maxNum = 0;

        // Find the maximum number
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }

        // points[i] stores the total points earned
        // by choosing every occurrence of number i
        int[] points = new int[maxNum + 1];

        for (int num : nums) {
            points[num] += num;
        }

        // DP array: maximum points up to number i
        int[] dp = new int[maxNum + 1];

        if (maxNum >= 1) {
            dp[1] = points[1];
        }

        for (int i = 2; i <= maxNum; i++) {

            // Either skip i, or earn its points
            // and skip the adjacent number i - 1
            dp[i] = Math.max(
                dp[i - 1],
                points[i] + dp[i - 2]
            );
        }

        return dp[maxNum];
    }

    public static void main(String[] args) {

        DeleteAndEarn obj = new DeleteAndEarn();

        int[] nums = {3, 4, 2};

        System.out.println(
            "Maximum points: " + obj.deleteAndEarn(nums)
        );
    }
}