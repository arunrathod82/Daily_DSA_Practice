// Problem: Minimum Falling Path Sum
// Platform: LeetCode
// Approach: Dynamic Programming
// Time Complexity: O(n^2)
// Space Complexity: O(n^2)

public class MinimumFallingPathSum {

    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;

        int[][] dp = new int[n][n];

        // Copy the first row
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

        // Calculate minimum falling path sum for each cell
        for (int i = 1; i < n; i++) {

            for (int j = 0; j < n; j++) {

                // First column: can come from above or upper-right
                if (j == 0) {

                    dp[i][j] = matrix[i][j]
                            + Math.min(dp[i - 1][j],
                                       dp[i - 1][j + 1]);
                }

                // Last column: can come from upper-left or above
                else if (j == n - 1) {

                    dp[i][j] = matrix[i][j]
                            + Math.min(dp[i - 1][j - 1],
                                       dp[i - 1][j]);
                }

                // Middle columns: three possible previous positions
                else {

                    dp[i][j] = matrix[i][j]
                            + Math.min(
                                dp[i - 1][j - 1],
                                Math.min(
                                    dp[i - 1][j],
                                    dp[i - 1][j + 1]
                                )
                            );
                }
            }
        }

        // Find the minimum value in the last row
        int ans = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, dp[n - 1][j]);
        }

        return ans;
    }

    public static void main(String[] args) {

        MinimumFallingPathSum obj = new MinimumFallingPathSum();

        int[][] matrix = {
            {2, 1, 3},
            {6, 5, 4},
            {7, 8, 9}
        };

        System.out.println(
            "Minimum Falling Path Sum: "
            + obj.minFallingPathSum(matrix)
        );
    }
}