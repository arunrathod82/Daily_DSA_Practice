/*
Problem: Jump Game V
Platform: LeetCode
Approach: DFS + Memoization
Time Complexity: O(n * d)
Space Complexity: O(n)
*/

import java.util.*;

public class JumpGameV {

    static int[] dp;
    static int[] arr;
    static int d;
    static int n;

    public static int maxJumps(int[] arrInput, int distance) {

        arr = arrInput;
        d = distance;
        n = arr.length;

        dp = new int[n];

        int ans = 1;

        for(int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(i));
        }

        return ans;
    }

    public static int dfs(int i) {

        if(dp[i] != 0) {
            return dp[i];
        }

        int ans = 1;

        // Right side
        for(int next = i + 1;
            next <= Math.min(i + d, n - 1);
            next++) {

            if(arr[next] >= arr[i]) {
                break;
            }

            ans = Math.max(ans, 1 + dfs(next));
        }

        // Left side
        for(int next = i - 1;
            next >= Math.max(i - d, 0);
            next--) {

            if(arr[next] >= arr[i]) {
                break;
            }

            ans = Math.max(ans, 1 + dfs(next));
        }

        dp[i] = ans;

        return ans;
    }

    public static void main(String[] args) {

        int[] arr = {6,4,14,6,8,13,9,7,10,6,12};
        int d = 2;

        int result = maxJumps(arr, d);

        System.out.println("Maximum Jumps: " + result);
    }
}