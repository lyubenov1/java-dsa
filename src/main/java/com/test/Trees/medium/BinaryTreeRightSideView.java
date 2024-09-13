package com.test.Trees.medium;

import com.test.Trees.*;

import java.util.*;

public class BinaryTreeRightSideView {

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();  // Number of nodes at the current level

            while (size-- > 0) {
                TreeNode cur = queue.poll();  // Get the next node in the level

                // Add the last node of the current level (rightmost node) to the result
                if (size == 0) {
                    res.add(cur.val);
                }

                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(5)),
                new TreeNode(3, null, new TreeNode(4))
        );

        List<Integer> result = rightSideView(root);
        System.out.println(result);  // Expected output: [1, 3, 4]
    }
}