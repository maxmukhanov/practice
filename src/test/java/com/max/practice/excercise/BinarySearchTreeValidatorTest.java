package com.max.practice.excercise;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class BinarySearchTreeValidatorTest {
    private BinarySearchTreeValidator sut = new BinarySearchTreeValidator();

    @Test
    public void shouldReturnTrueWhenValidBST() {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);

        assertThat(sut.isValidBST(root)).isTrue();

    }

    @Test
    public void shouldReturnFalseWhenInvalidBST() {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(10);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);

        assertThat(sut.isValidBST(root)).isFalse();
    }

    @Test
    public void shouldReturnFalseWhenSameValues() {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(6);
        root.right = new TreeNode(6);

        assertThat(sut.isValidBST(root)).isFalse();
    }
}