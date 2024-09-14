package com.test.Trees.medium;

import com.test.Trees.*;

import java.util.*;

public class KthSmallestElementInABst {

    public static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        int count = 0;

        while (current != null || !stack.isEmpty()) {
            // Traverse the left subtree
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Process the current node
            current = stack.pop();
            count++;

            if (count == k) {
                return current.val; // Return the kth smallest value
            }

            // Traverse the right subtree
            current = current.right;
        }

        return -1; // Return -1 if k is invalid (though this case shouldn't happen)
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(1, null, new TreeNode(2)),
                new TreeNode(4));
        int k = 1;
        int result = kthSmallest(root, k);
        System.out.println(result);
    }
}
