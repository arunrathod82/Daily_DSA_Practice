/*
Problem: Same Tree
Platform: LeetCode
Approach: Recursive DFS
Time Complexity: O(n)
Space Complexity: O(h)

n = number of nodes
h = height of tree
*/

import java.util.*;

public class SameTree {

    // Definition for binary tree node
    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(
                int val,
                TreeNode left,
                TreeNode right) {

            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static boolean isSameTree(
            TreeNode p,
            TreeNode q) {

        // Both null
        if(p == null && q == null) {
            return true;
        }

        // One null
        if(p == null || q == null) {
            return false;
        }

        // Check value + left + right
        return (p.val == q.val)
                &&
                isSameTree(p.left, q.left)
                &&
                isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {

        /*
              Tree 1           Tree 2

                 1                1
                / \              / \
               2   3            2   3
        */

        TreeNode p =
                new TreeNode(
                        1,
                        new TreeNode(2),
                        new TreeNode(3)
                );

        TreeNode q =
                new TreeNode(
                        1,
                        new TreeNode(2),
                        new TreeNode(3)
                );

        boolean result =
                isSameTree(p, q);

        System.out.println(
                "Are Trees Same: "
                + result
        );
    }
}