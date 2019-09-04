package com.max.practice.excercise;

import com.max.practice.excercise.LowerestCommonAncestor;
import com.max.practice.excercise.TreeNode;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LowerestCommonAncestorTest {

  private LowerestCommonAncestor sut = new LowerestCommonAncestor();

  @Test
  public void shouldReturnRoot() {
    TreeNode root = new TreeNode(1);
    TreeNode left = new TreeNode(2);
    TreeNode right = new TreeNode(3);

    root.left = left;
    root.right = right;

    assertThat(sut.lowestCommonAncestor(root, left, right)).isSameAs(root);
  }

  @Test
  public void shouldReturnRootAsCommon() {
    TreeNode root = new TreeNode(1);
    TreeNode left = new TreeNode(2);
    TreeNode right = new TreeNode(3);

    root.left = left;
    root.right = right;

    assertThat(sut.lowestCommonAncestor(root, left, right)).isSameAs(root);
  }

  @Test
  public void shouldReturnCommon() {

    TreeNode root = new TreeNode(1);
    TreeNode left = new TreeNode(2);
    TreeNode right = new TreeNode(3);


    TreeNode p = new TreeNode(4);
    TreeNode q = new TreeNode(5);
    root.left = left;
    root.right = right;

    left.left = p;
    left.right = new TreeNode(6);
    left.right.left = q;



    assertThat(sut.lowestCommonAncestor(root, p, q)).isSameAs(left);
  }
}