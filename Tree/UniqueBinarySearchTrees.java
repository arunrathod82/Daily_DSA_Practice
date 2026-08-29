import java.util.*;

class Solution {

    // Problem: Unique Binary Search Trees
    // Platform: LeetCode
    // Approach: Dynamic Programming
    // Time Complexity: O(n^2)
    // Space Complexity: O(n)

    public int numTrees(int n) {

        // unique[i] = number of unique BSTs
        // that can be formed using i nodes
        int[] unique = new int[n + 1];

        // Base cases
        unique[0] = 1;
        unique[1] = 1;

        // Calculate answer for every number of nodes
        for(int i = 2; i <= n; i++){

            // Try every node as the root
            for(int j = 0; j < i; j++){

                // Left subtree has j nodes
                // Right subtree has i-j-1 nodes
                unique[i] +=
                        unique[j] *
                        unique[i - j - 1];
            }
        }

        return unique[n];
    }

    // Main function for local testing
    public static void main(String[] args){

        Solution solution = new Solution();

        int n = 3;

        int result = solution.numTrees(n);

        System.out.println("Number of unique BSTs: " + result);
    }
}