/*
Problem: Minimum Cost of Buying Candies With Discount
Platform: LeetCode
Approach: Greedy + Sorting
Time Complexity: O(n log n)
Space Complexity: O(1)
*/

import java.util.*;

public class MinimumCostOfCandies {

    public static int minimumCost(int[] cost) {

        Arrays.sort(cost);

        int total = 0;

        // Buy 2 expensive candies, get 1 free
        for(int i = cost.length - 1; i >= 0; i -= 3) {

            total += cost[i];

            if(i - 1 >= 0) {
                total += cost[i - 1];
            }
        }

        return total;
    }

    public static void main(String[] args) {

        int[] cost = {6, 5, 7, 9, 2, 2};

        int result = minimumCost(cost);

        System.out.println("Minimum Cost: " + result);
    }
}