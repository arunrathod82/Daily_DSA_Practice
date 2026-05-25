
/* 
Problem: Jump Game VII
Platform: LeetCode
Approach: DP + Sliding Window
Time Complexity: O(n)
Space Complexity: O(n)
*/

package Sliding_Window;

import java.util.*;

public class JumpGameVII {

    public static boolean canReach(String s, int minJump, int maxJump) {

        boolean[] dp = new boolean[s.length()];
        dp[0] = true;

        int reachable = 0;

        for(int i = 1; i < s.length(); i++) {

            if(i - minJump >= 0) {
                if(dp[i - minJump]) {
                    reachable++;
                }
            }

            if(i - maxJump - 1 >= 0) {
                if(dp[i - maxJump - 1]) {
                    reachable--;
                }
            }

            if(reachable > 0 && s.charAt(i) == '0') {
                dp[i] = true;
            }
        }

        return dp[s.length() - 1];
    }

    public static void main(String[] args) {

        String s = "011010";
        int minJump = 2;
        int maxJump = 3;

        boolean result = canReach(s, minJump, maxJump);

        System.out.println("Can Reach Last Index: " + result);
    }
}