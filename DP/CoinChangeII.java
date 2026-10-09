import java.util.*;

// Problem: Coin Change II
// Platform: LeetCode
// Approach: Dynamic Programming
// Time Complexity: O(amount * n)
// Space Complexity: O(amount)

public class CoinChangeII {

    public int change(int amount, int[] coins) {

        int[] dp = new int[amount + 1];

        // One way to make amount 0: choose no coins
        dp[0] = 1;

        // Process each coin to avoid counting permutations
        for (int coin : coins) {

            // Update amounts using the current coin
            for (int i = coin; i <= amount; i++) {

                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {

        CoinChangeII obj = new CoinChangeII();

        int amount = 5;
        int[] coins = {1, 2, 5};

        System.out.println(
            "Number of combinations: " + obj.change(amount, coins)
        );
    }
}