/*
Problem: Best Time to Buy and Sell Stock
Platform: LeetCode
Approach: Track minimum buying price and maximum profit
Time Complexity: O(n)
Space Complexity: O(1)
*/

import java.util.*;

public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {

        int MP = 0;
        int buy = prices[0];

        for(int i = 1; i < prices.length; i++) {

            if(prices[i] > buy) {
                MP = Math.max(MP, prices[i] - buy);
            }

            buy = Math.min(buy, prices[i]);
        }

        return MP;
    }

    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};

        int result = maxProfit(prices);

        System.out.println("Maximum Profit: " + result);
    }
}