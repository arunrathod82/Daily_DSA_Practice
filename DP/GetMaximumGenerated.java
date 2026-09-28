// Problem: Get Maximum in Generated Array
// Platform: LeetCode
// Approach: Dynamic Programming
// Time Complexity: O(n)
// Space Complexity: O(n)

public class GetMaximumGenerated {

    public int getMaximumGenerated(int n) {

        // Handle the base case
        if (n == 0) {
            return 0;
        }

        int[] arr = new int[n + 1];

        arr[0] = 0;
        arr[1] = 1;

        int max = 1;

        // Generate array elements from index 2 to n
        for (int i = 2; i <= n; i++) {

            if (i % 2 == 0) {

                // Even index: arr[i] = arr[i / 2]
                arr[i] = arr[i / 2];

            } else {

                // Odd index: arr[i] = arr[i / 2] + arr[i / 2 + 1]
                arr[i] = arr[i / 2] + arr[i / 2 + 1];
            }

            // Update the maximum value
            max = Math.max(max, arr[i]);
        }

        return max;
    }

    public static void main(String[] args) {

        GetMaximumGenerated obj = new GetMaximumGenerated();

        int n = 7;

        System.out.println(
            "Maximum generated value: " + obj.getMaximumGenerated(n)
        );
    }
}