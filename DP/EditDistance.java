// Problem: Edit Distance
// Platform: LeetCode
// Approach: Dynamic Programming
// Time Complexity: O(m * n)
// Space Complexity: O(m * n)

public class EditDistance {

    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        // Convert word1 prefix to an empty string using deletions
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        // Convert an empty string to word2 prefix using insertions
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                // If characters match, no additional operation is needed
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {

                    // Insert, delete, or replace a character
                    dp[i][j] = 1 + Math.min(
                        dp[i][j - 1], // Insert
                        Math.min(
                            dp[i - 1][j],     // Delete
                            dp[i - 1][j - 1]  // Replace
                        )
                    );
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {

        EditDistance obj = new EditDistance();

        String word1 = "horse";
        String word2 = "ros";

        int result = obj.minDistance(word1, word2);

        System.out.println("Word 1: " + word1);
        System.out.println("Word 2: " + word2);
        System.out.println("Minimum Edit Distance: " + result);
    }
}