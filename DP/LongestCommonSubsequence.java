// Problem: Longest Common Subsequence
// Platform: LeetCode
// Approach: Dynamic Programming
// Time Complexity: O(m * n)
// Space Complexity: O(m * n)

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                // If characters match, extend the LCS
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // Take the maximum by skipping one character
                    dp[i][j] = Math.max(
                        dp[i - 1][j],
                        dp[i][j - 1]
                    );
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {

        LongestCommonSubsequence obj = new LongestCommonSubsequence();

        String text1 = "abcde";
        String text2 = "ace";

        int result = obj.longestCommonSubsequence(text1, text2);

        System.out.println("Text 1: " + text1);
        System.out.println("Text 2: " + text2);
        System.out.println("Length of LCS: " + result);
    }
}