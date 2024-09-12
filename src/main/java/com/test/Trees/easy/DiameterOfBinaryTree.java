package com.test.Trees.easy;

import com.test.Trees.*;

public class DiameterOfBinaryTree {
    static int max = 0; // Static variable to keep track of the maximum diameter

    private static int diameter(TreeNode root) {
        if (root == null) return 0; // Base case: if the node is null, its depth is 0

        int left = diameter(root.left); // Recursively calculate the diameter of the left subtree
        int right = diameter(root.right); // Recursively calculate the diameter of the right subtree

        // Update the maximum diameter found so far. The diameter through the current node
        // is the sum of the depths of its left and right subtrees.
        max = Math.max(max, left + right);

        // Return the depth of the current node. The depth is the maximum of the depths of
        // the left and right subtrees plus one for the current node.
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        // Construct a sample binary tree
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3));

        diameter(root); // Compute the diameter of the tree

        // Print the maximum diameter found
        System.out.println(max);
    }
}
