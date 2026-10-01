// Problem: Decode Ways
// Platform: LeetCode
// Approach: Dynamic Programming
// Time Complexity: O(n)
// Space Complexity: O(n)

public class DecodeWays {

    public int numDecodings(String s) {

        int n = s.length();

        int[] dp = new int[n + 1];

        // Empty string has one valid way
        dp[0] = 1;

        // A string starting with 0 cannot be decoded
        if (s.charAt(0) != '0') {
            dp[1] = 1;
        }

        for (int i = 2; i <= n; i++) {

            // One-digit decoding: 1 to 9
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }

            // Two-digit decoding: 10 to 26
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));

            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {

        DecodeWays obj = new DecodeWays();

        String s = "226";

        System.out.println(
            "Number of decoding ways: " + obj.numDecodings(s)
        );
    }
}