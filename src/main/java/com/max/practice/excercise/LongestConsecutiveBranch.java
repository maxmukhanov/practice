package com.max.practice.excercise;

public class LongestConsecutiveBranch {

    public int longestConsecutiveBranch(TreeNode root) {
        if (root == null) return 0;

        return longest(root, 0)  + 1;
    }

    private int longest(TreeNode node, int len) {
        int left = len;
        int right = len;
        if (node.left != null) {
            left = node.left.val == node.val + 1 ? longest(node.left, len + 1) : longest(node.left, 0);
        }

        if (node.right != null) {
            right = node.right.val == node.val + 1 ? longest(node.right, len + 1) : longest(node.right, 0);
        }

        return Math.max(left, right);
    }
}
