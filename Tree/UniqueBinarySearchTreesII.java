import java.util.*;

// Problem: Unique Binary Search Trees II
// Platform: LeetCode
// Approach: Recursion
// Time Complexity: O(Cn * n), where Cn is the nth Catalan number
// Space Complexity: O(Cn * n)

public class UniqueBinarySearchTreesII {

    public List<TreeNode> generateTrees(int n) {

        if (n == 0) {
            return new ArrayList<>();
        }

        return build(1, n);
    }

    // Generates all BSTs using values from start to end
    public List<TreeNode> build(int start, int end) {

        List<TreeNode> result = new ArrayList<>();

        // No values in this range.
        // Add null so that parent can have an empty subtree.
        if (start > end) {
            result.add(null);
            return result;
        }

        // Try every value as the root
        for (int i = start; i <= end; i++) {

            // Generate all possible left subtrees
            List<TreeNode> leftTree = build(start, i - 1);

            // Generate all possible right subtrees
            List<TreeNode> rightTree = build(i + 1, end);

            // Combine every left subtree with every right subtree
            for (TreeNode left : leftTree) {

                for (TreeNode right : rightTree) {

                    TreeNode root = new TreeNode(i);

                    root.left = left;
                    root.right = right;

                    result.add(root);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        UniqueBinarySearchTreesII obj = new UniqueBinarySearchTreesII();

        int n = 3;

        List<TreeNode> trees = obj.generateTrees(n);

        System.out.println("Number of unique BSTs: " + trees.size());
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