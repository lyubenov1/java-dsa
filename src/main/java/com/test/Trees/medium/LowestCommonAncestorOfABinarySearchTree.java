package com.test.Trees.medium;

import com.test.Trees.*;

public class LowestCommonAncestorOfABinarySearchTree {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            // If both p and q are smaller than root, move to the left subtree
            if (root.val > p.val && root.val > q.val)
                root = root.left;

                // If both p and q are larger than root, move to the right subtree
            else if (root.val < p.val && root.val < q.val)
                root = root.right;

                // Otherwise, the current root is the lowest common ancestor
            else
                return root;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6,
                new TreeNode(2, new TreeNode(0), new TreeNode(4, new TreeNode(3), new TreeNode(5))),
                new TreeNode(8, new TreeNode(7), new TreeNode(9))
        );

        TreeNode p = root.left; // Node with value 2
        TreeNode q = root.right; // Node with value 8

        TreeNode lca = lowestCommonAncestor(root, p, q);

        System.out.println("The LCA of nodes " + p.val + " and " + q.val + " is: " + lca.val); // Expected output: 6
    }
}
