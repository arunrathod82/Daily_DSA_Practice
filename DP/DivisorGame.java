// Problem: Divisor Game
// Platform: LeetCode
// Approach: Dynamic Programming
// Time Complexity: O(n^2)
// Space Complexity: O(n)

public class DivisorGame {

    public boolean divisorGame(int n) {

        // dp[i] = true if the current player can win
        // when the remaining number is i
        boolean[] dp = new boolean[n + 1];

        // Base case: Alice loses when n = 1
        dp[1] = false;

        for (int i = 2; i <= n; i++) {

            // Try every possible divisor x
            for (int x = 1; x < i; x++) {

                // x must divide i, and the opponent must lose
                // after i is reduced by x
                if (i % x == 0 && !dp[i - x]) {

                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {

        DivisorGame obj = new DivisorGame();

        int n = 4;

        System.out.println("Alice wins: " + obj.divisorGame(n));
    }
}