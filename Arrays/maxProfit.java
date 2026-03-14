/*
Problem: Best Time to Buy and Sell Stock
Approach: Track minimum buying price and maximum profit
Time Complexity: O(n)
Space Complexity: O(1)
*/

import java.util.*;

public class maxProfit {

    public static int MaxProfit(int[] prices) {

        int MP = 0;
        int buy = prices[0];

        for(int i = 1; i < prices.length; i++) {

            if(prices[i] > buy){
                MP = Math.max(MP, prices[i] - buy);
            }

            buy = Math.min(buy, prices[i]);
        }

        return MP;
    }

    public static void main(String[] args) {

        int[] prices = {7,1,5,3,6,4};

        int result = MaxProfit(prices);

        System.out.println("Maximum Profit: " + result);
    }
}