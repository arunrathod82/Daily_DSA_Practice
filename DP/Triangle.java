import java.util.*;

// Problem: Triangle
// Platform: LeetCode
// Approach: Dynamic Programming
// Time Complexity: O(n^2)
// Space Complexity: O(n^2)

public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();

        int[][] dp = new int[n][n];

        // Starting value
        dp[0][0] = triangle.get(0).get(0);

        // Build minimum path sums row by row
        for (int i = 1; i < n; i++) {

            for (int j = 0; j <= i; j++) {

                // First element can only come from above
                if (j == 0) {
                    dp[i][j] = triangle.get(i).get(j)
                            + dp[i - 1][j];
                }

                // Last element can only come from upper-left
                else if (j == i) {
                    dp[i][j] = triangle.get(i).get(j)
                            + dp[i - 1][j - 1];
                }

                // Middle elements can come from above or upper-left
                else {
                    dp[i][j] = triangle.get(i).get(j)
                            + Math.min(
                                dp[i - 1][j],
                                dp[i - 1][j - 1]
                            );
                }
            }
        }

        // Find minimum path sum in the last row
        int ans = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, dp[n - 1][j]);
        }

        return ans;
    }

    public static void main(String[] args) {

        Triangle obj = new Triangle();

        List<List<Integer>> triangle = Arrays.asList(
            Arrays.asList(2),
            Arrays.asList(3, 4),
            Arrays.asList(6, 5, 7),
            Arrays.asList(4, 1, 8, 3)
        );

        System.out.println(
            "Minimum Path Sum: " + obj.minimumTotal(triangle)
        );
    }
}