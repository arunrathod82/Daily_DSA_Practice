// Problem: N-th Tribonacci Number
// Platform: LeetCode
// Approach: Dynamic Programming
// Time Complexity: O(n)
// Space Complexity: O(1)

public class NthTribonacciNumber {

    public int tribonacci(int n) {

        int prev3 = 0; // T(n-3)
        int prev2 = 1; // T(n-2)
        int prev1 = 1; // T(n-1)

        // Base cases
        if (n == 0) {
            return prev3;
        }

        if (n == 1 || n == 2) {
            return prev2;
        }

        // Calculate Tribonacci numbers from T3 to Tn
        for (int i = 3; i <= n; i++) {

            int curr = prev1 + prev2 + prev3;

            // Shift values for the next iteration
            prev3 = prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public static void main(String[] args) {

        NthTribonacciNumber obj = new NthTribonacciNumber();

        int n = 25;

        System.out.println(
            "Tribonacci number: " + obj.tribonacci(n)
        );
    }
}