package com.test.Trees.medium;

import com.test.Trees.*;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // Perform BFS until all nodes are processed
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();  // List to store values of the current level
            int cnt = queue.size();  // Number of nodes at the current level

            for (int i = 0; i < cnt; i++) {
                TreeNode node = queue.poll();  // Get the next node from the queue
                level.add(node.val);  // Add the node's value to the current level

                // Add the left child to the queue if it exists
                if (node.left != null) {
                    queue.add(node.left);
                }

                // Add the right child to the queue if it exists
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            res.add(level);  // Add the current level's values to the result
        }

        return res;
    }

    public static void main(String[] args) {
        // Create a binary tree for the example
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7))
        );

        List<List<Integer>> result = levelOrder(root);
        System.out.println(result);  // Expected output: [[3], [9, 20], [15, 7]]
    }
}