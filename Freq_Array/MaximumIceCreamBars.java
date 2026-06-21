/*
Problem: Maximum Ice Cream Bars
Platform: LeetCode
Approach: Counting Sort / Frequency Array
Time Complexity: O(n + maxCost)
Space Complexity: O(maxCost)
*/

import java.util.*;

public class MaximumIceCreamBars {

    public static int maxIceCream(
            int[] costs,
            int coins) {

        // Frequency array
        int[] freq = new int[100001];

        // Count frequencies
        for(int cost : costs) {
            freq[cost]++;
        }

        int count = 0;

        // Buy cheapest ice creams first
        for(int price = 1;
            price <= 100000;
            price++) {

            while(freq[price] > 0 &&
                  coins >= price) {

                coins -= price;

                count++;

                freq[price]--;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[] costs = {1,3,2,4,1};

        int coins = 7;

        int result =
                maxIceCream(costs, coins);

        System.out.println(
                "Maximum Ice Cream Bars: "
                + result
        );
    }
}