package com.max.practice.excercise;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class BSTtoGSTTest {

  private BSTtoGST bsTtoGST = new BSTtoGST();

  @Test
  public void bstToGst() {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(1);
    root.left.left = new TreeNode(0);
    root.left.right = new TreeNode(2);
    root.left.right.right = new TreeNode(3);
    root.right = new TreeNode(6);
    root.right.left = new TreeNode(5);
    root.right.right = new TreeNode(7);
    root.right.right.right = new TreeNode(8);

    List<Integer> actual = new TreeTraversalImpl().inOrderIterative(bsTtoGST.bstToGst(root));

    assertThat(actual).containsExactly(36, 36, 35, 33, 30, 26, 21, 15, 8);
  }
}