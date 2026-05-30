/*
Problem: Binary Tree Inorder Traversal
Platform: LeetCode
Approach: Recursive DFS (Inorder)
Time Complexity: O(n)
Space Complexity: O(h)

n = number of nodes
h = height of tree
*/

import java.util.*;

public class BinaryTreeInorderTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {

        if(root == null) {
            return result;
        }

        inorderTraversal(root.left);

        result.add(root.val);

        inorderTraversal(root.right);

        return result;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        BinaryTreeInorderTraversal solution =
                new BinaryTreeInorderTraversal();

        List<Integer> result =
                solution.inorderTraversal(root);

        System.out.println("Inorder Traversal: " + result);
    }
}