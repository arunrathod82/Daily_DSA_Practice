// Problem: Count Subarrays With Product Divisible by K
// Platform: LeetCode
// Approach: Dynamic Programming on Remainders
// Time Complexity: O(n * k)
// Space Complexity: O(k)

public class ResultArray {

    public long[] resultArray(int[] nums, int k) {

        long[] ans = new long[k];

        // dp[i] = number of subarrays ending at previous position
        // whose product % k == i
        long[] dp = new long[k];

        for (int num : nums) {

            long[] newDp = new long[k];

            int numMod = num % k;

            // Start a new subarray with the current number
            newDp[numMod] = 1;

            // Extend all previous subarrays
            for (int i = 0; i < k; ++i) {

                int newMod = (int) (1L * i * numMod % k);

                newDp[newMod] += dp[i];
            }

            // Add current subarray counts to the answer
            for (int i = 0; i < k; ++i) {
                ans[i] += newDp[i];
            }

            // Move to the next position
            dp = newDp;
        }

        return ans;
    }

    public static void main(String[] args) {

        ResultArray obj = new ResultArray();

        int[] nums = {1, 2, 3, 4};
        int k = 2;

        long[] result = obj.resultArray(nums, k);

        for (long count : result) {
            System.out.print(count + " ");
        }
    }
}