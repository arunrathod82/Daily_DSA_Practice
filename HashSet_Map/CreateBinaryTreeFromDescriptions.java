/*
Problem: Create Binary Tree From Descriptions
Platform: LeetCode
Approach: HashMap + HashSet
Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.*;

public class CreateBinaryTreeFromDescriptions {

    // TreeNode Definition
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

    public static TreeNode createBinaryTree(
            int[][] descriptions) {

        HashMap<Integer, TreeNode> nodes =
                new HashMap<>();

        HashSet<Integer> childSet =
                new HashSet<>();

        for(int i = 0;
            i < descriptions.length;
            i++) {

            int parent = descriptions[i][0];
            int child = descriptions[i][1];
            int isLeft = descriptions[i][2];

            // Create parent if absent
            if(!nodes.containsKey(parent)) {

                nodes.put(
                        parent,
                        new TreeNode(parent)
                );
            }

            // Create child if absent
            if(!nodes.containsKey(child)) {

                nodes.put(
                        child,
                        new TreeNode(child)
                );
            }

            TreeNode parentNode =
                    nodes.get(parent);

            TreeNode childNode =
                    nodes.get(child);

            // Connect nodes
            if(isLeft == 1) {
                parentNode.left = childNode;
            }

            else {
                parentNode.right = childNode;
            }

            // Track child nodes
            childSet.add(child);
        }

        // Root is node
        // that never appears as child
        for(int value : nodes.keySet()) {

            if(!childSet.contains(value)) {

                return nodes.get(value);
            }
        }

        return null;
    }

    // Inorder traversal
    public static void inorder(TreeNode root) {

        if(root == null) {
            return;
        }

        inorder(root.left);

        System.out.print(root.val + " ");

        inorder(root.right);
    }

    public static void main(String[] args) {

        int[][] descriptions = {
                {20,15,1},
                {20,17,0},
                {15,10,1}
        };

        TreeNode root =
                createBinaryTree(descriptions);

        System.out.print(
                "Inorder Traversal: "
        );

        inorder(root);
    }
}