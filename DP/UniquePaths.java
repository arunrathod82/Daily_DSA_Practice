// Problem: Unique Paths
// Platform: LeetCode
// Approach: Dynamic Programming
// Time Complexity: O(m * n)
// Space Complexity: O(m * n)

public class UniquePaths {

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];

        // First column: only one way to reach each cell
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        // First row: only one way to reach each cell
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // Each cell can be reached from top or left
        for (int i = 1; i < m; i++) {

            for (int j = 1; j < n; j++) {

                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {

        UniquePaths obj = new UniquePaths();

        int m = 3;
        int n = 7;

        System.out.println("Number of unique paths: " + obj.uniquePaths(m, n));
    }
}