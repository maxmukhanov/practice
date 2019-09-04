package com.max.practice.excercise;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


public class TreeTraversalTest {
  private TreeTraversal treeTraversal = new TreeTraversal();

  @Test
  public void inOrderIterative() {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(1);
    root.left.left = new TreeNode(0);
    root.left.right = new TreeNode(2);
    root.left.right.right = new TreeNode(3);
    root.right = new TreeNode(6);
    root.right.left = new TreeNode(5);
    root.right.right = new TreeNode(7);
    root.right.right.right = new TreeNode(8);

    List<Integer> actual = treeTraversal.inOrderIterative(root);

    assertThat(actual).containsExactly(0, 1, 2, 3, 4, 5, 6, 7, 8);
  }

  @Test
  public void inOrderRecursive() {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(1);
    root.left.left = new TreeNode(0);
    root.left.right = new TreeNode(2);
    root.left.right.right = new TreeNode(3);
    root.right = new TreeNode(6);
    root.right.left = new TreeNode(5);
    root.right.right = new TreeNode(7);
    root.right.right.right = new TreeNode(8);

    List<Integer> actual = treeTraversal.inOrderRecursive(root);

    assertThat(actual).containsExactly(0, 1, 2, 3, 4, 5, 6, 7, 8);
  }

  @Test
  public void postOrderIterative() {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(1);
    root.left.left = new TreeNode(0);
    root.left.right = new TreeNode(2);
    root.left.right.right = new TreeNode(3);
    root.right = new TreeNode(6);
    root.right.left = new TreeNode(5);
    root.right.right = new TreeNode(7);
    root.right.right.right = new TreeNode(8);

    List<Integer> actual = treeTraversal.postOrderTraversalIterative(root);
    assertThat(actual).containsExactly(0, 3, 2, 1, 5, 8, 7, 6, 4);
  }
}