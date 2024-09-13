package com.test.Trees.medium;

import com.test.Trees.*;

public class ValidateBinarySearchTree {

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;

        // If the node's value violates the min or max constraint, it's not a valid BST
        if (root.val >= maxVal || root.val <= minVal) return false;

        // Recursively check the left and right subtrees with updated min/max values
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                new TreeNode(1),
                new TreeNode(4, new TreeNode(3), new TreeNode(6))
        );

        boolean result = isValidBST(root);
        System.out.println(result);
    }
}