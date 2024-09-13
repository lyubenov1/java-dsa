package com.test.Trees.medium;

import com.test.Trees.*;

public class CountGoodNodesInBinaryTree {

    // Number of good nodes
    static int count = 0;

    public static int goodNodes(TreeNode root) {
        if (root == null) return 0;

        dfs(root, root.val);
        return count;
    }

    private static void dfs(TreeNode node, int maxVal) {
        if (node == null) return;

        // If the current node's value is greater than or equal to the maximum value so far, it's a good node
        if (node.val >= maxVal) {
            count++;
        }

        // Continue DFS to the left and right subtrees, updating maxVal as the max of current node's value
        dfs(node.left, Math.max(maxVal, node.val));
        dfs(node.right, Math.max(maxVal, node.val));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(1, new TreeNode(3), null),
                new TreeNode(4, new TreeNode(1), new TreeNode(5))
        );

        int result = goodNodes(root);
        System.out.println(result);
    }

    /*  -- Another DFS solution
        public int goodNodes(TreeNode root) {
        return goodNodes(root, root.val);
    }

    public int goodNodes(TreeNode root, int maxVal) {
        if (root == null) return 0;
        int res = root.val >= maxVal ? 1 : 0;
        res += goodNodes(root.left, Math.max(maxVal, root.val));
        res += goodNodes(root.right, Math.max(maxVal, root.val));
        return res;
    }
     */
}