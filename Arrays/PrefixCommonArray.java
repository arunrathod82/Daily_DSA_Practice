/*
Problem: Find the Prefix Common Array of Two Arrays
Platform: LeetCode
Approach: Frequency Counting
Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.Arrays;

public class PrefixCommonArray {

    public static int[] findThePrefixCommonArray(int[] A, int[] B) {

        int n = A.length;

        int[] count = new int[n + 1];
        int[] ans = new int[n];

        int common = 0;

        for(int i = 0; i < n; i++) {

            if(++count[A[i]] == 2) {
                common++;
            }

            if(++count[B[i]] == 2) {
                common++;
            }

            ans[i] = common;
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] A = {1,3,2,4};
        int[] B = {3,1,2,4};

        int[] result = findThePrefixCommonArray(A, B);

        System.out.println("Prefix Common Array: " 
                            + Arrays.toString(result));
    }
}