// Problem: Interleaving String
// Platform: LeetCode
// Approach: Dynamic Programming
// Time Complexity: O(m * n)
// Space Complexity: O(m * n)

public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {

        int m = s1.length();
        int n = s2.length();

        // Lengths must match
        if (m + n != s3.length()) {
            return false;
        }

        boolean[][] dp = new boolean[m + 1][n + 1];

        // Empty strings can form an empty string
        dp[0][0] = true;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                // Take the next character from s1
                if (i > 0 &&
                    s1.charAt(i - 1) == s3.charAt(i + j - 1)) {

                    dp[i][j] = dp[i][j] || dp[i - 1][j];
                }

                // Take the next character from s2
                if (j > 0 &&
                    s2.charAt(j - 1) == s3.charAt(i + j - 1)) {

                    dp[i][j] = dp[i][j] || dp[i][j - 1];
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {

        InterleavingString obj = new InterleavingString();

        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";

        System.out.println(
            "Is Interleaving: " + obj.isInterleave(s1, s2, s3)
        );
    }
}