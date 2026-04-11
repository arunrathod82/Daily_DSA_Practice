/*
Problem: Richest Customer Wealth
Platform: LeetCode
Approach: Traverse each customer's accounts and track maximum wealth
Time Complexity: O(m × n)
Space Complexity: O(1)
*/

import java.util.*;

public class RichestCustomerWealth {

    public static int maximumWealth(int[][] accounts) {

        int maxWealth = 0;

        for(int i = 0; i < accounts.length; i++) {

            int wealth = 0;

            for(int j = 0; j < accounts[i].length; j++) {
                wealth += accounts[i][j];
            }

            maxWealth = Math.max(wealth, maxWealth);
        }

        return maxWealth;
    }

    public static void main(String[] args) {

        int[][] accounts = {
            {1, 2, 3},
            {3, 2, 1},
            {4, 1, 2}
        };

        int result = maximumWealth(accounts);

        System.out.println("Maximum Wealth: " + result);
    }
}