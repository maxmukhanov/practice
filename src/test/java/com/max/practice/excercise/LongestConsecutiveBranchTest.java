package com.max.practice.excercise;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class LongestConsecutiveBranchTest {
    private LongestConsecutiveBranch sut = new LongestConsecutiveBranch();

    @Test
    public void shouldReturn3ForLongestConsecutiveBranch() {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(7);
        assertThat(sut.longestConsecutiveBranch(root)).isEqualTo(3);
    }

    @Test
    public void shouldReturn4ForLongestConsecutiveBranchNotFromRoot() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(2);
        root.right.left.right = new TreeNode(3);
        root.right.left.right.right = new TreeNode(4);
        assertThat(sut.longestConsecutiveBranch(root)).isEqualTo(4);
    }
}