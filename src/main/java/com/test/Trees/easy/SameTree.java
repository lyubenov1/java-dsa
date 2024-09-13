package com.test.Trees.easy;

import com.test.Trees.*;

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Base case: both nodes are null (same tree structure at this point)
        if (p == null && q == null) return true;

        // If one is null and the other isn't, the trees are not the same
        else if (p == null || q == null) return false;

        // If both nodes have the same value, check the subtrees recursively
        if (p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

        // If the values are not the same, the trees aren't the same
        return false;
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3)
        );

        TreeNode q = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3)
        );

        SameTree treeChecker = new SameTree();
        boolean result = treeChecker.isSameTree(p, q);

        System.out.println(result); // Expected output: true
    }
}
