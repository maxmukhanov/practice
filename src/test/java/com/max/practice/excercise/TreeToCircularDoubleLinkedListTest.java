package com.max.practice.excercise;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class TreeToCircularDoubleLinkedListTest {

    TreeToCircularDoubleLinkedList sut = new TreeToCircularDoubleLinkedList();

    @Test
    public void shouldReturnDListHead() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        assertThat(sut.toDoubleLinkedList(root).toList()).containsExactly(4, 2, 5, 1, 6, 3, 7);
    }
}