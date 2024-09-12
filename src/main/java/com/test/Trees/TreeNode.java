package com.test.Trees;

import java.util.*;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) { this.val = val; }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    // Method to print tree level by level (Breadth-First Search)
    public void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        StringBuilder result = new StringBuilder("[");
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current != null) {
                result.append(current.val).append(", ");
                queue.offer(current.left);
                queue.offer(current.right);
            }
        }

        // Remove the last comma and space
        result.setLength(result.length() - 2);
        result.append("]");

        System.out.println(result);
    }

}