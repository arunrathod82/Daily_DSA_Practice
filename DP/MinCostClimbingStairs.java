// Problem: Min Cost Climbing Stairs
// Platform: LeetCode
// Approach: Dynamic Programming
// Time Complexity: O(n)
// Space Complexity: O(1)

public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {

        // Cost of reaching the first two steps
        int prev2 = cost[0];
        int prev1 = cost[1];

        // Calculate minimum cost for each step
        for (int i = 2; i < cost.length; i++) {

            int curr = cost[i] + Math.min(prev1, prev2);

            // Move previous values forward
            prev2 = prev1;
            prev1 = curr;
        }

        // We can reach the top from either of the last two steps
        return Math.min(prev1, prev2);
    }

    public static void main(String[] args) {

        MinCostClimbingStairs obj = new MinCostClimbingStairs();

        int[] cost = {10, 15, 20};

        System.out.println(
            "Minimum cost: " + obj.minCostClimbingStairs(cost)
        );
    }
}