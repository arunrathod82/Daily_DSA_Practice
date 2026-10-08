import java.util.*;

// Problem: Perfect Squares
// Platform: LeetCode
// Approach: Dynamic Programming
// Time Complexity: O(n * sqrt(n))
// Space Complexity: O(n)

public class PerfectSquares {

    public int numSquares(int n) {

        int[] dp = new int[n + 1];

        // Initialize with a value larger than any possible answer
        Arrays.fill(dp, n + 1);

        // 0 requires 0 perfect squares
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {

            // Try every perfect square <= i
            for (int j = 1; j * j <= i; j++) {

                // Minimum number of perfect squares needed
                // to make the value i
                dp[i] = Math.min(
                    dp[i],
                    dp[i - j * j] + 1
                );
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {

        PerfectSquares obj = new PerfectSquares();

        int n = 12;

        System.out.println(
            "Minimum number of perfect squares: "
            + obj.numSquares(n)
        );
    }
}