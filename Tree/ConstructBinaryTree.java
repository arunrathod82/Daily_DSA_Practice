/*
Problem: Construct Binary Tree from Preorder and Inorder Traversal
Platform: LeetCode
Approach: Recursive DFS using Stop Boundary
Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.*;

public class ConstructBinaryTree {

    // TreeNode definition
    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val,
                 TreeNode left,
                 TreeNode right) {

            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int i = 0;
    private int p = 0;

    public TreeNode buildTree(
            int[] preorder,
            int[] inorder) {

        return build(preorder,
                     inorder,
                     Integer.MAX_VALUE);
    }

    private TreeNode build(
            int[] preorder,
            int[] inorder,
            int stop) {

        if(p >= preorder.length) {
            return null;
        }

        if(inorder[i] == stop) {
            i++;
            return null;
        }

        TreeNode node =
                new TreeNode(preorder[p++]);

        node.left =
                build(preorder,
                      inorder,
                      node.val);

        node.right =
                build(preorder,
                      inorder,
                      stop);

        return node;
    }

    // Inorder print for checking
    public static void printInorder(TreeNode root) {

        if(root == null) {
            return;
        }

        printInorder(root.left);

        System.out.print(root.val + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) {

        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        ConstructBinaryTree solution =
                new ConstructBinaryTree();

        TreeNode root =
                solution.buildTree(
                        preorder,
                        inorder
                );

        System.out.print(
                "Constructed Tree Inorder: "
        );

        printInorder(root);
    }
}