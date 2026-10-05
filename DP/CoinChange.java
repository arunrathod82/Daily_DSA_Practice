// Problem: Coin Change
// Platform: LeetCode
// Approach: Dynamic Programming
// Time Complexity: O(amount * n)
// Space Complexity: O(amount)

import java.util.*;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];

        // Initially, mark all amounts as impossible
        Arrays.fill(dp, Integer.MAX_VALUE);

        // 0 coins are needed to make amount 0
        dp[0] = 0;

        // Calculate the minimum coins for every amount
        for (int i = 0; i <= amount; i++) {

            for (int coin : coins) {

                // Check if the coin can be used
                // and the previous amount is reachable
                if (coin <= i && dp[i - coin] != Integer.MAX_VALUE) {

                    dp[i] = Math.min(
                        dp[i],
                        dp[i - coin] + 1
                    );
                }
            }
        }

        // If amount cannot be formed
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }

        return dp[amount];
    }

    public static void main(String[] args) {

        CoinChange obj = new CoinChange();

        int[] coins = {1, 2, 5};
        int amount = 11;

        System.out.println(
            "Minimum coins: " + obj.coinChange(coins, amount)
        );
    }
}