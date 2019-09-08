package com.max.practice.excercise;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class BalancedBinaryTreeTest {
    private BalancedBinaryTree sut = new BalancedBinaryTree();

    @Test
    public void shouldReturnTrueWhenBalanced() {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(7);

        assertThat(sut.isBalanced(root)).isTrue();
    }

    @Test
    public void shouldReturnFalseWhenBalanced() {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(1);

        assertThat(sut.isBalanced(root)).isFalse();
    }
}