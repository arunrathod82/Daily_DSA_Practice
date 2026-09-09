import java.util.*;

// Problem: Validate Binary Search Tree
// Platform: LeetCode
// Approach: Recursion + Range Validation
// Time Complexity: O(n)
// Space Complexity: O(h)

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValid(TreeNode root, long min, long max) {

        // Empty tree is a valid BST
        if (root == null) {
            return true;
        }

        // Current node must be strictly between min and max
        if (root.val <= min || root.val >= max) {
            return false;
        }

        // Left subtree must contain smaller values
        // Right subtree must contain larger values
        return isValid(root.left, min, root.val)
                && isValid(root.right, root.val, max);
    }

    public static void main(String[] args) {

        ValidateBinarySearchTree obj = new ValidateBinarySearchTree();

        /*
                 2
                / \
               1   3
        */

        TreeNode root = new TreeNode(
                2,
                new TreeNode(1),
                new TreeNode(3)
        );

        System.out.println("Is Valid BST: " + obj.isValidBST(root));
    }

    // Definition for a binary tree node
    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}