package com.test.Trees.easy;

import com.test.Trees.*;

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root) != -1;
    }

    // Helper method to calculate the height of the tree and check if it's balanced
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        // Create the binary tree for the example: [3, 9, 20, null, null, 15, 7]
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7))
        );

        BalancedBinaryTree tree = new BalancedBinaryTree();

        boolean result = tree.isBalanced(root);
        System.out.println(result); // Expected output: true
    }
}
