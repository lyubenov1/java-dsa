package com.test.Trees.easy;

import com.test.Trees.*;

public class SubtreeOfAnotherTree {

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // Base case: If the main tree is null, there's no subtree
        if (root == null) return false;

        // Check if the current node is the same as subRoot
        if (isSame(root, subRoot)) return true;

        // Recursively check left and right subtrees
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private static boolean isSame(TreeNode root, TreeNode subRoot) {
        // If both nodes are null, the trees match at this point
        if (root == null && subRoot == null) return true;

        // If one is null and the other isn't, trees don't match
        if (root == null || subRoot == null) return false;

        // If the values don't match, the trees aren't the same
        if (root.val != subRoot.val) return false;

        // Recursively check left and right subtrees for equality
        return isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(4, new TreeNode(1), new TreeNode(2)),
                new TreeNode(5)
        );

        TreeNode subRoot = new TreeNode(4,
                new TreeNode(1),
                new TreeNode(2)
        );

        boolean result = isSubtree(root, subRoot);
        System.out.println(result);
    }
}
