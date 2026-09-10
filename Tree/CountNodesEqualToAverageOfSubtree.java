// Problem: Count Nodes Equal to Average of Subtree
// Platform: LeetCode
// Approach: Postorder DFS + Subtree Sum and Count
// Time Complexity: O(n)
// Space Complexity: O(h)

public class CountNodesEqualToAverageOfSubtree {

    int count = 0;

    // Returns {sum of subtree, number of nodes in subtree}
    Pair countAverage(TreeNode root) {

        if (root == null) {
            return new Pair(0, 0);
        }

        // Get sum and count from left subtree
        Pair left = countAverage(root.left);

        // Get sum and count from right subtree
        Pair right = countAverage(root.right);

        // Calculate sum of current subtree
        int nodeSum = root.val + left.sum + right.sum;

        // Calculate number of nodes in current subtree
        int nodeCount = 1 + left.count + right.count;

        // Check if current node equals subtree average
        if (root.val == nodeSum / nodeCount) {
            count++;
        }

        return new Pair(nodeSum, nodeCount);
    }

    public int averageOfSubtree(TreeNode root) {
        countAverage(root);
        return count;
    }

    public static void main(String[] args) {

        CountNodesEqualToAverageOfSubtree obj =
                new CountNodesEqualToAverageOfSubtree();

        /*
                 4
                / \
               8   5
              / \   \
             0   1   6
        */

        TreeNode root = new TreeNode(
                4,
                new TreeNode(
                        8,
                        new TreeNode(0),
                        new TreeNode(1)
                ),
                new TreeNode(
                        5,
                        null,
                        new TreeNode(6)
                )
        );

        System.out.println(
                "Nodes equal to subtree average: "
                        + obj.averageOfSubtree(root)
        );
    }

    // Custom Pair class
    static class Pair {

        int sum;
        int count;

        Pair(int sum, int count) {
            this.sum = sum;
            this.count = count;
        }
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