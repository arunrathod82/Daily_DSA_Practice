// Problem: Unique Paths II
// Platform: LeetCode
// Approach: Dynamic Programming
// Time Complexity: O(m * n)
// Space Complexity: O(m * n)

public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        // If starting cell has an obstacle, no path exists
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        // Starting position
        dp[0][0] = 1;

        // Fill the first column
        for (int i = 1; i < m; i++) {

            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = dp[i - 1][0];
            }
        }

        // Fill the first row
        for (int j = 1; j < n; j++) {

            if (obstacleGrid[0][j] == 1) {
                dp[0][j] = 0;
            } else {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // Fill the remaining cells
        for (int i = 1; i < m; i++) {

            for (int j = 1; j < n; j++) {

                // Cannot pass through an obstacle
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {

                    // Paths from top + paths from left
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {

        UniquePathsII obj = new UniquePathsII();

        int[][] obstacleGrid = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };

        System.out.println(
            "Number of unique paths: "
            + obj.uniquePathsWithObstacles(obstacleGrid)
        );
    }
}