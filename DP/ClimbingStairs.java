// Problem: Climbing Stairs
// Platform: LeetCode
// Approach: Dynamic Programming
// Time Complexity: O(n)
// Space Complexity: O(1)

public class ClimbingStairs {

    public int climbStairs(int n) {

        // For 1 stair -> 1 way
        // For 2 stairs -> 2 ways
        if (n <= 2) {
            return n;
        }

        // Number of ways to reach the previous two steps
        int prev2 = 1;
        int prev1 = 2;

        // Calculate ways from step 3 to n
        for (int i = 3; i <= n; i++) {

            int curr = prev1 + prev2;

            // Move the previous values forward
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public static void main(String[] args) {

        ClimbingStairs obj = new ClimbingStairs();

        int n = 5;

        System.out.println("Number of ways: " + obj.climbStairs(n));
    }
}