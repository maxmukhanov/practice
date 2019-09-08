package com.max.practice.excercise;

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int left = height(root.left);
        int right = height(root.right);

        return Math.abs(left - right) <= 1;
    }

    private int height(TreeNode node) {
        if (node == null) return 0;

        return Math.max(height(node.left), height(node.right)) + 1;
    }
}
