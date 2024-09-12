package com.test.Trees.easy;

import com.test.Trees.*;

public class InvertBinaryTree {

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = root.left, right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }

    public static void main(String[] args) {
        // Constructing the tree based on input [4, 2, 7, 1, 3, 6, 9]
        TreeNode root = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9)));

        System.out.println("Original Tree:");
        root.printTree(root);
        System.out.println();

        // Invert the tree
        TreeNode invertedRoot = invertTree(root);

        System.out.println("Inverted Tree:");
        root.printTree(invertedRoot);
    }
}
